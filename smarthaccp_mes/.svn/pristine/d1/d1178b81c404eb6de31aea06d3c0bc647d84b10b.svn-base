package com.ppm.mes.domain.bom.bom000;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface BomMasterMapper extends MyBatisMapper {
    List<BomMasterVO> bomMasterList(RequestParams<BomMasterVO> bomVo);
    List<BomDetailVO> bomDetailList(RequestParams<BomDetailVO> bomVo);
    List<BomDetailVO> forwardBomList(RequestParams<BomDetailVO> bomVo);
    List<BomDetailVO> forwardBomList2(RequestParams<BomDetailVO> bomVo);
    List<BomDetailVO> bomRoutingDetailList(RequestParams<BomDetailVO> bomVo);
    List<BomItemVO> backwardBomList(RequestParams<BomItemVO> bomVo);
	List<BomMasterVO> bomListAll(RequestParams<BomMasterVO> bomVo);
}