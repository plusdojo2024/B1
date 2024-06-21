<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
メイン画面
<div>
user_numは${Status[0]}<br>
tour_numは${Status[1]}<br>
round_numは${Status[2]}<br>
hole_numは${Status[3]}<br>
round_statusは${Status[4]}<br>
play_statusは${Status[5]}<br>

</div>


<a href="/B1/StatusCheck?action="><img></a>



</body>
</html>