<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless" %>
<%@ attribute name="name" %>
<%@ attribute name="id" %>
<%@ attribute name="method" %>
<%@ attribute name="style" %>
<%@ attribute name="onsubmit" %>  
<%@ attribute name="valign" %>
<%
    if(StringUtils.isEmpty(id)){
        id = "";
    }
    if(StringUtils.isEmpty(onsubmit)){
        onsubmit = "return false";
    }  
    if(StringUtils.isEmpty(method)){
        method = "post";
    }
    
    String onkeydownStr = "";
    if(name.equals("searchView0")){
    	onkeydownStr = "onkeydown='javascript:if(event.keyCode==13){return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);}'";
    }
    
    
%>
<form name="${name}" id="${name}" method="<%=method%>" onsubmit="<%=onsubmit%>" style="${style}" <%=onkeydownStr%>>
    <jsp:doBody/>
</form>

