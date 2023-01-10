package com.ppm.mes.domain.eq.manu.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.eq.manu.ManuEquip;
 
@Service
public class ManuDetailEquipService extends BaseService <ManuDetailEquip,ManuDetailEquip.ManuDetailEquipId>{
	
    private ManuDetailEquipRepository repository;
    
    @Inject private ManuDetailEquipMapper manuDetailEquipMapper;
    
    @Inject
    public ManuDetailEquipService(ManuDetailEquipRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    
  //조회
    public List<ManuDetailEquipVO> getEquipDetailList(RequestParams<ManuDetailEquipVO> requestParams) {
    	return manuDetailEquipMapper.getEquipDetailList(requestParams);
    }
    //저장
    @Transactional
    public void saveEquipDetail(List<ManuDetailEquip> list){
    	int seq;
    	if(list != null){
    		for(ManuDetailEquip m : list){
    			if(isNotEmpty(m.getEquipCode())){
    				save(m);
    			}
    		}
    	}
    }
    public void deleteDetail(ManuEquip m){
    	manuDetailEquipMapper.deleteDetail(m);
    } 
}