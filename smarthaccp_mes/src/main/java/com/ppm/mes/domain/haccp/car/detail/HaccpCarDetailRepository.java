package com.ppm.mes.domain.haccp.car.detail;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
@Repository
public interface HaccpCarDetailRepository extends AXBootJPAQueryDSLRepository<HaccpCarDetail, HaccpCarDetail.HaccpCarDetailId>{
	
}
