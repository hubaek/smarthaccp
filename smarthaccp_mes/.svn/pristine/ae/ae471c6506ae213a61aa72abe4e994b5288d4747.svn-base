package com.ppm.mes.domain.haccp.code.detail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.qc.qc200.QcItemVO;
import com.ppm.mes.utils.SessionUtils;
 
@Service
public class HaccpCodeDetailService extends BaseService <HaccpCodeDetail,HaccpCodeDetail.HaccpCodeDetailId>{
	
    private HaccpCodeDetailRepository repository;

    @Inject private HaccpCodeDetailMapper haccpCodeDetailMapper;
    
    @Inject
    public HaccpCodeDetailService(HaccpCodeDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<HaccpCodeDetailVO> getAllByCodeMap(RequestParams<HaccpCodeDetailVO> vo){
    	vo.put("lang",SessionUtils.getUserLanguage());
    	return haccpCodeDetailMapper.getAllByCodeMap(vo);
    }
    
    //공통코드화면 조회용
    public List<HaccpCodeDetailVO> getHaccpDetailList(RequestParams<HaccpCodeDetailVO> vo) {  
    	return haccpCodeDetailMapper.getHaccpDetailList(vo);
    }

    //랭긔지변환 조회용
    public List<HaccpCodeDetailVO> getBasicDetailLangList(RequestParams<HaccpCodeDetailVO> vo) {  
    	vo.put("lang",SessionUtils.getUserLanguage());
    	return haccpCodeDetailMapper.getBasicDetailLangList(vo);
    }
        
    @Transactional
    public void saveCodeDetail(List<HaccpCodeDetail> itemInfos) {   
 		save(itemInfos);  
    }

	public List<QcItemVO> getHaccpGroupItem(RequestParams<QcItemVO> vo) {
		return haccpCodeDetailMapper.getHaccpGroupItem(vo);
	}
	
	@Transactional
	public void deleteByKeys(HaccpCodeDetail d) {
		if(null != d){
    		
        	String company = d.getCompany();
        	String mainCode = d.getMainCode();
        	String subCode = d.getSubCode();
        	delete(qHaccpCodeDetail).where(qHaccpCodeDetail.company.eq(company).and(qHaccpCodeDetail.mainCode.eq(mainCode)).and(qHaccpCodeDetail.subCode.eq(subCode))).execute(); 
    	}
		
	}
	
	@Transactional
	public HaccpCodeDetail saveDoc(HaccpCodeDetail d) {
		if (null!=d) {  
			if(isEmpty(d.getSubCode())){
				String subCode = select().select(qHaccpCodeDetail.subCode.max()).distinct()
    					.from(qHaccpCodeDetail)
    					.where(qHaccpCodeDetail.company.eq(d.getCompany()).and(qHaccpCodeDetail.mainCode.eq(d.getMainCode()))).fetchOne();
    			Long iSubCode = new Long(0);
    			if(null==subCode){
    				iSubCode = new Long(1);  
    			}else{
    				iSubCode = Long.parseLong(subCode) + new Long(1);
    			}
				d.setSubCode(String.valueOf(iSubCode));
			}
			d.setData1(d.getMainCode()+d.getSubCode());
			save(d);  
    	}
		return d;
	}
	
	//HACCP기준서 KEY (첨부파일용)
	public List<HaccpCodeDetailVO> getDocKey(RequestParams<HaccpCodeDetailVO> vo) {
		List<HaccpCodeDetailVO> list = new ArrayList<>();
		HaccpCodeDetailVO detailVo = new HaccpCodeDetailVO();
		String data1 = null;
		if (null!=vo) {  
			if(isEmpty(vo.getString("subCode"))){
				String subCode = select().select(qHaccpCodeDetail.subCode.max()).distinct()
    					.from(qHaccpCodeDetail)
    					.where(qHaccpCodeDetail.company.eq(vo.getString("company")).and(qHaccpCodeDetail.mainCode.eq(vo.getString("mainCode")))).fetchOne();
    			Long iSubCode = new Long(0);
    			if(null==subCode){
    				iSubCode = new Long(1);  
    			}else{
    				iSubCode = Long.parseLong(subCode) + new Long(1);
    			}
    			data1 = vo.getString("mainCode")+String.valueOf(iSubCode);
			}
    	}
		detailVo.setData1(data1);
		list.add(detailVo);
		
		return list;
	}

}