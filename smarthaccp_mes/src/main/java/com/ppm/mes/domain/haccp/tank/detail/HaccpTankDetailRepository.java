package com.ppm.mes.domain.haccp.tank.detail;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpTankDetailRepository extends AXBootJPAQueryDSLRepository<HaccpTankDetail, HaccpTankDetail.HaccpTankDetailId>{

}
