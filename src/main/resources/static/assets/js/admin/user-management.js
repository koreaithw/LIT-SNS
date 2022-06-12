// 사이드바를 넣어줌
// html작업이라 어쩔 수 없이 jquery로 넣었는데 나중에 수정해야 할 수 있음
$(document).ready(function () {
  $(".side-bar").load("/src/main/resources/templates/admin/side-bar.html");
});

window.onload = function () {
  sideAni(3); //사이드바 애니메이션 side-bar.js
  $(".menu-box").eq(0).addClass("menu-box__select");
};

// 체크박스 이벤트 ==========================================
$(".check-all").change(function () {
  $allBox = $(this).is(":checked");
  $otherBox = $(".list-checkbox > input[type='checkbox']");
  console.log($otherBox);
  if ($allBox) {
    $otherBox.prop("checked", true);
  } else {
    console.log("in");
    $otherBox.prop("checked", false);
  }
});

$(".list-checkbox > input[type='checkbox']").change(function () {
  if (!$(this).is(":checked")) {
    console.log("change list-checkbox");
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
