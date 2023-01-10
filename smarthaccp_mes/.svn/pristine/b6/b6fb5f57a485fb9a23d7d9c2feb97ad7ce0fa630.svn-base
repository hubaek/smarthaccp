<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 성적서 팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="pageName" value="doc popup"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>

<ppm:layout name="modal">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/QC-DOC-M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
            성적서 첨부
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="100%" style="padding-right: 10px;">
                <ppm:form name="formView01">
	                    <ppm:tbl clazz="ax-form-tbl">
		                    <ppm:tr>
				                <ppm:td label='입고코드' width="33%">
				                    <input type="text" data-ax-path="slipCd"  id="slipCd" class="form-control" readonly="readonly"/>
				                </ppm:td>	
		                        <ppm:td label='품목코드' width="33%">
				                    <input type="text" data-ax-path="itemCd"  id="itemCd" class="form-control" readonly="readonly"/>
				                </ppm:td>
				                <ppm:td label='검사구분' width="33%">
			                        <ppm:common-code mainCd="QC_TYPE" emptyText="" id="qcType" dataPath="qcType" name="qcType" readonly="readonly"/>
		                        </ppm:td>
		       				</ppm:tr>                
	                    	<ppm:tr>             
	                           <ppm:td label="파일첨부" width="100%">
    								<ppm:file-uploader targetType = "QC_DOC_CODE" targetId = "slipCd" targetId2 = "itemCd" targetId3= "qcType" fileCount = "3" errMsg=""/>
	                           </ppm:td>
	                    	</ppm:tr>   
	                   	</ppm:tbl>    
	                </ppm:form>
            </ppm:split-panel>
        </ppm:split-layout>

    </jsp:body>
</ppm:layout>