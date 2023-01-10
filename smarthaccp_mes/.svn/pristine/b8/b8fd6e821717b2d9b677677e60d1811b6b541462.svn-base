package com.ppm.mes.domain.report;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

import javax.inject.Inject;
import com.chequer.axboot.core.parameter.RequestParams;
import java.util.List;

@Service
public class DailyReport030Service extends BaseService<DailyReport030, DailyReport030.DailyReport030Id> {
    private DailyReport030Repository dailyReport030Repository;

    @Inject
    public DailyReport030Service(DailyReport030Repository dailyReport030Repository) {
        super(dailyReport030Repository);
        this.dailyReport030Repository = dailyReport030Repository;
    }

    public List<DailyReport030> gets(RequestParams<DailyReport030> requestParams) {
    	
    	String company = requestParams.getString("company");
    	String templateId = requestParams.getString("templateId");
    	String reportDate = requestParams.getString("reportDate");
    	String attribute_1_value = requestParams.getString("attribute_1_value");
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if(isNotEmpty(company)){
    		builder.and(qDailyReport030.company.eq(company));
    	}
    	
    	if(isNotEmpty(templateId)){
    		builder.and(qDailyReport030.templateId.eq(templateId));
    	}
    	
    	if(isNotEmpty(reportDate)){ 
    		builder.and(qDailyReport030.reportDate.eq(reportDate));
    	}
    	
    	if(isNotEmpty(attribute_1_value)){ 
    		builder.and(qDailyReport030.attribute_1_value.eq(attribute_1_value));
    	}
    	
    	List<DailyReport030> list = select().from(qDailyReport030).where(builder).orderBy(qDailyReport030.measure_dtm.asc()).fetch();
    	
        return list;
    }
    
    @Transactional
    public void saveReport030(List<DailyReport030> list){
    	if (isNotEmpty(list)) {  
    		for (DailyReport030 c : list) {
    			BooleanBuilder builder = new BooleanBuilder();
            	
            	builder.and(qDailyReport030.company.eq(c.getCompany()));
            	builder.and(qDailyReport030.templateId.eq(c.getTemplateId()));
            	builder.and(qDailyReport030.reportDate.eq(c.getReportDate()));
            	
        		if(null == c.getSeq()){
        			Integer seq = select().select(qDailyReport030.seq.max()).distinct()
        					.from(qDailyReport030).where(builder).fetchOne();
        					
        			if(null==seq){
        				seq = new Integer(1);  
        			}else{
        				seq = seq + new Integer(1);
        			}
        			c.setSeq(seq);
        		}
            	save(c);
            }
    	}
    }
}