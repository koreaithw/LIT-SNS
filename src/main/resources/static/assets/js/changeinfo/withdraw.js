
const pw = $('#_withdrawlPassword');
const pwBtn = $('#btnNoOff');

pw.keyup(function(result){
    
    if(result){ // 비번 유효성 검사
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

function removeCheck() {
    if (confirm("정말 삭제하시겠습니까??") == true){    //확인
        alert("회원탈퇴가 완료되었습니다.");
    }else{   //취소
        return false;
    }
   }

pwBtn.on("click", function(){
    removeCheck();
});
