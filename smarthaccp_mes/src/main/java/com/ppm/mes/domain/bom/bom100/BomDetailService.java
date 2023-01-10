package com.ppm.mes.domain.bom.bom100;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;

@Service
public class BomDetailService extends BaseService<BomDetail, BomDetail.BomDetailId> {
    private BomDetailRepository repository;

    @Inject
    public BomDetailService(BomDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }
    

    @Transactional
    public void saveBomDetail(List<BomDetail> boms) {
    	if (isNotEmpty(boms)) {  
    		for (BomDetail b : boms) {
        		if(null == b.getBomSeq()){
        			Long bomSeq = select().select(qBomDetail.bomSeq.max()).distinct()
        					.from(qBomDetail)
        					.where(qBomDetail.parentItemCd.eq(b.getParentItemCd())).fetchOne();
        					
        			if(null==bomSeq){
        				bomSeq = new Long(1);  
        			}else{
        				bomSeq = bomSeq + new Long(1);
        			}
        			b.setBomSeq(bomSeq);
        		}
            	save(b);
            }
    	}
    }   
}