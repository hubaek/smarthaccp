package com.ppm.mes.domain.haccp.check;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
  
@Repository											
public interface HaccpCheckRepository extends AXBootJPAQueryDSLRepository<HaccpCheck,HaccpCheck.HaccpCheckId> {
    Page<HaccpCheck> findByMainCode(String mainCode, Pageable pageable);
}        