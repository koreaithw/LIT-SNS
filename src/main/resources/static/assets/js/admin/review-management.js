let chartResult;
$(document).ready(function(){
    chartData();
    
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
        labels: getDateInfo(),
        data: chartResult,
    });
})
window.onload = function () {
    sideAni(); //사이드바 애니메이션 side-bar.js
    $(".menu-box").eq(4).addClass("menu-box__select");
};






//================================ ajax =========================================

function searchReview() {
    $(".list-table tr:not(.table-head)").html("");
    adminService.searchReview({
        startDate: $("input[name='startDate']").val(),
        endDate: $("input[name='endDate']").val(),
        type: $("select[name='type']").val(),
        keyword: $("input[name='keyword']").val(),
        category: $("select[name='category']").val(),
        status: $("input[name='status']:checked").val()
    }, function (result) {
        $(".searchResult").text(result.length);
        let str = "";
        result.forEach(function(review, i){
            str +=
                "<tr>\n" +
                "<td class=\"list-checkbox\">" +
                "<input type=\"checkbox\" value=\"" + review.reviewNumber + "\" />" +
                "</td>\n" +
                "<td class=\"review-number\">" + review.reviewNumber + "</td>" +
                "<td class=\"user-number\">" + review.userNumber + "</td>\n" +
                "<td class=\"user-email\">" + review.email + "</td>" +
                "<td class=\"project-view\">" +
                "<div>" +
                "<a class=\"a-btn not-selected\" href=\"\">보기</a>" +
                "</div>" +
                "</td>" +
                "<td class=\"project-number\">" + review.projectNumber + "</td>" +
                "<td class=\"project-category\">" + renameCategory(review.category) + "</td>" +
                "<td class=\"project-status\">" + renameStatus(review.status) + "</td>" +
                "<td class=\"project-register-date\">" +
                review.registerDate +
                "</td>" +
                "</tr>"
        })
        $(".list-table > tbody").append(str);

    })
}

//삭제하기
let deleteReview = function (){
    let $checked = $(".list-checkbox > input[type='checkbox']:checked");
    let list = [];

    $checked.each((i, box) => {
        list.push(box.value);
    });

    adminService.deleteReview(list.join(","), function(){
        searchReview();
    })
}

// 삭제 버튼 이벤트 ==========================================
//checkAlert() 는 admin-common.js 에 정의됨
//매개변수에 실행시킬 함수 콜백함수로 넘겨서 사용하기 -> checkAlert("msg", function(){......})
$(".delete-btn").on("click", function () {
    checkAlert("정말로 삭제하시겠습니까?", deleteReview);
});

//차트=====

function chartData(){
    chartService.reviewChartData(function(result){
        chartResult = result;
    })
}
















