package com.ppm.mes.domain.haccp.itemCheck.detail;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.itemCheck.ItemCheckMaster;
import com.querydsl.core.BooleanBuilder;



@Service
public class ItemCheckDetailSerivce extends BaseService<ItemCheckDetail,ItemCheckDetail.ItemCheckDetailId>{
	
private ItemCheckDetailRepository repository;
	
	@Inject private ItemCheckDetailMapper itemCheckDetailMapper;
	
	@Inject
    public ItemCheckDetailSerivce(ItemCheckDetailRepository repository){
		super(repository);
        this.repository = repository;
	}
	
	//디테일 조회
	public List<ItemCheckDetailVO> getItemCheckDetailList(RequestParams<ItemCheckDetailVO> requestParams) {
			
		return itemCheckDetailMapper.getItemCheckDetailList(requestParams);
	}
	
	public List<ItemCheckDetail> getItemCheckPrintDetailList(RequestParams<ItemCheckMaster> requestParams) {
		 String inspectionYm = requestParams.getString("inspectionYm", "");
		 BooleanBuilder builder = new BooleanBuilder();
		 builder.and(qItemCheckDetail.inspectionYm.eq(inspectionYm));
		 return findAll(builder);
	}
	
	//저장,수정
	@Transactional
	public void saveItemCheckDetail(List<ItemCheckDetail> list) {
		for(ItemCheckDetail d : list){
			save(d);
		}
		
	}
	@Transactional
	public void deleteDetailAll(ItemCheckMaster m) {
		itemCheckDetailMapper.deleteDetailAll(m);
	}

	



	
	
}
