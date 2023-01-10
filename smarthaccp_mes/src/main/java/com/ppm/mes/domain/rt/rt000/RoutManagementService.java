package com.ppm.mes.domain.rt.rt000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.company.CompanyKeyManagementService;
import com.ppm.mes.domain.rt.rt200.RoutMan;
import com.ppm.mes.domain.rt.rt200.RoutManService;
import com.ppm.mes.domain.rt.rt300.RoutEquip;
import com.ppm.mes.domain.rt.rt300.RoutEquipService;
import com.ppm.mes.domain.rt.rt500.RoutNwrk;
import com.ppm.mes.domain.rt.rt500.RoutNwrkService;
import com.ppm.mes.domain.rt.rt600.RoutBad;
import com.ppm.mes.domain.rt.rt600.RoutBadService;
 
@Service
public class RoutManagementService extends BaseService <RoutManagement,RoutManagement.RoutManagementId>{
	
    private RoutManagementRepository repository;


    @Inject private CompanyKeyManagementService companyKeyManagementService;  
    @Inject private RoutEquipService routEquipService;
    @Inject private RoutNwrkService routNwrkService;
    @Inject private RoutBadService routBadService;
    @Inject private RoutManService routManService;
    @Inject private RoutManagementMapper routManagementMapper;
    
    
    
    @Inject
    public RoutManagementService(RoutManagementRepository repository) {
        super(repository);
        this.repository = repository;
    }

    //공정조회
    public List<RoutManagementVO> get(RequestParams<RoutManagementVO> vo) {
    	return routManagementMapper.getList(vo);
    }
    

    //공정별작업자
    public List<RoutManManagementVO> getRoutManList(RequestParams<RoutManManagementVO> vo) {
    	return routManagementMapper.getRoutManList(vo);
    }        

    //공정별 설비
    public List<RoutEquipManagementVO> getRoutEquipList(RequestParams<RoutEquipManagementVO> vo) {
    	return routManagementMapper.getRoutEquipList(vo);
    }        
    
    //라우팅 품목별 공정절차
    public List<RoutingItemDetailVO> getRoutingItemDetailList(RequestParams<RoutingItemDetailVO> vo) {
    	return routManagementMapper.getRoutingItemDetailList(vo);
    }        
    
    //라우팅품목
    public List<RoutingItemVO> getRoutingItemList(RequestParams<RoutingItemVO> vo) {
    	return routManagementMapper.getRoutingItemList(vo);
    }        

    //품목별 생산정보 (작업표준)
    public List<RoutItemInfoVO> getRoutItemInfo(RequestParams<RoutItemInfoVO> vo) {
    	return routManagementMapper.getRoutItemInfo(vo);
    }        

    //공정별 불량정보
    public List<RoutBadVO> getRoutBadList(RequestParams<RoutBadVO> vo) {
    	return routManagementMapper.getRoutBadList(vo);
    }        
    //공정별 검사종류
    public List<RoutBadVO> getRoutQcGbnList(RequestParams<RoutBadVO> vo) {
    	return routManagementMapper.getRoutQcGbnList(vo);
    }        
    
    
    //공정 저장
    @Transactional
    public RoutManagement saveRout(RoutManagement m) {
    	
    	List<RoutEquip> rout300List = m.getRout300List();
    	List<RoutNwrk> rout500List = m.getRout500List();
    	List<RoutBad> rout600List = m.getRout600List();
    	List<RoutMan> rout200List = m.getRout200List();
		
    	if (null != m) {  
			if(null==m.getRoutCd()){
				m.setRoutCd(companyKeyManagementService.getCommonCode("ROUT_CD","RT",m.getCompany(),3));
			}  
			
			if(isNotEmpty(m.getTempFileCd())){
				update(qCommonFile)
		        .set(qCommonFile.targetId , m.getRoutCd())
	        		.where(qCommonFile.targetId.eq(m.getTempFileCd())
		        			.and(qCommonFile.targetType.eq("ROUT_CD"))
		        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
			}
		    
			//공정별설비
			if(isNotEmpty(rout300List)){
		    	for (RoutEquip c : rout300List) {
		    		c.setCompany(m.getCompany());
		    		c.setRoutCd(m.getRoutCd());
		    	}
		    	routEquipService.save(rout300List);
			}
			
			//공정별비가동
			if(isNotEmpty(rout500List)){
		    	for (RoutNwrk c : rout500List) {
		    		c.setCompany(m.getCompany());
		    		c.setRoutCd(m.getRoutCd());
		    	}
		    	routNwrkService.save(rout500List);
			}
			
			//공정별불량유형
			if(isNotEmpty(rout600List)){
		    	for (RoutBad c : rout600List) {
		    		c.setCompany(m.getCompany());
		    		c.setRoutCd(m.getRoutCd());
		    	}
		    	routBadService.save(rout600List);
			}
			
			//공정별가용인원
			if(isNotEmpty(rout200List)){
		    	for (RoutMan c : rout200List) {
		    		c.setCompany(m.getCompany());
		    		c.setRoutCd(m.getRoutCd());
		    	}
		    	routManService.save(rout200List);
			}
			
     		save(m);
    	}
    	
    	return m;
    }    
}