package com.ppm.mes.domain.haccp.metal.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpMetalMasterRepository extends AXBootJPAQueryDSLRepository<HaccpMetalMaster, HaccpMetalMaster.HaccpMetalMasterId>{

}
