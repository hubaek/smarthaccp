package com.ppm.mes.domain.haccp.clean.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpCleanMasterRepository extends AXBootJPAQueryDSLRepository<HaccpCleanMaster, HaccpCleanMaster.HaccpCleanMasterId> {

}
