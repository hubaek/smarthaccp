package com.ppm.mes.domain.haccp.temp.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpTempMasterRepository extends AXBootJPAQueryDSLRepository<HaccpTempMaster, HaccpTempMaster.HaccpTempMasterId> {

}
