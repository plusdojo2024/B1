<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今回のスコア</title>
</head>
<body>
<c:set var="par" value="${scoreList[0].par}"/>
<c:set var="par_calc" value="${-1*par+1}"/>
日付 第回ツアー R H par<c:out value="${par}"/>
スコア <c:out value="${scoreList[0].total_score}"/>

<a href="/B1/ScoreServlet">スコア表はこちら</a>

料理画像

料理名

▼スコア詳細
<table>
	<tr><td>調理時間</td>
		<td><c:out value="${scoreList[0].total_score}"/></td>
		<td>評価</td></tr>
	<tr><td>使用食材</td>
		<c:forEach var="item" items="${scorelist}">
		<td>${e.使用食材}</td>
		</c:forEach>
		<td>評価</td></tr>
	<tr><td>使用調味料</td>
		<c:forEach var="item" items="${scorelist}">
		<td>${e.使用調味料}</td>
		</c:forEach>
		<td>評価</td></tr>
	<tr><td>調理満足度</td>
		<td><c:out value="${scoreList[0].cook_scores}"/></td>
		<td>評価</td></tr>
	<tr><td>味満足度</td>
		<td><c:out value="${scoreList[0].taste_scores}"/></td>
		<td>評価</td></tr>
	<tr><td>規定打数</td>
		<td>par<c:out value="${par_calc}"/></td>
		<td></td></tr>
		</table>
		---------------------
		総合評価
		コメント
</body>
</html>