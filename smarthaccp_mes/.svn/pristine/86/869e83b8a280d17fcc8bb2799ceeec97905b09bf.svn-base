package com.ppm.mes.domain.user.user050;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.user.user050.UserAuth.UserAuthId;
import com.querydsl.core.BooleanBuilder;

@Service
public class UserAuthService extends BaseService<UserAuth, UserAuthId> {

    private UserAuthRepository repository;

    @Inject
    public UserAuthService(UserAuthRepository repository) {
        super(repository);
        this.repository = repository;
    }


    public List<UserAuth> get(RequestParams requestParams) {

        String company = requestParams.getString("company", "");
        String grpAuthCd = requestParams.getString("grpAuthCd", "");
        String userCd = requestParams.getString("userCd", "");
        String filter = requestParams.getString("filter", "");

        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(company)) {
            builder.and(qUserAuth.company.eq(company));
        }
        
        if (isNotEmpty(userCd)) {
            builder.and(qUserAuth.userCd.eq(userCd));
        }
        
        if (isNotEmpty(grpAuthCd)) {
            builder.and(qUserAuth.grpAuthCd.eq(grpAuthCd));
        }
        
        List<UserAuth> list = select().from(qUserAuth).where(builder).fetch();

        if (isNotEmpty(filter)) {
            list = filter(list, filter);
        }
        return list;
    }

    public List<UserAuth> getUserAuthList(String company, String userCd) {
    	
        BooleanBuilder builder = new BooleanBuilder();
        
        builder.and(qUserAuth.company.eq(company));
        builder.and(qUserAuth.userCd.eq(userCd));
        builder.and(qUserAuth.useYn.eq("Y"));
        
        return select().from(qUserAuth).where(builder).fetch();
        
    }
}