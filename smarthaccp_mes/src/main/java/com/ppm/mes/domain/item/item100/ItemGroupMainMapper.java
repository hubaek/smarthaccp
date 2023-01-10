package com.ppm.mes.domain.item.item100;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
public interface ItemGroupMainMapper extends MyBatisMapper {
    List<ItemGroupMainVO> getItemMainList(RequestParams<ItemGroupMainVO> vo);
    List<ItemGroupMainVO> getItemSubList(RequestParams<ItemGroupMainVO> vo);
}