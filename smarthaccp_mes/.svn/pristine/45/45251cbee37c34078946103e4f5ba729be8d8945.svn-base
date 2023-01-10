package com.ppm.mes.domain.sys.sys310;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class PopEquipManageService extends BaseService <PopEquipManage,PopEquipManage.PopEquipManageId>{
    private PopEquipManageRepository repository;
        
    @Inject
    public PopEquipManageService(PopEquipManageRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    public List<PopEquipManage> getPopEquipSetupList(RequestParams<PopEquipManage> requestParams) {     
		String userCd = requestParams.getString("userCd", "");
    	BooleanBuilder builder = new BooleanBuilder();
    	if (isNotEmpty(userCd)) {
           	builder.and(qPopEquipManage.userCd.eq(userCd));
        }    	
        return select().from(qPopEquipManage).where(builder).fetch();
    }
}