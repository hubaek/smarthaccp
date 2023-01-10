package com.ppm.mes.domain.auth.auth000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.company.CompanyKeyManagementService;
import com.querydsl.core.BooleanBuilder;

@Service
public class AuthGroupService extends BaseService<AuthGroup, AuthGroup.AuthGroupId> {
    private AuthGroupRepository repository;

    @Inject private AuthGroupMapper authGroupMapper;
    @Inject private CompanyKeyManagementService companyKeyManagementService;
    
    
    @Inject
    public AuthGroupService(AuthGroupRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    public List<AuthGroup> getGroupList(RequestParams requestParams) {  
        
        String company = requestParams.getString("company", "");        
        String grpAuthCd = requestParams.getString("grpAuthCd", "");  
        String grpAuthNm = requestParams.getString("grpAuthNm", "");  
        String defaultYn = requestParams.getString("defaultYn", "");
        String useYn = requestParams.getString("useYn", "");
        
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(company)) {
            builder.and(qAuthGroup.company.eq(company));
        }

        if (isNotEmpty(grpAuthCd)) {
            builder.and(qAuthGroup.grpAuthCd.eq(grpAuthCd));
        }
        
        if (isNotEmpty(grpAuthNm)) {
        	builder.and(qAuthGroup.grpAuthNm.like("%"+grpAuthNm+"%"));
        }
        
        if (isNotEmpty(defaultYn)) {
            builder.and(qAuthGroup.defaultYn.eq(defaultYn));
        }
        
        if (isNotEmpty(useYn)) {
            builder.and(qAuthGroup.useYn.eq(useYn));
        }
        
        return findAll(builder);
    }
    
    
    public List<AuthGroupVO> getAuthGroupList(RequestParams<AuthGroupVO> vo) {     
    	return authGroupMapper.getAuthGroupList(vo);
    }

    public List<AuthGroupVO> getAuthUserList(RequestParams<AuthGroupVO> vo) {     
    	return authGroupMapper.getAuthUserList(vo);
    }

    public List<AuthGroupVO> getUserAuthList(RequestParams<AuthGroupVO> vo) {     
    	return authGroupMapper.getUserAuthList(vo);
    }

    public List<AuthMenuVO> getAuthMenuList(RequestParams<AuthMenuVO> vo) {     
    	return authGroupMapper.getAuthMenuList(vo);
    }
    
    //저장
    @Transactional
    public AuthGroup saveGroup(AuthGroup m) {
    	if (null!=m) {  

			//신규
    		String grpAuthCd = "";
			if(isEmpty(m.getGrpAuthCd())){
				grpAuthCd = companyKeyManagementService.getCommonCode(m.getCompany(),"AUTH000" ,"AUTH", 3);    
				m.setGrpAuthCd(grpAuthCd);
			}
			save(m);  
		}
    	return m;
    }
}
