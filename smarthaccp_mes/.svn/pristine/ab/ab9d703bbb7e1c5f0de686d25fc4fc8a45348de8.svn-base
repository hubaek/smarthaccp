package com.ppm.mes.domain.haccp.prod.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpProdMasterService extends BaseService<HaccpProdMaster, HaccpProdMaster.HaccpProdMasterId> {
	private HaccpProdMasterRepository repository;
	
	@Inject private HaccpProdMasterMapper masterMapper;
	@Inject
	public HaccpProdMasterService(HaccpProdMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpProdMasterVO> getMasterList(RequestParams<HaccpProdMasterVO> vo){
    	return masterMapper.getMasterList(vo);
    }
}
