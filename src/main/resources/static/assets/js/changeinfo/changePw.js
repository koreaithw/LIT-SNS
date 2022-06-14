
// 새 비밀번호 / 비밀번호 확인
$(function(){
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

    // 새 비밀번호 확인 유효성 검사
    $('#cppCheckPassword').keyup(function(){
        if($('#cppNewPassword').val() != $('#cppCheckPassword').val()){
            $ ('._checkArea3').html('비밀번호가 일치하지 않습니다.');
            $('._checkArea3').css('color', 'red');
        } else{
            $('._checkArea3').html('비밀번호가 일치합니다.');
            $('._checkArea3').css('color', 'black');
        }
    });

    // 새 비밀번호 확인 유효성 검사
    $('#cppNewPassword').keyup(function(){
        
        if($('#cppNewPassword').val() && $('#cppCheckPassword').val()){
            
            
            if($('#cppNewPassword').val() != $('#cppCheckPassword').val()){
                $('._checkArea3').html('비밀번호가 일치하지 않습니다.');
                $('._checkArea3').css('color', 'red');
            } else{
                $('._checkArea3').html('비밀번호가 일치합니다.');
                $('._checkArea3').css('color', 'black');
            }
            
        }
    });

});