package com.ppm.mes.domain.haccp.heat.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpHeatMasterRepository extends AXBootJPAQueryDSLRepository<HaccpHeatMaster, HaccpHeatMaster.HaccpHeatMasterId>{

}
