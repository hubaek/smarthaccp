package com.ppm.mes.domain.qc.qc350;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.qc.qc300.QcResultMaster;

@Service
public class QcResultDetailService extends BaseService<QcResultDetail, QcResultDetail.QcResultDetailId> {
    private QcResultDetailRepository repository;
    
    @Inject
    public QcResultDetailService(QcResultDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public void saveQcDetailList(List<QcResultDetail> list,QcResultMaster m) {
    	
    	for (QcResultDetail c : list) {
    		c.setSlipCd(m.getSlipCd());
    		c.setCompany(m.getCompany());
    		c.setSlipCd(m.getSlipCd());
    		c.setStockCd(m.getStockCd());
    		c.setItemCd(m.getItemCd());
        }
    	
		save(list);
    }
}