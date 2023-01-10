<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 환경설정
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="pop_modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/setup-modal.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">  <i class="cqc-browser"></i>권한</h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
        	<button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
            <button type="button" class="btn btn-info W100" data-page-btn="save">변경</button>
            <button type="button" class="btn btn-fn2 W100" data-page-btn="logout" onclick="parent.location.href = '${pageContext.request.contextPath}/api/logout';">로그아웃</button>
            <button type="button" class="btn btn-default W100" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="55%" style="padding-right: 10px;">
                <ppm:form name="formView01">
	                <ppm:tbl clazz="ax-form-tbl" minWidth="500px">
                     	<ppm:tr>
                     		<ppm:td label='mes.admin.company' width="50%">
                     			<ppm:company-code dataPath="company" readonly="readonly" clazz="W200"/> 
                     		</ppm:td>
                            <ppm:td label="ax.admin.user.id" width="50%">
                                <input type="text" name="userCd" data-ax-path="userCd" maxlength="100" title="아이디" class="form-control W200" readonly="readonly"/>
                            </ppm:td>
	                    </ppm:tr>
                        <ppm:tr >
                            <ppm:td label="공정분류" width="50%">
                                <ppm:common-code mainCd="ROUT_TYPE" dataPath="routType" emptyText="전체" emptyValue="" clazz="W200"/>
                            </ppm:td>
                            <ppm:td label="공정" width="50%">
                     			<ppm:rout-code dataPath="routCd" name="routCd" emptyText="전체" emptyValue="" clazz="W200"/>
                            </ppm:td>
                        </ppm:tr>
                        <ppm:tr >
                            <ppm:td label="바코드프린터" width="50%">
                     			<ppm:print-code dataPath="printCd" disabledFlag="Y" clazz="W200"/>
                            </ppm:td>
                        </ppm:tr>
                    </ppm:tbl>
                </ppm:form>
            </ppm:split-panel>
		</ppm:split-layout>
    </jsp:body>
</ppm:layout>