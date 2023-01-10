package com.ppm.mes.domain.haccp.metal.detect;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;

@Service
public class MetalDetectControlService {
	@Inject private MetalDetectControlMapper metalDetectControlMapper;
	
	public List<MetalDetectControlVO> getSpecimenTest(RequestParams<MetalDetectControlVO> vo){
		return metalDetectControlMapper.getSpecimenTest(vo);
	}
	
	public void mergeSpecimen(RequestParams<MetalDetectControlVO> vo){
		metalDetectControlMapper.mergeSpecimen(vo);
	}
	
	public void insertStartSensingData(RequestParams<MetalDetectControlVO> vo){
		metalDetectControlMapper.insertStartSensingData(vo);
	}

}
