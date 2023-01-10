<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산실적수정
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
        <script type="text/javascript" src="<c:url value='assets/PRD150.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="취소"></ppm:page-buttons>
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
                    	<ppm:td label='지시번호' width="230px">
                        	<input type="text" name="orderNo" class="form-control" value=""/>
                        </ppm:td> 
                    </ppm:tr> 
                    <ppm:tr>        
                        <ppm:td label='설비' width="320px">
	                        <ppm:search-modal codeName="equipCd" valueName="equipNm"  modalType="EQUIP-MODAL"/>    
                        </ppm:td>               
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>                             
                        </ppm:td>        
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
        </div>
        <ppm:split-layout name="ax1" orientation="horizontal">
            <ppm:split-panel height="45%" style="padding-bottom: 10px;"  id = "header-split-panel">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>생산실적 목록</h5>
                    </div>
                </div>               
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel height="55%" style="padding-top: 0px;" id="split-panel-bottom">     
            	
	        	<div class="H10"></div>
				<ppm:tab-layout name="ax2" data_fit_height_content="layout-view-01" style="height:100%;">
		    		<ppm:tab-panel label="생산실적">   
		    			<div class="ax-button-group">   
		                        <div class="right">
		                        <button type="button" class="btn btn-success W80" data-grid-view-06-btn="add-prd">
		                            	실적추가
								</button>
		                        <button type="button" class="btn btn-default W80" data-grid-view-06-btn="del-prd">
		                        	<i class="cqc-minus"></i>
			                            	삭제
								</button>
		                        </div>
		                    </div>
		                    <div data-ax5grid="grid-view-06" style="height: 280px;"></div>
		    		</ppm:tab-panel>    		
		    		<ppm:tab-panel label="자재출고">   
		    			<div class="ax-button-group">   
	                        <div class="right">
			                    <button type="button" class="btn btn-success W80" data-grid-view-02-btn="out-stock">
			                         	자재적용
			                    </button>
	                        </div>
	                    </div>
	                    <div data-ax5grid="grid-view-02" style="height: 280px;"></div>
		    		</ppm:tab-panel>    		
		    		<ppm:tab-panel label="불량">   
		              <div class="ax-button-group">   
	                        <div class="right">
			                    <button type="button" class="btn btn-success W80" data-grid-view-03-btn="bad-all">
			                        	 불량적용
			                    </button>
	                        </div>
	                   </div>
	                   <div data-ax5grid="grid-view-03" style="height: 280px;"></div>
					</ppm:tab-panel>
		    		<ppm:tab-panel label="작업자">   
						<div class="ax-button-group">                   
							<div class="right">
								<button type="button" class="btn btn-success W80" data-grid-view-05-btn="workman-all">
				                       	 작업자적용
				                </button>
		                        <button type="button" class="btn btn-default W80" data-grid-view-05-btn="item-remove">
		                        	<i class="cqc-minus"></i>
		                        	삭제
								</button>
			                    <button type="button" class="btn btn-success W80" data-grid-view-05-btn="item-save">
			                         	저장
			                    </button>
		                        </div>
	                    </div>
	                    <div data-ax5grid="grid-view-05" style="height: 280px;"></div>
					</ppm:tab-panel>
		    		<%-- <ppm:tab-panel label="비가동" scroll="scroll">
						<div class="ax-button-group">                   
							<div class="right">
								<button type="button" class="btn btn-success W80" data-grid-view-04-btn="nwrk-all">
				                       	 비가동적용
				                </button>
		                        <button type="button" class="btn btn-default W80" data-grid-view-04-btn="item-remove">
		                        	<i class="cqc-minus"></i>
		                            	<ppm:lang id="ax.admin.delete"/>
								</button>
			                    <button type="button" class="btn btn-success W80" data-grid-view-04-btn="item-save">
			                         	저장
			                    </button>
							</div>
	                    </div>
	                    <div data-ax5grid="grid-view-04" style="height: 380px;"></div>
					</ppm:tab-panel> --%>
				</ppm:tab-layout>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>