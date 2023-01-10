package com.ppm.mes.domain.bom.bom000;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface BomMasterRepository extends AXBootJPAQueryDSLRepository<BomMaster, BomMaster.BomMasterId> {
}
