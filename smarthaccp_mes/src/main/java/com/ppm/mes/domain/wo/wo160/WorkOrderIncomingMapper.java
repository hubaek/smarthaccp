package com.ppm.mes.domain.wo.wo160;

import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface WorkOrderIncomingMapper extends MyBatisMapper {
    void cancelIncomingItem(String stockCd);
    void insertIncomingItem(Map map);
    void updateOrderStatus(RequestParams<WorkOrderIncomingVO> vo);
    int getNewWoSeq();
}  