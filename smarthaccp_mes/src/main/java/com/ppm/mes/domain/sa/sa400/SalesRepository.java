package com.ppm.mes.domain.sa.sa400;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface SalesRepository extends AXBootJPAQueryDSLRepository<Sales, Sales.SalesId> {
}
