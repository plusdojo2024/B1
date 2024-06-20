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
<c:forEach var="e" items="${cardList}">
${e.cook_img}<br>
${e.cook_num}<br>
${e.cook_name}<br>
${e.cook_time}<br>
${e.cook_sta}<br>
${e.cook_fin}<br>
${e.food_con}<br>
${e.food_used}<br>
${e.seas_con}<br>
${e.seas_used}<br>
${e.cook_satis}<br>
${e.aji_satis}<br>
${e.cook_fav}<br>
${e.cook_com}<br>

</c:forEach>
料理の一覧
</body>
</html>