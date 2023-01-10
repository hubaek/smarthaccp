package com.ppm.mes.domain.sa.sa410;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository 
public interface SalesDetailRepository extends AXBootJPAQueryDSLRepository<SalesDetail, SalesDetail.SalesDetailId> {
}
