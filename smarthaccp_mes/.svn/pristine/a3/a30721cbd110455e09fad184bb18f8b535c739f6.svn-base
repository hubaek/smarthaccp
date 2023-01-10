<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 용수탱크 세척·소독 일지
 * 4. 변경이력 		: 
 *  	이름		|일자          		|변경내용
 *      ------------------------------------------------------
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
        <script type="text/javascript" src="<c:url value='assets/REPORT012M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 용수탱크 세척/소독 일지<span id = "pgmTitle"></span></h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N"  clear="N">          
	        <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
	        <button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
	        <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
        </ppm:page-buttons>             
		<div id="modal-content" style="height:690px;">
			<ppm:form name="formView01">
                <ppm:tbl clazz="ax-form-tbl" minWidth="500px">  
                        <ppm:tr>
	                        <ppm:td label='회사' width="33%">
			                	<ppm:company-code dataPath="company" /> 
	                        </ppm:td>	   	   
                            <ppm:td label="점검일자" width="35%" required="true">
                            	<div class="form-inline">
	                         		<div class="form-group">
	                         			<div class="input-group" data-ax5picker="basic">
		                         			<ppm:date-picker dataPath="reportDate" requiredFlag="true" title="점검일자"/>
		                         		</div>
                         				<button id="chk" class="btn btn-default" data-form-view-01-btn="check-date">중복체크</button>
										<input type="checkbox" id = "date_check" name="is_date_check" value="y" onclick="return false;" >
                        			</div>
                        		</div>
                            </ppm:td>
                            <ppm:td label="상태" width="32%">
                     			<input type="text" data-ax-path="status" title="상태" id="status-id" class="form-control" readonly/>
                        	</ppm:td>
                        	 
                        </ppm:tr>            
                        <ppm:tr>
                        	<ppm:td label="대상" width="33%">
                                <input type="text" data-ax-path="mitem001" title="대상" class="form-control" readonly/>
                            </ppm:td>
                            <ppm:td label="작성자" width="35%">
                                <input type="text" data-ax-path="writer" title="작성자" class="form-control" readonly/>
                            </ppm:td>
                            <ppm:td label="승인자" width="32%">
                                <input type="text" data-ax-path="approver" title="승인자" class="form-control" readonly/>
                            </ppm:td>                     
                        </ppm:tr>
                        <ppm:tr>
                        	<ppm:td label="소독제" width="100%">
                                <input type="text" data-ax-path="mitem002" title="소독제" class="form-control" />
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                        	<ppm:td label="세척/소독<br>방법 예시" width="100%">
                                <textarea data-ax-path="mitem003" class="form-control" rows=6 readonly="readonly"></textarea>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
							<ppm:td label="부적합사항" width="50%">
								<textarea data-ax-path="remark1" class="form-control" rows=4></textarea>
		                	</ppm:td>
			                <ppm:td label="조치사항" width="50%">
								<textarea data-ax-path="remark2" class="form-control" rows=4></textarea>
			                </ppm:td>
	            		</ppm:tr> 
                        <ppm:tr>
		                	<ppm:td label="파일첨부" width="100%">
						 		<ppm:file-uploader2 targetType = "REPORT014M" targetId = "reportDate"/>
		                	</ppm:td>
	            		</ppm:tr>
                    </ppm:tbl>
                    
                    
       		</ppm:form>
		</div>
	</jsp:body>
</ppm:layout>
<script>
	//중복채크후 id 변경시 validation 되어진 값 초기화
	$("#inspectionDate").on("propertychange change keyup paste input", function() {
		if(inFlag == true){
			inFlag = false;
			$("input:checkbox[id='chk']").prop("checked", false);	
		}
	});
</script>