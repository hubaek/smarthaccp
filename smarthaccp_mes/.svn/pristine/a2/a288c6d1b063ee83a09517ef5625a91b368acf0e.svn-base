<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.util.List" %>
<%@ tag import="com.ppm.mes.utils.BasicCodeUtils" %>
<%@ tag import="com.ppm.mes.domain.cd.cd100.BasicCodeDetailVO" %>
<%@ tag import="com.ppm.mes.domain.user.user000.SessionUser" %>

<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ attribute name="mainCd" required="true" %>
<%@ attribute name="name" required="false" %>
<%@ attribute name="clazz" required="false" %>
<%@ attribute name="id" required="false" %>
<%@ attribute name="dataPath" required="false" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="defaultValue" required="false"%>

<%@ attribute name="data1" required="false"%>
<%@ attribute name="data2" required="false"%>
<%@ attribute name="data3" required="false"%>

<!-- 특정 value만 조회 -->
<%@ attribute name="includeValue" required="false" %>
<!-- 전체선택 가능 -->
<%@ attribute name="emptyValue" required="false" %>
<%@ attribute name="emptyText" required="false" %>
<!-- disabled -->
<%@ attribute name="disabledFlag" required="false" %>
<!-- 제외코드 -->
<%@ attribute name="exceptValue" required="false" %>


<%@ attribute name="requiredFlag" required="false" %>
<%@ attribute name="readonly" required="false" %>
<%@ attribute name="title" required="false" %>
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
	
	//관리자
	if(user.getCompany().equals("*")){
		includeValue="";
		exceptValue="";
	}

    StringBuilder builder = new StringBuilder();

    List<BasicCodeDetailVO> commonCodes = BasicCodeUtils.get(user.getCompany(),mainCd,includeValue,exceptValue,data1,data2,data3);

    switch (type) {
        case "select":
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
                builder.append("data-ax-path=\"" + dataPath + "\"");
            }

            builder.append(disabledFlag+">");

            if (StringUtils.isNotEmpty(emptyText)) {
                builder.append(String.format("<option value=\"%s\">%s</option>", emptyValue, emptyText));
            }

            for (BasicCodeDetailVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getSubCd())) {
                    builder.append(String.format("<option value=\"%s\" selected>%s</option>", commonCode.getSubCd(), commonCode.getSubNm()));
                } else {
                    builder.append(String.format("<option value=\"%s\">%s</option>", commonCode.getSubCd(), commonCode.getSubNm()));
                }
            }
            
            builder.append("</select>");
            break;

        case "checkbox":
            for (BasicCodeDetailVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getSubCd())) {
                    builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"checkbox\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" checked> %s </label>", name, dataPath, commonCode.getSubCd(), commonCode.getSubNm()));
                } else {
                    builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"checkbox\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\"> %s </label>", name, dataPath, commonCode.getSubCd(), commonCode.getSubNm()));
                }
            }
            break;

        case "radio":
            for (BasicCodeDetailVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getSubCd())) {
                    builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"radio\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" checked> %s </label>", name, dataPath, commonCode.getSubCd(), commonCode.getSubNm()));
                } else {
                	builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"radio\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\"> %s </label>", name, dataPath, commonCode.getSubCd(), commonCode.getSubNm()));
                }
            }
            break;
    }
%>

<%=builder.toString()%>