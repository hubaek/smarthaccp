<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<ppm:set key="pageName" value="File Browser"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/USER-INFO-M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">  <i class="cqc-browser"></i>사용자 정보변경 </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-info W100" data-page-btn="save">비밀번호 변경</button>
            <button type="button" class="btn btn-default" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="55%" style="padding-right: 10px;">
                <ppm:form name="formView01">
	                <ppm:tbl clazz="ax-form-tbl" minWidth="500px">
                     	<ppm:tr labelWidth="120px">
                     		<ppm:td label='mes.admin.company' width="50%">
                     			<ppm:company-code dataPath="company" readonly="readonly"/> 
                     		</ppm:td>
	                    </ppm:tr>
                        <ppm:tr labelWidth="120px"> 
                            <ppm:td label="ax.admin.user.name" width="50%">
                                <input type="text" name="userNm" data-ax-path="userNm" maxlength="15"  title="asd" class="form-control required" data-ax-validate="required"/>
                            </ppm:td>
                            <ppm:td label="ax.admin.user.id" width="50%">
                                <input type="text" name="userCd" data-ax-path="userCd" maxlength="100" title="아이디" class="form-control required" data-ax-validate="required"/>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr labelWidth="120px">
                            <ppm:td label="ax.admin.user.password" width="50%" required="true">
                                <input type="password" name="userPs" data-ax-path="userPs" maxlength="128" class="form-control"  value="" readonly="readonly"/>
                            </ppm:td>
                            <ppm:td label="ax.admin.user.password.confirm" width="50%" required="true">
                                <input type="password" name="userPs_chk" data-ax-path="userPs_chk" maxlength="128" class="form-control inline-block W120" value="" readonly="readonly"/>
                                &nbsp;
                                <label>
                                    <input type="checkbox" data-ax-path="password_change" name="password_change" value="Y"/>
                                    <ppm:lang id="ax.admin.user.password.change"/> 
                                </label>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr labelWidth="120px">
                            <ppm:td label="ax.admin.user.email" width="50%">
                                <input type="text" name="email" data-ax-path="email" maxlength="50" title="이메일" placeholder="abc@abc.com" class="av-email form-control" value=""/>
                            </ppm:td>
                            <ppm:td label="ax.admin.user.hp" width="50%" labelWidth="120px">
                                <input type="text" name="hpNo" data-ax-path="hpNo" maxlength="15" placeholder="" class="av-phone form-control" data-ax5formatter="phone" value=""/>
                            </ppm:td>
                        </ppm:tr>
                    </ppm:tbl>
                </ppm:form>
            </ppm:split-panel>
		</ppm:split-layout>
    </jsp:body>
</ppm:layout>