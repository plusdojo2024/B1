<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/main.css" rel="stylesheet" type="text/css">
<title>ＴＯＰ</title>
</head>
<body>

<div id="Flex">
メイン画面

	<!-- プレイボタン -->
	<div class="box_" id="test">
		<a href="/B1/StatusCheckServlet?page=Play">
		<img src="/B1/img/cook.png" id="playImg">
		</a>
	</div>

	<!-- 料理、スコア、食材 -->
	<div class="box_ RowBox">
		<div class="box">
			<a href="/B1/StatusCheckServlet?page=Cooks">
				<div class="SelectBlock">
					<h1>料理</h1>
				</div>

			</a>
		</div>

		<div class="box">
			<a href="/B1/StatusCheckServlet?page=Foods">
				<div class="SelectBlock">
					<h1>食材</h1>
				</div>
			</a>
		</div>

		<div class="box">
			<a href="/B1/StatusCheckServlet?page=Score">
				<div class="SelectBlock">
					<h1>スコア</h1>
				</div>
			</a>
		</div>
	</div>

	<div class="box_">
		<div id="box_regist">
			<a href="/B1/StatusCheckServlet?page=Regist">
				<div class="SelectBlock">
					<h1>スコア</h1>
				</div>
			</a>
		</div>
	</div>

		<dialog>
			<div>${Message[0]}</div>
			<div>${Message[1]}</div>
			<button>ＯＫ</button>
		</dialog>
		<script>
			window.addEventListener("load",(event)=>){
				const MessageDialog = document.getElementById("");
			}
		</script>

</div>

</body>
</html>