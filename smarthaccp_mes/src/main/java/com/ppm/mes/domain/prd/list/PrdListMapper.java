package com.ppm.mes.domain.prd.list;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface PrdListMapper extends MyBatisMapper {
    //작업지시현황
    List<PrdWorkOrderListVO> workOrderList(RequestParams<PrdWorkOrderListVO> vo);
    
    //생산일보
    List<PrdOrderListVO> orderList1(RequestParams<PrdOrderListVO> vo);
    
    //비가동현황
    List<PrdOrderNwrkVO> nwrkList(RequestParams<PrdOrderNwrkVO> vo);
    
    //불량현황
    List<PrdOrderBadVO> badList(RequestParams<PrdOrderBadVO> vo);
    
    //생산현황 lot추적
    List<PrdOrderListVO> orderListForLot(RequestParams<PrdOrderListVO> vo);
    
    //lot추적 사용자재 
    List<PrdOrderListVO> outItemListForLot(RequestParams<PrdOrderListVO> vo);    
    
    //생산자재출고
    List<PrdOrderOutgoingListVO> outgoingList(RequestParams<PrdOrderOutgoingListVO> vo);
    
    //생산입고
    List<PrdIncomingListVO> incomingList(RequestParams<PrdIncomingListVO> vo);
    
    //생산 작업자 작업현황
    List<PrdWorkManListVO> workManList(RequestParams<PrdWorkManListVO> vo);
    
    //설비모니터링현황_TV
    List<PrdEquipMonitListVO> equipMonitList(RequestParams<PrdEquipMonitListVO> vo);

}  