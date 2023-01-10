package com.ppm.mes.domain.haccp.in.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpInDetailService extends BaseService<HaccpInDetail, String> {
	private HaccpInDetailRepository deRepository;
	@Inject private HaccpInDetailMapper deMapper;
	
	@Inject
	public HaccpInDetailService(HaccpInDetailRepository deRepository){
		super(deRepository);
		this.deRepository = deRepository;
	}
	
	public List<HaccpInDetail> getInDetailList(RequestParams<HaccpInDetailVO> requestParams) {

		String company = requestParams.getString("company", "");
		String inspectionMonth = requestParams.getString("inspectionMonth","");
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(company)){
			builder.and(qHacppInDetail.company.like("%" + company + "%"));
		}
		if(isNotEmpty(inspectionMonth)){
			builder.and(qHacppInDetail.inspectionMonth.eq(inspectionMonth));
		}
		return findAll(builder);

	}
	
	@Transactional
	public void saveDetail(List<HaccpInDetail> list) {
		if(list != null){
			for(HaccpInDetail m : list){				
					save(m);
				}
			}
		}

	public void deDel(HaccpInDetail t) {
		deMapper.deDel(t);
	}

	public List<HaccpInDetail> detailDel(RequestParams<HaccpInDetailVO> vo) {
		return deMapper.detailDel(vo);
		
	}

}
