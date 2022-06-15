const oldPw = $('#cppOldPassword');
const newPw = $('#cppNewPassword');
const newPwCk = $('#cppCheckPassword');


// 비밀번호 변경 버튼 활성화/비활성화
function buttonOn(){

    var oldCk = ckeckOldPw();
    var newCk = nPwChenk();

    if(oldCk && newCk){
        $('#subBtn').attr("class", "buttonOn");
    } else{
        $('#subBtn').attr("class", "buttonStyle");
    }
}

$('#subBtn').on("click", function(){
    alert("비밀번호 변경이 완료 되었습니다.");
});

// 새 비밀번호 확인 유효성 검사
function nPwChenk(){

    if(newPw.val() != newPwCk.val()){ // 새 비밀번호 / 비밀번호 확인
        $ ('._checkArea3').html('비밀번호가 일치하지 않습니다.');
        $('._checkArea3').css('color', 'red');
        return false;
    } else if(newPw.val().length <= 0 && newPwCk.val().length <= 0) {
        $ ('._checkArea3').html(' ');
        return false;
    } else{
        $('._checkArea3').html('비밀번호가 일치합니다.');
        $('._checkArea3').css('color', 'black');
        return true;
    }
}

function ckeckOldPw() {
    if(oldPw.val() != "aaaaa"){ // 현제 비밀번호 유효성 검사
        $ ('._checkArea1').html('비밀번호가 일치하지 않습니다.');
        $('._checkArea1').css('color', 'red');
        return false;
    } else if(oldPw.val().length <= 0){
        $('._checkArea1').html(' ');
        return false;
    } else{
        $('._checkArea1').html(' ');
        $('._checkArea1').css('color', 'black');
        return true;
    }
}

oldPw.keyup(buttonOn);
newPw.keyup(buttonOn);
newPwCk.keyup(buttonOn);
