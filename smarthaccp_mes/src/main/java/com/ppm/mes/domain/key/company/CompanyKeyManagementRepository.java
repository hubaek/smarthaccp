package com.ppm.mes.domain.key.company;


import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface CompanyKeyManagementRepository extends AXBootJPAQueryDSLRepository<CompanyKeyManagement, CompanyKeyManagement.CompanyKeyManagementId> {
}
  