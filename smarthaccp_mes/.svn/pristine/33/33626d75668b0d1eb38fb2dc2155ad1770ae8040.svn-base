<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ppm.mes.utils.SessionUtils" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%
	boolean initialized = true;
	String lastNavigatedPage = null;
	try{
		if (SessionUtils.isLoggedIn()) {
			try{
		    	if(SessionUtils.getUserSystemType().equals("MONIT")){
		       		lastNavigatedPage = "/jsp/monit/MT-MAIN01.jsp";
		       	}else if(SessionUtils.getUserSystemType().equals("POP")){
		       		lastNavigatedPage = "/jsp/pop/pop-main.jsp";
				}else if(SessionUtils.getUserSystemType().equals("PDA")){
		       		lastNavigatedPage = "/jsp/pda/PDA010.jsp";
				}
			}catch(Exception e){
				request.setAttribute("redirect", "/api/logout");
			}
		}
	}catch(Exception e){
		request.setAttribute("redirect", "/api/logout");
	}finally{
	    request.setAttribute("redirect", lastNavigatedPage);
	}
	
	if (null != lastNavigatedPage) {
	    request.setAttribute("redirect", lastNavigatedPage);
	}    
%>
<c:if test="${redirect!=null}">
    <c:redirect url="${redirect}"/>
</c:if>
<ppm:set key="axbody_class" value="frame-set"/>  
<ppm:layout name="frame">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" var="LANG" />
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='/assets/js/view/frame.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
	</jsp:attribute>
    <jsp:body>
        <div id="content-frame-container" class="ax-frame-contents"></div>
    </jsp:body>
</ppm:layout>  