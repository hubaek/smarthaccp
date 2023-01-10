package com.ppm.mes.domain.cp.cp000;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface CompanyManagementRepository extends AXBootJPAQueryDSLRepository<CompanyManagement, CompanyManagement.CompanyManagementId> {
    List<CompanyManagement> findByCompany(String company);
}
