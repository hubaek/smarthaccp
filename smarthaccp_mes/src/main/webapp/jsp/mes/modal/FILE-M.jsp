<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<ppm:set key="pageName" value="File Browser"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>

<ppm:layout name="modal">
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="script">
        <script type="text/javascript" src="<c:url value='assets/FILE-M.js' />"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
            파일업로드
        </h1>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons>
            <button type="button" class="btn btn-info W50" data-page-btn="search">조회</button>
            <button type="button" class="btn btn-fn1 W50" data-page-btn="fn1">삭제</button>
            <button type="button" class="btn btn-default W50" data-page-btn="close">창닫기</button>
        </ppm:page-buttons>

        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="*" style="padding-right: 10px;">

                <div data-fit-height-aside="grid-view-01">
                    <ppm:form name="searchView0">
                        <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                            <ppm:tr>
                                <ppm:td label='검색어' width="100%">
                                    <input type="text" name="filter" id="filter" class="form-control inline-block W200" value="" placeholder="검색어를 입력하세요."/>
                                </ppm:td>
                            </ppm:tr>
                        </ppm:tbl>
                    </ppm:form>
                    <div class="H10"></div>
                </div>

                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>

                <div data-fit-height-aside="grid-view-01">
                    <div class="H10"></div>
                    <form name="uploadForm" action="/ckeditor/uploadImage" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="targetId" id="targetId" />
                        <input type="hidden" name="targetType" id="targetType" />
                        <input type="hidden" name="only" id="only" />

                        <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                            <ppm:tr>
                                <ppm:td label='파일업로드' width="100%" labelStyle="background: #616161;color: #fff;">
                                    <div class="input-group">
                                        <input type="file" name="upload" class="form-control" />
                                        <span class="input-group-btn">
                                            <button type="submit" name="Upload" class="btn btn-primary"><i class="cqc-upload"></i> 업로드</button>
                                        </span>
                                    </div><!-- /input-group -->
                                </ppm:td>
                            </ppm:tr>
                        </ppm:tbl>
                    </form>
                </div>

            </ppm:split-panel>
            <ppm:splitter></ppm:splitter>
            <ppm:split-panel width="400" style="padding-left: 10px;" id="split-panel-form" scroll="true">

                <ppm:form name="formView01">
                    <div data-fit-height-aside="form-view-01">
                        <div class="ax-button-group">
                            <div class="left">
                                <h2>
                                    <i class="cqc-blackboard"></i>
                                    파일 뷰어 </h2>
                            </div>
                            <div class="right">

                            </div>
                        </div>

                        <ppm:tbl clazz="ax-form-tbl">
                            <ppm:tr labelWidth="80px">
                                <ppm:td label="파일명" width="100%">
                                    <input type="text" data-ax-path="fileNm" class="form-control" value=""/>
                                </ppm:td>
                            </ppm:tr>
                            <ppm:tr labelWidth="80px">
                                <ppm:td label="타입" width="100%">
                                    <input type="text" data-ax-path="fileType" class="form-control" value=""/>
                                </ppm:td>
                            </ppm:tr>
                            <ppm:tr labelWidth="80px">
                                <ppm:td label="URL" width="100%">
                                    <input type="text" data-ax-path="preview" class="form-control" value=""/>
                                </ppm:td>
                            </ppm:tr>
                        </ppm:tbl>

                    </div>
                    <div class="H10"></div>
                    <div id="preview-target"></div>
                </ppm:form>

            </ppm:split-panel>
        </ppm:split-layout>

    </jsp:body>
</ppm:layout>