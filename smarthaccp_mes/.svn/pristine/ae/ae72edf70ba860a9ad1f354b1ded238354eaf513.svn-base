package com.ppm.mes.domain.haccp.temp.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpTempMasterService extends BaseService<HaccpTempMaster, HaccpTempMaster.HaccpTempMasterId> {
	private HaccpTempMasterRepository repository;
	
	@Inject private HaccpTempMasterMapper masterMapper;
	@Inject
	public HaccpTempMasterService(HaccpTempMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpTempMasterVO> getMasterList(RequestParams<HaccpTempMasterVO> vo){
    	return masterMapper.getMasterList(vo);
    }

}
