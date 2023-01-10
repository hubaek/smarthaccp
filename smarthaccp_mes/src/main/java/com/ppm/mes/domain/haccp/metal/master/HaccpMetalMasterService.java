package com.ppm.mes.domain.haccp.metal.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpMetalMasterService extends BaseService<HaccpMetalMaster, HaccpMetalMaster.HaccpMetalMasterId>{
	
	private HaccpMetalMasterRepository repository;
	@Inject private HaccpMetalMasterMapper masterMapper;
	
	@Inject
	public HaccpMetalMasterService(HaccpMetalMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpMetalMasterVO> getMasterList(RequestParams<HaccpMetalMasterVO> vo) {
		return masterMapper.getMasterList(vo);
	}

}
