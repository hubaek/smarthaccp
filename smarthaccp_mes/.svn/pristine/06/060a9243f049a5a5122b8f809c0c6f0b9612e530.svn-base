package com.ppm.mes.domain.monit.prdSite.cleaner;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;

@Service
public class CleanerService {
	
	@Inject
	private CleanerMapper CleanerMapper;
	
	public List<CleanerVO> getCleanerMonitList(RequestParams<CleanerVO> vo){
		return CleanerMapper.getCleanerMonitList(vo);
		
	}
}
