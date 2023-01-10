package com.ppm.mes.domain.selfHygine.detail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
@Repository
public interface SelfHygineDetailRepository extends AXBootJPAQueryDSLRepository<SelfHygineDetail,SelfHygineDetail.SelfHygineDetailId>{
	Page<SelfHygineDetail> findByMainCode(String mainCode, Pageable pageable);
}
