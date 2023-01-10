<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>  
  <meta charset="utf-8">  
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SV MONIT</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- jQuery 2.2.0 -->
	<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/js/treetable/jquery-treetable.css">
	<script src="resources/js/treetable/jquery-treetable.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.10/d3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
	<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<style>
.body{font-size: 20px;background-color:black}
/** Default,Notice,Qna **/
/* List */
.bbsList{table-layout:fixed; border-collapse:collapse; border:0; width:100%; margin:0 0 0 0px; border-bottom:0px solid #848484;}
.bbsList th{padding:4px 2px; border-top:15px solid #3CC267; background-color:#242424; border-bottom:0px solid #848484; font-weight:bold; color:#ffffff; text-align:center;font-size: 35px;}
.bbsList td{padding:4px 2px; border-top:0px solid #dddddd; background-color:black;  color:#ffffff; text-align:center;font-size: 30px;font-weight: bold;}

.navbar-custom {
    color: #ffffff;
    background-color: black;
}

canvas {
    padding: 0;
    margin: auto;
    display: block;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
}

.col-lg-1, .col-lg-10, .col-lg-11, .col-lg-12, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-md-1, .col-md-10, .col-md-11, .col-md-12, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9, .col-xs-1, .col-xs-10, .col-xs-11, .col-xs-12, .col-xs-2, .col-xs-3, .col-xs-4, .col-xs-5, .col-xs-6, .col-xs-7, .col-xs-8, .col-xs-9 {
    position: relative;
    min-height: 0px;
    padding-right: 0px;
    padding-left: 0px;
}
</style>
</head> 
<body  bgcolor="black">
        <div class="container-fluid" id = 'mainRow' style="background-color:black">
       	</div>
</body>
<script>


var totalCnt  = 0 ; //전체 글의 갯수.

var currentPage = 1; // 현재페이지    
var maxListCount  = 8; // (보여질)최대 리스트 수 (한페이지 출력될 항목 갯수)
var totalPageCnt  = 0;//전체 페이지 수


$(document).ready(function(){
	initPage();
});

function initPage(){	
	
	currentPage = 1;
	
	$.ajax({
		type:"GET"		// 포스트방식
		,url:'/api/v1/worderList/equipMonitList?userCd=tv1&pagingYn=N'
		,dataType:"json"
		,success:function(res){		
			totalCnt = res.length;
	        totalPageCnt = Math.ceil(totalCnt / maxListCount);
	    	refreshPage();	
		}
	    ,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
	    	alert(e.responseText);
	    }
	});
	

	
}
function refreshPage(){		
    var rowIdx = 0;
	$.ajax({
		type:"GET"		// 포스트방식
		,url:'/api/v1/worderList/equipMonitList?userCd=tv1&pagingYn=Y&startIdx=' + (currentPage-1) * maxListCount
		,dataType:"json"
		,success:function(res){		
			
			$("#mainRow").empty();	
			
			var idx = 1;
			res.forEach(function (n) {    
				
	        	if((idx-1) % 4 == 0){
	        		rowIdx++;
		        	$("#mainRow").append(
		        		'<div class="row clearfix" style="height:100%" id ="subRow'+rowIdx+'"></div>'
		        	);
	        	}
	        	
	        	var html = 
	        		'<div class="col-lg-3 col-md-3">'+
	        	    '<table class="bbsList" width = 100%  height = 100% > '+
	        	    '        <input type="hidden" name = "hProdQty'+idx+'" id = "hProdQty'+idx+'"/>'+
	        	    '        <input type="hidden" name = "hBadQty'+idx+'"  id = "hBadQty'+idx+'"/>'+
	        	    '        <input type="hidden" name = "hProdPercent'+idx+'"  id = "hProdPercent'+idx+'"/>'+
	        	   ' 		<tr>'+
	        	   '          <tr>'+
	        	   '             <th height = 10% id = "equipTh'+idx+'">'+n.equipNm+
	        	    '            </th>'+
	        	    '        </tr>'+
	        	    '        <tr>'+
	        	    '            <td height = 70% align=center>'+
	        	     '               <canvas style="border:0px solid #000000;" id="canvas'+idx+'" ></canvas>'+
	        	     '               <div id="item_name'+idx+'"></div>'+
	        	     '           </td>'+
	        	     '       </tr>'+
	        	    '</table>'+
	        	'</div>';
	        	
	        	$("#subRow"+rowIdx).append(html);
				idx ++;
	        });      
		}
	    ,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
	    	alert(e.responseText);
	    }
	});
	startMonitData();
}

var timerId; 

function startMonitData() {  
	if (timerId) return
	timerId = setInterval(getMonitData, 5000)
	getMonitData();
}

function stopMonitData() {
	clearInterval(timerId)
	timerId = null;
}


</script>

<script type="text/javascript">
				
		var refreshCnt = 0 ;
		
        function degToRad(degree){
            var factor = Math.PI/180;
            return degree*factor;
        }

        function renderTime( cavas_name,equip_name,order_qty,order_state,order_state_nm,prod_qty,prod_percent,bad_qty,equip_per,item_name_td,item_name,index ){
        	var canvas = document.getElementById(cavas_name);
            var ctx = canvas.getContext("2d");

        	if(item_name==''){
        		$('#'+item_name_td).html("<div style='line-height:80%;background-color:black'><font size = 4>"+"_"+"</font><br><font size=4>"+"-"+" (</font><font color='red' size=4>"+"-"+"</font><font size=4>) / </font><font color='#6799FF' size=4>"+"-"+"</font></div>");
			}else{
				$('#'+item_name_td).html("<div style='line-height:80%;background-color:black'><font size = 4>"+item_name+"</font><br><font size=4>"+prod_qty+" (</font><font color='red' size=4>"+bad_qty+"</font><font size=4>) / </font><font color='#6799FF' size=4>"+order_qty+"</font></div>");
			}
        	 
            canvas.width = 375;
            canvas.height = 410;
            var barColor = '';
            if(order_state=='RUN'){
            	barColor = "#3CC267";
                $("#equipTh"+(index)).css("border-top","15px solid #3CC267");	
            }else if(order_state=='NWRK'){
            	barColor = "red";
				$("#equipTh"+(index)).css("border-top","15px solid red");	
            }else{
            	barColor = "orange";
				$("#equipTh"+(index)).css("border-top","15px solid orange");	
            }
            
            ctx.strokeStyle = barColor;
            ctx.lineWidth = 17;
            ctx.shadowBlur= 15;
            ctx.shadowColor = barColor;

            //Background
            gradient = ctx.createRadialGradient(250, 250, 5, 250, 250, 300);
     //       gradient.addColorStop(0, "#03303a");
            gradient.addColorStop(1, "black");
            ctx.fillStyle = gradient;
            //ctx.fillStyle = 'rgba(00 ,00 , 00, 1)';
            ctx.fillRect(0, 0, 400, 400);
            //Hours
            ctx.beginPath();
            //ctx.arc(250,250,200, degToRad(270), degToRad((hrs*30)-90));
            //ctx.arc(200,200,200, degToRad(270), degToRad(269));
           // ctx.stroke();
            //Minutes
            ctx.beginPath();
            //ctx.arc(250,250,170, degToRad(270), degToRad((smoothmin*6)-90));
            ctx.arc(200,200,160, degToRad(270), degToRad(1500));
            ctx.stroke();
            //Seconds
            ctx.beginPath(); 
            
            if(prod_percent<=0){
            	ctx.arc(200,200,130, degToRad(270), degToRad( -89.9));
            }else if (prod_percent > 100){
            	ctx.arc(200,200,130, degToRad(270), degToRad(269.9));
            }else{
            	ctx.arc(200,200,130, degToRad(270), degToRad( (360 / 100) * prod_percent)  - 89.57);
            	
            }

	    if(order_state=='RUN'  || order_state=='NWRK'){
             
            ctx.stroke();
            //Date
            ctx.font = "55px Helvetica";
            ctx.fillStyle = barColor;
            
            if( $('#hProdPercent'+(index)).val() < prod_percent){
                ctx.fillText(prod_percent + "%"+ "▲", 145, 140);
            }else{
                ctx.fillText(prod_percent + "%", 145, 140);
            }
            
	    	ctx.font = "31px Helvetica";
            ctx.fillStyle = "#6799FF";
            
            ctx.fillText("계획 "+order_qty, 145, 220);
            
            ctx.font = "31px Helvetica";
            ctx.fillStyle = "white";
            
            if( $('#hProdQty'+(index)).val() < prod_qty){
            	ctx.fillText("실적 "+prod_qty+ "▲", 145, 250);
            }else{
            	ctx.fillText("실적 "+prod_qty, 145, 250);
            }
            
            ctx.font = "31px Helvetica";
            ctx.fillStyle = "red";
            
            if( $('#hBadQty'+(index)).val() < bad_qty){
                ctx.fillText("불량 "+bad_qty+ "▲", 145, 280);
            }else{
                ctx.fillText("불량 "+bad_qty, 145, 280);
            }
            
            ctx.font = "31px Helvetica";
            ctx.fillStyle = "orange";
            
            //if( $('#hEquipPer'+(index+1)).val() < equip_per){
            //    ctx.fillText("설비 "+equip_per+ "%▲", 145, 310);
            //}else{
            //    ctx.fillText("설비 "+equip_per+'%', 145, 310);
            //}
            
            //Time
            ctx.font = "35px Helvetica Bold";
            ctx.fillStyle = barColor;
            ctx.fillText(order_state_nm, 140, 180);
            }else{
	    	//Time
            ctx.font = "45px Helvetica Bold";
            ctx.fillStyle = barColor;
            ctx.fillText(order_state_nm, 135, 210);
            }
            
            $('#hProdQty'+(index)).val(prod_qty)
            $('#hBadQty'+(index)).val(bad_qty)
            $('#hProdPercent'+(index)).val(prod_percent)
            $('#hEquipPer'+(index)).val(equip_per)
		}
        
        
        function getMonitData(){
            refreshCnt++;
            if(refreshCnt == 5){
            	
        		refreshCnt = 0;
            	currentPage++;
            	if(totalPageCnt < currentPage){
            		stopMonitData();
            		initPage();
            	}else{
            		stopMonitData();
            		refreshPage();
            	}
            	
            }else{

                $.ajax({
            		type:"GET"		// 포스트방식
            		,url:'/api/v1/worderList/equipMonitList?userCd=x&pagingYn=Y&startIdx=' + (currentPage-1) * maxListCount
            		,dataType:"json"
            		,success:function(res){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
            			var idx = 1;
        		        res.forEach(function (n) {    
          				  	renderTime("canvas"+(idx),n.equipNm,n.orderQty,n.orderSt,n.orderStatusNm
          						  ,n.prodQty,n.prodPer,n.badQty,30,"item_name"+(idx),n.itemNm,idx)
          						idx ++;
        		        });        
            		}
            	    ,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
            	    	alert(e.responseText);
            	    }
            	});
            }
        }
       
       function closekey() 
       { 
	       if(event.keyCode==27) 
	       { 
	               window.close(); 
	               return false; 
	       } 
       } 

       document.onkeydown=closekey; 
</script>