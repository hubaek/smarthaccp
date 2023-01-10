package com.ppm.mes.domain.cd.cd100;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.utils.SessionUtils;
 
@Service
public class BasicCodeDetailService extends BaseService <BasicCodeDetail,BasicCodeDetail.BasicCodeDetailId>{
	
    private BasicCodeDetailRepository repository;

    @Inject private BasicCodeDetailMapper basicCodeDetailMapper;
    
    @Inject
    public BasicCodeDetailService(BasicCodeDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<BasicCodeDetailVO> getAllByCodeMap(RequestParams<BasicCodeDetailVO> vo){
    	vo.put("lang",SessionUtils.getUserLanguage());
    	return basicCodeDetailMapper.getAllByCodeMap(vo);
    }
    
    //공통코드화면 조회용
    public List<BasicCodeDetailVO> getBasicDetailList(RequestParams<BasicCodeDetailVO> vo) {  
    	return basicCodeDetailMapper.getBasicDetailList(vo);
    }

    //랭긔지변환 조회용
    public List<BasicCodeDetailVO> getBasicDetailLangList(RequestParams<BasicCodeDetailVO> vo) {  
    	vo.put("lang",SessionUtils.getUserLanguage());
    	return basicCodeDetailMapper.getBasicDetailLangList(vo);
    }
        
    @Transactional
    public void saveCodeDetail(List<BasicCodeDetail> itemInfos) {   
 		save(itemInfos);  
    }
}