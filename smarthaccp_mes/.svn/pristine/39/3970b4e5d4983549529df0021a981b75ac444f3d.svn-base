package com.ppm.mes.domain.haccp.heat.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpHeatMasterService extends BaseService<HaccpHeatMaster, HaccpHeatMaster.HaccpHeatMasterId>{
	private HaccpHeatMasterRepository repository;
	
	@Inject private HaccpHeatMasterMapper masterMapper;
	@Inject
	public HaccpHeatMasterService(HaccpHeatMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpHeatMasterVO> getMasterList(RequestParams<HaccpHeatMasterVO> vo){
    	return masterMapper.getMasterList(vo);
    }
}
