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
		String [] param = request.getParameter("inDate").split("-");
		%>
		
		var inspectionYY = ""+<%=param[0]%>+"";
		var inspectionmm = ""+<%=param[1]%>+"";
		var inspectiondd = ""+<%=param[2]%>+"";
		if(inspectionmm.length == 1){
			inspectionmm = "0"+inspectionmm;
		}
		if(inspectiondd.length == 1){
			inspectiondd = "0"+inspectiondd;
		}
		var inDate = inspectionYY+"-"+inspectionmm+"-"+inspectiondd;
		
		var master;
		var detail;
		var details;
		var html = "";
		function getData(){
		    /* $.ajax({
		        url: '/api/v1/material/print',
		        data: {inDate : inDate},
		        method: 'GET',
		        dataType: 'json',
		        success : function(data){
		            master = data.map.master;
		            detail = data.map.detail;
		            details = data.map.details;
		            craeteDetail();
		            craeteDetails();
		        }
		    }); */
		}
		/* function craeteDetail(){
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
		} */
		
	</script>
		<div style=height:1000px>
			<table style="border:1px;" id ="table">
				<thead>
					<tr>
						<th colspan = "11" rowspan = "2" style="vertical-align: bottom;">
                    		<h1>부재료 입고검사 대장</h1>
                    		<pre style ="text-align:left">■ 점검일자:<span id="inDate"></span></pre>
                		</th>
						<th colspan="1">작성</th>
						<th colspan="1">승인</th>
						<th colspan="1">승인</th>
					</tr>
					
					<tr>
						<th style="height: 100px"></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody id="tBody">
					<tr>
						<th>입고<br/>일자</th>
						<th>제품명</th>
						<th>입고량</th>
						<th>성상<br/>이물</th>
						<th>이취</th>
						<th>포장<br/>상태</th>
						<th>표시<br/>사항</th>
						<th>차량<br/>위생</th>
						<th>해충<br/>감염<br/>여부</th>
						<th>파렛트<br/>상태</th>
						<th>성적서</th>
						<th>유통기한<br/>(제조일)</th>
						<th>적부<br/>판정</th>
						<th>확인</th>
					</tr>
				</tbody>
			</table>
		</div>
		
		
		<div>
			<table style="border:1px;" id ="table2">
				<thead>
					<tr>
						<th colspan = "11" rowspan = "2" style="vertical-align: bottom;">
                    		<h1>부자재 입고검사 대장</h1>
                    		<pre style ="text-align:left">■ 점검일자:<span id="inDate2"></span></pre>
                		</th>
						<th colspan="1">작성</th>
						<th colspan="1">승인</th>
						<th colspan="1">승인</th>
					</tr>
					
					<tr>
						<th style="height: 100px"></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody id="tBody2">
					<tr>
						<th>입고<br/>일자</th>
						<th>제품명</th>
						<th>입고량</th>
						<th>표기<br/>인쇄<br/>사항</th>
						<th>규격<br/>상태</th>
						<th>포장<br/>상태</th>
						<th>차량<br/>위생</th>
						<th>해충<br/>감염<br/>여부</th>
						<th>파렛트<br/>상태</th>
						<th>성적서</th>
						<th>제조일</th>
						<th>LOT</th>
						<th>적부<br/>판정</th>
						<th>확인</th>
					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>