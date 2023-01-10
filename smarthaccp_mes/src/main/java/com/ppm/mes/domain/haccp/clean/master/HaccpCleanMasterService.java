package com.ppm.mes.domain.haccp.clean.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpCleanMasterService extends BaseService<HaccpCleanMaster, HaccpCleanMaster.HaccpCleanMasterId> {
	private HaccpCleanMasterRepository repository;
	
	@Inject private HaccpCleanMasterMapper masterMapper;
	@Inject
	public HaccpCleanMasterService(HaccpCleanMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	public List<HaccpCleanMasterVO> getMasterList(RequestParams<HaccpCleanMasterVO> requestParams) {
		return masterMapper.getMasterList(requestParams);
	}
}
