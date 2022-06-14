// $(document).ready(function () {
//   $(".side-bar").load("/templates/admin/side-bar.html");
// });

window.onload = function () {
  sideAni(); //사이드바 애니메이션 side-bar.js
  $(".menu-box").eq(4).addClass("menu-box__select");

  // ====== 차트 ======
  //makechart 메소드는 admin-common.js에 정의되어 있음

  //makechart("domId", myData)
  //domId는 그래프를 꽂을 요소의 id (설정완료)
  //myData는 객체이며 필요 프로퍼티는 label, labels, data (아래는 예시, 설정필요)

  //DB에서 가져온 값을 넘겨줘야함 각 프로퍼티별 타입은 아래와 같음
  //label : String, labels : Array, data : Array
  //label은 그래프 상단의 라벨
  //labels는 x축 데이터
  //data는 그래프에 그려질 값
  makechart("chart__review", {
    label: "최근 작성된 프로젝트",
    labels: ["06.07", "06.08", "06.09", "06.10", "06.11", "06.12", "06.13"],
    data: [0, 4, 7, 17, 22, 14, 20],
  });
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
  console.log($input);
  $input.trigger("focus");
});
