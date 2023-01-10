<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%--
/**
 * 0. Project	: MES
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2019.06.12
 * 3. Comment 	: 메인화면
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 --%>
<ppm:set key="pageName" value=""/>
<ppm:set key="page_auto_height" value="false"/>
<ppm:set key="axbody_class" value="baseStyle"/>
<ppm:layout name="empty">
    <jsp:attribute name="script">
        <ppm:script-lang key="ppm.script" />
        <c:set var="now" value="<%=System.currentTimeMillis()%>"></c:set>
        <script type="text/javascript" src="<c:url value='/assets/main/main.js'><c:param name="v" value="${now}"></c:param></c:url>"></script>
    	<script type="text/javascript" src="<c:url value='/assets/js/ppm_common.js'><c:param name="v" value="${v}"></c:param></c:url>"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
 		<link rel="stylesheet" href="/assets/css/weather.css" />
		<link rel="stylesheet" href="/assets/css/slider.css" />
		
		<!-- Fullcalendar -->
		<script src="/assets/js/fullcalendar/main.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/assets/js/fullcalendar/main.min.css">
		
		<!-- eCharts -->
		<script type="text/javascript" src="/assets/js/echarts.js"></script>
    </jsp:attribute>
    <jsp:body>
    	<div class="slider">
			    <div class="slides">
			      <!-- 
			      <div id="slides__1" class="slide">
					  <img src="/assets/css/images/slideimg.png" alt="sample">	
			      </div> 
			      -->
			      <div id="slides__2" class="slide">
			          <div class="lb-widget">
					      <div id="lb-1" class="lb-weather">
					          <iframe src="https://forecast.io/embed/#lat=35.18&lon=128.11&name=Jinju 진주시&color=&font=&units=si"></iframe>
					      </div>
					  </div>
			      </div>
			      <div id="slides__3" class="slide">
			          <div class="row clearfix" style="width:90%;">
				          <div class="col-lg-6 col-md-6">
							  <div class="x_panel">
			              	  	  <div class="x_title">
			                      	  <h5><i class="cqc-checkmark2"></i> 공지사항 </h5>
			                  	  </div>
							  	  <div class="x_content">
			               	  	  	  <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 335px"></div>
			               	  	  </div>
			           		  </div>
			      		  </div>
			      		  <div class="col-lg-6 col-md-6">
							  <div class="x_panel">
					              <div class="x_title">
					              	  <h5><i class="cqc-checkmark2"></i> 자료실 </h5>
					              </div>
								  <div class="x_content">
						              <div data-ax5grid="grid-view-02" data-fit-height-content="grid-view-02" style="height: 335px"></div>
						          </div>
					          </div>
				      	  </div>
			          </div>
			      </div>
			      <div id="slides__4" class="slide">
			      	  <div id='calendar' style="width: 90%; margin: 0 auto; background-color:#F1F6F7; overflow: hidden;"></div>
			          <!-- <div id='line-chart' style="width: 100%; height:90%"></div> -->
			      </div>
			      <div id="slides__5" class="slide">
			      	  
			          <div id='line-chart' style="width: 100%; height:90%"></div>
			      </div>
			    </div>
			    <div class="slider__nav">
			        <!-- <a id="slide1" class="slider__navlink" href="#slides__1"></a> -->
			        <a id="slide2" class="slider__navlink" href="#slides__2"></a>
			        <a id="slide3" class="slider__navlink" href="#slides__3"></a>
			        <a id="slide4" class="slider__navlink" href="#slides__4"></a>
			        <a id="slide5" class="slider__navlink" href="#slides__5"></a>
			    </div>
			</div>
	    <%-- <ppm:form name="formView01"></ppm:form> --%>
    </jsp:body>
</ppm:layout>

<style>
body {
	/* margin: 40px 10px; */
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
}
</style>
<script type="text/javascript">
var index = 1;
//var interval;
//var isStart = true;

//그래프 관련 변수
var myChart;
var Today = new Date();
Today = Today.toISOString();
Today = Today.substring(0,10);

//일정표 관련 변수
var calendar;

var calendarSampleData = [
    {title: 'All Day Event',start: '2022-09-01', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Long Event',start: '2022-09-07',end: '2022-09-10', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {groupId: 999,title: 'Repeating Event',start: '2022-09-09T16:00:00', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {groupId: 999,title: 'Repeating Event',start: '2022-09-16T16:00:00', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Conference',start: '2022-09-11',end: '2022-09-13', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Meeting',start: '2022-09-12T10:30:00',end: '2022-09-12T12:30:00', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Lunch',start: '2022-09-12T12:00:00', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Meeting',start: '2022-09-12T14:30:00', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Happy Hour',start: '2022-09-12T17:30:00', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Dinner',start: '2022-09-12T20:00:00', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Birthday Party',start: '2022-09-13T07:00:00', textColor:"#000000", backgroundColor:"#F5F5DC"},
    {title: 'Click for Google',url: 'http://google.com/',start: '2022-09-27', textColor:"#000000", backgroundColor:"#F5F5DC"}
];

$(document).ready(function () {
	lb_dropdowns();
	//alert(1234);
	/* $("#slide1").click( function() {index = 1;}); */
	$("#slide2").click( function() {index = 2;});
	$("#slide3").click( function() {index = 3;});
	$("#slide4").click( function() {index = 4; setTimeout(displayTasks(), 5000);});
	//$("#slide3").click( function() {index = 3; setTimeout(displayTasks(), 5000);});
	$("#slide5").click( function() {index = 5; setTimeout(selectCcpMonitoringData(Today), 5000);});
});
 
//calendar setting
function displayTasks() {
	var Today = new Date();
	Today = Today.toISOString();
	Today = Today.substring(0,10);

	var calendarEl = document.getElementById('calendar');
	if (calendar != null && calendar != "" && calendar != undefined) {
		calendar.destroy();
	}
	
	calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar: {
	        left: 'prev,next today',
	        center: 'title',
	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
	    },
	    initialDate: Today,
	    height: 700,
	    locale : 'ko',
	    expandRows: true,
	    navLinks: true, 
	    editable: true,
	    selectable: true,
	    selectMirror: true,
	    select: function(arg) {
	    	//ppmboot.popup.open("/jsp/calPopup.jsp", "일정", "800", "600", null);
	        var title = prompt('일정입력 :');
	        if (title) {
	            calendar.addEvent({
	                title: title,
	                start: arg.start,
	                end: arg.end,
	                allDay: arg.allDay,
	                textColor:"#000000",
	                backgroundColor:"#378006"
	            })
	        }
	        calendar.unselect(); 
	    },
	    eventClick: function(arg) {
	   	    if(confirm('선택하신 일정을 삭제하시겠습니까?')) {
	        	arg.event.remove();
	        }
	    },
	    editable: true,
	    dayMaxEvents: true, 
	    //events: calendarSampleData,
	    events: function(info, successCallback, failureCallback){
	    	  // ajax 처리로 데이터를 로딩 시킨다.
	    	  $.ajax({
	    		   type:"get",
	    		   url:"/api/v1/calendar/selectcalendarlist",
	    		   dataType:'json',
	    		   contentType: 'application/json',
	    		   async: false,
	    		   success : function(res){
				       successCallback(res);
	    	       },
	    	       error : function(XMLHttpRequest, textStatus, errorThrown){
	    	    	   console.log("error");	
	    	       }
	    	  }); 
	    },
	    
	    eventColor: '#378006',
	    eventTimeFormat: {
	   	    hour: '2-digit',
	   	    minute: '2-digit',
	   	    second: '2-digit',
	   	    meridiem: false
	    }
	});
	calendar.render();
}

function selectCcpMonitoringData(date){
	var strdate = date.replace(/-/gi, "");

	var params = {"DATE" : strdate};
	
	$.ajax({
        type : "POST",          
        url :  "/api/v1/productionSiteMonit/MonitoringData", 
        contentType: 'application/json',
        data : JSON.stringify(params),
        async: false,
        success : function(res){
        	realtimeData = res;
        	initGraph(res);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
        	alert("모니터링 데이터 조회 중 에러가 발생하였습니다.\n 시스템 관리자에게 문의하세요.");
        	return;
        }
    });
}

function initGraph(data){
	TYPE   = data.TYPE;
	XYLine = data.XYLine;
	
	if(XYLine.length == 0){
		for(var i=0; i<TYPE.length; i++){
			for(var j=0; j<=8; j++){
				var tmp_measure_dtm = "00:00";
				var hours = j*3 < 10 ? '' : '';
				tmp_measure_dtm = String(j*3) + ":" + tmp_measure_dtm;
				var temp = {"auto_collect_id" : TYPE[i], "measure_dtm" : tmp_measure_dtm, "value" : "0"};
				XYLine.push(temp);
			}	
		}
	}

    if (myChart != null && myChart != "" && myChart != undefined) {
	    myChart.dispose();
	}
    
    var chartDom = document.getElementById('line-chart');
	myChart = echarts.init(chartDom, null,{
		renderer: 'canvas',
		useDirtyRect: false
	});
	
	var option = {
		title: {
		    text: 'Sensing Data',
		    left: 10
		},
		tooltip: {
		    trigger: 'axis',
		    axisPointer: {
		        type: 'line',
		        axis: 'auto'
		    }
		},
		legend: {
			data : TYPE
		},
		grid: {
		    bottom: 90
		},
		xAxis: {
		    name: '시간',
		    data: [],
		    silent: false,
		    splitLine: {
		        show: false
		    },
		    splitArea: {
		        show: true
		    }
		},
		yAxis: {
		    name: '값',
		    splitArea: {show: true},
		    max: 30,
		    splitNumber : 5
		},
		series: []
	};
	
	setgraphData(option, TYPE, XYLine);
	
	if(option && typeof option === 'object') {
	    myChart.setOption(option);
		
	}
	window.addEventListener('resize', myChart.resize()); 
}

function setgraphData(option, dataType, selectList){
	var YvalList = new Array();
	for(var i=0; i<dataType.length; i++){
		var typeList = _.filter(selectList, _.matches({"auto_collect_id" : dataType[i]}));
		//1. X축 데이터(1번만 setting)
		if(i == 0){
			var Xtemp = _.map(typeList, 'measure_dtm');
			option.xAxis.data = Xtemp;
		}
		
		//2. Y축 데이터	
		var Ytemp = {
			name : dataType[i],
			type : 'line',
			large : true,
			data : typeList
		};
		
		YvalList.push(Ytemp);
	}
	option.series = YvalList;
}


//날씨 위젯
function lb_dropdowns() {
	$('.lb-weather').show();
	$('#lb-1').show();
	$('#select-box').change(function () {
	    $('.lb-weather').hide();
	    $('#lb-1').show();                                    
	});
}
</script>