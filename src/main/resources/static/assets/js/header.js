function headerAction(){

        if( $("._dropdown_wrapper").css("display") == 'none'){
            $("._dropdown_wrapper").show();
        }else{
            $("._dropdown_wrapper").hide();
        }
}
    // //프로필 아이콘 클릭시 드롭다운 활성화
    // $("._icon_profile").on("click",function(){
    //     console.log("A")
    //     if( $("._dropdown_wrapper").css("display") == 'none'){
    //         $("._dropdown_wrapper").show();
    //     }else{
    //         $("._dropdown_wrapper").hide();
    //     }
    //     })
        
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

const $likeBtn = $("#likeBtn");
const $follwBtn = $("#followBtn");

const $alterLike = $("#alterLike");
const $alterfollow = $("#alterfollow");

$fidOff.on("click", function() {
    $fidOff.css("display", "none");
    $fidOn.css("display", "block");
    $("._aa5z").css("display", "flex");
    likeBtnAct();
});

$fidOn.on("click", function() {
    $fidOn.css("display", "none");
    $fidOff.css("display", "block");
    $("._aa5z").css("display", "none");
});

function likeBtnAct() {
    $follwBtn.css("color", "#8e8e99");
    $likeBtn.css("color", "");
    $alterLike.css("display", "block");
    $alterfollow.css("display", "none");

    let userNumber = 1;

    $.ajax({
        url: "/alter/like/" + userNumber,
        type: "get",
        contentType: "application/json; charset=utf-8;",
        success: function (likes) {
            alterLike(likes);
        }
    });
}

// 알림 작업중 미완성
let ckLikes = "";
function alterLike(likes) {
    console.log(likes);
    let str = "";
    $(likes).each(function (i, like) {
        let userSrc = "";
        let reSrc = "";
        str += "<div class='alterCss'>";
        userSrc += "/lit/display?fileName=" + like.userFileVO.uploadPath + "/" + like.userFileVO.uuid + "_" + like.userFileVO.name
        str += "<a href=''><img width='30px' class='userFile' src='" + userSrc + "'></a>"
        str += "<div style='margin-bottom: -5px; margin-right: 30px;'><span class='alterspan'>" + like.nickName + "</span>님이 회원님의 사진을 좋아합니다.</div>"
        reSrc += "/lit/display?fileName=" + like.reviewFileVO.uploadPath + "/" + like.reviewFileVO.uuid + "_" + like.reviewFileVO.name
        str += "<div><a src=''><img class='alterRR' src=" + reSrc + "></a></div></div>"
        str += "<div><span class='alterTime'>" + like.registerDate + "</span></div>"
    });

    str += "<div class='alterCss'>";
    userSrc += "/lit/display?fileName=" + follow.userFileVO.uploadPath + "/" + follow.userFileVO.uuid + "_" + follow.userFileVO.name
    str += "<a href=''><img width='30px' class='userFile' src='" + userSrc + "'></a>"
    str += " <div style='margin-bottom: -5px; margin-right: 30px;'><span class='alterspan'>" + follow.nickName + "</span>님이 회원님을 팔로우 했습니다.</div></div>"
    str += "<div><span class='alterTime'>" + follow.registerDate + "</span></div>"

    if(str != ckLikes) {
        $("#alterLike").append(str);
        ckLikes += str
    }
}
//     <div class="alterCss">
//     <a href=""><img src="/images/login/checkIcon.png" width="30px" class="userFile"></a>
//     <div style=" margin-bottom: 4px; margin-right: 30px;"><span class="alterspan">홍길동</span>님이 회원님의 사진을 좋아합니다.</div>
//     <div><img src="/images/admin/logo.png" alt="" class="alterRR"></div></div>

function foll0wBtnAct(){
    $alterLike.css("display", "none");
    $alterfollow.css("display", "block");
    $likeBtn.css("color", "#8e8e99");
    $follwBtn.css("color", "");

    let userNumber = 1;

    $.ajax({
        url: "/alter/follow/" + userNumber,
        type: "get",
        contentType: "application/json; charset=utf-8;",
        success: function (follows) {
            alterfollow(follows);
        }
    });
}

let ckFollows = "";
function alterfollow(follows){
    console.log(follows)
    let str = "";
    $(follows).each(function (i, follow){
        let userSrc = "";

    });
    if(str != ckFollows) {
        $("#alterfollow").append(str);
        ckFollows += str;
    }
}

//     <div class="alterCss">
//     <a href=""><img src="/images/login/checkIcon.png" width="30px" class="userFile"></a>
//     <div style=" margin-bottom: 4px; margin-right: 30px;"><span class="alterspan">홍길동</span>님이 회원님의 사진을 좋아합니다.</div></div>

$likeBtn.click(likeBtnAct);
$follwBtn.click(foll0wBtnAct);
        


  
        







