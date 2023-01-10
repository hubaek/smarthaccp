<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 공정등록
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
        <script type="text/javascript" src="<c:url value='assets/RT100.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="신규" function2Label="수정"></ppm:page-buttons>
        <div role="page-header"> 
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr>
                        <ppm:td label='회사' width="230px">  
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>	      
                        <ppm:td label='공정분류' width="230px">
	                        <ppm:common-code mainCd="ROUT_TYPE" dataPath="routType" name="routType" emptyText="전체" emptyValue="" />
                        </ppm:td>         
                        <ppm:td label="사용여부" width="230px">
                     		<ppm:common-code mainCd="USE_YN" defaultValue ="Y" emptyText="전체" emptyValue="" dataPath="useYn" name="useYn"/>
                        </ppm:td>
                        <ppm:td label='공정코드' width="230px">
                        	<input type="text" name="routCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='공정명' width="230px">
                        	<input type="text" name="routNm" class="form-control" value=""/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="horizontal">        	
	        <ppm:split-panel height="60%" style="padding-bottom: 10px;"  id = "header-split-panel">
	            <div class="ax-button-group" data-fit-height-aside="grid-view-01">
		           <div class="left">
		              <h5><i class="cqc-list"></i>공정 목록</h5>
		           </div>
	            </div>
	 			<div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 600px"></div>
	 		</ppm:split-panel>
	 		<ppm:splitter></ppm:splitter>
	 		<ppm:split-panel height="40%" style="padding-top: 0px;" scroll="scroll" id="split-panel-bottom">
	 			<div class="H10"></div>
				<ppm:tab-layout name="ax2" data_fit_height_content="layout-view-01" style="height:100%;">
		    		<ppm:tab-panel label="공정별설비" scroll="scroll">   
	                    <div data-ax5grid="grid-view-02" style="height: 200px;"></div>
		    		</ppm:tab-panel>    		
		    		<ppm:tab-panel label="공정별비가동" scroll="scroll">   
	                    <div data-ax5grid="grid-view-03" style="height: 200px;"></div>
		    		</ppm:tab-panel>    		
		    		<ppm:tab-panel label="공정별불량유형" scroll="scroll">   
	                   <div data-ax5grid="grid-view-04" style="height: 200px;"></div>
					</ppm:tab-panel>
		    		<ppm:tab-panel label="공정별가용인원" scroll="scroll">   
	                    <div data-ax5grid="grid-view-05" style="height: 200px;"></div>
					</ppm:tab-panel>
				</ppm:tab-layout>
	 		</ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>