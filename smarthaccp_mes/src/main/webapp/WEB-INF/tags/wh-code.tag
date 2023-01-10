<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.util.List" %>
<%@ tag import="com.ppm.mes.utils.BasicCodeUtils" %>
<%@ tag import="com.ppm.mes.domain.wh.wh000.WarehouseMasterVO" %>
<%@ tag import="com.ppm.mes.domain.user.user000.SessionUser" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>

<%@ attribute name="whCd" required="false" %>
<%@ attribute name="whType" required="false" %>
<%@ attribute name="name" required="false" %>
<%@ attribute name="clazz" required="false" %>
<%@ attribute name="id" required="false" %>
<%@ attribute name="dataPath" required="false" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="defaultValue" required="false"%>

<!-- 전체선택 가능 -->
<%@ attribute name="emptyValue" required="false" %>
<%@ attribute name="emptyText" required="false" %>  
<!-- disabled -->
<%@ attribute name="disabledFlag" required="false" %>
<!-- 업무별 조회 가능 창고 -->
<%@ attribute name="readonly" required="false" %>

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

    List<WarehouseMasterVO> commonCodes = BasicCodeUtils.getWhCode(whType);
 
    switch (type) {
        case "select":
            builder.append("<select class=\"form-control "+ clazz +" \"");
            
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

            if (StringUtils.isNotEmpty(emptyText) && commonCodes.size() > 1) {
                builder.append(String.format("<option value=\"%s\">%s</option>", emptyValue, emptyText));
            }

            for (WarehouseMasterVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getWhCd())) {
                    builder.append(String.format("<option value=\"%s\" selected>%s</option>", commonCode.getWhCd(), commonCode.getWhNm()));
                } else {
                    builder.append(String.format("<option value=\"%s\">%s</option>", commonCode.getWhCd(), commonCode.getWhNm()));
                }
            }

            builder.append("</select>");
            break;

        case "checkbox":
            for (WarehouseMasterVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getWhCd())) {
                    builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"checkbox\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" checked> %s </label>", name, dataPath, commonCode.getWhCd(), commonCode.getWhNm()));
                } else {
                    builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"checkbox\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\"> %s </label>", name, dataPath, commonCode.getWhCd(), commonCode.getWhNm()));
                }
            }
            break;

        case "radio":
            for (WarehouseMasterVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getWhCd())) {
                    builder.append(String.format(" <input type=\"radio\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" checked> %s &nbsp;", name, dataPath, commonCode.getWhCd(), commonCode.getWhNm()));
                } else {
                    builder.append(String.format(" <input type=\"radio\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" > %s &nbsp;", name, dataPath, commonCode.getWhCd(), commonCode.getWhNm()));
                }
            }
            break;
    }
%>

<%=builder.toString()%>