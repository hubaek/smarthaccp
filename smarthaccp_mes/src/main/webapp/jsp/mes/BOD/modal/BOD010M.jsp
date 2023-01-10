<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 공지사항
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
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
        <script type="text/javascript" src="<c:url value='assets/BOD010M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 공지사항 등록</h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N" clear="N">
            <button type="button" class="btn btn-fn1 W80" data-page-btn="save">저장</button>
            <button type="button" class="btn btn-warning W80" data-page-btn="delete">삭제</button>
            <button type="button" class="btn btn-default W80" data-page-btn="close">닫기</button>
        </ppm:page-buttons>             
       <ppm:form name="formView01">  
			<ppm:tbl clazz="ax-form-tbl" minWidth="600px">                          
				<ppm:tr>          
					<ppm:td label='회사' width="33%">
						<ppm:company-code dataPath="company"/> 
					</ppm:td>      
	                <ppm:td label="등록일" width="33%" required="true">
	                  	<div class="input-group" data-ax5picker="date">
		                	<input type="text" class="form-control" data-ax-path="regDt" placeholder="yyyy-mm-dd" data-ax-validate="required" title="등록일"  readonly="readonly"/>
		                	<span class="input-group-addon"><i class="cqc-calendar"></i></span>
	                    </div>
	               </ppm:td>
					<ppm:td label="등록자" width="33%" required="true">  	
						<input type="text" data-ax-path="userNm" class="form-control" readonly="readonly"/>
					</ppm:td>     
				</ppm:tr>         
	       		<ppm:tr>     	    
					<ppm:td label="제목" width="100%" required="true">
						<input type="text" data-ax-path="boardTitle" title="모델명" class="form-control required" data-ax-validate="required"/>
					</ppm:td>       
		       </ppm:tr>
	       		<ppm:tr>     
					<ppm:td label='내용' width="100%">
      					<textarea data-ax-path="boardText" class="form-control" rows=22></textarea>
					</ppm:td>
		       </ppm:tr>
	           	<ppm:tr>  
		            <ppm:td label="파일첨부" width="100%">      
						<ppm:file-uploader targetType = "BOARD_CD" targetId = "boardCd"/>     	   
			        </ppm:td>
	            </ppm:tr>                
        	</ppm:tbl>
       </ppm:form>
    </jsp:body>
</ppm:layout>