const amount = 20;

//세션에서 받아올 유저넘버
userNumber = 1;

function keyEnter(key) {
    let receiveNickname = $(key).closest('.textInput').siblings('.contentTop').find('span').html();
    let receiveUserNumber = $(key).closest('.textInput').siblings('.contentTop').find('input[type="hidden"]').attr('id'); // 채팅방 들어올 때 받아오기
    let roomId = $('.dmWrap').find("#" + receiveNickname).find('.contentTop').find('input[type="hidden"]').attr('class');
    let content = $(key).val()

    if (this.event.keyCode == 13 && content != "") {
        messageService.send({
            sendUserNumber: userNumber,
            receiveUserNumber: receiveUserNumber,
            roomId: roomId,
            content: content
        });

        $('.messageWrite').val("");
    } else {
        return;
    }
    $('.dmWrap').find("#" + receiveNickname).find('.content').scrollTop($('.dmWrap').find("#" + receiveNickname).find('.content').height() + $(window).height());
    console.log("전송")
    //웹소켓 쪽 전송
    send(roomId, nickname, content);
}


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
$(".dmBtn").on("click", "a", function (e) {
    console.log("여기는 다른곳")
    e.preventDefault();

    let receiveUserNumber = $(this).attr('id');
    let roomId = $(this).find("input[type='hidden']").attr('id');
    let receiveNickname = $(this).find('.dmData').children(0).html();

    if (!$('.dmWrap').find("#" + receiveNickname).hasClass("on")) {
        $(".firstBox").removeClass("on");
        $('.dmWrap').find("#" + receiveNickname).siblings('.dmBox').removeClass("on");
        $('.dmWrap').find("#" + receiveNickname).addClass("on");
    }
    $("#modal1").removeClass("on");


    messageService.getMessageList({
        sendUserNumber: userNumber,
        receiveUserNumber: receiveUserNumber,
        pageNum: 1
    }, function (result) {
        if (result.length != 0) {
            let message = "";
            message +=
                '<div class="contentTop">' +
                '<div>' +
                '<img src="/images/project/domImg/indi01.webp" alt="">' +
                '</div>' +
                '<div>' +
                '<span>' + receiveNickname + '</span>' +
                '</div>' +
                '<div class="iconBox">' +
                '<a class="icon_info" href="/message/message">' +
                '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-box-arrow-in-left" viewBox="0 0 16 16">' +
                '<path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z"/>' +
                '<path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>' +
                '</svg>' +
                '</a>' +
                '</div>' +
                '<div>' +
                '<input type="hidden" id="' + receiveUserNumber + '" class="' + roomId + '">' +
                '</div>' +
                '</div>' +
                '<div class="content" onscroll="getMoreMessage(this)">' +
                '<div class="' +
                result[0].total.toString() +
                '">';

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
            message += '</div>' +
                '</div>' +
                '<div class="textInput">' +
                '<div>' +
                '<div class="iconBox">' +
                '<a class="icon_happy"></a>' +
                '</div>' +
                '<div class="inputBox">' +
                '<input class="messageWrite" type="text" placeholder="메세지를 입력하세요..." onkeyup="keyEnter(this)">' +
                '</div>' +
                '<div class="iconBox">' +
                '<a class="icon_heart_white" onclick="enterHeart(this)"></a>' +
                '</div>' +
                '</div>' +
                '</div>'

            $('.dmWrap').find("#" + receiveNickname).html(message);
        }
        //스크롤처리................///////////////////////////////////////////
        $('.dmWrap').find("#" + receiveNickname).find('.content').scrollTop($('.dmWrap').find("#" + receiveNickname).find('.content').height() + $(window).height());
    });
    console.log("연결")
    if (!webSocket) {
        connect(roomId, nickname);
    }

});

// 스크롤 시 20개씩 불러오기
// 불러올 글이 없을 때 에러처리 필요
function getMoreMessage(scrolling) {
    let total = $(scrolling).children(0).attr('class');

    if ($(scrolling).scrollTop() == 0) {
        if (total == $(scrolling).children(0).children().length) {
            return;
        }
        let receiveNickname = $(scrolling).siblings('.contentTop').find('span').html();
        let pageNum = Math.ceil($('.dmWrap').find("#" + receiveNickname).find('.content').children(0).children(0).length / amount) + 1 || 1;
        let receiveUserNumber = $('.contentTop').find('input[type="hidden"]').attr('id')

        messageService.getMessageList({
            sendUserNumber: userNumber,
            receiveUserNumber: receiveUserNumber,
            pageNum: pageNum,
        }, function (result) {
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
            $(scrolling).children(0).prepend(message);
            $(scrolling).scrollTop($(scrolling).children(0).height() / 2);
        });
    }
}


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


function startChat(receiveUserNumber, nick) {

    ///////////////////////webSocket 방 열어 주는 부분 추가 해야 함
    ///////////////////////////////////////////////////////////

    let receiveNickname = $(nick).parent().siblings('.userData').children(1).html();

    if (!$('.dmWrap').find("#" + receiveNickname).hasClass("on")) {
        $(".firstBox").removeClass("on");
        $('.dmWrap').find("#" + receiveNickname).siblings('.dmBox').removeClass("on");
        $('.dmWrap').find("#" + receiveNickname).addClass("on");
    }
    $("#modal1").removeClass("on");

    console.log($('.dmList > figure').find('#' + receiveUserNumber).length);
    console.log($('.dmWrap').find("#" + receiveNickname).length)

    messageService.getMessageList({
        sendUserNumber: userNumber,
        receiveUserNumber: receiveUserNumber,
        pageNum: 1
    }, function (result) {

        let roomId = messageService.getRoomId({sendUserNumber: userNumber, receiveUserNumber: receiveUserNumber})

        if (result.length == 0) {
            $('.dmWrap').children().removeClass("on");
            if ($('.dmList > figure').find('#' + receiveUserNumber).length == 0) {
                let str = '<figure class="dmBtn">' +
                    '<a id="' + receiveUserNumber + '" class="userDMList" onclick="goMessage(this)">' +
                    '<div class="dmImg">' +
                    '<img src="/images/project/domImg/indi01.webp" alt="">' +
                    '</div>' +
                    '<div class="dmData">' +
                    '<p>' + receiveNickname + '</p>' +
                    '<p class="recentMessage"></p>' +
                    '<input type="hidden" id="' + roomId + '">' +
                    '</div>' +
                    '</a>' +
                    '</figure>'
                if ($('.dmList').children().length == 0) {
                    $('.dmList').html(str);
                } else {
                    $('.dmList').append(str)
                }
            }

            if ($('.dmWrap').find("#" + receiveNickname).length == 0) {
                let msg = '<div class="colBox dmBox on" id="' + receiveNickname + '">' +
                    '<div class="contentTop">' +
                    '<div>' +
                    '<img src="/images/project/domImg/indi01.webp" alt="">' +
                    '</div>' +
                    '<div>' +
                    '<span>' + receiveNickname + '</span>' +
                    '</div>' +
                    '<div class="iconBox">' +
                    '<a class="icon_info" href="/message/message">' +
                    '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-box-arrow-in-left" viewBox="0 0 16 16">' +
                    '<path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z"/>' +
                    '<path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>' +
                    '</svg>' +
                    '</a>' +
                    '</div>' +
                    '<div>' +
                    '<input type="hidden" id="' + receiveUserNumber + '" class="' + roomId + '">' +
                    '</div>' +
                    '</div>' +
                    '<div class="content" onscroll="getMoreMessage(this)">' +
                    '<div class="">' +
                    '</div>' +
                    '</div>' +
                    '<div class="textInput">' +
                    '<div>' +
                    '<div class="iconBox">' +
                    '<a class="icon_happy"></a>' +
                    '</div>' +
                    '<div class="inputBox">' +
                    '<input class="messageWrite" type="text" placeholder="메세지를 입력하세요..." onkeyup="keyEnter(this)">' +
                    '</div>' +
                    '<div class="iconBox">' +
                    '<a class="icon_heart_white"  onclick="enterHeart(this)"></a>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>'
                $('.dmWrap').append(msg)
            } else {
                ////////////////////////////여기 이미 있어도 다시 더 도는거 고치는 중..../////////////////////
                $('.dmWrap').find("#" + receiveNickname).siblings('.dmBox').removeClass("on");
                $('.dmWrap').find("#" + receiveNickname).addClass("on");
            }
        } else {
            let message = "";
            message +=
                '<div class="contentTop">' +
                '<div>' +
                '<img src="/images/project/domImg/indi01.webp" alt="">' +
                '</div>' +
                '<div>' +
                '<span>' + receiveNickname + '</span>' +
                '</div>' +
                '<div class="iconBox">' +
                '<a class="icon_info" href="/message/message">' +
                '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-box-arrow-in-left" viewBox="0 0 16 16">' +
                '<path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z"/>' +
                '<path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>' +
                '</svg>' +
                '</a>' +
                '</div>' +
                '<div>' +
                '<input type="hidden" id="' + receiveUserNumber + '" class="' + roomId + '">' +
                '</div>' +
                '</div>' +
                '<div class="content" onscroll="getMoreMessage(this)">' +
                '<div class="' +
                result[0].total.toString() +
                '">';

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
            message += '</div>' +
                '</div>' +
                '<div class="textInput">' +
                '<div>' +
                '<div class="iconBox">' +
                '<a class="icon_happy"></a>' +
                '</div>' +
                '<div class="inputBox">' +
                '<input class="messageWrite" type="text" placeholder="메세지를 입력하세요..." onkeyup="keyEnter(this)">' +
                '</div>' +
                '<div class="iconBox">' +
                '<a class="icon_heart_white"  onclick="enterHeart(this)"></a>' +
                '</div>' +
                '</div>' +
                '</div>'

            $('.dmWrap').find("#" + receiveNickname).html(message);
        }


        //스크롤처리................///////////////////////////////////////////
        $('.dmWrap').find("#" + receiveNickname).find('.content').scrollTop($('.dmWrap').find("#" + receiveNickname).find('.content').height() + $(window).height());

        if (!webSocket) {
            connect(roomId, nickname);
        }
    });
}


function goMessage(e) {
    let receiveUserNumber = $(e).attr('id');
    let roomId = $(e).find("input[type='hidden']").attr('id');
    let receiveNickname = $(e).find('.dmData').children(0).html();

    if (!$('.dmWrap').find("#" + receiveNickname).hasClass("on")) {
        $(".firstBox").removeClass("on");
        $('.dmWrap').find("#" + receiveNickname).siblings('.dmBox').removeClass("on");
        $('.dmWrap').find("#" + receiveNickname).addClass("on");
    }
    $("#modal1").removeClass("on");

    let msg =
        '<div class="contentTop">' +
        '<div>' +
        '<img src="/images/project/domImg/indi01.webp" alt="">' +
        '</div>' +
        '<div>' +
        '<span>' + receiveNickname + '</span>' +
        '</div>' +
        '<div class="iconBox">' +
        '<a class="icon_info" href="/message/message">' +
        '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-box-arrow-in-left" viewBox="0 0 16 16">' +
        '<path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z"/>' +
        '<path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>' +
        '</svg>' +
        '</a>' +
        '</div>' +
        '<div>' +
        '<input type="hidden" id="' + receiveUserNumber + '" class="' + roomId + '">' +
        '</div>' +
        '</div>' +
        '<div class="content" onscroll="getMoreMessage(this)">' +
        '<div class="">' +
        '</div>' +
        '</div>' +
        '<div class="textInput">' +
        '<div>' +
        '<div class="iconBox">' +
        '<a class="icon_happy"></a>' +
        '</div>' +
        '<div class="inputBox">' +
        '<input class="messageWrite" type="text" placeholder="메세지를 입력하세요..." onkeyup="keyEnter(this)">' +
        '</div>' +
        '<div class="iconBox">' +
        '<a class="icon_heart_white"  onclick="enterHeart(this)"></a>' +
        '</div>' +
        '</div>' +
        '</div>'
    $('.dmWrap').find("#" + receiveNickname).html(msg);

    console.log("연결")
    if (!webSocket) {
        connect(roomId, nickname);
    }
}

function enterHeart(key){
    let receiveNickname = $(key).closest('.textInput').siblings('.contentTop').find('span').html();
    let receiveUserNumber = $(key).closest('.textInput').siblings('.contentTop').find('input[type="hidden"]').attr('id'); // 채팅방 들어올 때 받아오기
    let roomId = $('.dmWrap').find("#" + receiveNickname).find('.contentTop').find('input[type="hidden"]').attr('class');
    let content = "❤️";

    messageService.send({
        sendUserNumber: userNumber,
        receiveUserNumber: receiveUserNumber,
        roomId: roomId,
        content: content
    });

    send(roomId, nickname, content);
}