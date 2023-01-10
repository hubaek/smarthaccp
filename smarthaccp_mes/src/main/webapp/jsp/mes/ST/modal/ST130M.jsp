<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 재고실사등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<ppm:set key="pageName" value="File Browser"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">  
        <ppm:script-lang key="ax.script" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/ST130M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
        <script type="text/javascript" src="<c:url value='/assets/js/item-common.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
           		 재고실사등록(생산창고)
        </h1>  
    </jsp:attribute>
    <jsp:body>
       	<ppm:form name="formView01">
        <ppm:page-buttons help="N" clear="N">
		 	<div class="form-inline">
		       <div class="form-group">            
		            <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
					<button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
					<button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
		       </div>
		    </div>
        </ppm:page-buttons>           
       <div data-fit-height-aside="form-view-01">
       	<ppm:tbl clazz="ax-form-tbl" minWidth="600px">
	       <ppm:tr>     
	       		<ppm:td label='회사' width="25%">
           			<ppm:company-code dataPath="company"/> 
                </ppm:td>   
                <ppm:td label='담당자' width="25%" required="true">
                    <ppm:form-modal codeName="userCd" valueName="userNm"  modalType="USER-MODAL"/>
                </ppm:td>
               <ppm:td label="실사번호" width="25%">
                    <input type="text" data-ax-path="slipCd" class="form-control" value="" readonly="readonly" placeholder="시스템 자동발번"/>
               </ppm:td>
             	<ppm:td label="등록일자" width="25%" required="true">
                	<ppm:date-picker dataPath="slipDt" requiredFlag="true" title="등록일자"/>
                 </ppm:td>    
              </ppm:tr> 
              <ppm:tr>
                   <ppm:td label="실사유형" width="25%" required="true">
                		<ppm:common-code mainCd="MODIFY_TYPE" dataPath="modifyType"/>
                   </ppm:td>  
					<ppm:td label="실사창고" width="25%" required="true">
						<ppm:wh-code dataPath="whCd" whType="30"/>
					</ppm:td>
              </ppm:tr>     
              <ppm:tr>
                   <ppm:td label="비고" width="100%">
                   		<textarea data-ax-path="remark" class="form-control" rows=3></textarea>
                   </ppm:td>
              </ppm:tr>            	                          
         </ppm:tbl>
           <div class="H5"></div>
	            <div class="ax-button-group">
	                <div class="left">
	                    <h5><i class="cqc-list"></i>실사 상세</h5>
	                </div>
	                <div class="right" id = "grid-buttons">           
	                	<div class="form-inline">
	                       <div class="form-group">
			                    <button type="button" class="btn btn-success W120" data-grid-view-01-btn="stock-all">
			                        	재고 적용
			                    </button>          
			                    <button type="button" class="btn btn-success W120" data-grid-view-01-btn="item-all">
			                        	품목정보 적용
			                    </button>
			                    <button type="button" class="btn btn-default W80" data-grid-view-01-btn="item-remove" id="item-remove">
			                        <i class="cqc-minus"></i>
			                        <ppm:lang id="ax.admin.delete"/>
			                    </button>
			            	</div>
	                	</div>  
	                </div>
	            </div>
       		</div>
            <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 500px;"></div>
       </ppm:form>
    </jsp:body>
</ppm:layout>