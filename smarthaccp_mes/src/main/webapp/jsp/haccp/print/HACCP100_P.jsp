<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: 코주부 MES
 * 1. 작성자  		: 윤광준
 * 2. 작성일		: 2020.07.20
 * 3. Comment 	: 
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
var mList;
var dList;

//js에서 request getParam 구현
function Request(){
	var requestParam = "";
	this.getParameter = function(param) {
		var url = unescape(location.href);
		var paramArr = (url.substring(url.indexOf("?") + 1, url.length))
				.split("&");
		for (var i = 0; i < paramArr.length; i++) {
			var temp = paramArr[i].split("="); 
			if (temp[0].toUpperCase() == param.toUpperCase()) {
				requestParam = paramArr[i].split("=")[1];
				break;
			}
		}
		return requestParam;
	}
}

//textarea 높이 자동 조절
function adjustHeight() {
	  var textEle = $('textarea');
	  textEle[0].style.height = 'auto';
	  textEle[0].style.overflow = 'hidden';
	  textEle[0].style.backgroundColor = 'inherit';
	  var textEleHeight = textEle.prop('scrollHeight');
	  textEle.css('height', textEleHeight);
};

var request = new Request();
var inspecYm = request.getParameter("inspectionYm");
getMasterData(inspecYm);
function getMasterData(date){
	$.ajax({
		url: '/api/v1/car/master',
		data: {inspectionYm : date},
		method: 'GET',
		dataType: 'json',
		success : function(mData){
			getDetailData(date,mData);
		}
	});
}

function getDetailData(date, mData){
	$.ajax({
		url: '/api/v1/car/detail',
		data: {inspectionYm : date},
		method: 'GET',
		dataType: 'json',
		success : function(dData){
			tableCreate(mData,dData);
		}
	});
}

function tableCreate(mData, dData){
	var tm= new Array();
	var html = '';
	var html_d = '';
	var td = new Array();
	
	
	/*for (var item in mData.list[0]){
		//console.log(item);
		//업데이트 예정
	}*/
	
	for (var i = 0 ; i<dData.list.length; i++){
		td.push(dData.list[i]);
	}
	tm.push({company: mData.list[0].company, inspectionYm: mData.list[0].inspectionYm, reviewer: mData.list[0].reviewer, status: mData.list[0].status, writer:mData.list[0].writer, approver: mData.list[0].approver});
	for (key in td){
		//undefined 값 빈칸으로 채움
		var licensePlate = (td[key].licensePlate==undefined)?'':td[key].licensePlate + '</td>';
		var custCode = (td[key].custCode==undefined)?'':td[key].custCode + '</td>';
		var departureTime = (td[key].departureTime==undefined)?'':td[key].departureTime + '</td>';
		var arrivalTime = (td[key].arrivalTime==undefined)?'':td[key].arrivalTime + '</td>';
		var mileage = (td[key].mileage==undefined)?'':td[key].mileage + 'km</td>';
		var remark = (td[key].remark==undefined)?'':td[key].remark + '</td>';
		var foreinStatus = (td[key].foreinStatus==undefined)?'':td[key].foreinStatus + '</td>';
		var offFlavorStatus = (td[key].offFlavorStatus==undefined)?'':td[key].offFlavorStatus + '</td>';
		var loadStatus = (td[key].loadStatus==undefined)?'':td[key].loadStatus + '</td>';
		var lockStatus = (td[key].lockStatus==undefined)?'':td[key].lockStatus + '</td>';
		var proprietyStatus = (td[key].proprietyStatus==undefined)?'':td[key].proprietyStatus + '</td>';
		var sterStatus = (td[key].sterStatus==undefined)?'':td[key].sterStatus + '</td>';
		
		html_d += '<tr>';
		html_d += '<td style="text-align:center">' + td[key].deliveryDate.substring(5,10).replace('-','/') + '</td>';
		html_d += '<td align ="center">' + licensePlate + '</td>';
		html_d += '<td align ="center">' + custCode + '</td>';
		html_d += '<td align ="center">' + departureTime + '</td>';
		html_d += '<td align ="center">' + arrivalTime + '</td>';
		html_d += '<td>' + mileage + ' km</td>';
		html_d += '<td>' + remark + '</td>';
		html_d += '<td align ="center">' + foreinStatus + '</td>';
		html_d += '<td align ="center">' + offFlavorStatus + '</td>';
		html_d += '<td align ="center">' + loadStatus + '</td>';
		html_d += '<td align ="center">' + lockStatus + '</td>';
		html_d += '<td align ="center">' + proprietyStatus + '</td>';
		html_d += '<td align ="center">' + sterStatus + '</td>';
		html_d += '</tr>';
	}
	
	$("#createYear").text(mData.list[0].inspectionYm.substring(0,4)+"년");
	$("#writer").text(mData.list[0].writer);
	$("#reviewer").text(mData.list[0].reviewer);
	$("#approver").text(mData.list[0].approver);
	$("#detailPrintArea").empty();
	$("#detailPrintArea").append(html_d);
	$("#remark").text(mData.list[0].remark);
	adjustHeight();
}


</script>

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
<div id="main">
	<!-- <table style="border: 1px solid black;">
		<tbody id = "mainPrintArea">
		</tbody>
	</table> -->
	<!-- <p>	■ 작셩연도: <span id="createYear"></span>
		■ 배송담당자 : <span id="writer"></span>
		■ 검토자: <span id="reviewer"></span>&nbsp;&nbsp;
		■ 승인자: <span id="approver"></span>
	</p> -->
	<table>
		<thead>
			<tr>
				<th colspan = "9" rowspan = "2" style="vertical-align: bottom; border-left: solid 1px #FFF; border-top: solid 1px #FFF">
					<h1>차량운행 및 위생점검일지</h1>
					<pre style ="text-align:left">■ 작셩연도: <span id="createYear"></span>                    ■ 배송담당자 : <span id="writer"></span></pre>
				</th>
				<th rowspan = "2">결<br/><br/>재</th>
				<th>작성</th>
				<th>검토</th>
				<th>승인</th>
			</tr>
			<tr>
				<th style="height: 75px"></th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<th colspan ="7" style ="text-align:left"> ■ 배송내역</th>
				<th colspan ="6" style ="text-align:left"> ■ 차량 위생 점검사항
					<br/> <span style="color:red">*</span>양호: O, 불량: X
				</th>
			</tr>
			<tr>
				<th rowspan='2'>배송날짜</th>
				<th rowspan='2'>차량번호</th>
				<th rowspan='2'>거래처</th>
				<th rowspan='2'>출발시간</th>
				<th rowspan='2'>도착시간</th>
				<th rowspan='2'>주행거리</th>
				<th rowspan='2'>비고<br/>(이상내역, 수리내역 등)</th>
				<th colspan='2'>청결상태</th>
				<th rowspan='2' style="width:60px">적재상태</th>
				<th rowspan='2' style="width:60px">시건상태</th>
				<th rowspan='2' style="width:60px">적부판정</th>
				<th rowspan='2' style="width:60px">세차/소독 실시 여부</th>
			</tr>
			<tr>
				<th style="width:60px">이물</th>
				<th style="width:60px">이취</th>
			</tr>
			
		</thead>
		<tbody id = "detailPrintArea">
	
		</tbody>
		<tr>
			<td colspan="13" style="text-align:left"> ■ 개선조치란</td>
		</tr>
		<tr>
			<td colspan="13" style="height:150px; text-align : left"><textarea id="remark"></textarea></td>
		</tr>
	</table>
</div>