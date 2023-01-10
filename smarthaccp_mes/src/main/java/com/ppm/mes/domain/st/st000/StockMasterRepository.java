package com.ppm.mes.domain.st.st000;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
 
@Repository
public interface StockMasterRepository extends AXBootJPAQueryDSLRepository<StockMaster, StockMaster.StockMasterId> {
}
