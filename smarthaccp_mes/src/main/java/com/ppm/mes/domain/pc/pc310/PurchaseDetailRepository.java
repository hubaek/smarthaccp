package com.ppm.mes.domain.pc.pc310;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository 
public interface PurchaseDetailRepository extends AXBootJPAQueryDSLRepository<PurchaseDetail, PurchaseDetail.PurchaseDetailId> {
}
