<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산자재폐기현황
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
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/PRD122.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
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
                        <ppm:td label='공정' width="230px">
                     		<ppm:rout-code dataPath="routCd" name="routCd" emptyText="전체" emptyValue=""/>
                        </ppm:td>
                    </ppm:tr> 
                    <ppm:tr>      
                    	<ppm:td label='지시번호' width="230px">
                        	<input type="text" name="orderNo" class="form-control" value=""/>
                        </ppm:td>  
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>                               
                        </ppm:td>
                   		<ppm:td label='LOT' width="230px">
                        	<input type="text" name="lotNo" class="form-control" value=""/>
                        </ppm:td>          
                        <ppm:td label='BARCODE' width="230px">
                        	<input type="text" name="barcode" class="form-control" value=""/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="horizontal">        	
           <div class="ax-button-group" data-fit-height-aside="grid-view-01">
	           <div class="left">
	              <h5><i class="cqc-list"></i></h5>
	           </div>
           </div>
 		<div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 600px"></div>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>