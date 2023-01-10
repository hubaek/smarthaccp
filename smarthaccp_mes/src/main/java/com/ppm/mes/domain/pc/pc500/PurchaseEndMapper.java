package com.ppm.mes.domain.pc.pc500;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface PurchaseEndMapper extends MyBatisMapper {
    List<PurchaseEndVO> header(RequestParams<PurchaseEndVO> header);
    List<PurchaseEndVO> itemDetail(RequestParams<PurchaseEndVO> header);
}  