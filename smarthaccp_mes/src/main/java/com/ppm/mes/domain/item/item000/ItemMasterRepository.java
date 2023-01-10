package com.ppm.mes.domain.item.item000;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface ItemMasterRepository extends AXBootJPAQueryDSLRepository<ItemMaster, ItemMaster.ItemMasterId> {
}
