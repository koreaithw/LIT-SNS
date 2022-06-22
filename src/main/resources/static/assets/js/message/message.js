let $contentIn = $('.content > div');

const amount = 20;

//세션에서 받아올 유저넘버
const userNumber = 1;

//메세지 인풋 창에서 엔터키입력
$('.messageWrite').on('keyup', function (key) {
    let receiveUserNumber = $('.contentTop').find('input[type="hidden"]').attr('id'); // 채팅방 들어올 때 받아오기
    let roomId = "1번방"; // 채팅방 들어올 때 받아오기
    let content = $('.messageWrite').val()


    /////////////////////webSocket 메세지 추가 부분 연결 필요

    if (key.keyCode == 13 && content != "") {

        messageService.send({
            sendUserNumber: userNumber,
            receiveUserNumber: receiveUserNumber,
            roomId: roomId,
            content: content
            // });

            // 하나씩 뿌려줄 때
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
        $('.dmList > figure > a[href="' + receiveUserNumber + '"]').find('.dmData').find('.recentMessage').text(content);
    }else{
        return;
    }
    send(content);
});





// 유저 리스트 모달창
function dmSubmit() {

    messageService.getFollowerList(userNumber, function (result) {
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
                '<input type="hidden" id="' + item.userNumber + '">' +
                '</div>' +
                '<div class="dmBtn2">' +
                '<a class="userDMLink" onclick="startChat(' + item.userNumber + ',this' + ')">채팅</a>' +
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


// 메세지 내역 선택 시 리스트 가져오기
$(".dmBtn>a").on("click", function (e) {
    e.preventDefault();
    // 처음 클릭이면
    if (!$(".dmBox").hasClass("on")) {
        $(".firstBox").removeClass("on");
        $(".dmBox").addClass("on");
    }
    $("#modal1").removeClass("on");
    $contentIn.empty();

    ///////////////////////webSocket 방 열어 주는 부분 추가 해야 함
    ///////////////////////////////////////////////////////////

    let receiveUserNumber = $(this).find("input[type='hidden']").attr('id');
    nickname = $(this).find('.dmData').children(0).html();
    let pageNum = $contentIn.children().length / amount || 1;

    $('.contentTop').children(1).find('span').text(nickname + '님');
    $('.contentTop').find('input[type="hidden"]').attr('id',receiveUserNumber);

    messageService.getMessageList({
        sendUserNumber: userNumber,
        receiveUserNumber: receiveUserNumber,
        pageNum : pageNum
    },function(result){
        let message = "";

        //채팅에 맞게 순서 반대로 뿌려줌, 기본 20개
        for (let i = result.length - 1; i >= 0; i--) {
            if (result[i].sendUserNumber == userNumber){
                message += "<div class=\"dmStyle1\">" +
                    "<div class=\"dmImg\">" +
                    "<img src=\"\" alt=\"\">" +
                    "</div>" +
                    "<div class=\"text\">" +
                    result[i].content +
                    "</div>" +
                    "</div>";
            }else{
                message += "<div class=\"dmStyle2\">" +
                    "<div class=\"dmImg\">" +
                    "<img src='/images/project/domImg/indi01.webp' alt=''>" +
                    "</div>" +
                    "<div class=\"text\">" +
                    result[i].content +
                    "</div>" +
                    "</div>";
            }

        }

        // $.each(result, function(i, item){
        //     if (item.sendUserNumber == sendUserNumber){
        //         message += "<div class=\"dmStyle1\">" +
        //             "<div class=\"dmImg\">" +
        //             "<img src=\"\" alt=\"\">" +
        //             "</div>" +
        //             "<div class=\"text\">" +
        //             item.content +
        //             "</div>" +
        //             "</div>"
        //     }else{
        //         message += "<div class=\"dmStyle2\">" +
        //             "<div class=\"dmImg\">" +
        //             "<img src=\"\" alt=\"\">" +
        //             "</div>" +
        //             "<div class=\"text\">" +
        //             item.content +
        //             "</div>" +
        //             "</div>"
        //     }
        // });
        $contentIn.html(message);
        if(result[0]){
            $('.content > div').attr("class", result[0].total.toString());
        }
        $('.content').scrollTop($contentIn.height());
    });
    connect();
});

// 스크롤 시 20개씩 불러오기
// 불러올 글이 없을 때 에러처리 필요
$('.content').scroll(function () {

    let total = $('.content > div').attr('class');

    if ($(this).scrollTop() == 0) {
        if (total == $contentIn.children().length){
            return;
        }

        let pageNum = $contentIn.children().length / amount + 1;
        let receiveUserNumber = $('.contentTop').find('input[type="hidden"]').attr('id')

        messageService.getMessageList({
            sendUserNumber: userNumber,
            receiveUserNumber: receiveUserNumber,
            pageNum: pageNum,
        }, function(result){
            let message = "";

            //채팅에 맞게 순서 반대로 뿌려줌, 기본 20개
            for (let i = result.length - 1; i >= 0; i--) {
                if (result[i].sendUserNumber == userNumber) {
                    message += "<div class=\"dmStyle1\">" +
                        "<div class=\"dmImg\">" +
                        "<img src=\"\" alt=\"\">" +
                        "</div>" +
                        "<div class=\"text\">" +
                        result[i].content +
                        "</div>" +
                        "</div>";

                } else {
                    message += "<div class=\"dmStyle2\">" +
                        "<div class=\"dmImg\">" +
                        "<img src='/images/project/domImg/indi01.webp' alt=''>" +
                        "</div>" +
                        "<div class=\"text\">" +
                        result[i].content +
                        "</div>" +
                        "</div>";
                }
            }
            $contentIn.prepend(message);
            $('.content').scrollTop($contentIn.height()/2);
        });
    }
});


// 유저 검색 이텐트
$(".modalSearch > input").keyup(function () {
    // 입력 값 가져오기
    let keyword = $(this).val();

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
                '<input type="hidden" value="' + item.userNumber + '">' +
                '</div>' +
                '<div class="dmBtn2">' +
                '<a class="userDMLink" onclick="startChat(' + item.userNumber + ',this' + ')">채팅</a>' +
                '</div>' +
                '</div>';
        });
        $('.userList').html(res)
    });
});

function startChat(receiveUserNumber, nick){

    // 해당 유저와의 채팅방이 없다면 채팅방 추가하기




    // 처음 클릭이면
    if (!$(".dmBox").hasClass("on")) {
        $(".firstBox").removeClass("on");
        $(".dmBox").addClass("on");
    }
    $("#modal1").removeClass("on");
    $contentIn.empty();

    ///////////////////////webSocket 방 열어 주는 부분 추가 해야 함
    ///////////////////////////////////////////////////////////

    let nickname = $(nick).parent().siblings('.userData').children(1).html();
    let pageNum = $contentIn.children().length / amount || 1;

    $('.contentTop').children(1).find('span').text(nickname + '님');
    $('.contentTop').find('input[type="hidden"]').attr('id', receiveUserNumber);

    messageService.getMessageList({
        sendUserNumber: userNumber,
        receiveUserNumber: receiveUserNumber,
        pageNum : pageNum
    },function(result){
        let message = "";

        //채팅에 맞게 순서 반대로 뿌려줌, 기본 20개
        for (let i = result.length - 1; i >= 0; i--) {
            if (result[i].sendUserNumber == userNumber){
                message += "<div class=\"dmStyle1\">" +
                    "<div class=\"dmImg\">" +
                    "<img src=\"\" alt=\"\">" +
                    "</div>" +
                    "<div class=\"text\">" +
                    result[i].content +
                    "</div>" +
                    "</div>";
            }else{
                message += "<div class=\"dmStyle2\">" +
                    "<div class=\"dmImg\">" +
                    "<img src='/images/project/domImg/indi01.webp' alt=''>" +
                    "</div>" +
                    "<div class=\"text\">" +
                    result[i].content +
                    "</div>" +
                    "</div>";
            }

        }

        $contentIn.html(message);
        if(result[0]){
            $('.content > div').attr("class", result[0].total.toString());
        }
        $('.content').scrollTop($contentIn.height());
    });



}