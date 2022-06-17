// 사이드바를 넣어줌
// html작업이라 어쩔 수 없이 jquery로 넣었는데 나중에 수정해야 할 수 있음
// $(document).ready(function () {
//   $(".side-bar").load("/templates/admin/side-bar.html");
// });

window.onload = function () {
    sideAni(3); //사이드바 애니메이션 side-bar.js
    $(".menu-box").eq(0).addClass("menu-box__select");

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

    makechart("chart__recent", {
        label: "최근 가입한 회원",
        labels: ["06.07", "06.08", "06.09", "06.10", "06.11", "06.12", "06.13"],
        data: [0, 4, 10, 7, 5, 11, 10],
    });
    makechart("chart__complete", {
        label: "달성률 예시",
        labels: ["06.07", "06.08", "06.09", "06.10", "06.11", "06.12", "06.13"],
        data: [100, 77, 65, 85, 70, 55, 80],
    });
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
        todayObj.getTime() - 1000 * 60 * 60 * 24 * parseInt(val)
    );
    let year = dateResult.getFullYear();
    let month = dateResult.getMonth() + 1;
    let date = dateResult.getDate();

    let resultDateAr = [
        year,
        (month < 10 ? "0" : "") + month,
        (date < 10 ? "0" : "") + date,
    ];

    $endInput.val(
        [
            todayObj.getFullYear(),
            (todayObj.getMonth() + 1 < 10 ? "0" : "") + (todayObj.getMonth() + 1),
            (todayObj.getDate() + 1 < 10 ? "0" : "") + todayObj.getDate(), //DB조회시 + 1을 해야 오늘의 24 전까지도 포함됨
        ].join("-")
    );
    $startInput.val(resultDateAr.join("-"));
});

//date picker
// $(function () {
//   $(".datepicker").datepicker({
//
//   });
// });

$(function () {
    let $startDate = $("input[name=startDate]");
    let $endDate = $("input[name=endDate]");

    $(".datepicker").datepicker({
        showAnim: "slide",
        dateFormat: 'yy-mm-dd'
    })

    $endDate.datepicker('option', 'minDate', $startDate.val());
    $startDate.datepicker("option", "onClose", function (selectedDate) {
        $endDate.datepicker("option", "minDate", selectedDate);
    });

    $endDate.datepicker();
    $endDate.datepicker("option", "minDate", $startDate.val());
    $endDate.datepicker("option", "onClose", function (selectedDate) {
        $startDate.datepicker("option", "maxDate", selectedDate);
    });
});


$(".calendar-icon-wrap").on("click", function () {
    let $input = $(this).prev("div").find("input");
    $input.trigger("focus");
});


//================================ ajax =========================================

//검색하기
function searchUser() {
    $(".list-table tr:not(.table-head)").html("");

    adminService.searchUser({
        startDate: $("input[name='startDate']").val(),
        endDate: $("input[name='endDate']").val(),
        type: $("select[name='type']").val(),
        keyword: $("input[name='keyword']").val(),
        kakao: $("input[name='kakao']:checked").val()
    }, function (result) {
        //검색 결과 건수
        $(".searchResult").text(result.length);

        //결과 리스트 처리
        result.forEach(function (user, i) {
            let str = "";
            str += " <tr>" +
                "<td class=\"list-checkbox\">" +
                "<input type=\"checkbox\" value=\"" + user.userNumber + "\" />" +
                "</td>\n" +
                "<td class=\"user-name\">" + user.name + "</td>" +
                "<td class=\"user-email\">" + user.email + "</td>" +
                "<td class=\"user-nickname\">" + user.nickname + "</td>" +
                "<td class=\"user-kakao\">" + (user.kakao ? user.kakao : "")  + "</td>" +
                "<td class=\"user-status\">" + user.registerDate + "</td>" +
                "</tr>"
            $(".list-table > tbody").append(str);
        })
    });
}

//삭제하기
let deleteUser = function deleteUser(){
    let $checked = $(".list-checkbox > input[type='checkbox']:checked");
    let list = [];
    $checked.each((i, box) => {
        list.push(box.value);
    });

    adminService.deleteUser(list.join("-"), function(){
        searchUser();
    })

}
// 삭제 버튼 이벤트 ==========================================
//checkAlert() 는 admin-common.js 에 정의됨
//매개변수에 실행시킬 함수 콜백함수로 넘겨서 사용하기 -> checkAlert("msg", function(){......})
$(".delete-btn").on("click", function () {
    checkAlert("정말로 삭제하시겠습니까?", deleteUser);
});



