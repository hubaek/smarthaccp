<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 작업지시등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:layout name="base">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/PRD101.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">         
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                	<ppm:tr>                         	
	                    <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                         <ppm:td label='계획일자' width="230px">
                         	<ppm:period-picker toId="planDt" />
                        </ppm:td>    
                        <ppm:td label='품목유형' width="230px">
                     		<ppm:common-code mainCd="ITEM_TYPE" data1="P" dataPath="itemType"  emptyText="전체" name = "itemType" />
                        </ppm:td>
                   		<ppm:td label='품목분류' width="320px">
	                        <ppm:item-group/>
                        </ppm:td>    
	                    <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>    
                        </ppm:td>  
                    </ppm:tr> 
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="30%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>생산계획</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll"  id="split-panel-form">
               	<div class="ax-button-group" role="panel-header">
                    <div class="left">
                        <h5><i class="cqc-news"></i> 라우팅정보</h5>                        
                    </div>
	                <div class="right" id = "grid-buttons">
	                    <button type="button" class="btn btn-primary W80" data-grid-view-02-btn="add-order">
							작업편성
	                    </button>
	                </div>
                </div>
               	<div data-ax5grid="grid-view-02" style="height: 250px;"></div>
           		<div class="H10"></div>
               	<div class="ax-button-group" role="panel-header">
                    <div class="left">
                        <h5><i class="cqc-news"></i> 작업지시</h5>                        
                    </div>
	                <div class="right" id = "grid-buttons">
	                    <button type="button" class="btn btn-success W120" data-grid-view-03-btn="item-routing">
	                    	 품목 적용
	                    </button>
	                    <button type="button" class="btn btn-default" data-grid-view-03-btn="item-remove" id="item-remove">
	                        <i class="cqc-minus"></i>
	                        <ppm:lang id="ax.admin.delete"/>
	                    </button>
	                </div>
                </div>
               	<div data-ax5grid="grid-view-03" style="height: 350px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>