package com.ppm.mes.domain.haccp.cycleCheck;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.chequer.axboot.core.parameter.RequestParams;
import com.querydsl.core.BooleanBuilder;
import com.ppm.mes.domain.BaseService;


@Service
public class CycleCheckMasterService extends BaseService<CycleCheckMaster, CycleCheckMaster.CycleCheckMasterId>{
	
	private CycleCheckMasterRepository repository;
	
	@Inject private CycleCheckMasterMapper cycleCheckMasterMapper;
	
	@Inject
	public CycleCheckMasterService(CycleCheckMasterRepository repository){
		super(repository);
		this.repository  = repository;
	}
	
	public List<CycleCheckMaster> getList(RequestParams requestParams){
		String ccpCd = requestParams.getString("ccpCd","");
		String ccpNm = requestParams.getString("ccpNm","");
		String ccpCycle = requestParams.getString("ccpCycle","");
		String fromDate = requestParams.getString("fromDate",""); 
		String toDate = requestParams.getString("toDate","");
		String comment = requestParams.getString("comment","");
		String ccpDate = requestParams.getString("ccpDate","");
		String ccpHistoryDate = requestParams.getString("ccpHistoryDate","");
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(ccpCd)){	
			builder.and(qCycleCheckMaster.ccpCd.eq(ccpCd));
		}
		if(isNotEmpty(ccpNm)){	
			builder.and(qCycleCheckMaster.ccpNm.eq(ccpNm));
		}
		if(isNotEmpty(fromDate)&&isNotEmpty(toDate)){
			builder.and(qCycleCheckMaster.ccpDate.between(fromDate,toDate));
		}
		return findAll(builder);
	}
	
	public List<CycleCheckMasterVO> getPopAlarmList(RequestParams<CycleCheckMaster> requestParams){
		return cycleCheckMasterMapper.getPopAlarmList(requestParams);
	}
	
	public List<CycleCheckMasterVO> getAlarmList(RequestParams<CycleCheckMaster> requestParams){
		return cycleCheckMasterMapper.getAlarmList(requestParams);
	}
	public void updateLastDate(){
		/*
		List<CycleCheckMasterVO> ccpCodes;
		ArrayList<String> ccpCd = new ArrayList<String>();
		ccpCodes = cycleCheckMasterMapper.getCcpCode();
		for(int i = 0 ; i < ccpCodes.size(); i++){
			ccpCd.add(ccpCodes.get(i).getCcpCd());
			System.out.println(ccpCd.get(i));
		}
		*/
		cycleCheckMasterMapper.updateLastDate1();
		cycleCheckMasterMapper.updateLastDate2();
		cycleCheckMasterMapper.updateLastDate3();
		cycleCheckMasterMapper.updateLastDate4();
		cycleCheckMasterMapper.updateLastDate5();
		cycleCheckMasterMapper.updateLastDate6();
		cycleCheckMasterMapper.updateLastDate7();
		cycleCheckMasterMapper.updateHistoryDate();
	}
}
