package com.ppm.mes.domain.qc.qc110;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository 
public interface QcGroupItemRepository extends AXBootJPAQueryDSLRepository<QcGroupItem, QcGroupItem.QcGroupItemId> {
}
