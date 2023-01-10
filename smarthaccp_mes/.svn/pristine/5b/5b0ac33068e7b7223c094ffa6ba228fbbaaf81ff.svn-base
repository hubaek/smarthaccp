<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 수입검사등록
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
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/QC050.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
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
                         <ppm:td label='입고일' width="320px">  
                         	<ppm:period-picker fromId="fromDate" toId="toDate" />
                        </ppm:td>
                        <ppm:td label='품목유형' width="230px">
	                        <ppm:common-code mainCd="ITEM_TYPE" emptyText="전체" dataPath="itemType" name="itemType"/>
                        </ppm:td>
                        <ppm:td label='품목분류' width="320px">
	                        <ppm:item-group/>
                        </ppm:td>
                        <ppm:td label="검사상태">
                     		<label class="checkbox-inline"><input type="radio" name="endFlag" data-ax-path="endFlag" value="Y" >검사완료</label>
                     		<label class="checkbox-inline"><input type="radio" name="endFlag" data-ax-path="endFlag" value="N" checked>미검사</label>
                        </ppm:td>
                    </ppm:tr>
                    <ppm:tr>
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>    
                        </ppm:td>
	                    <ppm:td label='거래처' width="320px">
	                        <ppm:search-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL"/>
                        </ppm:td>  
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="40%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>검사대상 목록</h5>
                    </div>
                        <div class="right">
		                    <button type="button" class="btn btn-fn1 W80" data-grid-view-01-btn="qc-in">
		                        	검사완료
		                    </button>
                        </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>