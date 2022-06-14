


$("._withdrawlPassword").keyup(function(){
    if($("._withdrawlPassword").val()){
        $("._withdrawl_button").attr("disabled",false)
    }

    if(!$("._withdrawlPassword").val()){
        $("._withdrawl_button").attr("disabled",true)
    }

})


