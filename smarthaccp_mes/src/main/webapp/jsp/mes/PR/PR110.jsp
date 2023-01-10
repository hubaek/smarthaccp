<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 팔피엠 MES
 * 1. 작성자  		: 전준룡
 * 2. 작성일		: 2019.05.13
 * 3. Comment 	: 거래처별 구매단가등록
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
        <script type="text/javascript" src="<c:url value='assets/PR110.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>
                        <ppm:td label='회사' width="250px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                        <ppm:td label='품목분류' width="250px">
	                        <ppm:common-code mainCd="ITEM_TYPE" emptyText="전체" dataPath="itemType" name="itemType"/>
                        </ppm:td>
                        <ppm:td label='품목군' width="300px">
	                        <ppm:item-group/>
                        </ppm:td>       
                        <ppm:td label='규격' width="250px">
                        	<input type="text" name="spec" class="form-control" value=""/>
                        </ppm:td> 
                    </ppm:tr>
                   	<ppm:tr>  
                        <ppm:td label='품목코드' width="250px">
                        	<input type="text" name="itemCode" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='품명' width="250px">
                        	<input type="text" name="itemName" class="form-control" value=""/>
                        </ppm:td>
	                    <ppm:td label='거래처' width="320px">
	                        <ppm:search-modal codeName="custCode" valueName="custName"  modalType="CUST-MODAL" whereValue="20"/>
                        </ppm:td>      
                        <ppm:td label="사용유무" width="250px">
                     		<ppm:common-code mainCd="USE_YN" defaultValue ="Y" emptyText="전체" emptyValue="" dataPath="useYn" name="useYn"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>   
            <div class="H10"></div>
        </div>
            
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="50%" style="padding-right: 10px;">
                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h3><i class="cqc-list"></i>품목 목록</h3>
                    </div>
                </div>                
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
			</ppm:split-panel>
            <ppm:splitter></ppm:splitter>   
            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll"  id="split-panel-form">
                <ppm:form name="formView01">
                <div class="ax-button-group" data-fit-height-aside="grid-view-02">
                   <div class="left">
                       <h3><i class="cqc-list"></i>구매처별 단가 목록</h3>
                   </div>
	                <div class="right" id = "grid-buttons">
	                    <button type="button" class="btn btn-success" data-grid-view-02-btn="cust-all">
	                        <i class="cqc-popin"></i> 거래처 적용
	                    </button>
	                    <button type="button" class="btn btn-default" data-grid-view-02-btn="item-remove">
	                        <i class="cqc-minus"></i>
	                        <ppm:lang id="ax.admin.delete"/>
	                    </button>
	                </div>
               </div>

                <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 200px"></div>
                <!-- 
                <div class="H5"></div>
                <div class="ax-button-group">
                    <div class="left">
                        <h4><i class="cqc-list"></i>변경이력</h4>
                    </div>
                </div>

                <div data-ax5grid="grid-view-03" style="height: 300px;"></div>
                 -->
                </ppm:form>
            </ppm:split-panel>
		</ppm:split-layout>
    </jsp:body>
</ppm:layout>