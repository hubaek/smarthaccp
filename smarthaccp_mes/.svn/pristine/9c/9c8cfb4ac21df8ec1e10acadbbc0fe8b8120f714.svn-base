<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 양품등록
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
			.calculator
			{
			        width:100%;
			        height:90%;
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
			        height:145px;
			        font-size:60px;
			        color:orange;
			        background-color:black;
			}  
			.calc_btn2
			{
			        width:100%;
			        height:100%;
			        font-size:60px;
			        color:white;
			        background-color:black;
			}  
			 
			#box_button
			{
				border-top-left-radius:10px;
				border-bottom-left-radius: 10px;
				margin-right:-2px;
				
			}
			#unit_button
			{
				border-top-right-radius: 10px;
				border-bottom-right-radius: 10px;
				margin-left: -3px;
				
			}
			.btn_tri_style
			{
				border: 1px solid black;
				background-color: rgba(0,0,0,0);
				color:black;
				padding: 5px;
				outline: none;
			}
		</style>
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/num-pad-prod2.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i> 입고
        </h1>
    </jsp:attribute>
    <jsp:body>
    	<ppm:form name="searchView0">
	        <ppm:page-buttons help="N" clear="N">
	            <!-- <button id="box_button" type="button" class="btn btn-info2 W150 H40 btn_tri_style" style="font-size:xx-large;" data-page-btn="box">Box</button>
	            <button id="unit_button" type="button" class="btn btn-info W150 H40 btn_tri_style" style="font-size:xx-large;" data-page-btn="ea">EA</button> -->	           
	            <!-- 
	            <button id="box_button"  type="button" class="btn W150 H40 btn_tri_style" style="font-size:xx-large; outline:none" data-page-btn="box">BOX</button>
	            <button id="unit_button" type="button" class="btn W150 H40 btn_tri_style" style="font-size:xx-large; outline:none" data-page-btn="ea">EA</button>
	             -->
	            <button type="button" class="btn btn-default W150 H40" style="font-size:xx-large;" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
	        </ppm:page-buttons>
        </ppm:form>
        <ppm:split-layout name="ax1" orientation="vertical">
        	<ppm:split-panel width="55%" style="margin-top:50px;">
	        	<table class="calculator" id="calc">       
                	<tr>
                		<td>
                			<div data-ax5grid="grid-view-01" style="margin-left: 30px; width: 510px; height: 200px"></div>
                			<input style="margin-left: 10px;" type="hidden"  name="calc_result" id="calc_result" class="calc_result" onkeydown="javascript:key_detect_calc('calc',event);"/>
                		</td>
                		<td >
							<button type="button" style="margin-right:25px; margin-top: -13px;" class="btn btn-primary W90 H160"  id = "itemSearch" onclick="javascript:itemSearchModal();">
                                 <i class="cqc-magnifier" style="font-size: xx-large;"></i>
                            </button>						
                		</td>                		
                	</tr>
                	<tr>
                		<td>
                			<button type="button" style="background-color: red; margin-left: 30px; margin-top: 10px; margin-right: 20px;" class="btn btn-info2 W260 H340" data-page-btn="choice1"><h1 style="font-size:80px;">입고</h1></button>                			
                		</td>
                		<td>
                			<button type="button" style="margin-top: 10px; margin-left:-180px;" class="btn btn-info2 W260 H340" data-page-btn="choice2"><h1 style="font-size:80px;">출고</h1></button>
                		</td>
                	</tr>
                </table>

        	</ppm:split-panel>
        	<ppm:split-panel width="45%" style="margin-left:40px; margin-top:45px;" scroll="scroll"  id="split-panel-form">
        		<div class="col-lg-6 col-md-6">       		
	                <div class="x_panel">
		                <div class="x_content">
				        	<table class="calculator" id="calc">
				        		<tr>
	                              <td colspan="2" class="calc_td_btn">
	                                       <input type="text" class="calc_btn"  style = "text-align:center;" value="수량" />
	                               </td>
	                               <td  colspan="2" class="calc_td_btn">
	                                       <input type="text" class="calc_btn"  style = "text-align:center;" id="itemQty" placeholder="0" />
	                               </td>
                           		</tr>			                    
					            <tr>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="7" onclick="javascript:add_calc(7);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="8" onclick="javascript:add_calc(8);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="9" onclick="javascript:add_calc(9);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="C" onclick="javascript:add_calc('C');" />
					                </td>
					            </tr>
					            <tr>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="4" onclick="javascript:add_calc(4);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="5" onclick="javascript:add_calc(5);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="6" onclick="javascript:add_calc(6);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="&larr;" onclick="javascript:add_calc('nbs');" />
					                </td>
					            </tr>
					            <tr>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="1" onclick="javascript:add_calc(1);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="2" onclick="javascript:add_calc(2);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="3" onclick="javascript:add_calc(3);" />
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="." onclick="javascript:add_calc('.');" />
					                </td>
					            </tr>
					            <tr>
					                <td class="calc_td_btn">
								    	<input type="button" style="width: 125px; height: 125px" class="calc_btn" value=" "/>
					                </td>
					                <td class="calc_td_btn">
					                        <input type="button" style="width: 125px; height: 125px" class="calc_btn" value="0" onclick="javascript:add_calc(0);" />
					                </td>
					                <td class="calc_td_btn">
								    	<input type="button" style="width: 125px; height: 125px" class="calc_btn" value=" "/>
					                </td>
					                <td class="calc_td_btn">
								    	<input type="button" style="width: 125px; height: 125px" class="calc_btn" value=" "/>
					                </td>
					            </tr>
					        </table>
						</div>
					</div>
				</div>        
				</ppm:split-panel>		
			</ppm:split-layout>
    </jsp:body>
</ppm:layout>