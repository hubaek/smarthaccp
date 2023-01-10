package com.ppm.mes.domain.qc.qc000;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository 
public interface QcMasterRepository extends AXBootJPAQueryDSLRepository<QcMaster, QcMaster.QcMasterId> {
}
