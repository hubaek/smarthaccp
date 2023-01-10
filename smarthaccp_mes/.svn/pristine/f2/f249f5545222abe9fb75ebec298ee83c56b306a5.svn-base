<%@ tag import="com.ppm.mes.utils.BasicCodeUtils" %>
<%@ tag import="com.chequer.axboot.core.utils.ContextUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag import="com.chequer.axboot.core.utils.PhaseUtils" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %> 
<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless" %>
<%
	String basicCodeJson = BasicCodeUtils.getAllByCodeMapJson();
	  
    boolean isDevelopmentMode = PhaseUtils.isDevelopmentMode();
    request.setAttribute("isDevelopmentMode", isDevelopmentMode);
     
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>${config.title}</title>
    <link rel="shortcut icon" href="<c:url value='/assets/favicon.ico'/>" type="image/x-icon"/>
    <link rel="icon" href="<c:url value='/assets/favicon.ico'/>" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="/assets/axicon/axicon.min.css" />  

    <c:forEach var="css" items="${config.extendedCss}">
        <link rel="stylesheet" type="text/css" href="<c:url value='${css}'/>"/>
    </c:forEach>
	<link rel="stylesheet" href="/assets/scroll/css/jquery.mCustomScrollbar.css">
    
	
    <!--[if lt IE 10]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <c:forEach var="css" items="${config.extendedCssforIE9}">
        <link rel="stylesheet" type="text/css" href="<c:url value='${css}'/>"/>
    </c:forEach>
    <![endif]-->

    <script type="text/javascript"> 
        var CONTEXT_PATH = "<%=ContextUtil.getContext()%>";
        
        var TOP_MENU_DATA = (function (json) {
            return json;
        })(${menuJson});
        
        var COMMON_CODE = (function (json) {
            return json;
        })(<%=basicCodeJson%>);

        var SCRIPT_SESSION = (function (json) {
            return json;
        })(${scriptSession});
        
    </script>  

    <script type="text/javascript" src="<c:url value='/assets/js/plugins.js' />"></script>
    <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
    <script type="text/javascript" src="<c:url value='/assets/js/ppmboot/dist/ppmboot.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/ppmboot.config.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/report_util.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    <jsp:invoke fragment="css"/>
    <jsp:invoke fragment="js"/>
</head>
<body class="ax-body ${axbody_class}">
<div id="ax-frame-root" class="<c:if test="${config.layout.leftSideMenu eq 'visible'}">show-aside</c:if>" data-root-container="true">
    <jsp:doBody/>
    <div class="ax-frame-header-tool">
        <div class="ax-split-col" style="height: 100%;">
            <div class="ax-split-panel text-align-left">
            </div>
            <div class="ax-split-panel text-align-right">

                <div class="ax-split-col ax-frame-user-info">                     
                    <c:if test="${loginUser.userCd eq 'system'}">
                        <!-- 개발자 툴 연결 아이콘 -->
                        <div class="ax-split-panel">
                            <a href="#ax" onclick="window.open('/jsp/SYS/SYS999.jsp');"><i class="cqc-tools"></i> <ppm:lang id="ax.devtools"/></a>
                             
                        </div> 
                        <div class="panel-split"></div>
                    </c:if>
                    <!-- HACCP바로가기
                    <div class="ax-split-panel">
                        <a href="<c:url value='/haccpLogin/loginToHACCP'/>" target="_blank"><font color="#62AAB0"><strong>HACCP바로가기</strong></font></a>
                    </div>
                    <div class="panel-split"></div>
                    <div class="ax-split-panel">
                        <a href="#ax" onclick="javascript:void(window.open('/jsp/monit/MT-CLN01.jsp', 'monit-prd','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, width=1200,height=800,scrollbars=yes'))"><font color="red">세척기모니터링</font></a>
                    </div> 
                    <div class="panel-split"></div>
                     -->
                    
                    <div class="ax-split-panel">
                        <a href="#ax" onclick="javascript:void(window.open('/jsp/pop/pop-main.jsp', 'pop-main','height=' + screen.height + ',width=' + screen.width + 'fullscreen=yes'))"><font color="#60788A">POP</font></a>
                    </div>
                    <div class="panel-split"></div>
                    
                    <!-- <div class="ax-split-panel">
                        <a href="#ax" onclick="javascript:void(window.open('/jsp/monit/MT-PRD100.jsp', 'monit-prd','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, width=1200,height=800,scrollbars=yes'))"><font color="#60788A">생산현황 모니터링</font></a>
                    </div>
                    <div class="panel-split"></div> -->
                    
                    <div class="ax-split-panel">
                        <a href="#ax" onclick="javascript:void(window.open('/jsp/monit/MT-MAIN01.jsp', 'monit-main','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, width=1200,height=800,scrollbars=yes'))"><font color="#60788A">공정모니터링</font></a>
                    </div>
                    <div class="panel-split"></div>
                    
                    <div class="ax-split-panel">
                        <a href="#ax" onclick="javascript:void(window.open('/jsp/metalDetect​/MetalDetectControl.jsp', 'monit-main','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, width=1200,height=800,scrollbars=yes'))"><font color="#60788A">금속검출기</font></a>
                    </div>
                    <div class="panel-split"></div>
                    
                    <div class="ax-split-panel">
                        <a href="#ax" onclick="javascript:void(window.open('/jsp/main.jsp', '','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, scrollbars=no'))"><font color="#60788A">새창보기</font></a>
                    </div>
                    <div class="panel-split"></div>
                    
                    <div class="ax-split-panel">
                        <a href="#ax" onclick="javascript:void(window.open('/jsp/monit/weatherInfo.jsp', 'weatherInfo','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, width=1480,height=430,scrollbars=yes'))"><font color="#60788A">날씨정보</font></a>
                    </div> 
                    <div class="panel-split"></div>
                    
                    <!-- ERP동기화 버튼 (고도화)  -->
                    <!-- <div class="ax-split-panel" id="divSyncErp">
                        <a href="#ax" onclick="ppmboot.syncErpInfo();return false"><font color="#60788A">ERP 동기화</font></a>
                    </div>
                    <div class="panel-split" id="splitSyncErp"></div> -->
                    
                    <div class="ax-split-panel">
		                <a href="#ax" onclick="open_user_info('${loginUser.userCd}');return false"><font color="#60788A"><ppm:lang id="ax.admin.login.status.message" args="${loginUser.userNm}"/></font></a>
                    </div>
                    <div class="panel-split"></div>
                    
                    <div class="ax-split-panel">
                        <a href="#ax" class="ax-frame-logout" onclick="location.href = '${pageContext.request.contextPath}/api/logout';">
                            <i class="cqc-log-out"></i>
                            <ppm:lang id="ax.admin.logout"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="ax-frame-header">
        <div class="ax-split-col" style="height: 100%;">
            <c:if test="${config.layout.leftSideMenu ne 'visible'}">
                <div class="ax-split-panel">&nbsp;</div>
            </c:if>
            <c:if test="${config.layout.leftSideMenu eq 'visible'}">
                <div class="ax-split-panel cell-aside-handle" id="ax-aside-handel">
                    <i class="cqc-menu"></i>
                </div>
            </c:if>
            <div class="ax-split-panel cell-logo">
                <a href="${pageContext.request.contextPath}/jsp/main.jsp">
                    <img src="${pageContext.request.contextPath}${config.logo.header}" height="47px" width="160px"/>
                </a>
            </div>
            <div id="ax-top-menu" class="ax-split-panel ax-split-flex">
            	<!-- 
				<div class="search-box">
					
					<div class="form-inline">
					    <div class="form-group">
					        <input type="text"  class="form-control W250" value="" placeholder="검색어를 입력하세요"/>
					        <button type="button" class="btn btn-info" >
					            <i class="cqc-magnifier">검색</i>
					        </button>  
					    </div>
					</div>  
		       		
		        </div>
		         -->
            </div>
              
                
            <!--  
            <div class="ax-split-panel cell-arm-handle">
            	<i class="cqc-mail"></i>
            	<span class="btn-warning badge" id = 'armSeq' style=" position: absolute;top: 10px;right: 50px;">0</span></a>
            </div>-->
            <!--  -->
            <div class="ax-split-panel cell-aside-handle" id="ax-fullscreen-handel">
                <i class="cqc-expand icon-closed"></i>
                <i class="cqc-collapse icon-opened"></i>
            </div>
        </div>
    </div>

    <div class="ax-frame-header-tab">
        <div id="ax-frame-header-tab-container"></div>
    </div>

    <c:if test="${config.layout.leftSideMenu eq 'visible'}">
        <div class="ax-frame-aside" id="ax-frame-aside">        
        </div>
        <script>
</script>
                            
                            <!-- /input-group -->
        <script type="text/html" data-tmpl="ax-frame-aside">
            <div id="content-1" class="ax-frame-aside-menu-holder">
                <div style="height: 10px;"></div>
                {{#items}}
                <a class="aside-menu-item aside-menu-item-label{{#hasChildren}} {{#open}}opend{{/open}}{{/hasChildren}}" data-label-index="{{@i}}">{{{name}}}</a>
                {{#hasChildren}}
                <div class="aside-menu-item aside-menu-item-tree-body {{#open}}opend{{/open}}" data-tree-body-index="{{@i}}">
                    <div class="tree-holder ztree" id="aside-menu-{{@i}}" data-tree-holder-index="{{@i}}"></div>
                </div>
                {{/hasChildren}}
                {{/items}}
            </div>
        </script>
    </c:if>  
    
    <div class="ax-frame-foot">
        <div class="ax-split-col" style="height: 100%;">  
            <div class="ax-split-panel text-align-left"> ${config.copyrights} </div>
            <div class="ax-split-panel text-align-right">
      
           		Now : <b id="account-activity-timer1"></b> (Last account activity <b id="account-activity-timer2">00</b> ago)
                
            </div>
        </div>
    </div>
</div>
    <script type="text/javascript" src="<c:url value='/assets/scroll/js/jquery.mCustomScrollbar.concat.min.js' />"></script>
	<script>	
	function open_user_info(userCd){
		ppmboot.modal3.open({  
            modalType: "USER-INFO-M",
            param: "",
            sendData: function(){
                return {
                	"userCd" : userCd
                };
            },
            callback: function (data) {
               this.close();
            }
        });
	}
	
	</script>
<jsp:invoke fragment="script"/>
</body>
</html>