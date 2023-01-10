package com.ppm.mes.domain.wo.wo150;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.prd.pop.PopMapper;
import com.ppm.mes.domain.prd.pop.StockListVO;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.ppm.mes.domain.st.st000.StockMasterVO;
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterService;
import com.ppm.mes.utils.SessionUtils;
import com.querydsl.core.BooleanBuilder;

@Service
public class WorkOrderOutgoingItemService extends BaseService<WorkOrderOutgoingItem, WorkOrderOutgoingItem.WorkOrderOutgoingItemId> {
   
	private WorkOrderOutgoingItemRepository repository;

    @Inject private StockMasterService stockMasterService;
    @Inject private WorkOrderMasterService workOrderMasterService;
    @Inject private PopMapper popMapper;
    
    @Inject
    public WorkOrderOutgoingItemService(WorkOrderOutgoingItemRepository repository) {
        super(repository);
        this.repository = repository;
    }

    
    // POP > 자재출고
    @Transactional
    public void saveWorkOrderOutgoingItem(WorkOrderOutgoingItem item) {    	
    	
    	if (null != item) {

    		if(isEmpty(item.getDiscardYn())){
    			item.setDiscardYn("N");
    		}
    		
    		//신규
    		if(null==item.getWoSeq()){
    			Long woSeq = select().select(qWorkOrderOutgoingItem.woSeq.max()).distinct()
    					.from(qWorkOrderOutgoingItem)
    					.where(qWorkOrderOutgoingItem.wlotNo.eq(item.getWlotNo())).fetchOne();
    			
    			if(null==woSeq){
    				woSeq = new Long(1);
    			}else{
    				woSeq = woSeq + new Long(1);
    			}    			
        		
    			if(!item.getUnit().equals(item.getBomUnit())){
        			item.setItemQty(item.getBomItemQty().divide(item.getBomTrans(), 5, BigDecimal.ROUND_UP));    
    			}else{
    				item.setItemQty(item.getBomItemQty());
    			}
    			
    			item.setWoSeq(woSeq);    			
        		item = stockMasterService.workOutgoinItem(item);
    		}
			
	    	save(item);
        }
    }    
    
    //POP > 자재출고 취소
    @Transactional
    public void saveWorkOrderCancelOutgoingItem(WorkOrderOutgoingItem item) {    	
    	if (null != item) {
    		//신규
    		if(null!=item.getWoSeq()){
        		stockMasterService.workCancelOutgoinItem(item);
    		}    		
	    	save(item);
        }
    }
    
    public void saveWorkOrderOutgoingItemList(List<WorkOrderOutgoingItem> list){
    	if(isNotEmpty(list)){
	    	for (WorkOrderOutgoingItem m : list) {
	    		saveWorkOrderOutgoingItem(m);
	    	}
    	}
    }
    
    //POP >> 자재환입
    @Transactional
    public void saveWorkOrderReturnItem(WorkOrderOutgoingItem item) {    	
		//신규
		if(null!=item.getWoSeq()){
			
			WorkOrderOutgoingItem m = getMasterOne(item.getCompany(),item.getWlotNo(), item.getWoSeq());
			
			BigDecimal returnQty = new BigDecimal(0);
			
			if(null != m){
				returnQty = m.getItemQty().subtract(item.getItemQty());
			}
			
			if(!item.getUnit().equals(item.getBomUnit())){
    			item.setItemQty(item.getItemQty().subtract(item.getBomItemQty().divide(item.getBomTrans(), 5, BigDecimal.ROUND_UP)));    
    			item.setBomItemQty(item.getItemQty().multiply(item.getBomTrans()));    
			}else{
				item.setItemQty(item.getItemQty().subtract(item.getBomItemQty()));
    			item.setBomItemQty(item.getItemQty().multiply(new BigDecimal(1)));    
			}
    		stockMasterService.workUpdateOutgoinItem(item,returnQty);
		}		
		
    	save(item);
    }

    
    //작업지시 마스터 단건 조회
    public WorkOrderOutgoingItem getMasterOne(String company, String wlotNo, Long woSeq) {
		BooleanBuilder builder = new BooleanBuilder();

       	builder.and(qWorkOrderOutgoingItem.company.eq(company));
       	builder.and(qWorkOrderOutgoingItem.wlotNo.eq(wlotNo));
       	builder.and(qWorkOrderOutgoingItem.woSeq.eq(woSeq));
       	
		return select().from(qWorkOrderOutgoingItem).where(builder).fetchOne();
    }
    
    
    // MES > 자재출고
    @Transactional 
    public void saveWorkOrderOutgoingItems(List<WorkOrderOutgoingItem> list) {    	

    	if(isNotEmpty(list)){
	    	for (WorkOrderOutgoingItem m : list) {

				m.setBomItemQty(m.getItemQty());    	
				
	    		if(isEmpty(m.getDiscardYn())){
	    			m.setDiscardYn("N");
	    		}
	    		
	    		//신규
	    		if(null==m.getWoSeq()){
	    			Long woSeq = select().select(qWorkOrderOutgoingItem.woSeq.max()).distinct()
	    					.from(qWorkOrderOutgoingItem)
	    					.where(qWorkOrderOutgoingItem.wlotNo.eq(m.getWlotNo())).fetchOne();
	    			
	    			if(null==woSeq){
	    				woSeq = new Long(1);
	    			}else{
	    				woSeq = woSeq + new Long(1);
	    			}    			
	        		
	    			if(!m.getUnit().equals(m.getBomUnit())){
	        			m.setItemQty(m.getBomItemQty().divide(m.getBomTrans(), 5, BigDecimal.ROUND_UP));    
	    			}else{
	    				m.setItemQty(m.getBomItemQty());
	    			}
	    			
	    			m.setWoSeq(woSeq);    			
	        		m = stockMasterService.workOutgoinItem(m);
	    		}
				
		    	save(m);
	    	}
    	}

    		
    }    
    
    //MES >> 자재환입
    @Transactional
    public void saveWorkOrderReturnItems(List<WorkOrderOutgoingItem> list) {    	
		//신규
    	if(isNotEmpty(list)){
	    	for (WorkOrderOutgoingItem m : list) {

	    		if(null!=m.getWoSeq()){

	    			WorkOrderOutgoingItem i = getMasterOne(m.getCompany(),m.getWlotNo(), m.getWoSeq());
	    			
	    			BigDecimal returnQty = new BigDecimal(0);
	    			
	    			if(null != m){
	    				returnQty = i.getItemQty().subtract(m.getItemQty());
	    			}
	    			
	    			if(!m.getUnit().equals(m.getBomUnit())){
	        			m.setItemQty(m.getItemQty().subtract(m.getBomItemQty().divide(m.getBomTrans(), 5, BigDecimal.ROUND_UP)));    
	        			m.setBomItemQty(m.getItemQty().multiply(m.getBomTrans()));    
	    			}else{
	    				m.setItemQty(m.getItemQty().subtract(m.getBomItemQty()));
	        			m.setBomItemQty(m.getItemQty().multiply(new BigDecimal(1)));    
	    			}
	        		stockMasterService.workUpdateOutgoinItem(m,returnQty);
	    		}		
	    		
	        	save(m);
	    	}
    	}
    }
    
    //MES > 자재사용 JJY
    @Transactional
    public void saveWorkOrderConsumUseItem(List<WorkOrderOutgoingItem> list) {  
    	
    	if(isNotEmpty(list)){
	    	for (WorkOrderOutgoingItem m : list) {
	    		
				m.setBomItemQty(m.getItemQty());    
				    			
    			if(!m.getUnit().equals(m.getBomUnit())){
        			m.setItemQty(m.getBomItemQty().divide(m.getBomTrans(), 5, BigDecimal.ROUND_UP));    
    			}else{
    				m.setItemQty(m.getBomItemQty());
    			}
    			
	    		//신규
	    		if(null==m.getWoSeq()){
	    			Long woSeq = select().select(qWorkOrderOutgoingItem.woSeq.max()).distinct()
	    					.from(qWorkOrderOutgoingItem)
	    					.where(qWorkOrderOutgoingItem.wlotNo.eq(m.getWlotNo())).fetchOne();
	    			
	    			if(null==woSeq){
	    				woSeq = new Long(1);
	    			}else{
	    				woSeq = woSeq + new Long(1);
	    			}
	    			m.setWoSeq(woSeq);
	        		stockMasterService.workConsumUseItem(m);
	    		} 
	    		
	    		if(isEmpty(m.getDiscardYn())){
	    			m.setDiscardYn("N");
	    		}

		    	save(m);
	        }
	    	
    	}
    }    

    //MES > 자재사용 > 환입 JJY
    @Transactional
    public void saveWorkOrderReturnConsumUseItem(List<WorkOrderOutgoingItem> list) {   
    	if(isNotEmpty(list)){
        	for (WorkOrderOutgoingItem m : list) {    			    	
        		if(null != m.getWoSeq()){
        			
        			BigDecimal itemQty = m.getItemQty();
        			
        			m.setItemQty(m.getBomItemQty().divide(m.getBomTrans(), 5, BigDecimal.ROUND_UP));
        			System.out.println("######## m.getItemQty() :" + m.getItemQty());
        			
        			// 환입시 환입수량 계산하여 itemQty에 넣어서 넘겨줌(insert)
        			stockMasterService.workUpdateConsumUseItem(m);  
        			
        			// 재고 update시 원래 itemQty를 가지고 계산
        			m.setItemQty(itemQty);
        			if(!m.getUnit().equals(m.getBomUnit())){
            			m.setItemQty(m.getItemQty().subtract(m.getBomItemQty().divide(m.getBomTrans(), 5, BigDecimal.ROUND_UP)));    
            			m.setBomItemQty(m.getItemQty().multiply(m.getBomTrans()));    
        			}else{
        				m.setItemQty(m.getItemQty().subtract(m.getBomItemQty()));
            			m.setBomItemQty(m.getItemQty().multiply(new BigDecimal(1)));    
        			}
        			
        			System.out.println("######## m.getItemQty() :" + m.getItemQty());
        			System.out.println("######## m.getBomItemQty() :" + m.getBomItemQty());
        			
        			
               	 	BooleanBuilder builder = new BooleanBuilder();
        			builder.and(qWorkOrderOutgoingItem.wlotNo.eq(m.getWlotNo()));
        			builder.and(qWorkOrderOutgoingItem.woSeq.eq(m.getWoSeq()));
        			
        	    	update(qWorkOrderOutgoingItem)
			    		.set(qWorkOrderOutgoingItem.bomItemQty, m.getBomItemQty())    		    	
			    		.set(qWorkOrderOutgoingItem.itemQty, m.getItemQty())    		    	
        		    	.set(qWorkOrderOutgoingItem.updatedAt, Instant.now(Clock.systemUTC()))
        		    	.set(qWorkOrderOutgoingItem.updatedBy, SessionUtils.getCurrentLoginUserCd())
        		    	.where(builder).execute();    
        	    	
        		}
            }
    	}
    }    

	//실적번호가 있을경우, 작업종료시 해당 로뜨 사용여부 항목 N 처리.
    @Transactional
    public void saveWorkOrderItem(WorkOrderMaster m) {    
    	if(null != m){	
	    	//실적번호가 있을경우, 작업종료시 해당 로뜨 사용여부 항목 N 처리.
	    	if(isNotEmpty(m.getWlotNo())){
	        	stockMasterService.updatePrdUseYn(m.getStockCd(),"N");
	    	}
    	}
    }

    //MES_POP > 자동선출자재 선입선출처리. :: TEST
    @Transactional
    public void saveAutoFifoItem(String wlotNo, BigDecimal inQty) {
    	WorkOrderMaster m = workOrderMasterService.getMasterOne(wlotNo);
    	if(null != m){
            RequestParams<StockListVO> p1 = new RequestParams<>(StockListVO.class);        
            p1.put("company", m.getCompany());
            p1.put("wlotNo", m.getWlotNo());
            p1.put("routCd", m.getRoutCd());
            p1.put("routSeq", m.getRoutSeq());
            p1.put("autoFifoYn", "Y");
            List<StockListVO> bomList = popMapper.getStockBomList(p1);

        	if(isNotEmpty(bomList))
        	{
            	for (StockListVO b : bomList) {

                    RequestParams<StockMasterVO> p2 = new RequestParams<>(StockMasterVO.class);
                    p2.put("company", b.getCompany());
                    p2.put("itemCd", b.getItemCd());
                    

                	//로뜨투입인 자재일 경우에는 공정코드 조건 추가
                	if(b.getWipYn().equals("Y")){
                        p2.put("routCd", b.getRoutCd());
                	}
                	
                    p2.put("groupByType", "barcode");
                    p2.put("zeroStock", "N");
                    p2.put("prdUseYn", "N");
                    
                	BigDecimal sumQty = inQty.multiply(b.getReqQty());	//출고수량
                	BigDecimal nowQty = new BigDecimal(0);
                	BigDecimal itemQty = new BigDecimal(0);
                	
                    List<StockMasterVO> stocks = stockMasterService.stockGroupByAll(p2) ;
                    
                	List<WorkOrderOutgoingItem> outList = new ArrayList<WorkOrderOutgoingItem>();

                	if(isNotEmpty(stocks))
                	{
                    	for (StockMasterVO s : stocks) {

            				WorkOrderOutgoingItem o = new WorkOrderOutgoingItem();
            				o.setCompany(s.getCompany());
            				o.setWlotNo(wlotNo);
            				o.setStockCd(s.getStockCd());
            				o.setItemCd(s.getItemCd());
            				o.setUnit(s.getUnit());
            				o.setBomUnit(s.getBomUnit());
            				o.setBomTrans(s.getBomTrans());
            				o.setDiscardYn("N");				
            				
            				nowQty = s.getTransStockQty();
                    		
                    		//sum이 클경우
                			if (sumQty.compareTo(nowQty) == 1) {
                				itemQty = nowQty;
                				sumQty = sumQty.subtract(nowQty);

                				o.setBomItemQty(itemQty);
                				o.setItemQty(itemQty);
                				outList.add(o);
                			}else if (sumQty.compareTo(new BigDecimal(0)) == 1 && nowQty.compareTo(sumQty) >= 0){
                				
                				itemQty = sumQty;
                				o.setBomItemQty(itemQty);
                				o.setItemQty(itemQty);
                				outList.add(o);
                				break;
                			}else{
                				break;
                			}
                    	}
                    	saveWorkOrderOutgoingItems(outList);
                	}
            	}
        	}
    	}
    }
}  