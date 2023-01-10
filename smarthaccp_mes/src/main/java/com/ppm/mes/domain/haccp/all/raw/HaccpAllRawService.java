package com.ppm.mes.domain.haccp.all.raw;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpAllRawService extends BaseService<HaccpAllRaw, HaccpAllRaw.HaccpAllRawId>{
	private HaccpAllRawRepository repository;
	@Inject HaccpAllRawMapper rawMapper;
	
	@Inject
	public HaccpAllRawService(HaccpAllRawRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	@Transactional
	public void rawSave(List<HaccpAllRaw> list) {
		save(list);
	}

	public List<HaccpAllRawVO> getRawList(RequestParams<HaccpAllRawVO> requestParams) {
		return rawMapper.getRawList(requestParams);
	}
}
