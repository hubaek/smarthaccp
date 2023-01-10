<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 권한마스터
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
        <script type="text/javascript" src="<c:url value='assets/SYS300.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>  
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr> 
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company" multiYn="Y" id="company"/> 
                        </ppm:td>     
                        <ppm:td label='권한코드' width="230px">
                            <ppm:input type="text" name="grpAuthCd" clazz="form-control"/>
                        </ppm:td>
                        <ppm:td label='권한명' width="230px">
                            <ppm:input type="text" name="grpAuthNm" clazz="form-control"/>
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
            <ppm:split-panel width="40%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>권한그룹</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" scroll="scroll">
                <div class="ax-button-group" role="panel-header">
                    <div class="left">
                        <h5><i class="cqc-news"></i>
                            	권한그룹 상세
                        </h5>
                    </div>
                    <div class="right">
                        <button type="button" class="btn btn-default" data-form-view-01-btn="form-clear">
                            <i class="cqc-erase"></i>
                            신규권한생성
                        </button>
                    </div>
                </div>
                <ppm:form name="formView01">
                	<ppm:tbl clazz="ax-form-tbl" minWidth="500px">  
                        <ppm:tr>
	                        <ppm:td label='회사' width="33%">
			                	<ppm:company-code dataPath="company" multiYn="Y" /> 
	                        </ppm:td>	   
                            <ppm:td label="사용여부" width="33%">
	                        	<ppm:common-code mainCd="USE_YN" emptyValue="" dataPath="useYn"/>
                            </ppm:td>
                        </ppm:tr>            
                        <ppm:tr>
                            <ppm:td label="권한코드" width="33%" required="true">
                                <input type="text" data-ax-path="grpAuthCd" class="form-control" readonly="readonly"/>
                            </ppm:td>
                            <ppm:td label="권한명" width="33%" required="true">
                                <input type="text" data-ax-path="grpAuthNm" title="권한명" class="form-control" data-ax-validate="required"/>
                            </ppm:td>      
	                        <ppm:td label="DEFAULT권한" width="33%" required="true">
	                     		<ppm:common-code mainCd="USE_YN" defaultValue="N" dataPath="defaultYn"/>
	                        </ppm:td>  
                        </ppm:tr>     
			             <ppm:tr>	                    
				            	<ppm:td label="비고" width="100%">
	        						<textarea data-ax-path="remark" class="form-control" rows=7></textarea>
				                </ppm:td>    
			               </ppm:tr>                        
                    </ppm:tbl>
                    <div class="H5"></div>
                    <div class="ax-button-group">
                        <div class="left">
                            <h5><i class="cqc-list"></i>권한그룹별 담당</h5>
                        </div>
                        <div class="right">
			                  <button type="button" class="btn btn-success W100" data-grid-view-02-btn="item-add">
			                        	사용자적용
			                  </button>
	                          <button type="button" class="btn btn-default W100" data-grid-view-02-btn="item-remove">
	                              <i class="cqc-minus"></i>
	                              <ppm:lang id="ax.admin.delete"/>
	                          </button>
                        </div>
                    </div>
                    <div data-ax5grid="grid-view-02" style="height: 370px;"></div>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>