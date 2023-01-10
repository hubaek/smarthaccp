package com.ppm.mes.domain.haccp.ster.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpSterMasterService extends BaseService<HaccpSterMaster, HaccpSterMaster.HaccpSterMasterId>{
	private HaccpSterMasterRepository repository;
	
	@Inject private HaccpSterMasterMapper masterMapper;
	@Inject
	public HaccpSterMasterService(HaccpSterMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpSterMasterVO> getMasterList(RequestParams<HaccpSterMasterVO> vo){
    	return masterMapper.getMasterList(vo);
    }

}
