package com.ppm.mes.domain.material.Detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.material.MaterialMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class MaterialDetailService extends BaseService<MaterialDetail,MaterialDetail.MaterialDetailId>{
	
	private MaterialDetailRepository repository;
	
	@Inject private MaterialDetailMapper materialDetailMapper;
	
	@Inject
    public MaterialDetailService(MaterialDetailRepository repository){
		super(repository);
        this.repository = repository;
	}
	
	
	//조회
	public List<MaterialDetailVO> getMaterialDetailList(RequestParams<MaterialDetailVO> requestParams){
		return materialDetailMapper.getMaterialDetailList(requestParams);
	}
	
	@Transactional
	public void saveMaterialDetail(List<MaterialDetail> list){
		if(list != null){
			for(MaterialDetail d : list){
    				save(d);
    		}
		}
	}

	//삭제
	@Transactional
	public void deleteMaterialDetail(MaterialMaster m) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qMaterialDetail.inDate.eq(m.getInDate()));
		builder.and(qMaterialDetail.company.eq(m.getCompany()));
		List<MaterialDetail> list= findAll(builder);
		for(MaterialDetail d : list){
			builder = new BooleanBuilder();
			builder.and(qMaterialDetail.inDate.eq(m.getInDate()));
			builder.and(qMaterialDetail.company.eq(m.getCompany()));
			builder.and(qMaterialDetail.inSeq.eq(d.getInSeq()));
			delete(qMaterialDetail).where(builder).execute();
		}
		
	}
	
}
