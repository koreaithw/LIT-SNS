// $(document).ready(function () {
//
// });

window.onload = function () {
  sideAni(0); //사이드바 애니메이션 side-bar.js
  $(".menu-box").eq(3).addClass("menu-box__select");
};



// ========================================================



//================================ ajax =========================================

//삭제하기
let deleteProject = function (){
  let $checked = $(".list-checkbox > input[type='checkbox']:checked");
  let list = [];
  $checked.each((i, box) => {
    list.push(box.value);
  });

  adminService.deleteProject(list.join(","), function(){
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
    let str = "";
    result.forEach(function (project, i) {
      str +=
          "<tr>" +
          "<td class=\"list-checkbox\">" +
          "<input type=\"checkbox\" value=\"" + project.projectNumber + "\" />" +
          "</td>" +
          "<td class=\"project-number\">" + project.projectNumber + "</td>" +
          "<td class=\"project-category\">" + renameCategory(project.category) + "</td>" +
          "<td class=\"project-title\">" + project.title + "</td>" +
          "<td class=\"project-view\">" +
          "<div>" +
          "<a class=\"a-btn not-selected\" href=\"\">보기</a>" +
          "</div>" +
          "</td>" +
          "<td class=\"user-email\">" + project.email + "</td>" +
          "<td class=\"project-join-cnt\">" + (project.participationCount != null ? project.participationCount : 0) + "</td>" +
          "<td class=\"project-apply-cnt\">" + project.applyCount + "</td>" +
          "<td class=\"project-start-date\">" +
          project.startDate +
          "</td>" +
          "<td class=\"project-status\">" + renameStatus(project.status) + "</td>" +
          "</tr>"
    })
    $(".list-table > tbody").append(str);
  });
}

// 삭제 버튼 이벤트 ==========================================
//checkAlert() 는 admin-common.js 에 정의됨
//매개변수에 실행시킬 함수 콜백함수로 넘겨서 사용하기 -> checkAlert("msg", function(){......})
$(".delete-btn").on("click", function () {
  checkAlert("정말로 삭제하시겠습니까?", deleteProject);
});