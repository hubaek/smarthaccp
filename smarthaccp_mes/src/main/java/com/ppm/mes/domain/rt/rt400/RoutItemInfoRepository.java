package com.ppm.mes.domain.rt.rt400;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
  
@Repository											
public interface RoutItemInfoRepository extends AXBootJPAQueryDSLRepository<RoutItemInfo,RoutItemInfo.RoutItemInfoId> {
}        