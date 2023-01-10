package com.ppm.mes.domain.haccp.code.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
 
@Repository												
public interface HaccpCodeMasterRepository extends AXBootJPAQueryDSLRepository<HaccpCodeMaster, HaccpCodeMaster.HaccpCodeMasterId> {

}