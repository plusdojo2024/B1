<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty cardList}">
		<p>一致するデータはありません。</p>
	</c:if>
<c:forEach var="e" items="${cardList}">
"${e.cook_num}"
</c:forEach>
お気に入り一覧
</body>
</html>