<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 구매단가일괄변경
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
        <script type="text/javascript" src="<c:url value='assets/PC032.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="신규" function2Label="수정"></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">       
            	<ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>                        
	                    <ppm:td label='회사' width="230px">     
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                         <ppm:td label='등록일' width="320px"> 
                         	<ppm:period-picker fromId="fromDate" toId="toDate" dateType="MON"/>
                        </ppm:td> 
                    	<ppm:td label='구매번호' width="230px">
                        	<input type="text" name="slipCd" class="form-control" value=""/>
                        </ppm:td>     
                    </ppm:tr> 
                    <ppm:tr>             
	                    <ppm:td label='거래처' width="320px">
	                        <ppm:search-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL" whereValue="20"/>
                        </ppm:td>             
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL" whereValue="I"/>    
                        </ppm:td>      
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
        </div>
        <div class="ax-button-group" data-fit-height-aside="grid-view-01">
            <div class="left">
                <h5><i class="cqc-uh-list-view"></i>구매입고 상세 품목</h5>
            </div>
        </div>                
        <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
    </jsp:body>
</ppm:layout>