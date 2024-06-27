<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id = "main">
<head>
<meta charset="UTF-8">
<title>本登録｜献立ゴルフ</title>
<link rel="stylesheet" type="text/css" href="/B1/css/Hontouroku.css">
</head>
<body>
<form method="post" action="/B1/DefinitiveRegistrationServlet">
<div class = "cooks">
<h2>調理にかかった時間</h2>${cooks[0]}
<br>
<h2>コメント入力</h2>
<textarea>
${cooks[1]}
</textarea>
</div>
<br>
<h2>条件の中で使った食材</h2>
<div class = "syokuzai">
<c:forEach var="e" items="${foodSeasRecord}">
<input type="checkbox" name="foods[]" id="${e.food_seas_num}"  value="${e.food_seas_name}">
<label for="${e.food_seas_num}">${e.food_seas_name}</label>
</c:forEach>
</div>
<br>
<h2>使い切ったものリスト</h2>
<div class = "syokuzai">
<c:forEach var="e" items="${foodSeasRecord}">
<input type="checkbox" name="used[]" id="${e.food_seas_num}"  value="${e.food_seas_name}">
<label for="${e.food_seas_num}">${e.food_seas_name}</label>
</c:forEach>
</div>
<div class = "self">
<h2>味の評価</h2>
<input type="radio" name="taste" value="bad"> ミスショット（不満）
<input type="radio" name="taste" value="hutuu"> まあまあ
<input type="radio" name="taste" value="best"> ナイスショット！（最高）
<br>
<h2>調理の評価</h2>
<input type="radio" name="cook" value="bad"> ミスショット（不満）
<input type="radio" name="cook" value="hutuu"> まあまあ
<input type="radio" name="cook" value="best"> ナイスショット！（最高）
<hr>
<h2>お気に入り登録</h2>
<select name="favorite">
<option value="サンプル1">お気に入りに登録する</option>
<option value="サンプル2">努力しました！</option>
<option value="サンプル3">早く作れました！</option>
<option value="サンプル4">旨かったです！</option>
</select>
</div>
<hr>
<div class = "botan">
<input type="submit" name="regist" value="本登録">
</div>
<textarea>
${cooks[1]}
</textarea>
${cooks[0]}


</form>
本登録画面
</body>
</html>