package com.ppm.mes.domain.haccp.tank.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpTankMasterService extends BaseService<HaccpTankMaster, HaccpTankMaster.HaccpTankMasterId>{
	private HaccpTankMasterRepository repository;
	
	@Inject private HaccpTankMasterMapper masterMapper;
	@Inject
	public HaccpTankMasterService(HaccpTankMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpTankMasterVO> getMasterList(RequestParams<HaccpTankMasterVO> vo){
    	return masterMapper.getMasterList(vo);
    }
}
