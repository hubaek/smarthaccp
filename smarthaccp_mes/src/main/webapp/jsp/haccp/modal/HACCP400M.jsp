<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 김회재
 * 2. 작성일		: 2020.12.18
 * 3. Comment 	: 여과공정CCP2-P
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *								
 */
 --%>
<ppm:set key="pageName" value=""/>
<ppm:set key="page_auto_height" value="false"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/HACCP400M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
        <style>
		  table {
		    width: 100%;
		    border: 1px solid #D8D8D8;
		    border-collapse: collapse;
		  }
		  th  {
		    border: 1px solid #D8D8D8;
		    padding: 7px;
		    background-image: linear-gradient(to bottom, #fbfbfb, #F6F6F6);
		    border-right: 1px solid #D8D8D8;
		    background-color: #D8D8D8;
		    text-align: center;
		    color: #363636;
		  }
		  td {
		    border: 1px solid #D8D8D8;
		    padding: 9px;
		  }
		</style>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i>여과 공정<span id = "pgmTitle"></span></h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N"  clear="N">          
	        <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
	        <button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
	        <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
        </ppm:page-buttons>             
		<div id="modal-content" style="height:690px;">
			<table id ="ccpTable">
				<colgroup>			        
			        <col width="15%">
			        <col width="85%">
			    </colgroup>
			</table>
			<div class="ax-button-group">
				<div class="left">
				<h3><i class="cqc-list"></i>목록</h3>
			</div>
			
			</div>
			<div data-ax5grid="grid-view-02" data-ax5grid="grid-view-02" style="height: 330px;"></div>
			<%-- <ppm:form name="formView01">
                <ppm:tbl clazz="ax-form-tbl" minWidth="500px">  
	                    <ppm:tr>
	                        <ppm:td label='회사' width="35%">
			                	<ppm:company-code dataPath="company" /> 
	                        </ppm:td>
	                        <ppm:td label="점검일자" width="35%" required="true">
                            	<div class="form-inline">
	                         		<div class="form-group">
	                         			<div class="input-group" data-ax5picker="basic">
		                         			<input type="text" class="form-control" data-ax-path="inspectionDate" data-ax-validate="required" placeholder="yyyy-mm-dd" id="inspectionDate" title="입고일자" disabled="disabled" autocomplete="off"/>
	                                     	<span class="input-group-addon"><i class="cqc-calendar"></i></span>
		                         		</div>
                         				<button id="checkMonth" class="btn btn-default" data-form-view-01-btn="checkId">중복체크</button>
				    				<input type="checkbox" name="chk" id= "chk" value="y" onclick="return false;" >
                        			</div>
                        		</div>
                            </ppm:td>
                        </ppm:tr>      
                        <ppm:tr>
                            <ppm:td label="작성자" width="35%">
                                <input type="text" data-ax-path=writer class="form-control" maxlength="20" readonly="readonly"/>
                            </ppm:td>
                            <ppm:td label="승인자" width="35%">
                                <input type="text" data-ax-path=approver class="form-control" maxlength="20" readonly="readonly"/>
                            </ppm:td>
	                        <ppm:td label='상태' width="30%">
				                	 <ppm:common-code mainCd="STATUS" emptyText="" emptyValue="" dataPath="status" name="status" id="status" title="상태"/>
		                    </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                        	<ppm:td label="위해요소" width="98%">
                        		금속성 이물(Fe, SUS),연질이물(비닐), 경질이물(돌)
                        	</ppm:td>
                        	<ppm:td label="발생원인" width="98%">
                        		여과망크기, 여과망 교체주기, 파손 등 미준수로 이물 잔존
                        	</ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                        	<ppm:td label="한계기준" width="98%">
                        		<table>
                        			<tr> <th>여과망 파손시</th><th>여과망 크기</th> <th>세척소독</th> </tr>
                        			<tr> <td>즉시 교체</td><td>200 MESH이상</td> <td>배치시마다</td> </tr>
                        		</table>
                        	</ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                        	<ppm:td label="주기" width="98%">
                        		<span>
                        			매 작업 시작 전, 매 작업 종료 후 / 품목 교체 시
                        		</span>
                        	</ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                        	<ppm:td label="방법" width="98%">
                        		<span style="line-height: 180%;">
	                        		1.여과망크기 여과망 파손여부 확인<br>
	                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 여과망 크기/여과망 교체주기를 측정하여 모니터링 일지에 기록하고 HACCP팀장에게 보고한다.<br>
	                        		2.여과망 파손여부<br>
	                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 작업전 여과망의 파손여부를 모니터링 일지에 기록하고 HACCP팀장에게 보고한다.<br>
	                        		3.여과망 파손여부<br>
	                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 여과공정에 통과된 검출된 양을 모니터링 일지에 기록하고 HACCP팀장에게 보고한다.	                        		
                        		</span>                        		   
                        	</ppm:td>
                        </ppm:tr> 
                        <ppm:tr>
                        	<ppm:td label="담당자" width="98%">
                        		<span style="line-height: 180%;">
	                        		정 : 박진우 / 부 : 전배성
                        		</span>                        		   
                        	</ppm:td>
                        </ppm:tr>
                        <div class="H5"></div>
                       <div class="ax-button-group">
	                        <div class="right">
	                            <button type="button" class="btn btn-default" data-grid-view-02-btn="item-good">
	                                <ppm:lang id="ax.admin.sample.modal.button.all.good"/>
	                            </button>
	                            <button type="button" class="btn btn-default" data-grid-view-02-btn="item-bad">
	                                <ppm:lang id="ax.admin.sample.modal.button.all.bad"/>
	                            </button>
	                            <button type="button" class="btn btn-default" data-grid-view-02-btn="item-add">
	                                <i class="cqc-plus"></i>
	                                <ppm:lang id="ax.admin.add"/>
	                            </button>
	                            <button type="button" class="btn btn-default" data-grid-view-02-btn="item-remove">
	                                <i class="cqc-minus"></i>
	                                <ppm:lang id="ax.admin.delete"/>
	                            </button>
	                        </div>
	                    </div>
			            <div data-ax5grid="grid-view-02" data-ax5grid="grid-view-02" style="height: 330px;"></div>
			            <ppm:tr>
                        	<ppm:td label="개선조치 방법" width="98%">
                        		<span style="line-height: 180%;">
	                        		1.이물 검출의 경우<br>
	                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 여과망에서 체크된 공정품을 다시 통과시켜 이물의 혼입을 확인하고 기록한 후에 폐기하고 HACCP팀장에게 보고한다.<br>
	                        		2.여과망 교체주기 이탈의 경우<br>
	                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 여과망 교체주기가 이탈된 경우 작업을 중단하고 재여과하고 재여과 할 수 없는 경우 폐기 처분하고 모니터링 일지에 기록하고 HACCP팀장에게 보고한다.<br>	                        		
                        		</span>                        		   
                        	</ppm:td>
                        </ppm:tr> 
                        <ppm:tr>
                            <ppm:td label="이탈내용" width="100%">
                                <textarea data-ax-path="remark1" class="form-control" rows=3 maxlength="200" id="remark1"></textarea>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                            <ppm:td label="개선조치 및 결과" width="80%">
                            	<textarea data-ax-path="remark2" class="form-control" rows=3 maxlength="200" id="remark2"></textarea>
                            </ppm:td>
                            <ppm:td label="조치자" width="20%">
                            	<textarea data-ax-path="solver" class="form-control" rows=3 maxlength="200" id="solver"></textarea>
                            </ppm:td>
				   		</ppm:tr>
						<ppm:tr>
			                 <ppm:td label="파일첨부" width="100%">
							 	<ppm:file-uploader targetType = "INSPECTION_DATE" targetId = "inspectionDate"/>
			                 </ppm:td>
		            	</ppm:tr>	
                    </ppm:tbl>
                </ppm:form> --%>
		</div>
	<div class="H5"></div>    
	</jsp:body>
</ppm:layout>