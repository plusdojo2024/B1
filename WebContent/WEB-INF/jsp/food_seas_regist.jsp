<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>食材マイ調味料の登録</h2>
	<form method="post" action="/B1/FoodSeasServlet">
		食材名<input type="text" name="name"><br>
		ジャンル<select name="genre">
			<option value="meat">肉</option>
			<option value="vege">野菜</option>
			<option value="help">お助け</option>
			<option value="myse">調味料</option>
		<br><input type="submit" name="regist" value="登録">
		</select>
</form>
<h2>調味料セットの登録・解除</h2>

	<form>
		<input type="checkbox" name="set" value="suger">砂糖<br>
		<input type="checkbox" name="set" value="solt">塩<br>
		<input type="checkbox" name="set" value="vineger">酢<br>
		<input type="checkbox" name="set" value="soysauce">醤油<br>
		<input type="checkbox" name="set" value="miso">味噌<br>
		<input type="checkbox" name="set" value="touban">豆板醤<br>
		<input type="checkbox" name="set" value="tenmen">甜麺醤<br>
		<input type="checkbox" name="set" value="weiper">ウェイパー<br>
		<input type="checkbox" name="set" value="rayu">ラー油<br>
		<input type="checkbox" name="set" value="oystar">オイスターソース<br>
		<input type="checkbox" name="set" value="kochu">コチュジャン<br>
		<input type="checkbox" name="set" value="chill">唐辛子<br>
		<input type="checkbox" name="set" value="kumin">クミン<br>
		<input type="checkbox" name="set" value="garamu">ガラムマサラ<br>
		<input type="checkbox" name="set" value="curry">カレー粉<br>
		<input type="checkbox" name="set" value="chillpowder">チリパウダー<br>
		<input type="checkbox" name="set" value="consome">コンソメ<br>
		<input type="checkbox" name="set" value="tomato">トマト類<br>
		<input type="checkbox" name="set" value="herb">ハーブ<br>
		<input type="checkbox" name="set" value="wine">ワイン<br>
		<input type="checkbox" name="set" value="blackpepper">ブラックペッパー<br>
		<input type="checkbox" name="set" value="nanm">ナンプラー<br>
		<input type="checkbox" name="set" value="chillsouce">チリソース<br>
		<input type="checkbox" name="set" value="coconuts">ココナッツ類<br>
		<input type="checkbox" name="set" value="mustard">マスタード<br>
		<input type="checkbox" name="set" value="ketsup">ケチャップ<br>
		<input type="checkbox" name="set" value="mayo">マヨネーズ<br>
		<input type="checkbox" name="set" value="bbq">BBQソース<br>
		<input type="checkbox" name="set" value="cheese">チーズ<br>
	</form>
</body>
</html>