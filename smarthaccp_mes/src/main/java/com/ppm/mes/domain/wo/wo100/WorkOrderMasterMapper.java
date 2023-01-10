package com.ppm.mes.domain.wo.wo100;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface WorkOrderMasterMapper extends MyBatisMapper {
    List<WorkOrderMasterVO> getWorkOrderMasterList(RequestParams<WorkOrderMasterVO> header);
    void updateGoodPrdQty(Map map);
}  