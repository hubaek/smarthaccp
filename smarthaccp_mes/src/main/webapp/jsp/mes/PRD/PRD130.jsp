<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산실적수정
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
        <script type="text/javascript" src="<c:url value='assets/PRD130.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="취소"></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>                         	
	                    <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                         <ppm:td label='지시일자' width="320px">
                         	<ppm:period-picker fromId="fromDate" toId="toDate" />
                        </ppm:td> 
                        <ppm:td label='공정분류' width="230px">
	                        <ppm:common-code mainCd="ROUT_TYPE" dataPath="routType" name="routType" emptyText="전체" emptyValue="" />
                        </ppm:td>
                        <ppm:td label='공정' width="230px">
                     		<ppm:rout-code dataPath="routCd" name="routCd" emptyText="전체" emptyValue=""/>
                        </ppm:td>  
                    </ppm:tr>
                    <ppm:tr>
                    	<ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>    
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
        </div>
        <ppm:split-layout name="ax1" orientation="horizontal">
            <ppm:split-panel height="45%" style="padding-bottom: 10px;"  id = "header-split-panel">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>작업지시 목록</h5>
                    </div>
                </div>               
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel height="55%" style="padding-top: 0px;" scroll="scroll" id="split-panel-bottom">     
	        	<div class="H5"></div>
    			<div class="ax-button-group">   
    				<div class="left">
                        <h5><i class="cqc-list"></i>자재 상세</h5>
                    </div>
	                  <div class="right">
		                <button type="button" class="btn btn-success W80" data-grid-view-02-btn="out-stock">
		                     	자재적용
		                </button>
	                  </div>
	              </div>
	              <div id="grid02" data-ax5grid="grid-view-02" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>