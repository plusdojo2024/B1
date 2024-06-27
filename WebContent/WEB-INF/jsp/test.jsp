<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイマーの修正</title>
<style type="text/css">
  .button {
    background: lightblue;
    width: 100%;
    height: 100%;
    font-size: 45px;
    border-radius: 5px;
    font-weight: 900;
    position: relative;
    font-family: serif;
  }

  .modal {
    display: none;
    position: fixed;
    z-index: 1;
    height: 100%;
    width: 100%;
    overflow: auto;
    background-color: rgba(255, 255, 255, 1);
  }

  .modal-content {
    background-color: #000000;
    width: 100%;
    height: 100%;
    animation-name: modalopen;
    animation-duration: 1s;
  }

  .modalClose:hover {
    cursor: pointer;
  }
</style>
</head>
<body>

<div id="StartModal" class="modal">
  <div class="modal-content">
    <button class="modalClose button">始める</button>
  </div>
</div>

<p id="countdown"></p>
<!--
<script>
  const modal = document.getElementById('StartModal');

  window.onload = function(){
    modal.style.display = 'block';
  }

  const buttonClose = document.getElementsByClassName('modalClose')[0];

  // 始めるがクリックされた時
  buttonClose.addEventListener('click', modalClose);
  function modalClose() {

    modal.style.display = 'none';

    var duration = 10000; // 15分をミリ秒で表したもの
    startCountdown(duration)

    let now = new Date();
    let hours = now.getHours().toString().padStart(2, '0');
    let minutes = now.getMinutes().toString().padStart(2, '0');
    let seconds = now.getSeconds().toString().padStart(2, '0');

    let timeString = hours + ':' + minutes + ':' + seconds;

    document.getElementById('cook_sta').value = timeString;
  }

  // モーダルコンテンツ以外がクリックされた時
  addEventListener('click', outsideClose);
  function outsideClose(e) {
    if (e.target == modal) {
      modal.style.display = 'none';
    }
  }

  // カウントダウン関数
  function startCountdown(duration) {
  var timer = duration;
  setInterval(function () {
	  var milliseconds = timer % 1000; // ミリ秒部分を取得
	    milliseconds = Math.floor(milliseconds / 10); // ミリ秒の末尾の1桁を削除
    var seconds = Math.floor((timer / 1000) % 60);
    var minutes = Math.floor((timer / 1000 / 60) % 60);

    // ミリ秒を3桁で表示するためのフォーマット
    var formattedMilliseconds = ('00' + milliseconds).slice(-2);

    // idが"countdown"の要素にカウントダウンタイマーを表示
    document.getElementById('countdown').textContent = minutes + "分 " + seconds + "秒 " + formattedMilliseconds + "ミリ秒 ";

    	timer = timer - 10;

    if (timer < 0) {
    	document.getElementById('countdown').textContent = "??分 ??秒";
    }

  }, 10);
}



</script>
 -->



<div>
  調理時間は「${play[0]}」<br>
  必須の肉は「${play[1]}」<br>
  必須の野菜は「${play[2]}」<br>
  必須の野菜は「${play[3]}」<br>
  お助け調味料は「${play[4]}」<br>
  お助け食材はは「${play[5]}」<br>
  FREE調味料は「${play[6]}」<br>
  必須調味料は「${play[7]}」<br>
  必須調味料は「${play[8]}」<br>
  禁止調味料は「${play[9]}」<br>
  禁止調味料は「${play[10]}」<br>

  <form method="post" action="/B1/SetPlayingConditionsServlet" enctype="multipart/form-data" id="cook">
    <input type="file" name="image" accept="image/*" class="required" required>
    <input type="text" name="cook_sta" id="cook_sta">
    <input type="submit" name="regist" value="登録" id="submit"><br>
  </form>
</div>
 <script src="./js/test.js"></script>
</body>
</html>
