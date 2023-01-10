package com.ppm.mes.domain.rt.rt400;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ppm.mes.domain.BaseService;
 
@Service
public class RoutItemInfoService extends BaseService <RoutItemInfo,RoutItemInfo.RoutItemInfoId>{
	private RoutItemInfoRepository repository;
    @Inject
    public RoutItemInfoService(RoutItemInfoRepository repository) {
        super(repository);
        this.repository = repository;
    }
}