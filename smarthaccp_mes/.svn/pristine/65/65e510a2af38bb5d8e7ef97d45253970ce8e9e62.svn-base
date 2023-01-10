
package com.ppm.mes.domain.wo.wo100;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.st.st000.StockMaster;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.ppm.mes.domain.wo.wo110.WorkManManageService;
import com.ppm.mes.domain.wo.wo120.WorkOrderBadService;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncoming;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncomingService;
import com.ppm.mes.utils.CommonUtil;
import com.ppm.mes.utils.SessionUtils;
import com.querydsl.core.BooleanBuilder;

@Service
public class WorkOrderMasterService extends BaseService<WorkOrderMaster, WorkOrderMaster.WorkOrderMasterId> {
    private WorkOrderMasterRepository repository;
    
    @Inject private WorkKeyManagementService workKeyManagementService;
    @Inject private WorkOrderBadService workOrderBadService;
    @Inject private WorkOrderIncomingService workOrderIncomingService;
    @Inject private WorkManManageService workManManageService;
    @Inject private WorkOrderMasterService workOrderMasterService;
    @Inject private WorkOrderMasterMapper workOrderMasterMapper;
    @Inject private StockMasterService stockMasterService;
    
    @Inject
    public WorkOrderMasterService(WorkOrderMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    //작업지시 마스터 단건 조회
    public List<WorkOrderMasterVO> getWorkOrderMasterList(RequestParams<WorkOrderMasterVO> master) {
    	return workOrderMasterMapper.getWorkOrderMasterList(master);
    }
    //작업지시 마스터 생성 
    @Transactional
    public void saveWorkOrderMaster(List<WorkOrderMaster> masters) {    	

		if (isNotEmpty(masters)) {
			String tempOrderNo = "";
			String orderNo = "";
			String wlotNo = "";
    		int orderSeq = 1;    		
			
	    	for (WorkOrderMaster m : masters) {    
	    		if(isEmpty(m.getOrderNo())){
	            	if(!m.getTempOrderNo().equals(tempOrderNo)){
	                	orderNo = workKeyManagementService.getYymmCode("WORDER","WO", 3).toString();
	                	orderSeq = 1;
	    			}

					m.setOrderNo(orderNo);   
					
	            	if(null == m.getOrderSeq()){
	            		if(orderSeq == 1){
	                		m.setOrderSt("ORDER");
	            		}else{
	                		m.setOrderSt("LOCK");
	            		}
	            		//POP화면에서 작업등록시 작업시작 상태로 세팅 : 21.06.29 KHJ 
	            		/*
	            		if(isNotEmpty(m.getOrderType()) && m.getOrderType().equals("10")){
	            			m.setOrderSt("RUN");
	            		}
	            		*/

	            		m.setOrderSeq(new Long(orderSeq));
	            		m.setWorkSeq(new Long(1));      
	            		
	            		m.setLiquidA(new BigDecimal(0));      
	            		m.setLiquidB(new BigDecimal(0));      

				    	wlotNo = workKeyManagementService.getYymmCode("WLOTNO","WL", 3).toString();   
						m.setWlotNo(wlotNo);   
	                	orderSeq ++;
	            	}
	            	tempOrderNo = m.getTempOrderNo();
	            	
	    		}else{
	    	    	update(qWorkOrderMaster)
	    	    	.set(qWorkOrderMaster.orderDt, m.getOrderDt())
	    	    	.set(qWorkOrderMaster.equipCd, m.getEquipCd())
	    	    	.set(qWorkOrderMaster.orderQty, m.getOrderQty())
	    	    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
	    	    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
	    	    	.where(qWorkOrderMaster.orderNo.eq(m.getOrderNo()).and(qWorkOrderMaster.orderSeq.eq(m.getOrderSeq()))).execute();
	    		}
	    	}
	    	save(masters);
		}  
    }    
    
    //작업지시 마스터 단건 조회
    public WorkOrderMaster getMasterOne(String wlotNo) {
		BooleanBuilder builder = new BooleanBuilder();
		if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
	    }
		return select().from(qWorkOrderMaster).where(builder).fetchOne();
    }
    

    //POP >> 작업 상태변경
    @Transactional
    public void updateWorkStatus(WorkOrderMaster master) {

    	String wlotNo = master.getWlotNo();
    	String orderSt = master.getOrderSt();    	
    	
    	BooleanBuilder builder = new BooleanBuilder();    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
	    }
		
    	update(qWorkOrderMaster)
    	.set(qWorkOrderMaster.orderSt, orderSt)
    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();
    } 

    //POP >> 설비변경
    @Transactional
    public void updateEquip(WorkOrderMaster master) {

    	String wlotNo = master.getWlotNo();
    	String equipCd = master.getEquipCd();    	
    	String refEquipCd = master.getRefEquipCd();    	
    	
    	BooleanBuilder builder = new BooleanBuilder();    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
	    }
		
    	update(qWorkOrderMaster)
    	.set(qWorkOrderMaster.equipCd, equipCd)
    	.set(qWorkOrderMaster.refEquipCd, refEquipCd)
    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();
    } 
    
    //POP > 작업시작
    @Transactional
    public String updateWorkStart(WorkOrderMaster master) {    	

    	String wlotNo = master.getWlotNo();
    	
    	String equipCd = master.getEquipCd();
    	String orderSt = "RUN";
    	
    	BooleanBuilder builder = new BooleanBuilder();

    	String stockCd = "";

    	//작업시작 시점에 해당 오더에 신규 로뜨번호/재고코드 부여함.
    	StockMaster s = stockMasterService.createWlotNoStockMaster(master);
    	stockCd = s.getStockCd();
    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
	    }

    	Date nowTime = new Date();        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDt = sdf.format(nowTime);        
        
		sdf = new SimpleDateFormat("HH");
        String startHour = sdf.format(nowTime);

		sdf = new SimpleDateFormat("mm");
        String startMinute = sdf.format(nowTime);

		sdf = new SimpleDateFormat("ss");
        String startSecond = sdf.format(nowTime);
		
    	update(qWorkOrderMaster)
    	.set(qWorkOrderMaster.equipCd, equipCd)
    	.set(qWorkOrderMaster.wlotNo, wlotNo)
    	.set(qWorkOrderMaster.stockCd, stockCd) 
    	.set(qWorkOrderMaster.startDt, startDt)
    	.set(qWorkOrderMaster.startHour, startHour)
    	.set(qWorkOrderMaster.startMinute, startMinute)
    	.set(qWorkOrderMaster.startSecond, startSecond)
    	.set(qWorkOrderMaster.startDtm, nowTime.toInstant())
    	.set(qWorkOrderMaster.orderSt, orderSt)
    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();    	
    	
    	return wlotNo;
    } 
    
    //POP > 작업종료
    @Transactional
    public void updateWorkEnd(WorkOrderMaster master) {
    	String wlotNo = master.getWlotNo();
    	String orderSt = "END";	
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
	    }
    	
    	Date nowTime = new Date();        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endDt = sdf.format(nowTime);        
        
		sdf = new SimpleDateFormat("HH");
        String endHour = sdf.format(nowTime);

		sdf = new SimpleDateFormat("mm");
        String endMinute = sdf.format(nowTime);

		sdf = new SimpleDateFormat("ss");
        String endSecond = sdf.format(nowTime);		
        
    	update(qWorkOrderMaster)
    	.set(qWorkOrderMaster.endDt, endDt)
    	.set(qWorkOrderMaster.endHour, endHour)
    	.set(qWorkOrderMaster.endMinute, endMinute)
    	.set(qWorkOrderMaster.endSecond, endSecond)
    	.set(qWorkOrderMaster.endDtm, nowTime.toInstant())
    	.set(qWorkOrderMaster.orderSt, orderSt)
    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();
    } 
    
    //POP > 작업취소
    @Transactional
    public void updateWorkCancel(WorkOrderMaster master) {
    	String wlotNo = master.getWlotNo();
    	String orderSt = "ORDER";	
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
	    }

    	// 작업지시
    	update(qWorkOrderMaster)
    	//.set(qWorkOrderMaster.equipCd, "")
    	.set(qWorkOrderMaster.orderSt, orderSt)
    	.setNull(qWorkOrderMaster.startDt)
    	.setNull(qWorkOrderMaster.startDtm)
    	.setNull(qWorkOrderMaster.startHour)
    	.setNull(qWorkOrderMaster.startMinute)
    	.setNull(qWorkOrderMaster.startSecond)
    	.setNull(qWorkOrderMaster.stockCd)
    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();
    	
    	// 작업자
    	builder = new BooleanBuilder();    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkManManage.wlotNo.eq(wlotNo));
	       	delete(qWorkManManage).where(builder).execute();
	    }
    	
    	// 비가동
    	builder = new BooleanBuilder();    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkNwrkManage.wlotNo.eq(wlotNo));
	       	delete(qWorkNwrkManage).where(builder).execute();
	    }
    	    	
    } 
    
    //POP > 작업취소(전체삭제)
    @Transactional
    public void updateWorkCancelAll(List<WorkOrderMaster> list) {
    	if (isNotEmpty(list)){
    		for (WorkOrderMaster m : list) {  
    			
    			String wlotNo = m.getWlotNo();
    	    	String stockCd = m.getStockCd();
    	    	String orderSt = "ORDER";	
    	    	
    	    	BooleanBuilder builder = new BooleanBuilder();
    	    	
    	    	if (isNotEmpty(wlotNo)) {
    		       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
    		    }

    	    	// 작업지시
    	    	update(qWorkOrderMaster)
    	    	.set(qWorkOrderMaster.equipCd, "")
    	    	.set(qWorkOrderMaster.orderSt, orderSt)
    	    	.setNull(qWorkOrderMaster.startDt)
    	    	.setNull(qWorkOrderMaster.startDtm)
    	    	.setNull(qWorkOrderMaster.startHour)
    	    	.setNull(qWorkOrderMaster.startMinute)
    	    	.setNull(qWorkOrderMaster.startSecond)
    	    	.setNull(qWorkOrderMaster.stockCd)
    	    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
    	    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	    	.where(builder).execute();
    	    	
    	    	// 작업자
    	    	builder = new BooleanBuilder();    	
    	    	if (isNotEmpty(wlotNo)) {
    		       	builder.and(qWorkManManage.wlotNo.eq(wlotNo));
    		       	delete(qWorkManManage).where(builder).execute();
    		    }
    	    	
    	    	// 불량
    	    	builder = new BooleanBuilder();    	
    	    	if (isNotEmpty(wlotNo)) {
    		       	builder.and(qWorkOrderBad.wlotNo.eq(wlotNo));
    		       	delete(qWorkOrderBad).where(builder).execute();
    		    }
    	    	
    	    	// 비가동
    	    	builder = new BooleanBuilder();    	
    	    	if (isNotEmpty(wlotNo)) {
    		       	builder.and(qWorkNwrkManage.wlotNo.eq(wlotNo));
    		       	delete(qWorkNwrkManage).where(builder).execute();
    		    }
    	    	
    	    	// 자재투입
    	    	builder = new BooleanBuilder();    	
    	    	if (isNotEmpty(wlotNo)) {
    		       	builder.and(qWorkOrderOutgoingItem.wlotNo.eq(wlotNo));
    		       	delete(qWorkOrderOutgoingItem).where(builder).execute();
    		    }
    	    	
    	    	// 공정검사 qcResultMaster
    	    	builder = new BooleanBuilder();    	
    	    	if (isNotEmpty(stockCd)) {
    		       	builder.and(qQcResultMaster.stockCd.eq(stockCd));
    		       	delete(qQcResultMaster).where(builder).execute();
    		    }
    	    	
    	    	// 공정검사 qcResultDetail
    	    	builder = new BooleanBuilder();    	
    	    	if (isNotEmpty(stockCd)) {
    		       	builder.and(qQcResultDetail.stockCd.eq(stockCd));
    		       	delete(qQcResultDetail).where(builder).execute();
    		    }
    	    	
    	    	// stockMaster
    	    	builder = new BooleanBuilder();    	
    	    	if (isNotEmpty(stockCd)) {
    		       	builder.and(qStockMaster.stockCd.eq(stockCd));
    		       	delete(qStockMaster).where(builder).execute();
    		    }
    	    	
    	    	// stockDetail
    	    	builder = new BooleanBuilder();    	
    	    	if (isNotEmpty(stockCd)) {
    		       	builder.and(qStockDetail.stockCd.eq(stockCd));
    		       	delete(qStockDetail).where(builder).execute();
    		    }
    			
    		}
    	}
    } 
    
    
    //POP > 작업종료 > 후공정 작업지시 상태변경 (존재시)
    @Transactional
    public void updateNextWork(WorkOrderMaster master) {

    	String orderNo = master.getOrderNo();
    	Long orderSeq = master.getOrderSeq();
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if (isNotEmpty(orderNo)) {
	       	builder.and(qWorkOrderMaster.orderNo.eq(orderNo));
	    }
		if (0 != orderSeq) {
	       	builder.and(qWorkOrderMaster.orderSeq.eq(orderSeq + 1));
	    }
		
       	builder.and(qWorkOrderMaster.orderSt.eq("LOCK"));        
       	
		List<WorkOrderMaster> masters =  select().from(qWorkOrderMaster).where(builder).fetch();
				
		
		//연속공정일경우 (다음공정이 있을경우, 동일 lot 동일 barcode)
		if(isNotEmpty(masters)){			
			//후공정 상태변경
	    	update(qWorkOrderMaster)
	    	.set(qWorkOrderMaster.orderSt, "ORDER")
	    	.set(qWorkOrderMaster.parentWlotNo, master.getWlotNo())	    	
        	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
        	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
	    	.where(builder).execute();	    	
		}
    } 
   

    //POP > 생산실적수정
    @Transactional
    public BigDecimal updateWorkProdQty(String wlotNo) {
    	
    	//양품수량
    	BigDecimal goodQty = workOrderIncomingService.getTotalIncomingQty(wlotNo);
    	
    	//불량수량
    	BigDecimal badQty = workOrderBadService.getTotalBadQty(wlotNo);
    	
    	//생산수량
    	BigDecimal prodQty = goodQty.add(badQty);
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
	    }    	
    	
    	update(qWorkOrderMaster)
    	.set(qWorkOrderMaster.prodQty, prodQty)
    	.set(qWorkOrderMaster.goodQty, goodQty)
    	.set(qWorkOrderMaster.badQty, badQty)
    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();
    	
    	return prodQty;
    } 
    
    //MES > 생산실적수정
    @Transactional
    public void updatePrdWorkMaster(WorkOrderMasterRequestVO request) {
    	
    	WorkOrderMaster m = request.getWorkMaster();
    	BigDecimal itemQty = request.getItemQty();
    	
    	if(null != m){
	    		
    		m.setStartSecond("00");
			m.setEndSecond("00");
			
		    String startDtmString = m.getStartDt() + " " + m.getStartHour() + ":" + m.getStartMinute() + ":00";  
		    String endDtmString = m.getEndDt() + " " + m.getEndHour() + ":" + m.getEndMinute() + ":00";  

			m.setStartDtm(CommonUtil.stringToInstant(startDtmString));    	
			m.setEndDtm(CommonUtil.stringToInstant(endDtmString));    
    		
    		save(m);
    				
    		//생산품 입고처리
    		if (itemQty != null && itemQty.compareTo(BigDecimal.ZERO) != 0){
                workOrderIncomingService.saveIncomingItem(m.getWlotNo() , itemQty);       

        		//오더마스터 생산수량 업데이트
            	workOrderMasterService.updateWorkProdQty(m.getWlotNo());
    		}
    		
    	}
    } 
    
    //MES > 생산실적삭제
    @Transactional
    public void deletePrdWorkMaster(List<WorkOrderIncoming> list) {
		if (isNotEmpty(list)) {
	    	for (WorkOrderIncoming m : list) {    
	            delete(qWorkOrderIncoming).where(qWorkOrderIncoming.wlotNo.eq(m.getWlotNo()).and(qWorkOrderIncoming.woSeq.eq(m.getWoSeq()))).execute();
	    		//생산품 입고처리 (수불원장 마이너스 입고처리 )
	    		if (m.getItemQty() != null && m.getItemQty().compareTo(BigDecimal.ZERO) != 0){
	                //workOrderIncomingService.saveIncomingItem(m.getWlotNo() , m.getItemQty().multiply(new BigDecimal(-1)) ,"PC");      

	        		//오더마스터 생산수량 업데이트
	            	workOrderMasterService.updateWorkProdQty(m.getWlotNo()); 
	    		}
	    	}
		}
    }
    

    //POP >> 액빼기등록
    @Transactional
    public void updateLiquid(WorkOrderMaster master) {

    	String wlotNo = master.getWlotNo();
    	BigDecimal liquidA = master.getLiquidA();    	
    	BigDecimal liquidB = master.getLiquidB();    	
    	
    	BooleanBuilder builder = new BooleanBuilder();   
    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderMaster.wlotNo.eq(wlotNo));
	       	
	    	update(qWorkOrderMaster)
	    	.set(qWorkOrderMaster.liquidA, liquidA)
	    	.set(qWorkOrderMaster.liquidB, liquidB)
	    	.set(qWorkOrderMaster.updatedAt, Instant.now(Clock.systemUTC()))
	    	.set(qWorkOrderMaster.updatedBy, SessionUtils.getCurrentLoginUserCd())
	    	.where(builder).execute();
	    }
    }
    //POP 양품수량 업데이트
    public void updateGoodPrdQty(String stockCd, BigDecimal itemQty){
    	Map map = new HashMap();
    	map.put("stockCd", stockCd);
    	map.put("itemQty", itemQty);
    	
    	workOrderMasterMapper.updateGoodPrdQty(map);
    }
}