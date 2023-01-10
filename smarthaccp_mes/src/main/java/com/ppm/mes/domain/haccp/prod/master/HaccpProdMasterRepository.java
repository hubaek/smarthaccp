package com.ppm.mes.domain.haccp.prod.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HaccpProdMasterRepository extends AXBootJPAQueryDSLRepository<HaccpProdMaster, HaccpProdMaster.HaccpProdMasterId>{

}
