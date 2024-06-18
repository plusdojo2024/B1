<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	</datalist><br>

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
	</datalist><br>

	<!--
	<input type="text" name="jsp">.jsp<br>
	<input type="text" name="servlet">.java<br>
	-->


	<input type="submit">
</form>
</body>
</html>