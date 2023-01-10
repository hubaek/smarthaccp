<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 품질검사그룹등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="pageName" value="File Browser"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/QC100M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
           		 품질검사그룹 등록
        </h1>  
    </jsp:attribute>
    <jsp:body>
       <ppm:page-buttons help="N"  clear="Y">          
	        <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
	        <button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
	        <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
       </ppm:page-buttons>      
       <div id="modal-content">
       <ppm:form name="formView01">        
       	<ppm:tbl clazz="ax-form-tbl">
        	<ppm:tr>     
      			<ppm:td label='회사' width="25%">
          			<ppm:company-code dataPath="company"/> 
                </ppm:td>
	            <ppm:td label="검사그룹코드" width="25%">
	            	<input type="text" data-ax-path="qcGroupCd" class="form-control" value="" readonly="readonly" placeholder="시스템 자동발번"/>
	            </ppm:td>
	            <ppm:td label="검사그룹명" width="25%">
	            	<input type="text" data-ax-path="qcGroupNm" class="form-control" value=""/>
	            </ppm:td>
	            <ppm:td label="사용여부" width="25%" required="true">
	            	<ppm:common-code mainCd="USE_YN" dataPath="useYn"/>
	            </ppm:td> 
       		</ppm:tr>                      		
            <ppm:tr> 
	            <ppm:td label="검사유형" width="25%" required="true">
	            	<ppm:common-code mainCd="QC_TYPE" dataPath="qcType"/>
	            </ppm:td>        
           	</ppm:tr>                       		
            <ppm:tr> 
               <ppm:td label="비고" width="100%">
					<textarea data-ax-path="remark" class="form-control" rows=5></textarea>
               </ppm:td>         
           </ppm:tr>             
        </ppm:tbl>
           <div class="H5"></div>
            <div class="ax-button-group">
                <div class="left">
                    <h5>
                        <i class="cqc-list"></i>상세정보</h5>
                </div>
                <div class="right" id = "grid-buttons">
                	<div class="form-inline">
                       <div class="form-group">
		                    <button type="button" class="btn btn-success" data-grid-view-02-btn="qc-master">
		                        <i class="cqc-popin"></i> 검사항목적용
		                    </button>
                            <button type="button" class="btn btn-default" data-grid-view-02-btn="item-remove">
                                <i class="cqc-minus"></i>
                                <ppm:lang id="ax.admin.delete"/>
                            </button>
		        		</div>
		       		</div>
                </div>
            </div>
            <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 480px;"></div>
       </ppm:form>
     </div>
    </jsp:body>
</ppm:layout>