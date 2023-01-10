package com.ppm.mes.domain.key.key200;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class Key200Service {
	@Inject
	private Key200Mapper key200Mapper;
	
	//최신 재고코드 SEQ
	public int getCurrentSeq(){
		return key200Mapper.getCurrentSeq();
	}
	//최신 발행 바코드
	public String getNewBarcode(){
		return key200Mapper.getNewBarcode();
	}
	//최신  발행 재고코드
	public String getNewStockCd(){
		return key200Mapper.getNewStockCd();
	}
	
}
