<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>料理の一覧</title>
<link rel="stylesheet" href="/B1/css/cooklist.css">
<p>料理の一覧</p>
</head>
<body>
  <!-- モーダルを開くボタン -->
<button class="modal-open js-modal-open">モーダルを開く</button>

<!-- モーダル本体 -->
<div class="modal js-modal">
  <div class="modal-container">
    <!-- モーダルを閉じるボタン -->
    <div class="modal-close js-modal-close">×</div>
    <!-- モーダル内部のコンテンツ -->
    <div class="modal-content">
      <p>開きました。</p>
    </div>
  </div>
</div>
<c:forEach var="e" items="${cardList}">

<!--  ${e.cook_img}<br>-->
<img class="img-pc" src="/B1/img/cook.png"><br>
${e.cook_num}
${e.cook_name}<br>
${e.cook_time}<br>
${e.cook_sta}<br>
${e.cook_fin}<br>
${e.food_con}<br>
${e.food_used}<br>
${e.seas_con}<br>
${e.seas_used}<br>
${e.cook_satis}<br>
${e.aji_satis}<br>
${e.cook_fav}<br>
${e.cook_com}<br>

</c:forEach>
 <script src="cooklist.js">const buttonOpen = document.getElementById('modalOpen');
 const modal = document.getElementById('easyModal');
 const buttonClose = document.getElementsByClassName('modalClose')[0];

 // ボタンがクリックされた時
 buttonOpen.addEventListener('click', modalOpen);
 function modalOpen() {
   modal.style.display = 'block';
 }

 // バツ印がクリックされた時
 buttonClose.addEventListener('click', modalClose);
 function modalClose() {
   modal.style.display = 'none';
 }

 // モーダルコンテンツ以外がクリックされた時
 addEventListener('click', outsideClose);
 function outsideClose(e) {
   if (e.target == modal) {
     modal.style.display = 'none';
   }
 }</script>
</body>
</html>