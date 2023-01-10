<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 작업표준서
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
	<style>
		.wrap{
		    width: 1370px;
		    height: 820px;
		    overflow-x: scroll;
		    white-space:nowrap
		}
	   
	   .wrap img{
	       width:1370px;
	       height:100%;
	   	}
	</style>
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/wo-doc-modal.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>작업표준서 조회
        </h1>
    </jsp:attribute>  
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
        	<button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
            <button type="button" class="btn btn-info W80" data-page-btn="page1" id = "page1">1</button>
            <button type="button" class="btn btn-info W80" data-page-btn="page2" id = "page2">2</button>
            <button type="button" class="btn btn-info W80" data-page-btn="page3" id = "page3">3</button>
            <button type="button" class="btn btn-info W80" data-page-btn="page4" id = "page4">4</button>
            <button type="button" class="btn btn-info W80" data-page-btn="page5" id = "page5">5</button>
            <button type="button" class="btn btn-info2 W80" data-page-btn="img-plus" id="img-plus">+</button>
            <button type="button" class="btn btn-info2 W80" data-page-btn="img-minus" id="img-minus">-</button>
            <button type="button" class="btn btn-default W120" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
  		<div class="wrap">
	    	<img id="woDoc"  class="drag"/>
		</div>
    </jsp:body>
</ppm:layout>