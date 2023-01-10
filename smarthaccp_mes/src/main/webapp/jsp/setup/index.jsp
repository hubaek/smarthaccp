<%@ page import="com.ppm.mes.utils.SessionUtils" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%
    String lastNavigatedPage = null;

    if (SessionUtils.isLoggedIn()) {
        lastNavigatedPage = "/jsp/main.jsp";
    }

    request.setAttribute("redirect", lastNavigatedPage);
%>
<c:if test="${redirect!=null}">
    <c:redirect url="${redirect}"/>
</c:if>
<ppm:set key="axbody_class" value="setup"/>
<ppm:layout name="empty">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="js">
        <script type="text/javascript" src="<c:url value='/assets/js/ppmboot/dist/good-words.js' />"></script>
    </jsp:attribute>
    <jsp:attribute name="script">
        <script type="text/javascript">
        	var pw = "roqkf12#";
            var fnObj = {
                pageStart: function () {
                    $('[data-btn="setup"]').click(function () {
                    	axDialog.prompt({  
                            theme: "primary",
                            msg: "비밀번호를 입력하세요",
                            input: {
                                passwd: {label: "비밀번호", type: "text", value: "", required: true}
                            }
                        }, function () {
                        	if (this.key == "ok") {
                        		var passwd = this.input.passwd;
                        		if(passwd==pw){
                                	ppmboot.ajax({
                                        type: "GET",
                                        url: "/setup/init",
                                        data: {},
                                        callback: function (response) {
                                            alert("Initializing completed");
                                            location.href = CONTEXT_PATH + "/";
                                        }
                                    });
                        		}
                        		
                            }
                        });
                    });


                    $('[data-btn="setupMenu"]').click(function () {
                    	axDialog.prompt({  
                            theme: "primary",
                            msg: "비밀번호를 입력하세요",
                            input: {
                                passwd: {label: "비밀번호", type: "text", value: "", required: true}
                            }
                        }, function () {
                        	if (this.key == "ok") {
                        		var passwd = this.input.passwd;
                        		if(passwd==pw){

                                	ppmboot.ajax({
                                        type: "GET",
                                        url: "/setup/initMenu",
                                        data: {},
                                        callback: function (response) {
                                            alert("Menu Initializing completed");
                                            location.href = CONTEXT_PATH + "/";
                                        }
                                    });
                        		}
                        		
                            }
                        });
                    });

                    $('[data-btn="setupData"]').click(function () {
                    	ppmboot.ajax({
                            type: "GET",
                            url: "/setup/initData",
                            data: {},
                            callback: function (response) {
                                alert("Data Initializing completed");
                                location.href = CONTEXT_PATH + "/";
                            }
                        });
                    });


                    $('[data-btn="ifUser"]').click(function () {
                    	axDialog.prompt({  
                            theme: "primary",
                            msg: "비밀번호를 입력하세요",
                            input: {
                                passwd: {label: "비밀번호", type: "text", value: "", required: true}
                            }
                        }, function () {
                        	if (this.key == "ok") {
                        		var passwd = this.input.passwd;
                        		if(passwd==pw){
                                	ppmboot.ajax({
                                        type: "GET",
                                        url: "/setup/ifUser",
                                        data: {},
                                        callback: function (response) {
                                            alert("IF User completed");
                                            location.href = CONTEXT_PATH + "/";
                                        }
                                    });
                        		}
                        		
                            }
                        });
                    });
                }
            };
        </script>
    </jsp:attribute>

    <jsp:body>
        <ppm:flex-layout valign="top" align="center" style="width:100%;height:100%;">

            <div style="width: 360px;padding-top: 20px;">
                <div class="page-header">
                    <h1>HACCP CREATIVE MES
                        <small>Setup</small>
                    </h1>
                </div>

                <div class="panel panel-primary">
                    <div class="panel-heading">DATABASE 정보</div>
                    <table class="table">
                        <colgroup>
                            <col width="100"/>
                        </colgroup>
                        <tr>
                            <th>
                                DatabaseType
                            </th> 
                            <td>
                                    ${databaseType}
                            </td>
                        </tr>
                        <tr>
                            <th>
                                JdbcUrl
                            </th>
                            <td>
                                    ${jdbcUrl}
                            </td>
                        </tr>
                        <tr>
                            <th>
                                UserName
                            </th>
                            <td>
                                    ${username}
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="alert alert-info" role="alert">
                    초기화 하시면 모든 데이터가 없어집니다.
                </div>
                <!-- TODO : AJAX Call로 처리 -->
                <button class="btn btn-info btn-lg" data-btn="setup">DB 초기화</button>
                <button class="btn btn-info btn-lg" data-btn="setupMenu">메뉴 초기화</button>
                <button class="btn btn-info btn-lg" data-btn="setupData">기초코드 초기화</button>
                <button class="btn btn-info btn-lg" data-btn="ifUser">IF USER</button>
            </div>
        </ppm:flex-layout>
    </jsp:body>
</ppm:layout>
