package com.ppm.mes.domain.haccp.ther.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpTherMasterService extends BaseService<HaccpTherMaster, HaccpTherMaster.HaccpTherMasterId>{
	private HaccpTherMasterRepository repository;
	
	@Inject private HaccpTherMasterMapper masterMapper;
	
	@Inject
	public HaccpTherMasterService(HaccpTherMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpTherMasterVO> getMasterList(RequestParams<HaccpTherMasterVO> vo){
    	return masterMapper.getMasterList(vo);
    }

}
