<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.util.List" %>
<%@ tag import="java.util.Calendar" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>

<%@ attribute name="name" required="false" %>
<%@ attribute name="clazz" required="false" %>
<%@ attribute name="id" required="false" %>    
<%@ attribute name="dataPath" required="false" %>
<%@ attribute name="defaultValue" required="false"%>


<%@ attribute name="readonly" required="false" %>
<%@ attribute name="disabledFlag" required="false" %>
<!-- 전체선택 가능 -->
<%@ attribute name="emptyValue" required="false" %> 
<%@ attribute name="emptyText" required="false" %>

<!-- 제외코드 -->
<%    

	if (!StringUtils.isEmpty(disabledFlag) || !StringUtils.isEmpty(readonly)) {
		disabledFlag = "disabled";
	}else{
		disabledFlag = "";
	}



	int month = Calendar.getInstance().get(Calendar.MONTH) + 1;


	StringBuilder builder = new StringBuilder();
	builder.append("<select class=\" form-control "+ clazz +" \"");
    
    if (StringUtils.isEmpty(emptyValue)) {
        emptyValue = "";
    }

    if (StringUtils.isNotEmpty(id)) {
        builder.append("id=\"" + id + "\"");
    }

    if (StringUtils.isNotEmpty(name)) {
        builder.append("name=\"" + name + "\"");
    }

    if (StringUtils.isNotEmpty(dataPath)) {    
        builder.append("data-ax-path=\"" + dataPath + "\" name=\"" + dataPath + "\"");
    }

    builder.append(disabledFlag+">");

    if (StringUtils.isNotEmpty(emptyText)) {
        builder.append(String.format("<option value=\"%s\">%s</option>", emptyValue, emptyText));
    }
    
    
    for (int i = 1 ; i <= 12 ; i ++){
    	if(month == i){
            builder.append(String.format("<option value=\"%s\" selected>%s</option>", String.format("%02d", i) ,String.format("%02d", i)));
    	}else{
            builder.append(String.format("<option value=\"%s\">%s</option>", String.format("%02d", i) ,String.format("%02d", i)));
    	}
    }
    
    builder.append("</select>");
%>
<%=builder.toString()%>