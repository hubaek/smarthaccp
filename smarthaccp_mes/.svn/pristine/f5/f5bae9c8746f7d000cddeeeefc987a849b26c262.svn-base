<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 창고별재고현황
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
        <script type="text/javascript" src="<c:url value='assets/ST052.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
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
                    	<ppm:td label='창고' width="230px">
                     		<ppm:wh-code name="whCd" emptyText="전체" emptyValue=""/>
                        </ppm:td> 
                        <ppm:td label="검사상태" width="230px">
                     		<ppm:common-code mainCd="QC_FLAG" dataPath="qcFlag"  emptyText="전체" name = "qcFlag" />
                        </ppm:td>   
                        <ppm:td label='무재고포함' width="230px">
                     		<label class="checkbox-inline"><input type="radio" name="zeroStock" data-ax-path="zeroStock" value="N">제외</label>
                     		<label class="checkbox-inline"><input type="radio" name="zeroStock" data-ax-path="zeroStock" value="Y" checked>포함</label>
                        </ppm:td> 
                        <%--
                        <ppm:td label='재공포함' width="230px">
                     		<label class="checkbox-inline"><input type="radio" name="wipYn" data-ax-path="wipYn" value="N">제외</label>
                     		<label class="checkbox-inline"><input type="radio" name="wipYn" data-ax-path="wipYn" value="" checked>포함</label>
                        </ppm:td>   
                         --%>
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
	 		<ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll">
				<ppm:tab-layout name="ax2" >
		    		<ppm:tab-panel label="LOT별" scroll="scroll">   
			            <div class="ax-button-group" data-fit-height-aside="grid-view-02">
			            </div>
	                    <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 250px;"></div>
		    		</ppm:tab-panel>    		
		    		<ppm:tab-panel label="바코드별" scroll="scroll">   
			            <div class="ax-button-group" data-fit-height-aside="grid-view-03">
			            </div>
	                    <div data-ax5grid="grid-view-03" data-fit-height-content="grid-view-03" style="height: 250px;"></div>
		    		</ppm:tab-panel>       		
		    		<ppm:tab-panel label="이력" scroll="scroll">   
			            <div class="ax-button-group" data-fit-height-aside="grid-view-04">
			            </div>
	                    <div data-ax5grid="grid-view-04" data-fit-height-content="grid-view-04" style="height: 250px;"></div>
		    		</ppm:tab-panel>  		
				</ppm:tab-layout>
	 		</ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>