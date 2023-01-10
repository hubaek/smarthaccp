package com.ppm.mes.domain.snsr;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;


@Service
public class SnsrMasterService extends BaseService<SnsrMaster,SnsrMaster.SnsrMasterId>{

	private SnsrMasterRepository repository;
	
	@Inject private SnsrMasterMapper snsrMasterMapper;
	
	
	@Inject
    public SnsrMasterService(SnsrMasterRepository repository){
		super(repository);
        this.repository = repository;
	}

	//조회
	public List<SnsrMaster> getSensorList(RequestParams<SnsrMasterVO> requestParams) {
		return snsrMasterMapper.getSensorList(requestParams);
	}
	//저장
	@Transactional
	public void saveSensorInfo(SnsrMaster m) {
		if(isNotEmpty(m.getTempFileCd())){
			update(qCommonFile)
	        .set(qCommonFile.targetId , m.getSnsrId())
        		.where(qCommonFile.targetId.eq(m.getTempFileCd())
	        			.and(qCommonFile.targetType.eq("SNSR_ID"))
	        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
		}
		
		save(m);
	}
	
	//삭제
    @Transactional
    public void deleteAll(SnsrMaster m){
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qSnsrMaster.company.eq(m.getCompany()));
    	builder.and(qSnsrMaster.snsrId.eq(m.getSnsrId()));
    	builder.and(qSnsrMaster.routCd.eq(m.getRoutCd()));
    	delete(qSnsrMaster).where(builder).execute();
    }
    
    //중복체크
	public List<SnsrMaster> getSensorIdCheck(RequestParams<SnsrMaster> requestParams) {
		String snsrId = requestParams.getString("snsrId", "");
		 BooleanBuilder builder = new BooleanBuilder();
		 builder.and((qSnsrMaster.snsrId.eq(snsrId)));
		 return findAll(builder);
	}
	
	
}
