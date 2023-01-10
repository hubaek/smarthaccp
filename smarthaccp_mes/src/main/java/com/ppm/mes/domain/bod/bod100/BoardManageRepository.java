package com.ppm.mes.domain.bod.bod100;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
 
@Repository												
public interface BoardManageRepository extends AXBootJPAQueryDSLRepository<BoardManage, BoardManage.BoardManageId> {
}