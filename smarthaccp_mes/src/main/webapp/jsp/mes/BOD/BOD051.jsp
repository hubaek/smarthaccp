<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>일정표</title>
	
	<script src="/jsp/monit/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/assets/js/fullcalendar/main.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/assets/js/fullcalendar/main.min.css">
	<style>
		body {
		  margin: 40px 10px;
		  padding: 0;
		  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
		  font-size: 14px;
		}
		
		#calendar {
		  /* max-width: 920px; */
		  margin: 0 auto;
		  background-color : white;
		}
	</style>
</head>
<body>
	<div id='calendar' style="width: 100%;"></div>
</body>

<script>
	 document.addEventListener('DOMContentLoaded', function() {
		 var calendarEl = document.getElementById('calendar');

		    var calendar = new FullCalendar.Calendar(calendarEl, {
		      headerToolbar: {
		        left: 'prev,next today',
		        center: 'title',
		        right: 'dayGridMonth,timeGridWeek,timeGridDay'
		      },
		      initialDate: '2022-09-02',
		      height: 700,
		      locale : 'ko',
		      expandRows: true,
		      navLinks: true, // can click day/week names to navigate views
		      editable: true,
		      selectable: true,
		      selectMirror: true,
		      select: function(arg) {
		        var title = prompt('일정입력 :');
		        if (title) {
		          calendar.addEvent({
		            title: title,
		            start: arg.start,
		            end: arg.end,
		            allDay: arg.allDay
		          })
		        }
		        calendar.unselect()
		      },
		      eventClick: function(arg) {
		    	  if(confirm('선택하신 일정을 삭제하시겠습니까?')) {
		          	  arg.event.remove()
		          }
		      },
		      editable: true,
		      dayMaxEvents: true, // allow "more" link when too many events
		      events: [
		        {
		          title: 'All Day Event',
		          start: '2022-09-01'
		        },
		        {
		          title: 'Long Event',
		          start: '2022-09-07',
		          end: '2022-09-10'
		        },
		        {
		          groupId: 999,
		          title: 'Repeating Event',
		          start: '2022-09-09T16:00:00'
		        },
		        {
		          groupId: 999,
		          title: 'Repeating Event',
		          start: '2022-09-16T16:00:00'
		        },
		        {
		          title: 'Conference',
		          start: '2022-09-11',
		          end: '2022-09-13'
		        },
		        {
		          title: 'Meeting',
		          start: '2022-09-12T10:30:00',
		          end: '2022-09-12T12:30:00'
		        },
		        {
		          title: 'Lunch',
		          start: '2022-09-12T12:00:00'
		        },
		        {
		          title: 'Meeting',
		          start: '2022-09-12T14:30:00'
		        },
		        {
		          title: 'Happy Hour',
		          start: '2022-09-12T17:30:00'
		        },
		        {
		          title: 'Dinner',
		          start: '2022-09-12T20:00:00'
		        },
		        {
		          title: 'Birthday Party',
		          start: '2022-09-13T07:00:00'
		        },
		        {
		          title: 'Click for Google',
		          url: 'http://google.com/',
		          start: '2022-09-28'
		        }
		      ],
		      eventTimeFormat: { // like '14:30:00'
		    	    hour: '2-digit',
		    	    minute: '2-digit',
		    	    second: '2-digit',
		    	    meridiem: false
		      }
		    });

		    calendar.render();
		  });
	</script>

</html>