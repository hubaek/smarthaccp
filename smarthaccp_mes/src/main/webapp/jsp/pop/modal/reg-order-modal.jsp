<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP 
 * 2. 작성일		: 2021.06.29
 * 3. Comment 	: 작업등록
 */
 --%>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="pop_modal">
    <jsp:attribute name="css">    	
		<style>
			.calculator
			{
			        width:100%;
			        height:70%;
			        background-color:white;
			        border:2px solid white;
			        padding-left:10px;
			        padding-right:5px;
			        padding-bottom:5px;
			}
			.calculator td
			{
			        height:15%;
			}
			.calc_td_result
			{
			        text-align:center;
			}
			.calc_result
			{
			        width:79%;
			        text-align:right;
			}
			.calc_msg
			{
			        width:99%;
			        text-align:right;
			}
			
			.calc_unit
			{
			        width:20%;
			        text-align:center;
			        text-color:red;
			}
			.calc_td_calculs
			{
			        text-align:center;
			}
			.calc_calculs
			{
			        width:90%;
			        text-align:left;
			}
			.calc_td_btn
			{
			        width:17%;
			        height:100%;
			        margin:5px;
			}
			.calc_btn
			{
			        width:100%;
			        height:100%;
			        font-size:60px;
			        color:orange;
			        background-color:black;
			}  
			.calc_btn2 {
			        width:100%;
			        height:100%;
			        font-size:60px;
			        color:white;
			        background-color:black;
			}  
			  
		</style>
    </jsp:attribute>
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/reg-order-modal.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">작업등록</h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
        	<div style="display: inline-block; margin-right: 600px;">
	        	<button type="button" class="btn btn-info W150" data-page-btn="btn-refri" style="background-color: #249b24;">코다리</button>
	        	<button type="button" class="btn btn-info W150" data-page-btn="btn-freeze">기타</button>
        	</div>
        	
        	<button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
            <button type="button" class="btn btn-info2 W120" data-page-btn="reg-order" id="reg-order">작업등록</button>
            <button type="button" class="btn btn-default W120" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <div class="container-fluid" style="margin-top: 30px;">
        	<div class="row clearfix" style="height:100%" id="div-refri">
        		<div style="display: flex;">
	           	  <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 20px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#249b24; font-size: 45px;" data-page-btn="btn-refri-1" id="btn-refri-1"></button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 10px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#249b24; font-size: 45px;" data-page-btn="btn-refri-2" id="btn-refri-2"></button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#249b24; font-size: 45px;" data-page-btn="btn-refri-3" id="btn-refri-3"></button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#249b24; font-size: 45px;" data-page-btn="btn-refri-4" id="btn-refri-4"></button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#249b24; font-size: 45px;" data-page-btn="btn-refri-5" id="btn-refri-5"></button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#249b24; font-size: 45px;" data-page-btn="btn-refri-6" id="btn-refri-6"></button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#249b24; font-size: 45px;" data-page-btn="btn-refri-7" id="btn-refri-7"></button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
				</div>
		    </div>
		    
		    <div class="row clearfix" style="height:100%; display: none;" id="div-freeze">
        		<div style="display: flex;">
	           	  <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 20px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#0079BF; font-size: 40px;" data-page-btn="btn-freeze-1" id="btn-freeze-1">황매실</button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 10px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#0079BF; font-size: 40px;" data-page-btn="btn-freeze-2" id="btn-freeze-2">기타1</button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#0079BF; font-size: 40px;" data-page-btn="btn-freeze-3" id="btn-freeze-3">기타2</button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#0079BF; font-size: 40px;" data-page-btn="btn-freeze-4" id="btn-freeze-4">기타3</button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#0079BF; font-size: 40px;" data-page-btn="btn-freeze-5" id="btn-freeze-5">기타4</button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#0079BF; font-size: 40px;" data-page-btn="btn-freeze-6" id="btn-freeze-6">기타5</button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#0079BF; font-size: 40px;" data-page-btn="btn-freeze-7" id="btn-freeze-7">기타6</button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
	           	   <div style="flex: 1;"> 
	           		 <div class="ax-button-group" style="margin-left: 5px;"> 
	                    <div class="center">
                            <div class="form-inline">
                                <div class="form-group">
							       <button type="button" class="btn btn-info W140 H140" style="background-color:#0079BF; font-size: 40px;" data-page-btn="btn-freeze-8" id="btn-freeze-8">기타7</button>
	           					</div>
	           				</div>
	           			</div>
	           		 </div>
	           	   </div>
	           	   
				</div>
		    </div>
		    
        	<div class="row clearfix" style="margin-top:30px; height:100%;">
        		<div class="col-lg-6 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">
					        <div class="ax-button-group">
					            <div class="left">
					                <h4><i class="cqc-list"></i>품목현황</h4>
					            </div>                  
					        </div>
					        <div style="display: inline-block;">
						        <div data-ax5grid="grid-view-01" style="height: 460px; width: 900px; float: left;"></div>
						        <input type="hidden"  name="calc_result" id="calc_result" class="calc_result" onkeydown="javascript:key_detect_calc('calc',event);"/>
						        <div style="float: right;">
					        		<table class="calculator" id="calc">				                    
							            <tr>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="7" onclick="javascript:add_calc(7);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="8" onclick="javascript:add_calc(8);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="9" onclick="javascript:add_calc(9);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="C" onclick="javascript:add_calc('C');" />
							                </td>
							            </tr>
							            <tr>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="4" onclick="javascript:add_calc(4);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="5" onclick="javascript:add_calc(5);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="6" onclick="javascript:add_calc(6);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="&larr;" onclick="javascript:add_calc('nbs');" />
							                </td>
							            </tr>
							            <tr>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="1" onclick="javascript:add_calc(1);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="2" onclick="javascript:add_calc(2);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="3" onclick="javascript:add_calc(3);" />
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="." onclick="javascript:add_calc('.');" />
							                </td>
							            </tr>
							            <tr>
							                <td class="calc_td_btn">
										    	<input type="button" class="calc_btn" value=" "/>
							                </td>
							                <td class="calc_td_btn">
							                        <input type="button" class="calc_btn" value="0" onclick="javascript:add_calc(0);" />
							                </td>
							                <td class="calc_td_btn">
										    	<input type="button" class="calc_btn" value=" "/>
							                </td>
							                <td class="calc_td_btn">
										    	<input type="button" class="calc_btn" value=" "/>
							                </td>
							            </tr>
							        </table>
						        </div>
					        </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
        <div class="H30"></div>       
    </jsp:body>
</ppm:layout>