<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="com.chequer.axboot.core.utils.MessageUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless" %>
<%@ attribute name="function1Label" required="false" %>
<%@ attribute name="function2Label" required="false" %>
<%@ attribute name="function3Label" required="false" %>
<%@ attribute name="function4Label" required="false" %>
<%@ attribute name="function5Label" required="false" %>
<%@ attribute name="help" required="false" %>  
<%@ attribute name="clear" required="false" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<div data-page-buttons=""> 
    <div class="button-warp">
        
        <!-- https://chequer-io.github.io/chequer-icon/demo.html -->
    
		<%if (StringUtils.isEmpty(clear)) {%>
        <button type="button" class="btn btn-default" data-page-btn="reload" onclick="window.location.reload();"><i class="cqc-cw"></i></button>
        <%} %>
        <c:if test="${authGroupMenu.schAh eq 'Y'}">
            <button type="button" class="btn btn-info W60" data-page-btn="search"><i class="cqc-magnifier"></i> <%=MessageUtils.getMessage(request, "ax.admin.inquery")%> </button>
        </c:if>

        <c:if test="${authGroupMenu.savAh eq 'Y'}">
            <button type="button" class="btn btn-info W60" data-page-btn="save" id="saveBtn"><i class="cqc-save"></i> <%=MessageUtils.getMessage(request, "ax.admin.save")%></button>
        </c:if>
        
        <c:if test="${authGroupMenu.creAh eq 'Y'}">
            <button type="button" class="btn btn-info W60" data-page-btn="cre" id="creBtn"><%=MessageUtils.getMessage(request, "ax.admin.cre")%></button>
        </c:if>
        
        <c:if test="${authGroupMenu.modAh eq 'Y'}">
            <button type="button" class="btn btn-info W60" data-page-btn="mod" id="modBtn"><%=MessageUtils.getMessage(request, "ax.admin.mod")%></button>
        </c:if>
        
        <!-- 
        	수정자 : 윤광준
        	수정일자 : 2020-07-03
        	SAVE 버튼 다음에 삭제 버튼 오게 위치 수정
        	원복 필요시 삭제 c:if 테그를 fn5 c:if 테그 다음으로 위치시키면 됨
         -->
		<c:if test="${authGroupMenu.delAh eq 'Y'}">
            <button type="button" class="btn btn-fn1 W80" data-page-btn="del"><i class="cqc-minus"></i> <%=MessageUtils.getMessage(request, "ax.admin.delete")%></button>
        </c:if>
        <c:if test="${authGroupMenu.exlAh eq 'Y'}">
            <button type="button" class="btn btn-info W80" data-page-btn="excel"><i class="cqc-file-excel-o"></i> <%=MessageUtils.getMessage(request, "ax.admin.excel")%></button>
        </c:if>
       
        <c:if test="${authGroupMenu.fn1Ah eq 'Y'}">
            <button type="button" class="btn btn-fn1 W80" data-page-btn="fn1" id = "fn1Btn">${function1Label}</button>
        </c:if>

        <c:if test="${authGroupMenu.fn2Ah eq 'Y'}">
            <button type="button" class="btn btn-fn2 W80" data-page-btn="fn2" id = "fn2Btn">${function2Label}</button>
        </c:if>

        <c:if test="${authGroupMenu.fn3Ah eq 'Y'}">
            <button type="button" class="btn btn-fn3 W80" data-page-btn="fn3" id = "fn3Btn">${function3Label}</button>
        </c:if>

        <c:if test="${authGroupMenu.fn4Ah eq 'Y'}">
            <button type="button" class="btn btn-fn4 W80" data-page-btn="fn4" id = "fn4Btn">${function4Label}</button>
        </c:if>

        <c:if test="${authGroupMenu.fn5Ah eq 'Y'}">
            <button type="button" class="btn btn-white W80" data-page-btn="fn5" id = "fn5Btn">${function5Label}</button>
        </c:if>
        
        
        <jsp:doBody/>
    </div>
</div>