<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 바코드발행패드
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
			        height:80%;
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
			.calc_result1
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
			        height:115px;
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
			  
		</style>
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/num-pad-box.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i> 바코드발행1
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N"> 
        	<button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
            <button type="button" class="btn btn-info2 W120" data-page-btn="choice">발행</button>
            <button type="button" class="btn btn-default W120" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <div class="container-fluid">
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-12 col-md-12">
	                <div class="x_panel">
		                <div class="x_content">	<div data-ax5grid="grid-view-01" style="height: 120px"></div>
        				<input type="hidden"  name="calc_result1" id="calc_result1" class="calc_result1" onkeydown="javascript:key_detect_calc('calc',event);"/>
		                <input type="hidden"  name="calc_result2" id="calc_result2" class="calc_result2"/>
		                </div>
		           	</div>
        		</div>
        	</div>
        	<div class="row clearfix" style="height:100%">
        		<div class="col-lg-6 col-md-6">
	                <div class="x_panel">
		                <table class="calculator" id="calc">				                    
				            <tr>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="7" onclick="javascript:add_calc1(7);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="8" onclick="javascript:add_calc1(8);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="9" onclick="javascript:add_calc1(9);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="C" onclick="javascript:add_calc1('C');" />
				                </td>
				            </tr>
				            <tr>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="4" onclick="javascript:add_calc1(4);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="5" onclick="javascript:add_calc1(5);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="6" onclick="javascript:add_calc1(6);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="&larr;" onclick="javascript:add_calc1('nbs');" />
				                </td>
				            </tr>
				            <tr>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="1" onclick="javascript:add_calc1(1);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="2" onclick="javascript:add_calc1(2);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="3" onclick="javascript:add_calc1(3);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="." onclick="javascript:add_calc1('.');" />
				                </td>
				            </tr>
				            <tr>
				                <td class="calc_td_btn">
							    	<input type="button" class="calc_btn" value=" "/>
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="0" onclick="javascript:add_calc1(0);" />
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
        		<div class="col-lg-6 col-md-6">
	                <div class="x_panel">
		                <table class="calculator" id="calc">				                    
				            <tr>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="7" onclick="javascript:add_calc2(7);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="8" onclick="javascript:add_calc2(8);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="9" onclick="javascript:add_calc2(9);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="CE" onclick="javascript:add_calc2('ce');" />
				                </td>
				            </tr>
				            <tr>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="4" onclick="javascript:add_calc2(4);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="5" onclick="javascript:add_calc2(5);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="6" onclick="javascript:add_calc2(6);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="&larr;" onclick="javascript:add_calc2('nbs');" />
				                </td>
				            </tr>
				            <tr>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="1" onclick="javascript:add_calc2(1);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="2" onclick="javascript:add_calc2(2);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="3" onclick="javascript:add_calc2(3);" />
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="." onclick="javascript:add_calc2('.');" />
				                </td>
				            </tr>
				            <tr>
				                <td class="calc_td_btn">
							    	<input type="button" class="calc_btn" value=" "/>
				                </td>
				                <td class="calc_td_btn">
				                        <input type="button" class="calc_btn" value="0" onclick="javascript:add_calc2(0);" />
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
    </jsp:body>
</ppm:layout>