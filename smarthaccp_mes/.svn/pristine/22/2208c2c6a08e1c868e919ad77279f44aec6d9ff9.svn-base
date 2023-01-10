package com.ppm.mes.utils;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.code.AXBootTypes;
import com.chequer.axboot.core.context.AppContextManager;
import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.JsonUtils;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetailService;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetailVO;
import com.ppm.mes.domain.cp.cp100.TbCmmsCp100;
import com.ppm.mes.domain.cp.cp100.TbCmmsCp100Service;
import com.ppm.mes.domain.eq.eq000.EquipMasterService;
import com.ppm.mes.domain.eq.eq000.EquipMasterVO;
import com.ppm.mes.domain.item.item100.ItemGroupMainService;
import com.ppm.mes.domain.item.item100.ItemGroupMainVO;
import com.ppm.mes.domain.rt.rt000.RoutManagementService;
import com.ppm.mes.domain.rt.rt000.RoutManagementVO;
import com.ppm.mes.domain.wh.wh000.WarehouseMasterService;
import com.ppm.mes.domain.wh.wh000.WarehouseMasterVO;

public class BasicCodeUtils {

	public static List<BasicCodeDetailVO> get(String mainCd) {
        RequestParams<BasicCodeDetailVO> requestParams = new RequestParams<>(BasicCodeDetailVO.class);
        requestParams.put("mainCd", mainCd);
        requestParams.put("useYn", AXBootTypes.Used.YES.getLabel()); 
        return getService().getBasicDetailLangList(requestParams);  
    } 
	
	public static List<BasicCodeDetailVO> get(String mainCd,String subCd) {
        RequestParams<BasicCodeDetailVO> requestParams = new RequestParams<>(BasicCodeDetailVO.class);
        requestParams.put("mainCd", mainCd);
        requestParams.put("subCd", subCd);
        requestParams.put("useYn", AXBootTypes.Used.YES.getLabel()); 
        return getService().getBasicDetailLangList(requestParams);
    } 

	public static List<BasicCodeDetailVO> get(String mainCd,String includeValue,String exceptValue) {
        RequestParams<BasicCodeDetailVO> requestParams = new RequestParams<>(BasicCodeDetailVO.class);
        requestParams.put("mainCd", mainCd);
        requestParams.put("includeValue", includeValue);
        requestParams.put("exceptValue", exceptValue);
        requestParams.put("useYn", AXBootTypes.Used.YES.getLabel()); 
        return getService().getBasicDetailLangList(requestParams);
    } 
	
	public static List<BasicCodeDetailVO> get(String company,String mainCd,String includeValue,String exceptValue,String data1,String data2,String data3) {
        
		RequestParams<BasicCodeDetailVO> requestParams = new RequestParams<>(BasicCodeDetailVO.class);
        requestParams.put("company", company);
        requestParams.put("mainCd", mainCd);
        requestParams.put("includeValue", includeValue);
        requestParams.put("exceptValue", exceptValue);
        
        requestParams.put("data1", data1);
        requestParams.put("data2", data2);
        requestParams.put("data3", data3);
        
        requestParams.put("useYn", AXBootTypes.Used.YES.getLabel()); 
        return getService().getBasicDetailLangList(requestParams);
    } 


	public static Map<String, List<BasicCodeDetailVO>> getAllByCodeMap() {
        RequestParams<BasicCodeDetailVO> requestParams = new RequestParams<>(BasicCodeDetailVO.class);
        List<BasicCodeDetailVO> commonCodes = getService().getAllByCodeMap(requestParams);
        Map<String, List<BasicCodeDetailVO>> commonCodeMap = commonCodes.stream().collect(groupingBy(BasicCodeDetailVO::getMainCd));        		
        return commonCodeMap;
	}

	public static List<WarehouseMasterVO> getWhCode(String whType) {
        RequestParams<WarehouseMasterVO> requestParams = new RequestParams<>(WarehouseMasterVO.class);        
        requestParams.put("whType", whType);
        requestParams.put("useYn", "Y"); 
        
        return getWarehouseService().getWarehouseList(requestParams);
    } 
	
	//공정
	public static List<RoutManagementVO> getRoutCode(String routCd,String equipUseYn,String qcYn) {
        RequestParams<RoutManagementVO> requestParams = new RequestParams<>(RoutManagementVO.class);        
        requestParams.put("routCd", routCd);
        requestParams.put("equipUseYn", equipUseYn);
        requestParams.put("qcYn", qcYn);
        return getRoutManagementService().get(requestParams);
    } 
	
	//설비
	public static List<EquipMasterVO> getEquipCode() {
        RequestParams<EquipMasterVO> requestParams = new RequestParams<>(EquipMasterVO.class);       
        return getEquipMasterService().getEquipList(requestParams);
    } 
	
	//부서정보
	public static List<TbCmmsCp100> getDeptList(String company) {        
		RequestParams<TbCmmsCp100> requestParams = new RequestParams<>(TbCmmsCp100.class);
        requestParams.put("company", company);
        requestParams.put("useYn", "Y");
        return getTbCmmsCp100Service().getCp100List(requestParams);
    } 

	public static List<ItemGroupMainVO> getItemMainList(String company) {        
		RequestParams<ItemGroupMainVO> requestParams = new RequestParams<>(ItemGroupMainVO.class);
        requestParams.put("company", company);
        requestParams.put("useYn", "Y");
        return getItemGroupMainService().getItemMainList(requestParams);
    } 
	
    public static String getAllByCodeMapJson() {
        return JsonUtils.toJson(getAllByCodeMap());
    }
    
    public static BasicCodeDetailService getService() {
        return AppContextManager.getBean(BasicCodeDetailService.class);
    }

    public static WarehouseMasterService getWarehouseService() {
        return AppContextManager.getBean(WarehouseMasterService.class);
    }

    public static RoutManagementService getRoutManagementService() {
        return AppContextManager.getBean(RoutManagementService.class);
    }
    
    public static EquipMasterService getEquipMasterService() {
        return AppContextManager.getBean(EquipMasterService.class);
    }

    public static TbCmmsCp100Service getTbCmmsCp100Service() {
        return AppContextManager.getBean(TbCmmsCp100Service.class);
    }

    public static ItemGroupMainService getItemGroupMainService() {
        return AppContextManager.getBean(ItemGroupMainService.class);
    }
}
