package com.ppm.mes.domain.wo.wo120;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterService;
import com.ppm.mes.domain.wo.wo150.WorkOrderOutgoingItemService;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncomingService;
import com.ppm.mes.utils.CommonUtil;
import com.querydsl.core.BooleanBuilder;

@Service
public class WorkOrderBadService extends BaseService<WorkOrderBad, WorkOrderBad.WorkOrderBadId> {
 
	private WorkOrderBadRepository repository;
    
    @Inject private WorkOrderMasterService workOrderMasterService;
    @Inject private WorkOrderIncomingService workOrderIncomingService;
    @Inject private WorkOrderOutgoingItemService workOrderOutgoingItemService;
    
    @Inject
    public WorkOrderBadService(WorkOrderBadRepository repository) {
        super(repository);
        this.repository = repository;
    }   

    public BigDecimal getTotalBadQty(String wlotNo) {
		BooleanBuilder builder = new BooleanBuilder();
		if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderBad.wlotNo.eq(wlotNo));
	    }		
		return select().select(qWorkOrderBad.badQty.sum().coalesce(new BigDecimal(0))).distinct().from(qWorkOrderBad).where(builder).fetchOne();
    }

    //POP > 불량등록
    @Transactional
    public void saveWorkBad(WorkOrderBad m) {

    	String wlotNo = "";
    	Date nowTime = new Date();        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String badDt = sdf.format(nowTime);        
        
		sdf = new SimpleDateFormat("HH");
        String badHour = sdf.format(nowTime);

		sdf = new SimpleDateFormat("mm");
        String badMinute = sdf.format(nowTime);

		sdf = new SimpleDateFormat("ss");
        String badSecond = sdf.format(nowTime);
        
    	if (null != m) {
			Long badSeq = select().select(qWorkOrderBad.badSeq.max()).distinct()
					.from(qWorkOrderBad)
					.where(qWorkOrderBad.badDt.eq(badDt)
							).fetchOne();
			  
			
			if(null==badSeq){
				badSeq = new Long(1);
			}else{
				badSeq = badSeq + new Long(1);
			}    			
			m.setBadDt(badDt);
			m.setBadHour(badHour);
			m.setBadMinute(badMinute);
			m.setBadSecond(badSecond);
			m.setBadDtm(nowTime.toInstant());
			m.setBadSeq(badSeq);	
			wlotNo = m.getWlotNo();		
						
			save(m);

			//오더 마스터 수량 업데이트
	    	BigDecimal prodQty = workOrderMasterService.updateWorkProdQty(wlotNo);

        }
    }

    //POP > 불량취소
    @Transactional
    public void cancelWorkBad(WorkOrderBad m) {
    	if (null != m) {
            delete(qWorkOrderBad).where(qWorkOrderBad.badDt.eq(m.getBadDt()).and(qWorkOrderBad.badSeq.eq(m.getBadSeq()))).execute();
			//오더 마스터 수량 업데이트
            BigDecimal prodQty = workOrderMasterService.updateWorkProdQty(m.getWlotNo());
        }
    }
    

    //MES > 불량등록 (실적 수정)
    @Transactional
    public void savePrdWorkBad(WorkOrderBadRequestVO request) {
    	String wlotNo = request.getWlotNo();
    	List<WorkOrderBad> bads = request.getBads();
        if(isNotEmpty(bads)){
        	//마스터 정보 가져오기        	
            
            WorkOrderMaster master =  workOrderMasterService.getMasterOne(wlotNo);
            BigDecimal itemQty = new BigDecimal(0);
            
        	for (WorkOrderBad m : bads) {
    			itemQty = m.getBadQty();    			
        		if(m.isDeleted()){
                    //workOrderIncomingService.saveIncomingItem(master.getWlotNo() , itemQty ,"BC");
        		}else{
        			if(null==m.getBadSeq()){
            			Long badSeq = select().select(qWorkOrderBad.badSeq.max()).distinct()
            					.from(qWorkOrderBad)
            					.where(qWorkOrderBad.badDt.eq(m.getBadDt())
            							).fetchOne();  
            			
            			if(null==badSeq){
            				badSeq = new Long(1);
            			}else{
            				badSeq = badSeq + new Long(1);
            			}
            			m.setBadSeq(badSeq);
            		}

        			m.setBadSecond("00");
        		    String badDtmString = m.getBadDt() + " " + m.getBadHour() + ":" + m.getBadMinute() + ":00";  
        			m.setBadDtm(CommonUtil.stringToInstant(badDtmString));    	

            		save(m);    	 
        		}
            }        		

			//오더 마스터 수량 업데이트
	    	workOrderMasterService.updateWorkProdQty(master.getWlotNo());
        }
    }
    
    //MES > 불량취소 (실적 수정)
    @Transactional
    public void cancelPrdWorkBad(WorkOrderBadRequestVO request) {
    	List<WorkOrderBad> bads = request.getBads();
        if(isNotEmpty(bads)){
        	for (WorkOrderBad m : bads) {
        		delete(qWorkOrderBad).where(qWorkOrderBad.badDt.eq(m.getBadDt()).and(qWorkOrderBad.badSeq.eq(m.getBadSeq()))).execute();
        		
    			//오더 마스터 수량 업데이트
    	    	workOrderMasterService.updateWorkProdQty(m.getWlotNo());
            }        		
        }
    }
}