package com.ppm.mes.domain.haccp.pack.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpPackMasterService extends BaseService<HaccpPackMaster, HaccpPackMaster.HaccpPackMasterId>{
	private HaccpPackMasterRepository repository;
	
	@Inject private HaccpPackMasterMapper masterMapper;
	@Inject
	public HaccpPackMasterService(HaccpPackMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpPackMasterVO> getMasterList(RequestParams<HaccpPackMasterVO> vo){
    	return masterMapper.getMasterList(vo);
    }
}
