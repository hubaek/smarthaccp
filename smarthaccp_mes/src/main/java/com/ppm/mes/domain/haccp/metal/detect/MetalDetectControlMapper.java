package com.ppm.mes.domain.haccp.metal.detect;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface MetalDetectControlMapper extends MyBatisMapper{
	
	List<MetalDetectControlVO> getSpecimenTest(RequestParams<MetalDetectControlVO> vo);
	int mergeSpecimen(RequestParams<MetalDetectControlVO> vo);
	int insertStartSensingData(RequestParams<MetalDetectControlVO> vo);
}
