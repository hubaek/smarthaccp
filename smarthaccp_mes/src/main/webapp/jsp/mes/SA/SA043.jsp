<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: DPIN ERP
 * 1. 작성자  		: 전
 * 2. 작성일		: 2018.06.17
 * 3. Comment 	: 매출-종합집계
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="false"/>  
<ppm:layout name="base"> 
    <jsp:attribute name="css">   
		<link rel="stylesheet" href="/assets/billboard/billboard.css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />   
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SA043.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
        <script type="text/javascript" src="<c:url value='https://d3js.org/d3.v4.min.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
        <script type="text/javascript" src="<c:url value='/assets/billboard/billboard.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons> 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label='회사' width="250px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                        <ppm:td label='기준년도' width="250px">
                     		<ppm:year-code dataPath="inoutYear" id="inoutYear"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H10"></div>
        </div>
        <div class="main-panel">
	    		<div class="x_panel">
					<div class="content">
	                    <div class="row">
							<div class="col-md-2">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i> 월별 매출실적</h5>
					                    </div>
					                </div>    
					                <div data-ax5grid="grid-view-01" style="height: 390px"></div>      
								</div>
							</div>
							<div class="col-md-5">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i>상세</h5>
					                    </div>
					                </div>    
									<div id="graph1" style="height: 390px"></div>               
								</div>
							</div>
							
							<div class="col-md-2">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i> 분기별 매출실적</h5>
					                    </div>
					                </div>    
					                <div data-ax5grid="grid-view-02" style="height: 390px"></div>      
								</div>
							</div>
							<div class="col-md-3">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i>상세</h5>
					                    </div>
					                </div>    
									<div id="graph2" style="height: 390px"></div>               
								</div>
							</div>
	                    </div>
	                    <div class="row">
	                    </div>
	                    <div class="row">
							<div class="col-md-3">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i> 거래처별 년별 매출실적</h5>
					                    </div>
					                </div>    
					                <div data-ax5grid="grid-view-03" style="height: 400px"></div>      
								</div>
							</div>
							<div class="col-md-9">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i> 거래처별 월별매출실적</h5>
					                    </div>
					                </div>    
					                <div data-ax5grid="grid-view-04" style="height: 400px"></div>      
								</div>
							</div>
							<!-- 
							<div class="col-md-9">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i>상세</h5>
					                    </div>
					                </div>    
									<div id="graph3" style="height: 400px"></div>               
								</div>
							</div>
							 -->
	                    </div>
	                    
	                    <div class="row">
							<div class="col-md-5">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i> 매출실적 상위20권</h5>
					                    </div>
					                </div>    
					                <div data-ax5grid="grid-view-05" style="height: 400px"></div>      
								</div>
							</div>
							<div class="col-md-7">
								<div class="x_panel">
					                <div class="ax-button-group">
					                    <div class="left">
					                        <h5><i class="cqc-list"></i> 거래처별 전년대비 비교분석</h5>
					                    </div>
					                </div>    
					                <div data-ax5grid="grid-view-06" style="height: 400px"></div>      
								</div>
							</div>
	                    </div>
	                </div>
	            </div>
	       </div>
    </jsp:body>
</ppm:layout>