<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 김회재
 * 2. 작성일		: 2020.12.18
 * 3. Comment 	: 여과공정CCP2-P
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
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/HACCP400.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute> 
    <jsp:body>
        <ppm:page-buttons function1Label="상신" function4Label="승인" function5Label="반려"></ppm:page-buttons> 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>
                    	<ppm:td label='CCP유형' width="250px" required="true"> 
                         	<ppm:common-code mainCd="CCP_ITEM" dataPath="templateId" name="templateId"/>
                        </ppm:td>
                    	<ppm:td label='점검일자' width="450px">
                         	<ppm:period-picker fromId="fromDate" toId="toDate" dateType="MON"/>
                        </ppm:td>
                        <ppm:td label='작성자' width="250px">
		                	<ppm:input type="text" name="writer" clazz="form-control"/> 
                        </ppm:td>
                        <ppm:td label='승인자' width="250px">
		                	<ppm:input type="text"  name="approver" clazz="form-control"/> 
                        </ppm:td>                    	
                         <ppm:td label="상태" width="270px">
                     		<ppm:common-code mainCd="STATUS" emptyText="전체" emptyValue="" dataPath="status" name="status"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H10"></div>
        </div>
                <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="35%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h2><i class="cqc-list"></i>목록</h2>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>