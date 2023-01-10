package com.ppm.mes.domain.pc.pc300;

import java.util.List;
import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface PurchaseMapper extends MyBatisMapper {
    List<PurchaseVO> header(RequestParams<PurchaseVO> header);
    List<PurchaseVO> itemDetail(RequestParams<PurchaseVO> header);
   /* 낭만연구소
    void printbarcode(Map<String, Object> paramMap);
    */
}  