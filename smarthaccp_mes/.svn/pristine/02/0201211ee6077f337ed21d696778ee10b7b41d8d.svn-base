<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 센서정보등록
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
        <script type="text/javascript" src="<c:url value='assets/SNSR000M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 센서정보 등록<span id = "pgmTitle"></span></h1>  
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
	                  <ppm:td label="회사" width="33%" required="true">
		     				<ppm:company-code dataPath="company"/> 
	                  </ppm:td>
	                  <ppm:td label="센서ID" width="33%" required="true">
							<input type="text" data-ax-path="snsrId" class="form-control inline-block W200 required" data-ax-validate="required" title="센서ID" id="snsrId" autocomplete="off"/>
							<button id="checkId" class="btn btn-default" data-form-view-01-btn="checkId">중복체크</button>
                          	<input type="checkbox"  id="chk" onclick="return false;"/>
	                  </ppm:td>
	                  <ppm:td label="센서명" width="33%">
	                      <input type="text" data-ax-path="snsrNm" class="form-control"/>
	                  </ppm:td>
                         
	              </ppm:tr>
	              <ppm:tr>
	                  <ppm:td label="센서모델명" width="33%" >
	               		<input type="text" data-ax-path="snsrMdlNm" class="form-control"/>
	                  </ppm:td>
	                  <ppm:td label="제조사" width="33%">
	                      <input type="text" data-ax-path="snsrMnf" class="form-control"/>
	                  </ppm:td>
	                  <ppm:td label="센서용도" width="33%">
	                      <input type="text" data-ax-path="snsrUsg" class="form-control"/>
	                  </ppm:td> 
	              </ppm:tr>
	              <ppm:tr>             
	                  <ppm:td label="수집데이터속성" width="33%">
	                      <input type="text" data-ax-path="snsrDataFrm" class="form-control"/>
	                  </ppm:td>
	                  <ppm:td label="생산일" width="33%">
                  		<div class="input-group" data-ax5picker="date">
	                        <input type="text" class="form-control" data-ax-path="snsrPrdDt" placeholder="yyyy-mm-dd"/>
	                        <span class="input-group-addon"><i class="cqc-calendar"></i></span>
	                    </div>
	                  </ppm:td>    
	                  <ppm:td label="설치일" width="33%">
                  		<div class="input-group" data-ax5picker="date">
	                        <input type="text" class="form-control" data-ax-path="snsrInsDt" placeholder="yyyy-mm-dd"/>
	                        <span class="input-group-addon"><i class="cqc-calendar"></i></span>
	                    </div>
	                  </ppm:td>
	               </ppm:tr>   
	                  <!-- 
		              <ppm:tr>
		                  <ppm:td label="센서코드" width="33%">
		                      <input type="text" data-ax-path="snsrCd" id="snsrCd" class="form-control"/>
		                  </ppm:td>
		              </ppm:tr>
	                   -->
		           <ppm:tr>	                  
                         <ppm:td label="비고" width="100%">
							<textarea data-ax-path="remark" class="form-control" rows=7></textarea>
                         </ppm:td>
                    </ppm:tr>
                	<ppm:tr>
		                 <ppm:td label="파일첨부" width="100%">
						 	<ppm:file-uploader targetType = "SNSR_ID" targetId = "snsrId"/>
		                 </ppm:td>
	            	</ppm:tr>       
	          	</ppm:tbl>   
       		</ppm:form>
		</div>
	<div class="H5"></div>    
	</jsp:body>
</ppm:layout>
	<script>
	//중복채크후 id 변경시 validation 되어진 값 초기화
	$("#snsrId").on("propertychange change keyup paste input", function() {
		if(inFlag == true){
			inFlag = false;
			$("input:checkbox[id='chk']").prop("checked", false);	
		}
	});
</script>