let $contentIn = $('.content > div');

//메세지 인풋 창에서 엔터키입력
$('.messageWrite').on('keyup', function (key) {
    let sendUserNumber = 1; // 채팅방 들어올 때 받아오기
    let receiveUserNumber = 10; // 채팅방 들어올 때 받아오기
    let room = "3번방"; // 채팅방 들어올 때 받아오기
    let content = $('.messageWrite').val();

    if (key.keyCode == 13) {

        messageService.send({
            sendUserNumber: sendUserNumber,
            receiveUserNumber: receiveUserNumber,
            room: room,
            content: content
            // });

            // 하나씩 뿌려줄때
        }, function (result) {
            let message = "<div class=\"dmStyle1\">" +
                "<div class=\"dmImg\">" +
                "<img src=\"\" alt=\"\">" +
                "</div>" +
                "<div class=\"text\">" +
                result.content +
                "</div>" +
                "</div>"
            $contentIn.append(message);
        });

        let message = "<div class=\"dmStyle1\">" +
            "<div class=\"dmImg\">" +
            "<img src=\"\" alt=\"\">" +
            "</div>" +
            "<div class=\"text\">" +
            $('.messageWrite').val() +
            "</div>" +
            "</div>";

        $contentIn.append(message);

        $('.content').scrollTop($contentIn.height());
        $('.messageWrite').val("");
    }
});


// 스크롤 시 20개씩 불러오기
// 불러올 글이 없을 때 에러처리 필요
$('.content').scroll(function () {

    if ($(this).scrollTop() == 0) {
        alert("글불러오기!")
    }

});


// 유저 리스트 모달창
function dmSubmit() {

    //세션에서 유저 넘버 받아서 넘겨주기 추가해야함!!
    messageService.getFollowerList(1, function (result) {
        let res = "";
        $.each(result, function (i, item) {
            res += '<div>' +
                '<div class="dmImg">' +
                '<img src="/images/project/domImg/indi01.webp" alt="">' +
                '</div>' +
                '<div class="userData">' +
                '<p>' +
                item.nickname +
                '</p>' +
                '<p>' +
                item.name +
                '</p>' +
                '</div>' +
                '<div class="dmBtn">' +
                '<a href="" class="userDMLink">채팅</a>' +
                '</div>' +
                '</div>';
        });
        $('.userList').html(res)
    })

    $("#modal1").addClass("on");
}

$("a#modalClose").on("click", function (e) {
    e.preventDefault();
    $("#modal1").removeClass("on");
});

// dm 선택시 리스트 가져오기
$(".dmBtn>a").on("click", function (e) {
    e.preventDefault();
    // 처음 클릭이면
    if (!$(".dmBox").hasClass("on")) {
        $(".firstBox").removeClass("on");
        $(".dmBox").addClass("on");
    }
    $("#modal1").removeClass("on");


    //세션에서 받아오기
    let sendUserNumber = 1;
    let receiveUserNumber = $(this).find("input[type='hidden']").val();
    // AJAX 실행
    messageService.getMessageList({
        sendUserNumber: sendUserNumber,
        receiveUserNumber: receiveUserNumber,
    },function(result){
        let message = "";

        $.each(result, function(i, item){
            if (item.sendUserNumber == sendUserNumber){
                message += "<div class=\"dmStyle1\">" +
                    "<div class=\"dmImg\">" +
                    "<img src=\"\" alt=\"\">" +
                    "</div>" +
                    "<div class=\"text\">" +
                    item.content +
                    "</div>" +
                    "</div>"
            }else{
                message += "<div class=\"dmStyle2\">" +
                    "<div class=\"dmImg\">" +
                    "<img src=\"\" alt=\"\">" +
                    "</div>" +
                    "<div class=\"text\">" +
                    item.content +
                    "</div>" +
                    "</div>"
            }
        });
        $contentIn.html(message);
    });

});


// 유저 검색 이텐트
$(".modalSearch > input").keyup(function () {
    // 입력 값 가져오기
    let keyword = $(this).val();
    let userNumber = 1; //채팅방 들어올 때 받아 오기

    messageService.searchFollowerList({
        keyword: keyword,
        userNumber: userNumber
    }, function (result) {
        let res = "";
        $.each(result, function (i, item) {
            res += '<div>' +
                '<div class="dmImg">' +
                '<img src="/images/project/domImg/indi01.webp" alt="">' +
                '</div>' +
                '<div class="userData">' +
                '<p>' +
                item.nickname +
                '</p>' +
                '<p>' +
                item.name +
                '</p>' +
                '</div>' +
                '<div class="dmBtn">' +
                '<a href="" class="userDMLink">채팅</a>' +
                '</div>' +
                '</div>';
        });
        $('.userList').html(res)
    });
    //
});

// DM 유저 리스트
function userList() {
    console.log("유저 리스트 가져오기");
    // Ajax 에섯 데이타 가져오기
    // $.ajax({
    // });
}

// 스크롤시 DM 리스트 가져오기