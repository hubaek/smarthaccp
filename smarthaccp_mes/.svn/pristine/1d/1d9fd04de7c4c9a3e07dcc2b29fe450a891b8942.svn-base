package com.ppm.mes.domain.auth.auth010;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class AuthGroupUserService extends BaseService<AuthGroupUser, AuthGroupUser.AuthGroupUserId> {
    private AuthGroupUserRepository repository;

    @Inject
    public AuthGroupUserService(AuthGroupUserRepository repository) {
        super(repository);
        this.repository = repository;
    }
    

    public List<AuthGroupUser> getGroupUserList(RequestParams requestParams) {  
        
        String company = requestParams.getString("company", "");        
        String grpAuthCd = requestParams.getString("grpAuthCd", "");  
        String useYn = requestParams.getString("useYn", "");
        
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(company)) {
            builder.and(qAuthGroupUser.company.eq(company));
        }

        if (isNotEmpty(grpAuthCd)) {
            builder.and(qAuthGroupUser.grpAuthCd.eq(grpAuthCd));
        }
        
        if (isNotEmpty(useYn)) {
            builder.and(qAuthGroupUser.useYn.eq(useYn));
        }
        
        return findAll(builder);
    }
}
