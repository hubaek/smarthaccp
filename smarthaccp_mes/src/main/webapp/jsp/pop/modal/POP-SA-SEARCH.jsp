<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 출하창고재고현황
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:layout name="pop_modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/POP-SA-SEARCH.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title" style="font-size: x-large;">
            <i class="cqc-browser"></i> 재고 현황 (제품창고)
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N" clear="N">
        	<div class="form-inline">
                 <div class="form-group">
                 	<button type="button" class="btn btn-default W150 H40" style="font-size: x-large;" data-page-btn="search"><ppm:lang id="ax.admin.sample.modal.button.search"/></button>
		        	<button type="button" class="btn btn-default W150 H40" style="font-size: x-large;" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
                 </div>
            </div>
        </ppm:page-buttons>
        <div class="H15"></div>
        <div role="page-header">
            <ppm:form name="searchView0">
            	<ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                    	<ppm:td label='창고' width="230px">
                     		<ppm:wh-code name="whCd" whType="20" emptyText="전체" emptyValue=""/>
                        </ppm:td> 
                        <ppm:td label="검사상태" width="230px">
                     		<ppm:common-code mainCd="QC_FLAG" dataPath="qcFlag"  emptyText="전체" name = "qcFlag" />
                        </ppm:td>   
                        <ppm:td label='무재고포함' width="230px">
                     		<label class="checkbox-inline"><input type="radio" name="zeroStock" data-ax-path="zeroStock" value="N">제외</label>
                     		<label class="checkbox-inline"><input type="radio" name="zeroStock" data-ax-path="zeroStock" value="Y" checked>포함</label>
                        </ppm:td> 
                    </ppm:tr>
                    <ppm:tr>               
	                    <ppm:td label='품목' width="400px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>    
                        </ppm:td>  
                        <ppm:td label='품목유형' width="230px">
	                        <ppm:common-code mainCd="ITEM_TYPE" emptyText="전체" name="itemType"/>
                        </ppm:td>
                        <ppm:td label='품목분류' width="320px">
	                        <ppm:item-group/>
                        </ppm:td>       
                    </ppm:tr> 
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
       <ppm:split-layout name="ax1" orientation="vertical">   	
            <ppm:split-panel width="55%" style="padding-right: 10px;">
	            <div class="ax-button-group" data-fit-height-aside="grid-view-01">
		           <div class="left">
		              <h5><i class="cqc-list"></i></h5>
		           </div>
	            </div>
	 			<div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 600px"></div>
	 		</ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>