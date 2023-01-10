<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 거래처 등록
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
        <script type="text/javascript" src="<c:url value='assets/STD020M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 거래처 등록<span id = "pgmTitle"></span></h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N"  clear="N">          
	        <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
	        <button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
	        <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
        </ppm:page-buttons>             
		<div id="modal-content" style="height:680px;">
			<ppm:form name="formView01">
           		<ppm:tbl clazz="ax-form-tbl">            
                   	<ppm:tr>
                        <ppm:td label='회사' width="33%">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>	   
                        <ppm:td label='거래처유형' width="33%">
	                        <ppm:common-code mainCd="CUST_TYPE" dataPath="custType"/>
                        </ppm:td>
                           <ppm:td label="사용여부" width="33%">
                    			<ppm:common-code mainCd="USE_YN" dataPath="useYn" name="useYn" id="useYn"/>
                           </ppm:td>
                      </ppm:tr>   
                      <ppm:tr>
                          <ppm:td label="거래처코드" width="33%" required="true">
                              <input type="text" data-ax-path="custCd" id="custCd" title="거래처코드" class="form-control inline-block W170 required" data-ax-validate="required"/>
                          	  <button id="checkId" class="btn btn-default" data-form-view-01-btn="checkId">중복체크</button>
                          </ppm:td>
                          <ppm:td label="거래처명" width="33%" required="true">
                              <input type="text" data-ax-path="custNm" placeholder="거래처명" title="거래처명" class="form-control required" data-ax-validate="required"/>
                          </ppm:td>
                          <ppm:td label="사업자번호" width="33%">
                              <input type="text" data-ax-path="businessNo" class="form-control" onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');"/>
                          </ppm:td>
                      </ppm:tr> 
					</ppm:tbl>
					<div class="H5"></div>
					<ppm:tbl clazz="ax-form-tbl" minWidth="500px">
					  <ppm:tr>
                          <ppm:td label="대표자명" width="33%">
                              <input type="text" data-ax-path="ceoNm" class="form-control"/>
                          </ppm:td>
                          <ppm:td label="대표자연락처" width="33%">
                              <input type="text" data-ax-path="businessType1" class="form-control"/>
                          </ppm:td>
                          <ppm:td label="업종" width="33%">
                              <input type="text" data-ax-path="businessType2" class="form-control"/>
                          </ppm:td>
                      </ppm:tr>             
                      <ppm:tr>
                           <ppm:td label="주소" width="100%">
                               <input type="text" data-ax-path="zipcode" class="form-control inline-block W250" readonly="readonly"/>
                               <button class="btn btn-default" data-form-view-01-btn="etc1find"><i class="cqc-magnifier"></i> <ppm:lang id="ax.admin.sample.form.find"/></button>
                               <div class="H5"></div>
                               <input type="text" data-ax-path="address" class="form-control"/>
                           </ppm:td>
                      	</ppm:tr>                       	
                      <ppm:tr>
                          <ppm:td label="전화" width="33%">
                              <input type="text" data-ax-path="tel"  maxlength="15" placeholder="" class="av-phone form-control" data-ax5formatter="phone"/>
                          </ppm:td>
                          <ppm:td label="FAX" width="33%">
                              <input type="text" data-ax-path="fax" maxlength="15" placeholder="" class="av-phone form-control" data-ax5formatter="phone"/>
                          </ppm:td>                       
                      </ppm:tr>
                      <ppm:tr>
                          <ppm:td label="담당자Phone" width="33%">
                              <input type="text" data-ax-path="manPhone"  maxlength="15" placeholder="" class="av-phone form-control" data-ax5formatter="phone"/>
                          </ppm:td>
                          <ppm:td label="담당자명" width="33%">
                              <input type="text" data-ax-path="manNm" class="form-control"/>
                          </ppm:td>
                      </ppm:tr>  
                      <ppm:tr>
                      	   <ppm:td label="이메일" width="33%">
                              <input type="text" data-ax-path="email" class="form-control"/>
                          </ppm:td>
                      	   <ppm:td label="이메일_계산서" width="33%">
                              <input type="text" data-ax-path="acctEmail" class="form-control"/>
                          </ppm:td>
                      </ppm:tr>   
                      <ppm:tr>
                          <ppm:td label="금융기관" width="33%">
                              <input type="text" data-ax-path="bank" class="form-control"/>
                          </ppm:td>
                      	   <ppm:td label="예금주" width="33%">
                              <input type="text" data-ax-path="depositor" class="form-control"/>
                          </ppm:td>
                          <ppm:td label="계좌번호" width="33%">
                              <input type="text" data-ax-path="accountNo" class="form-control"/>
                          </ppm:td>
                          
                      </ppm:tr>      	
                      <ppm:tr>
                          <ppm:td label="거래시작일" width="33%">
	                  		<div class="input-group" data-ax5picker="date">
		                        <input type="text" class="form-control" data-ax-path="startDt" placeholder="yyyy-mm-dd"/>
		                        <span class="input-group-addon"><i class="cqc-calendar"></i></span>
	                        </div>
                          </ppm:td>
                          
                          <ppm:td label="거래종료일" width="33%">
	                  		<div class="input-group" data-ax5picker="date">
		                        <input type="text" class="form-control" data-ax-path="endDt" placeholder="yyyy-mm-dd"/>
		                        <span class="input-group-addon"><i class="cqc-calendar"></i></span>
	                        </div>
                          </ppm:td>                       
                      </ppm:tr>     
                   	  <ppm:tr>
                          <ppm:td label="비고" width="100%">
							<textarea data-ax-path="remark" class="form-control" rows=3></textarea>
                          </ppm:td>
                      </ppm:tr>              
		              <ppm:tr>
		              <ppm:td label="파일첨부" width="100%">
   					  	  <ppm:file-uploader targetType = "CUST_CD" targetId = "custCd"/>
		              </ppm:td>
		            </ppm:tr>                   
				</ppm:tbl>
			</ppm:form>
		</div>
	<div class="H5"></div>    
	</jsp:body>
</ppm:layout>