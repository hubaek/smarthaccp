<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 개별시스템 권한관리
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
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SYS070.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label='회사' width="230px" >
	           				<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                        <ppm:td label='ID' width="230px" >
                            <input type="text" id="userCd" name="userCd" class="form-control"/>
                        </ppm:td>
                        <ppm:td label='이름' width="230px" >
                            <input type="text" id="userNm" name="userNm" class="form-control"/>
                        </ppm:td>
                        <ppm:td label='부서명' width="230px" >
                            <input type="text" id="deptNm" name="deptNm" class="form-control"/>
                        </ppm:td>
                        <ppm:td label='접근시스템' width="230px" >
                            <ppm:common-code mainCd="SYSTEM_TYPE"  emptyText="ALL" emptyValue=""  name="systemType" defaultValue="POP"/>
                        </ppm:td>       
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H5"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="65%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i></h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll"  id="split-panel-form">
               	<div class="ax-button-group" data-fit-height-aside="grid-view-02">
                     <div class="left">
                         <h5><i class="cqc-list"></i>사용설비</h5>
                     </div>
	                <div class="right">
	                    <button type="button" class="btn btn-success" data-grid-view-02-btn="equip-all">
	                        <i class="cqc-popin"></i> 설비 적용
	                    </button>
	                    <button type="button" class="btn btn-default" data-grid-view-02-btn="item-remove">
	                        <i class="cqc-minus"></i>
	                        <ppm:lang id="ax.admin.delete"/>
	                    </button>
	                </div>
                   </div>
           		<div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 230px;"></div>         
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>