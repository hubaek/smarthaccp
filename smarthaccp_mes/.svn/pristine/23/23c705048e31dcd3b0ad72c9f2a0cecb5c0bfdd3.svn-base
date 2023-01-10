<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: SMART HACCP
 * 1. 작성자  	: 김회재
 * 2. 작성일		: 2020.06.01
 * 3. Comment 	: HACCP 공통코드 관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="false"/>  
<ppm:layout name="base"> 
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />   
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/HACCP010.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="상신" function2Label="검토완료" function3Label="검토반려" function4Label="승인" function5Label="반려"></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label='회사' width="250px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>                    	
                        <ppm:td label='검색' width="270px">
                            <ppm:input type="text" name="templateInfo" clazz="form-control" placeholder="점검일지 코드/명"/>
                        </ppm:td>
                        <ppm:td label="사용유무" width="270px">
                     		<ppm:common-code mainCd="USE_YN" emptyText="전체" emptyValue="" dataPath="useYn" name="useYn"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="25%" style="padding-right: 10px;">
                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h2><i class="cqc-list"></i>점검일지 유형</h2>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" scroll="scroll">
                <!-- 폼 -->
                <div class="ax-button-group" role="panel-header">
                    <div class="left">
                        <h2><i class="cqc-news"></i>
                            	점검일지 상세
                        </h2>
                    </div>
                    <div class="right">
                        <button type="button" class="btn btn-default" data-form-view-01-btn="form-clear">
                            <i class="cqc-erase"></i>
                            <ppm:lang id="ax.admin.clear"/>
                        </button>
                    </div>                    
                </div>
                <ppm:form name="formView01">
                	<ppm:tbl clazz="ax-form-tbl" minWidth="500px">  
                        <ppm:tr>
	                        <ppm:td label='회사' width="33%">
			                	<ppm:company-code dataPath="company"/> 
	                        </ppm:td>	   
                            <ppm:td label="사용유무" width="33%">
	                        	<ppm:common-code mainCd="USE_YN" emptyValue="" dataPath="useYn" name="useYn" id="useYn"/>
                            </ppm:td>
                        </ppm:tr>            
                        <ppm:tr>
                            <ppm:td label="점검일지코드" width="33%">
                                <input type="text" data-ax-path=templateId title="점검일지코드" class="form-control" data-ax-validate="required"/>
                            </ppm:td>
                            
                            <ppm:td label="점검일지명" width="33%">
                                <input type="text" data-ax-path="templateNm" title="점검일지명" class="form-control" data-ax-validate="required"/>
                            </ppm:td>      
                            
                        </ppm:tr>                        
                    </ppm:tbl>
                    <div class="H5"></div>
                    <div class="ax-button-group">
                        <div class="left">
                            <h3><i class="cqc-list"></i>점검항목</h3>
                        </div>
                        <div class="right">
                            <button type="button" class="btn btn-default" data-grid-view-02-btn="item-add">
                                <i class="cqc-plus"></i>
                                <ppm:lang id="ax.admin.add"/>
                            </button>
                            <button type="button" class="btn btn-default" data-grid-view-02-btn="item-remove">
                                <i class="cqc-minus"></i>
                                <ppm:lang id="ax.admin.delete"/>
                            </button>
                        </div>
                    </div>
                    <div data-ax5grid="grid-view-02" style="height: 555px;"></div>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>