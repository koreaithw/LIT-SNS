// 뉴 방식
let now = 0;
let ani = 0;
let len = $("._ad_wrapper>img").length;

$("._ad_wrapper>img").css({"left": "-100%", "z-index": "0"}).eq(now).css({"left": "0%", "z-index": "1"});

function slide() {
    ani = (now + 1) == len ? 0 : now + 1;

    $("._ad_wrapper>img").eq(now).css({"z-index": "0"});
    $("._ad_wrapper>img").eq(ani).css({"left": "0%", "z-index": "1"});
    setTimeout(function () {
        $("._ad_wrapper>img").eq(now).css({"left": "-100%"});
        now = ani;
    }, 1000);
}

function start() {
    setInterval(function () {
        slide()
    }, 3000);
}

start();


window.onload = function () {
    $("._icon_profile").on("click", function () {
        headerAction();
    });
};
$(document).ready(function () {

    $("#header").load("/src/main/resources/templates/header.html")
    $("#footer").load("/src/main/resources/templates/footer.html")

    //윈도우 스크롤 이벤트 발생시켜서 리스트 사진 뿌려줌
    //함수를 직접 실행 시키면 page증가가 없어서 1페이지가 중복됨
    $(window).trigger("scroll");

})


// ####################################################

const lit1 = $('#lits1');
const lit2 = $('#lits2');

// lit Up LITS 버튼 액션
lit1.on("click", function () {
    // color: rgb(142, 142, 142); 검은색
    lit1.attr('class', 'lits1On');
    $('#lit1Img').attr('src', '/images/mypage/menu.png');
    lit2.attr('class', 'lits2Off');
    $('#lit2Img').attr('src', '/images/mypage/fire.png');
    $(".photoContents > div").html("");
    //lits 탭메뉴 클릭 시 페이지 초기화
    page = 1;
    //윈도우 스크롤 이벤트 발생시켜서 리스트 사진 뿌려줌
    //함수를 직접 실행 시키면 page증가가 없어서 1페이지가 중복됨
    $(window).trigger("scroll");
});

lit2.on("click", function () {
    // color: rgb(142, 142, 142); 검은색
    lit2.attr('class', 'lits2On');
    $('#lit2Img').attr('src', '/images/mypage/lists.png');
    lit1.attr('class', 'lits1Off');
    $('#lit1Img').attr('src', '/images/mypage/menu2.png');
    $(".photoContents > div").html("");
    //lits 탭메뉴 클릭 시 페이지 초기화
    page = 1;
    //윈도우 스크롤 이벤트 발생시켜서 리스트 사진 뿌려줌
    //함수를 직접 실행 시키면 page증가가 없어서 1페이지가 중복됨
    $(window).trigger("scroll");
});


//스크롤 이벤트
let timer;
let page = 1;
$(window).scroll(function () {
    // 현 스크롤 탑의 위치
    let windowTop = $(window).scrollTop();
    // 변화될 아이
    let contentHeight = $(".photoContents").height();
    // 창의 전체 높이
    let windowHeight = $(window).height();


    // 스크롤이 마지막 이면 데이터 가져오기
    if (windowTop > (contentHeight - windowHeight)) {
        // 스크롤 맨 아래
        if (timer) {
            clearTimeout(timer);
        }
        timer = setTimeout(() => {
            // ajax 실행
            if (lit1.hasClass('lits1On')) {
                getLitUpList(page);
            } else if (lit2.hasClass('lits2On')) {
                getLitList(page);
            }
            page += 1;
        }, 500);

    } else {
    }
});


// function pageBlock(total) {
//     let endPage = Math.ceil(page / 6.0) * 6;
//     let startPage = endPage - 9;
//     let realEnd = Math.ceil(total / 6.0);
//     const $paging = $(".paging-block");
//
//     if (endPage > realEnd) {
//         endPage = realEnd;
//     }
//
//     let prev = startPage > 1;
//     let next = endPage * 10 < total;
//     let str = "";
//
//     if (prev) {
//         str += "<a class='changePage' href='" + (startPage - 1) + "'><li>&lt;</li></a>"
//     }
//     for (let i = startPage; i <= endPage; i++) {
//         str += page == i ? "<li>" + i + "</li>" : "<a class='changePage' href='" + i + "'><li>" + i + "</li></a>";
//     }
//     if (next) {
//         str += "<a class='changePage' href='" + (endPage + 1) + "'><li>&gt;</li></a>"
//     }
//     $paging.html(str);
// }


let getLitUpList = function (page) {
    mainService.mainLitUp({
        order: "new",
        pageNum: page
    }, function (result) {
        let str = "";
        // $(".photoContents > div").html("");
        result.forEach((data, i) => {
            let file = data.reviewFileList;
            if (file[0]) {
                str +=
                    "<figure>" +
                    "<a href=\"" + data.reviewNumber + "\">" +
                    "<img alt=\"\" src=\"/litUp/display?fileName=" + file[0].uploadPath + "/" + file[0].uuid + "_" + file[0].name + "\">" +
                    "</a>" +
                    "</figure>";
            }
        })
        $(".photoContents > div").append(str);
    })
}

let getLitList = function (page) {
    mainService.mainLit({
        order: "new",
        pageNum: page
    }, function (result) {
        let str = "";
        // $(".photoContents > div").html("");
        result.forEach((data, i) => {
            let file = data.projectFile;
            if (file) {
                str +=
                    "<figure>" +
                    "<a href=\"" + data.projectNumber + "\">" +
                    "<img alt=\"\" src=\"/lit/display?fileName=" + file.uploadPath + "/" + file.uuid + "_" + file.name + "\">" +
                    "</a>" +
                    "</figure>";
            }
        })
        $(".photoContents > div").append(str);

    })
}


let mainService = (function () {
    function mainLitUp(info, callback, error) {
        $.ajax({
            url: "/litUp/getMainList",
            type: "post",
            data: JSON.stringify(info),
            contentType: "application/json",
            dataType: "json",
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        })
    }

    function mainLit(info, callback, error) {
        $.ajax({
            url: "/lit/getMainList",
            type: "post",
            data: JSON.stringify(info),
            contentType: "application/json",
            dataType: "json",
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        })
    }


    return {
        mainLit: mainLit,
        mainLitUp: mainLitUp
    };
})();