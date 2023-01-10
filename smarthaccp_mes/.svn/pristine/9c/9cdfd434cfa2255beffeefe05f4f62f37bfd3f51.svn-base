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
public class MaterialsDetailService extends BaseService<MaterialsDetail,MaterialsDetail.MaterialsDetailId>{
	
	private MaterialsDetailRepository repository;
	
	@Inject private MaterialsDetailMapper materialsDetailMapper;
	
	@Inject
    public MaterialsDetailService(MaterialsDetailRepository repository){
		super(repository);
        this.repository = repository;
	}
	
	//조회
		public List<MaterialsDetailVO> getMaterialsDetailList(RequestParams<MaterialsDetailVO> requestParams){
			return materialsDetailMapper.getMaterialsDetailList(requestParams);
		}
		
	@Transactional
		public void saveMaterialsDetail(List<MaterialsDetail> list){
		if(list != null){
			for(MaterialsDetail d : list){
    				save(d);
			}
		}
	}
	//삭제
	@Transactional
	public void deleteMaterialsDetail(MaterialMaster m) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qMaterialsDetail.inDate.eq(m.getInDate()));
		builder.and(qMaterialsDetail.company.eq(m.getCompany()));
		List<MaterialsDetail> list= findAll(builder);
		for(MaterialsDetail d : list){
			builder = new BooleanBuilder();
			builder.and(qMaterialsDetail.inDate.eq(m.getInDate()));
			builder.and(qMaterialsDetail.company.eq(m.getCompany()));
			builder.and(qMaterialsDetail.inSeq.eq(d.getInSeq()));
			delete(qMaterialsDetail).where(builder).execute();
		}
		
	}
}
