<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 출하창고입고등록
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
        <script type="text/javascript" src="<c:url value='assets/SA110.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
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
                         <ppm:td label='품목유형' width="230px">
                     		<ppm:common-code mainCd="ITEM_TYPE" data1="P"  emptyText="ALL" name = "itemType" />
                        </ppm:td>   
                        <ppm:td label='품목분류' width="320px">
	                        <ppm:item-group/>
                        </ppm:td>    
                    </ppm:tr> 
                   	<ppm:tr>  
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>
                        </ppm:td>   
                        <ppm:td label='공정' width="230px">
                     		<ppm:rout-code dataPath="routCd" name="routCd" emptyText="전체" emptyValue=""/>
                        </ppm:td>
                        <ppm:td label='보낸창고' width="230px">
                     		<ppm:wh-code name="whCd" whType="30" emptyText="전체" emptyValue=""/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H5"></div>
        </div>             
        <ppm:split-layout name="ax1" orientation="horizontal">
            <ppm:split-panel width="*" style="">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>출하창고 입고가능 품목</h5>
                    </div>
                    <div class="right">
	                	<div class="form-inline">
	                       <div class="form-group">
	                       		입고창고 :
                 				<ppm:wh-code name="toWarehouse" id = "toWarehouse" whType="20" />
            					<button type="button" class="btn btn-modal-cancel W80" data-grid-view-01-btn="select-whCd">일괄적용</button>
	                       </div>
	                	</div>
                    </div>
                </div>                
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
			</ppm:split-panel>
		</ppm:split-layout>
    </jsp:body>
</ppm:layout>