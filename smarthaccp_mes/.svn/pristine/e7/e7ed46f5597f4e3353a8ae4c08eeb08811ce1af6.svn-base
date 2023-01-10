<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 권한별메뉴
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="false"/>  
<ppm:layout name="base"> 
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />   
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SYS320.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
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
                        <ppm:td label='메뉴그룹' width="250px">
                            <ppm:common-code mainCd="MENU_GROUP" name="menuGrpCd" id="menuGrpCd"/>
                        </ppm:td>     
                        <ppm:td label='권한코드' width="230px">
                            <ppm:input type="text" name="grpAuthCd" clazz="form-control"/>
                        </ppm:td>
                        <ppm:td label='권한명' width="230px">
                            <ppm:input type="text" name="grpAuthNm" clazz="form-control"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H5"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="40%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">  
                    <div class="left">
                        <h5><i class="cqc-list"></i>권한그룹</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" scroll="scroll">
                <div class="ax-button-group" data-fit-height-aside="grid-view-02">
                    <div class="left"> 
                        <h5><i class="cqc-list"></i>메뉴별 권한</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 370px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>