<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일	: 2019.05.13
 * 3. Comment 	: 생산일보
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
        <script type="text/javascript" src="<c:url value='assets/PRD112.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">       
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>                         	
	                    <ppm:td label='회사' width="230px">   
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                         <ppm:td label='작업일자' width="320px">
                         	<ppm:period-picker fromId="fromStartDt" toId="toStartDt" />
                        </ppm:td> 
                        <ppm:td label='공정' width="250px">
                     		<ppm:rout-code name="routCd" emptyText="전체" emptyValue=""/>
                        </ppm:td>       
                    </ppm:tr> 
                    <ppm:tr>     
                        <ppm:td label='설비' width="320px">
	                        <ppm:search-modal codeName="equipCd" valueName="equipNm"  modalType="EQUIP-MODAL"/>    
                        </ppm:td>       
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>    
                        </ppm:td>
                    	<ppm:td label='지시번호' width="230px">
                        	<input type="text" name="orderNo" class="form-control" value=""/>
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
	              <h5><i class="cqc-list"></i></h5>
	           </div>
            </div>
 			<div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 600px"></div>
 		</ppm:split-panel>
 		<ppm:splitter></ppm:splitter>
 		<ppm:split-panel height="40%" style="padding-top: 0px;" scroll="scroll" id="split-panel-bottom">
 			<div class="H10"></div>
			<ppm:tab-layout name="ax2" data_fit_height_content="layout-view-01" style="height:100%;">
	    		<ppm:tab-panel label="생산실적" scroll="scroll">   
                    <div data-ax5grid="grid-view-06" style="height: 200px;"></div>
	    		</ppm:tab-panel>    		
	    		<ppm:tab-panel label="자재출고" scroll="scroll">   
                    <div data-ax5grid="grid-view-02" style="height: 200px;"></div>
	    		</ppm:tab-panel>    		
	    		<ppm:tab-panel label="불량" scroll="scroll">   
                   <div data-ax5grid="grid-view-03" style="height: 200px;"></div>
				</ppm:tab-panel>
	    		<ppm:tab-panel label="작업자" scroll="scroll">   
                    <div data-ax5grid="grid-view-05" style="height: 200px;"></div>
				</ppm:tab-panel>
	    		<ppm:tab-panel label="비가동" scroll="scroll">
                    <div data-ax5grid="grid-view-04" style="height: 200px;"></div>
				</ppm:tab-panel>
			</ppm:tab-layout>
 		
 		</ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>