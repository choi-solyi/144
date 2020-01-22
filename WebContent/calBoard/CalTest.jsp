<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='http://localhost:8080/challenger144/calBoard/fullcalendar/core/main.css' rel='stylesheet' />
<link href='http://localhost:8080/challenger144/calBoard/fullcalendar/daygrid/main.css' rel='stylesheet' />
<link href='http://localhost:8080/challenger144/calBoard/fullcalendar/timegrid/main.css' rel='stylesheet' />
<script src='http://localhost:8080/challenger144/calBoard/fullcalendar/core/main.js'></script>
<script src='http://localhost:8080/challenger144/calBoard/fullcalendar/interaction/main.js'></script>
<script src='http://localhost:8080/challenger144/calBoard/fullcalendar/daygrid/main.js'></script>
<script src='http://localhost:8080/challenger144/calBoard/fullcalendar/timegrid/main.js'></script>
<script>
//페이지가 로드되면 DB에 접속해서 calboard title, caldate, bno를 가져올거야
  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth'
      },
      //defaultDate: '2019-08-12',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
    	  console.log(arg);
        var title = prompt('대회명:');
        if (title) { //입력부분 입력된 데이터는 DB에 저장할것임
          calendar.addEvent({
            title: title,
            start: arg.start,
            end: arg.en,
            allDay: arg.allDay
          })
        }
        calendar.unselect()
      },
      editable: true,
      eventLimit: true, // allow "more" link when too many events
      events: [ // 일정 출력부분 데이터 넣어줄것임
        {
          title: 'All Day Event',
          start: '2020-01-23'
        },
        {
          title: 'Click for Google',
          url: 'http://google.com/',
          start: '2020-01-22'
        }
      ]
    });

    calendar.render();
  });

</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }

</style>
</head>
<body>

  <div id='calendar'></div>

</body>
</html>