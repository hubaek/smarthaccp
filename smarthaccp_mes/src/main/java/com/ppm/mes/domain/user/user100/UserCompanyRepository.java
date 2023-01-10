package com.ppm.mes.domain.user.user100;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
import com.ppm.mes.domain.user.user100.UserCompany.UserCompanyId;

@Repository
public interface UserCompanyRepository extends AXBootJPAQueryDSLRepository<UserCompany, UserCompanyId> {
    List<UserCompany> findByUserCd(String userCd);
}
