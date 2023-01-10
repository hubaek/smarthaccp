<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_auto_height" value="false"/>
<ppm:layout name="pop">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/barcode-main.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
					        <div role="page-header" id='pageHeader' style ="text-align:center;background-color:black;color:white">
					        	<h1>바코드재발행</h1>
					        </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
        <div class="H10"></div>        
    	<div class="container-fluid">
	        <div class="row clearfix">
	        	<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
			                <div class="ax-button-group" > 
			                    <div class="left">
		                            <div class="form-inline">
		                                <div class="form-group">
					        			   <button type="button" class="btn btn-default W40" data-grid-view-01-btn="full-size"><i class="cqc-resize"></i></button>
					        			   <button type="button" class="btn btn-default W40" data-grid-view-01-btn="small-size"><i class="cqc-resize2"></i></button>
					        			 </div>
					       			</div>
			           			</div>  
			                    <div class="right">  
		                            <div class="form-inline">
		                                <div class="form-group">
        								   <button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
									       <button type="button" class="btn btn-info W100" data-grid-view-01-btn="search-barcode"><i class="cqc-barcode2" style="font-size:20px"></i> 조회</button>
								   		   <button type="button" class="btn btn-default W80" data-grid-view-01-btn="close">닫기</button>
								
			           					</div>
			           				</div>
			           			</div>
			           		</div>
						</div>
					</div>
				</div>
			</div>
		    <div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
				            <ppm:form name="searchView0">
				                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
				                    <ppm:tr>        
					               		<ppm:td label="창고유형" width="250px">
				                 			<ppm:common-code mainCd="WH_TYPE" dataPath="whType" name="whType" defaultValue="30" emptyText="전체"/>
					               		</ppm:td>   
				                        <ppm:td label='공정분류' width="400px">
				                            <div class="form-inline">
				                                <div class="form-group">
						                            <ppm:common-code mainCd="ROUT_TYPE" dataPath="routType" id="routType" name="routType" emptyText="공정분류 선택" emptyValue="" data1="Y"/>
						                            <ppm:rout-code dataPath="routCd" name="routCd" id="routCd"  emptyText="공정 선택" emptyValue=""/>
				                       			</div>
				                       		</div>
				                        </ppm:td>
					               		<ppm:td label="품목코드/명" width="450px">
				                            <div class="form-inline">
				                                <div class="form-group">
                        							<input type="text" name="itemCd" class="form-control" value=""/>
                        							<input type="text" name="itemNm" class="form-control" value=""/>
					               				</div>
					               			</div>
					               		</ppm:td>   
				                    </ppm:tr>
				                </ppm:tbl>
				            </ppm:form>
		                </div>
            			<div class="H10"></div>  
		                <div data-ax5grid="grid-view-01"  style="height: 800px"></div>
		            </div>
		        </div>
		    </div>
            <div class="H10"></div>  
	    </div>
    </jsp:body>
</ppm:layout>