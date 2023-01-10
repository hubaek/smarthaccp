<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 바코드발행
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
        <script type="text/javascript" src="<c:url value='assets/barcode-modal.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
        <script type="text/javascript" src="<c:url value='/assets/js/socket-common.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">바코드분할</h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
        	<button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
            <button type="button" class="btn btn-default W120" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <div class="container-fluid">
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
					        <div class="ax-button-group">
					            <div class="left">
					                <h4><i class="cqc-list"></i>지시 바코드</h4>
					            </div>
					            <div class="right">
					           		<button type="button" class="btn btn-warning W120" data-grid-view-01-btn="divide-barcode"  style='background-color:orange'><i class="cqc-sitemap2" style="font-size:20px"></i> 바코드 분할</button>
					            	<!-- <button type="button" class="btn btn-success W120" data-grid-view-01-btn="divide-box"><i class="cqc-box" style="font-size:20px"></i> 박스바코드 발행</button>-->
					            </div> 
					        </div>
					        <div data-ax5grid="grid-view-01" style="height: 110px"></div>
		                </div>
		            </div>
		        </div>
		    </div>
	        <div class="H10"></div>
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">  
		                <div class="x_content">
		                	<ppm:tab-layout name="tab1"  style="height:630px">
					    		<ppm:tab-panel label="바코드 발행현황" scroll="scroll">   
	            					<div class="H10"></div>
					    			<div class="ax-button-group">
							            <div class="left">	
				                        	<div id="client-output"></div>
							            </div>          
				                        <div class="right">
				                        	<button type="button" class="btn btn-default W100" data-grid-view-02-btn="all-print"><i class="cqc-barcode2" style="font-size:20px"></i> 인쇄</button>
						       				<button type="button" class="btn btn-info W100" style="background-color:red" data-grid-view-02-btn="all-print-cancel"><i class="cqc-barcode2" style="font-size:20px"></i> 취소</button> 
				                        </div>        
							        </div>
							        <div data-ax5grid="grid-view-02" style="height: 500px"></div>
					    		</ppm:tab-panel>   
					    		<!-- 
					    		<ppm:tab-panel label="박스바코드 발행현황" scroll="scroll">   
					    			<div class="H10"></div>
					    			<div class="ax-button-group">
							            <div class="left">	
							            </div>          
				                        <div class="right">
				                        	<button type="button" class="btn btn-default W100" data-grid-view-03-btn="all-print"><i class="cqc-barcode2" style="font-size:20px"></i> 전체인쇄</button>
						       				<button type="button" class="btn btn-info W100" style="background-color:red" data-grid-view-03-btn="all-print-cancel"><i class="cqc-barcode2" style="font-size:20px"></i> 전체취소</button> 
				                        </div>        
							        </div>
							         <div data-ax5grid="grid-view-03" style="height: 500px"></div>
					    		</ppm:tab-panel>  
					    		-->    
					    	</ppm:tab-layout>
					        
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
        <div class="H20"></div>     
    </jsp:body>
</ppm:layout>
<style>
div[ data-ax5grid="grid-view-01"] td[data-ax5grid-column-col="1"] span{
	margin-right: 5px;
}
div[ data-ax5grid="grid-view-01"] td[data-ax5grid-column-col="2"] span{
	margin-right: 5px;
}
div[ data-ax5grid="grid-view-01"] td[data-ax5grid-column-col="3"] span{
	margin-right: 5px;
}
div[ data-ax5grid="grid-view-01"] td[data-ax5grid-column-col="4"] span{
	margin-right: 5px;
}
div[ data-ax5grid="grid-view-01"] td[data-ax5grid-column-col="5"] span{
	margin-right: 5px;
}
div[ data-ax5grid="grid-view-02"] td[data-ax5grid-column-col="3"] span{
	margin-right: 5px;
}
div[ data-ax5grid="grid-view-02"] td[data-ax5grid-column-col="4"] span{
	margin-right: 5px;
}
</style>