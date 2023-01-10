<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 사용자관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="system-auth-user-version" value="1.0.0"/>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="true"/>

<ppm:layout name="base">
    <jsp:attribute name="script"> 
        <ppm:script-lang key="ax.script" var="LANG" />
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SYS030.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>  
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr>
                        <ppm:td label='부서' width="230px" >
			                <ppm:dept-code name="deptCd" emptyText="ALL" emptyValue="" />
                        </ppm:td>
                        <ppm:td label='ID' width="230px" >
                            <input type="text" id="userCd" name="userCd" class="form-control"/>
                        </ppm:td>
                        <ppm:td label='이름' width="230px" >
                            <input type="text" id="userNm" name="userNm" class="form-control"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H5"></div>
        </div>

        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="50%" style="padding-right: 10px;">

                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>
                            <ppm:lang id="ax.admin.user.title"/>
                        </h5>
                    </div>
                    <div class="right">
                        <button type="button" class="btn btn-default" data-form-view-01-btn="form-clear">
                            <i class="cqc-plus2"></i>신규 사용자등록
                        </button>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>

            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" scroll="scroll"  id = "split-panel-form">
                <div class="ax-button-group" role="panel-header">
                    <div class="left">
                        <h5><i class="cqc-news"></i>
                            <ppm:lang id="ax.admin.user.information"/>
                        </h5>
                    </div>
                </div>
                <ppm:form name="formView01">
                    <ppm:tbl clazz="ax-form-tbl" minWidth="500px">
                        <ppm:tr> 
                            <ppm:td label="사용자명" width="33%" required="true">
                                <input type="text" name="userNm" data-ax-path="userNm" maxlength="15"  title="사용자명" class="form-control required" data-ax-validate="required"/>
                            </ppm:td>
                            <ppm:td label="아이디" width="42%" required="true">
                            	<input type="text" data-ax-path="userCd" name="userCd" id="userCd" title="아이디" class="form-control inline-block W130 required" data-ax-validate="required"/>	
                                <button id="checkId" class="btn btn-default" data-form-view-01-btn="checkId">중복체크</button>
                            </ppm:td>
                            <ppm:td label="사용여부" width="25%" required="true">
                                <ppm:common-code mainCd="USE_YN" dataPath="useYn" clazz="form-control"/>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr> 
                            <ppm:td label="사용자명(KO)" width="25%">
                                <input type="text" name="userNmKo" data-ax-path="userNmKo"  title="사용자명" class="form-control"/>
                            </ppm:td>
                            <ppm:td label="사용자명(EN)" width="25%">
                                <input type="text" name="userNmEn" data-ax-path="userNmEn"  title="사용자명" class="form-control"/>
                            </ppm:td>
                            <ppm:td label="사용자명(CHS)" width="25%">
                                <input type="text" name="userNmZh1" data-ax-path="userNmZh1"  title="사용자명" class="form-control"/>
                            </ppm:td>
                            <ppm:td label="사용자명(CHT)" width="25%">
                                <input type="text" name="userNmZh2" data-ax-path="userNmZh2"  title="사용자명" class="form-control"/>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                            <ppm:td label="비밀번호" width="50%">
                                <input type="password" name="userPs" data-ax-path="userPs" maxlength="128" class="form-control" value="" readonly="readonly"/>
                            </ppm:td>
                            <ppm:td label="비밀번호 확인" width="50%">
                                <input type="password" name="userPs_chk" data-ax-path="userPs_chk" maxlength="128" class="form-control inline-block W120" value="" readonly="readonly"/>
                                &nbsp;
                                <label>
                                    <input type="checkbox" data-ax-path="password_change" name="password_change" value="Y"/>
                                    <ppm:lang id="ax.admin.user.password.change"/>
                                </label>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                            <ppm:td label="이메일" width="33%">
                                <input type="text" name="email" data-ax-path="email" maxlength="50" title="이메일" placeholder="abc@abc.com" class="av-email form-control" value=""/>
                            </ppm:td>
                            <ppm:td label="휴대폰번호" width="33%">
                                <input type="text" name="hpNo" data-ax-path="hpNo" maxlength="15" placeholder="" class="av-phone form-control" data-ax5formatter="phone" value=""/>
                            </ppm:td>
			                <ppm:td label="부서" width="33%">
			                	<ppm:dept-code dataPath="deptCd"/>
			                </ppm:td>
                        </ppm:tr>
                        <ppm:tr >    
			                <ppm:td label="직위" width="33%">
			                	<ppm:common-code mainCd="USER_POSITION" dataPath="userPosition"/>
			                </ppm:td>
			                <ppm:td label="직책" width="33%">
			                	<ppm:common-code mainCd="USER_DUTY" dataPath="userDuty"/>
			                </ppm:td>
                            <ppm:td label="계정상태" width="33%" required="true">
                                <ppm:common-code mainCd="USER_ST" dataPath="userSt"/>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                        	<ppm:td label="법인권한" width="100%">
                        		<ppm:company-code id="company_auth" dataPath="companyAuthCd" type="checkbox" /> 
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                            <ppm:td label="비고" width="100%">
      							<textarea data-ax-path="remark" class="form-control" rows=5></textarea>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr>
                            <ppm:td label="알림수신동의" width="100%">
                                <input type="checkbox" name="mailAgree">
                            </ppm:td>
                       	</ppm:tr>
                    </ppm:tbl>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>