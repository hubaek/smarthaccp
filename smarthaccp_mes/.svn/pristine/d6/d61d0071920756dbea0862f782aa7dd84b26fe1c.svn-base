package com.ppm.mes.domain.health.health000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
 
@Service
public class HealthService extends BaseService <Health,Health.HealthId>{


    private HealthRepository repository;
    @Inject private HealthMapper healthMapper;
    
    @Inject
    public HealthService(HealthRepository repository) {
        super(repository);
        this.repository = repository;
    }

	public List<HealthVO> getHealthList(RequestParams<HealthVO> vo) {
		return healthMapper.getHealthList(vo);
	}

	public void saveHealth(Health h) {
		if (null != h) {  
    		if(null == h.getHealthCardSeq()){
    			Long healthCardSeq = select().select(qHealth.healthCardSeq.max()).distinct()
    					.from(qHealth)
    					.where(qHealth.userCd.eq(h.getUserCd())).fetchOne();
    					
    			if(null==healthCardSeq){
    				healthCardSeq = new Long(1);  
    			}else{
    				healthCardSeq = healthCardSeq + new Long(1);
    			}
    			h.setHealthCardSeq(healthCardSeq);
    		}
        	save(h);
            
    	}
	}

	public List<HealthVO> getAlarmList(RequestParams<Health> params) {
		return healthMapper.getAlarmList(params);
	}
    

}