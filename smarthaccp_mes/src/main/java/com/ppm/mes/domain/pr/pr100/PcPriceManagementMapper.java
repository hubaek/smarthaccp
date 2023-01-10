package com.ppm.mes.domain.pr.pr100;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface PcPriceManagementMapper extends MyBatisMapper {
	List<PcPriceVO> getPcPriceList(RequestParams<PcPriceVO> vo);
}  