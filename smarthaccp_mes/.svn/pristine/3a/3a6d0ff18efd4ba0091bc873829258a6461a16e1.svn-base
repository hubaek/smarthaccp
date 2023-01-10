package com.ppm.mes.domain.report;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class DailyReport000Service extends BaseService<DailyReport000, DailyReport000.DailyReport000Id> {
    private DailyReport000Repository dailyReport000Repository;

    @Inject
    public DailyReport000Service(DailyReport000Repository dailyReport000Repository) {
        super(dailyReport000Repository);
        this.dailyReport000Repository = dailyReport000Repository;
    }
    
    public DailyReport000 recentlyTemplate(RequestParams<DailyReport000> requestParams){
    	String company = requestParams.getString("company");
    	String templateId = requestParams.getString("templateId");
    	String typeCd = requestParams.getString("typeCd");
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if(isNotEmpty(company)){
    		builder.and(qDailyReport000.company.eq(company));
    	}
    	if(isNotEmpty(templateId)){
    		builder.and(qDailyReport000.templateId.eq(templateId));
    	}
    	if(isNotEmpty(typeCd)){
    		builder.and(qDailyReport000.typeCd.eq(typeCd));
    	}
    	
    	//select().from(qDailyReport000).where(builder).orderBy(qDailyReport000.startDate.desc()).fetchFirst();
    	
    	return select().from(qDailyReport000).where(builder).orderBy(qDailyReport000.startDate.desc()).fetchFirst();
    }

    public List<DailyReport000> gets(RequestParams<DailyReport000> requestParams) {
    	
    	String company = requestParams.getString("company");
    	String templateId = requestParams.getString("templateId");
    	String startDate = requestParams.getString("startDate");
    	String typeCd = requestParams.getString("typeCd");
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if(isNotEmpty(company)){
    		builder.and(qDailyReport000.company.eq(company));
    	}
    	
    	if(isNotEmpty(templateId)){
    		builder.and(qDailyReport000.templateId.eq(templateId));
    	}
    	
    	if(isNotEmpty(startDate)){
    		builder.and(qDailyReport000.startDate.eq(startDate));
    	}
    	
    	if(isNotEmpty(typeCd)){
    		builder.and(qDailyReport000.typeCd.eq(typeCd));
    	}
    	
    	
    	List<DailyReport000> list = select().from(qDailyReport000).where(builder).orderBy(qDailyReport000.dSeq.asc()).fetch();
    	
        return list;
    }
    
    @Transactional
    public void saveReport000(List<DailyReport000> list){
    	for(DailyReport000 c: list){
    		Integer dSeq = new Integer(1);
    		
    		BooleanBuilder builder = new BooleanBuilder();
        	
        	
        	builder.and(qDailyReport000.company.eq(c.getCompany()));
        	builder.and(qDailyReport000.templateId.eq(c.getTemplateId()));
        	builder.and(qDailyReport000.startDate.eq(c.getStartDate()));
        	
    		
    		if(null == c.getDSeq()){
    			dSeq = select().select(qDailyReport000.dSeq.max()).distinct()
    					.from(qDailyReport000).where(builder).fetchOne();
    			if(null==dSeq){
    				dSeq = new Integer(1);
    			}else{
    				dSeq = dSeq + new Integer(1);
    			}
    			
    			c.setDSeq(dSeq);
    			
    		}
    		save(c);
    	}
    	
    	
    }
}