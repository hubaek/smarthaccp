<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 설비정보등록
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
        <script type="text/javascript" src="<c:url value='assets/EQ000M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 설비정보 등록<span id = "pgmTitle"></span></h1>  
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
                         <ppm:td label="사용여부" width="33%">
                  			<ppm:common-code mainCd="USE_YN" dataPath="useYn"/>
                         </ppm:td>
	              </ppm:tr>
	              <ppm:tr>
	                  <ppm:td label="설비코드" width="33%" required="true">
	                      <input type="text" data-ax-path="equipCd" id="equipCd" title="설비코드" class="form-control inline-block W200" data-ax-validate="required"/>
	                      <button id="checkId" class="btn btn-default" data-form-view-01-btn="checkId">중복체크</button>
                          	<input type="checkbox"  id="chk" onclick="return false;"/>
	                  </ppm:td>
	                  <ppm:td label="설비명" width="33%" required="true">
	                      <input type="text" data-ax-path="equipNm" title="설비명" class="form-control required" data-ax-validate="required"/>
	                  </ppm:td>
	                  <ppm:td label="설비유형" width="33%" required="true">
	               		<ppm:common-code mainCd="EQUIP_TYPE" dataPath="equipType"/>
	                  </ppm:td>
	              </ppm:tr>
	              <ppm:tr>
	                  <ppm:td label="메이커명" width="33%">
	                      <input type="text" data-ax-path="equipMaker" class="form-control"/>
	                  </ppm:td>
	                  <ppm:td label="모델명" width="33%">
	                      <input type="text" data-ax-path="modelNm" class="form-control"/>
	                  </ppm:td> 
	                  <ppm:td label="설비규격" width="33%">
	                      <input type="text" data-ax-path="equipSpec" class="form-control"/>
	                  </ppm:td>
	              </ppm:tr>
	              <ppm:tr>             
	                    <ppm:td label='구매처' width="33%">
	                        <ppm:form-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL"/>
                        </ppm:td>     
	                  <ppm:td label="구매일자" width="33%">
                  		<div class="input-group" data-ax5picker="date">
	                        <input type="text" class="form-control" data-ax-path="purchaseDt" placeholder="yyyy-mm-dd"/>
	                        <span class="input-group-addon"><i class="cqc-calendar"></i></span>
	                    </div>
	                  </ppm:td>    
	                  <ppm:td label="구매금액" width="33%">
		              		<input type="text" data-ax-path="pcAmt" class="form-control" style="text-align:right" data-ax5formatter="number"/>
	                  </ppm:td>     
	               </ppm:tr>   
		           <ppm:tr>	                  
		            	<ppm:td label="실토출량(A제)" width="33%">
		                	<input type="text" data-ax-path="option1" class="form-control" style="text-align:right" data-ax5formatter="number"/>
		                </ppm:td>       
		            	<ppm:td label="실토출량(B제)" width="33%">
		                	<input type="text" data-ax-path="option2" class="form-control" style="text-align:right" data-ax5formatter="number"/>
		                </ppm:td>       
		            </ppm:tr>            
                  	<ppm:tr> 
                        <ppm:td label="PLC사용" width="33%">
                  			<ppm:common-code mainCd="USE_YN" dataPath="plcYn"/>
                        </ppm:td>
		                <ppm:td label="PLC IP" width="33%">
		                    <input type="text" data-ax-path="plcIp" class="form-control"/>
		                </ppm:td>
		            	<ppm:td label="PLC PORT" width="33%">
		                    <input type="text" data-ax-path="plcPort" class="form-control"/>
		                </ppm:td>       
                    </ppm:tr>   
                    <ppm:tr>
                         <ppm:td label="비고" width="100%">
							<textarea data-ax-path="remark" class="form-control" rows=14></textarea>
                         </ppm:td>
                    </ppm:tr>
                	<ppm:tr>
		                 <ppm:td label="파일첨부" width="100%">
						 	<ppm:file-uploader targetType = "EQUIP_CD" targetId = "equipCd"/>
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
	$("#equipCd").on("propertychange change keyup paste input", function() {
		if(inFlag == true){
			inFlag = false;
			$("input:checkbox[id='chk']").prop("checked", false);	
		}
	});
</script>