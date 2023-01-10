package com.ppm.mes.domain.haccp.clean.detail;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpCleanDetailRepository extends AXBootJPAQueryDSLRepository<HaccpCleanDetail, HaccpCleanDetail.HaccpCleanDetailId> {

}
