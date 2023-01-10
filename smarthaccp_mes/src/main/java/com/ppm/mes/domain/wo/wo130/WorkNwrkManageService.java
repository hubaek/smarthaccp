package com.ppm.mes.domain.wo.wo130;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.utils.CommonUtil;
import com.querydsl.core.BooleanBuilder;

@Service
public class WorkNwrkManageService extends BaseService<WorkNwrkManage, WorkNwrkManage.WorkNwrkManageId> {
    private WorkNwrkManageRepository repository;
        
    @Inject
    public WorkNwrkManageService(WorkNwrkManageRepository repository) {
        super(repository);
        this.repository = repository;
    }   
    
    //현장 비가동 상태 변경
    @Transactional
    public void updateWorkNwrk(WorkOrderMaster vo) {

    	BooleanBuilder builder = new BooleanBuilder();

    	String wlotNo = vo.getWlotNo();
    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkNwrkManage.wlotNo.eq(wlotNo));
	    }
    	
       	builder.and(qWorkNwrkManage.nwrkedDtm.isNull());       	
       	
       	Date nowTime = new Date();        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nwrkedDt = sdf.format(nowTime);        

		sdf = new SimpleDateFormat("HH");
        String nwrkedHour = sdf.format(nowTime);

		sdf = new SimpleDateFormat("mm");
        String nwrkedMinute = sdf.format(nowTime);

		sdf = new SimpleDateFormat("ss");
        String nwrkedSecond = sdf.format(nowTime);
                
    	update(qWorkNwrkManage)
    	.set(qWorkNwrkManage.nwrkedDt, nwrkedDt)
    	.set(qWorkNwrkManage.nwrkedHour, nwrkedHour)
    	.set(qWorkNwrkManage.nwrkedMinute, nwrkedMinute)
    	.set(qWorkNwrkManage.nwrkedSecond, nwrkedSecond)
    	.set(qWorkNwrkManage.nwrkedDtm, nowTime.toInstant())    	
    	.set(qWorkNwrkManage.lastYn, "N")
    	.where(builder).execute();
    	
    } 

    // MES > 생산실적수정 > 비가동등록
    @Transactional
    public void savePrdWorkNwrk(List<WorkNwrkManage> nwrk) {        

    	Date nowTime = new Date();        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nwrkDt = sdf.format(nowTime);        
        
        if(isNotEmpty(nwrk)){
        	for (WorkNwrkManage m : nwrk) {
        		if(null==m.getNwrkSeq()){
        			Long nwrkSeq = select().select(qWorkNwrkManage.nwrkSeq.max()).distinct()
        					.from(qWorkNwrkManage)
        					.where(qWorkNwrkManage.nwrkDt.eq(nwrkDt)).fetchOne();
        			
        			if(null==nwrkSeq){
        				nwrkSeq = new Long(1);
        			}else{
        				nwrkSeq = nwrkSeq + new Long(1);
        			}
        			m.setNwrkSeq(nwrkSeq);
        		}

    			m.setNwrkSecond("00");
    			m.setNwrkedSecond("00");
    			
    		    String nwrkDtmString = m.getNwrkDt() + " " + m.getNwrkHour() + ":" + m.getNwrkMinute() + ":00";  
    		    String nwrkedDtmString = m.getNwrkedDt() + " " + m.getNwrkedHour() + ":" + m.getNwrkedMinute() + ":00";  

    			m.setNwrkDtm(CommonUtil.stringToInstant(nwrkDtmString));    	
    			m.setNwrkedDtm(CommonUtil.stringToInstant(nwrkedDtmString));    
        		save(m);
            }
        }
    }
    
    // POP > 비가동등록
    @Transactional
    public void saveWorkNwrk(WorkNwrkManage item) {

    	Date nowTime = new Date();        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nwrkDt = sdf.format(nowTime);        

		sdf = new SimpleDateFormat("HH");
        String nwrkHour = sdf.format(nowTime);

		sdf = new SimpleDateFormat("mm");
        String nwrkMinute = sdf.format(nowTime);

		sdf = new SimpleDateFormat("ss");
        String nwrkSecond = sdf.format(nowTime);
                
    	if (null != item) {
    		if(null==item.getNwrkSeq()){
    			Long nwrkSeq = select().select(qWorkNwrkManage.nwrkSeq.max()).distinct()
    					.from(qWorkNwrkManage)
    					.where(qWorkNwrkManage.nwrkDt.eq(nwrkDt)).fetchOne();
    			  
    			
    			if(null==nwrkSeq){
    				nwrkSeq = new Long(1);
    			}else{
    				nwrkSeq = nwrkSeq + new Long(1);
    			}
    			item.setNwrkDt(nwrkDt);
    			item.setNwrkHour(nwrkHour);
    			item.setNwrkMinute(nwrkMinute);
    			item.setNwrkSecond(nwrkSecond);
    			item.setNwrkDtm(nowTime.toInstant());
    			item.setNwrkSeq(nwrkSeq);
    			item.setLastYn("Y");
    		}     		
    		save(item);
        }
    }
}