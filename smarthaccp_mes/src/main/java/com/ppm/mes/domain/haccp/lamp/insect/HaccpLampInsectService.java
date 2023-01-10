package com.ppm.mes.domain.haccp.lamp.insect;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpLampInsectService  extends BaseService<HaccpLampInsect,HaccpLampInsect.HaccpLampInsectId>{

	private HaccpLampInsectRepository repository;
	
	@Inject private HaccpLampInsectMapper insectMapper; 
	@Inject
	public HaccpLampInsectService(HaccpLampInsectRepository repository){
		super(repository);
		this.repository = repository;
	}
    
	public List<HaccpLampInsectVO> getInsectList(RequestParams<HaccpLampInsectVO> requestParams) {
		return insectMapper.getInsectList(requestParams);
	}

	public List<HaccpLampInsectVO> getHaccpInsectList(RequestParams<HaccpLampInsectVO> requestParams) {
		return insectMapper.getHaccpInsectList(requestParams);
	}
	@Transactional
	public void insectSave(List<HaccpLampInsect> list) {
		save(list);
	}
}
