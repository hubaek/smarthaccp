package com.ppm.mes.domain.cd.cd000;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
 
@Repository												
public interface BasicCodeMasterRepository extends AXBootJPAQueryDSLRepository<BasicCodeMaster, BasicCodeMaster.BasicCodeMasterId> {

}