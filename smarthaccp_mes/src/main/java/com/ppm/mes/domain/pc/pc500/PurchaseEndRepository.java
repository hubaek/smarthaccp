package com.ppm.mes.domain.pc.pc500;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface PurchaseEndRepository extends AXBootJPAQueryDSLRepository<PurchaseEnd, PurchaseEnd.PurchaseEndId> {
}
