package com.ppm.mes.domain.key.work;


import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface WorkKeyManagementRepository extends AXBootJPAQueryDSLRepository<WorkKeyManagement, WorkKeyManagement.WorkKeyManagementId> {
}
  