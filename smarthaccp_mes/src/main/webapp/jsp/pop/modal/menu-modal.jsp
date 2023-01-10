<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<ppm:set key="pageName" value="File Browser"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="pop_modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/menu-modal.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">  <i class="cqc-browser"></i>메뉴</h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
        	<button type="button" class="btn btn-default W80" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
            <button type="button" class="btn btn-default W120" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="55%" style="padding-right: 10px;">
                <ppm:form name="formView01">
		            <button type="button" class="btn btn-info W150 H80" data-form-view-01-btn="menu1">바코드재발행</button>
                </ppm:form>
            </ppm:split-panel>
		</ppm:split-layout>
    </jsp:body>
</ppm:layout>