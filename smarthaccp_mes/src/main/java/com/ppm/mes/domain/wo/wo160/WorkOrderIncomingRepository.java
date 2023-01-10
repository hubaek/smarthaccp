package com.ppm.mes.domain.wo.wo160;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface WorkOrderIncomingRepository extends AXBootJPAQueryDSLRepository<WorkOrderIncoming, WorkOrderIncoming.WorkOrderIncomingId> {
}
