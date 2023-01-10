package com.ppm.mes.domain.eq.manu.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.eq.manu.ManuEquip;
 
 
public interface ManuDetailEquipMapper extends MyBatisMapper {
	List<ManuDetailEquipVO> getEquipDetailList(RequestParams<ManuDetailEquipVO> requestParams);
	int getLastSeq(ManuDetailEquip m);
	void deleteDetail(ManuEquip m);
}