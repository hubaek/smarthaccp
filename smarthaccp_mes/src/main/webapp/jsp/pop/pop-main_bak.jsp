<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: POP메인
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="POP_메인화면"/>
<ppm:set key="page_auto_height" value="false"/>
<ppm:layout name="pop">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/pop-main.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    	<script type="text/javascript" src="<c:url value='/assets/js/socket-common.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
					        <div role="page-header" id='pageHeader' style ="text-align:center;background-color:black;color:white">
					        	<h1><span id="headerString">-</span></h1>
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
           				<ppm:form name="searchView0">
		                <div class="x_content">
			              <div style="display: flex;">
			               <div style="flex: 6.5;"> 
			                <div class="ax-button-group" > 
			                    <div class="left">
		                            <div class="form-inline">
		                                <div class="form-group">
					        			   <button type="button" class="btn btn-default W40" data-grid-view-01-btn="full-size"><i class="cqc-resize"></i></button>
					        			   <button type="button" class="btn btn-default W40" data-page-btn="search"><i class="cqc-cw"></i></button>
					        			   <button type="button" class="btn btn-info W40" style="background-color:red" data-page-btn="search">Clear</button>
					        			 </div>
					       			</div>
			           			</div>  
			                    <div class="right">
		                            <div class="form-inline">
		                                <div class="form-group">
		                                	<ppm:common-code mainCd="ROUT_TYPE" dataPath="routType" id="routType" emptyText="공정분류 선택" emptyValue="" data1="Y"/>
		                                	<ppm:common-code mainCd="ORDER_ST" emptyText="전체" id="orderType" emptyValue="" dataPath="orderSt" name="orderSt"/>
									       <button type="button" class="btn btn-info W100" data-grid-view-01-btn="search-man" id ="search-man"><i class="cqc-emoji-flirt" style="font-size:20px"></i> 작업자등록</button> 
									       <button type="button" class="btn btn-info W100" data-grid-view-01-btn="change-equip" id ="change-equip"> 설비등록</button> 
									       <button type="button" class="btn btn-info W100" data-grid-view-01-btn="out-item" id="out-item"><i class="cqc-flow-tree" style="font-size:20px"></i> 자재투입</button>
									       <button type="button" class="btn btn-info2 W100" data-grid-view-01-btn="in-item" id="in-item"><i class="cqc-plus2" style="font-size:20px"></i> 양품등록</button> 
									       <button type="button" class="btn btn-info3 W100" data-grid-view-01-btn="in-bad-item" id="in-bad-item"><i class="cqc-minus2" style="font-size:20px"></i> 불량등록</button> 
									       <button type="button" class="btn btn-info W100" style="background-color:green" data-grid-view-01-btn="start-order" id="start-order"><i class="cqc-controller-play" style="font-size:20px"></i> 작업시작</button>			           					
									    </div>
			           				</div>
			           			</div>
			           		</div>
			                <div class="ax-button-group" > 
			                    <div class="left">
		                            <div class="form-inline">
		                                <div class="form-group">
					        			   <button type="button" class="btn btn-default W40" data-grid-view-01-btn="small-size"><i class="cqc-resize2"></i></button>
					        			   <button type="button" class="btn btn-default W40" data-grid-view-01-btn="setup-modal" id = "setup-modal"><i class="cqc-cog" style="font-size:20px"></i></button>
			           						<button type="button" class="btn btn-default W40" data-grid-view-01-btn="menu-modal" id = "menu-modal"><i class="cqc-menu" style="font-size:20px"></i></button>
			           					</div>
			           				</div>
			           			</div>
			                    <div class="right">
		                            <div class="form-inline">
		                                <div class="form-group">
		                     			   <ppm:rout-code dataPath="routCd" id="routCd" emptyText="공정 선택" emptyValue=""/>
									       <button type="button" class="btn btn-info W100" data-grid-view-01-btn="search-order" id="search-order"><i class="cqc-magnifier" style="font-size:20px"></i> 작업조회</button>
									       <button type="button" class="btn btn-info W100" data-grid-view-01-btn="search-nwrk" id="search-nwrk"><i class="cqc-warning" style="font-size:20px;color:red"></i> 비가동</button>	 
									       <button type="button" class="btn btn-info W100" data-grid-view-01-btn="barcode-print" id="barcode-print"><i class="cqc-uh-printer" style="font-size:20px"></i> 바코드인쇄</button>
									       <button type="button" class="btn btn-info W100" data-grid-view-01-btn="barcode-out" id="barcode-out"><i class="cqc-barcode2" style="font-size:20px"></i> 바코드발행</button>
					        			   <button type="button" class="btn btn-info W100" data-grid-view-01-btn="wo-doc" id="wo-doc"><i class="cqc-clipboard2" style="font-size:20px"></i>작업표준서</button>
									       <button type="button" class="btn btn-info W100" style="background-color:red" data-grid-view-01-btn="end-order" id="end-order"><i class="cqc-controller-stop" style="font-size:20px"></i> 작업종료</button>
			           					</div>
			           				</div>
			           			</div>
			           		</div>
			           	   </div>
			           	    
			           	    <div style="flex:1; margin-left: 3px; margin-top: 1px;">
			           	    
				           		 <div style="display: flex;">
				           		 	<!--  
			               		   <div style="flex: 1;"> 
						           		<button type="button" class="btn btn-info W100" style="background-color:#FF8000; height: 76px;" data-grid-view-01-btn="pop-in-out-item" id="inout-item"> 출고등록</button>
				           		   </div>
				           		   <div style="flex: 1;"> 
						           		<button type="button" class="btn btn-info W100" style="background-color:#FF8000; height: 76px;" data-grid-view-01-btn="pop-in-out-item" id="inout-item"> 출고등록</button>
				           		   </div>
				           		    -->
				           		   <div style="flex: 1;"> 
					           		 <div class="ax-button-group" style="margin-left: 3px;"> 
					                    <div class="left">
				                            <div class="form-inline">
				                                <div class="form-group">
											       <button type="button" class="btn btn-info W100 H75" style="background-color:#FF8000; " data-grid-view-01-btn="pop-in-out-item" id="inout-item"> 제품출하<br>(출하창고)</button>
											       <!--  <button type="button" class="btn btn-info2 W100" data-grid-view-01-btn="st-search11" id="st-search11">재고현황</button> -->
					           					</div>
					           				</div>
					           				<!-- <div class="form-inline" style="margin-top: 4px;"> -->
				                                <!-- <div class="form-group"> -->
											     <!--  <button type="button" class="btn btn-info W100" style="background-color:#FF8000; " data-grid-view-01-btn="pop-in-out-item2" id="inout-item2"> 원재료 입고/출고</button> -->
											       <!--  <button type="button" class="btn btn-info2 W100" data-grid-view-01-btn="pop-in-out-item" id="pop-in-out-item">재고현황123</button>  -->
					           					<!--</div>-->
					           				<!-- </div> -->
					           			</div>
					           		</div>
					           	  </div>
					           	  <div style="flex: 1;"> 
					           		 <div class="ax-button-group" style="margin-left: 3px;"> 
					                    <div class="left">
				                            <div class="form-inline">
				                                <div class="form-group">
											       <button type="button" class="btn btn-info W100" style="background-color:#6464CD; " data-grid-view-01-btn="pop-in-out-item2" id="inout-item2"> 원재료 입고</button>											       
					           					</div>
					           				</div>
					           				<div class="form-inline" style="margin-top: 4px;">
				                                <div class="form-group">
											       <button type="button" class="btn btn-info W100" style="background-color:#6464CD; " data-grid-view-01-btn="pop-in-out-item3" id="inout-item3"> 원재료 출고</button>											      
					           					</div>
					           				</div>
					           			</div>
					           		</div>
					           	  </div>
					           	   <div style="flex: 1;"> 
					           		 <div class="ax-button-group" style="margin-left: 3px;"> 
					                    <div class="left">
				                            <div class="form-inline">
				                                <div class="form-group">
											       <button type="button" class="btn btn-info2 W110" data-grid-view-01-btn="st-search" style="background-color:#0080ff; id="st-search">생산창고재고현황</button>
											       <!--  <button type="button" class="btn btn-info2 W100" data-grid-view-01-btn="st-search11" id="st-search11">재고현황</button> -->
					           					</div>
					           				</div>
					           				<div class="form-inline" style="margin-top: 4px;">
				                                <div class="form-group">
											       <button type="button" class="btn btn-info W110" data-grid-view-01-btn="st-add" style="background-color:#0080ff; id="st-add">생산창고재고실사</button>
											       <!--  <button type="button" class="btn btn-info2 W100" data-grid-view-01-btn="pop-in-out-item" id="pop-in-out-item">재고현황123</button>  -->
					           					</div>
					           				</div>
					           			</div>
					           		</div>
					           	  </div>
					           	  <div style="flex: 1;"> 
					           		 <div class="ax-button-group" style="margin-left: 3px;"> 
					                    <div class="left">
				                            <div class="form-inline">
				                                <div class="form-group">
											       <button type="button" class="btn btn-info2 W110" data-grid-view-01-btn="sa-search" style="background-color:#ff8100; id="sa-search">출하창고재고현황</button>
											       <!--  <button type="button" class="btn btn-info2 W100" data-grid-view-01-btn="st-search11" id="st-search11">재고현황</button> -->
					           					</div>
					           				</div>
					           				<div class="form-inline" style="margin-top: 4px;">
				                                <div class="form-group">
									 		       <button type="button" class="btn btn-info W110" data-grid-view-01-btn="sa-add" style="background-color:#ff8100; id="sa-add">출하창고재고실사</button>
											       <!--  <button type="button" class="btn btn-info2 W100" data-grid-view-01-btn="pop-in-out-item" id="pop-in-out-item">재고현황123</button>  -->
					           					</div>
					           				</div>
					           			</div>
					           		</div>
					           	  </div>
				           	   </div>
				            </div>
			           	  </div>
			           		
			              <div class="H5"></div>
			              <div data-ax5grid="grid-view-01"  style="height: 430px"></div>
						</div>
					  </ppm:form>
					</div>
				</div>
			</div>
       		<div class="H10"></div>
	        <div class="row clearfix">
	        	<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
						<ppm:tab-layout name="ax1"  style="height:370px">
				    		<ppm:tab-panel label="작업자 현황" scroll="scroll">   
            					<div class="H10"></div>
				    			<div class="ax-button-group">   
			                        <div class="right">
			                            <div class="form-inline">
			                                <div class="form-group">
			                                	<!-- 
			                                	<button type="button" class="btn btn-info W100" data-grid-view-02-btn="add-workman" id="add-workman"><i class="cqc-plus2" style="font-size:20px"></i> 작업자등록</button> 
								       			 -->  
								       			<button type="button" class="btn btn-default W100" data-grid-view-02-btn="del-workman" id="del-workman"><i class="cqc-minus2" style="font-size:20px"></i> 작업자삭제</button> 
						        			 </div>
						       			</div>
			                        </div>
			                    </div>
			                    <div data-ax5grid="grid-view-02" style="height: 250px;"></div>
				    		</ppm:tab-panel>    
				    		<ppm:tab-panel label="자재투입현황" scroll="scroll">   
				    			<div class="ax-button-group">   
				                        <div class="right">
				                        </div>
				                    </div>
				                    <div data-ax5grid="grid-view-03" style="height: 250px;"></div>
				    		</ppm:tab-panel>    
				    		<ppm:tab-panel label="불량등록현황" scroll="scroll">   
				    			<div class="ax-button-group">   
				                        <div class="right">
				                        </div>
				                    </div>
				                    <div data-ax5grid="grid-view-05" style="height: 250px;"></div>
				    		</ppm:tab-panel>    
				    		<ppm:tab-panel label="생산실적현황" scroll="scroll">   
				    			<div class="ax-button-group">   
				                        <div class="right">
				                        </div>
				                    </div>
				                    <div data-ax5grid="grid-view-06" style="height: 250px;"></div>
				    		</ppm:tab-panel>    
				    	</ppm:tab-layout>	
    				</div>
	    		</div>
	    	</div>
	    </div>
    </jsp:body>
</ppm:layout>
<style>
td[data-ax5grid-column-col="6"] span{
	margin-right: 5px;
}
td[data-ax5grid-column-col="7"] span{
	margin-right: 5px;
}
td[data-ax5grid-column-col="8"] span{
	margin-right: 5px;
}
td[data-ax5grid-column-col="9"] span{
	margin-right: 5px;
}
</style>