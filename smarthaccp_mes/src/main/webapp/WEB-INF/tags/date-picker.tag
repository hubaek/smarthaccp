<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.text.SimpleDateFormat" %>
<%@ tag import="java.util.Calendar" %>
<%@ tag import="java.util.List" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<!-- input box id값 한개 DATE -->
<%@ attribute name="id" required="false" %>
<%@ attribute name="dataPath" required="false" %>
<%@ attribute name="requiredFlag" required="false" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="dateType" required="false" %>
<%@ attribute name="onchange" required="false" %>

<%
StringBuilder builder = new StringBuilder();
builder.append("<div class=\"input-group\" data-ax5picker=\"date\">");


SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar cal = Calendar.getInstance();


if (StringUtils.isNotEmpty(dateType) && dateType.equals("YEAR")) {
	cal.add(Calendar.YEAR,-1); 
}else if (StringUtils.isNotEmpty(dateType) && dateType.equals("MON")) {
	cal.add(Calendar.MONTH,-1); 
}else if (StringUtils.isNotEmpty(dateType) && dateType.equals("WEEK")) {
	cal.add(Calendar.DATE,-7); 
}else if (StringUtils.isNotEmpty(dateType) && dateType.equals("TODAY")) {
	cal.add(Calendar.DATE,-0); 
}else{
	cal.add(Calendar.DATE,-7); 
}

String toDate = sdf.format(cal.getTime());

// NOW DATE 전용
if (StringUtils.isNotEmpty(id)) {
	builder.append("<input type=\"text\" class=\"form-control\" placeholder=\"yyyy-mm-dd\" ");
	if(StringUtils.isNotEmpty(requiredFlag)){
		builder.append(String.format("data-ax-validate=\"required\" title=\"%s\" class=\"form-control required\"", title));
	}
    builder.append("id=\"" + id + "\"");
    builder.append("name=\"" + id + "\"");
    builder.append("value=\"" + toDate + "\"");
    builder.append(">");  
}


if (StringUtils.isNotEmpty(dataPath)) {
	builder.append("<input type=\"text\" class=\"form-control\" placeholder=\"yyyy-mm-dd\" ");
	if(StringUtils.isNotEmpty(requiredFlag)){
		builder.append(String.format("data-ax-validate=\"required\" title=\"%s\" class=\"form-control required\"", title));
	}
	if(StringUtils.isNotEmpty(onchange)){
		builder.append(String.format(" onchange=\"%s\" ", onchange));
	}
    builder.append("data-ax-path=\"" + dataPath + "\"");
    builder.append("value=\"" + toDate + "\"");
    builder.append(" data-ax5formatter=\"date\">");  
}

builder.append("<span class=\"input-group-addon\"><i class=\"cqc-calendar\"></i></span>");
builder.append("	</div>");
%>
<%=builder.toString()%>  