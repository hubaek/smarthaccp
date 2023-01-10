package com.ppm.mes.domain.rt.rt120;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
 
@Service
public class RoutingItemService extends BaseService <RoutingItem,RoutingItem.RoutingItemId>{
	
    private RoutingItemRepository repository;    
    @Inject
    public RoutingItemService(RoutingItemRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    //라우팅 저장
    @Transactional
    public void saveRoutingItem(List<RoutingItem> list) {
 		save(list);
    }    
}