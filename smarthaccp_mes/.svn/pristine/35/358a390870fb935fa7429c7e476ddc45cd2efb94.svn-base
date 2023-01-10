<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.util.List" %>
<%@ tag import="com.ppm.mes.utils.BasicCodeUtils" %>
<%@ tag import="com.ppm.mes.domain.eq.eq000.EquipMasterVO" %>
<%@ tag import="com.ppm.mes.domain.user.user000.SessionUser" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ attribute name="routCd" required="false" %>
<%@ attribute name="name" required="false" %>
<%@ attribute name="clazz" required="false" %>
<%@ attribute name="id" required="false" %>
<%@ attribute name="dataPath" required="false" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="defaultValue" required="false"%>


<!-- 특정 value만 조회 -->
<%@ attribute name="includeValue" required="false" %>
<!-- 전체선택 가능 -->
<%@ attribute name="emptyValue" required="false" %>
<%@ attribute name="emptyText" required="false" %>
<!-- disabled -->
<%@ attribute name="disabledFlag" required="false" %>  
<!-- 제외코드 -->
<%@ attribute name="exceptValue" required="false" %>
<%

	SessionUser user = (SessionUser)request.getAttribute("loginUser");

    if (StringUtils.isEmpty(type)) {
        type = "select";
    }

	if (!StringUtils.isEmpty(disabledFlag)) {
		disabledFlag = "disabled";
	}else{
		disabledFlag = "";
	}

    StringBuilder builder = new StringBuilder();
    List<EquipMasterVO> commonCodes = BasicCodeUtils.getEquipCode();

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

            //if (StringUtils.isEmpty(defaultValue) && StringUtils.isNotEmpty(emptyText)) {
            if (StringUtils.isNotEmpty(emptyText)) {
                builder.append(String.format("<option value=\"%s\">%s</option>", emptyValue, emptyText));
            }

            for (EquipMasterVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getEquipCd())) {
                    builder.append(String.format("<option value=\"%s\" selected>%s</option>", commonCode.getEquipCd(), commonCode.getEquipNm()));
                } else {
                    builder.append(String.format("<option value=\"%s\">%s</option>", commonCode.getEquipCd(), commonCode.getEquipNm()));
                }
            }

            //builder.append(String.format("<option  style=\"color:red\" value=\"%s\">%s</option>", "기초코드 추가", "기초코드 추가"));
            
            
            builder.append("</select>");
            break;

        case "checkbox":
            for (EquipMasterVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getEquipCd())) {
                    builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"checkbox\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" checked> %s </label>", name, dataPath, commonCode.getEquipCd(), commonCode.getEquipNm()));
                } else {
                    builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"checkbox\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\"> %s </label>", name, dataPath, commonCode.getEquipCd(), commonCode.getEquipNm()));
                }
            }
            break;

        case "radio":
            for (EquipMasterVO commonCode : commonCodes) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(commonCode.getEquipCd())) {
                    builder.append(String.format(" <input type=\"radio\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" checked> %s &nbsp;", name, dataPath, commonCode.getEquipCd(), commonCode.getEquipNm()));
                } else {
                    builder.append(String.format(" <input type=\"radio\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" > %s &nbsp;", name, dataPath, commonCode.getEquipCd(), commonCode.getEquipNm()));
                }
            }
            break;
    }
    

    
%>

<%=builder.toString()%>