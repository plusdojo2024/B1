/**
 *
 */

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




