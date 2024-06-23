<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>表彰一覧</title>
<link rel="stylesheet" href="/B1/css/cooklist.css">
</head>
<body>
	<c:if test="${empty cardList}">
		<p>一致するデータはありません。</p>
	</c:if>
<c:forEach var="e" items="${cardList}">
		<p>${e.cook_img}</p>
</c:forEach>
	<a href="/B1/HyousyouServlet" class="btn">表彰一覧へ</a>
</body>
</html>