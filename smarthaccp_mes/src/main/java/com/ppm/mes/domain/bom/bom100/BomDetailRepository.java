package com.ppm.mes.domain.bom.bom100;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface BomDetailRepository extends AXBootJPAQueryDSLRepository<BomDetail, BomDetail.BomDetailId> {
}
