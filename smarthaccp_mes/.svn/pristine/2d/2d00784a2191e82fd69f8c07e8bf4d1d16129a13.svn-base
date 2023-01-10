package com.ppm.mes.domain.haccp.check;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
 
@Service
public class HaccpCheckService extends BaseService <HaccpCheck,HaccpCheck.HaccpCheckId>{
	
    private HaccpCheckRepository repository;

    @Inject private HaccpCheckMapper haccpCheckMapper;
    
    @Inject
    public HaccpCheckService(HaccpCheckRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<HaccpCheckVO> getHygieneList(RequestParams<HaccpCheck> vo) {  
    	return haccpCheckMapper.getHygieneList(vo);
    }

    @Transactional
    public void saveCodeDetail(List<HaccpCheck> itemInfos) {   
 		save(itemInfos);  
    }


}