package com.ppm.mes.domain.st.st400;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface MoveInoutRepository extends AXBootJPAQueryDSLRepository<MoveInout, MoveInout.MoveInoutId> {
}
