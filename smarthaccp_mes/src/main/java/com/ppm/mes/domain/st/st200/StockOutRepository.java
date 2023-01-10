package com.ppm.mes.domain.st.st200;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository 
public interface StockOutRepository extends AXBootJPAQueryDSLRepository<StockOut, StockOut.StockOutId> {
	
}
