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
   	<c:if test="${empty foodSeasRecord}">
		<p>一致するデータはありません。</p>
	</c:if>
	<c:forEach var="e" items="${foodSeasRecord}">
		<p>${e.food_seas_name}</p>
		<p>${e.name}</p>
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