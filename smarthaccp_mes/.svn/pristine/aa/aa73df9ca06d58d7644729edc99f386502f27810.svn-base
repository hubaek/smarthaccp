<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 백현욱
 * 2. 작성일	: 2022.09.23
 * 3. Comment 	: 자료실(지원사업)
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:layout name="base">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" /> 
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/BOD042.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="신규"></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">       
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px" id="searchTb">
                    <ppm:tr>                         	
	                    <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath=	"company"/> 
                        </ppm:td>
		               <ppm:td label="사업명" width="230px">
                        	<input type="text" name="searchText" class="form-control"/>
		               </ppm:td>
		               <ppm:td label="진행사항" width="230px">
                        	<%--<input type="text" name="searchText" class="form-control"/>--%>
                        	<select name="progress">
							    <option value="">진행사항</option>
							    <option value="대기">대기</option>
							    <option value="작성중">작성중</option>
							    <option value="신청완료">신청완료</option>
							</select>
		               </ppm:td>	
		               <ppm:td label="선정여부" width="230px">
                        	<%-- <input type="text" name="searchText" class="form-control"/>--%>
                        	<select name="selection">
							    <option value="">선정여부</option>
							    <option value="미신청">미신청</option>
							    <option value="선정">선정</option>
							    <option value="미선정">미선정</option>
							</select>
		               </ppm:td>	
		               <ppm:td label="담당자" width="230px">
                        	<input type="text" name="searchText" class="form-control"/>
		               </ppm:td>	
		               <ppm:td label="기관명" width="230px">
                        	<input type="text" name="searchText" class="form-control"/>
		               </ppm:td>		
		               	 
                    </ppm:tr> 
                </ppm:tbl>
            </ppm:form>
       		<div class="H10"></div>
        </div>
        <ppm:split-layout name="ax1" orientation="vertical">
            <ppm:split-panel width="50%" style="padding-right: 10px;">
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h5><i class="cqc-list"></i>목록</h5>
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 200px"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>