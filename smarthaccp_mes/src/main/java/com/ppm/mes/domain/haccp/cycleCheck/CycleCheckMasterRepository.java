package com.ppm.mes.domain.haccp.cycleCheck;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface CycleCheckMasterRepository extends AXBootJPAQueryDSLRepository<CycleCheckMaster, CycleCheckMaster.CycleCheckMasterId>{

}
