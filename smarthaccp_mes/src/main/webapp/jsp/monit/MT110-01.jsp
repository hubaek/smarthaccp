<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>  
  	<meta charset="utf-8">  
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  	<title>CCP 모니터링</title>
  	<link rel="stylesheet" href="/assets/css/index.css">
  	<link rel="stylesheet" href="/assets/css/button.css"> 
	
	<!-- jQuery 2.2.0 -->
	<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="assets/MT-ITEM-LIST.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/js/treetable/jquery-treetable.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<script src="resources/js/treetable/jquery-treetable.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.10/d3.min.js"></script>

	<!-- moment -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/ko.js"></script>
</head> 
<body>
    <div class="index">
        <header id="header">
            <h1 class="title">SMART HACCP 모니터링 시스템 </h1>
            <button class="btn-round" onclick="fn_fullScreen();">전체화면</button>
            <span class="date" id="clock">-</span>
        </header>
        <div id="itemList" class="grid-container">
			
        </div>
        
    </div>
</body>
<script>

var btnConfig = new Object();
$(document).ready(function(){
	drawMonitPage();
	setInterval(function(){drawMonitPage();}, 1000 * 10);
	startClock();
});

function drawMonitPage(){
	//Default
	getSensingData(); //Default
	getMetalDetect(); //금속검출기
	//추가 모니터링 데이터는 function 및 MT-ITEM-LIST에 추가
	/*
	 * ex) getAddExitem1(), getAddExitem2() ....	 
	*/
}

function getSensingData(){
	var rtnData;
	$.ajax({
		type:"GET"
		,url:'/api/v1/productionSiteMonit/getTempList'
		,data: {}
		,async: false //동기
		,contentType: 'application/json'
		,success:function(res){
			$("#itemList").empty();//초기화
			defineItem(res);
		}//sucess
		,error:function(e){
			alert(e.responseText);
		}
	});
	
	return rtnData;
}

function getMetalDetect(){
	$.ajax({
		type:"GET"
		,url:'/api/v1/productionSiteMonit/getMetalDetect'
		,data: {}
		,async: false //동기
		,contentType: 'application/json'
		,success:function(res){
			MetalAddItem("itemList", res);
		}//sucess
		,error:function(e){
			alert(e.responseText);
		}
	});
}

function fn_fullScreen(){
	if (!document.fullscreenElement) {
	    document.documentElement.requestFullscreen()
  	}else{
    	if (document.exitFullscreen) {
      		document.exitFullscreen()
    	}
  	}
}

function startClock(){
    let $clock = $('#clock');
    let clockFormat = 'YYYY.MM.DD HH:mm:ss';
    
    $clock.html(moment().format(clockFormat));

    setInterval(function() {
        $clock.html(moment().format(clockFormat));
    }, 1000);
}

/*
 * CCP Item 추가
 * plcIp에 맞게 설정하여 value setting
 *
 */
function defineItem(itemList){
	for(var i=0; i<itemList.length; i++){
		var index = i+1;
		var item = itemList[i];
		
		var plcIp = item["plcIp"];
		var temp = item["value1"];
		var Humidity = item["value2"];
		
		/* 
		 * 1. icon Config(온도, 습도 등등)
		*/
		item["icon"] = ["temp"];
		item["iconpre"] = [""];
		item["iconval"] = [ temp1 ];
		item["iconpost"] = ["°C"];
		
		var btnDivid = "btn_div" + '_' + index;
		/* 1-1. CCP 추가 */
		addCcpItem("itemList", btnDivid, item, index, max, min);
		
		/* 2. button Config(상태) */
		/* 2-1. 초기화 */
		btnConfig = {};
		var statbtnid = "";
		
		/* 2-2. Config Setting
		 * value : 상태를 show/hide
		 * valuebtnid : 상태가 ON/OPEN일 경우 상태 title
		 * valueonTitle : 상태가 OFF/CLOSE일 경우 상태 title
		 * valueoffTitle : 상태가 OFF나 CLOSE시, title
		 * valueoffHidden : 상태가 OFF나 CLOSE일 경우, hidden으로 처리할지 여부(default: false)
		*/
		
		var btnid = "btn_" + plcIp + '_' + index;
		btnConfig.value2 = temp2;
		btnConfig.value2btnid = btnid + "_temp2";
		btnConfig.value2onTitle = "OPEN";
		btnConfig.value2offTitle = "CLOSE";
		btnConfig.value2offHidden = false;
		
		btnConfig.value3 = temp3;
		btnConfig.value3btnid = btnid + "_temp3";
		btnConfig.value3onTitle = "OPEN";
		btnConfig.value3offTitle = "CLOSE";
		btnConfig.value3offHidden = false;
		
		btnConfig.value4 = temp4;
		btnConfig.value4btnid = btnid + "_temp4";
		btnConfig.value4onTitle = "OPEN";
		btnConfig.value4offTitle = "CLOSE";
		btnConfig.value4offHidden = false;
		
		btnConfig.value5 = temp5;
		btnConfig.value5btnid = btnid + "_temp5";
		btnConfig.value5onTitle = "OPEN";
		btnConfig.value5offTitle = "CLOSE";
		btnConfig.value5offHidden = false;
		
		if(plcIp == "EQUIP_01" || plcIp == "EQUIP_02"){
			btnConfig.value3offHidden = true;
			btnConfig.value5offHidden = true;
			btnConfig.value4onTitle = "ON";
			btnConfig.value4offTitle = "OFF";
		}else {
			btnConfig.value3onTitle = "제상중";
			btnConfig.value3offTitle = "CLOSE";
			btnConfig.value3offHidden = true;
			if(plcIp == "TEMP_02"){
				btnConfig.value5offHidden = false;
			}else{
				btnConfig.value5offHidden = false;
			}
		}
		
		/* 2-3. 상태추가 */
		addButton(btnDivid, btnConfig);
	}
}
</script>