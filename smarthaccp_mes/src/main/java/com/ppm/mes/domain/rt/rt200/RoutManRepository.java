package com.ppm.mes.domain.rt.rt200;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
  
@Repository											
public interface RoutManRepository extends AXBootJPAQueryDSLRepository<RoutMan,RoutMan.RoutManId> {
}        