function checkLoginLogout(userNumber) {
    let str =""
    if(userNumber){
        str += " <a href=\"/user/logout\">" +
            "<div class=\"_dropdown_loginout\">" +
            "<div class=\"_dropdown_loginout_content\">로그아웃</div>" +
            "</div>" +
            "</a>"

    }else{
        str += " <a href=\"/user/login\">" +
            "<div class=\"_dropdown_loginout\">" +
            "<div class=\"_dropdown_loginout_content\">로그인</div>" +
            "</div>" +
            "</a>"
    }

    $("div.login_inOrOut").html(str)
}


//
// function headerAction(){
//
//         if( $("._dropdown_wrapper").css("display") == 'none'){
//             $("._dropdown_wrapper").show();
//         }else{
//             $("._dropdown_wrapper").css("display","none")
//             $("._dropdown_wrapper").hide();
//         }
//
//
// }
    // // //프로필 아이콘 클릭시 드롭다운 활성화
    $("._icon_profile").on("click",function(){
        console.log("A")
        if( $("._dropdown_wrapper").css("display") == 'none'){
            $("._dropdown_wrapper").show();
        }else{
            $("._dropdown_wrapper").hide();
        }
        })

        // 검색 버튼 클릭시 X버튼 노출
        $("._search_wrapper").on("click",function(){
            $("._search_cancle").show()
            $("._search_input").focus()
            $("._search_span").hide()
            $("._search_icon").hide()
            
            })
        
        // X 버튼 클릭시 원상복귀
        $("._search_cancle").on("click",function(e){
            e.stopPropagation(); // 부모 요소 클릭 이벤트 금지
            $("._search_cancle").hide()
            $("._search_input").blur()
            $("._search_span").show()
            $("._search_icon").show()
            
            })

const $fidOn = $("#fidOn");
const $fidOff = $("#fidOff");

$fidOff.on("click", function() {
    $fidOff.css("display", "none");
    $fidOn.css("display", "block");
    $("._aa5z").css("display", "flex");
    BtnAct();
});

$fidOn.on("click", function() {
    $fidOn.css("display", "none");
    $fidOff.css("display", "block");
    $("._aa5z").css("display", "none");
});

function BtnAct() {

    $.ajax({
        url: "/alert/get/" + userNumber,
        type: "get",
        contentType: "application/json; charset=utf-8;",
        success: function (alerts) {
            alterLike(alerts);
        }
    });
}

// 알림
function alterLike(alerts) {
    console.log(alerts);

    let str = "";
    $(alerts).each(function (i, alert) {
        let userNum = alert.userNumber;

        if(userNum != userNumber) {
            str += "<div class='alterCss'><div style='border-bottom: 2px solid rgb(219, 219, 219); display: flex; flex-direction: row; align-items: center;'>"
            if (alert.userFileVO != null) {
                str += "<a href='/user/mypage?userPageNumber=" + alert.userNumber + "'><img width='30px' class='userFile' src='/lit/display?fileName=" + alert.userFileVO.uploadPath + "/" + alert.userFileVO.uuid + "_" + alert.userFileVO.name + "'></a>"
            } else {
                str += "<a href='/user/userPage/" + alert.userNumber + "'><img width='30px' class='userFile' src='/images/main/profile_ex.png'></a>"
            }
            if (alert.typeAlert == "like") {
                let reSrc = "";
                str += "<div style=' margin-bottom: -20px;; margin-right: 30px; display: inline-block;'><span class='alterspan'>" + alert.nickName
                str += "</span>님이 회원님의 사진을 좋아합니다.<span class='alterTime' style=' padding-left: 13px;'>" + alert.registerDate + "</span></div>"
                reSrc += "/lit/display?fileName=" + alert.reviewFileVO.uploadPath + "/" + alert.reviewFileVO.uuid + "_" + alert.reviewFileVO.name
                str += "<div style='display: inline-block;'><a href=''><img class='alterRR' src=" + reSrc + "></a></div></div></div>"
                str += ""
            } else {
                str += "<div style=' margin-bottom: -7px; margin-right: 30px; display: inline-block; margin-top: 17px;'><span class='alterspan'>" + alert.nickName
                str += "</span>님이 회원님을 팔로우 했습니다."
                str += "<span class='alterTime' style='padding-left: 13px;'>" + alert.registerDate + "</span></div>"
                if(followCheck(alert.userNumber) != 1){
                    str += "<a id='headFollowBtn' onclick='headFollow(" + alert.userNumber + ")'><button type='button' class='alertFollowBtn'>팔로우</button></a></div>"
                }else {
                    str += "<a id='headFollowBtn' onclick='headDeleteFollow(" + alert.userNumber + ")'><button type='button' class='alertFollowingBtn'>팔로잉</button></a></div>"
                }

            }
        };
    });

    $("#alertList").html(str);
}

function headFollow(following) {

    let followVO = {"followingNumber" : following, "followerNumber" : userNumber};

    $.ajax({
        url: "/user/follow",
        type: "post",
        data: JSON.stringify(followVO),
        contentType:"application/json",
        success: function(e) {
            BtnAct();
        }
    });
}

function headDeleteFollow(following) {

    let followVO = {"followingNumber" : following, "followerNumber" : userNumber};

    $.ajax({
        url: "/user/deleteFollow",
        type: "post",
        data: JSON.stringify(followVO),
        contentType:"application/json",
        success: function(e) {
            BtnAct();
        }, error(a,b,c){
            console.log(a,b,c);
        }
    });

}

function followCheck(following) {
    // let followVO = {"followingNumber" : following, "followerNumber" : userNumber};
    let result;
    $.ajax({
        url: "/user/followCheck/" + following + "/" + userNumber,
        type: "get",
        async:false,
        success: function (success) {
            result = success;
            console.log("ajax" + success);
        }
    });


    return result;
}

//     <div class="alterCss">
//     <a href=""><img src="/images/login/checkIcon.png" width="30px" class="userFile"></a>
//     <div style=" margin-bottom: 4px; margin-right: 30px;"><span class="alterspan">홍길동</span>님이 회원님의 사진을 좋아합니다.</div>
//     <div><img src="/images/admin/logo.png" alt="" class="alterRR"></div></div>
//     <div class="alterCss">
//     <a href=""><img src="/images/login/checkIcon.png" width="30px" class="userFile"></a>
//     <div style=" margin-bottom: 4px; margin-right: 30px;"><span class="alterspan">홍길동</span>님이 회원님의 사진을 좋아합니다.</div></div>




  
        







