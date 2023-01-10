<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: HACCP기준서관리
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
        <script type="text/javascript" src="<c:url value='assets/DOC000M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i><span id = "pgmTitle">문서관리</span></h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N" clear="N">          
	        <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
	        <button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
	        <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
        </ppm:page-buttons>             
		<div id="modal-content" style="height:400px;">
			<ppm:form name="formView01">
				<ppm:tbl clazz="ax-form-tbl" minWidth="500px">	  
					<ppm:tr>
						<ppm:td label="회사" width="50%" required="true">
							<ppm:company-code dataPath="company"/> 
						</ppm:td>
					</ppm:tr> 
					<ppm:tr>
						<ppm:td label="문서명" width="100%" required="true">
							<input type="hidden" data-ax-path="mainCode"/>
							<input type="hidden" data-ax-path="subCode"/>
							<input type="hidden" data-ax-path="data1" id="data1" />
							<input type="text" data-ax-path="subName" title="문서명" class="form-control required" data-ax-validate="required"/>
						</ppm:td>             
					</ppm:tr>    
                   <ppm:tr>
                       	<ppm:td label="비고" width="100%">
							<textarea data-ax-path="remark" class="form-control" rows=5></textarea>
                         </ppm:td>
                   </ppm:tr>
				</ppm:tbl>
				
				<div class="H5"></div>
				<ppm:tbl clazz="ax-form-tbl" minWidth="500px">	  
					<ppm:tr>
						<ppm:td label="파일첨부" width="100%">
							<ppm:file-uploader targetType = "DOC000" targetId = "data1"/>
						</ppm:td>
					</ppm:tr> 
				</ppm:tbl>  
			</ppm:form>
		</div>
	<div class="H5"></div>    
	</jsp:body>
</ppm:layout>