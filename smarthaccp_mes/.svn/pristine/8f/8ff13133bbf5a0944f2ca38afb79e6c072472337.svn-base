package com.ppm.mes.domain.haccp.hgPrc.detail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface HgPrcDetailRepository extends AXBootJPAQueryDSLRepository<HgPrcDetail,HgPrcDetail.HgPrcDetailId>{
	Page<HgPrcDetail> findByMainCode(String mainCode, Pageable pageable);
}
