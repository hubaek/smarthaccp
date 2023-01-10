<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<ppm:set key="pageName" value="item search"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>

<ppm:layout name="modal">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/QC-GROUP-M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
            검사그룹적용
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-info W80" data-page-btn="search"><ppm:lang id="ax.admin.sample.modal.button.search"/></button>
            <button type="button" class="btn btn-info W80" data-page-btn="choice">검사그룹적용</button>
            <button type="button" class="btn btn-default W80" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label='회사' width="250px">  
		                	<ppm:company-code dataPath="company"/>     
                        </ppm:td>               	
                         <ppm:td label='검사유형' width="250px">
                     		<ppm:common-code mainCd="QC_TYPE" name = "qcType" emptyText="전체"/>
                        </ppm:td>       
                        <ppm:td label='그룹코드' width="250px">
                        	<input type="text" name="qcGroupCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='그룹명' width="250px">
                        	<input type="text" name="qcGroupNm" class="form-control" value=""/>
                        </ppm:td>  
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="40%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>검사그룹</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>   
            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-02">
                	<div class="left">
                     	<h5><i class="cqc-list"></i>검사항목</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>

    </jsp:body>
</ppm:layout>