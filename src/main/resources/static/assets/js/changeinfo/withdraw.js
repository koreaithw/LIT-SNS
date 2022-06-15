
const pw = $('#_withdrawlPassword');
const pwBtn = $('#btnNoOff');

pw.keyup(function(){
    
    if(pw.val() == "1111"){ // 비번 유효성 검사
        $ ('._checkArea1').html('');
        pwBtn.attr('class', 'buttonOn');
    } else if(pw.val().length <= 0){
        $ ('._checkArea1').html('');
    } else{
        $ ('._checkArea1').html('비밀번호가 일치하지 않습니다.');
        $('._checkArea1').css('color', 'red');
        pwBtn.attr('class', 'buttonStyle');
    }

})

pwBtn.on("click", function(){
    alert("회원탈퇴가 완료되었습니다.");
});
