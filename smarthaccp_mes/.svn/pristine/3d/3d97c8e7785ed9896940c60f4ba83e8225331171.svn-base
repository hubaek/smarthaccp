package com.ppm.mes.domain.rt.rt200;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ppm.mes.domain.BaseService;
 
@Service
public class RoutManService extends BaseService <RoutMan,RoutMan.RoutManId>{
	
    private RoutManRepository repository;
    
    @Inject
    public RoutManService(RoutManRepository repository) {
        super(repository);
        this.repository = repository;
    }
}