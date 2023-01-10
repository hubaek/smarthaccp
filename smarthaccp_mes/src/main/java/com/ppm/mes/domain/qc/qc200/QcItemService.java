package com.ppm.mes.domain.qc.qc200;

import java.util.List;

import javax.inject.Inject;
import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class QcItemService extends BaseService<QcItem, QcItem.QcItemId> {
   
	private QcItemRepository repository;
    
    @Inject private QcItemMapper qcItemMapper;
    
    @Inject
    public QcItemService(QcItemRepository repository) {
        super(repository);
        this.repository = repository;
    }    
    
    //검사항목마스터
    public List<QcItemVO> getQcItem(RequestParams<QcItemVO> vo) {       
    	return qcItemMapper.getQcItem(vo); 
    }    

    //그룹별 검사항목마스터
    public List<QcItemVO> getQcGroupItem(RequestParams<QcItemVO> vo) {       
    	return qcItemMapper.getQcGroupItem(vo); 
    }    


    //검사대상 품목리스트 - 수입/출하검사
    public List<QcItemTargetVO> getQcItemTargetList(RequestParams<QcItemTargetVO> vo) {       
    	return qcItemMapper.getQcItemTargetList(vo); 
    }    

    //검사대상 품목리스트 - 공정검사
    public List<QcItemTargetVO> getQcRoutItemTargetList(RequestParams<QcItemTargetVO> vo) {       
    	return qcItemMapper.getQcRoutItemTargetList(vo); 
    }    


    //그룹별 검사항목마스터 - 공정검사 그룹별 검사항목 전체 - SETUP 용
    public List<QcItemVO> getQcRoutItemSetupList(RequestParams<QcItemVO> vo) {       
    	return qcItemMapper.getQcRoutItemSetupList(vo); 
    }    

    @Transactional
    public void saveQcItem(List<QcItem> list) {    	
    	save(list);
    }
}