package com.ppm.mes.domain.sys.sys300;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.utils.SessionUtils;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class PopManageService extends BaseService <PopManage,PopManage.PopManageId>{
    private PopManageRepository repository;
        
    @Inject
    public PopManageService(PopManageRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    public List<PopManage> getPopSetupList(RequestParams<PopManage> requestParams) {     
		String userCd = requestParams.getString("userCd", "");
    	BooleanBuilder builder = new BooleanBuilder();

    	if (isNotEmpty(userCd)) {
           	builder.and(qPopManage.userCd.eq(userCd));
        }
    	
        return select().from(qPopManage).where(builder).fetch();
    }

    public PopManage getSetup(RequestParams<PopManage> requestParams) {     
		String userCd = SessionUtils.getCurrentLoginUserCd();
    	BooleanBuilder builder = new BooleanBuilder();

    	if (isNotEmpty(userCd)) {
           	builder.and(qPopManage.userCd.eq(userCd));
        }    	
        return select().from(qPopManage).where(builder).fetchOne();
    }

    @Transactional
    public void savePopSetup(List<PopManage> m) {
     	save(m);
    }

    @Transactional
    public void savePopSetup(PopManage m) {
     	save(m);
    }
}