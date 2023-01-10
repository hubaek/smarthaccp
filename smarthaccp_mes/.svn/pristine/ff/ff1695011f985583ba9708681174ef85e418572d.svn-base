package com.ppm.mes.domain.haccp.code.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.qc.qc200.QcItemVO;
 
 
public interface HaccpCodeDetailMapper extends MyBatisMapper {
    List<HaccpCodeDetailVO> getAllByCodeMap(RequestParams<HaccpCodeDetailVO> vo);
    List<HaccpCodeDetailVO> getHaccpDetailList(RequestParams<HaccpCodeDetailVO> vo);
    List<HaccpCodeDetailVO> getBasicDetailLangList(RequestParams<HaccpCodeDetailVO> vo);
	List<QcItemVO> getHaccpGroupItem(RequestParams<QcItemVO> vo);
}  