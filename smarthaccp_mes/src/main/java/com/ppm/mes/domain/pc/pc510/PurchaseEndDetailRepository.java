package com.ppm.mes.domain.pc.pc510;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository 
public interface PurchaseEndDetailRepository extends AXBootJPAQueryDSLRepository<PurchaseEndDetail, PurchaseEndDetail.PurchaseEndItemDetailId> {
}
