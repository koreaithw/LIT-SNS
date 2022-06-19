$(document).ready(function () {
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
    // makechart("chart__project", {
    //     label: "최근 작성된 프로젝트",
    //     labels: ["06.07", "06.08", "06.09", "06.10", "06.11", "06.12", "06.13"],
    //     data: [0, 4, 7, 17, 22, 14, 20],
    // });
});

window.onload = function () {
    sideAni(0); //사이드바 애니메이션 side-bar.js
    $(".menu-box").eq(2).addClass("menu-box__select");
};





//================================ ajax =========================================

//검색하기
function searchProject() {
    $(".list-table tr:not(.table-head)").html("");

    adminService.searchProject({
        startDate: $("input[name='startDate']").val(),
        endDate: $("input[name='endDate']").val(),
        type: $("select[name='type']").val(),
        keyword: $("input[name='keyword']").val(),
        category: $("select[name='category']").val(),
        status: 0
    }, function (result) {
        //검색 결과 건수
        $(".searchResult").text(result.length);

        //결과 리스트 처리
        result.forEach(function (project, i) {
            let str = "";

            str +=
                "<tr>\n" +
                "<td class=\"list-checkbox\">" +
                "<input type=\"checkbox\" value=\"" + project.projectNumber + "\"/>" +
                "</td>\n" +
                "<td class=\"project-number\">" + project.projectNumber + "</td>" +
                "<td class=\"project-category\">" + renameCategory(project.category) + "</td>" +
                "<td class=\"project-title\">" + project.title + "</td>" +
                "<td class=\"user-email\">" + project.email + "</td>" +
                "<td class=\"project-preview\">" +
                "<!-- 미리보기 경로 -->" +
                "<div>" +
                "<a class=\"a-btn not-selected\" href=\"\">미리보기</a>" +
                "</div>" +
                "</td>" +
                "<td class=\"project-start-date\">" + project.startDate + "</td>" +
                "<td class=\"project-end-date\">" + project.endDate + "</td>" +
                "<td class=\"project-status\">" + renameStatus(project.status) + "</td>" +
                "</tr>";
            $(".list-table > tbody").append(str);
        })
    });
}

//삭제하기
let deleteProject = function () {
    let $checked = $(".list-checkbox > input[type='checkbox']:checked");
    let list = [];
    $checked.each((i, box) => {
        list.push(box.value);
    });

    adminService.deleteProject(list.join(","), function () {
        searchProject();
    })
}

//승인하기
let changeStatus = function () {
    let $checked = $(".list-checkbox > input[type='checkbox']:checked");
    let list = [];
    $checked.each((i, box) => {
        list.push(box.value);
    });

    adminService.changeStatus({
        projectNumber: list.join(","),
        status: 1
    }, function () {
        searchProject();
    })
}
// 삭제 버튼 이벤트 ==========================================
//checkAlert() 는 admin-common.js 에 정의됨
//매개변수에 실행시킬 함수 콜백함수로 넘겨서 사용하기 -> checkAlert("msg", function(){......})
$(".delete-btn").on("click", function () {
    checkAlert("정말로 삭제하시겠습니까?", deleteProject);
});

$(".approval-btn").on("click", function () {
    checkAlert("해당 프로젝트를 승인하시겠습니까?", changeStatus);
});