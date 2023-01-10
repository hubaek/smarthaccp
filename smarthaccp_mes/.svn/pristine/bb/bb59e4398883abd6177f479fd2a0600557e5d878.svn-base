<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 거래처 등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="title" value="${pageName}"/>
<ppm:set key="page_desc" value="${pageRemark}"/>
<ppm:set key="page_auto_height" value="false"/>
  
<ppm:layout name="base">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <ppm:script-lang key="ax.admin" var="COL" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/STD020.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:body>
        <ppm:page-buttons function1Label="신규" function2Label="수정"></ppm:page-buttons>
        <div role="page-header">
            <ppm:form name="searchView0">
                <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ppm:tr>                    	
                        <ppm:td label='회사' width="230px">
		                	<ppm:company-code dataPath="company"/> 
                        </ppm:td>	                    
                        <ppm:td label='거래처유형' width="230px">
	                        <ppm:common-code mainCd="CUST_TYPE" emptyText="전체" emptyValue="" dataPath="custType" name="custType" id="custType"/>
                        </ppm:td>
                        <ppm:td label='거래처코드' width="230px">
                        	<input type="text" name="custCd" class="form-control" value=""/>
                        </ppm:td>
                        <ppm:td label='거래처명' width="230px">
                        	<input type="text" name="custNm" class="form-control" value=""/>
                        </ppm:td>     
                        <ppm:td label="사용여부" width="230px">
                     		<ppm:common-code mainCd="USE_YN" defaultValue ="Y" emptyText="전체" emptyValue="" dataPath="useYn" name="useYn"/>
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
                        <h5><i class="cqc-list"></i>거래처 목록</h5>
                    </div>
                        <!-- 
                        <div class="right" id = "grid-buttons">
		                    <button type="button" class="btn btn-default" data-page-btn="down-doc">
				                        	양식다운로드
		                    </button>
                		</div>
                         -->
                </div>
                <%-- <ppm:tbl clazz="ax-search-tbl" minWidth="500px">
                  <ppm:tr>
                  <form name="uploadForm" action="/ckeditor/uploadExcel" method="POST" enctype="multipart/form-data">
                  	  <input type="hidden" name="targetId" id="targetId" />
                      <input type="hidden" name="targetType" id="targetType" />
                      <input type="hidden" name="only" id="only" />
                      
                      <ppm:td label='파일업로드' width="100%" labelStyle="background: #616161;">
                          <div class="input-group">
                              <input type="file" name="upload" class="form-control" />
                              <span class="input-group-btn">
                                  <button type="submit" name="Upload" class="btn btn-primary"><i class="cqc-upload"></i> 업로드</button>
                              </span>
                          </div>
                      </ppm:td>
                      
                  </form>    
                  </ppm:tr>
              </ppm:tbl>  --%>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ppm:split-panel>
        </ppm:split-layout>
    </jsp:body>
</ppm:layout>