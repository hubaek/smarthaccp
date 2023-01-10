package com.ppm.mes.domain.selfHygine.code;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface SelfHygineMasterRepository extends AXBootJPAQueryDSLRepository<SelfHygineMaster, SelfHygineMaster.SelfHygineMasterId>  {
	
}
