<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 
 * 3. Comment 	: 생산현황 모니터링
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="POP_PRD"/>
<ppm:set key="page_auto_height" value="false"/>
<ppm:layout name="pop">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/MT-PRD100.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    	<script type="text/javascript" src="<c:url value='/assets/js/socket-common.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
            <h1 style="margin-bottom:10px; margin-top:10px; font-size:40px"><i class="cqc-list"></i><span class ="todayDate"></span> 생산현황</h1>
			<ppm:form name="searchView0">
 				<div data-ax5grid="grid-view-01"  style="height: 1040px"></div>
			</ppm:form>
    </jsp:body>
</ppm:layout>
<style>
td.hasBorder{
    box-shadow: inset 0px 0px 1px 1px #0581f2;
    background: black;
    color: darkorange;
}
</style>