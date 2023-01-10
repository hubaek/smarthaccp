package com.ppm.mes.domain.wh.wh000;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface WarehouseMasterMapper extends MyBatisMapper {
	List<WarehouseMasterVO> getWarehouseList(RequestParams<WarehouseMasterVO> requestParams);
}