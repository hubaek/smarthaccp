<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 팔피엠 CMMS
 * 1. 작성자  	: 팔피엠
 * 2. 작성일	: 2020.01.15
 * 3. Comment 	: BOM등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="page_auto_height" value="false"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/BOM010M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> BOM등록<span id = "pgmTitle"></span></h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N" clear="N">
            <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
            <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
        </ppm:page-buttons> 
        <div id="modal-content" style="height:710px;">
	       	<ppm:form name="formView01">       
       			 <ppm:tbl clazz="ax-form-tbl">         
                   	<ppm:tr>
                        <ppm:td label='회사' width="25%">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>                   
		           		<ppm:td label="사용여부" width="25%">
		            		<ppm:common-code mainCd="USE_YN" dataPath="useYn" name="useYn" id="useYn" readonly="readonly"/>
		               </ppm:td>     
                    </ppm:tr>                        
                    <ppm:tr>
                        <ppm:td label="품목코드" width="25%">
                            <input type="text" data-ax-path="itemCd" class="form-control" readonly="readonly" class="form-control"/>
                        </ppm:td>  
                        <ppm:td label="품명" width="25%">
                            <input type="text" data-ax-path="itemNm" class="form-control" readonly="readonly" class="form-control"/>
                        </ppm:td>    
                        <ppm:td label="기준수량" width="25%" required="true">
                     		<input type="text" data-ax-path="itemQty" class="form-control" style="text-align:right" data-ax5formatter="number" title="기준수량" class="form-control required" data-ax-validate="required" readonly="readonly"/>
                        </ppm:td>  
		                <ppm:td label="버전" width="25%" required="true">
		                    <input type="text" data-ax-path="revisionNo" id="revisionNo" readonly="readonly" class="form-control"/>
		                </ppm:td>			            
                    </ppm:tr>                 
                </ppm:tbl> 
	            <div class="H5"></div>      
       			<div class="ax-button-group">
                 <div class="left">
                     <h5><i class="cqc-list"></i> BOM목록</h5>
                 </div>
                 <div class="right">
               		<button type="button" class="btn btn-success" data-grid-view-01-btn="item-copy" id ="item-copy">
                   		<i class="cqc-popin"></i> 타품목 BOM 복사
               		</button>
               		<button type="button" class="btn btn-success" data-grid-view-01-btn="item-all" id ="item-all">
                   		<i class="cqc-popin"></i> 품목 적용
               		</button>
                    <button type="button" class="btn btn-default" data-grid-view-01-btn="item-remove">
                         <i class="cqc-minus"></i>
                         <ppm:lang id="ax.admin.delete"/>
                    </button>
                 </div>
                </div>   
                <div data-ax5grid="grid-view-01" style="height: 560px;"></div>
	       </ppm:form>
       </div>            
    </jsp:body>
</ppm:layout>