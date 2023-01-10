package com.ppm.mes.domain.haccp.hgPrc.master;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HgPrcMasterRepository extends AXBootJPAQueryDSLRepository<HgPrcMaster, HgPrcMaster.HgPrcMasterId>  {

}
