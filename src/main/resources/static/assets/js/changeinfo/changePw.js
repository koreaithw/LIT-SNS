// 새 비밀번호 / 비밀번호 확인
function buttonOn(){
    $('#cppCheckPassword').keyup(function(){
        $('._checkArea3').html('');

        // 비밀번호 변경 버튼 활성화/비활성화
        if($('#cppCheckPassword').val() && $('#cppNewPassword').val() && $('#cppOldPassword').val()){
            $('#subBtn').attr("class", "buttonOn");
        }
        
        if(!$('#cppCheckPassword').val() && $('#cppNewPassword').val() && $('#cppOldPassword').val()){
            $('#subBtn').attr("class", "buttonStyle");
        }

    });
}

// 새 비밀번호 확인 유효성 검사
$('#cppCheckPassword').keyup(function(){
    console.log($('#cppNewPassword').val().length)
    if($('#cppNewPassword').val() != $('#cppCheckPassword').val()){
        $ ('._checkArea3').html('비밀번호가 일치하지 않습니다.');
        $('._checkArea3').css('color', 'red');
    } else if($('#cppNewPassword').val().length < 0) {
        $ ('._checkArea3').html('');
    } else{
        $('._checkArea3').html('비밀번호가 일치합니다.');
        $('._checkArea3').css('color', 'black');
    }
    buttonOn()
});
