<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 공통코드관리_담당자별
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
        <script type="text/javascript" src="<c:url value='assets/SYS005.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons> 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label="공통코드유형" width="230px">
                     		<ppm:common-code mainCd="CD_TYPE" emptyText="ALL" emptyValue="" name="cdType"/>
                        </ppm:td>   
                        <ppm:td label="사용모듈코드" width="230px">
                     		<ppm:common-code mainCd="PG_MODULE_CD" emptyText="ALL" emptyValue="" name="pgModuleCd"/>
                        </ppm:td>      
                        <ppm:td label="대분류코드" width="230px">
                            <ppm:input type="text" name="mainCd" clazz="form-control"/>
                        </ppm:td>
                        <ppm:td label="대분류명" width="230px">
                            <ppm:input type="text" name="mainNm" clazz="form-control"/>
                        </ppm:td>
                        <ppm:td label="사용여부" width="230px">
                     		<ppm:common-code mainCd="USE_YN" emptyText="ALL" emptyValue="" name="useYn"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H5"></div>
        </div> 
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="45%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>대분류</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" scroll="scroll">
                <div class="ax-button-group" role="panel-header">
                    <div class="left">
                        <h5><i class="cqc-news"></i>
                            	대분류 상세
                        </h5>
                    </div>
                    <div class="right">
                    </div>
                </div>
                <ppm:form name="formView01">
                	<ppm:tbl clazz="ax-form-tbl" minWidth="500px">  
                        <ppm:tr>
                            <ppm:td label="대분류코드" width="50%">
                                <input type="text" data-ax-path=mainCd title="대분류코드" class="form-control" data-ax-validate="required" readonly="readonly"/>
                            </ppm:td>
                            <ppm:td label="대분류명" width="50%">
                                <input type="text" data-ax-path="mainNm" title="대분류명" class="form-control" data-ax-validate="required" readonly="readonly"/>
                            </ppm:td>  
                        </ppm:tr>        
                        <ppm:tr>       
                            <ppm:td label="사용모듈코드" width="50%">
	                        	<ppm:common-code mainCd="PG_MODULE_CD" emptyValue="" dataPath="pgModuleCd"  readonly="readonly"/>
                            </ppm:td>
                            <ppm:td label="공통코드유형" width="50%">
	                        	<ppm:common-code mainCd="CD_TYPE" emptyValue="" dataPath="cdType"  readonly="readonly"/>
                            </ppm:td>
                        </ppm:tr>        
                        <ppm:tr> 
	                      	<ppm:td label="담당자" width="50%">
			                	<div class="form-inline">
				                    <div class="form-group">
				                        <input type="text" data-ax-path="userCd" class="form-control W90" readonly="readonly"  placeholder="사용자ID" class="form-control"/>
				                        <input type="text" data-ax-path="userNm" class="form-control W110" readonly="readonly" placeholder="사용자명"/>
				                    </div>
			               		</div>
			              	</ppm:td>
                            <ppm:td label="사용여부" width="50%">
	                        	<ppm:common-code mainCd="USE_YN" emptyValue="" dataPath="useYn"  readonly="readonly"/>
                            </ppm:td>
                        </ppm:tr>                            
                    </ppm:tbl>
                    <div class="H5"></div>
                    <div class="ax-button-group">
                        <div class="left">
                            <h5><i class="cqc-list"></i>소분류</h5>
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
                    <div id="gridView02" data-ax5grid="grid-view-02" style="height: 530px;"></div>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>