package com.ppm.mes.domain.prd.pop;

 

import java.util.List;

 

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface PopMapper extends MyBatisMapper {
    //분할된 바코드 개수 
    List<PopVO> getDividedBarcodeCnt(RequestParams<PopVO> header);
    //작업지시목록
    List<WorkOrderListVO> getWorkOrderList(RequestParams<WorkOrderListVO> header);
  //작업지시목록 생산실적모니터링용
    List<WorkOrderListVO> getWorkOrderList02(RequestParams<WorkOrderListVO> header);
    
    List<WorkManListVO> getWorkOrderManList(RequestParams<WorkManListVO> header);
    List<StockListVO> getStockBomList(RequestParams<StockListVO> header);
    List<WorkOutgoingListVO> getOutgoingList(RequestParams<WorkOrderListVO> header);
    
    
    List<BadTypeListVO> getBadTypeList(RequestParams<BadTypeListVO> header);
    List<WorkBadListVO> getWorkBadList(RequestParams<WorkBadListVO> header);    
    List<NwrkTypeListVO> getNwrkTypeList(RequestParams<NwrkTypeListVO> header);
    List<DiscardTypeListVO> getDiscardTypeList(RequestParams<DiscardTypeListVO> header);
    
    List<Long> getWoDocFileList(RequestParams<WorkOrderListVO> header);
    
}  