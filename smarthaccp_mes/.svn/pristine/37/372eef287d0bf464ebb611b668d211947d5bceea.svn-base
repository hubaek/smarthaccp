<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="false"/>
	<ppm:layout name="base">
		<jsp:attribute name="script">
			<ppm:script-lang key="ax.script" />
			<c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
			<script type="text/javascript" src="<c:url value='assets/PL000.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
		</jsp:attribute>
		<jsp:body>
			<ppm:page-buttons function1Label="복사"></ppm:page-buttons>
			<div role="page-header">
				<ppm:form name="searchView0">
					<ppm:tbl clazz="ax-search-tbl" minWidth="500px">
						<ppm:tr>
							<ppm:td label='점검년도' required="true">
	                         	<div class="input-group" data-ax5picker="basic">
		                        	<ppm:period-picker3 fromId="year" dateType="YEAR"/>
		                        </div>
		                    </ppm:td> 
		                    <ppm:td label="검사유형" width="230px">
                            	<ppm:input type="text" name="qcNm" id="qcNm" clazz="form-control"/>
                        	</ppm:td>
						</ppm:tr>
					</ppm:tbl>
				</ppm:form>
				<div class="H10"></div>
			</div>
			<ppm:split-layout name="ax1" orientation="vertical">
				<ppm:split-panel width="45%" style="padding-right: 10px;">
					<div class="ax-button-group" data-fit-height-aside="grid-view-01">
						<div class="left">
	                        <h2><i class="cqc-list"></i>목록</h2>
	                    </div>
	                    <div class="right">
	                    	<label style="color:red; font-size: large;">검사유형과 계획만 복사됩니다.</label>
	                    	<button type="button" class="btn btn-default" data-grid-view-01-btn="item-add">
	                    		<i class="cqc-plus"></i>
	                    		<ppm:lang id="ax.admin.add"/>
	                    	</button>
	                    	<button type="button" class="btn btn-default" data-grid-view-01-btn="item-remove">
		                        <i class="cqc-minus"></i>
		                        <ppm:lang id="ax.admin.delete"/>
	                    	</button>
	                    </div>
                    </div>
                    <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
				</ppm:split-panel>
			</ppm:split-layout>
		</jsp:body>
	</ppm:layout> 