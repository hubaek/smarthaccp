<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 보건증관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="false"/>  
<ppm:layout name="base"> 
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />   
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/HEALTH000.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons> 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>      
                        <ppm:td label='사용자명' width="270px">
                            <ppm:input type="text" name="userNm" clazz="form-control" placeholder="사용자명"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H5"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="33%" style="padding-right: 10px;">
                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h3><i class="cqc-list"></i>대상자 목록</h3>
                    </div>
                    <div class="right" id = "grid-buttons">
	                    <button type="button" class="btn btn-fn1 W80" data-grid-view-01-btn="btn-reg">
							신규
	                    </button>
	                </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" scroll="scroll">
                 <div class="ax-button-group">
                     <div class="left">
                         <h3><i class="cqc-list"></i>보건증</h3>
                     </div>
                     <div class="right" id = "grid-buttons">
	                    <button type="button" class="btn btn-fn2 W80" data-grid-view-02-btn="btn-mod">
							수정
	                    </button>
	                </div>
                 </div>
                 <div data-ax5grid="grid-view-02" style="height: 650px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>