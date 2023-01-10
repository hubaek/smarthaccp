package com.ppm.mes.domain.haccp.pack.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpPackMasterRepository extends AXBootJPAQueryDSLRepository<HaccpPackMaster, HaccpPackMaster.HaccpPackMasterId>{

}
