<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<ppm:set key="pageName" value="item search"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>

<ppm:layout name="modal">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/HELP-M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
            도움말
        </h1>
    </jsp:attribute>
    <jsp:body>

        <ppm:page-buttons help="N">
            <button type="button" class="btn btn-default W50" data-page-btn="close"><ppm:lang id="ax.admin.sample.modal.button.close"/></button>
        </ppm:page-buttons>
 
        <ppm:form name="formView01">
       <div data-fit-height-aside="form-view-01">
       	<ppm:tbl clazz="ax-form-tbl" minWidth="500px">
            <ppm:tr>
                <ppm:td label="제목" width="100%">                         
                    <input type="hidden" data-ax-path="progCd" id="progCd"/>              
               		<textarea data-ax-path="title" class="form-control" readonly="readonly" rows=5></textarea>
                </ppm:td>
            </ppm:tr>
            <ppm:tr>
                <ppm:td label="내용" width="100%">                              
               		<textarea data-ax-path="remark" class="form-control" readonly="readonly" rows=20></textarea>
                </ppm:td>
            </ppm:tr>
            <ppm:tr>
                <ppm:td label="첨부" width="100%">                              
					<ppm:file-uploader-view targetType = "PGM_HELP" targetId = "progCd"/>
                </ppm:td>
            </ppm:tr>
        </ppm:tbl>	   				
        </div>
        </ppm:form>

    </jsp:body>
</ppm:layout>