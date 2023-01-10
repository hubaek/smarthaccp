<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 메뉴별권한
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="system-config-menu-version" value="1.0.0"/>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:layout name="base">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SYS310.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">  
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr>    
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company" multiYn="Y" id="company"/> 
                        </ppm:td>
                        <ppm:td label='메뉴그룹' width="230px">
                            <ppm:common-code mainCd="MENU_GROUP" name="menuGrpCd" id="menuGrpCd"/>
                        </ppm:td>
                    </ppm:tr> 
                </ppm:tbl>  
            </ppm:form>
            <div class="H5"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="30%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="tree-view-01">
                    <div class="left">
                        <h5> <i class="cqc-list"></i> <ppm:lang id="ax.admin.menu.title"/> </h5>
                    </div>
                </div>
                <div data-z-tree="tree-view-01" data-fit-height-content="tree-view-01" style="height: 300px;" class="ztree"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" id="split-panel-form">
                	<div class="ax-button-group" data-fit-height-aside="grid-view-01">
                        <div class="left">
                            <h5><i class="cqc-list"></i>권한그룹설정</h5>
                        </div>
                        <div class="right">
                        </div>
                    </div>
                 <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;">
                 </div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>