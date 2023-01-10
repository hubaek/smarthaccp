<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.util.List" %>
<%@ tag import="com.ppm.mes.utils.CompanyCodeUtils" %>
<%@ tag import="com.ppm.mes.domain.cp.cp000.CompanyManagement" %>
<%@ tag import="com.ppm.mes.domain.user.user000.SessionUser" %>
<%@ tag import="com.ppm.mes.domain.user.user100.UserCompanyVO" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ attribute name="mainCd" required="false" %>
<%@ attribute name="name" required="false" %>
<%@ attribute name="clazz" required="false" %>
<%@ attribute name="id" required="false" %>     
<%@ attribute name="dataPath" required="false" %> 
<%@ attribute name="type" required="false" %>
<%@ attribute name="defaultValue" required="false"%>
<%@ attribute name="readonly" required="false" %>
<%@ attribute name="disabledFlag" required="false" %>
<%@ attribute name="multiYn" required="false" %>  
<% 
	SessionUser user = (SessionUser)request.getAttribute("loginUser");
	
	if(StringUtils.isEmpty(defaultValue)){
		defaultValue = user.getCompany();  
	}
	
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
        	
            List<UserCompanyVO> userCompanyList = null;

           	String company = user.getCompany();
            String userCd = user.getUserCd();

            
            if (StringUtils.isEmpty(multiYn)) { 
            	userCd = "";
            }
                  
            userCompanyList = CompanyCodeUtils.getUserCompany(company,userCd);
        	
            builder.append("<select class=\"form-control "+ clazz +" \"");
            
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

            for (UserCompanyVO c : userCompanyList) {
                if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(c.getCompany())) {
                    builder.append(String.format("<option value=\"%s\" selected>%s</option>", c.getCompany(), c.getCompanyNm()));
                } else {
                    builder.append(String.format("<option value=\"%s\">%s</option>", c.getCompany(), c.getCompanyNm()));
                }
            }            
            builder.append("</select>");
            break;
            
		case "checkbox":  
		    List<CompanyManagement> companyCodes = null;
        	companyCodes = CompanyCodeUtils.get("");
        	
       		for (CompanyManagement companyCode : companyCodes) {
                   if (StringUtils.isNotEmpty(defaultValue) && defaultValue.equals(companyCode.getCompany())) {
                       builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"checkbox\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\" checked> %s </label>", name, dataPath, companyCode.getCompany(), companyCode.getCompanyNm()));
                   } else {
                       builder.append(String.format("<label class=\"checkbox-inline\"><input type=\"checkbox\" name=\"%s\" data-ax-path=\"%s\" value=\"%s\"> %s </label>", name, dataPath, companyCode.getCompany(), companyCode.getCompanyNm()));
                   }
            }            
            break;
           
    }
%>
<%=builder.toString()%>