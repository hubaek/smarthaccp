package com.ppm.mes.domain.appr.appr000;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
 
@Repository												
public interface ApprovalRepository extends AXBootJPAQueryDSLRepository<Approval, Approval.ApprovalId> {

}