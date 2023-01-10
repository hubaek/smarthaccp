<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP CMMS
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2020.01.15
 * 3. Comment 	: 공정등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="page_auto_height" value="false"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/RT100M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 공정등록 <span id = "pgmTitle"></span></h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N" clear="N">
            <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
            <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
        </ppm:page-buttons>             
		<div id="modal-content" style="height:700px;">
	       	<ppm:form name="formView01">       
	       		<ppm:tbl clazz="ax-form-tbl">        
                  	 <ppm:tr>
                        <ppm:td label='회사' width="33%">
	                   		<ppm:company-code dataPath="company"/> 
                        </ppm:td>	   
                        <ppm:td label='공정분류' width="33%" required="true">
                        	<ppm:common-code mainCd="ROUT_TYPE" dataPath="routType"/>
                        </ppm:td>
                        <ppm:td label="사용여부" width="33%">
                			<ppm:common-code mainCd="USE_YN" dataPath="useYn" name="useYn" id="useYn"/>
                        </ppm:td>
                     </ppm:tr>   
                     <ppm:tr>
                        <ppm:td label="공정코드" width="33%" required="true">
                            <input type="text" data-ax-path="routCd" id="routCd" class="form-control" data-ax-validate="required" title="공정코드" class="form-control"/>
                        </ppm:td>
                        <ppm:td label="공정명" width="33%" required="true">
                            <input type="text" data-ax-path="routNm" class="form-control" placeholder="공정명" data-ax-validate="required" title="공정명"/>
                        </ppm:td>
						<ppm:td label="조회순서" width="33%">
							<input type="text" data-ax-path="sort" class="form-control" style="text-align:right" data-ax5formatter="number"/>
						</ppm:td>   
                     </ppm:tr>      
                  	 <ppm:tr>
                         <ppm:td label="공정창고" width="33%">
                         	<!-- 생산창고(30) => 제품창고(20)으로 변경 : 21.07.20 khj -->
   							<ppm:wh-code dataPath="whCd" emptyText="전체" whType="20"/>
                         </ppm:td>
                         <ppm:td label="검사여부" width="33%">
                   			<ppm:common-code mainCd="USE_YN" dataPath="qcYn" name="qcYn"/>
                         </ppm:td>
                         <ppm:td label="설비사용유무" width="33%">
                   			<ppm:common-code mainCd="USE_YN" dataPath="equipUseYn" name="equipUseYn"/>
                         </ppm:td>
                     </ppm:tr>
                     <ppm:tr>
                        <ppm:td label='외주여부' width="33%">
                        	<ppm:common-code mainCd="OUTSC_FLAG" dataPath="outscFlag"/>
                        </ppm:td>
                     	<ppm:td label='외주거래처' width="320px">
                        	<ppm:form-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL"/>
                        </ppm:td>   
                     </ppm:tr>      
		             <ppm:tr>
		                <ppm:td label="파일첨부" width="100%">
	  						<ppm:file-uploader targetType = "ROUT_CD" targetId = "routCd"/>
		                </ppm:td>
		             </ppm:tr>     
                </ppm:tbl> 
	            <div class="H5"></div>      
					<div data-ax5layout="tab1" id="tab-content" style="height:340px"> 
	                  <ppm:tab-layout name="tab1" style="height:320px">
				       		<ppm:tab-panel label="공정별설비" scroll="scroll"> 
				                  <div class="ax-button-group">
				                      <div class="right">
						                  	<button type="button" class="btn btn-success" data-grid-view-01-btn="grid01-add">
						                        <i class="cqc-popin"></i> 설비 적용
						                    </button>
						                    <button type="button" class="btn btn-default" data-grid-view-01-btn="grid01-remove">
						                        <i class="cqc-minus"></i>
						                        <ppm:lang id="ax.admin.delete"/>
						                    </button>
				                      </div> 
				                  </div>
				                  <div data-ax5grid="grid-view-01" style="height: 260px;"></div>
				   			</ppm:tab-panel>
				       		<ppm:tab-panel label="공정별비가동" scroll="scroll"> 
				                  <div class="ax-button-group">
				                      <div class="right">
						                  	<button type="button" class="btn btn-success" data-grid-view-02-btn="grid02-add">
						                        <i class="cqc-popin"></i> 비가동 적용
						                    </button>
						                    <button type="button" class="btn btn-default" data-grid-view-02-btn="grid02-remove">
						                        <i class="cqc-minus"></i>
						                        <ppm:lang id="ax.admin.delete"/>
						                    </button>
				                      </div> 
				                  </div>
				                  <div data-ax5grid="grid-view-02" style="height: 260px;"></div>
				   			</ppm:tab-panel>
				   			<ppm:tab-panel label="공정별불량유형" scroll="scroll"> 
				                  <div class="ax-button-group">
				                      <div class="right">
						                  	<button type="button" class="btn btn-success" data-grid-view-03-btn="grid03-add">
						                        <i class="cqc-popin"></i> 불량 적용
						                    </button>
						                    <button type="button" class="btn btn-default" data-grid-view-03-btn="grid03-remove">
						                        <i class="cqc-minus"></i>
						                        <ppm:lang id="ax.admin.delete"/>
						                    </button>
				                      </div> 
				                  </div>
				                  <div data-ax5grid="grid-view-03" style="height: 260px;"></div>
				   			</ppm:tab-panel>
				   			<ppm:tab-panel label="공정별가용인원" scroll="scroll"> 
				                  <div class="ax-button-group">
				                      <div class="right">
						                  	<button type="button" class="btn btn-success" data-grid-view-04-btn="grid04-add">
						                        <i class="cqc-popin"></i> 가용인원 적용
						                    </button>
						                    <button type="button" class="btn btn-default" data-grid-view-04-btn="grid04-remove">
						                        <i class="cqc-minus"></i>
						                        <ppm:lang id="ax.admin.delete"/>
						                    </button>
				                      </div> 
				                  </div>
				                  <div data-ax5grid="grid-view-04" style="height: 260px;"></div>
				   			</ppm:tab-panel>
				   		</ppm:tab-layout>
			 		</div>
	       </ppm:form>
       </div>
    </jsp:body>
</ppm:layout>