package com.ppm.mes.domain.material;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository		
public interface MaterialMasterRepository extends AXBootJPAQueryDSLRepository<MaterialMaster,MaterialMaster.MaterialMasterId>{

}
