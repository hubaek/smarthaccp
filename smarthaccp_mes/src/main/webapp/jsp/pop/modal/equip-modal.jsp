<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 설비등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="pop_modal">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/equip-modal.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
            설비등록 
            <!-- (가동,비가동상태인 설비는 조회되지 않습니다.) -->
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
        	<button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
            <button type="button" class="btn btn-info2 W120" data-page-btn="choice">설비등록</button>
            <button type="button" class="btn btn-default W120" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <div class="container-fluid">
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-6">
	                <div class="x_panel">
		                <div class="x_content">
                			<div data-ax5grid="grid-view-01" style="height: 700px;"></div>
		                </div>
		            </div>
		        </div>
		        <div class="col-lg-6 col-md-6">
	                <div class="x_panel">
		                <div class="x_content">
                			<div data-ax5grid="grid-view-02" style="height: 700px;"></div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
        <div class="H30"></div>       
    </jsp:body>
</ppm:layout>