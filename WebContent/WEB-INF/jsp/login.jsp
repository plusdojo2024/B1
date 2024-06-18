<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input[type="text"]{
	width:400px;
	height:50px;
	font-size:40px;
	}
	input[type="submit"]{
	width:400px;
	height:100px;
	font-size:40px;
	}
	</style>
</head>
<body>
<div>

<h1>ログイン画面</h1>

<div>
<form method="post" action="/B1/login">
	<input type="text" name="user_name" placeholder="ユーザ名"><br>
	<input type="text" name="user_pass" placeholder="パスワード"><br>
	<input type="submit">

</form>
	<h2>ログイン機能付き</h2>
	<div><h4>空欄のまま送信</h4>
		⇒JSP、サーブレットのアクセスページへ</div>
	<div><h4>ログイン情報(user1,pass1)を入力</h4>
		⇒トップページへ</div>

</div>

</div>
</body>
</html>