package com.ppm.mes.domain.rt.rt500;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
  
@Repository											
public interface RoutNwrkRepository extends AXBootJPAQueryDSLRepository<RoutNwrk,RoutNwrk.RoutNwrkId> {
}        