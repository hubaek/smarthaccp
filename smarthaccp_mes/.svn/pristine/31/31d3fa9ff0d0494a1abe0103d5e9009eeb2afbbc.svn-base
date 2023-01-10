package com.ppm.mes.domain.prd.list;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.utils.SessionUtils;

@Service
public class PrdListService{
    @Inject private PrdListMapper productionListMapper;
    //생산일보
    public List<PrdWorkOrderListVO> workOrderList(RequestParams<PrdWorkOrderListVO> vo){
    	return productionListMapper.workOrderList(vo);
    }
    
    //생산일보
    public List<PrdOrderListVO> orderList1(RequestParams<PrdOrderListVO> vo){
    	return productionListMapper.orderList1(vo);
    }

    //비가동현황
    public List<PrdOrderNwrkVO> nwrkList(RequestParams<PrdOrderNwrkVO> vo){
    	return productionListMapper.nwrkList(vo);
    }

    //불량현황
    public List<PrdOrderBadVO> badList(RequestParams<PrdOrderBadVO> vo){    	
    	return productionListMapper.badList(vo);
    }

    //생산현황 로트추적 
    public List<PrdOrderListVO> orderListForLot(RequestParams<PrdOrderListVO> vo){
    	return productionListMapper.orderListForLot(vo);
    }
    
    //로트추적 - 사용자재
    public List<PrdOrderListVO> outItemListForLot(RequestParams<PrdOrderListVO> vo){
    	return productionListMapper.outItemListForLot(vo);
    }

    //생산자재출고
    public List<PrdOrderOutgoingListVO> outgoingList(RequestParams<PrdOrderOutgoingListVO> vo){
    	return productionListMapper.outgoingList(vo);
    }
    
    //생산입고
    public List<PrdIncomingListVO> incomingList(RequestParams<PrdIncomingListVO> vo){
    	return productionListMapper.incomingList(vo);
    }	

    //생산작업자 작업현황
    public List<PrdWorkManListVO> workManList(RequestParams<PrdWorkManListVO> vo){
    	return productionListMapper.workManList(vo);
    }	

    //설비모니터링_TV
    public List<PrdEquipMonitListVO> equipMonitList(RequestParams<PrdEquipMonitListVO> vo){
    	vo.put("userCd" , SessionUtils.getCurrentLoginUserCd());
    	return productionListMapper.equipMonitList(vo);
    }	
}