package com.ppm.mes.domain.pr.pr100;


import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface PcPriceManagementRepository extends AXBootJPAQueryDSLRepository<PcPriceManagement, PcPriceManagement.PurchasePriceManagementId> {
}
  