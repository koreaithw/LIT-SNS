$(document).ready(function () {
  $(".side-bar").load("/src/main/resources/templates/admin/side-bar.html");
});

window.onload = function () {
  sideAni(0); //사이드바 애니메이션 side-bar.js
  $(".menu-box").eq(3).addClass("menu-box__select");
};

//기간 버튼
$(".a-btn").on("click", function (e) {
  e.preventDefault();
  $(".period-button-wrap > .a-btn").removeClass("a-btn__selected");
  $(this).addClass("a-btn__selected");
});

//date picker
$(function () {
  $(".datepicker").datepicker();
});

$(".calendar-icon-wrap").on("click", function () {
  $input = $(this).prev("div").find("input");
  console.log($input);
  $input.trigger("focus");
});
