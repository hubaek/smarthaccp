package com.ppm.mes.domain.qc.qc400;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.qc.qc300.QcResultMaster;
import com.ppm.mes.domain.qc.qc450.QcResultBadDetail;
import com.ppm.mes.domain.qc.qc450.QcResultBadDetailService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class QcResultBadService extends BaseService<QcResultBad, QcResultBad.QcResultBadId> {
    private QcResultBadRepository repository;
    
    @Inject private QcResultBadDetailService inspBadDetailService;
    @Inject private QcResultBadMapper inspBadMapper;
    
    @Inject
    public QcResultBadService(QcResultBadRepository repository) {
        super(repository);
        this.repository = repository;
    }

    //불량
    public List<QcResultBadVO> getQcBadList(RequestParams<QcResultBadVO> vo) {
    	return inspBadMapper.getQcBadList(vo);
    }   
    

    //불량 후처리
    public List<QcResultBadVO> getQcBadDetailList(RequestParams<QcResultBadVO> vo) {
    	return inspBadMapper.getQcBadDetailList(vo);
    }   
    
    @Transactional
    public void saveQcBad(List<QcResultBad> list, QcResultMaster m) {    
    	deleteDetail(m.getSlipCd());

    	Long badSeq = new Long(1);
    	for (QcResultBad c : list) {
    		c.setCompany(m.getCompany());
    		c.setSlipCd(m.getSlipCd());
    		c.setBadSeq(badSeq);
    		c.setStockCd(m.getStockCd());
    		c.setItemCd(m.getItemCd());
    		badSeq++;
    	}
		save(list);
    }

    @Transactional
    public void deleteDetail(String slipCd) {        
    	BooleanBuilder builder = new BooleanBuilder();
    	if (isNotEmpty(slipCd)) { 
           	builder.and(qQcResultBad.slipCd.eq(slipCd));
        }
        delete(qQcResultBad).where(builder).execute();
    }


    @Transactional
    public void saveInspectionBadDetail(QcResultBadRequestVO request){
    	QcResultBad bad = request.getBad();
        List<QcResultBadDetail> badDetail = request.getBadDetail();
    	if (null!=bad) {      		
    		save(bad);
    		
    		if(isNotEmpty(badDetail)){
    			inspBadDetailService.saveInspectionBadDetail(badDetail ,bad);
    		}
    	}
    }
}