package com.ppm.mes.domain.st.st500;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface StockBoxMapper extends MyBatisMapper {
	List<StockBoxVO> getStockBoxList(RequestParams<StockBoxVO> vo);
}