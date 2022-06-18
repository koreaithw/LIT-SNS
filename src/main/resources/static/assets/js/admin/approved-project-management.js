// $(document).ready(function () {
//   $(".side-bar").load("/templates/admin/side-bar.html");
// });

window.onload = function () {
  sideAni(0); //사이드바 애니메이션 side-bar.js
  $(".menu-box").eq(3).addClass("menu-box__select");
};

// 체크박스 이벤트 ==========================================
$(".check-all").change(function () {
  let $allBox = $(this).is(":checked");
  let $otherBox = $(".list-checkbox > input[type='checkbox']");
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
  let $startInput = $("input[name='startDate']");
  let $endInput = $("input[name='endDate']");
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

//================================ ajax =========================================
//가져온 상태 값 수정하기
function renameStatus(status){
  let result;
  switch (status) {
    case 0:
      result = "대기중";
      break;
    case 1:
      result = "진행중";
      break;
    case 2:
      result = "완료";
      break;
  }
  return result;
}

//삭제하기
let deleteProject = function deleteProject(){
  let $checked = $(".list-checkbox > input[type='checkbox']:checked");
  let list = [];
  $checked.each((i, box) => {
    list.push(box.value);
  });

  adminService.deleteProject(list.join("-"), function(){
    searchProject();
  })
}

//검색하기
function searchProject() {
  $(".list-table tr:not(.table-head)").html("");
  console.log( $("input[name='status']:checked").val())

  adminService.searchProject({
    startDate: $("input[name='startDate']").val(),
    endDate: $("input[name='endDate']").val(),
    type: $("select[name='type']").val(),
    keyword: $("input[name='keyword']").val(),
    category: $("select[name='category']").val(),
    status : $("input[name='status']:checked").val()
  }, function (result) {
    //검색 결과 건수
    $(".searchResult").text(result.length);

    //결과 리스트 처리
    result.forEach(function (project, i) {
      let str = "";

      str +=
          "<tr>" +
          "<td class=\"list-checkbox\">" +
          "<input type=\"checkbox\" value=\"" + project.projectNumber + "\" />" +
          "</td>" +
          "<td class=\"project-number\">" + project.projectNumber + "</td>" +
          "<td class=\"project-category\">" + project.category + "</td>" +
          "<td class=\"project-title\">" + project.title + "</td>" +
          "<td class=\"project-view\">" +
          "<div>" +
          "<a class=\"a-btn not-selected\" href=\"\">보기</a>" +
          "</div>" +
          "</td>" +
          "<td class=\"user-email\">" + project.userNumber + "</td>" +
          "<td class=\"project-join-cnt\">" + "구현필요" + "</td>" +
          "<td class=\"project-apply-cnt\">" + project.applyCount + "</td>" +
          "<td class=\"project-start-date\">" +
          project.startDate +
          "</td>" +
          "<td class=\"project-status\">" + renameStatus(project.status) + "</td>" +
          "</tr>"
      $(".list-table > tbody").append(str);
    })
  });
}

// 삭제 버튼 이벤트 ==========================================
//checkAlert() 는 admin-common.js 에 정의됨
//매개변수에 실행시킬 함수 콜백함수로 넘겨서 사용하기 -> checkAlert("msg", function(){......})
$(".delete-btn").on("click", function () {
  checkAlert("정말로 삭제하시겠습니까?", deleteProject);
});