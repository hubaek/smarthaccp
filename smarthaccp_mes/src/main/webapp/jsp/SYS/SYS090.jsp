<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: COMPANY 관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>  
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="false"/>  
<ppm:layout name="base"> 
    <jsp:attribute name="script"> 
        <ppm:script-lang key="ax.script" /> 
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SYS090.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body> 
        <ppm:page-buttons></ppm:page-buttons> 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>    
                        <ppm:td label='회사코드' width="230px">
                            <ppm:input type="text" name="company" clazz="form-control"/>
                        </ppm:td>
                        <ppm:td label='회사명' width="230px">
                            <ppm:input type="text" name="companyNm" clazz="form-control"/>
                        </ppm:td>
                        <ppm:td label="사용여부" width="230px">
                     		<ppm:common-code mainCd="USE_YN" emptyText="ALL" emptyValue="" name="useYn" defaultValue="Y"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H5"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="40%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i></h5>
                    </div>
                    <div class="right">
                        <button type="button" class="btn btn-default" data-form-view-01-btn="form-clear">
                            <i class="cqc-plus2"></i>신규 회사등록
                        </button>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" scroll="scroll" id = "split-panel-form">	               	
                <ppm:form name="formView01">
	                <div class="ax-button-group" data-fit-height-aside="grid-view-02">
	                    <div class="left">
	                        <h5><i class="cqc-list"></i></h5>
	                    </div>
	                </div>
                	<ppm:tbl clazz="ax-form-tbl" minWidth="600px">
                       <ppm:tr>
                           <ppm:td label="회사코드" width="33%" required="true">
                               <input type="text" data-ax-path="company" id = "company" class="form-control required" data-ax-validate="required" title="회사코드"/>
                           </ppm:td>
                           <ppm:td label="회사명" width="33%" required="true">
                               <input type="text" data-ax-path="companyNm" class="form-control"  data-ax-validate="required" title="회사명"/>
                           </ppm:td>
                           <ppm:td label="회사명(영문)" width="33%">
                               <input type="text" data-ax-path="engCompanyNm" class="form-control"/>
                           </ppm:td>
                       </ppm:tr> 
                       <ppm:tr>
                           <ppm:td label="코드약어" width="33%"  required="true">
                               <input type="text" data-ax-path="companyType" class="form-control"  data-ax-validate="required" title="해당 약어 기준으로 코드발번에 활용합니다."/>
                           </ppm:td>
                           <ppm:td label="로고파일명" width="33%"  required="true">
                               <input type="text" data-ax-path="logoNm" class="form-control"  data-ax-validate="required" title="회사로고파일명"/>
                           </ppm:td>
                       </ppm:tr>
                       <ppm:tr>
                           <ppm:td label="사업자번호" width="33%">
                               <input type="text" data-ax-path="businessNo" class="form-control"  placeholder="비사업자는 넣지 않으셔도 됩니다."/>
                           </ppm:td>
                           
                           <ppm:td label="법인번호" width="33%">
                               <input type="text" data-ax-path="corporateNo" class="form-control"/>
                           </ppm:td>		                          
                           
                           <ppm:td label="대표자명" width="33%">
                               <input type="text" data-ax-path="ceoNm" class="form-control"/>
                           </ppm:td>
                       </ppm:tr>
                       <ppm:tr>
                           <ppm:td label="담당자 Email" width="33%">
                               <input type="text" data-ax-path="email" class="form-control"/>
                           </ppm:td>
                           <ppm:td label="회사 전화" width="33%"> 
                           	<input type="text" data-ax-path="tel" class="form-control" placeholder="'-' 포함하여 입력하세요"/>
                           </ppm:td>
                           <ppm:td label="회사 FAX" width="33%">
                               <input type="text" data-ax-path="fax" class="form-control" placeholder="'-' 포함하여 입력하세요"/>
                           </ppm:td>
                       </ppm:tr>
                       <ppm:tr>
                           <ppm:td label="Haccp팀장명" width="33%">
                               <input type="text" data-ax-path="leaderName" class="form-control"/>
                           </ppm:td>
                           <ppm:td label="팀장전화번호" width="33%"> 
                           	<input type="text" data-ax-path="leaderPhone" class="form-control" placeholder="'-' 포함하여 입력하세요"/>
                           </ppm:td>
                           <ppm:td label="인증원표준업종코드" width="33%">
                               <input type="text" data-ax-path="confirmCd" class="form-control"/>
                           </ppm:td>
                       </ppm:tr>
                       <ppm:tr>
                           <ppm:td label="설립일" width="33%">
		                   		<div class="input-group" data-ax5picker="date">
			                         <input type="text" class="form-control" data-ax-path="establishDate" placeholder="yyyy-mm-dd"/>
			                         <span class="input-group-addon"><i class="cqc-calendar"></i></span>
		                     	</div>
                           </ppm:td>
                           <ppm:td label="업태" width="33%">
                               <input type="text" data-ax-path="category1" class="form-control" />
                           </ppm:td>
                           <ppm:td label="종목" width="33%">
                               <input type="text" data-ax-path="category2" class="form-control"/>
                           </ppm:td>
                       </ppm:tr>
                       <ppm:tr>
                            <ppm:td label="언어" width="33%">
                                <ppm:common-code mainCd="LOCALE" dataPath="locale"/>
                            </ppm:td>
						   <ppm:td label="정렬" width="33%" required="true">
                               <input type="text" data-ax-path="sort" class="form-control required" data-ax5formatter="number"/>
                           </ppm:td>
                           <ppm:td label="사용여부" width="33%">
                        		<ppm:common-code mainCd="USE_YN" dataPath="useYn"/>
                           </ppm:td>
                       </ppm:tr>
                       <ppm:tr>
                            <ppm:td label="주소" width="100%">
                                <input type="text" data-ax-path="address1" class="form-control inline-block W100" readonly="readonly"/>
                                <button class="btn btn-default" data-form-view-01-btn="etc1find"><i class="cqc-magnifier"></i> <ppm:lang id="ax.admin.sample.form.find"/></button>
                                <div class="H5"></div>
                                <input type="text" data-ax-path="address2" class="form-control"/>
                            </ppm:td>
                       	</ppm:tr>
                       	<ppm:tr>
                            <ppm:td label="데이터수집동의" width="100%">
                                <input type="checkbox" name="consent">
                            </ppm:td>
                       	</ppm:tr>
                   	</ppm:tbl>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>