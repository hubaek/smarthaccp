package com.ppm.mes.domain.sa.sa320;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
 
 
public interface OrderTempMapper extends MyBatisMapper {
	    
		//del temp
		void deleteTempTable();
		//excel upload
	    void insertTempExcel(OrderTemp vo);
	    //master insert
	    void insertSa300Insert();
	    //detail insert
	    void insertSa310Insert();
	    //invoice insert
	    void insertSa320Insert();
	    
}  