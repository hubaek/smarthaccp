<%@ page import="com.ppm.mes.domain.init.DatabaseInitService" %>
<%@ page import="com.chequer.axboot.core.context.AppContextManager" %>
<%@ page import="com.ppm.mes.utils.SessionUtils" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%
	boolean initialized = true;
	String lastNavigatedPage = null;
	
	try{
		if (SessionUtils.isLoggedIn()) {
			if(SessionUtils.getUserSystemType().equals("MONIT")){
	       		lastNavigatedPage = "/jsp/monit/MT-MAIN01.jsp";
			}else if(SessionUtils.getUserSystemType().equals("POP")){
	       		lastNavigatedPage = "/jsp/pop/pop-main.jsp";
			}else{
		        lastNavigatedPage = "/jsp/main.jsp";
			}
		}
	}catch(Exception e){
	    lastNavigatedPage = "/jsp/main.jsp";
	}finally{
		request.setAttribute("redirect", "/api/logout");
	}
	
	if (initialized) {
	    request.setAttribute("redirect", lastNavigatedPage);
	} else {
	    request.setAttribute("redirect", "/setup");
	}    
%>

<c:if test="${redirect!=null}">
    <c:redirect url="${redirect}"/>
</c:if>
<ppm:set key="axbody_class" value="login"/>
<ppm:layout name="empty">
    <jsp:attribute name="css">
        <style>
            .ax-body.login {
                background: url(${config.background.login}) center center;
                background-color:white;
                background-size: cover;
                color: #ccc;
            }
        </style>
    </jsp:attribute>
    <jsp:attribute name="js">
        <script>
        ppmboot.requireSession('${config.sessionCookie}');
        </script>
        <script type="text/javascript" src="<c:url value='/assets/js/ppmboot/dist/good-words.js' />"></script>
    </jsp:attribute>

 <jsp:attribute name="script">
        <script type="text/javascript">
	    	// Popup window function
	    	function basicPopup(url) {
		    	popupWindow = window.open(url,'popUpWindow','height=470,width=1000,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
		    }
	    	
            var fnObj = {
                pageStart: function () {
                    $("#good_words").html(goodWords.get());
                	ppmboot.ajax({
                        type: "GET", 
                        url: "/api/v1/open/getCompany",
                        data: JSON.stringify({
                            "useYn": "Y"
                        }),
                        callback: function (res) {            	
                        	res.list.forEach(function (n) {
                                $("select#company").append("<option value='"+n.company+"'>"+n.companyNm+"</option>");
                	        });
                	     }
                    }); 
                },
                login: function () {
                	ppmboot.ajax({
                        method: "POST",
                        url: "/api/login",
                        data: JSON.stringify({
                            "company": $("#company").val(),
                            "userCd": $("#userCd").val(),
                            "userPs": $("#userPs").val(),
                            "language": "ko_KR",
                        }),
                        callback: function (res) {
                            if (res && res.error) {
                                if (res.error.message == "Unauthorized") {
                                    alert("로그인에 실패 하였습니다. 계정정보를 확인하세요");
                                }
                                else {
                                    alert(res.error.message);
                                }
                                return; 
                            }
                            else {
                                location.reload();
                            }
                        },
                        options: {
                            nomask: false, apiType: "login"
                        }
                    });
                    return false;
                }
            };
        </script>
    </jsp:attribute>
    <jsp:body>
		<ppm:flex-layout valign="middle" align="center" style="width:100%;height:100%;" >   
			<table style="width:1100px">
				<tr>
				<td align="center" >
            			<img src="${pageContext.request.contextPath}${config.logo.login}" class="img-logo" style="width:316px;height:80px;" />
            			</td>
				</tr>
				<tr>
				<td align="center" style="width:50%">
             		<img src="${pageContext.request.contextPath}${config.background.background}"  style="width:450px;height:210px;"/>
				</td>
				<td style="width:50%">
					<div class="panel">
		                <div class="panel-heading">Welcome to MES System</div>
		                <div class="panel-body">
		                    <form name="login-form" class="" method="post" action="/api/login" onsubmit="return fnObj.login();" autocomplete="off">
		                        <div class="form-group">
		                            <label><i class="cqc-new-message"></i> Company</label>		                            
		                        	<select class = "form-control" name = "company" id = "company">
		                        	</select>
		                        </div>	
		                        <div class="form-group">
		                            <label for="userCd"><i class="cqc-new-message"></i> ID</label>
		                            <ppm:input id="userCd" value="" clazz="ime-false" />
		                        </div>		  
		                        <div class="form-group">
		                            <label for="userPs"><i class="cqc-key"></i> PASSWORD</label>
		                            <ppm:input type="password" id="userPs" value="" clazz="ime-false" />
		                        </div>
		                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                        <div class="ax-padding-box" style="text-align: right;">
		                            <button style="color:white" type="submit" class="btn">&nbsp;&nbsp;<ppm:lang id="ax.admin.login"/>&nbsp;&nbsp;</button>
		                        </div>	
		                    </form>
		                </div>
		            </div>
				</td>
				</tr>
             </table>
            <div class="txt-copyrights">
                ${config.copyrights}
            </div>
            <div class="txt-good-words" id="good_words" style="display: none;"></div>
        </ppm:flex-layout>
    </jsp:body>
</ppm:layout>