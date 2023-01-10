<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.util.List" %>
<%@ tag import="com.ppm.mes.utils.BasicCodeUtils" %>
<%@ tag import="com.ppm.mes.domain.user.user000.SessionUser" %>
<%@ tag import="com.ppm.mes.domain.cp.cp100.TbCmmsCp100" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ attribute name="name" required="false" %>
<%@ attribute name="clazz" required="false" %>
<%@ attribute name="id" required="false" %>    
<%@ attribute name="dataPath" required="false" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="defaultValue" required="false"%>
<%@ attribute name="disabledFlag" required="false" %>

<%@ attribute name="requiredFlag" required="false" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="readonly" required="false" %> 

<!-- 전체선택 가능 -->
<%@ attribute name="emptyValue" required="false" %>
<%@ attribute name="emptyText" required="false" %>
<%

	SessionUser user = (SessionUser)request.getAttribute("loginUser");
	
    if (StringUtils.isEmpty(type)) {
        type = "select";
    }
    
	if (!StringUtils.isEmpty(disabledFlag) || !StringUtils.isEmpty(readonly)) {
		disabledFlag = "disabled";
	}else{
		disabledFlag = "";
	}	
	 
	StringBuilder builder = new StringBuilder();

	
    switch (type) { 
        case "select":        	
        	
            List<TbCmmsCp100> deptList = null;
            
            deptList = BasicCodeUtils.getDeptList("*");

        	if(StringUtils.isNotEmpty(requiredFlag)){
                builder.append(String.format("<select data-ax-validate=\"required\" title=\"%s\" class=\"form-control required "+ clazz +" \"", title));
        	}else{
                builder.append("<select class=\"form-control "+ clazz +" \"");
        	}

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
                builder.append("data-ax-path=\"" + dataPath + "\" name=\"" + dataPath + "\" id=\"" + dataPath + "\"");
            }

            builder.append(disabledFlag+">");

            if (StringUtils.isNotEmpty(emptyText)) {
                builder.append(String.format("<option value=\"%s\">%s</option>", emptyValue, emptyText));
            }
            
            for (TbCmmsCp100 c : deptList) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(c.getDeptCd())) {
                    builder.append(String.format("<option value=\"%s\" selected>%s</option>", c.getDeptCd(),c.getDeptNm()));
                } else {
                    builder.append(String.format("<option value=\"%s\">%s</option>", c.getDeptCd(), c.getDeptNm()));
                }
            }            
            builder.append("</select>");
            break;
            
           
    }
%>
<%=builder.toString()%>