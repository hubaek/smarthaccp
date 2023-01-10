package com.ppm.mes.domain.pc.pc210;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository 
public interface PurchaseOrderDetailRepository extends AXBootJPAQueryDSLRepository<PurchaseOrderDetail, PurchaseOrderDetail.PurchaseOrderDetailId> {
}
