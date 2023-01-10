package com.ppm.mes.domain.rt.rt120;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
  
@Repository											
public interface RoutingItemRepository extends AXBootJPAQueryDSLRepository<RoutingItem,RoutingItem.RoutingItemId> {
}        