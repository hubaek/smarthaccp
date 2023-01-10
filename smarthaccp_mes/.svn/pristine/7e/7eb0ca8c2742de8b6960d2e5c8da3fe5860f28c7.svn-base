<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 작업표준서등록
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
        <script type="text/javascript" src="<c:url value='assets/PRD030.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
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
	                        <ppm:common-code mainCd="ITEM_TYPE" emptyText="전체" dataPath="itemType" name="itemType" data1="P"/>
                        </ppm:td>
                        <ppm:td label='품목분류' width="320px">
	                        <ppm:item-group/>
                        </ppm:td>
                    </ppm:tr>
                   	<ppm:tr>  
                        <ppm:td label='공정' width="230px">
                     		<ppm:rout-code name="routCd" emptyText="전체" emptyValue="" />
                        </ppm:td>            
                        <ppm:td label='품목코드' width="230px">
                        	<input type="text" name="itemCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='품명' width="230px">
                        	<input type="text" name="itemNm" class="form-control" value=""/>
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
                        <h5><i class="cqc-list"></i>공정별 품목 목록</h5>
                    </div>
                </div>                
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
			</ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll"  id="split-panel-form">
                	<div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h5><i class="cqc-news"></i>작업표준서 등록</h5>                        
	                    </div>
	                </div>
            		<ppm:form name="formView01">
	                    <ppm:tbl clazz="ax-form-tbl">     
	                    	<ppm:tr>           
	                           <ppm:td label="품목코드" width="33%">
	                               <input type="text" data-ax-path="itemCd" id = "itemCd" class="form-control" readonly="readonly" class="form-control"/>
	                           </ppm:td>
	                           <ppm:td label="품목명" width="33%">
	                               <input type="text" data-ax-path="itemNm" class="form-control" readonly="readonly" class="form-control"/>
	                           </ppm:td>
	                           <ppm:td label="공정" width="33%">
	                     			<ppm:rout-code dataPath="routCd" name="routCd" id = "routCd" disabledFlag = "Y"/>
	                           </ppm:td>
	                    	</ppm:tr>               
							<ppm:tr>	              
								<ppm:td label="규격" width="33%">
									<input type="text" data-ax-path="spec" class="form-control" readonly="readonly"/>
								</ppm:td>          
							</ppm:tr>      
	                    	<ppm:tr>             
	                           <ppm:td label="파일첨부" width="100%">
    								<ppm:file-uploader-thumbnail targetType = "WO_DOC_CODE" targetId = "routCd" targetId2 = "itemCd" fileCount = "3" errMsg="공정을 선택하세요."/>
	                           </ppm:td>
	                    	</ppm:tr>                  
	                   	</ppm:tbl>    
	                </ppm:form>
            </ppm:split-panel>
		</ppm:split-layout>
    </jsp:body>
</ppm:layout>