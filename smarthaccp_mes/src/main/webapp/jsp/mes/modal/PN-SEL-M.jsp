<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: PN 적용 팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="pageName" value="item search"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/PN-SEL-M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
        <script type="text/javascript" src="<c:url value='/assets/js/item-common.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">      
        <h1 class="title">
            <i class="cqc-browser"></i>
            PN 적용
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-info W70" data-page-btn="choice">적용</button>
            <button type="button" class="btn btn-default W70" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="100%" style="padding-right: 10px;">
                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h2><i class="cqc-list"></i></h2>
                    </div>
	                <div class="right" id = "grid-buttons">
            			<button type="button" class="btn btn-info W80" data-grid-view-01-btn="item-call">불러오기</button>
	                    <button type="button" class="btn btn-default W80" data-grid-view-01-btn="item-add">
	                        <i class="cqc-plus"></i>
	                        <ppm:lang id="ax.admin.add"/>
	                    </button>
	                    <button type="button" class="btn btn-default W80" data-grid-view-01-btn="item-remove">
	                        <i class="cqc-minus"></i>
	                        <ppm:lang id="ax.admin.delete"/>
	                    </button>
	                </div>
                </div>
                <div id="gridView01" data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>

    </jsp:body>
</ppm:layout>