<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
	background-image: url(/B1/img/grass.jpg);

	}

	.SS{
		display: flex;
		justify-content:center;
		align-items: center;
		flex-direction: column;
		height: 100vh;
		background-color: cover;
		gap:30px;

	a{
		font-size:2rem;
		text-decoration:none;
		color:#000000;
		text-align:center;
		font-weight:bold;
		top: 50%;
		font-size:8vw;
		}

	.SSparts{
		display:flex;
		flex-direction: row;
		width:80%;
		height: 10%;
		text-align:center;
		background-color:#FFFFFF;
		justify-content: center;
    	align-items: center;

	}

	.title{
		font-size:10vw;
		font-weight:bold;
		color:#FFFFFF;

	}
}
</style>
</head>
<body>

<div class="SS">

<div class="img">


</div>

<div class="title">
ワールドツアー
</div>


<div class="SSparts">
	<a href = "/B1/SetPlayingConditionsServlet?play=japan">国内コース</a>
</div>
<div class="SSparts">
	<a href = "/B1/SetPlayingConditionsServlet?play=foreign">海外コース</a>
</div>
<div class="SSparts">
	<a href = "/B1/SetPlayingConditionsServlet?play=random">ランダム</a>
</div>

</div>




</body>
</html>