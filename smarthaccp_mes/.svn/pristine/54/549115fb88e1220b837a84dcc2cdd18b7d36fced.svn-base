package com.ppm.mes.domain.st.st200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.st.st000.StockMasterMapper;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.ppm.mes.domain.st.st000.StockMasterVO;
import com.ppm.mes.utils.MailHandler;


@Service
public class StockOutService extends BaseService<StockOut, StockOut.StockOutId> {

    
    @Inject private StockMasterService stockMasterService;
    @Inject private StockMasterMapper stockMasterMapper;
    @Inject private JavaMailSender sender;
    
    @Inject
    public StockOutService(StockOutRepository repository) {
        super(repository);
        this.repository = repository;
    }  

    //재고관리 - 제품출고
    @Transactional
    public void stockOutItem(List<StockOut> list) {    	
    	if(isNotEmpty(list)){
        	for (StockOut m : list) {
        		if(null==m.getOutSeq()){        			
        			String outDt = m.getOutDt();
        	        
        			Long outSeq = select().select(qStockOut.outSeq.max()).distinct()
        					.from(qStockOut)
        					.where(qStockOut.outDt.eq(outDt)).fetchOne();
        			
        			if(null==outSeq){
        				outSeq = new Long(1);
        			}else{
        				outSeq = outSeq + new Long(1);
        			}    			
        			
        			m.setOutSeq(outSeq);  
        		} 		
        		
        		m = stockMasterService.stockOutItem(m);
        		save(m);
        	}
    	}
    }
    
    //재고관리 - 제품출고취소
    @Transactional
    public void stockOutCancelItem(List<StockOut> list) {    	
    	if(isNotEmpty(list)){
        	for (StockOut m : list) {
        		stockMasterService.stockOutCancelItem(m);
        	}
        	delete(list);
    	}
    }
    
    // pop화면 출고 - 20.08.11 김재민
    @Transactional
    public void cancelItem(StockOut m) { 
        		if(null==m.getOutSeq()){        			
        			String outDt = m.getOutDt();
        	        
        			Long outSeq = select().select(qStockOut.outSeq.max()).distinct()
        					.from(qStockOut)
        					.where(qStockOut.outDt.eq(outDt)).fetchOne();
        			
        			if(null==outSeq){
        				outSeq = new Long(1);
        			}else{
        				outSeq = outSeq + new Long(1);
        			}    			
        			
        			m.setOutSeq(outSeq);  
        		} 		
        		
        		m = stockMasterService.popStockOutItem(m);        		
        		save(m);
        	}
    
    //안전재고 체크 및 메일 발송
    @Transactional
    public void chksafetyQtyandsendMail(Map<String, Object> paramMap) {
    	if(paramMap != null){
    		
    		//BOM조회
			Map<String, Object> childPMap = new HashMap<String, Object>();
			String itemCd  = String.valueOf(paramMap.get("itemCd"));
			childPMap.put("itemCd", itemCd);
			List<Map<String, Object>> childItemList =stockMasterMapper.childrenItemInfo(childPMap);
    		
			//상위품목의 BOM이 존재할 경우
			
			String ItemType = String.valueOf(childItemList.get(0).get("ItemType"));
			
			if(ItemType.equals("30")){
				sendMail(paramMap);
			} else {
				for(int i=0; i<childItemList.size(); i++){
					String childItemCd = String.valueOf(childItemList.get(i).get("itemCd"));
					
					//품목별 재고 정보 조회
		    		RequestParams<StockMasterVO> vo = new RequestParams<StockMasterVO>();
		    		List<StockMasterVO> StockAllList = stockMasterService.stockGroupByAll(vo);
		    		
		    		//하위품목의 재고정보 조회
		    		for(int j=0; j<StockAllList.size(); j++){
		    			StockMasterVO StockAllMap = StockAllList.get(j);
		    			
		    			if(childItemCd.equals(StockAllMap.getItemCd())){
		    				Map<String, Object> sendMailParamMap = new HashMap<String, Object>();
		    				sendMailParamMap.put("itemCd", childItemCd);
		    				sendMailParamMap.put("stockCd", StockAllMap.getStockCd());
		    				
		    				sendMailParamMap.put("frMail", String.valueOf(paramMap.get("frMail")));
		    				sendMailParamMap.put("toMail", String.valueOf(paramMap.get("toMail")));
		    				sendMailParamMap.put("frName", String.valueOf(paramMap.get("frName")));
		    				sendMailParamMap.put("subJect", String.valueOf(paramMap.get("subJect")));
		    				sendMail(sendMailParamMap);
		    			}
		    			
		    		}
				}
			}
    	}
    }
    
    @Transactional
    public void sendMail(Map<String, Object> paramMap) {
    	Map<String, Object> resultMap = stockMasterMapper.chksafetyQtyandsendMail(paramMap);
		System.out.println("resultMap : " + resultMap);

        String ALARM_YN = String.valueOf(resultMap.get("ALARM_YN"));
        if(ALARM_YN.equals("Y")){
        	System.out.println("안전재고 메일발송 알림");
        	try{
        		//String memberMail = "rlawoals5704@naver.com,k003o85894o4@gmail.com";
        
        		MailHandler mail = new MailHandler(sender);
        		//mail.setFrom("k003o85894o4@gmail.com", "스마트해썹앤팩토리KHJ");
        		mail.setFrom(String.valueOf(paramMap.get("frMail")), String.valueOf(paramMap.get("frName")));
        		//mail.setTo("kdw92322@naver.com");
        		mail.setTo(String.valueOf(paramMap.get("toMail")));
        		mail.setSubject(String.valueOf(paramMap.get("subJect")));
        		
        		//업무프로세스에 따른 구현이 필요한 부분
        		mail.setText(new StringBuffer().append("<h2>안전재고 수량이하 알림</h2>")
											   .append("<h2>재고정보</h2>")
											   .append("<h2>품목 : " + String.valueOf(resultMap.get("ITEM_NM")) + "</h2>")
											   .append("<h2>창고 : " + String.valueOf(resultMap.get("WH_NM")) + "</h2>")
											   .append("<h2>안전재고 : " + String.valueOf(resultMap.get("SAFETY_QTY")) + "</h2>")
											   .append("<h2>현재고 : " + String.valueOf(resultMap.get("STOCK_QTY")) + "</h2>")
											   .append("<h2>출고일시 : " + String.valueOf(resultMap.get("WH_OUT_DT")) + "</h2>").toString());
        		mail.send();
        	}catch (Exception e) {
        		e.printStackTrace();
        	}
        }
    }
    /*
     * 낭만연구소
    @Transactional
    public Map<String, Map<String, Object>> getQRcode() {
		//바코드(QR코드) 값을 읽어오는 부분필요
    	Map<String, Map<String, Object>> rtnMap = new HashMap<String, Map<String, Object>>();
    	
     	//test
    	Map<String, Object> rtnputMap = new HashMap<String, Object>();
    	rtnputMap.put("barcode", "B22050057");
     	rtnMap.put("barcode", rtnputMap);
    	
     	return  rtnMap; 
    }
    */
}