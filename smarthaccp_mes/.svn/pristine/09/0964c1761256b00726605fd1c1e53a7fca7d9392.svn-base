<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 라우팅등록
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
        <script type="text/javascript" src="<c:url value='assets/RT000.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons> 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>                    	
                        <ppm:td label='라우팅코드' width="230px">
                            <ppm:input type="text" name="routingCd" clazz="form-control"/>
                        </ppm:td>	
                        <ppm:td label='라우팅명' width="230px">
                            <ppm:input type="text" name="routingNm" clazz="form-control"/>
                        </ppm:td>
                        <ppm:td label='품목' width="320px">
	                        <ppm:search-modal codeName="itemCd" valueName="itemNm"  modalType="ITEM-MODAL"/>    
                        </ppm:td>
                        <ppm:td label="사용여부" width="230px">
                     		<ppm:common-code mainCd="USE_YN" emptyText="전체" emptyValue="" dataPath="useYn" name="useYn"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="35%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>라우팅 목록</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" scroll="scroll">
                <div class="ax-button-group" role="panel-header">
                    <div class="left">
                        <h5><i class="cqc-news"></i>라우팅 상세</h5>
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
	                        <ppm:td label='회사' width="250px">
			                	<ppm:company-code dataPath="company"/> 
	                        </ppm:td>	   
                            <ppm:td label="라우팅코드" width="250px">
                                <input type="text" data-ax-path=routingCd title="라우팅코드" class="form-control" data-ax-validate="required"/>
                            </ppm:td>
                            <ppm:td label="라우팅명" width="250px">
                                <input type="text" data-ax-path="routingNm" title="라우팅명" class="form-control" data-ax-validate="required"/>
                            </ppm:td>   
                            <ppm:td label="사용여부" width="250px">
	                        	<ppm:common-code mainCd="USE_YN" emptyValue="" dataPath="useYn" name="useYn" id="useYn"/>
                            </ppm:td>
                        </ppm:tr>                         
                    </ppm:tbl>
                    <div class="H5"></div>
                    <div class="ax-button-group">
                        <div class="left">
                        	<h5><i class="cqc-news"></i>공정절차</h5>
                        </div>
                        <div class="right">
		                    <button type="button" class="btn btn-success" data-grid-view-02-btn="rout-all">
		                        <i class="cqc-popin"></i> 공정 적용
		                    </button>
                            <button type="button" class="btn btn-default" data-grid-view-02-btn="item-remove">
                                <i class="cqc-minus"></i>
                                <ppm:lang id="ax.admin.delete"/>
                            </button>
                        </div>
                    </div>
                    <div data-ax5grid="grid-view-02" style="height: 220px;"></div>
                    <div class="H5"></div>
                    <div class="ax-button-group">
                        <div class="left">
                        	<h5><i class="cqc-news"></i>품목 배정</h5>
                        </div>
                        <div class="right">
		                    <button type="button" class="btn btn-success" data-grid-view-03-btn="item-all-m">
		                        <i class="cqc-popin"></i> 품목 적용 멀티
		                    </button>
		                    <button type="button" class="btn btn-success" data-grid-view-03-btn="item-all">
		                        <i class="cqc-popin"></i> 품목 적용
		                    </button>
                            <button type="button" class="btn btn-default" data-grid-view-03-btn="item-remove">
                                <i class="cqc-minus"></i>
                                <ppm:lang id="ax.admin.delete"/>
                            </button>
                        </div>
                    </div>
                    <div data-ax5grid="grid-view-03" style="height: 330px;"></div>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>