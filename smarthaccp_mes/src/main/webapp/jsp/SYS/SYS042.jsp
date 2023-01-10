<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 사용자 로그관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="system-operation-log-version" value="1.0.0"/>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:layout name="base">
    <jsp:attribute name="js">
        <script src="/assets/plugins-fix/prettify/prettify.js"></script>
        <script src="/assets/plugins-fix/prettify/lang-css.js"></script>
    </jsp:attribute>
    <jsp:attribute name="css">
        <link rel="stylesheet" type="text/css" href="/assets/plugins-fix/prettify/skins/github.css"/>
    </jsp:attribute>
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <ppm:script-lang key="ax.admin" var="COL" />
        <script type="text/javascript" src="<c:url value='assets/SYS042.js' />"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <ppm:split-layout name="ax1" orientation="horizontal">
            <ppm:split-panel height="*" style="padding-bottom: 5px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <ppm:tbl clazz="ax-search-box" style="width:300px;margin-bottom: 7px;">
                        <ppm:form name="searchView0">
                            <div class="input-group">
                                <ppm:input type="text" name="userCd" id="userCd" clazz="form-control" value="" placeholder="ax.admin.input.search"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary">조회</button>
                                </span>
                            </div>
                        </ppm:form>
                    </ppm:tbl>
                    <%-- <div class="right">
                        <button type="button" class="btn btn-default" data-grid-view-01-btn="remove"><i class="cqc-circle-with-minus"></i> <ppm:lang id="ax.admin.delete"/></button>
                        <button type="button" class="btn btn-default" data-grid-view-01-btn="removeAll"><i class="cqc-circle-with-minus"></i> <ppm:lang id="ax.admin.delete.all"/></button>
                    </div> --%>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>