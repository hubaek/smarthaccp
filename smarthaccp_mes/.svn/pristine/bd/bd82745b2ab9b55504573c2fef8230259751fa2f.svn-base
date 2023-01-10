<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 작업지시등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="pageName" value="File Browser"/>
<ppm:set key="page_auto_height" value="true"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/PRD100M.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
        <script type="text/javascript" src="<c:url value='/assets/js/item-common.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
           		 작업지시서 등록
        </h1>  
    </jsp:attribute>
    <jsp:body>
       <ppm:form name="formView01">   
        <ppm:page-buttons help="N" clear="N">  
		 	<div class="form-inline">
		       <div class="form-group">            
		            <button type="button" class="btn btn-success W100" data-page-btn="save">저장</button>
		            <button type="button" class="btn btn-fn3 W100" data-page-btn="delete">삭제</button>
		            <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
		       </div>
		    </div>   
        </ppm:page-buttons>              
       <div data-fit-height-aside="form-view-01">
       	<ppm:tbl clazz="ax-form-tbl" minWidth="600px">
	       <ppm:tr>     
	       		<ppm:td label='회사' width="33%">
           			<ppm:company-code dataPath="company"/> 
                </ppm:td>
	       		<ppm:td label="담당자" width="33%" required="true">
                  <div class="form-inline">
                    <div class="form-group">
                        <input type="text" data-ax-path="userCd" class="form-control W80" readonly="readonly"  placeholder="담당자아이디" title="담당자" class="form-control required" data-ax-validate="required"/>
                        <input type="text" data-ax-path="userNm" class="form-control W100" readonly="readonly" placeholder="담당자명"/>
                        <button type="button" class="btn btn-primary W30" data-form-view-01-btn="user_modal" id="userModalBtn">
                            <i class="cqc-magnifier"></i>
                        </button>
                    </div>
               	</div>
              </ppm:td>
	       </ppm:tr>
           <ppm:tr>
               <ppm:td label="지시번호" width="33%">
                    <input type="text" data-ax-path="slipCd" class="form-control" value="" readonly="readonly" placeholder="시스템 자동발번"/>
               </ppm:td>
               <ppm:td label="등록일" width="33%" required="true">
               		<div class="input-group" data-ax5picker="date">
                      <input type="text" class="form-control" data-ax-path="slipDt" placeholder="yyyy-mm-dd" data-ax-validate="required" title="등록일"/>
                      <span class="input-group-addon"><i class="cqc-calendar"></i></span>
                 	</div>
               </ppm:td>
              </ppm:tr>
             	<ppm:tr>
                   <ppm:td label="비고" width="100%">
                       <input type="text" data-ax-path="remark" class="form-control" placeholder=""/>
                   </ppm:td>      
                </ppm:tr>                            
        	</ppm:tbl>
           
           <div class="H5"></div>
            <div class="ax-button-group">
                <div class="left">
                    <h5>
                        <i class="cqc-list"></i>상세정보</h5>
                </div>
                <div class="right" id = "grid-buttons">
                    <button type="button" class="btn btn-success W120" data-grid-view-02-btn="item-all" id ="item-all">
                    	품목 적용
                    </button>
                    <button type="button" class="btn btn-default" data-grid-view-02-btn="item-remove" id="item-remove">
                        <i class="cqc-minus"></i>
                        <ppm:lang id="ax.admin.delete"/>
                    </button>
                </div>
            </div>
       		</div>
            <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 540px;"></div>
       </ppm:form>
    </jsp:body>
</ppm:layout>