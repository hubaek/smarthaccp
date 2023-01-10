package com.ppm.mes.domain.rt.rt100;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
 
@Service
public class RoutingMasterService extends BaseService <RoutingMaster,RoutingMaster.RoutingMasterId>{
	
    private RoutingMasterRepository repository;
    
    @Inject
    public RoutingMasterService(RoutingMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    @Inject private RoutingMasterMapper routingMasterMapper;
    
    public List<RoutingMaster> getRoutingList(RequestParams<RoutingMaster> master) {  
    	return routingMasterMapper.getRoutingList(master);
    }
    
    //라우팅 저장
    @Transactional
    public void saveRouting(RoutingMaster master) {
 		save(master);
    }    
}