$(document).ready(function () {
  $(".side-bar").load("/src/main/resources/templates/admin/side-bar.html");
});

window.onload = function () {
  sideAni(0); //사이드바 애니메이션 side-bar.js
  $(".menu-box").eq(3).addClass("menu-box__select");
};

// 체크박스 이벤트 ==========================================
$(".check-all").change(function () {
  $allBox = $(this).is(":checked");
  $otherBox = $(".list-checkbox > input[type='checkbox']");
  if ($allBox) {
    $otherBox.prop("checked", true);
  } else {
    $otherBox.prop("checked", false);
  }
});

$(".list-checkbox > input[type='checkbox']").change(function () {
  if (!$(this).is(":checked")) {
    $(".check-all").prop("checked", false);
  }
});

// 버튼 이벤트 ==========================================
//checkAlert() 는 admin-common.js 에 정의됨
//매개변수에 실행시킬 함수 콜백함수로 넘겨서 사용하기 -> checkAlert("msg", function(){......})

$(".delete-btn").on("click", function () {
  checkAlert("정말로 삭제하시겠습니까?");
});
// ========================================================

//기간 버튼
$(".a-btn").on("click", function (e) {
  e.preventDefault();
  if ($(this).hasClass("not-selected")) {
    return;
  }
  $(".period-button-wrap > .a-btn").removeClass("a-btn__selected");
  $(this).addClass("a-btn__selected");

  //기간 버튼 클릭시 input에 자동 삽입
  let $startInput = $("input[name='start-date']");
  let $endInput = $("input[name='end-date']");
  let val = $(this).attr("href");

  //전체 버튼 선택시 공백으로 바꾸기
  if (val == "") {
    $startInput.val("");
    $endInput.val("");
    return;
  }

  let todayObj = new Date();
  let dateResult = new Date(
    todayObj.getTime() + 1000 * 60 * 60 * 24 * parseInt(val)
  );
  let year = dateResult.getFullYear();
  let month = dateResult.getMonth() + 1;
  let date = dateResult.getDate();

  let resultDateAr = [
    year,
    (month < 10 ? "0" : "") + month,
    (date < 10 ? "0" : "") + date,
  ];

  $startInput.val(
    [
      todayObj.getFullYear(),
      (todayObj.getMonth() + 1 < 10 ? "0" : "") + (todayObj.getMonth() + 1),
      (todayObj.getDate() < 10 ? "0" : "") + todayObj.getDate(),
    ].join("-")
  );
  $endInput.val(resultDateAr.join("-"));
});

//date picker
$(function () {
  $(".datepicker").datepicker();
});

$(".calendar-icon-wrap").on("click", function () {
  $input = $(this).prev("div").find("input");
  $input.trigger("focus");
});
