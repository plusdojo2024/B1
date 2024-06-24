<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>参加中のツアー</title>
</head>
<body>
    <h1>参加中のツアー</h1>

    <table border="1">
    <h5>第回ツアー（</h5>
    <c:out value="${pastList[0].tour_sta }"/><h5>～）累計スコア</h5>
        <tr>
        <th>日付</th>
        <th>H番号</th>
        <th>コース</th>
        <th>規定打数</th>
        <th>スコア</th>
        <th>累計スコア</th>
        </tr>
    <c:forEach var="e" items="${pastList}">
        <tr>
        <td>${e.user_num}</td>
        <td>1H</td>
        <td></td>
        <td></td>
        <td></td>
        <td>累計スコア</td>
    	</tr>
    </c:forEach>
	</table>
</body>
</html>