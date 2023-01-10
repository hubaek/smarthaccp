package com.ppm.mes.domain.bom.bom000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.bom.bom100.BomDetail;
import com.ppm.mes.domain.bom.bom100.BomDetailService;
import com.querydsl.core.BooleanBuilder;

@Service
public class BomMasterService extends BaseService<BomMaster, BomMaster.BomMasterId> {
    private BomMasterRepository repository;

    @Inject private BomDetailService bomDetailService;
    @Inject private BomMasterMapper bomMasterMapper;
    
    @Inject
    public BomMasterService(BomMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    @Transactional
    public BomMaster saveBom(BomMaster m) {    	
    	
    	List<BomDetail> list = m.getBomDetail();
    	
    	if (null!=m) {
         	if(null == m.getRevisionNo()){
	    		BooleanBuilder builder = new BooleanBuilder();
	         	builder.and(qBomMaster.company.eq(m.getCompany()));  
	         	builder.and(qBomMaster.itemCd.eq(m.getItemCd()));  	

	        	update(qBomMaster)
		        .set(qBomMaster.lastYn , "N").where(builder).execute();
         		
				Long rNo = select().select(qBomMaster.revisionNo.max()).distinct()
						.from(qBomMaster)
						.where(qBomMaster.company.eq(m.getCompany()).and(qBomMaster.itemCd.eq(m.getItemCd()))).fetchOne();
				
				if(null == rNo){
					rNo = new Long(1);
				}else{
					rNo = rNo + 1;
				}
				
	         	m.setRevisionNo(rNo);
	         	m.setLastYn("Y");
    		}

			if(isNotEmpty(list)){
		    	for (BomDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setParentItemCd(m.getItemCd());
		    		c.setRevisionNo(m.getRevisionNo());
		    	}
		    	bomDetailService.saveBomDetail(list);
			}
    		save(m);
    	}
    	
    	return m;
    }

    public List<BomMasterVO> bomMasterList(RequestParams<BomMasterVO> bomVo){
    	return bomMasterMapper.bomMasterList(bomVo);
    }    
    
    public List<BomDetailVO> bomDetailList(RequestParams<BomDetailVO> bomVo){
    	return bomMasterMapper.bomDetailList(bomVo);
    }    

    public List<BomDetailVO> forwardBomList(RequestParams<BomDetailVO> bomVo){
    	return bomMasterMapper.forwardBomList(bomVo);
    }


    public List<BomDetailVO> forwardBomList2(RequestParams<BomDetailVO> bomVo){
    	return bomMasterMapper.forwardBomList2(bomVo);
    }

    public List<BomDetailVO> bomRoutingDetailList(RequestParams<BomDetailVO> bomVo){
    	return bomMasterMapper.bomRoutingDetailList(bomVo);
    }

    public List<BomItemVO> backwardBomList(RequestParams<BomItemVO> bomVo){
    	return bomMasterMapper.backwardBomList(bomVo);
    }

	public List<BomMasterVO> bomListAll(RequestParams<BomMasterVO> bomVo) {
		return bomMasterMapper.bomListAll(bomVo);
	}
}