package com.ppm.mes.domain.wo.wo160;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.st.st000.StockMasterMapper;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.ppm.mes.domain.st.st050.StockDetailMapper;
import com.ppm.mes.domain.st.st050.StockDetailService;
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterMapper;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterService;
import com.querydsl.core.BooleanBuilder;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncomingMapper;
import com.ppm.mes.utils.SessionUtils;
import com.ppm.mes.domain.key.key200.Key200Service;
@Service
public class WorkOrderIncomingService extends BaseService<WorkOrderIncoming, WorkOrderIncoming.WorkOrderIncomingId> {
    private WorkOrderIncomingRepository repository;
  
    @Inject private WorkOrderMasterService workOrderMasterService;
    @Inject private StockMasterService stockMasterService;
    @Inject private StockDetailService stockDetailService;
    @Inject private Key200Service key200Service;
    @Inject private WorkOrderIncomingMapper workOrderIncomingMapper;
    @Inject private StockMasterMapper stockMasterMapper;
    @Inject private StockDetailMapper stockDetailMapper;
    @Inject private WorkOrderMasterMapper workOrderMasterMapper;
    @Inject
    public WorkOrderIncomingService(WorkOrderIncomingRepository repository) {
        super(repository);
        this.repository = repository;
    }

    //2020-11-10 ykj POP-작업종료
    public void updateOrderStatus(RequestParams<WorkOrderIncomingVO> vo){
    	workOrderIncomingMapper.updateOrderStatus(vo);	//작업종료시
    }
    public BigDecimal getTotalIncomingQty(String wlotNo) {
    	
		BooleanBuilder builder = new BooleanBuilder();
		if (isNotEmpty(wlotNo)) {
	       	builder.and(qWorkOrderIncoming.wlotNo.eq(wlotNo));
	    }		
		return select().select(qWorkOrderIncoming.itemQty.sum().coalesce(new BigDecimal(0))).distinct().from(qWorkOrderIncoming).where(builder).fetchOne();
		
    }

    //MES_POP >> 생산품 입고 처리 (JPA version)
    @Transactional
    public void saveIncomingItem(String wlotNo ,BigDecimal itemQty) {    	
    	
        WorkOrderMaster master =  workOrderMasterService.getMasterOne(wlotNo);
        
    	if (null != master) 
    	{  
    		
			Long woSeq = select().select(qWorkOrderIncoming.woSeq.max()).distinct()
					.from(qWorkOrderIncoming)
					.where(qWorkOrderIncoming.wlotNo.eq(wlotNo)).fetchOne();    

			if(null == woSeq){
				woSeq = new Long(1);
			}else{
				woSeq = woSeq + new Long(1);
			}
			
			//생산창고 입고처리
			WorkOrderIncoming i = new WorkOrderIncoming();
			
            i.setCompany(master.getCompany());
            i.setWlotNo(master.getWlotNo());
            i.setItemCd(master.getItemCd());
            i.setStockCd(master.getStockCd());
            i.setItemQty(itemQty); 
			i.setWoSeq(woSeq);

			stockMasterService.saveWorkingOrderIncoming(i);    	
	    	save(i);
    	}
    }
    
    //MES_POP >> 생산품 입고 처리 - 바코드, 재고코드  재발행 , 추후 REFACTO
    @Transactional
    public void saveIncomingItem2(String wlotNo ,BigDecimal itemQty, String stockCd, String barcode, String itemCd) {
    	Map map = new HashMap();
    	Calendar calendar = Calendar.getInstance();
    	int year=calendar.get(Calendar.YEAR);
    	int currentSeq;
    	String refStockCd;
    	Date today = new Date();
    	SimpleDateFormat now;
    	now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	map.put("company", "1000");
    	map.put("barcode", key200Service.getNewBarcode());
    	map.put("wlotNo", wlotNo);
    	map.put("itemQty", itemQty);
    	map.put("stockCd", key200Service.getNewStockCd());
    	map.put("itemCd", itemCd);
    	map.put("inoutType", "IN");
    	map.put("inoutTypeDetail", "10");
    	map.put("inoutSeq",  stockDetailMapper.getNewInoutSeq());
    	now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	map.put("createdAt", now.format(today));
    	now = new SimpleDateFormat("yyyy-MM-dd");
    	map.put("inoutDt", now.format(today));
    	map.put("woSeq",  workOrderIncomingMapper.getNewWoSeq());	//woSeq 가져오기
    	stockMasterMapper.addGoodPrd(map);
    	stockMasterMapper.increaseStockCdSeq();
    	stockMasterMapper.increaseBarcodeSeq();
    	
    	workOrderMasterMapper.updateGoodPrdQty(map);	//작업지시 마스터(WO100)에  양품  수량 업데이트 
    	currentSeq = key200Service.getCurrentSeq();		//재고코드  SEQ 최근값 가져오기
    	//Master 재고코드 가져오기
    	refStockCd = stockMasterMapper.getRefStockCd(currentSeq);
    	map.put("refStockCd", refStockCd);
    	map.put("userCd", SessionUtils.getCurrentLoginUserCd());
    	Map testMap  = stockDetailService.testQuery(map);	//테스트용 - will be removed
    	stockDetailService.insertIncomingData(map);			//제고관리 상세 incoming record 추가
    	workOrderIncomingMapper.insertIncomingItem(map);	//wo160 정상등록
    	
    	//바코드 분할 해결해야함
    	//기존 잡혀있는 appliation 보고 바코드 분할
    	//오늘내로 완료 후 팀과 소스 싱크후 테스트 진행 후 디버깅 
    	//입고, 출고 바코드 출력, 기존 코주부에 있던 기능들
   
    }
    
    //현재 미사용
   public void insertIncomingItem(RequestParams<WorkOrderIncomingVO> vo){
	   RequestParams<WorkOrderIncomingVO> requestParams = new RequestParams<>(WorkOrderIncomingVO.class);
	   //requestParams.put("company",company);
	   //requestParams.put("mainCd", mainCd);
	   //requestParams.put("includeValue",  includeValue);
	   //map.put("company", requestParams.getString("company",""));
   }
    
    @Transactional
    public void cancelIncomingItem(WorkOrderIncoming m) {    	
    	if (null != m) 
    	{  
    		delete(m);
    	    stockMasterService.saveWorkingOrderCancelIncoming(m);
    	}
    }
}