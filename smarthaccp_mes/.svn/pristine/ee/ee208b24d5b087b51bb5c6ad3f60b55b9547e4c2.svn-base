package com.ppm.mes.domain.lmt.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
 
@Service
public class LmtMasterService extends BaseService <LmtMaster, LmtMaster.LmtMasterId>{
	private LmtMasterRepository repository;
	@Inject private LmtMasterMapper lmtMasterMapper;
	@Inject private LmtMasterService lmtMasterService;
	
	@Inject
	public LmtMasterService(LmtMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	//조회
	public List<LmtMasterVO> getLimitList(RequestParams<LmtMasterVO> requestParams){
		return lmtMasterMapper.getLimitList(requestParams);
	}
	
	//저장
	@Transactional
	public void saveLimitInfo(LmtMaster m){
	
		if(isNotEmpty(m.getTempFileCd())){
			update(qCommonFile)
	        .set(qCommonFile.targetId , m.getPrcsslmtId())
        		.where(qCommonFile.targetId.eq(m.getTempFileCd())
	        			.and(qCommonFile.targetType.eq("PRCSSLMT_ID"))
	        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
		}
 		save(m);  

	}
}
