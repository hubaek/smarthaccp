package com.ppm.mes.domain.st.st000;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.item.item000.ItemMaster;
import com.ppm.mes.domain.item.item000.ItemMasterService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.pc.pc310.PurchaseDetail;
import com.ppm.mes.domain.pc.pc410.PurchaseReturnDetail;
import com.ppm.mes.domain.qc.qc300.QcResultMaster;
import com.ppm.mes.domain.qc.qc300.QcResultMasterService;
import com.ppm.mes.domain.qc.qc450.QcResultBadDetail;
import com.ppm.mes.domain.st.st050.StockDetailService;
import com.ppm.mes.domain.st.st100.StockIn;
import com.ppm.mes.domain.st.st100.StockInService;
import com.ppm.mes.domain.st.st200.StockOut;
import com.ppm.mes.domain.st.st310.ModifyDetail;
import com.ppm.mes.domain.st.st410.MoveInoutDetail;
import com.ppm.mes.domain.st.st500.StockBox;
import com.ppm.mes.domain.st.st600.StockBox2;
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterService;
import com.ppm.mes.domain.wo.wo150.WorkOrderOutgoingItem;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncoming;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class StockMasterService extends BaseService<StockMaster, StockMaster.StockMasterId> {
   
	private StockMasterRepository repository;

    @Inject private ItemMasterService itemMasterService;
    @Inject private WorkKeyManagementService workKeyManagementService;
    @Inject private StockDetailService stockDetailService;
    @Inject private StockInService stockInService;
    @Inject private QcResultMasterService inspResultMasterService;
    @Inject private WorkOrderMasterService workOrderMasterService;
    @Inject private StockMasterMapper stockMasterMapper;
    
    @Inject
    public StockMasterService(StockMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }
    //2020-11-10 ykj POP-작업종료 
    public void updateWlotNo(RequestParams<StockMasterVO> vo){
    	stockMasterMapper.updateWlotNo(vo);
    }
    //2020-11-10 ykj POP-작업종료 
    public void updateEndWorkPrdUseYn(RequestParams<StockMasterVO> vo) {
    	stockMasterMapper.updateEndWorkPrdUseYn(vo);
    }
    
    //구매-구매(입고)
    @Transactional
    public PurchaseDetail purchaseItem(PurchaseDetail item,String custCd,String whCd,String slipDt) {

    	String inoutType = "10";	//입고
    	
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(item.getCompany());
    	stock.setItemCd(item.getItemCd());
    	stock.setWhCd(whCd);
    	stock.setLotNo(item.getLotNo());
    	
        stock =  inProcess(stock, item.getItemQty().multiply(item.getPdTrans()),inoutType,"Y", slipDt);
        
    	//입고후, 로뜨 /바코드 /창고 리턴
    	item.setLotNo(stock.getLotNo());    	
    	//입고데이터 생성
    	createIn(stock,item.getSlipCd(),item.getSlipSeq(), custCd , item.getUnitAmt());
    	
    	return item;
    }

    //구매-구매(반품)
    @Transactional
    public void purchaseReturnItem(PurchaseReturnDetail item) {
    	
    	String inoutType = "15";	//입고취소
    	
    	StockMaster m = useProcess(item.getStockCd(),null, item.getItemQty().multiply(item.getPdTrans()), inoutType,"N",null, null);
    	
    	//검사요청 데이터 수정
    	update(qQcResultMaster)
	    	.set(qQcResultMaster.inQty, m.getStockQty())
	    	.set(qQcResultMaster.itemQty, m.getStockQty())
	    .where(qQcResultMaster.stockCd.eq(item.getStockCd())).execute();    	
    	
    }
    
    //MES_POP > 생산완료 공정, 실적수정 생산품 공정입고 :: TEST
    @Transactional
    public void saveWorkingOrderIncoming(WorkOrderIncoming item) {
    	String inoutTypeDetail = "10";    	
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(item.getCompany());
    	stock.setItemCd(item.getItemCd());    	
    	stock.setStockCd(item.getStockCd());
        inProcess(stock,  item.getItemQty(),inoutTypeDetail,"N", null);
    }
    
    //WO - 자재출고 (MES/POP)
    @Transactional
    public WorkOrderOutgoingItem workOutgoinItem(WorkOrderOutgoingItem item) {    	

    	String inoutType = "50";		//불출
    	
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(item.getCompany());
    	stock.setItemCd(item.getItemCd());
    	stock.setWlotNo(item.getWlotNo());    	

    	stock = useProcess(item.getStockCd(),null, item.getItemQty(), inoutType,"N",null, null);
    	item.setStockCd(stock.getStockCd());  
    	
    	return item;
    }


    //WO - 자재전체 환입 (MES/POP)
    @Transactional
    public void workCancelOutgoinItem(WorkOrderOutgoingItem item) {    

    	String inoutType = "60";	//환입
    	
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(item.getCompany());
    	stock.setItemCd(item.getItemCd());
    	stock.setStockCd(item.getStockCd());
    	
        inProcess(stock, item.getItemQty(),inoutType,"N", null);
    }


    //WO - 자재일부 환입 (MES/POP)
    @Transactional
    public void workUpdateOutgoinItem(WorkOrderOutgoingItem item,BigDecimal returnQty) {

    	String inoutType = "60";	//환입
    	
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(item.getCompany());
    	stock.setItemCd(item.getItemCd());
    	stock.setStockCd(item.getStockCd());

        //inProcess(stock, item.getPreItemQty().subtract(item.getItemQty()),inoutType,"N", null);  
        inProcess(stock, returnQty,inoutType,"N", null);  	
    }
    
    //MES_POP > 생산완료 공정, 실적수정 생산품 공정입고(취소) :: TEST
    @Transactional
    public void saveWorkingOrderCancelIncoming(WorkOrderIncoming item) {   
    	String inoutTypeDetail = "15";
    	useProcess(item.getStockCd(),null, item.getItemQty(), inoutTypeDetail,"N",null, null);
    }
    
    //WO - 자재사용처리 (MES - 생산실적수정) :: TEST
    @Transactional
    public void workConsumUseItem(WorkOrderOutgoingItem item) {    	
    	String inoutTypeDetail = "90";
    	useProcess(item.getStockCd(),item.getStockCd(), item.getItemQty(), inoutTypeDetail,"N",null, null);
    }

    //WO - 자재사용(환입)처리 (MES - 생산실적수정) :: TEST
    @Transactional
    public void workUpdateConsumUseItem(WorkOrderOutgoingItem item) { 
    	
    	String inoutTypeDetail = "95";
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(item.getCompany());
    	stock.setItemCd(item.getItemCd());
    	stock.setStockCd(item.getStockCd());

    	//STOCK = USE > IN
        inProcess(stock,  item.getItemQty(),inoutTypeDetail,"N", null);
        
    }


    //재고관리 - 출하창고입고등록:: TEST
    @Transactional
    public void salesInItem(List<SalesOutVO> list) {    	   
    	if(isNotEmpty(list)){
        	for (SalesOutVO m : list) {

            	String inoutTypeFrom = "20";
            	String inoutTypeTo = "10";
            	StockMaster stock = new StockMaster();    	
            	stock.setCompany(m.getCompany());
            	stock.setItemCd(m.getItemCd());
            	stock.setWhCd(m.getToWarehouse());   
            	
            	outProcess(stock, m.getStockCd(), m.getItemQty(), inoutTypeFrom, inoutTypeTo, m.getQcWay(), "Y", null);    	            	    				
        	}
    	}
    }
    
    //재고관리 - 제품/자재출고:: TEST
    @Transactional
    public StockOut stockOutItem(StockOut m) {    
    	
    	String inoutTypeDetail = "20";    
    	
    	if(m.getWhType().equals("10")){
        	inoutTypeDetail = "90";    	
    	}else if(m.getWhType().equals("20")){
        	inoutTypeDetail = "100";    	
    	}
    	
    	StockMaster stock = useProcess(m.getStockCd(),null, m.getItemQty(), inoutTypeDetail,"N",null, m.getOutDt());
    	m.setStockCd(stock.getStockCd());
    	
    	return m;
    }

    //재고관리 - 제품/자재출고-취소:: TEST
    @Transactional
    public void stockOutCancelItem(StockOut m) {  
    	
    	String inoutTypeDetail = "";    	
    	
    	if(m.getWhType().equals("10")){
        	inoutTypeDetail = "95";    	
    	}else if(m.getWhType().equals("20")){
        	inoutTypeDetail = "105";    	
    	}
    	
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(m.getCompany());
    	stock.setItemCd(m.getItemCd());
    	stock.setStockCd(m.getStockCd());
    	
        inProcess(stock, m.getItemQty(),inoutTypeDetail,"N", null);
    }
    

    //재고관리-실사	:: TEST
    @Transactional
    public ModifyDetail modifyItem(ModifyDetail item,String whCd, String dt) {
	
    	//기초재고등록일경우
		if(item.getModifyDetailType().equals("20")){
	    	String inoutTypeDetail = "40";	//실사입고
	    	
	    	StockMaster stock = new StockMaster();    	
	    	stock.setCompany(item.getCompany());
	    	stock.setItemCd(item.getItemCd());
	    	stock.setWhCd(whCd);
	    	stock.setLotNo(item.getLotNo());
	    	stock.setRoutCd(item.getRoutCd());
	    	
	        stock =  inProcess(stock, item.getItemQty(),inoutTypeDetail,"N", dt);
	        item.setStockCd(stock.getStockCd());
	        item.setLotNo(stock.getLotNo());
		}else if(item.getModifyDetailType().equals("10")){	//재고실사
			
			if (item.getItemQty().compareTo(new BigDecimal(0)) == 1) {
				String inoutTypeDetail = "30";
		    	//수량증가일경우 입고처리		
	        	StockMaster stock = new StockMaster();    	
	        	stock.setCompany(item.getCompany());
	        	stock.setItemCd(item.getItemCd());
	        	stock.setStockCd(item.getStockCd());
	        	inProcess(stock, item.getItemQty(),inoutTypeDetail,"N", dt);
			}else{
				String inoutTypeDetail = "35";
				//수량감소일경우 소모처리
				useProcess(item.getStockCd(),null, item.getItemQty().abs(), inoutTypeDetail,"N",null, null);
			}
		}
    	return item;
    }
    
    //재고관리 - 기말재고실사
    @Transactional
    public void saveStockEndAdj(List<StockMasterVO> list) {    	   
    	if(isNotEmpty(list)){
        	for (StockMasterVO m : list) {
        		if (m.getItemQty().compareTo(new BigDecimal(0)) == 1) {
    				String inoutTypeDetail = "330";
    		    	//수량증가일경우 입고처리		
    	        	StockMaster stock = new StockMaster();    	
    	        	stock.setCompany(m.getCompany());
    	        	stock.setItemCd(m.getItemCd());
    	        	stock.setStockCd(m.getStockCd());
    	        	inProcess(stock, m.getItemQty(),inoutTypeDetail,"N", m.getInoutDt());
    			}else{
    				String inoutTypeDetail = "335";
    				//수량감소일경우 소모처리
    				useProcess(m.getStockCd(),null, m.getItemQty().abs(), inoutTypeDetail,"N",null, m.getInoutDt());
    			} 	            	    				
        	}
    	}
    }
    
    //공통 - 바코드발행	:: TEST
    @Transactional
    public StockBox barcodeDivision(StockBox m) {

    	String inoutTypeFrom = "210";
    	String inoutTypeTo = "215";
    	
    	StockMaster stock = new StockMaster();    	  	
    	stock.setCompany(m.getCompany());
    	stock.setItemCd(m.getItemCd());
    	stock.setWlotNo(m.getWlotNo());
    	
    	stock = outProcess(stock,m.getRefStockCd(),m.getItemQty(), inoutTypeFrom,inoutTypeTo,null,"N",null);
    	m.setStockCd(stock.getStockCd());  
    	
    	return m;
    	
    }

    //공통 -	:: TEST  - 양품등록시 사용
    @Transactional
    public StockBox2 barcodeDivision2(StockBox2 m) {

    	String inoutTypeFrom = "210";
    	String inoutTypeTo = "215";
    	
    	StockMaster stock = new StockMaster();    	  	
    	stock.setCompany(m.getCompany());
    	stock.setItemCd(m.getItemCd());
    	stock.setWlotNo(m.getWlotNo());
    	
    	stock = outProcess(stock,m.getRefStockCd(),m.getItemQty(), inoutTypeFrom,inoutTypeTo,null,"N",null);
    	m.setStockCd(stock.getStockCd());  
    	
    	return m;
    	
    }
    
    //공통 - 바코드발행취소	:: TEST
    @Transactional
    public void barcodeCancelDivision(StockBox m) {

    	String inoutTypeFrom = "220";
    	String inoutTypeTo = "225";
    	
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(m.getCompany());
    	stock.setItemCd(m.getItemCd());
    	stock.setStockCd(m.getRefStockCd());
    	
    	outProcess(stock,m.getStockCd(),m.getItemQty(), inoutTypeFrom,inoutTypeTo,null,"N",null);   
    }
    //공통 - 바코드발행취소2	:: TEST
    @Transactional
    public void barcodeCancelDivision2(StockBox2 m) {

    	String inoutTypeFrom = "220";
    	String inoutTypeTo = "225";
    	
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(m.getCompany());
    	stock.setItemCd(m.getItemCd());
    	stock.setStockCd(m.getRefStockCd());
    	
    	outProcess(stock,m.getStockCd(),m.getItemQty(), inoutTypeFrom,inoutTypeTo,null,"N",null);   
    }
    //수입검사 (입고/불량)	:: TEST
    @Transactional
    public void insertQcResult(QcResultMaster item) {
		if (null!=item.getBadQty() && item.getBadQty().compareTo(new BigDecimal(0)) == 1) {	    
	    	useProcess(item.getStockCd(),null, item.getBadQty(), "310","N",null, null);
		}
    }    
    
    //부적합후처리 (재처리)	:: TEST
    @Transactional
    public void insertBadItemPrc(QcResultBadDetail detail){    
    	StockMaster stock = new StockMaster();    	
    	stock.setCompany(detail.getCompany());
    	stock.setItemCd(detail.getItemCd());
    	stock.setStockCd(detail.getStockCd());    	
        stock =  inProcess(stock,detail.getPrcQty(),"320","N", detail.getRegDt());
    }	

    //재고관리-이동(환입)    (생산창고>자재)
    @Transactional
    public MoveInoutDetail moveItem(MoveInoutDetail m,String whCd,String returnYn) { 

    	String inoutTypeFrom = "110";
    	String inoutTypeTo = "115";
    	
    	//자재창고로 들어올경우 환입.
    	if(returnYn.equals("Y")){
    		inoutTypeFrom = "111";
    		inoutTypeTo = "116";
    	}
    	
    	StockMaster stock = new StockMaster();    	  	
    	stock.setCompany(m.getCompany());
    	stock.setItemCd(m.getItemCd());
    	stock.setWhCd(whCd);
    	
    	stock = outProcess(stock,m.getRefStockCd(),m.getItemQty(), inoutTypeFrom,inoutTypeTo,null,"N", null);
    	m.setStockCd(stock.getStockCd());  
    	return m;
    }

    @Transactional
    public StockMaster createWlotNoStockMaster(WorkOrderMaster master) {

    	StockMaster m = new StockMaster();
    	m.setCompany(master.getCompany());
    	m.setWlotNo(master.getWlotNo());
    	m.setItemCd(master.getItemCd());
    	
		if(isNotEmpty(m.getWlotNo())){			
			WorkOrderMaster w = new WorkOrderMaster();	
			w = getWorkOrderMaster(m.getWlotNo());		
			if(null!=w){
		    	m.setWhCd(w.getWhCd());
		    	m.setRoutCd(w.getRoutCd());
			}
			
        	m.setStockCd(workKeyManagementService.getYymmCode("STOCK_CD","T", 4).toString());
			m.setLotNo(workKeyManagementService.getYymmCode("LOTNO","SV", 4).toString());
			m.setBarcode(workKeyManagementService.getYymmCode("BARCODE","B", 4).toString());    

    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String stockDt = sdf.format(cal.getTime());
            
        	m.setStockDt(stockDt);
			m.setQcWay("10");
			m.setQcFlag("Y");	
			m.setPrdUseYn("Y");		
			
			
			if(w.getLastFlag().equals("Y")){
				m.setWipYn("N");
			}else{
				m.setWipYn("Y");
			}
			
	    	save(m); 
		}
		
		return m;
    }


    @Transactional
    public StockMaster inProcess(StockMaster m,BigDecimal itemQty,String inoutTypeDetail,String qcYn, String dt) {

    	String inoutType = "IN";
    	String stockDt = dt;
    	
		//품목마스터 정보
		ItemMaster item = getItemInfo(m.getItemCd());
		//검사유형 (무검사/샘플링/전수검사)
		String qcWay = item.getQcWay();    		
		//로뜨관리 여부
		String lotYnFlag = item.getLotYn();

		String lotNo="";
		String barcode="";

		if(null != m){
			
			m.setPrdUseYn("N");		
			m.setWipYn("N");
			m.setQcFlag("Y");	
			//2020-10-14
			/*
			barcode = workKeyManagementService.getYymmCode("BARCODE","B", 4).toString();    
        	m.setBarcode(barcode);
			*/
			if (isEmpty(stockDt)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Calendar cal = Calendar.getInstance();
	            stockDt = sdf.format(cal.getTime());
			}

    		//실적번호가 있을경우, 해당 실적의 설비 및 공정코드 가져온다.
    		if(isNotEmpty(m.getWlotNo())){			
    			
    			WorkOrderMaster w = new WorkOrderMaster();	
    			w = getWorkOrderMaster(m.getWlotNo());		
    			
    			if(null!=w){
    		    	m.setWhCd(w.getWhCd());
    		    	m.setRoutCd(w.getRoutCd());
    			}
    			
    			if(w.getOrderSt().equals("RUN") || w.getOrderSt().equals("NWRK") || w.getOrderSt().equals("PAUSE")){
        			m.setPrdUseYn("Y");		
    			}    			
    		}

    		//재고코드가 지정되었으면 해당 지정코드에 입고
    		if(isNotEmpty(m.getStockCd())){
    			m = getStockRow(m.getStockCd());
    		}else{
    			//재고코드가 지정되지 않았으면
    			
    			//로뜨 사용 하지 않을경우
            	if(lotYnFlag.equals("N")){
            		
        			lotNo = "NLOT";
        			barcode = "NBAR";
                	m.setLotNo(lotNo);
                	m.setBarcode(barcode);
                	
            	}else{
            		//로뜨 사용할경우
            		
            		//지정된 로뜨가 없으면 로뜨 채번
            		if(isEmpty(m.getLotNo())){
            			lotNo = workKeyManagementService.getYymmCode("LOTNO","SV", 4).toString();        
                    	m.setLotNo(lotNo);
            		}
            		
            		//지정된 바코드가 없을경우 바코드 채번
            		if(isEmpty(m.getBarcode())){
            			barcode = workKeyManagementService.getYymmCode("BARCODE","B", 4).toString();    
                    	m.setBarcode(barcode);  
            		}	
            		
            	}
            	
            	//창고,로뜨,바코드,공정,실적번호로 재고 다시 확인
            	//StockMaster prevRow = getPrevStockRow(m.getItemCd(),m.getWhCd(),m.getLotNo(),m.getBarcode(),m.getRoutCd(),m.getWlotNo());
            	StockMaster prevRow = getPrevStockRow(m.getItemCd(),m.getWhCd(),m.getLotNo(),m.getBarcode(),null,null);
            	
            	//신규 재고일경우
            	if(null == prevRow){
            		String stockCd = workKeyManagementService.getYymmCode("STOCK_CD","T", 4).toString();     
                	m.setStockCd(stockCd);
                	m.setStockDt(stockDt);
            	}else{
            		//등록된 재고가 있을경우
            		m = prevRow;
            	}
    		}
    		
        	m = stockDetailService.inOutProcess(m ,null, inoutType, inoutTypeDetail, itemQty, stockDt);
        	
        	//10	구매입고
        	//20	예외입고
        	//140	출하창고입고
    		if(isNotEmpty(qcWay) && !qcWay.equals("10")  && qcYn.equals("Y")){
    			
            	createQc(m,inoutTypeDetail,qcWay,itemQty,stockDt);
    			m.setQcWay(qcWay);
    			m.setQcFlag("N");
    		}else{
    			m.setQcDt(stockDt);
    			m.setQcWay(qcWay);
    			m.setQcFlag("Y");
    		}
    		
    		m.setWlotNo(null);
    		
        	save(m);
		}
    	return m;
    }        

    @Transactional
    public StockMaster outProcess(StockMaster m, String refStockCd, BigDecimal itemQty ,String inoutTypeFrom,String inoutTypeTo,String qcWay,String qcYn, String dt) {

    	String inoutType = "OUT";
    	String stockDt = dt;
    	StockMaster r = new StockMaster();

    	if(null != m){

			m.setPrdUseYn("N");		
			m.setWipYn("N");

			if (isEmpty(stockDt)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Calendar cal = Calendar.getInstance();
	            stockDt = sdf.format(cal.getTime());
			}
    		//실적번호가 있을경우, 해당 실적번호의 설비 및 공정코드 가져온다.
    		if(isNotEmpty(m.getWlotNo())){			
    			
    			WorkOrderMaster w = new WorkOrderMaster();	
    			w = getWorkOrderMaster(m.getWlotNo());		
    			
    			if(null!=w){    				
    		    	m.setWhCd(w.getWhCd());
    			}

    			if(w.getOrderSt().equals("ORDER") || w.getOrderSt().equals("RUN") || w.getOrderSt().equals("NWRK") || w.getOrderSt().equals("PAUSE")){
        			m.setPrdUseYn("Y");		
    			}
    		}
    		
    		//재고 로우 가져오기
    		r = getStockRow(refStockCd);    		
    		
    		System.out.println("##refStockCd" + refStockCd);
    		//재고가 있으면
    		if(null != r)
    		{
    			
    			//창고 지정안되엇을경우 재고 창고로
    			if(isEmpty(m.getWhCd())){
        			m.setWhCd(r.getWhCd());
    			}

    			//로뜨 지정되지 않앗을경우 재고 로뜨로
    			if(isEmpty(m.getLotNo())){
        			m.setLotNo(r.getLotNo());
    			}

    			//바코드 지정되지 않앗을경우 재고 바코드로
    			if(isEmpty(m.getBarcode()) ){
        			m.setBarcode(r.getBarcode());
    			}

    			//공정코드
    			if(isNotEmpty(r.getRoutCd()) ){
        			m.setRoutCd(r.getRoutCd());
    			}

    			//재공여부
    			if(isNotEmpty(r.getWipYn()) ){
        			m.setWipYn(r.getWipYn());
    			}

        		if(isNotEmpty(m.getStockCd())){
            		m = getStockRow(m.getStockCd());
        		}else{        			
                	//창고,로뜨,바코드,공정,실적번호로 재고 다시 확인
        			//StockMaster prevRow = getPrevStockRow(m.getItemCd(),m.getWhCd(),m.getLotNo(),m.getBarcode(),m.getRoutCd(),m.getWlotNo());
        			StockMaster prevRow = getPrevStockRow(m.getItemCd(),m.getWhCd(),m.getLotNo(),m.getBarcode(),null,null);
                	
                	//바코드분할일경우. 신규 재고 코드 생성함 ( 바코드만 초기화 )
                	if(inoutTypeFrom.equals("210")){
                		
                		String stockCd = workKeyManagementService.getYymmCode("STOCK_CD","T", 4).toString();     
            			String barcode = workKeyManagementService.getYymmCode("BARCODE","B", 4).toString();    
                    	m.setStockCd(stockCd);
                    	m.setStockDt(stockDt);
                    	m.setBarcode(barcode);
            			m.setPrdUseYn("N");		
            			
                	}else{
                    	//신규 재고일경우
                    	if(null == prevRow){
                    		String stockCd = workKeyManagementService.getYymmCode("STOCK_CD","T", 4).toString();     
                        	m.setStockCd(stockCd);
                        	m.setStockDt(stockDt);
                    	}else{
                    		//등록된 재고가 있을경우
                    		m = prevRow;
                    	}
                	}
        		}
        		
        		//출고
            	r = stockDetailService.inOutProcess(r ,m.getStockCd(), inoutType, inoutTypeFrom, itemQty, stockDt);
            	
            	//입고
            	m = stockDetailService.inOutProcess(m ,r.getStockCd(), "IN", inoutTypeTo, itemQty, stockDt);

            	//10	구매입고
            	//20	예외입고
            	//140	출하창고입고
        		if(isNotEmpty(qcWay) && !qcWay.equals("10") && qcYn.equals("Y")){               
        			createQc(m,inoutTypeFrom,qcWay,itemQty,stockDt);                	
        			m.setQcWay(qcWay);
        			m.setQcFlag("N");        			
        		}else{
        			m.setQcDt(stockDt);
        			m.setQcWay(qcWay);
        			m.setQcFlag("Y");
        		}

        		//r.setWlotNo(null);	
    			m.setWlotNo(null);	
    			
            	save(r);
            	save(m);
    		}
    	}
    	    	
    	return m;
    }        


    //소모 대상 코드, 환입대상 코드 , 소모수량, 입출고유형
    @Transactional					
    public StockMaster useProcess(String stockCd,String refStockCd, BigDecimal itemQty,String inoutTypeDetail, String returnYn , BigDecimal remainQty, String dt) {

    	String inoutType = "USE";
    	String stockDt = dt;
    	StockMaster m = new StockMaster();
    	
    	if (isEmpty(stockDt)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            stockDt = sdf.format(cal.getTime());
		}
    	
    	if(isNotEmpty(stockCd)){
       		m = getStockRow(stockCd);
       		if(null!=m){
            	m = stockDetailService.inOutProcess(m ,refStockCd, inoutType, inoutTypeDetail, itemQty, stockDt);

    			m.setWlotNo(null);	
            	save(m);

            	//환입 y일경우 남은수량 환입처리함.
            	if(returnYn.equals("Y") && isNotEmpty(refStockCd)){

                	StockMaster stock = new StockMaster();  
                	stock.setCompany(stock.getCompany());
                	stock.setItemCd(stock.getItemCd());
                	stock.setStockCd(refStockCd);
                	
                	//환입 수량 존재 할 경우 ,환입처리 (원래 재고코드로==item.getStockCode())//소모처리후 남은 재고 전체수량 만큼.;
            		if (null!=remainQty && remainQty.compareTo(new BigDecimal(0)) == 1) {	    	
            	    	outProcess(stock,m.getStockCd(),remainQty, inoutTypeDetail,inoutTypeDetail,"10","N", stockDt);   
            		}
            	}
       		}
    	}   	
    	
    	return m;
    }        

    //입고 데이터 생성
    @Transactional
    public void createIn(StockMaster m,String slipCd, Long slipSeq, String custCd,BigDecimal unitAmt){
    	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String inDt = sdf.format(cal.getTime());
        
    	StockIn so = new StockIn();
		so.setCompany(m.getCompany());
		so.setStockCd(m.getStockCd()); 		
		so.setInDt(inDt);
		so.setCustCd(custCd);   
		so.setUnitAmt(unitAmt);	
		so.setRefSlipCd(slipCd);	
		so.setRefSlipSeq(slipSeq);	
		
		stockInService.save(so);		
		
    }

    //QC 데이터 생성
    @Transactional
    public void createQc(StockMaster m,String inoutTypeDetail,String qcWay,BigDecimal itemQty, String dt){

		QcResultMaster qc = new QcResultMaster();
		String inoutDt = dt;
		
		if (isEmpty(inoutDt)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            inoutDt = sdf.format(cal.getTime());
		}
		
    	//무검사 10 샘플링20 전수 30
		//10 구매입고   20 출하창고입고. (old : 10 구매입고   20예외입고   140 출하창고입고.) ==> 김회재 수정 2020.07.23
		//무검사가 아니고 일반/구매입고/예외입고 일 경우 검사대상 테이블 INSERT
		//if(isNotEmpty(inoutTypeDetail) && (inoutTypeDetail.equals("10")|| inoutTypeDetail.equals("20"))){  ==>  김회재 수정 2020.07.23
		if(isNotEmpty(inoutTypeDetail) && inoutTypeDetail.equals("10")){
			qc.setCompany(m.getCompany());
	    	qc.setStockCd(m.getStockCd());
	    	qc.setLotNo(m.getLotNo());
	    	qc.setInDt(inoutDt);        	    	     
	    	qc.setItemCd(m.getItemCd());
	    	qc.setInQty(itemQty);
	    	qc.setItemQty(itemQty);
	    	qc.setBadQty(new BigDecimal(0));
	    	qc.setQcWay(qcWay);
	    	qc.setQcType("10"); //수입검사
	    	qc.setQcFlag("N");
	    	qc.setEndFlag("N"); 	    	
	    	qc = inspResultMasterService.saveInsp(qc);
		}else if(isNotEmpty(inoutTypeDetail) && inoutTypeDetail.equals("20")){   // (old : inoutTypeDetail.equals("140") ==>  김회재 수정 2020.07.23 )
			
			//출하창고 입고시 무검사 항목은 무검사 등록
	    	qc.setCompany(m.getCompany());
	    	qc.setStockCd(m.getStockCd());
	    	qc.setLotNo(m.getLotNo());
	    	qc.setInDt(inoutDt);        	    		
	    	qc.setItemCd(m.getItemCd());
	    	qc.setInQty(itemQty);
	    	qc.setItemQty(itemQty);
	    	qc.setBadQty(new BigDecimal(0));
	    	qc.setQcWay(qcWay);
	    	qc.setQcType("20"); //출하검사
	    	
			if(qcWay.equals("10")){
		    	qc.setQcFlag("Y");
		    	qc.setEndFlag("Y"); 	    
			}else{
		    	qc.setQcFlag("N");
		    	qc.setEndFlag("N"); 	    
			}	        	
	    	qc = inspResultMasterService.saveInsp(qc);
		}     		
    }


    public StockMaster getPrevStockRow(String itemCd,String whCd,String lotNo,String barcode,String routCd,String wlotNo){

        BooleanBuilder builder = new BooleanBuilder();
        
        if (isNotEmpty(itemCd)) { 
            builder.and(qStockMaster.itemCd.eq(itemCd));
        }

        if (isNotEmpty(whCd)) { 
            builder.and(qStockMaster.whCd.eq(whCd));
        }

        if (isNotEmpty(lotNo)) { 
            builder.and(qStockMaster.lotNo.eq(lotNo));
        }

        if (isNotEmpty(barcode)) { 
            builder.and(qStockMaster.barcode.eq(barcode));
        }
        
        if (isNotEmpty(routCd)) { 
            builder.and(qStockMaster.routCd.eq(routCd));
        }        

        if (isNotEmpty(wlotNo)) { 
            builder.and(qStockMaster.wlotNo.eq(wlotNo));
        }
                
    	return
    	 select()
		.from(qStockMaster)
		.where(builder).fetchOne();
    }
    


    public StockMaster getStockRow(String stockCd){

        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(stockCd)) { 
            builder.and(qStockMaster.stockCd.eq(stockCd));
        }

                
    	return
    	 select()
		.from(qStockMaster)
		.where(builder).fetchOne();
    }

    //생산로뜨 기준 투입여부 상태값 변경
    @Transactional
    public void updatePrdUseYn(String stockCd, String prdUseYn) {
    	if(isNotEmpty(stockCd)){
        	update(qStockMaster)
        	.set(qStockMaster.prdUseYn, prdUseYn)
        	.where(qStockMaster.stockCd.eq(stockCd)).execute();    	
    	}
    }

    
    //검사상태값 변경
    @Transactional
    public void updateQcInfo(String stockCd, String qcDt, String qcWay, String qcFlag) {
    	if(isNotEmpty(stockCd)){
        	update(qStockMaster)
        	.set(qStockMaster.qcDt, qcDt)
        	.set(qStockMaster.qcWay, qcWay)
        	.set(qStockMaster.qcFlag, qcFlag)
        	.where(qStockMaster.stockCd.eq(stockCd)).execute();    	
    	}
    }

    //품목마스터정보
    public ItemMaster getItemInfo(String itemCd){
        return itemMasterService.getItemMaster(itemCd);
    }

    //작업지시 마스터조회
    public WorkOrderMaster getWorkOrderMaster(String wlotNo){
        return workOrderMasterService.getMasterOne(wlotNo);
    }
    
    //통합 재고용-창고별
    public List<StockMasterVO> stockGroupByAll(RequestParams<StockMasterVO> vo) {       
       return stockMasterMapper.stockGroupByAll(vo);
    } 
    
    //2020-09-23 cju 바코드 검색
    public List<StockMasterVO> stockBarcodeSearch(RequestParams<StockMasterVO> vo) {       
       return stockMasterMapper.stockBarcodeSearch(vo);
    }     
    //2020-10-12 cju 출하 여브 검색
    public List<StockMasterVO> outYNSearch(RequestParams<StockMasterVO> vo) {       
       return stockMasterMapper.outYNSearch(vo);
    } 
    //통합 재고용-품목별
    public List<StockMasterVO> stockGroupByItem(RequestParams<StockMasterVO> vo) {       
       return stockMasterMapper.stockGroupByItem(vo);
    } 

    //현재고
    public List<StockMasterVO> getStockMaster (RequestParams<StockMasterVO> requestParams) {	
    	return stockMasterMapper.getStockMaster(requestParams);
    }     
    
    //수불원장
    public List<StockMasterVO> getStockHistory (RequestParams<StockMasterVO> requestParams) {	
    	return stockMasterMapper.getStockHistory(requestParams);
    }     

    //제품출고현황
    public List<StockMasterVO> getStockOutList(RequestParams<StockMasterVO> vo) {
    	return stockMasterMapper.getStockOutList(vo);
    } 
    
    //20.09.09 KJM POP 출고
    @Transactional
    public StockOut popStockOutItem(StockOut m) {    
    	
    	String inoutTypeDetail = "20";    
    	
    	if(m.getWhType().equals("10")){
        	inoutTypeDetail = "90";    	
    	}else if(m.getWhType().equals("20")){
        	inoutTypeDetail = "100";    	
    	}
    	
    	StockMaster stock = popUseProcess(m.getStockCd(),null, m.getItemQty(), inoutTypeDetail,"N",null, m.getOutDt());
    	m.setStockCd(stock.getStockCd());
    	
    	return m;
    }

    //20.09.09 kjm
    @Transactional					
    public StockMaster popUseProcess(String stockCd,String refStockCd, BigDecimal itemQty,  String inoutTypeDetail, String returnYn , BigDecimal remainQty, String dt) {

    	String inoutType = "USE";
    	String stockDt = dt;
    	StockMaster m = new StockMaster();
    	
    	if (isEmpty(stockDt)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            stockDt = sdf.format(cal.getTime());
		}
    	
    	if(isNotEmpty(stockCd)){
       		m = getStockRow(stockCd);
       		if(null!=m){
            	m = stockDetailService.popInOutProcess(m ,refStockCd, inoutType, inoutTypeDetail, itemQty, stockDt);

    			m.setWlotNo(null);	
            	save(m);

            	//환입 y일경우 남은수량 환입처리함.
            	if(returnYn.equals("Y") && isNotEmpty(refStockCd)){

                	StockMaster stock = new StockMaster();  
                	stock.setCompany(stock.getCompany());
                	stock.setItemCd(stock.getItemCd());
                	stock.setStockCd(refStockCd);
                	
                	//환입 수량 존재 할 경우 ,환입처리 (원래 재고코드로==item.getStockCode())//소모처리후 남은 재고 전체수량 만큼.;
            		if (null!=remainQty && remainQty.compareTo(new BigDecimal(0)) == 1) {	    	
            	    	outProcess(stock, m.getStockCd(),remainQty, inoutTypeDetail,inoutTypeDetail,"10","N", stockDt);   
            		}
            	}
       		}
    	}   	
    	
    	return m;
    }
}