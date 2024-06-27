<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
	textarea {
  	resize: none;
  	width:45%;
 	height:100px;
	}
	body{
		font-size: 32px;
		background-color:#FFFF88;
    	background-size:30%;
	}
</style>
<head>
<meta charset="UTF-8">
<title>今回のスコア</title>
</head>
<body align=center>
<c:set var="par" value="${scoreList[0].par}"/>
<c:set var="par_calc" value="${-1*par+1}"/>
2024年6月18日 第2回ツアー 2R13H par5<br>
<font size="200px">
スコア -1 バーディ
</font><img src="${pageContext.request.contextPath}/img/jump.png" width=15% height=15% style="vertical-align: middle;"><br>
<a href="/B1/ScoreServlet">スコア表はこちら</a><br><br>
<img src="${pageContext.request.contextPath}/img/yasaita.jpg" width=50% height=50%><br>
<p style="font-size:50px">豚野菜味噌炒め</p>
▼スコア詳細
<table align=center>
	<tr><td>調理時間</td>
		<td><c:out value="${scoreList[0].total_score}"/></td>
		<td>±0</td></tr>
	<tr><td>使用食材</td>
		<td>豚肉</td>
		<td>±0</td></tr>
	<tr><td></td>
		<td>キャベツ</td>
		<td>±0</td></tr>
	<tr><td></td>
		<td>もやし</td>
		<td>±0</td></tr>
	<tr><td></td>
		<td>人参</td>
		<td>+1</td></tr>
	<tr><td></td>
		<td>ピーマン</td>
		<td>+1</td></tr>
	<tr><td></td>
		<td>きくらげ</td>
		<td>+1</td></tr>
	<tr><td>使用調味料</td>
		<td>味噌</td>
		<td>±0</td></tr>
	<tr><td></td>
		<td>砂糖</td>
		<td>±0</td></tr>
	<tr><td>調理満足度</td>
		<td>☆☆☆</td>
		<td>±0</td></tr>
	<tr><td>味満足度</td>
		<td>☆☆☆</td>
		<td>±0</td></tr>
	<tr><td>規定打数</td>
		<td>par5</td>
		<td>-4</td></tr>
	<tr><td>------------</td>
		<td>----------</td>
		<td>-----</td></tr>
	<tr><td>総合評価</td>
		<td></td>
		<td>-1</td></tr>
</table><br><br>
<textarea readonly>コメント</textarea><br>
</body>
</html>