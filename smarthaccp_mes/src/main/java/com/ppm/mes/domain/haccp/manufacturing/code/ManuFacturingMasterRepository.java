package com.ppm.mes.domain.haccp.manufacturing.code;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface ManuFacturingMasterRepository extends AXBootJPAQueryDSLRepository<ManuFacturingMaster, ManuFacturingMaster.ManuFacturingMasterId>  {
	
}
