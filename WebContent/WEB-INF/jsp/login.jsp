<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="Message" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./css/login.css" rel="stylesheet" type="text/css">
<title>献立ゴルフ</title>
</head>
<body class="PageFlex">

	<div class="PageFlexBox">


		<div class="FormBox">

			<div class="FormTitle">ログイン</div>

			<form 	method="post"
			action="/B1/LoginServlet">

			<div>


				<input 	type="text"
						name="user_name"
						placeholder="ユーザ名"
						class="TextForm"><br>
			</div>

			<div>
				<input 	type="text"
						name="user_pass"
						placeholder="パスワード"
						class="TextForm" ><br>
			</div>

			<div class="SubmitButton">
				<input 	type="submit">

			</div>

			</form>

		</div>

		<div>
			<Message:if test="${!empty Message[0]}">
				<div>${Message[0]}</div>
				<div>${Message[1]}</div>
			</Message:if>
		</div>
	</div>

</body>
</html>