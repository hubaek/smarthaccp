<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 작업지시조회
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
        <script type="text/javascript" src="<c:url value='assets/order-modal.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>작업지시조회 
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
             <div class="form-inline">
                 <div class="form-group">
                    <font color="blue" size="4">바코드 입력 ( 바코드를 스캔 하세요) ::  </font>
					<input  type="text" class="form-control" onKeyDown="onKeyDown();" id="barcode"   value="" autocomplete="off"/>
        			<button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
		            <button type="button" class="btn btn-info W100" data-page-btn="search"><ppm:lang id="ax.admin.sample.modal.button.search"/></button>
					<button type="button" class="btn btn-info2 W120" data-page-btn="choice">작업지시선택</button>
		            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
            	</div>
            </div>
        </ppm:page-buttons>
        <div class="container-fluid">
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
				            <ppm:form name="searchView0">
				                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
				                    <ppm:tr>        
				                        <ppm:td label='공정분류' width="400px">
				                            <div class="form-inline">
				                                <div class="form-group">
						                            <ppm:common-code mainCd="ROUT_TYPE" dataPath="routType" id="routType" emptyText="공정분류 선택" emptyValue="" data1="Y"/>
						                            <ppm:rout-code dataPath="routCd" id="routCd" emptyText="공정 선택" emptyValue=""/>
				                       			</div>
				                       		</div>
				                        </ppm:td>
				                        <ppm:td label='지시일자구분' width="300px">
								            <div class ="right">
							            		<div class="H10"></div>
							               		<label class="checkbox-inline"><input type="radio" name="orderDtYn" style="font-size:17px; width:33px;height:33px" value="Y" checked>오늘이전</label>
							               		<label class="checkbox-inline"><input type="radio" name="orderDtYn" style="font-size:17px; width:33px;height:33px" value="N">전체</label>
							            		<div class="H10"></div>
								            </div>   
				                        </ppm:td>
				                    </ppm:tr>
				                </ppm:tbl>
				            </ppm:form>
		                </div>
		            </div>
		        </div>
		    </div>
            <div class="H10"></div>        
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
                			<div data-ax5grid="grid-view-01" style="height: 630px;"></div>
		                </div>
					</div>
				</div>
			</div>
		</div>
        <div class="H30"></div>       
    </jsp:body>
</ppm:layout>
<style>
div[ data-ax5grid="grid-view-01"] td[data-ax5grid-column-col="6"] span{
	margin-right: 5px;
}
</style>