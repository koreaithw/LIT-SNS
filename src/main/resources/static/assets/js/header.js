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
        },
    });
}
function alterLike(likes) {
    let str = "";
    $(likes).each(function (i, like) {
        str += "<div class='alterCss'>";
        str += "'<a href=''><img src='/lit/display?fileName='" + like.userFileVO.uploadPath + "/" + like.userFileVO.uuid + "_"  + like.userFileVO.name + "width='30px' class='userFile'></a>";
        str += "<div style='margin-bottom: 4px; margin-right: 30px;'><span class='alterspan'>" + like.nickname +"</span>님이 회원님의 사진을 좋아합니다.</div>"
        str += "<div><a><img src='/lit/display?fileName='" + like.reviewFileVO[0].uploadPath + "/" + like.reviewFileVO[0].uuid + "_"  + like.reviewFileVO[0].name + "class='alterRR'></a></div></div>"
        console.log(str);
    })


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

//     <div class="alterCss">
//     <a href=""><img src="/images/login/checkIcon.png" width="30px" class="userFile"></a>
//     <div style=" margin-bottom: 4px; margin-right: 30px;"><span class="alterspan">홍길동</span>님이 회원님의 사진을 좋아합니다.</div></div>
}

$likeBtn.click(likeBtnAct);
$follwBtn.click(foll0wBtnAct);
        


  
        







