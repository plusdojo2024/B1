<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Play Page</title>
</head>
<body>
    <h1>調理条件</h1>
   	<c:if test="${empty foodSeasNames}">
		<p>一致するデータはありません。</p>
	</c:if>
	<c:forEach var="e" items="${foodSeasNames}">
<<<<<<< HEAD
		<p>${e.food_seas_name}</p>
=======
		<p>${e.name}</p>
>>>>>>> cf96dc07c26f7d8d7d49c299092d0859b7560e0b
	</c:forEach>

	<h2>
	de
	</h2>




   	<!--   <c:forEach var="name" items="${foodSeasNames}">
        		<li>${e.name}</li>
    </c:forEach>
	-->

    <!-- ここに他のコンテンツや機能を追加 -->

</body>
</html>