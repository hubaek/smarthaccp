package com.ppm.mes.domain.haccp.itemCheck;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;


@Repository
public interface ItemCheckMaserRepository extends AXBootJPAQueryDSLRepository<ItemCheckMaster,ItemCheckMaster.ItemCheckMasterId>{

}
