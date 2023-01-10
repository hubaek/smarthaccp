package com.ppm.mes.domain.haccp.prod.detail;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpProdDetailRepository extends AXBootJPAQueryDSLRepository<HaccpProdDetail, HaccpProdDetail.HaccpProdDetailId> {

}
