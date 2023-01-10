<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 공정공통코드 관리
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
        <script type="text/javascript" src="<c:url value='assets/STD040.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons> 
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label='대분류코드/명' width="270px">
                            <ppm:input type="text" name="mainCd" clazz="form-control" placeholder="대분류코드/명"/>
                        </ppm:td>
                        <ppm:td label="사용유무" width="270px">
                     		<ppm:common-code mainCd="USE_YN" emptyText="ALL" emptyValue="" dataPath="useYn" name="useYn"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="40%" style="padding-right: 10px;">
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
                            <ppm:td label="대분류코드" width="33%" required="true">
                                <input type="text" data-ax-path=mainCd class="form-control" readonly="readonly" data-ax-validate="required" title="대분류코드"/>
                            </ppm:td>
                            <ppm:td label="대분류명" width="33%">
                                <input type="text" data-ax-path="mainNm" class="form-control" readonly="readonly"/>
                            </ppm:td>       
                            <ppm:td label="사용여부" width="33%">
	                        	<ppm:common-code mainCd="USE_YN" dataPath="useYn" readonly="readonly"/>
                            </ppm:td>                 
                        </ppm:tr>       
			            <ppm:tr> 
			               <ppm:td label="비고" width="100%">
								<textarea data-ax-path="remark" class="form-control" rows=3 readonly="readonly"></textarea>
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
                    <div data-ax5grid="grid-view-02" style="height: 570px;"></div>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>