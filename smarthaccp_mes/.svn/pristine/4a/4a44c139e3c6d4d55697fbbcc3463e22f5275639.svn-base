<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 구매/영업 적용 팝업 (발주서)
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/PC040R.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">구매취소 적용</h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-info W50" data-page-btn="search"><ppm:lang id="ax.admin.sample.modal.button.search"/></button>
            <button type="button" class="btn btn-fn1 W50" data-page-btn="choice" id ="choice_btn">적용</button>
            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>                         	
                        <ppm:td label='회사' width="250px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>      
                         <ppm:td label='등록일' width="320px">
                         	<ppm:period-picker fromId="fromDate" toId="toDate" />
                        </ppm:td>          
                        <ppm:td label='구매번호' width="250px">
                        	<input type="text" name="slipCd" class="form-control" value=""/>
                        </ppm:td>
                    </ppm:tr> 
                   	<ppm:tr>  
                        <ppm:td label='품목코드' width="250px">
                        	<input type="text" name="itemCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='품명' width="250px">
                        	<input type="text" name="itemNm" class="form-control" value=""/>
                        </ppm:td> 
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
      	<ppm:tab-layout name="tab1" data_fit_height_content="layout-view-01" style="height:100%;">
       		<ppm:tab-panel label="구매취소적용 (LIST)" scroll="scroll">   
                <div data-ax5grid="grid-view-03" style="height: 530px;"></div>
   			</ppm:tab-panel>		
       		<ppm:tab-panel label="구매취소적용 (건별)" scroll="scroll">   
                <div data-ax5grid="grid-view-01" style="height: 210px"></div>
           			<div class="H10"></div>
                <div data-ax5grid="grid-view-02" style="height: 310px;"></div>
   			</ppm:tab-panel>	   	
   		</ppm:tab-layout>
    </jsp:body>
</ppm:layout>