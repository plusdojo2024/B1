<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<!--
	 String[] play ={cook_time_,selectMeat,selectVege1,selectVege2,selectSeas,selectHelp,
        		PlaySeasList[1],PlaySeasList[2],PlaySeasList[0]};
	 -->

	調理時間は「${play[0]}」<br>
	必須の肉は「${play[1]}」<br>
	必須の野菜は「${play[2]}」<br>
	必須の野菜は「${play[3]}」<br>
	お助け調味料は「${play[4]}」<br>
	お助け食材はは「${play[5]}」<br>
	FREE調味料は「${play[6]}」<br>
	制限付き調味料は「${play[7]}」<br>
	制限付き調味料は「${play[8]}」<br>
	禁止調味料は「${play[9]}」<br>
	禁止調味料は「${play[10]}」<br>


	<form method="post" action="/B1/SetPlayingConditionsServlet" enctype="multipart/form-data">>
		<input type="file" name="image"
		accept="image/*" class="required" required>
		<input type="submit" name="regist" value="登録"><br>
	</form>


	<!--
	<c:forEach var="item" items="${FS}">

	 ${item.food_seas_num}<br>
	 ${item.food_seas_name}<br>
	 ${item.food_seas_genre}<br>
	 ${item.food_box_num}<br>

	 </c:forEach>
	  -->

<!--
	${PlaySeasList[0]}<br>
	${PlaySeasList[1]}<br>
	${PlaySeasList[2]}<br>
	${PlaySeasList[3]}<br>
	${PlaySeasList[4]}<br>
	 -->


		<!--
		ユーザ番号は ${Status[0]} <br>
		ツアー番号は「${Status[1]}」<br>
		ラウンド番号は「${Status[2]}」<br>
		ホール数は「${Status[3]}」<br>
		ラウンドステータスは「${Status[4]}」<br>
		プレイステータスは「${Status[5]}」<br>
	 -->
	</div>
</body>
</html>