package com.ppm.mes.domain.haccp.code.detail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
  
@Repository											
public interface HaccpCodeDetailRepository extends AXBootJPAQueryDSLRepository<HaccpCodeDetail,HaccpCodeDetail.HaccpCodeDetailId> {
    Page<HaccpCodeDetail> findByMainCode(String mainCode, Pageable pageable);
}        