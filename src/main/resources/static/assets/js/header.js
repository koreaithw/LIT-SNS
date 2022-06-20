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

        


  
        







