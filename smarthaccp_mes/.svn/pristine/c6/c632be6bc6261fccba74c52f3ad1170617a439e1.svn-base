<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 창고등록
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
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/STD030.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
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
                        <ppm:td label="창고유형" width="230px">
                     		<ppm:common-code mainCd="WH_TYPE" emptyText="전체" emptyValue="" dataPath="whType" name="whType"/>
                        </ppm:td>       
                        <ppm:td label='창고코드' width="230px">
                        	<input type="text" name="whCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='창고명' width="230px">
                        	<input type="text" name="whNm" class="form-control" value=""/>
                        </ppm:td>         
                        <ppm:td label="사용여부" width="230px">
                     		<ppm:common-code mainCd="USE_YN" defaultValue ="Y" emptyText="전체" emptyValue="" dataPath="useYn" name="useYn"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>
            </ppm:form>
            <div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="50%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>창고 목록</h5>
                    </div>
                    <div class="right">
                        <button type="button" class="btn btn-default" data-form-view-01-btn="form-clear">
                            <i class="cqc-plus2"></i>신규 창고등록
                        </button>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>            
            <ppm:split-panel width="*" style="padding-left: 10px;padding-right: 5px;" scroll="scroll"  id="split-panel-form">
                <ppm:form name="formView01">
                	<div class="ax-button-group" role="panel-header">
                    <div class="left">
                        <h5><i class="cqc-news"></i>상세 창고 정보</h5>                        
                    </div>
                </div>
                    <ppm:tbl clazz="ax-form-tbl">     
                    	<ppm:tr>
	                        <ppm:td label='회사' width="33%">
			                	<ppm:company-code dataPath="company"/> 
	                        </ppm:td>	   
                            <ppm:td label="사용여부" width="33%">
                     			<ppm:common-code mainCd="USE_YN" dataPath="useYn"/>
                            </ppm:td>
	                        <ppm:td label='창고유형' width="33%">
		                        <ppm:common-code mainCd="WH_TYPE" dataPath="whType"/>
	                        </ppm:td>
                        </ppm:tr>   
                       <ppm:tr>
                           <ppm:td label="창고코드" width="33%" required="true">
                               <input type="text" data-ax-path="whCd" id="whCd" title="창고코드" class="form-control required" data-ax-validate="required"/>
                           </ppm:td>
                           <ppm:td label="창고명" width="33%" required="true">
                               <input type="text" data-ax-path="whNm" placeholder="창고명" title="창고명" class="form-control required" data-ax-validate="required"/>
                           </ppm:td>
	                        <ppm:td label="조회순서" width="33%">
			                    <input type="text" data-ax-path="sort" class="form-control" style="text-align:right" data-ax5formatter="number"/>
			                </ppm:td>  
                       </ppm:tr> 
                    	<ppm:tr>
                           <ppm:td label="비고" width="100%">
								<textarea data-ax-path="remark" class="form-control" rows=3></textarea>
                           </ppm:td>
                        </ppm:tr>              
                    	<ppm:tr>
			                <ppm:td label='외주거래처' width="66%">
			                    <ppm:form-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL"/>
			                </ppm:td>   
                        </ppm:tr>           
			            <ppm:tr>
			                <ppm:td label="파일첨부" width="100%">
    							<ppm:file-uploader targetType = "WH_CD" targetId = "whCd"/>
			                </ppm:td>
			            </ppm:tr>       
                    </ppm:tbl>
                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>