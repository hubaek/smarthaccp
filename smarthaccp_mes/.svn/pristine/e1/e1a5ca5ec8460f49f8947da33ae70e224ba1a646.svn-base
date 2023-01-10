<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 수입검사불량유형등록
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
        <script type="text/javascript" src="<c:url value='assets/QC040.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
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
                         <ppm:td label='검사유형' width="320px">
                     		<label class="checkbox-inline"><input type="radio" name="routCd" data-ax-path="routCd" value="QCHE" checked>수입검사</label>
                     		<label class="checkbox-inline"><input type="radio" name="routCd" data-ax-path="routCd" value="DCHE">출하검사</label>
                        </ppm:td>       
                        <ppm:td label='불량코드' width="230px">
                        	<input type="text" name="badCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='불량명' width="230px">
                        	<input type="text" name="badNm" class="form-control" value=""/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="horizontal">
            <ppm:split-panel width="*" style="">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>검사유형별 불량항목 목록</h5>
                    </div>
                    <div class="right">
	                    <button type="button" class="btn btn-success" data-grid-view-01-btn="bad-all">
	                        <i class="cqc-popin"></i> 불량 적용
	                    </button>
                       <button type="button" class="btn btn-default" data-grid-view-01-btn="item-remove">
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