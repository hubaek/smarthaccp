<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 모니터링 및 검사장비 검ㆍ교정 목록표
 * 4. 변경이력 		: 
 *  	이름		|일자          		|변경내용
 *      ------------------------------------------------------
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
        <script type="text/javascript" src="<c:url value='assets/REPORT019M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 검·교정 대상 목록표<span id = "pgmTitle"></span></h1>  
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
	                        <ppm:td label='회사' width="33%">
			                	<ppm:company-code dataPath="company" /> 
	                        </ppm:td>	   	   
                            <ppm:td label="점검일자" width="35%" required="true">
                            	<div class="form-inline">
	                         		<div class="form-group">
	                         			<div class="input-group" data-ax5picker="basic">
		                         			<ppm:date-picker dataPath="reportDate" requiredFlag="true" title="점검일자"/>
		                         		</div>
                         				<button id="chk" class="btn btn-default" data-form-view-01-btn="check-date">중복체크</button>
										<input type="checkbox" id = "date_check" name="is_date_check" value="y" onclick="return false;" >
                        			</div>
                        		</div>
                            </ppm:td>
                            <ppm:td label="상태" width="32%">
                     			<input type="text" data-ax-path="status" title="상태" id="status-id" class="form-control" readonly/>
                        	</ppm:td>
                        	 
                        </ppm:tr>            
                        <ppm:tr>
                            <ppm:td label="작성자" width="33%">
                                <input type="text" data-ax-path="writer" title="작성자" class="form-control" readonly/>
                            </ppm:td>
                            <ppm:td label="승인자" width="35%">
                                <input type="text" data-ax-path="approver" title="승인자" class="form-control" readonly/>
                            </ppm:td>                     
                        </ppm:tr>
                        
                        <!-- 그리드 -->
                        <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 380px;"></div>
                        
                        <ppm:tr>
							<ppm:td label="부적합사항" width="50%">
								<textarea data-ax-path="remark1" class="form-control" rows=4></textarea>
		                	</ppm:td>
			                <ppm:td label="조치사항" width="50%">
								<textarea data-ax-path="remark2" class="form-control" rows=4></textarea>
			                </ppm:td>
	            		</ppm:tr> 
                        <ppm:tr>
		                	<ppm:td label="파일첨부" width="100%">
						 		<ppm:file-uploader2 targetType = "REPORT014M" targetId = "reportDate"/>
		                	</ppm:td>
	            		</ppm:tr>
	            		
	            		<!-- 안내문구 -->
                        <div style="text-align:center; padding:1em;">
                        	<h2>※ 공인기관 검·교정 의뢰 시 한국인정기구 코라스에서 지역별 검고정 업체 검색 가능</h2>
                        	<h2>(http://www.kolas.go.kr/usr/inf/srh/InfoCrrcInsttSearchList.do)</h2>
                        </div>
                        <div style="padding:1em;">
                        	<h3>※ 자체 검·교정 허용오차 기준</h3>
                        	<h3> - 자체 검·교정 허용오차 기준은 별도의 기준은 없으나, "중소기업 HACCP적용 지침서"를 참고하면 저울은 ±1% 온도계는 1℃로 설정되어 있음</h3>
                        	<h3> - 저울의 ±2%나 온도계의 ±2℃를 검·교정 오차범위로 설정할 경우 편차의 크기가 4%(℃)로 그 적합성 유무를 확인할 필요가 있으며, 보정하여 사용하는 것을 권고함</h3>
                        </div>
                        
                    </ppm:tbl>
                    
                    
       		</ppm:form>
		</div>
	</jsp:body>
</ppm:layout>
<script>
	//중복채크후 id 변경시 validation 되어진 값 초기화
	$("#inspectionDate").on("propertychange change keyup paste input", function() {
		if(inFlag == true){
			inFlag = false;
			$("input:checkbox[id='chk']").prop("checked", false);	
		}
	});
</script>