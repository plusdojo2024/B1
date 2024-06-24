<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Play Page</title>
    <script type="text/javascript">
        window.onload = function () {
            // 開始時刻を表示
            var startTime = "${startTime}";
            document.getElementById('startTimeDisplay').innerText = startTime;

            // 画像送信ボタンを押した瞬間の現在時刻を記録
            document.getElementById('uploadButton').onclick = function () {
                var now = new Date();
                var formattedTime = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
                document.getElementById('uploadTime').value = formattedTime;
                document.getElementById('startTime').value = startTime;
                document.getElementById('timeForm').submit();
            };
        };
    </script>
</head>
<body>
    <h1>調理条件</h1>
   	<c:if test="${empty foodSeasNames}">
		<p>一致するデータはありません。</p>
	</c:if>
	<c:forEach var="e" items="${foodSeasNames}">
		<p>${e.food_seas_name}</p>
		<p>${e.name}</p>

	</c:forEach>

	<h2>
		<div>Start Time: <span id="startTimeDisplay"></span></div>

    	<form id="timeForm" action="saveTimes" method="post">
        <input type="hidden" id="startTime" name="startTime" value="">
        <input type="hidden" id="uploadTime" name="uploadTime" value="">
        <input type="submit" id="uploadButton" value="Send Image">
    </form>
	</h2>




   	<!--   <c:forEach var="name" items="${foodSeasNames}">
        		<li>${e.name}</li>
    </c:forEach>
	-->

    <!-- ここに他のコンテンツや機能を追加 -->

</body>
</html>