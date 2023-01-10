<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>

<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/REF-FORM-M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">  
            <i class="cqc-browser"></i>
            종결 처리  
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
            <button type="button" class="btn btn-fn1 W50" data-page-btn="choice">종결처리</button>
        </ppm:page-buttons>
         <!-- 목록 -->
         <div class="ax-button-group" data-fit-height-aside="grid-view-01">
             <div class="left">
                 <h5><i class="cqc-list"></i></h5>
             </div>
         </div>
         <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 330px"></div>
    </jsp:body>
</ppm:layout>