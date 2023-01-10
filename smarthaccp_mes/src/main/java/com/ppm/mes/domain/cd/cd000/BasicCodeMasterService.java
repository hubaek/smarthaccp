package com.ppm.mes.domain.cd.cd000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
 
@Service
public class BasicCodeMasterService extends BaseService <BasicCodeMaster,BasicCodeMaster.BasicCodeMasterId>{


    private BasicCodeMasterRepository repository;
    @Inject private BasicCodeMasterMapper basicCodeMasterMapper;
    
    @Inject
    public BasicCodeMasterService(BasicCodeMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<BasicCodeMasterVO> getBasicMasterList(RequestParams<BasicCodeMasterVO> vo){
    	return basicCodeMasterMapper.getBasicMasterList(vo);
    }
}