<%@ tag import="com.chequer.axboot.core.utils.ContextUtil" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:forEach var="css" items="${config.extendedCss}">
        <link rel="stylesheet" type="text/css" href="<c:url value='${css}'/>"/></c:forEach>
    <!--[if lt IE 10]><c:forEach var="css" items="${config.extendedCssforIE9}">
    <link rel="stylesheet" type="text/css" href="<c:url value='${css}'/>"/></c:forEach>
    <![endif]-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script type="text/javascript">
        var CONTEXT_PATH = "<%=ContextUtil.getContext()%>";
        var SCRIPT_SESSION = (function(json){return json;})(${scriptSession});
    </script>
    <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
    <script type="text/javascript" src="<c:url value='/assets/js/ppm_common.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/plugins.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/ppmboot/dist/ppmboot.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/ppmboot.config.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    <%-- <script type="text/javascript" src="<c:url value='/assets/js/report_util.js'><c:param name="v" value="${now}"></c:param></c:url>"></script> --%>
    <jsp:invoke fragment="css"/>
    <jsp:invoke fragment="js"/>
</head>
<body class="ax-body ${axbody_class}" data-page-auto-height="${page_auto_height}">
<div id="ax-base-root" data-root-container="true">
    <div class="ax-base-title" role="page-title">
        <jsp:invoke var="headerContent" fragment="header"/>
        <c:if test="${empty headerContent}">
            <h1 class="title">
            	<i class="cqc-browser"></i> 
            	${pageName}
            </h1>
            <p class="desc">${pageRemark}</p>
        </c:if>
        <c:if test="${!empty headerContent}">
            ${headerContent}
        </c:if>
    </div>
    <div class="ax-base-content">
        <jsp:doBody/>
    </div>
</div>
<script>	
</script>
<jsp:invoke fragment="script"/>
</body>
</html>