<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<%--
/**
 * 0. Project	: 코주부MES
 * 1. 작성자  		: 박혁준
 * 2. 작성일		: 2020.07.03
 * 3. Comment 	: 제품검사대장
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="crossorigin="anonymous"></script>
<title>출력 테스트</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
    border: 1px solid #444444;
}

 

th, td {
    text-align: center;
    padding: 8px;
    border: 1px solid #444444;
}

 

textarea{
    width: 100%;
    height: 100%;
    border: 0;
    resize:none;
}

 

tr:nth-child(even) {background-color: #f2f2f2;}
</style>

<style>
table {
    border-collapse: collapse;
    width: 100%;
    border: 1px solid #444444;
}

 

th, td {
    text-align: center;
    padding: 8px;
    border: 1px solid #444444;
}

 

textarea{
    width: 100%;
    height: 100%;
    border: 0;
    resize:none;
}
tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body onload="getData()">
		<script type="text/javascript">
		<%
		String [] param = request.getParameter("inspectionYm").split("-");
		%>
		
		var inspectionYY = ""+<%=param[0]%>+"";
		var inspectionmm = ""+<%=param[1]%>+"";
		if(inspectionmm.length == 1){
			inspectionmm = "0"+inspectionmm;
		}
		var inspectionYm = inspectionYY+"-"+inspectionmm;
		
		var master;
		var detail;
		var html = "";
		function getData(){
		    $.ajax({
		        url: '/api/v1/itemCheck/print',
		        data: {inspectionYm : inspectionYm},
		        method: 'GET',
		        dataType: 'json',
		        success : function(data){
		            master = data.map.master;
		            detail = data.map.detail;
		            craeteDetail();
		        }
		    });
		}
		function craeteDetail(){
			for(index in detail){
				html += '<tr>';

				if(detail[index].inspectionDate == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].inspectionDate+'</td>';	
				}
				
				if(detail[index].itemName == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].itemName+'</td>';	
				}
				
				if(detail[index].stellate == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].stellate+'</td>';	
				}
				
				if(detail[index].expriationDt == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].expriationDt+'</td>';	
				}
				
				if(detail[index].displayItem == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].displayItem+'</td>';	
				}
				
				if(detail[index].packing == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].packing+'</td>';	
				}
				
				if(detail[index].dxdznAgentYn == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].dxdznAgentYn+'</td>';	
				}
				
				if(detail[index].weight == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].weight+'</td>';	
				}
				
				if(detail[index].pinholeYn == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].pinholeYn+'</td>';	
				}
				
				if(detail[index].mstrCntnt == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].mstrCntnt+'</td>';	
				}
				
				if(detail[index].finalJdgmn == undefined){
					html += '<td>'+"-"+'</td>';
				}else{
					html += '<td>'+detail[index].finalJdgmn+'</td>';	
				}

				html += '</tr>';
				
			}
		$("#tBody").append(html);
		$("#inspectionYm").text(master.inspectionYm);
		}
		
	</script>
		<div>
			<table style="border:1px;" id ="table">
				<thead>
					<tr>
						<th colspan = "8" rowspan = "2" style="vertical-align: bottom;">
                    		<h1>제품 검사 대장</h1>
                    		<pre style ="text-align:left">■ 점검월:<span id="inspectionYm"></span></pre>
                		</th>
						<th colspan="1" rowspan="2">결<br/>재</th>
						<th colspan="1">작성</th>
						<th colspan="1">승인</th>
					</tr>
					
					<tr>
						<th style="height: 100px"></th>
						<th></th>
					</tr>
				</thead>
				<tbody id="tBody">
					<tr>
						<th colspan="2">점검주기</th>
						<th colspan="9">1회/일(제품별)</th>
					</tr>
					<tr>
						<th colspan="2">범례</th>
						<th colspan="9">양호 : O , 불량 : X</th>
					</tr>
					<tr>
						<th colspan="1"></th>
						<th>제품명</th>
						<th>성상</th>
						<th>유통기한</th>
						<th>표시사항</th>
						<th>포장상태</th>
						<th>탈산소제</th>
						<th>중량</th>
						<th>핀홀유무</th>
						<th>수분함량</th>
						<th rowspan="2">최정판정</th>
					</tr>
					<tr>
						<th>점검일</th>
						<th>제품제조보고<br/>명칭</th>
						<th>고유의색상,<br/>형상</th>
						<th>년월일<br/>인쇄확인</th>
						<th>스티커<br/>부착상태,<br/>표시사항<br/>확인</th>
						<th>실링<br/>상태</th>
						<th>유무<br/>확인</th>
						<th>-0g이상<br/>,<br/>5g이하</th>
						<th>포장지<br/>핀홀<br/>확인</th>
						<th>22<br/>~<br/>28%</th>
					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>