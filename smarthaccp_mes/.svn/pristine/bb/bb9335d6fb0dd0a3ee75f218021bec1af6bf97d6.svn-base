<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 수주등록
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
        <script type="text/javascript" src="<c:url value='assets/SA030M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
        <script type="text/javascript" src="<c:url value='/assets/js/item-common.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>수주 등록
        </h1>
    </jsp:attribute>  
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
		 	<div class="form-inline">
		       <div class="form-group">            
		            <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
			        <button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
			        <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
		       </div>
		    </div>
        </ppm:page-buttons>  
       <div id="modal-content">
       <ppm:form name="formView01">             
       <div data-fit-height-aside="form-view-01">
       		<ppm:tbl clazz="ax-form-tbl" minWidth="600px">
				<ppm:tr>	       		
		       		<ppm:td label='회사' width="25%">
	           			<ppm:company-code dataPath="company"/> 
	                </ppm:td>
	                <ppm:td label='담당자' width="25%" required="true">
	                    <ppm:form-modal codeName="userCd" valueName="userNm"  modalType="USER-MODAL" required="true" title="담당자"/>
	                </ppm:td>  
		              <ppm:td label="수주번호" width="25%">
		                    <input type="text" data-ax-path="slipCd" class="form-control" value="" readonly="readonly" placeholder="시스템 자동발번"/>
		               </ppm:td>              
		               <ppm:td label="등록일" width="25%" required="true">
		                	<ppm:date-picker dataPath="slipDt" requiredFlag="true" title="등록일"/>
		               </ppm:td>
		      	</ppm:tr>
	        </ppm:tbl>
        <div class="H5"></div>
       	<ppm:tbl clazz="ax-form-tbl" minWidth="600px">  	               		
           	    <ppm:tr>      
	               <ppm:td label="수주일자" width="25%" required="true">
	                	<ppm:date-picker dataPath="saOrderDt" requiredFlag="true" title="수주일자"/>
	               </ppm:td>      
	               <ppm:td label="납기일자" width="25%" required="true">
	                	<ppm:date-picker dataPath="saDeliveryDt" requiredFlag="true" title="납기일자"/>
	               </ppm:td>
	               <ppm:td label="수주구분" width="25%" required="true">
	               		<ppm:common-code mainCd="SA_ORDER_TYPE" dataPath="saOrderType"/>
	               </ppm:td> 
	              <ppm:td label="발주번호" width="25%" >
	                    <input type="text" data-ax-path="orderNo" class="form-control" value=""/>
	               </ppm:td> 
                </ppm:tr>                   		
           	    <ppm:tr>
	                <ppm:td label='거래처' width="25%" required="true">
	                    <ppm:form-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL" required="true" title="거래처" whereValue="10"/>
	                </ppm:td>  
	               <ppm:td label="부가세적용" width="25%" required="true">
	               		<ppm:common-code mainCd="SURTAX_YN" dataPath="surtaxYn"/>
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
                    <h5>
                        <i class="cqc-list"></i>상세정보</h5>
                </div>
                <div class="right" id = "grid-buttons">
                    <button type="button" class="btn btn-success W120" data-grid-view-02-btn="item-all" id ="item-all">
      						품목정보 적용
                    </button>
                    <button type="button" class="btn btn-default W80" data-grid-view-02-btn="item-remove" id="item-remove">
                        <i class="cqc-minus"></i>
                        <ppm:lang id="ax.admin.delete"/>
                    </button>
                </div>
            </div>
       		</div>
            <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 460px;"></div>
       </ppm:form>
       </div>
    </jsp:body>
</ppm:layout>