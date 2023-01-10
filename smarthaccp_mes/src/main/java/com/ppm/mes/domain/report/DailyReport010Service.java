package com.ppm.mes.domain.report;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.utils.StringUtil;
import com.querydsl.core.BooleanBuilder;

@Service
public class DailyReport010Service extends BaseService<DailyReport010, DailyReport010.DailyReport010Id> {
    private DailyReport010Repository dailyReport010Repository;
    
    @Inject private WorkKeyManagementService workKeyManagementService;

    @Inject
    public DailyReport010Service(DailyReport010Repository dailyReport010Repository) {
        super(dailyReport010Repository);
        this.dailyReport010Repository = dailyReport010Repository;
    }
    
    public boolean duplicateReportDt(RequestParams<DailyReport010> requestParams){
    	
    	String company = requestParams.getString("company");
    	String templateId = requestParams.getString("templateId");
    	String reportDate = requestParams.getString("reportDate");
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if(isNotEmpty(company)){
    		builder.and(qDailyReport010.company.eq(company));
    	}
    	if(isNotEmpty(templateId)){
    		builder.and(qDailyReport010.templateId.eq(templateId));
    	}
    	if(isNotEmpty(reportDate)){
    		builder.and(qDailyReport010.reportDate.eq(reportDate.replaceAll("-", "")));
    	}
    	
    	Long count = select().from(qDailyReport010).where(builder).fetchCount();
    	
    	return count >= 1 ;
    }

    public List<DailyReport010> gets(RequestParams<DailyReport010> requestParams) {
    	String company = requestParams.getString("company");
    	String templateId = requestParams.getString("templateId");
    	String startDate = requestParams.getString("startDate");
    	String reportDate = requestParams.getString("reportDate");
    	String fromDate = requestParams.getString("fromDate");
    	String toDate = requestParams.getString("toDate");
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if(isNotEmpty(company)){
    		builder.and(qDailyReport010.company.eq(company));
    	}
    	
    	if(isNotEmpty(templateId)){
    		builder.and(qDailyReport010.templateId.eq(templateId));
    	}
    	
    	if(isNotEmpty(startDate)){
    		builder.and(qDailyReport010.startDate.eq(startDate));
    	}
    	
    	if(isNotEmpty(fromDate)){
    		builder.and(qDailyReport010.reportDate.between(fromDate.replaceAll("-", ""), toDate.replaceAll("-", "")));
    	}
    	List<DailyReport010> list = select().from(qDailyReport010).where(builder).orderBy(qDailyReport010.mSeq.asc()).fetch();
    	
        return list;
    }
    
    public DailyReport010 getOne(RequestParams<DailyReport010> requestParams) {
    	String company = requestParams.getString("company");
    	String templateId = requestParams.getString("templateId");
    	String startDate = requestParams.getString("startDate");
    	String reportDate = requestParams.getString("reportDate");
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if(isNotEmpty(company)){
    		builder.and(qDailyReport010.company.eq(company));
    	}
    	
    	if(isNotEmpty(templateId)){
    		builder.and(qDailyReport010.templateId.eq(templateId));
    	}
    	
    	if(isNotEmpty(startDate)){
    		builder.and(qDailyReport010.startDate.eq(startDate.replaceAll("-", "")));
    	}
    	
    	if(isNotEmpty(reportDate)){
    		builder.and(qDailyReport010.reportDate.eq(reportDate.replaceAll("-", "")));
    	}
    	
    	DailyReport010 dailyReport010 = select().from(qDailyReport010).where(builder).fetchOne();
    	
    	return dailyReport010;
    }
    
    
    @Transactional
    public void saveReport010(List<DailyReport010> list){
    	for(DailyReport010 c: list){
    		Integer mSeq = new Integer(1);
    		
    		BooleanBuilder builder = new BooleanBuilder();
        	
        	
        	builder.and(qDailyReport010.company.eq(c.getCompany()));
        	builder.and(qDailyReport010.templateId.eq(c.getTemplateId()));
        	builder.and(qDailyReport010.startDate.eq(c.getStartDate()));
        	builder.and(qDailyReport010.reportDate.eq(c.getReportDate().replaceAll("-", "")));
        	
    		
    		if(null == c.getMSeq()){
    			mSeq = select().select(qDailyReport010.mSeq.max()).distinct()
    					.from(qDailyReport010).where(builder).fetchOne();
    			if(null==mSeq){
    				mSeq = new Integer(1);
    			}else{
    				mSeq = mSeq + new Integer(1);
    			}
    			
    			c.setMSeq(mSeq);
    			
    		}
    		//문서의 상태값이 '상신' 일때  결재ID 채번
        	if("20".equals(c.getStatus())){ 
	    		//결재ID 채번
	    		String approvalId = StringUtil.isEmpty(c.getApprovalId()) ? workKeyManagementService.getYymmCode("APPR", "APPR", 5) : c.getApprovalId();
	    		c.setApprovalId(approvalId);
        	}
    		
    		save(c);
    	}
    	
    	
    }
    
}