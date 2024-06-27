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
<h2>食材マイ調味料の登録</h2>
<button type="button" onclick="/B1/FoodSeasListServlet">食材一覧</button>

<form method="post" action="/B1/FoodSeasListServlet" name="form">
	<c:forEach var="i" begin="0" end="7" step="1">
		<label>食材${i+1}</label><input type="text" name="food" id="food"><br>
		<select name="genre">
			<option value="genre">ジャンル</option>
			<option value="meat">肉</option>
			<option value="vege">野菜</option>
			<option value="help">お助け</option>
			<option value="myse">調味料</option>
		</select><br>
	</c:forEach>

<h2>調味料セットの登録・解除</h2>
		<input type="checkbox" name="set" value="suger">砂糖
		<input type="checkbox" name="set" value="solt">塩
		<input type="checkbox" name="set" value="vineger">酢
		<input type="checkbox" name="set" value="soysauce">醤油
		<input type="checkbox" name="set" value="miso">味噌<br>
		<input type="checkbox" name="set" value="touban">豆板醤
		<input type="checkbox" name="set" value="tenmen">甜麺醤
		<input type="checkbox" name="set" value="weiper">ウェイパー<br>
		<input type="checkbox" name="set" value="rayu">ラー油
		<input type="checkbox" name="set" value="oystar">オイスターソース<br>
		<input type="checkbox" name="set" value="kochu">コチュジャン
		<input type="checkbox" name="set" value="chill">唐辛子<br>
		<input type="checkbox" name="set" value="kumin">クミン
		<input type="checkbox" name="set" value="garamu">ガラムマサラ
		<input type="checkbox" name="set" value="curry">カレー粉
		<input type="checkbox" name="set" value="chillpowder">チリパウダー<br>
		<input type="checkbox" name="set" value="consome">コンソメ
		<input type="checkbox" name="set" value="tomato">トマト類
		<input type="checkbox" name="set" value="herb">ハーブ<br>
		<input type="checkbox" name="set" value="wine">ワイン
		<input type="checkbox" name="set" value="blackpepper">ブラックペッパー<br>
		<input type="checkbox" name="set" value="nanm">ナンプラー
		<input type="checkbox" name="set" value="chillsouce">チリソース
		<input type="checkbox" name="set" value="coconuts">ココナッツ類<br>
		<input type="checkbox" name="set" value="mustard">マスタード
		<input type="checkbox" name="set" value="ketsup">ケチャップ
		<input type="checkbox" name="set" value="mayo">マヨネーズ<br>
		<input type="checkbox" name="set" value="bbq">BBQソース
		<input type="checkbox" name="set" value="cheese">チーズ<br>

	<input type="submit" name="regist" value="登録">
	</form>
</body>
</html>