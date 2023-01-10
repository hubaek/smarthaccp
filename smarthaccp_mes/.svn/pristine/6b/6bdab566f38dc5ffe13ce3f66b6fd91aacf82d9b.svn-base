package com.ppm.mes.domain.prd.pop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.utils.SessionUtils;

@Service
public class PopService{

    @Inject
    private PopMapper popMapper;

    
    //작업지시목록
    public List<WorkOrderListVO> getWorkOrderList(RequestParams<WorkOrderListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getWorkOrderList(vo);
    }
    
    //작업지시목록	생산실적 모니터링용
    public List<WorkOrderListVO> getWorkOrderList02(RequestParams<WorkOrderListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getWorkOrderList02(vo);
    }

    //작업자
    public List<WorkManListVO> getWorkOrderManList(RequestParams<WorkManListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getWorkOrderManList(vo); 
    }

    //재고 bom
    public List<StockListVO> getStockBomList(RequestParams<StockListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getStockBomList(vo); 
    }
    
    
    //출고리스트
    public List<WorkOutgoingListVO> getOutgoingList(RequestParams<WorkOrderListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getOutgoingList(vo); 
    }

    //불량유형
    public List<BadTypeListVO> getBadTypeList(RequestParams<BadTypeListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getBadTypeList(vo); 
    }
    
    //불량리스트
    public List<WorkBadListVO> getWorkBadList(RequestParams<WorkBadListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getWorkBadList(vo); 
    }

    public List<NwrkTypeListVO> getNwrkTypeList(RequestParams<NwrkTypeListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getNwrkTypeList(vo); 
    }

    public List<DiscardTypeListVO> getDiscardTypeList(RequestParams<DiscardTypeListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getDiscardTypeList(vo); 
    }

    //작업표준서 리스트 id값
    public List<Long> getWoDocFileList(RequestParams<WorkOrderListVO> vo){
    	vo.put("company",SessionUtils.getCurrentUserCompany());
    	return popMapper.getWoDocFileList(vo); 
    }
    //분할바코드갯수조회
    public List<PopVO> getDividedBarcodeCnt(RequestParams<PopVO> vo){
        return popMapper.getDividedBarcodeCnt(vo);
    }
}