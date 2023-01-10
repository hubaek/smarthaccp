<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 메뉴관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="system-config-menu-version" value="1.0.0"/>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="true"/>

<ppm:layout name="base">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/SYS020.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">  
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr>
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company" multiYn="Y" id = "company"/> 
                        </ppm:td>           
                        <ppm:td label='메뉴그룹' width="250px">
                            <ppm:common-code mainCd="MENU_GROUP"  name ="menuGrpCd" id="menuGrpCd"/>
                        </ppm:td>
                    </ppm:tr>
                </ppm:tbl>   
            </ppm:form>
            <div class="H5"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="30%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="tree-view-01">
                    <div class="left">
                        <h5>
                            <i class="cqc-list"></i>
                            <ppm:lang id="ax.admin.menu.title"/> </h5>
                    </div>
                    <div class="right">
                        <button type="button" class="btn btn-default" data-tree-view-01-btn="add"><i class="cqc-circle-with-plus"></i> <ppm:lang id="ax.admin.add"/></button>
                    </div>
                </div>
                <div data-z-tree="tree-view-01" data-fit-height-content="tree-view-01" style="height: 300px;" class="ztree"></div>
            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="*" style="padding-left: 10px;" id="split-panel-form">
                <div data-fit-height-aside="form-view-01">
                    <div class="ax-button-group">
                        <div class="left">
                            <h5><i class="cqc-news"></i>프로그램 설정</h5>
                        </div>
                        <div class="right">
                        </div>
                    </div>
                    <ppm:form name="formView01">
                        <ppm:tbl clazz="ax-form-tbl" minWidth="500px">
                            <ppm:tr>
                                <ppm:td label="회사" width="33%">
	                        		<ppm:company-code dataPath="company" />
                                </ppm:td>
                                <ppm:td label="메뉴아이콘" width="33%">
                                    <input type="text" data-ax-path="iconNm" class="form-control" value=""/>
                                </ppm:td>
                                <ppm:td label="화면 구분값" width="33%">
                                    <input type="text" data-ax-path="paramUrl" class="form-control" value=""/>
                                </ppm:td>
                            </ppm:tr>
                            <ppm:tr>
                                <ppm:td label="프로그램코드" width="33%">
                                    <input type="text" data-ax-path="progCd" class="form-control" value="" readonly="readonly"/>
                                </ppm:td>
                                <ppm:td label="메뉴코드" width="33%">
                                    <input type="text" data-ax-path="menuCd" class="form-control" value="" readonly="readonly"/>
                                </ppm:td>
                                <ppm:td label="메뉴서브코드" width="33%">
                                    <input type="text" data-ax-path="menuCd" class="form-control" value=""/>
                                </ppm:td>
                            </ppm:tr>
                            <ppm:tr>
                                <ppm:td label="다국어(KO)" width="33%">
                                    <input type="text" data-ax-path="multiLanguageJson.ko" class="form-control" value="" />
                                </ppm:td>
                                <ppm:td label="다국어(EN)" width="33%">
                                    <input type="text" data-ax-path="multiLanguageJson.en" class="form-control" value="" />
                                </ppm:td>
                                <ppm:td label="다국어(ZH)" width="33%">
                                    <input type="text" data-ax-path="multiLanguageJson.zh" class="form-control" value="" />
                                </ppm:td>
                            </ppm:tr>
                            <ppm:tr>
                                <ppm:td label="프로그램명" width="33%">
                                    <input type="hidden" data-ax-path="menuCd" class="form-control" value=""/>
                                    <input type="hidden" data-ax-path="progNm" class="form-control" value=""/>
                                    <div class="form-group">
                                        <div data-ax5combobox="progCd" style="width:320px" data-ax5combobox-config='{size: "", editable: false, multiple: false}'></div>
                                    </div>
                                </ppm:td>
                            </ppm:tr>
                        </ppm:tbl>
                    </ppm:form>
                    <div class="H20"></div>
                    <div class="ax-button-group">
                        <div class="left">
                            <h5><i class="cqc-list"></i>권한그룹설정</h5>
                        </div>
                        <div class="right">
                        </div>
                    </div>
                </div>
                 <div data-ax5grid="grid-view-01" data-fit-height-content="form-view-01" style="height: 300px;">
                 </div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>