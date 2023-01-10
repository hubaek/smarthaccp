package com.ppm.mes.domain.sa.sa400;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface SalesMapper extends MyBatisMapper {
    List<SalesVO> header(RequestParams<SalesVO> order);
    List<SalesVO> itemDetail(RequestParams<SalesVO> order);
    

    //기간별_연별_월
    List<SalesListVO> itemDetailGroupByYearMon(RequestParams<SalesListVO> order);
    //기간별_연별_분기
    List<SalesListVO> itemDetailGroupByYearQuater(RequestParams<SalesListVO> order);
    //기간별_지역별_연
    List<SalesListVO> itemDetailGroupByYearCust(RequestParams<SalesListVO> order);
    //기간별_지역별_연월별
    List<SalesListVO> itemDetailGroupByMonthCust(RequestParams<SalesListVO> order);
    //기간별_지역별_연별_TOP20
    List<SalesListVO> itemDetailGroupByYearCust20(RequestParams<SalesListVO> order);
}