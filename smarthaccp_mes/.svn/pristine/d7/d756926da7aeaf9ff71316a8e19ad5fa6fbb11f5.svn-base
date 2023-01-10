package com.ppm.mes.domain.sa.sa300;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface OrderMapper extends MyBatisMapper {
    List<OrderVO> header(RequestParams<OrderVO> order);
    List<OrderVO> itemDetail(RequestParams<OrderVO> order);
    List<OrderVO> excelDataDownLoad(RequestParams<OrderVO> vo);
}