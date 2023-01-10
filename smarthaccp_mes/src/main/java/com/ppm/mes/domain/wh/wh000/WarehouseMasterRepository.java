package com.ppm.mes.domain.wh.wh000;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
  
@Repository											
public interface WarehouseMasterRepository extends AXBootJPAQueryDSLRepository<WarehouseMaster,WarehouseMaster.WarehouseMasterId> {
}        