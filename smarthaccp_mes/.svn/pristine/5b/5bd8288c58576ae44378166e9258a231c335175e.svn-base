package com.ppm.mes.domain.user.user100;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.user.user100.UserCompany.UserCompanyId;
import com.querydsl.core.BooleanBuilder;

@Service
public class UserCompanyService extends BaseService<UserCompany, UserCompanyId> {

    private UserCompanyRepository repository;

    @Inject private UserCompanyMapper userCompanyMapper;
    
    
    @Inject
    public UserCompanyService(UserCompanyRepository repository) {
        super(repository);
        this.repository =repository;
    }

    //사용자관리에서 권한 등록된 회사 가져오기
    public List<UserCompany> get(RequestParams requestParams) {
        String userCd = requestParams.getString("userCd", "");
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(userCd)) {
            builder.and(qUserCompany.userCd.eq(userCd));
        }
        return select().from(qUserCompany).where(builder).fetch();
    }
    

    //사용자별 사
    public List<UserCompanyVO> getUserCompanyList(RequestParams<UserCompanyVO> requestParams) {
    	return userCompanyMapper.getUserCompanyList(requestParams);
    }
}