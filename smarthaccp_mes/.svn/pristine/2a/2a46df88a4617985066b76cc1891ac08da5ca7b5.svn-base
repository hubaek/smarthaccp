package com.ppm.mes.domain.haccp.in.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.haccp.in.detail.HaccpInDetail;

public interface HaccpInMasterMapper extends MyBatisMapper{

	String checkSeq(HaccpInMaster list);

	List<HaccpInDetail> masterDel(RequestParams<HaccpInMasterVO> vo);

	List<HaccpInMasterVO> getList(RequestParams<HaccpInMasterVO> requestParams);

	List<HaccpInMasterVO> formview(RequestParams<HaccpInMasterVO> vo);
	
	

}
