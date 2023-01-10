package com.ppm.mes.domain.qc.qc300;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.qc.qc350.QcResultDetail;
import com.ppm.mes.domain.qc.qc350.QcResultDetailService;
import com.ppm.mes.domain.qc.qc400.QcResultBad;
import com.ppm.mes.domain.qc.qc400.QcResultBadService;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class QcResultMasterService extends BaseService<QcResultMaster, QcResultMaster.QcResultMasterId> {
    private QcResultMasterRepository repository;
    
    @Inject private QcResultDetailService qcResultDetailService;
    @Inject private QcResultBadService qcResultBadService;
    @Inject private WorkKeyManagementService workKeyManagementService;
    @Inject private QcResultMasterMapper qcResultMasterMapper;
    @Inject private StockMasterService stockMasterService;
    
    @Inject
    public QcResultMasterService(QcResultMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    
    //검사마스터(등록된)
    public List<QcResultMasterVO> getQcMasterList(RequestParams<QcResultMasterVO> vo) {
    	return qcResultMasterMapper.getQcMasterList(vo);
    }   

    //공정검사대상마스터
    public List<QcResultMasterVO> getRoutQcMaster(RequestParams<QcResultMasterVO> vo) {
    	return qcResultMasterMapper.getRoutQcMaster(vo);
    }   
    
    //검사상세현황
    public List<QcResultDetailVO> getQcResultDetail(RequestParams<QcResultDetailVO> vo) {
    	return qcResultMasterMapper.getQcResultDetail(vo);
    }   
    

    //검사완료 저장 - 수입검사/출하검사
    @Transactional
    public void saveQcResultMaster(List<QcResultMaster> list){		
		if(isNotEmpty(list)){

	    	Date nowTime = new Date();        
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String qcDt = sdf.format(nowTime);        

			sdf = new SimpleDateFormat("HH");
	        String qcHour = sdf.format(nowTime);

			sdf = new SimpleDateFormat("mm");
	        String qcMinute = sdf.format(nowTime);

			sdf = new SimpleDateFormat("ss");
	        String qcSecond = sdf.format(nowTime);
	        
        	for (QcResultMaster m : list) {    	    	
                List<QcResultBad> badList = m.getBadList();
        		if(isNotEmpty(badList)){
        			qcResultBadService.saveQcBad(badList,m);
        		}

                List<QcResultDetail> qcDetail = m.getQcDetail();
        		if(isNotEmpty(qcDetail)){
        			qcResultDetailService.saveQcDetailList(qcDetail,m);
        		}
        		
        		//재고마스터 검사완료처리	//합격에,완료처리하면, 재고 검사완료 처리..
        		if(m.getQcFlag().equals("Y") && m.getEndFlag().equals("Y")){
        			stockMasterService.insertQcResult(m);
        		}

    			m.setQcDt(qcDt);
    			m.setQcHour(qcHour);
    			m.setQcMinute(qcMinute);
    			m.setQcSecond(qcSecond);
    			m.setQcDtm(nowTime.toInstant());
    			m.setConfirmYn("N");
    			
    			stockMasterService.updateQcInfo(m.getStockCd(), m.getQcDt(), m.getQcWay(), m.getQcFlag());
        	}
        	save(list);
		}        		
    }

    //검사완료 저장 - 공정검사
    @Transactional
    public void saveQcResultRoutMaster(QcResultMaster m){		
		if(null != m){
	    	Date nowTime = new Date();        
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String qcDt = sdf.format(nowTime);        

			sdf = new SimpleDateFormat("HH");
	        String qcHour = sdf.format(nowTime);

			sdf = new SimpleDateFormat("mm");
	        String qcMinute = sdf.format(nowTime);

			sdf = new SimpleDateFormat("ss");
	        String qcSecond = sdf.format(nowTime);

    		String slipCd = "";
			String slipType = "INSP";
			//신규
			if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode(slipType ,"IP", 3);      
				m.setSlipCd(slipCd);
			}

            List<QcResultDetail> qcDetail = m.getQcDetail();
    		if(isNotEmpty(qcDetail)){
    			qcResultDetailService.saveQcDetailList(qcDetail,m);
    		}

    		m.setQcType("30");//공정검사 하드코딩
    		m.setQcFlag("Y"); //합격 하드코딩
			m.setQcDt(qcDt);
			m.setQcHour(qcHour);
			m.setQcMinute(qcMinute);
			m.setQcSecond(qcSecond);
			m.setQcDtm(nowTime.toInstant());
        	save(m);
        	
        	stockMasterService.updateQcInfo(m.getStockCd(), m.getQcDt(), m.getQcWay(), m.getQcFlag());
		}        		
    }

    
    //LOT별 일괄 검사 대상 가져오기.
    public List<QcResultMaster> getInspLotTarget(String qcType ,  String lotNo) {
    	  BooleanBuilder builder = new BooleanBuilder();

          if (isNotEmpty(qcType)) { 
              builder.and(qQcResultMaster.qcType.eq(qcType));
          }
          if (isNotEmpty(lotNo)) { 
              builder.and(qQcResultMaster.lotNo.eq(lotNo));
          }

          List<QcResultMaster> list = select().from(qQcResultMaster).where(builder).fetch();
          
          return list;
    }   
    
    //검사 생성
    @Transactional
    public QcResultMaster saveInsp(QcResultMaster master){

    	if (null!=master) {    

    		String slipCd = "";
			String slipType = "INSP";
			//신규
			if(isEmpty(master.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode(slipType ,"IP", 3);      
				master.setSlipCd(slipCd);
			}
			
    		save(master);
    	}
    	return master;
    }
    
}


