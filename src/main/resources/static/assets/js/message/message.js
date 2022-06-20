let $contentIn = $('.content > div');

//메세지 인풋 창에서 엔터키입력
$('.messageWrite').on('keyup', function (key) {
    let sendUserNumber = 1; // 채팅방 들어올 때 받아오기
    let receiveUserNumber = 5; // 채팅방 들어올 때 받아오기
    let room = "3번방"; // 채팅방 들어올 때 받아오기
    let content = $('.messageWrite').val();

    if (key.keyCode == 13) {

        messageService.send({
            sendUserNumber: sendUserNumber,
            receiveUserNumber: receiveUserNumber,
            room: room,
            content: content
        });

        // 하나씩 뿌려줄때
        // },function(result){
        // let message = "<div class=\"dmStyle1\">" +
        //         "<div class=\"dmImg\">" +
        //         "<img src=\"\" alt=\"\">" +
        //         "</div>" +
        //         "<div class=\"text\">" +
        //         result.content +
        //         "</div>" +
        //         "</div>"
        //     $contentIn.append(message);
        // });

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
    messageService.getFollowerList(1,function(result){
        let res = "";
        $.each(result, function(i,item){
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

    // AJAX 실행
    dmList();

});

// dm 내용 가져오기 ajax
function dmList() {
    console.log("유저 리스트 가져오기");
    // Ajax 에섯 데이타 가져오기
    // $.ajax({
    // });
}

// 유저 검색 이텐트
$(".modalSearch > input").keyup(function () {
    // 입력 값 가져오기
    let keyWord = $(this).val();
    console.log(keyWord);
    userList()
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