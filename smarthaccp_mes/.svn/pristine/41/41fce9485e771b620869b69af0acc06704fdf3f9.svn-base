<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 검사항목등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="false"/>
<ppm:layout name="base">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/QC000.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
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
                        <ppm:td label='검사항목코드' width="230px">
                        	<input type="text" name="qcCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='검사항목명' width="230px">
                        	<input type="text" name="qcNm" class="form-control" value=""/>
                        </ppm:td>        
                    </ppm:tr>
                </ppm:tbl>  
            </ppm:form>
            <div class="H5"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="50%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h3><i class="cqc-list"></i> 검사항목 목록</h3>
                    </div>
                </div>                
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
			</ppm:split-panel>
            <ppm:splitter></ppm:splitter>            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll"  id="split-panel-form">
                <ppm:form name="formView01">
                	<div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h3><i class="cqc-news"></i> 검사항목 상세</h3>	                        
	                    </div>
	                    <div class="right">
	                        <button type="button" class="btn btn-default" data-form-view-01-btn="form-clear">
	                            <i class="cqc-plus2"></i>신규 검사항목 등록
	                        </button>
	                    </div>
                	</div>
	            	<ppm:tbl clazz="ax-form-tbl" minWidth="500px">	                    
			            <ppm:tr>          
	                        <ppm:td label='회사' width="50%">
		                    	<ppm:company-code dataPath="company" />     
	                        </ppm:td>  
	                        <ppm:td label="사용여부" width="50%" required="true">
	                     		<ppm:common-code mainCd="USE_YN" defaultValue="Y" dataPath="useYn" name="useYn" />
	                        </ppm:td>
	       				</ppm:tr>                   
			            <ppm:tr>  
			                <ppm:td label="항목코드" width="50%" auto="true" required="true">
			                    <input type="text" data-ax-path="qcCd"  title="항목코드" class="form-control" data-ax-validate="required" />
			                </ppm:td>		
			                <ppm:td label="항목명" width="50%" required="true">
			                    <input type="text" data-ax-path="qcNm" title="항목명" class="form-control required" data-ax-validate="required" />
			                </ppm:td>     
			            </ppm:tr>       
			            <ppm:tr>			           
			            	<ppm:td label="검사단위" width="50%" required="true">
		             			<ppm:common-code mainCd="QC_UNIT" dataPath="qcUnit" requiredFlag="Y" title="검사단위" />
			                </ppm:td>           
			            </ppm:tr>
			            <ppm:tr>			    
	                        <ppm:td label="검사장비" width="50%" required="true">
	                     		<ppm:common-code mainCd="USE_YN" defaultValue="Y" dataPath="qcEquipYn" />
	                        </ppm:td>
	                        <ppm:td label="공정검사" width="50%" required="true">
	                     		<ppm:common-code mainCd="USE_YN" defaultValue="Y" dataPath="qcRoutYn" />
	                        </ppm:td>         
			            </ppm:tr>
			             <ppm:tr>	                    
				            	<ppm:td label="비고" width="100%">
	        						<textarea data-ax-path="remark" class="form-control" rows=7></textarea>
				                </ppm:td>    
			               </ppm:tr>     
			        </ppm:tbl> 
                    <div class="H5"></div>
			        <div class="ax-button-group" role="panel-header">
	                    <div class="left">
	                        <h3><i class="cqc-list"></i> 사용 검사그룹 목록<font size=2> (해당 검사항목을 사용하는 검사그룹)</font></h3>                  
	                    </div>
                	</div>
                	<div data-ax5grid="grid-view-02" style="height: 310px"></div>
			    </ppm:form>
            </ppm:split-panel>
		</ppm:split-layout>
    </jsp:body>
</ppm:layout>