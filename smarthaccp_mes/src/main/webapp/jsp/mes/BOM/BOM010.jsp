<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: BOM등록
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
        <script type="text/javascript" src="<c:url value='assets/BOM010.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="수정" function2Label="REVISION"></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">
            	<ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                        <ppm:td label='품목유형' width="230px">
	                        <ppm:common-code mainCd="ITEM_TYPE" emptyText="전체" dataPath="itemType" name="itemType" data1="P"/>
                        </ppm:td>
                        <ppm:td label='품목분류' width="320px">
	                        <ppm:item-group/>
                        </ppm:td>       
                    </ppm:tr>
                   	<ppm:tr>  
                        <ppm:td label='품목코드' width="230px">
                        	<input type="text" name="itemCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='품명' width="230px">
                        	<input type="text" name="itemNm" class="form-control" value=""/>
                        </ppm:td>
	                    <ppm:td label='거래처' width="320px">
	                        <ppm:search-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL"/>
                        </ppm:td>      
                        <ppm:td label="최종여부" width="230px">
                     		<ppm:common-code mainCd="LAST_YN" defaultValue ="Y" emptyText="전체" emptyValue="" dataPath="lastYn" name="lastYn"/>
                        </ppm:td>
                        <ppm:td label="사용여부" width="230px">
                     		<ppm:common-code mainCd="USE_YN" defaultValue ="Y" emptyText="전체" emptyValue="" dataPath="useYn" name="useYn"/>
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
                        <h5><i class="cqc-list"></i> 품목목록</h5>
                    </div>
                </div>               
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel height="40%" style="padding-top: 0px;" scroll="scroll" id="split-panel-bottom">     
                <div class="ax-button-group" data-fit-height-aside="grid-view-02">
                    <div class="left">
                        <h5><i class="cqc-uh-list-view"></i> BOM목록</h5>
                    </div>
                </div>                
                <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:split-panel style="padding-top: 0px;" scroll="scroll" id="split-panel-bottom">                  
                <div data-ax5grid="grid-view-03" data-fit-height-content="grid-view-03" style="height: 300px;" hidden="hidden"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>