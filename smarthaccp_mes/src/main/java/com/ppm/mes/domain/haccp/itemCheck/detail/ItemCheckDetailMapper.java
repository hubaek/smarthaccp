package com.ppm.mes.domain.haccp.itemCheck.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.haccp.itemCheck.ItemCheckMaster;

public interface ItemCheckDetailMapper extends MyBatisMapper{

	List<ItemCheckDetailVO> getItemCheckDetailList(RequestParams<ItemCheckDetailVO> requestParams);

	void deleteDetailAll(ItemCheckMaster m);

}
