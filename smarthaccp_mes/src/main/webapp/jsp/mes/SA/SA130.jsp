<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 제품출하등록_수주
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
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SA130.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
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
                         <ppm:td label='납기일자' width="320px">
                         	<ppm:period-picker fromId="fromDate" toId="toDate"  dateType="MON_T"/>
                        </ppm:td> 
                    	<ppm:td label='수주번호' width="230px">
                        	<input type="text" name="slipCd" class="form-control" value=""/>
                        </ppm:td>     
                        <ppm:td label="발주번호" width="230px">
                        	<input type="text" name="orderNo" class="form-control" value=""/>
                        </ppm:td> 
                    </ppm:tr> 
                    <ppm:tr>    
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL" whereValue="P"/>    
                        </ppm:td>
	                    <ppm:td label='거래처' width="320px">
	                        <ppm:search-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL" whereValue="10"/>
                        </ppm:td>   
                         <ppm:td label='출하잔량' width="320px">
                         	<label class="checkbox-inline"><input type="radio" name="remainYn2" value="" >전체</label>
                     		<label class="checkbox-inline"><input type="radio" name="remainYn2" value="N" >없음</label>
                     		<label class="checkbox-inline"><input type="radio" name="remainYn2" value="Y" checked>있음</label>
                        </ppm:td>       
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="45%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>수주 목록</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll"  id="split-panel-form">
                <ppm:form name="formView01">
                	<div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h5><i class="cqc-news"></i>출하 상세</h5>                        
	                    </div>
	                </div>
                    <ppm:tbl clazz="ax-form-tbl">                    
                       <input type="hidden" data-ax-path=company/>
                    	<ppm:tr>	           
	                        <ppm:td label='수주번호' width="33%">
	                        	<input type="text" data-ax-path="slipCd" class="form-control" value="" readonly="readonly"/>
	                        </ppm:td>          
	                        <ppm:td label='품목명' width="33%">
	                        	<input type="text" data-ax-path="itemNm" class="form-control" value="" readonly="readonly"/>
	                        </ppm:td>      
	                        <ppm:td label='규격' width="33%">
	                        	<input type="text" data-ax-path="spec" class="form-control" value="" readonly="readonly"/>
	                        </ppm:td>     
	                    </ppm:tr>      
                    	<ppm:tr>	                      
                           <ppm:td label="출하일" width="33%" required="true">
                				<ppm:date-picker dataPath="outDt" requiredFlag="true" title="출하일"/>
                           </ppm:td>           
			                <ppm:td label="거래처" width="33%">
			                    <div class="form-inline">
			                     <div class="form-group">
			                         <input type="text" data-ax-path="custCd" class="form-control W60" value="" readonly="readonly" title="거래처" class="form-control required" data-ax-validate="required"/>
			                         <input type="text" data-ax-path="custNm" class="form-control W100" value="" readonly="readonly"/>
			                     </div>
			                	</div>
			                </ppm:td>             
	                    </ppm:tr>     
                    	<ppm:tr>	     
			                  <ppm:td label="수주수량" width="33%">
				              		<input type="text" data-ax-path="itemQty" class="form-control" style="text-align:right" data-ax5formatter="number" readonly="readonly"/>
			                  </ppm:td>    
			                  <ppm:td label="출하수량" width="33%">
				              		<input type="text" data-ax-path="useQty2" class="form-control" style="text-align:right" data-ax5formatter="number" readonly="readonly"/>
			                  </ppm:td>    
			                  <ppm:td label="출하잔량" width="33%">
				              		<input type="text" data-ax-path="remainQty2" class="form-control" style="text-align:right" data-ax5formatter="number" readonly="readonly"/>
			                  </ppm:td>    
                    	</ppm:tr>  
                    </ppm:tbl>
            		<div class="H10"></div>
                	<div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h5><i class="cqc-news"></i> 제품재고</h5>                        
	                    </div>
		                <div class="right" id = "grid-buttons">
		                    <button type="button" class="btn btn-primary W80" data-grid-view-02-btn="add-out-list">
								제품출하
		                    </button>
		                </div>
	                </div>
                	<div data-ax5grid="grid-view-02" style="height: 300px;"></div>
            		<div class="H10"></div>
                	<div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h5><i class="cqc-news"></i> 제품출하 목록</h5>                        
	                    </div>
		                <div class="right" id = "grid-buttons">
		                    <button type="button" class="btn btn-primary W80" data-grid-view-03-btn="cancel-out-list">
								출하취소
		                    </button>
		                </div>
	                </div>
                	<div data-ax5grid="grid-view-03" style="height: 300px;"></div>
               </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>