package com.ppm.mes.domain.st.st000;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface StockMasterMapper extends MyBatisMapper {
	
	List<StockMasterVO> stockGroupByAll(RequestParams<StockMasterVO> vo);
	List<StockMasterVO> stockGroupByItem(RequestParams<StockMasterVO> vo);
	//2020-11-10 ykj 발행바코드 취소시 ref_barcode에 wlot_no 업데이트
	void updateWlotNo(RequestParams<StockMasterVO> vo);
	//2020-11-10 ykj 작업종료시 prd_use_yn 값 업데이트
	void updateEndWorkPrdUseYn(RequestParams<StockMasterVO> vo);
	//2020-09-23 cju 바코드 검색
	List<StockMasterVO> stockBarcodeSearch(RequestParams<StockMasterVO> vo);
	//2020-10-12 cju 출고여부 검색
	List<StockMasterVO> outYNSearch(RequestParams<StockMasterVO> vo);
    List<StockMasterVO> getStockMaster(RequestParams<StockMasterVO> vo);
    List<StockMasterVO> getStockHistory(RequestParams<StockMasterVO> vo);
    //제품출고현황
    List<StockMasterVO> getStockOutList(RequestParams<StockMasterVO> vo);
    List<StockMasterVO> updateOutYn(RequestParams<StockMasterVO> vo);
    
    //양품등록 - 바코드, 재고코드 발행
    void addGoodPrd(Map map);
    //양품등록 - 추후   수정
    void updateGoodPrd(Map map);
    //바코드, 재고코드 발행후 키관리 테이블 에서 바코드,재고코드 SEQ 값 1 증가
    void increaseStockCdSeq();
    void increaseBarcodeSeq();
    //특정 Ref재고코드 가져오기
    String getRefStockCd(int currentSeq); 
    
    Map<String, Object> chksafetyQtyandsendMail(Map<String, Object> paramMap);
    List<Map<String, Object>> childrenItemInfo(Map<String, Object> paramMap);
}