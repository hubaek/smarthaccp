package com.ppm.mes.domain.pgm.pgm000;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends AXBootJPAQueryDSLRepository<Program, String> {
}
