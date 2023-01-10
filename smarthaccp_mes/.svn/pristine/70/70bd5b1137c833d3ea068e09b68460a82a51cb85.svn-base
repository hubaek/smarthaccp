<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 코주부HACCP MES
 * 1. 작성자  		: 윤광준
 * 2. 작성일		: 2020.08.04
 * 3. Comment 	: 주기관리 모달
 * 4. 변경이력 		: 
 *  	이름		|일자          		|변경내용
 *      ------------------------------------------------------
 *
 */
 --%>
<ppm:set key="pageName" value=""/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/CCP000M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 주기관리 등록<span id = "pgmTitle"></span></h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N"  clear="N">          
	        <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
	        <button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
	        <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
        </ppm:page-buttons>             
		<div id="modal-content" style="height:450px;">
			<ppm:form name="formView01">
                <ppm:tbl clazz="ax-form-tbl" minWidth="500px">  
                        <ppm:tr>
	                        <ppm:td label="주기명" width="40%" required="true">
                     			<ppm:common-code mainCd="HACCP_CODE" dataPath="ccpCd" />
                     			<button id="checkId" class="btn btn-default" data-form-view-01-btn="checkId">중복체크</button>
								<input type="checkbox"  id="chk" onclick="return false;"/>
                        	</ppm:td>
                            <ppm:td label="기준일자" width="30%" required="true">
                            	<div class="form-inline">
	                         		<div class="form-group">
	                         			<div class="input-group" data-ax5picker="basic">
	                         				<input type="text" class="form-control" data-ax-path="ccpDate" data-ax-validate="required" placeholder="yyyy-mm-dd" id="inspectionYm" title="기준일자" disabled="disabled" autocomplete="off"/>
	                                     	<span class="input-group-addon"><i class="cqc-calendar"></i></span>
		                         		</div>
                        			</div>
                        		</div>
                            </ppm:td>
                            <ppm:td label="주기일" width="30%">
                                <input type="number" data-ax-path="ccpCycle" title="주기일" class="form-control" />
                            </ppm:td>
                        </ppm:tr>            
                        <ppm:tr>
                        	<ppm:td label="설명" width="100%">
                                <textarea data-ax-path="comment" id="comment" rows=21 title="설명" class="form-control"></textarea>
                            </ppm:td>
                        </ppm:tr> 
                    </ppm:tbl>
                    <div class="H5"></div>
       		</ppm:form>
		</div>
	</jsp:body>
</ppm:layout>
<script>
	//중복채크후 ccpCd 값 변경시 validation 되어진 값 초기화
	$("select[data-ax-path='ccpCd']").on("propertychange change keyup paste input", function() {
		if(inFlag == true){
			inFlag = false;
			$("input:checkbox[id='chk']").prop("checked", false);	
		}
	});
	$("select[data-ax-path='ccpCd']").css("width", "170px");
	$("select[data-ax-path='ccpCd']").css("float", "left");
	
</script>