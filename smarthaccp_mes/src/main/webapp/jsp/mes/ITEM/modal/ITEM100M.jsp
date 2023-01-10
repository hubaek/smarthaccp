<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 품목정보등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="pageName" value=""/>
<ppm:set key="page_auto_height" value="false"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="modal">
    <jsp:attribute name="script">
        <ppm:script-lang key="ax.script" />
        <c:set var="v" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='assets/ITEM100M.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title"><i class="cqc-browser"></i> 품목정보등록<span id = "pgmTitle"></span></h1>  
    </jsp:attribute>
    <jsp:body>    	
        <ppm:page-buttons help="N" clear="N">          
	        <button type="button" class="btn btn-fn1 W100"  data-page-btn="save" id = "save" style="display:none;">저장</button>
	        <button type="button" class="btn btn-danger W100"  data-page-btn="delete" id = "delete" style="display:none;">삭제</button>
	        <button type="button" class="btn btn-default W100" data-page-btn="close">닫기</button>
        </ppm:page-buttons>             
		<div id="modal-content" style="height:700px;">
			<ppm:form name="formView01">
				<ppm:tab-layout name="ax2" style="height:700px;">
					<ppm:tab-panel label="기본정보" scroll="scroll">   
						<ppm:tbl clazz="ax-form-tbl" minWidth="500px">	  
							<ppm:tr>
								<ppm:td label="회사" width="25%" required="true">
									<ppm:company-code dataPath="company"/> 
								</ppm:td>
								<ppm:td label="품목유형" width="25%">
									<ppm:common-code mainCd="ITEM_TYPE" dataPath="itemType"/>
								</ppm:td>     	   					                
								<ppm:td label='품목그룹' width="25%">
					                <div class="form-inline">
										<div class="form-group">
						                   	<ppm:item-main-cd emptyText="-" emptyValue="" dataPath="itemMainCd" clazz=" W80" id="itemMainCd"/>&nbsp;
						                   	<ppm:common-code mainCd="ITEM_SUB_CD" emptyText="-" emptyValue="" dataPath="itemSubCd" id="itemSubCd" clazz=" W110"/>
										</div>
									</div>
								</ppm:td>      
								<ppm:td label="사용여부" width="25%">
									<ppm:common-code mainCd="USE_YN" defaultValue ="Y" dataPath="useYn"/>
								</ppm:td>
							</ppm:tr>                               
							<ppm:tr>
								<ppm:td label="품목코드" width="25%" required="true">
									<input type="text" data-ax-path="itemCd" id="itemCd" title="품목코드" class="form-control inline-block W130 required" data-ax-validate="required" onKeyUp="chkCharCode(event)"/>
									<button id="checkId" class="btn btn-default" data-form-view-01-btn="checkId">중복체크</button>
								</ppm:td>
								<ppm:td label="품목명" width="25%" required="true">
									<input type="text" data-ax-path="itemNm" title="품목명" class="form-control required" data-ax-validate="required"/>
								</ppm:td>             
								<ppm:td label="규격" width="25%">
									<input type="text" data-ax-path="spec" class="form-control"/>
								</ppm:td>
								<ppm:td label="EA변환수량" width="25%">
									<input type="text" data-ax-path="boxEa" class="form-control" style="text-align:right" data-ax5formatter="number"/>
								</ppm:td>      
							</ppm:tr>             
							<ppm:tr>	          
								<ppm:td label="LOT관리" width="25%" required="false">
									<ppm:common-code mainCd="USE_YN" dataPath="lotYn"/>
								</ppm:td>         
								<ppm:td label="안전재고" width="25%">
									<input type="text" data-ax-path="safetyQty" class="form-control" style="text-align:right" data-ax5formatter="number"/>
								</ppm:td>     
								<ppm:td label="검사방법" width="25%" required="false">
									<ppm:common-code mainCd="QC_WAY" dataPath="qcWay"/>
								</ppm:td>    
								<ppm:td label="유통기한" width="25%">
									<input type="text" data-ax-path="expirationDate" class="form-control"/>
								</ppm:td>	                  
							</ppm:tr>
							<ppm:tr>	             
								<ppm:td label='거래처' width="25%">
									<ppm:form-modal codeName="custCd" valueName="custNm"  modalType="CUST-MODAL"/>
								</ppm:td>   
								<ppm:td label="수불단위" width="25%" required="true">
									<ppm:common-code mainCd="UNIT" dataPath="unit"/>
								</ppm:td>
								<ppm:td label="판매단가" width="25%">
									<input type="text" data-ax-path="saAmt" class="form-control" style="text-align:right" data-ax5formatter="number"/>
								</ppm:td>
								<ppm:td label="구매단가" width="25%">
									<input type="text" data-ax-path="pcAmt" class="form-control" style="text-align:right" data-ax5formatter="number"/>
								</ppm:td>              
							</ppm:tr>
							<ppm:tr style="display:none;">
								<ppm:td label="재고관리" width="25%" required="true">
									<ppm:common-code mainCd="USE_YN" dataPath="stockYn"/>
								</ppm:td>           							
							</ppm:tr>   
					</ppm:tbl>
					
					<div class="H5"></div>
					<ppm:tbl clazz="ax-form-tbl" minWidth="500px">	  
						  
						<ppm:tr style="display : none">	               
							<ppm:td label="가로" width="25%">
								<input type="text" data-ax-path="horizontal" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>        
							<ppm:td label="세로" width="25%">
								<input type="text" data-ax-path="vertical" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>    
							<ppm:td label="두께" width="25%">
								<input type="text" data-ax-path="thickness" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>    
							<ppm:td label="로스" width="25%">
								<input type="text" data-ax-path="loss" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>
							<ppm:td label="구매단가" width="25%">
								<input type="text" data-ax-path="pcAmt" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>    
							<ppm:td label="표준원가" width="25%">
								<input type="text" data-ax-path="stdCost" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>    
							<ppm:td label="실제원가" width="25%">
								<input type="text" data-ax-path="realCost" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td> 
							<ppm:td label="바코드수량" width="25%">
								<input type="text" data-ax-path="barcodeQty" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td> 
							<ppm:td label="최소구매량" width="25%">
								<input type="text" data-ax-path="lowPurchaseQty" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>      
							<ppm:td label="LEAD TIME" width="25%">
								<input type="text" data-ax-path="leadTime" class="form-control" data-ax5formatter="number"/>
							</ppm:td>
							<ppm:td label="수율단위" width="25%">
								<ppm:common-code mainCd="UNIT" dataPath="yieldUnit"/>
							</ppm:td>
							<ppm:td label="수율단위 수량" width="25%" help="EX) 수불단위 수량(1) 기준 수율단위 수량">
								<input type="text" data-ax-path="yieldTrans" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>       
							<ppm:td label="매입단위" width="25%">
								<ppm:common-code mainCd="UNIT" dataPath="pdUnit"/>
							</ppm:td>
							<ppm:td label="매입단위 수량" width="25%" help="매입단위 수량(1) 기준 수불단위 수량">
								<input type="text" data-ax-path="pdTrans" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>                        
							<ppm:td label="소요단위" width="25%">
								<ppm:common-code mainCd="UNIT" dataPath="bomUnit"/>
							</ppm:td>
							<ppm:td label="소요단위 수량" width="25%" help="EX) 수불단위 수량(1) 기준 소요단위 수량">
								<input type="text" data-ax-path="bomTrans" class="form-control" style="text-align:right" data-ax5formatter="number"/>
							</ppm:td>       
						</ppm:tr>  
						        
	                   <ppm:tr>
	                       	<ppm:td label="비고" width="100%">
								<textarea data-ax-path="remark" class="form-control" rows=5></textarea>
	                         </ppm:td>
	                   </ppm:tr>
						<ppm:tr>
							<ppm:td label="파일첨부" width="100%">
								<ppm:file-uploader targetType = "ITEM_CD" targetId = "itemCd"/>
							</ppm:td>
						</ppm:tr> 
					</ppm:tbl>  
				</ppm:tab-panel>	   	
			</ppm:tab-layout>
			</ppm:form>
		</div>
	<div class="H5"></div>    
	</jsp:body>
</ppm:layout>