<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 코주부HACCP MES
 * 1. 작성자  	: 윤광준
 * 2. 작성일	: 2020.07.09
 * 3. Comment 	: 설비등록
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
        <script type="text/javascript" src="<c:url value='assets/LMT000M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 한계기준정보 등록<span id = "pgmTitle"></span></h1>  
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
	                  <ppm:td label="한계기준ID" width="33%" required="true">
							<input type="text" data-ax-path="prcsslmtId" id="prcsslmtId" title="한계기준아이디" class="form-control inline-block W200 required" data-ax-validate="required"/>
							<button id="checkId" class="btn btn-default" data-form-view-01-btn="checkId">중복체크</button>
							<input type="checkbox"  id="chk" onclick="return false;"/>
	                  </ppm:td>
	                  <ppm:td label="한계기준명" width="33%" required="true">
							<input type="text" data-ax-path="prcsslmtNm" id="prcsslmtNm" title="한계기준명" class="form-control required" data-ax-validate="required"/>
	                  </ppm:td>                      
	              </ppm:tr>
	              <ppm:tr>	                  
	                  <ppm:td label="한계기준단위" width="33%">
							<input type="text" data-ax-path="prcsslmtSgn" id="prcsslmtSgn" title="한계기준단위" class="form-control"/> 
	                  </ppm:td>
	                  <ppm:td label="한계기준범위<br>최저값" width="33%">
							<input type="number" data-ax-path="prcsslmtMin" id="prcsslmtMin" class="form-control"/>
	                  </ppm:td>
	                  <ppm:td label="한계기준범위<br>최대값" width="33%">
							<input type="number" data-ax-path="prcsslmtMax" id="prcsslmtMax" class="form-control"/>
	                  </ppm:td> 
	              </ppm:tr>
	              <ppm:tr>     
	                  <ppm:td label="메일알림주기<br>(분 단위)" width="33%">
	                  	  <input type="number" data-ax-path="mst" id="mst" class="form-control inline-block W200" disabled/>
						  <input type="checkbox" name="emailYn" id="emailYn">
	                  </ppm:td>
	               </ppm:tr>     
                    <ppm:tr>
                         <ppm:td label="비고" width="100%">
							<textarea data-ax-path="remark" class="form-control" rows=14></textarea>
                         </ppm:td>
                    </ppm:tr>
                	<ppm:tr>
		                 <ppm:td label="파일첨부" width="100%">
						 	<ppm:file-uploader targetType = "PRCSSLMT_ID" targetId = "prcsslmtId"/>
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
	$("#prcsslmtId").on("propertychange change keyup paste input", function() {
		if(inFlag == true){
			inFlag = false;
			$("input:checkbox[id='chk']").prop("checked", false);	
		}
	});
</script>