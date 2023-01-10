package com.ppm.mes.domain.haccp.car.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpCarMasterRepository extends AXBootJPAQueryDSLRepository<HaccpCarMaster, HaccpCarMaster.HaccpCarMasterId> {

}
