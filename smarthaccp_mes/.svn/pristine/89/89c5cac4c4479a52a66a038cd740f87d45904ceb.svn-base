<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 에러로그관리
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
        <script type="text/javascript" src="<c:url value='assets/SYS041.js' />"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <ppm:split-layout name="ax1" orientation="horizontal">
            <ppm:split-panel height="*" style="padding-bottom: 5px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <ppm:tbl clazz="ax-search-box" style="width:300px;margin-bottom: 7px;">
                        <ppm:form name="searchView0">
                            <div class="input-group">
                                <ppm:input type="text" name="filter" id="filter" clazz="form-control" value="" placeholder="ax.admin.input.search"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary">조회</button>
                                </span>
                            </div>
                        </ppm:form>
                    </ppm:tbl>
                    <div class="right">
                        <button type="button" class="btn btn-default" data-grid-view-01-btn="remove"><i class="cqc-circle-with-minus"></i> <ppm:lang id="ax.admin.delete"/></button>
                        <button type="button" class="btn btn-default" data-grid-view-01-btn="removeAll"><i class="cqc-circle-with-minus"></i> <ppm:lang id="ax.admin.delete.all"/></button>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel height="*" style="padding-top: 10px;" scroll="scroll">
                <ppm:form name="formView01">
                    <div class="ax-button-group">
                        <div class="left">
                            <h2><i class="cqc-classic-computer"></i> Stack Trace</h2>
                        </div>
                    </div>
                    <div class="form-control for-prettify" style="height:auto;padding: 0;" data-ax-path="trace"></div>
                    <div class="ax-button-group">
                        <div class="left">
                            <h5><i class="cqc-info-with-circle"></i> <ppm:lang id="ax.admin.errorlog.message"/></h5>
                        </div>
                    </div>
                    <pre class="form-control for-prettify" style="height:auto;padding: 0;" data-ax-path="message"></pre>
                    <div class="ax-button-group">
                        <div class="left">
                            <h5><i class="cqc-info-with-circle"></i> <ppm:lang id="ax.admin.errorlog.parameter.info"/></h5>
                        </div>
                    </div>
                    <pre class="form-control for-prettify" style="height:auto;padding: 0;" data-ax-path="parameterMap"></pre>
                    <div class="ax-button-group">
                        <div class="left">
                            <h2><i class="cqc-info-with-circle"></i> <ppm:lang id="ax.admin.errorlog.header.info"/></h2>
                        </div>
                        <div class="right">
                            <!--<button type="button" class="AXButton" id="ax-form-btn-new"><i class="axi axi-plus-circle"></i> 신규</button>-->
                        </div>
                    </div>
                    <pre class="form-control for-prettify" style="height:auto;padding: 0;" data-ax-path="headerMap"></pre>
                    <div class="ax-button-group">
                        <div class="left">
                            <h2><i class="cqc-info-with-circle"></i> <ppm:lang id="ax.admin.errorlog.user.info"/></h2>
                        </div>
                    </div>
                    <pre class="form-control for-prettify" style="height:auto;padding: 0;" data-ax-path="userInfo"></pre>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>