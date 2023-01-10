package com.ppm.mes.domain.item.item000;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface ItemMasterMapper extends MyBatisMapper {
    List<ItemMasterVO> getList(RequestParams<ItemMasterVO> vo); 
 // POP 품목조회
    List<ItemMasterVO> getPopList(RequestParams<ItemMasterVO> vo); 
    List<ItemMasterVO> getRoutingItemList(RequestParams<ItemMasterVO> vo);    
    List<ItemMasterVO> getRoutItemList(RequestParams<ItemMasterVO> vo);    
}