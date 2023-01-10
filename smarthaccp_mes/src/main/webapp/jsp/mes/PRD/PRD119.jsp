<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 불량현황
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
        <script type="text/javascript" src="<c:url value='assets/PRD119.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">       
            	<ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>                         	
	                    <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                         <ppm:td label='작업일자' width="320px">
                         	<ppm:period-picker fromId="fromStartDt" toId="toStartDt" />
                        </ppm:td>   
                        <ppm:td label='공정' width="250px">
                     		<ppm:rout-code name="routCd" emptyText="전체" emptyValue=""/>
                        </ppm:td>       
                    </ppm:tr> 
                    <ppm:tr> 
                        <ppm:td label='설비' width="320px">
	                        <ppm:search-modal codeName="equipCd" valueName="equipNm"  modalType="EQUIP-MODAL"/>    
                        </ppm:td>       
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>    
                        </ppm:td>
                        <ppm:td label='불량명' width="230px">
                        	<input type="text" name="badNm" class="form-control" value=""/>
                        </ppm:td> 
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="horizontal">        	
           <div class="ax-button-group" data-fit-height-aside="grid-view-01">
	           <div class="left">
	              <h5><i class="cqc-list"></i>작업지시별 불량 목록</h5>
	           </div>
           </div>
 		<div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 600px"></div>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>