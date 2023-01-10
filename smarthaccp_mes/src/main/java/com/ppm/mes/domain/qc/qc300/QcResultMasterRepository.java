package com.ppm.mes.domain.qc.qc300;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
 
@Repository
public interface QcResultMasterRepository extends AXBootJPAQueryDSLRepository<QcResultMaster, QcResultMaster.QcResultMasterId> {
}
