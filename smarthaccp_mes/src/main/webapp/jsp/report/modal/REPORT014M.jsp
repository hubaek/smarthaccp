<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 검증결과보고서
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
        <script type="text/javascript" src="<c:url value='assets/REPORT014M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 검증 결과보고서 등록<span id = "pgmTitle"></span></h1>  
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
		                         			<ppm:date-picker dataPath="reportDate" requiredFlag="true" onchange="fn_reportDateChg(this)" title="점검일자"/>
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
                        
                        <ppm:tr>
	                        <ppm:td label="문서번호" width="25%">
                     			<input type="text" data-ax-path="mitem001" title="상태" id="status-id" class="form-control"/>
	                        </ppm:td>	   	   
                            <ppm:td label="제정일자" width="25%">
                     			<ppm:date-picker dataPath="mitem002" requiredFlag="true" title="제정일자"/>
                            </ppm:td>
                            <ppm:td label="개정번호" width="25%">
                     			<input type="text" data-ax-path="mitem003" title="상태" id="status-id" class="form-control"/>
                        	</ppm:td>
                            <ppm:td label="페이지" width="25%">
                     			<input type="text" data-ax-path="mitem004" title="상태" id="status-id" class="form-control"/>
                        	</ppm:td>
                        </ppm:tr>
                        <ppm:tr>
	                        <ppm:td label="검증부서" width="50%">
                     			<input type="text" data-ax-path="mitem005" title="상태" id="status-id" class="form-control"/>
	                        </ppm:td>	   	   
                            <ppm:td label="검증일자" width="50%">
                     			<ppm:date-picker dataPath="mitem006" requiredFlag="true" title="검증일자"/>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
	                        <ppm:td label="검증목적 및 범위" width="100%">
                     			<textarea data-ax-path="mitem007" class="form-control" rows=4></textarea>
	                        </ppm:td>	   	   
                        </ppm:tr>
                        <ppm:tr>
	                        <ppm:td label="작성일자" width="100%">
                     			<ppm:date-picker dataPath="mitem008" requiredFlag="true" title="작성일자"/>
	                        </ppm:td>	   	   
                        </ppm:tr>
                        <ppm:tr>
	                        <ppm:td label="검증팀구성<br>(검증팀장)" width="100%">
	                        	<ppm:tr>
	                        		<ppm:td label="검증팀장" width="100%">
		                     			<input type="text" data-ax-path="mitem009" title="검증팀원1" class="form-control"/>
	                        		</ppm:td>
	                        	</ppm:tr>
	                        	<ppm:tr>
	                        		<ppm:td label="검증팀원1" width="100%">
		                     			<input type="text" data-ax-path="mitem010" title="검증팀원1" class="form-control"/>
	                        		</ppm:td>
	                        	</ppm:tr>
	                        	<ppm:tr>
	                        		<ppm:td label="검증팀원2" width="100%">
		                     			<input type="text" data-ax-path="mitem011" title="검증팀원2" class="form-control"/>
	                        		</ppm:td>
	                        	</ppm:tr>
	                        </ppm:td>	   	   
                        </ppm:tr>
                        <ppm:tr>
	                        <ppm:td label="검증결과요약<br>(총평)" width="100%">
		                        <ppm:tr>
			                        <ppm:td label="■ 평가방법" width="100%">
	                     				<textarea data-ax-path="mitem012" class="form-control" rows=4>
		                     			</textarea>
	                     			</ppm:td>
		                        </ppm:tr>
		                        <ppm:tr>
			                        <ppm:td label="■ 평가결과" width="100%">
	                     				<textarea data-ax-path="mitem013" class="form-control" rows=4>
		                     			</textarea>
	                     			</ppm:td>
		                        </ppm:tr>
		                        <ppm:tr>
			                        <ppm:td label="■ 부적합" width="100%">
	                     				<textarea data-ax-path="mitem014" class="form-control" rows=4>
		                     			</textarea>
	                     			</ppm:td>
		                        </ppm:tr>
		                        <ppm:tr>
			                        <ppm:td label="■ 개선사항" width="100%">
	                     				<textarea data-ax-path="mitem015" class="form-control" rows=4>
		                     			</textarea>
	                     			</ppm:td>
		                        </ppm:tr>
	                        </ppm:td>	   	   
                        </ppm:tr>
                        <ppm:tr>
	                        <ppm:td label="전회검증 시정<br>조치 결과확인" width="100%">
                     			<input type="text" data-ax-path="mitem016" title="전회검증 시정조치 결과확인" class="form-control"/>
	                        </ppm:td>	   	   
                        </ppm:tr>
                        <ppm:tr>
	                        <ppm:td label="적합성평가" width="100%">
                     			적합<input type="radio" data-ax-path="mitem012" name="mitem017" value="적합"/>
								개선필요<input type="radio" data-ax-path="mitem012" name="mitem017" value="개선필요"/>
	                        </ppm:td>	   	   
                        </ppm:tr>
                        <ppm:tr>
	                        <ppm:td label="특이사항" width="100%">
                     			<textarea data-ax-path="mitem018" class="form-control" rows=4>
                     			</textarea>
	                        </ppm:td>	   	   
                        </ppm:tr>
                        
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
                    </ppm:tbl>
                    
                    
       		</ppm:form>
		</div>
	</jsp:body>
</ppm:layout>
<script>
	//중복채크후 id 변경시 validation 되어진 값 초기화
	$("#reportDate").on("propertychange change keyup paste input", function() {
		if(inFlag == true){
			inFlag = false;
			$("input:checkbox[id='chk']").prop("checked", false);	
		}
	});
</script>