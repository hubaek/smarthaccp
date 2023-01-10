<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 품목 적용 팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="pageName" value="item search"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>

<ppm:layout name="pop_modal">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/POP-ITEM-SEL-M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
			            품목조회
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-info W50" data-page-btn="search"><ppm:lang id="ax.admin.sample.modal.button.search"/></button>
            <button type="button" class="btn btn-success W50" data-page-btn="apply" ><ppm:lang id="ax.admin.sample.modal.button.apply"/></button>
            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                   	<ppm:tr>  
                        <ppm:td label='품목코드' width="33%">
                        	<input type="text" name="itemCd" class="form-control" value="" style="width:fit-content"/>
                        </ppm:td>
                        <ppm:td label='품명' width="33%">
                        	<input type="text" name="itemNm" class="form-control" value="" style="width:fit-content"/>
                        </ppm:td>
                        <ppm:td label='규격' width="33%">
                        	<input type="text" name="spec" class="form-control" value="" style="width:fit-content"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="100%" style="padding-right: 10px;">
                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h2><i class="cqc-list"></i></h2>
                    </div>
                </div>
                <div class="gird-view-01" data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>

    </jsp:body>
</ppm:layout>