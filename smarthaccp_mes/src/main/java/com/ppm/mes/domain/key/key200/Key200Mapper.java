package com.ppm.mes.domain.key.key200;

import com.chequer.axboot.core.mybatis.MyBatisMapper;

public interface Key200Mapper extends MyBatisMapper{
	 int getCurrentSeq();
	 String getNewBarcode();
	 String getNewStockCd();
}
