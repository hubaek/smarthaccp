package com.ppm.mes.domain.haccp.filter.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpFilterMasterService extends BaseService<HaccpFilterMaster, HaccpFilterMaster.HaccpFilterMasterId>{
	
	private HaccpFilterMasterRepository repository;
	@Inject private HaccpFilterMasterMapper masterMapper;
	
	@Inject
	public HaccpFilterMasterService(HaccpFilterMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpFilterMasterVO> getMasterList(RequestParams<HaccpFilterMasterVO> vo) {
		return masterMapper.getMasterList(vo);
	}

}
