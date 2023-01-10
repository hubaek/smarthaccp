package com.ppm.mes.domain.monit.prdSite.metalDetector;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class MetalDetectorVO extends BaseVO{
	
	private String metal;
	private String metalDTM;
	private String siphyun;
	private String siphyunDTM;
	private String susSiphyun;
	private String susSiphyunDTM;
	
}