// let imgs = 2;
// let now = 0;
// let idx = 2;

// function slide() {
//     now = now == imgs ? 0 : now += 1; 

//     switch(now){
//         case 1:
//             idx= 2;
//             break;
//         case 2:
//             idx= 0;
//             break;
//         case 0:
//             idx= 1;

//     }
    
//     $("._ad_wrapper>img").eq(now - 1).css({"left": "0%", "z-index":"0"});
//     $("._ad_wrapper>img").eq(now).css({"left": "-100%"});
//     $("._ad_wrapper>img").eq(idx).css({"left": "0%", "z-index":"-10"});
// }

// function start() {
//     setInterval(function () { slide()}, 2000);
// }
// start();

// 뉴 방식
let now = 0;
let ani = 0;
let len = $("._ad_wrapper>img").length;

$("._ad_wrapper>img").css({"left": "-100%", "z-index":"0"}).eq(now).css({"left": "0%", "z-index":"1"});
function slide() {
    ani = (now+1) == len ? 0 : now + 1; 

    $("._ad_wrapper>img").eq(now).css({"z-index":"0"});
    $("._ad_wrapper>img").eq(ani).css({"left": "0%", "z-index":"1"});
    setTimeout(function(){
        $("._ad_wrapper>img").eq(now).css({"left": "-100%"});
        now = ani;
    }, 1000);
}

function start() {
    setInterval(function () { slide()}, 3000);
}
start();






window.onload =function () {
    $("._icon_profile").on("click",function(){
        headerAction();
        });
};
$(document).ready(function(){

    $("#header").load("/src/main/resources/templates/header.html")
    $("#footer").load("/src/main/resources/templates/footer.html")
})

    // ####################################################
    // lit up(인증글 페이지 이동) 클릭 이벤트 Ajax 사용하세요

    // $(".list1").on("click",function(e){
    //     e.preventDefault();
        
    //     $.ajax({
            


    //     })
    // })

     // ####################################################
    // lit(프로젝트 페이지 이동) 클릭 이벤트 Ajax 사용하세요

    // $(".list2").on("click",function(e){
    //     e.preventDefault();
        
    //     $.ajax({
            

            
    //     })
    // })

    // ####################################################

