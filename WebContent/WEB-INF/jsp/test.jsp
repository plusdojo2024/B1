<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/B1/Test">
	<input type="text" name="jsp">.jsp<br>
	<input type="submit">
</form>
=======
<title>開発用ページ</title>
</head>
<body>


開発用のページです
送信を押すと選択したファイルに遷移します
<form method="post" action="/B1/Test">

	ＪＳＰ選択<br>
	<input list="jsp" name="jsp">
	<datalist id="jsp">
		<option value="cook_list"/>
		<option value="favorite"/>
		<option value="login"/>
		<option value="main_regist"/>
		<option value="play"/>
		<option value="temp_regist"/>
		<option value="today_regist"/>
		<option value="now_tour"/>
		<option value="past_scores"/>
		<option value="worldtour">
		<option value="food_seas_list"/>
		<option value="food_seas_regist"/>
		<option value="main"/>
	</datalist>.jsp<br>

	サーブレット選択<br>
	<input list="servlet" name="servlet">
	<datalist id="servlet">
		<option value="login"/>
		<option value="StatesCheck"/>
		<option value="WorldTourPlay"/>
		<option value="SetPlayingConditions"/>
		<option value="SaveTemporaryRegistration"/>
		<option value="DefinitiveRegistration"/>
		<option value="Current"/>
		<option value="favorite"/>
		<option value="foodSeasList"/>
		<option value="foodSeasRegist"/>
		<option value="score"/>
	</datalist>.java<br>

	<!--
	<input type="text" name="jsp">.jsp<br>
	<input type="text" name="servlet">.java<br>
	-->

	<input type="submit">
</form>


>>>>>>> f6c9659f3d18b339c0717751cf3926bca605c108
</body>
</html>