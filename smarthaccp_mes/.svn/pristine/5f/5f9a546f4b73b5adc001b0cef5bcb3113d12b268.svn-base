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
        <script type="text/javascript" src="<c:url value='assets/ITEM-COPY-M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
            BOM 복사
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-info W50" data-page-btn="search"><ppm:lang id="ax.admin.sample.modal.button.search"/></button>
            <button type="button" class="btn btn-info W50" data-page-btn="choice">복사</button>
            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="700px" id="searchTb">
                    <ppm:tr>
                        <ppm:td label='회사' width="250px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>       
                        <ppm:td label='품목유형' width="250px">
	                        <ppm:common-code mainCd="ITEM_TYPE" emptyText="전체" dataPath="itemType" name="itemType" data1="P"/>
                        </ppm:td>
                   		<ppm:td label='품목코드' width="250px"   >
                   			<input type="text" id="itemCd" name="itemCd" class="form-control" value=""/>
                   			<input type="hidden" name = "activeFlag" value = "A"/>
                        </ppm:td>
                        <ppm:td label='품목명' width="250px"   >
                   			<input type="text" id="itemNm" name="itemNm" class="form-control" value=""/>
                        </ppm:td>     
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="40%" style="padding-right: 10px;">
                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h2><i class="cqc-list"></i>품목정보</h2>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>   
            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;">
                <div class="ax-button-group">
                	<div class="left">
                     	<h4><i class="cqc-list"></i>BOM</h4>
                    </div>
                </div>
                <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>

    </jsp:body>
</ppm:layout>