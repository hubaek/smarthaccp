package com.ppm.mes.domain.haccp.tank.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpTankMasterRepository extends AXBootJPAQueryDSLRepository<HaccpTankMaster, HaccpTankMaster.HaccpTankMasterId>{

}
