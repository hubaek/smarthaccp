package com.ppm.mes.domain.cd.cd100;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
  
@Repository											
public interface BasicCodeDetailRepository extends AXBootJPAQueryDSLRepository<BasicCodeDetail,BasicCodeDetail.BasicCodeDetailId> {
    Page<BasicCodeDetail> findByMainCd(String mainCd, Pageable pageable);
}        