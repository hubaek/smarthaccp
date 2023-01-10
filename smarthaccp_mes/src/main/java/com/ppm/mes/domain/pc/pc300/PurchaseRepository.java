package com.ppm.mes.domain.pc.pc300;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface PurchaseRepository extends AXBootJPAQueryDSLRepository<Purchase, Purchase.PurchaseId> {
}
