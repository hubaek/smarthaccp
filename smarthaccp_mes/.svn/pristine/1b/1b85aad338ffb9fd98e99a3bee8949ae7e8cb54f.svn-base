package com.ppm.mes.domain.monit.prdSite.metalDetector;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;

@Service
public class MetalDetectorService {

	@Inject
	private MetalDetectorMapper metalDetectorMapper;
	
	//금속검출기 상태
	public List<MetalDetectorVO> getMetalDetectorStatus(RequestParams<MetalDetectorVO> vo){
		return metalDetectorMapper.getMetalDetectorStatus(vo);
	}

}
