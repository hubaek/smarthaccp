<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 서버모니터링
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:layout name="base">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SYS055.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="신규" function2Label="수정" function3Label="그룹복사" function4Label="스케쥴생성"  ></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>
                          <ppm:td label='회사' width="230px">
		                		<ppm:company-code dataPath="company" name ="company"/>
                          </ppm:td>  
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H5"></div>
        </div>            
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="*" style="padding-right: 10px;">
                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i></h5>
                    </div>
                	<div class="right">
                       <button type="button" class="btn btn-default W50" data-grid-view-01-btn="item-add">
                           <i class="cqc-plus"></i>
                           <ppm:lang id="ax.admin.add"/>
                       </button>
                       <button type="button" class="btn btn-default W50" data-grid-view-01-btn="item-remove">
                           <i class="cqc-minus"></i>
                           <ppm:lang id="ax.admin.delete"/>
                       </button>
                    </div>
                </div>                
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
			</ppm:split-panel>
		</ppm:split-layout>
    </jsp:body>
</ppm:layout>