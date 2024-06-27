<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
	.chart-container {
    	width: 80%; /* グラフの幅を100%に設定 */
        height: 400px; /* グラフの高さを指定 */
        border: 1px solid #ccc; /* 枠線を追加 */
        margin: 0 auto; /* グラフを中央揃えにする */
    }
    body{
    background-image:url("${pageContext.request.contextPath}/img/scorebg.png");
    background-size:5%;
    }
    .btn {
	font-size:50px;
	display: block;
	text-align: center;
	text-decoration: none;
	width: 500px;
	height:75px;
	margin: auto;
	padding: 1rem 4rem;
	font-weight: bold;
	border: 2px solid #45A049;
	background: #0000FF;
	color: #fff;
	border-radius: 100vh;
	transition: 0.5s;
	}
	.btn:hover{
	color: #45A049;
	background: #fff;
	}
	.dialog-overlay {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 1000;
  }

	.dialog-box {
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        z-index: 1010;
        overflow-y: auto; /* 縦方向のスクロールを可能にする */
        max-height: 80%; /* ダイアログの最大高さを設定 */
    }
	textarea {
  		resize: none;
  		width:45%;
 		height:100px;
  	}
  	.dia{
		background-color:#FFFF88;
    	background-size:30%;
  	}
</style>
<head>
<meta charset="UTF-8">
<title>過去の成績</title>
</head>
<body align=center>
<table border="1" align=center width=30% style="background-color: white;"><tr><th><h1>過去の成績</h1></th></tr></table>
<br><div class="chart-container" style="background-color: white;">
	<canvas id="lineChart"></canvas>
</div><br>
<c:forEach var="e" items="${pastList}" >
	<c:set var="H1" value="${pastList[0].total_score}"/>
    <c:set var="H2" value="${pastList[1].total_score}"/>
	<c:set var="H3" value="${pastList[2].total_score}"/>
	<c:set var="H4" value="${pastList[3].total_score}"/>
	<c:set var="H5" value="${pastList[4].total_score}"/>
	<c:set var="H6" value="${pastList[5].total_score}"/>
	<c:set var="H7" value="${pastList[6].total_score}"/>
	<c:set var="H8" value="${pastList[7].total_score}"/>
	<c:set var="H9" value="${pastList[8].total_score}"/>
	<c:set var="H10" value="${pastList[9].total_score}"/>
	<c:set var="H11" value="${pastList[10].total_score}"/>
	<c:set var="H12" value="${pastList[11].total_score}"/>
	<c:set var="H13" value="${pastList[12].total_score}"/>
	<c:set var="H14" value="${pastList[13].total_score}"/>
	<c:set var="H15" value="${pastList[14].total_score}"/>
	<c:set var="H16" value="${pastList[15].total_score}"/>
	<c:set var="H17" value="${pastList[16].total_score}"/>
	<c:set var="H18" value="${pastList[17].total_score}"/>
	<c:set var="R1" value="${H1+H2+H3+H4+H5+H6}"/>
	<c:set var="R2" value="${H7+H8+H9+H10+H11+H12}"/>
	<c:set var="R3" value="${H13+H14+H15+H16+H17+H18}"/>
	<c:set var="T1" value="${R1+R2+R3}"/>
	<table border="1" align=center width=80% style="background-color:gray;"><tr><th>
	<details><summary>第<c:out value="${pastList[0].tour_num}"/>回ツアー（<c:out value="${pastList[0].tour_sta}"/>～<c:out value="${pastList[0].tour_fin}"/>）<c:out value="${R1+R2+R3}"/>
	</summary>
	<table border="1" align=center width=100% style="background-color: white;">
    <tr>
    <th>日付</th>
    <th>H番号</th>
    <th>コース</th>
    <th>規定打数</th>
    <th>スコア</th>
    <th>累計スコア</th>
    </tr>
    <tr>
    <td><c:out value="${pastList[0].cook_date}"/></td>
    <td><a href="">1H</a></td>
    <td><c:out value="${pastList[0].course_name}"/></td>
    <td><c:out value="${pastList[0].par}"/></td>
    <td><p>${H1}</p></td>
    <td><p>${H1}</p></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[1].cook_date}"/></td>
    <td><a href="">H2</a></td>
    <td><c:out value="${pastList[1].course_name}"/></td>
    <td><c:out value="${pastList[1].par}"/></td>
    <td><p>${H2}</p></td>
    <td><c:if test="${not empty H2}"><p>${H1+H2}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[2].cook_date}"/></td>
    <td><a href="">H3</a></td>
    <td><c:out value="${pastList[2].course_name}"/></td>
    <td><c:out value="${pastList[2].par}"/></td>
    <td><p>${H3}</p></td>
    <td><c:if test="${not empty H3}"><p>${H1+H2+H3}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[3].cook_date}"/></td>
    <td><a href="">H4</a></td>
    <td><c:out value="${pastList[3].course_name}"/></td>
    <td><c:out value="${pastList[3].par}"/></td>
    <td><p>${H4}</p></td>
    <td><c:if test="${not empty H4}"><p>${H1+H2+H3+H4}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[4].cook_date}"/></td>
    <td><a href="">H5</a></td>
    <td><c:out value="${pastList[4].course_name}"/></td>
    <td><c:out value="${pastList[4].par}"/></td>
    <td><p>${H5}</p></td>
    <td><c:if test="${not empty H5}"><p>${H1+H2+H3+H4+H5}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[5].cook_date}"/></td>
    <td><a href="">H6</a></td>
    <td><c:out value="${pastList[5].course_name}"/></td>
    <td><c:out value="${pastList[5].par}"/></td>
    <td><p>${H6}</p></td>
    <td><c:if test="${not empty H6}"><p>${R1}</p></c:if></td>
    </tr>
	<tr>
    <td></td>
    <td>R1</td>
    <td></td>
    <td></td>
    <td><c:if test="${not empty H6}"><p>${R1}</p></c:if></td>
    <td><c:if test="${not empty H6}"><p>${R1}</p></c:if></td>
    </tr>
	<tr>
    <td><c:out value="${pastList[6].cook_date}"/></td>
    <td><a href="">H7</a></td>
    <td><c:out value="${pastList[6].course_name}"/></td>
    <td><c:out value="${pastList[6].par}"/></td>
    <td><p>${H7}</p></td>
    <td><c:if test="${not empty H7}"><p>${R1+H7}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[7].cook_date}"/></td>
    <td><a href="">H8</a></td>
    <td><c:out value="${pastList[7].course_name}"/></td>
    <td><c:out value="${pastList[7].par}"/></td>
    <td><p>${H8}</p></td>
    <td><c:if test="${not empty H8}"><p>${R1+H7+H8}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[8].cook_date}"/></td>
    <td><a href="">H9</a></td>
    <td><c:out value="${pastList[8].course_name}"/></td>
    <td><c:out value="${pastList[8].par}"/></td>
    <td><p>${H9}</p></td>
    <td><c:if test="${not empty H9}"><p>${R1+H7+H8+H9}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[9].cook_date}"/></td>
    <td><a href="">H10</a></td>
    <td><c:out value="${pastList[9].course_name}"/></td>
    <td><c:out value="${pastList[9].par}"/></td>
    <td><p>${H10}</p></td>
    <td><c:if test="${not empty H10}"><p>${R1+H7+H8+H9+H10}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[10].cook_date}"/></td>
    <td><a href="">H11</a></td>
    <td><c:out value="${pastList[10].course_name}"/></td>
    <td><c:out value="${pastList[10].par}"/></td>
    <td><p>${H11}</p></td>
    <td><c:if test="${not empty H11}"><p>${R1+H7+H8+H9+H10+H11}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[11].cook_date}"/></td>
    <td><a href="">H12</a></td>
    <td><c:out value="${pastList[11].course_name}"/></td>
    <td><c:out value="${pastList[11].par}"/></td>
    <td><p>${H12}</p></td>
    <td><c:if test="${not empty H12}"><p>${R1+R2}</p></c:if></td>
    </tr>
	<tr>
    <td></td>
    <td>R2</td>
    <td></td>
    <td></td>
    <td><c:if test="${not empty H12}"><p>${R2}</p></c:if></td>
    <td><c:if test="${not empty H12}"><p>${R1+R2}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[12].cook_date}"/></td>
    <td><a href="#" id="open-dialog">13H</a></td>
    <td><c:out value="${pastList[12].course_name}"/></td>
    <td><c:out value="${pastList[12].par}"/></td>
    <td><p>${H13}</p></td>
    <td><c:if test="${not empty H13}"><p>${R1+R2+H13}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[13].cook_date}"/></td>
    <td><a href="">14H</a></td>
    <td><c:out value="${pastList[13].course_name}"/></td>
    <td><c:out value="${pastList[13].par}"/></td>
    <td><p>${H14}</p></td>
    <td><c:if test="${not empty H14}"><p>${R1+R2+H13+H14}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[14].cook_date}"/></td>
    <td><a href="">15H</a></td>
    <td><c:out value="${pastList[14].course_name}"/></td>
    <td><c:out value="${pastList[14].par}"/></td>
    <td><p>${H15}</p></td>
    <td><c:if test="${not empty H15}"><p>${R1+R2+H13+H14+H15}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[15].cook_date}"/></td>
    <td><a href="">16H</a></td>
    <td><c:out value="${pastList[15].course_name}"/></td>
    <td><c:out value="${pastList[15].par}"/></td>
    <td><p>${H16}</p></td>
    <td><c:if test="${not empty H16}"><p>${R1+R2+H13+H14+H15+H16}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[16].cook_date}"/></td>
    <td><a href="">17H</a></td>
    <td><c:out value="${pastList[16].course_name}"/></td>
    <td><c:out value="${pastList[16].par}"/></td>
    <td><p>${H17}</p></td>
    <td><c:if test="${not empty H17}"><p>${R1+R2+H13+H14+H15+H16+H17}</p></c:if></td>
    </tr>
    <tr>
    <td><c:out value="${pastList[17].cook_date}"/></td>
    <td><a href="">18H</a></td>
    <td><c:out value="${pastList[17].course_name}"/></td>
    <td><c:out value="${pastList[17].par}"/></td>
    <td><p>${H18}</p></td>
    <td><c:if test="${not empty H18}"><p>${R1+R2+R3}</p></c:if></td>
    </tr>
	<tr>
    <td></td>
    <td>R3</td>
    <td></td>
    <td></td>
    <td><c:if test="${not empty H18}"><p>${R3}</p></c:if></td>
    <td><c:if test="${not empty H18}"><p>${R1+R2+R3}</p></c:if></td>
    </tr>
    <tr>
    <td></td>
    <td>最終成績</td>
    <td></td>
    <td></td>
    <td></td>
    <td><c:if test="${not empty H18}"><p>${R1+R2+R3}</p></c:if></td>
    </tr>
	</table>
	</details></th></tr></table>
	</c:forEach>
	<div class="dialog-overlay" id="dialog-overlay"><div class="dialog-box">
		<div class="dia" align=center>
		2024年6月18日 第2回ツアー 2R13H par5<br>
		<h4>スコア -1 バーディ</h4>
		<img src="${pageContext.request.contextPath}/img/yasaita.jpg" width=50% height=50%><br>
		<h4>豚野菜味噌炒め</h4>
		▼スコア詳細
		<table align=center>
		<tr><td>調理時間</td>
		<td><c:out value="${scoreList[0].total_score}"/></td>
		<td>±0</td></tr>
		<tr><td>使用食材</td>
		<td>豚肉</td>
		<td>±0</td></tr>
		<tr><td></td>
		<td>キャベツ</td>
		<td>±0</td></tr>
		<tr><td></td>
		<td>もやし</td>
		<td>±0</td></tr>
		<tr><td></td>
		<td>人参</td>
		<td>+1</td></tr>
		<tr><td></td>
		<td>ピーマン</td>
		<td>+1</td></tr>
		<tr><td></td>
		<td>きくらげ</td>
		<td>+1</td></tr>
		<tr><td>使用調味料</td>
		<td>味噌</td>
		<td>±0</td></tr>
		<tr><td></td>
		<td>砂糖</td>
		<td>±0</td></tr>
		<tr><td>調理満足度</td>
		<td>☆☆☆</td>
		<td>±0</td></tr>
		<tr><td>味満足度</td>
		<td>☆☆☆</td>
		<td>±0</td></tr>
		<tr><td>規定打数</td>
		<td>par5</td>
		<td>-4</td></tr>
		<tr><td>------------</td>
		<td>----------</td>
		<td>-----</td></tr>
		<tr><td>総合評価</td>
		<td></td>
		<td>-1</td></tr>
		</table><br><br>
		<textarea readonly>コメント</textarea><br>
		</div>
    	<p><a href="#" id="close-dialog">閉じる</a></p>
  	</div></div>
</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
  // ダイアログを開くリンクの処理
  document.getElementById('open-dialog').addEventListener('click', function(event) {
    event.preventDefault();
    document.getElementById('dialog-overlay').style.display = 'block';
  });

  // ダイアログを閉じるリンクの処理
  document.getElementById('close-dialog').addEventListener('click', function(event) {
    event.preventDefault();
    document.getElementById('dialog-overlay').style.display = 'none';
  });

  // エスケープキーでダイアログを閉じる処理
  document.addEventListener('keydown', function(event) {
    if (event.key === 'Escape') {
      document.getElementById('dialog-overlay').style.display = 'none';
    }
  });
</script>
<script>
    // JSPからH1からH18の値を取得（すでに定義されていると仮定）
    var tValues = [
        ${T1},${T2},${T3},${T4},${T5},${T6},${T7},${T8},${T9},${T10}
    ];

    // Chart.jsを使って折れ線グラフを描画する
    var ctx = document.getElementById('lineChart').getContext('2d');
    var lineChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ['T1','T2','T3','T4','T5','T6','T7','T8','T9','T10'],
            datasets: [{
                label: 'スコア',
                data: tValues,
                borderColor: 'rgba(75, 192, 192, 1)', // 必要に応じて色をカスタマイズ
                borderWidth: 2,
                fill: false
            }]
        },
        options: {responsive: true,
            plugins: {legend:
            	{display: false}
            },
            scales:{
            	x:{
            		title:{
            			display: true,
                     	text: 'ツアー'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: 'スコア'
                    }
                }
            }
        }
    });
</script>
</html>