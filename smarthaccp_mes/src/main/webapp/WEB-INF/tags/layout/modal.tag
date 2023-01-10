<%@ tag import="com.chequer.axboot.core.utils.ContextUtil" %>
<%@ tag import="com.ppm.mes.utils.BasicCodeUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless" %>
<%

	String basicCodeJson = BasicCodeUtils.getAllByCodeMapJson();
    
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>${pageName}</title>
    <link rel="shortcut icon" href="<c:url value='/assets/favicon.ico'/>" type="image/x-icon"/>
    <link rel="icon" href="<c:url value='/assets/favicon.ico'/>" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="/assets/axicon/axicon.min.css" />  
    <c:forEach var="css" items="${config.extendedCss}">
        <link rel="stylesheet" type="text/css" href="<c:url value='${css}'/>"/></c:forEach>
    <!--[if lt IE 10]><c:forEach var="css" items="${config.extendedCssforIE9}">
    <link rel="stylesheet" type="text/css" href="<c:url value='${css}'/>"/></c:forEach>
    <![endif]-->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/assets/scroll/css/jquery.mCustomScrollbar.css">
    <script type="text/javascript">
        var CONTEXT_PATH = "<%=ContextUtil.getContext()%>";
        var SCRIPT_SESSION = (function(json){return json;})(${scriptSession});
        var COMMON_CODE = (function (json) {
            return json;
        })(<%=basicCodeJson%>);
        
        <!--
        var message="오른쪽 마우스는 사용할 수 없습니다.";

        function clickIE4(){
        	if (event.button==2){
        		//alert(message);
        		return false;
        	}
        }

        function clickNS4(e){
        	if (document.layers||document.getElementById&&!document.all){
        	if (e.which==2||e.which==3){
        			//alert(message);
        			return false;
        		}
        	}
        }

        if (document.layers){
        	document.captureEvents(Event.MOUSEDOWN);
        	document.onmousedown=clickNS4;
        }
        else if (document.all&&!document.getElementById){
        	document.onmousedown=clickIE4;
        }

        //document.oncontextmenu=new Function("alert(message);return false")
        document.oncontextmenu=new Function("return false")

        // --> 
    </script>

    <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
    <script type="text/javascript" src="<c:url value='/assets/js/ppm_common.js' />"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/plugins.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/ppmboot/dist/ppmboot.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/ppmboot.config.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    <jsp:invoke fragment="css"/>
    <jsp:invoke fragment="js"/>
</head>
<body class="ax-body ${axbody_class}" data-page-auto-height="${page_auto_height}">
<div id="ax-modal-base-root" data-root-container="true">
    <jsp:invoke var="headerContent" fragment="header"/>
    <c:if test="${!empty headerContent}">
        <div class="ax-base-title" role="page-title"> ${headerContent} </div>
    </c:if>
    <div class="ax-base-content">
        <jsp:doBody/>
    </div>
</div>
    <script type="text/javascript" src="<c:url value='/assets/scroll/js/jquery.mCustomScrollbar.concat.min.js' />"></script>
	<script>	
	$("#modal-content").mCustomScrollbar({
		theme:"rounded-dots-dark",
	    scrollInertia:0
	});
	</script>
<jsp:invoke fragment="script"/>
</body>
</html>