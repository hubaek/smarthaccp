<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2021.01.25
 * 3. Comment 	: 운송창 출력
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
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/WB000.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="신규" function2Label="수정" function3Label="복사"></ppm:page-buttons>
        <div role="page-header">
        	<ppm:form name="searchView0">       
				<ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>                         	
	                    <ppm:td label='회사' width="230px">
	                    	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                         <ppm:td label='수주일' width="320px">
                         	<ppm:period-picker fromId="fromDate" toId="toDate" dateType="MON"/>
                        </ppm:td> 
                    	<ppm:td label='수주번호' width="230px">
                        	<input type="text" name="slipCd" class="form-control" value=""/>
                        </ppm:td>   
                        <ppm:td label='수주구분' width="230px">
	               			<ppm:common-code mainCd="SA_ORDER_TYPE" name="saOrderType" emptyValue="" emptyText="전체"/>
                        </ppm:td> 
                        <ppm:td label="발주번호" width="230px">
                        	<input type="text" name="orderNo" class="form-control" value=""/>
                        </ppm:td> 
                    </ppm:tr> 
                    <ppm:tr>      
	                    <ppm:td label='거래처' width="320px">
	                        <ppm:search-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL" whereValue="10"/>
                        </ppm:td>   
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL" whereValue="P"/>    
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
        </div>
        <ppm:split-layout name="ax1" orientation="horizontal">
            <ppm:split-panel height="45%" style="padding-bottom: 10px;"  id = "header-split-panel">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>수주</h5>
                    </div>
                    <div class="right" id = "grid-buttons">
                    <button type="button" class="btn btn-default" data-grid-view-03-btn="dexcel-data-down">
                       <!--  <i class="axi axi-file-excel-o"></i> -->
                        <ppm:lang id="ax.admin.exceldata.download"/>
                   	</button>
                </div>
                </div>                            
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
            </ppm:split-panel>
            
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel height="55%" style="padding-top: 0px;" scroll="scroll" id="split-panel-bottom">     
                <div class="ax-button-group" data-fit-height-aside="grid-view-02">
                    <div class="left">
                        <h5><i class="cqc-uh-list-view"></i>수주 상세</h5>
                    </div>
                </div>                
                <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 300px;"></div>
                <div data-ax5grid="grid-view-03" data-fit-height-content="grid-view-03" style="display:none;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
       
</div>
    </jsp:body>
</ppm:layout>