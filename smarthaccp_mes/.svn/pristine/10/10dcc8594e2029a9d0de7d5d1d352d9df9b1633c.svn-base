package com.ppm.mes.domain.wo.wo110;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.utils.CommonUtil;
import com.ppm.mes.utils.SessionUtils;
import com.querydsl.core.BooleanBuilder;

@Service
public class WorkManManageService extends BaseService<WorkManManage, WorkManManage.WorkManManageId> {
 
	private WorkManManageRepository repository;
    
    @Inject
    public WorkManManageService(WorkManManageRepository repository) {
        super(repository);
        this.repository = repository;
    }   
    
    public List<WorkManManage> get(RequestParams<WorkManManage> requestParams) {
		BooleanBuilder builder = new BooleanBuilder();

    	String wlotNo = requestParams.getString("wlotNo", "");
    	
		if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkManManage.wlotNo.eq(wlotNo));
	    }
				
		return select().from(qWorkManManage).where(builder).orderBy(qWorkManManage.userSeq.desc()).fetch();
    }

    // MES > 생산실적수정 > 작업자등록
    @Transactional
    public void savePrdWorkMan(List<WorkManManage> mans) {        
        if(isNotEmpty(mans)){
        	for (WorkManManage m : mans) {
        		if(null==m.getUserSeq()){
        			Long userSeq = select().select(qWorkManManage.userSeq.max()).distinct()
        					.from(qWorkManManage)
        					.where(qWorkManManage.wlotNo.eq(m.getWlotNo())).fetchOne();    			  
        			
        			if(null==userSeq){
        				userSeq = new Long(1);
        			}else{
        				userSeq = userSeq + new Long(1);
        			}
        			m.setUserSeq(userSeq);
        		}
    			m.setWrkSecond("00");
    			m.setWrkedSecond("00");
    			
    		    String wrkDtmString = m.getWrkDt() + " " + m.getWrkHour() + ":" + m.getWrkMinute() + ":00";  
    		    String wrkedDtmString = m.getWrkedDt() + " " + m.getWrkedHour() + ":" + m.getWrkedMinute() + ":00";  
    			m.setWrkDtm(CommonUtil.stringToInstant(wrkDtmString));    	
    			m.setWrkedDtm(CommonUtil.stringToInstant(wrkedDtmString));    
    			m.setWrkSt("END");	
        		save(m);
            }
        }
    }

    // POP > 작업자저장
    @Transactional
    public void saveWorkMan(List<WorkManManage> mans) {
    	Date nowTime = new Date();        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String wrkDt = sdf.format(nowTime);        

		sdf = new SimpleDateFormat("HH");
        String wrkHour = sdf.format(nowTime);

		sdf = new SimpleDateFormat("mm");
        String wrkMinute = sdf.format(nowTime);

		sdf = new SimpleDateFormat("ss");
        String wrkSecond = sdf.format(nowTime);
        
        if(isNotEmpty(mans)){
        	for (WorkManManage m : mans) {
    			Long userSeq = select().select(qWorkManManage.userSeq.max()).distinct()
    					.from(qWorkManManage)
    					.where(qWorkManManage.wlotNo.eq(m.getWlotNo())).fetchOne();    			  
    			
    			if(null==userSeq){
    				userSeq = new Long(1);
    			}else{
    				userSeq = userSeq + new Long(1);
    			}
    			m.setWrkDt(wrkDt);
    			m.setWrkHour(wrkHour);
    			m.setWrkMinute(wrkMinute);
    			m.setWrkSecond(wrkSecond);
    			m.setWrkDtm(nowTime.toInstant());    			
    			m.setUserSeq(userSeq);		
    			m.setProdQty(new BigDecimal(0));
    			m.setWrkSt("RUN");
        		save(m);
            }
        }
    }

    

    // POP > 작업종료 > 작업자저장 (특정작업자)
    @Transactional
    public void endWorkMan(WorkManManage master){
    	
    	String wlotNo = master.getWlotNo();
    	Long userSeq = master.getUserSeq();	    	
    	
		BooleanBuilder builder = new BooleanBuilder();
		
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkManManage.wlotNo.eq(wlotNo));
	    }

		if (0 != userSeq) {
	       	builder.and(qWorkManManage.userSeq.eq(userSeq));
	    }
		

       	builder.and(qWorkManManage.wrkSt.eq("RUN"));

        Date nowTime = new Date();        
        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String wrkedDt = sdf.format(nowTime);                

		sdf = new SimpleDateFormat("HH");
        String wrkedHour = sdf.format(nowTime);

		sdf = new SimpleDateFormat("mm");
        String wrkedMinute = sdf.format(nowTime);

		sdf = new SimpleDateFormat("ss");
        String wrkedSecond = sdf.format(nowTime);
        
    	update(qWorkManManage)
    	.set(qWorkManManage.wrkedDt,wrkedDt)
    	.set(qWorkManManage.wrkedHour,wrkedHour)
    	.set(qWorkManManage.wrkedMinute,wrkedMinute)
    	.set(qWorkManManage.wrkedSecond,wrkedSecond)
    	.set(qWorkManManage.wrkedDtm,nowTime.toInstant())
    	.set(qWorkManManage.wrkSt,"END")
    	.set(qWorkManManage.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkManManage.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();
    }
    

    // POP > 작업종료 > 작업자저장 (작업자 전체)
    @Transactional
    public void updateEndWorkMan(WorkOrderMaster master){
    	
    	String wlotNo = master.getWlotNo();    	
		BooleanBuilder builder = new BooleanBuilder();
		
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkManManage.wlotNo.eq(wlotNo));
	    }
    	
       	builder.and(qWorkManManage.wrkSt.eq("RUN"));
    	
        Date nowTime = new Date();        
        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String wrkedDt = sdf.format(nowTime);        
        
        sdf = new SimpleDateFormat("HH");
        String wrkedHour = sdf.format(nowTime);

		sdf = new SimpleDateFormat("mm");
        String wrkedMinute = sdf.format(nowTime);

		sdf = new SimpleDateFormat("ss");
        String wrkedSecond = sdf.format(nowTime); 
        
    	update(qWorkManManage)
    	.set(qWorkManManage.wrkedDt,wrkedDt)
    	.set(qWorkManManage.wrkedHour,wrkedHour)
    	.set(qWorkManManage.wrkedMinute,wrkedMinute)
    	.set(qWorkManManage.wrkedSecond,wrkedSecond)
    	.set(qWorkManManage.wrkedDtm,nowTime.toInstant())
    	.set(qWorkManManage.wrkSt,"END")
    	.set(qWorkManManage.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkManManage.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();
    	
    	
    }
    

    // POP > 생산품입고 > 작업자별 생산수량 업데이트
    @Transactional
    public void updateManProdQty(String wlotNo ,BigDecimal prodQty) {

    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkManManage.wlotNo.eq(wlotNo));
	    }    	
       	builder.and(qWorkManManage.wrkSt.eq("RUN"));  
    	update(qWorkManManage)
    	.set(qWorkManManage.prodQty, qWorkManManage.prodQty.add(prodQty))
    	.set(qWorkManManage.updatedAt, Instant.now(Clock.systemUTC()))
    	.set(qWorkManManage.updatedBy, SessionUtils.getCurrentLoginUserCd())
    	.where(builder).execute();
    	
    }
}