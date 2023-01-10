package com.ppm.mes.domain.haccp.manufacturing.detail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
@Repository
public interface ManuFacturingDetailRepository extends AXBootJPAQueryDSLRepository<ManuFacturingDetail,ManuFacturingDetail.ManuFacturingDetailId>{
	Page<ManuFacturingDetail> findByMainCode(String mainCode, Pageable pageable);
}
