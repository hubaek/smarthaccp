package com.ppm.mes.domain.key.system;


import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface SystemKeyManagementRepository extends AXBootJPAQueryDSLRepository<SystemKeyManagement, SystemKeyManagement.SystemKeyManagementId> {
}
   