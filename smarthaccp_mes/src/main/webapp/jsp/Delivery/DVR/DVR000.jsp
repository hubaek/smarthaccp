<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 코주부MES
 * 1. 작성자  		: 김재민
 * 2. 작성일		: 2020.06.24
 * 3. Comment 	: 원료육 입고 검사대장
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
        <script type="text/javascript" src="<c:url value='assets/DVR000.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons> 
        <div role="page-header">
        <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr>
                         <ppm:td label='운송사' width="230px">
                     		<ppm:common-code mainCd="DVR_CD"  emptyText="--------선택--------" name = "dvrCd" />
                        </ppm:td>   
                        <ppm:td label="운송장번호" width="400px">
                        	<input type="text" name="dvrNum" class="form-control" placeholder="운송장번호"/>
                        </ppm:td>
                        <ppm:td label="" width="0px">
                        	<input type="text" style="display: none;" name="dvrNum2" class="form-control" placeholder="운송장번호2"/>
                        </ppm:td> 
                    </ppm:tr>                   	
                </ppm:tbl>
            </ppm:form>            
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="horizontal">
            <ppm:split-panel height="20%" style="padding-bottom: 10px;" id = "header-split-panel">
                <!-- 목록 -->                
                <div class="ax-button-group" data-fit-height-aside="grid-view-02">                	
                    <div class="left">
                        <h2><i class="cqc-list"></i>결과</h2>
                    </div>
                </div>
                <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 200px;"></div>
            </ppm:split-panel> 
            <ppm:split-panel height="60%" style="padding-top: 0px;" scroll="scroll" id="split-panel-bottom">
                <!-- 목록 -->                
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">                	
                    <div class="left">
                        <h2><i class="cqc-list"></i>배송추척</h2>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 400px;"></div>
            </ppm:split-panel>                
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>
