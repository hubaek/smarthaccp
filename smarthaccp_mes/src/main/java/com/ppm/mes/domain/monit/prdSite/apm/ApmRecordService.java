package com.ppm.mes.domain.monit.prdSite.apm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;

@Service
public class ApmRecordService {
	@Inject
	private ApmRecordMapper apmRecordMapper;
	
	public List<ApmRecordVO> getApmRecord(RequestParams<ApmRecordVO> vo){
		return apmRecordMapper.getApmRecord(vo);
	}
	
}
