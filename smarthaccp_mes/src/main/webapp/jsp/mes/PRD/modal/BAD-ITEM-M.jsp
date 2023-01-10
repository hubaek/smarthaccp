<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 자재출고 등록
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
        <script type="text/javascript" src="<c:url value='assets/BAD-ITEM-M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">불량등록</h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
		<div id="modal-content" style="height:720px;">
	        <div class="ax-button-group">
	            <div class="left">
	                <h4><i class="cqc-list"></i>불량유형</h4>
	            </div>                  
                <div class="right">
            		<button type="button" class="btn btn-success W80" data-grid-view-01-btn="out-item">
                		 불량등록
            		</button>
              	</div> 
	        </div>
	        <div data-ax5grid="grid-view-01" style="height: 280px"></div>
	        
            <div class="H10"></div>  
	        <div class="ax-button-group">
	            <div class="left">
	                <h4><i class="cqc-list"></i>불량현황</h4>
	            </div>                    
                <div class="right">
            		<button type="button" class="btn btn-success W80" data-grid-view-02-btn="return-item">
                		 불량취소
            		</button>
              	</div>
	        </div>
	        <div data-ax5grid="grid-view-02" style="height: 280px"></div>
        </div>
    </jsp:body>
</ppm:layout>