package com.ppm.mes.domain.pc.pc400;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface PurchaseReturnMapper extends MyBatisMapper {
    List<PurchaseReturnVO> header(RequestParams<PurchaseReturnVO> header);
    List<PurchaseReturnVO> itemDetail(RequestParams<PurchaseReturnVO> header);
}  