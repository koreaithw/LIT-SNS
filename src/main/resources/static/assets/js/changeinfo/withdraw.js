
const pw = $('#_withdrawlPassword');
const pwBtn = $('#btnNoOff');

pw.keyup(function(){
    
    if(pw.val() == "1111"){
        pwBtn.attr('class', 'buttonOn');
    }else{
        pwBtn.attr('class', 'buttonStyle');
    }

})

pwBtn.on("click", function(){
    alert("회원탈퇴가 완료되었습니다.");
});
