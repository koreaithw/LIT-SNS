// 사이드바를 넣어줌
// html작업이라 어쩔 수 없이 jquery로 넣었는데 나중에 수정해야 할 수 있음
$(document).ready(function () {
  $(".side-bar").load("/src/main/resources/templates/admin/side-bar.html");
});

window.onload = function () {
  sideAni(3); //사이드바 애니메이션 side-bar.js
  $(".menu-box").eq(0).addClass("menu-box__select");
};
