<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 결재관리
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
        <script type="text/javascript" src="<c:url value='assets/APPR000.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function4Label="승인" function5Label="반려"></ppm:page-buttons>
        <div role="page-header">
        	<ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="800px" id="120px">
                    <ppm:tr> 
                        <ppm:td label='회사' width="250px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>                    	
                        <ppm:td label="점검일자" width="300px">
                     		<ppm:period-picker fromId="fromDate" toId="toDate" dateType="MON"/>
                        </ppm:td>
                        <ppm:td label='통합검색' width="400px">
                            <ppm:input type="text" name="writer" clazz="form-control" placeholder="문서구분, 기안자, 승인자"/>
                        </ppm:td>               	
                        <ppm:td label="상태" width="270px">
                     		<ppm:common-code mainCd="STATUS" emptyText="전체" emptyValue="" exceptValue="10" dataPath="approvalStateCd" name="approvalStateCd"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="45%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>결재진행 및 완료 목록</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>