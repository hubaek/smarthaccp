<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 자재투입 등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="pop_modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/out-stock-modal.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">자재투입</h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
             <div class="form-inline">
                 <div class="form-group">
                    <font color="blue" size="4">바코드 스캔::</font>
					<input  type="text" class="form-control W200" onKeyDown="onKeyDown();" id="barcode"   value="" autocomplete="off"/>
					<button type="button" class="btn btn-default W50" data-page-btn="search"><i class="cqc-cw"></i></button>
		            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
            	</div>
            </div>
        </ppm:page-buttons>
        <div class="container-fluid">
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
					        <div class="ax-button-group">
					            <div class="left">
					                <h4><i class="cqc-list"></i>BOM</h4>
					            </div>
					            <div class ="right">
				            		<div class="H10"></div>
				               		<label class="checkbox-inline"><input type="radio" name="bomType" style="font-size:15px; width:25px;height:25px" value="Y" checked>양품대비</label>
				               		<label class="checkbox-inline"><input type="radio" name="bomType" style="font-size:15px; width:25px;height:25px" value="N">오더대비</label>
				            		<div class="H10"></div>
					            </div>   
					        </div>
					        <div data-ax5grid="grid-view-01" style="height: 240px"></div>
		                </div>
		            </div>
		        </div>
		    </div>
            <div class="H5"></div>     
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
					        <div class="ax-button-group">
					            <div class="left">
					                <h4><i class="cqc-list"></i>자재 재고현황</h4>
					            </div>                  
					        </div>
					        <div data-ax5grid="grid-view-02" style="height: 240px"></div>
		                </div>
		            </div>
		        </div>
		    </div>
            <div class="H5"></div>       
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
					        <div class="ax-button-group">
					            <div class="left">
					                <h4><i class="cqc-list"></i>자재투입현황</h4>
					            </div>                 
					            <div class ="right">
				            		<div class="H10"></div>
				               		<label class="checkbox-inline"><input type="radio" name="discardYn" style="font-size:15px; width:25px;height:25px" value="N" checked>자재투입</label>
				               		<label class="checkbox-inline"><input type="radio" name="discardYn" style="font-size:15px; width:25px;height:25px" value="Y">자재폐기</label>
				            		<div class="H10"></div>
					            </div>      
					        </div>
					        <div data-ax5grid="grid-view-03" style="height: 260px"></div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
        <div class="H30"></div>       
    </jsp:body>
</ppm:layout>