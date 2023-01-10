package com.ppm.mes.domain.haccp.car.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class HaccpCarDetailVO extends BaseVO{
	private String company;
	private String inspectionYm;
	private String deliveryDate;
	private String deliverySeq;
	private String licensePlate;
	private String custCode;
	private String departureTime;
	private String arrivalTime;
	private String mileage;
	private String remark;
	private String foreinStatus;
	private String offFlavorStatus;
	private String loadStatus;
	private String lockStatus;
	private String proprietyStatus;
	private String sterStatus;
	
	public static HaccpCarDetailVO of(HaccpCarDetail eo){
		HaccpCarDetailVO vo = ModelMapperUtils.map(eo,  HaccpCarDetailVO.class);
		return vo;
	}
	
	public static List<HaccpCarDetailVO> of(List<HaccpCarDetail> eoList){
		List<HaccpCarDetailVO> vtoList = new ArrayList<>();
		
		for (HaccpCarDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
	
}
