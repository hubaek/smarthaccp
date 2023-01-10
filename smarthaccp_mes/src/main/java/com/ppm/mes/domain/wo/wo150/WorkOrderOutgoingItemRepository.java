package com.ppm.mes.domain.wo.wo150;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository 
public interface WorkOrderOutgoingItemRepository extends AXBootJPAQueryDSLRepository<WorkOrderOutgoingItem, WorkOrderOutgoingItem.WorkOrderOutgoingItemId> {
}
