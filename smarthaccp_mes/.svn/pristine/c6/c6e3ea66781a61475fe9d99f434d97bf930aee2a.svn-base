<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: POP> 원재료출고
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="원재료출고등록"/>
<ppm:set key="page_auto_height" value="true"/>       
<ppm:layout name="pop-modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/POP-PC090M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons>
           	<button type="button" class="btn btn-default W50 H20" style="font-size: 15px;" data-page-btn="search"><ppm:lang id="ax.admin.sample.modal.button.search"/></button>
        	<button type="button" class="btn btn-default W50 H20" style="font-size: 15px;" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons> 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>
                    	<ppm:td label='창고' width="230px">
                     		<ppm:wh-code name="whCd" whType="10" emptyText="전체" emptyValue=""/>
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
	                    <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>    
                        </ppm:td>  
                        <ppm:td label='품목유형' width="230px">
	                        <ppm:common-code mainCd="ITEM_TYPE" emptyText="전체" name="itemType"/>
                        </ppm:td>
                        <ppm:td label='품목분류' width="320px">
	                        <ppm:item-group/>
                        </ppm:td>
                        <ppm:td label='QR' width="230px">
	                        <input type="text" id="QRCode" name="QRCode" class="form-control" style="display:inline-block;" disabled="disabled";>
                        </ppm:td>
                        <!--    
                        <button type="button" class="btn btn-primary W80" data-grid-view-02-btn="QR-SEARCH" style="margin:7px;">
							QR 조회
		                </button>
		                -->
                    </ppm:tr> 
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="48%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>자재창고 재고 목록</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll"  id="split-panel-form">
                <ppm:form name="formView01">
                	<div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h5><i class="cqc-news"></i>자재 상세</h5>                        
	                    </div>
	                </div>
                    <ppm:tbl clazz="ax-form-tbl">                    
                    	<ppm:tr>	           
	                        <ppm:td label='품목명' width="50%">
	                        	<input type="text" data-ax-path="itemNm" class="form-control" value="" readonly="readonly"/>
	                        </ppm:td>      
	                        <ppm:td label='규격' width="50%">
	                        	<input type="text" data-ax-path="spec" class="form-control" value="" readonly="readonly"/>
	                        </ppm:td>     
	                    </ppm:tr> 
	                    <ppm:tr>
	                    	<ppm:td label="출고유형" width="50%">
	                     		<label class="checkbox-inline"><input type="radio" name="etcYn" data-ax-path="etcYn" value="N">거래처출고</label>
	                     		<label class="checkbox-inline"><input type="radio" name="etcYn" data-ax-path="etcYn" value="Y" checked>예외출고</label>
	                        </ppm:td> 
	                        <ppm:td label="출고일" width="50%" required="true">
                				<ppm:date-picker dataPath="outDt" requiredFlag="true" title="출고일"/>
                            </ppm:td>  
	                    </ppm:tr>    
                    	<ppm:tr>	     
			                <ppm:td label='거래처' width="50%" required="true">
			                    <ppm:form-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL"/>
			                </ppm:td>    
			                <ppm:td label='담당자' width="50%" required="true">
			                    <ppm:form-modal codeName="userCd" valueName="userNm"  modalType="USER-MODAL"/>
			                </ppm:td>  
	                    </ppm:tr>      
                    </ppm:tbl>
            		<div class="H10"></div>
                	<div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h5><i class="cqc-news"></i>자재창고재고</h5>                        
	                    </div>
		                <div class="right" id = "grid-buttons">
		                    <button type="button" class="btn btn-primary W80" data-grid-view-02-btn="add-out-list">
								자재출고
		                    </button>
		                </div>
	                </div>
                	<div data-ax5grid="grid-view-02" style="height: 300px;"></div>
            		<div class="H10"></div>
                	<div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h5><i class="cqc-news"></i>출고 목록</h5>                        
	                    </div>
		                <div class="right" id = "grid-buttons">
		                    <button type="button" class="btn btn-primary W80" data-grid-view-03-btn="cancel-out-list">
		                       	 출고취소
		                    </button>
		                </div>
	                </div>
                	<div data-ax5grid="grid-view-03" style="height: 300px;"></div>
               </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>

<script>
$("p").html("원재료 출고");
$("p").css("fontSize", 20);
</script>