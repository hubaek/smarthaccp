package com.ppm.mes.domain.rt.rt000;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface RoutManagementMapper extends MyBatisMapper {
    List<RoutManagementVO> getList(RequestParams<RoutManagementVO> vo);       
    List<RoutManManagementVO> getRoutManList(RequestParams<RoutManManagementVO> vo);        
	List<RoutEquipManagementVO> getRoutEquipList(RequestParams<RoutEquipManagementVO> requestParams);	
	List<RoutingItemVO> getRoutingItemList(RequestParams<RoutingItemVO> requestParams);
	List<RoutingItemDetailVO> getRoutingItemDetailList(RequestParams<RoutingItemDetailVO> requestParams);
	List<RoutItemInfoVO> getRoutItemInfo(RequestParams<RoutItemInfoVO> requestParams);

    //공정별 불량정보
	List<RoutBadVO> getRoutBadList(RequestParams<RoutBadVO> requestParams);
	//공정별 검사종류
	List<RoutBadVO> getRoutQcGbnList(RequestParams<RoutBadVO> requestParams);
	
}