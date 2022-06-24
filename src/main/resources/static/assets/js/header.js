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
    let userNumber = 1;

    $.ajax({
        url: "/alert/get/" + userNumber,
        type: "get",
        contentType: "application/json; charset=utf-8;",
        success: function (alters) {
            alterLike(alters);
        }
    });
}

// 알림 작업중 미완성
let ckLikes = "";
function alterLike(alters) {
    console.log(alters);

    let ifck = Date;
    let str = "";
    $(alters).each(function (i, alter) {
        let userSrc = "";
        let reSrc = "";
        str += "<div class='alterCss'>"
        console.log(alter)
        console.log(userSrc)

        str += "<a href=''><img width='30px' class='userFile' src='/lit/display?fileName=" + alter.userFileVO.uploadPath + "/" + alter.userFileVO.uuid + "_" + alter.userFileVO.name + "'></a>"
        str += "<div style='margin-bottom: -5px; margin-right: 30px;'><span class='alterspan'>" + alter.nickName
        if(alter.typeAlert == "like") {
            str += "</span>님이 회원님의 사진을 좋아합니다.</div>"
            reSrc += "/lit/display?fileName=" + alter.reviewFileVO.uploadPath + "/" + alter.reviewFileVO.uuid + "_" + alter.reviewFileVO.name
            str += "<div><a src=''><img class='alterRR' src=" + reSrc + "></a></div></div>"
            str += "<div><span class='alterTime'>" + alter.likeDTO[i].registerDate + "</span></div>"
        } else {
            userSrc += "/lit/display?fileName=" + alter.userFileVO.uploadPath + "/" + alter.userFileVO.uuid + "_" + alter.userFileVO.name
            str += "<a href=''><img width='30px' class='userFile' src='" + userSrc + "'></a>"
            str += " <div style='margin-bottom: -5px; margin-right: 30px;'><span class='alterspan'>" + alter.nickName + "</span>님이 회원님을 팔로우 했습니다.</div></div>"
            str += "<div><span class='alterTime'>" + alter.registerDate + "</span></div>"
        }


    });

    if(str != ckLikes) {
        $("#alterLike").append(str);
        ckLikes += str
    }
}

//     <div class="alterCss">
//     <a href=""><img src="/images/login/checkIcon.png" width="30px" class="userFile"></a>
//     <div style=" margin-bottom: 4px; margin-right: 30px;"><span class="alterspan">홍길동</span>님이 회원님의 사진을 좋아합니다.</div>
//     <div><img src="/images/admin/logo.png" alt="" class="alterRR"></div></div>
//     <div class="alterCss">
//     <a href=""><img src="/images/login/checkIcon.png" width="30px" class="userFile"></a>
//     <div style=" margin-bottom: 4px; margin-right: 30px;"><span class="alterspan">홍길동</span>님이 회원님의 사진을 좋아합니다.</div></div>

        


  
        







