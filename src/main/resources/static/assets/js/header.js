console.log("들어옴")
console.log($("._icon_profile"));
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

function likeBtnAct(){
    $follwBtn.css("color", "#8e8e99");
    $likeBtn.css("color", "");
    $.ajax({
        url: "/lit/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(files){
            imgEvent(files);
        }
    });
}

function foll0wBtnAct(){
    $likeBtn.css("color", "#8e8e99");
    $follwBtn.css("color", "");
}

$likeBtn.click(likeBtnAct);
$follwBtn.click(foll0wBtnAct);
        


  
        







