
let changeInfoAjax = (function () {

    // 이전 비밀번호 확인
    function checkOldPw(param, callback) {
        $.ajax({
            url:"/user/oldPwCheck",
            type: "post",
            dataType: "json",
            data: JSON.stringify(param),
            contentType: "application/json",
            success: function (result) {
                if(callback){
                    callback(result);
                }
            }
        });
    }

    // 회원탈퇴시 비밀번호 확인
    function checkWithdrawPw(param, callback) {
        $.ajax({
            url:"/user/withdrawCheck",
            type: "post",
            dataType: "json",
            data: JSON.stringify(param),
            contentType: "application/json",
            success: function (result) {
                if(callback){
                    callback(result);
                }
            }
        });
    }

    // 회원탈퇴 버튼 클릭시
    function withdrawUser(userNumber, callback){
        $.ajax({
            url: "/withdraw/" + userNumber,
            type: "delete",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    return {checkOldPw: checkOldPw, checkWithdrawPw: checkWithdrawPw, withdrawUser: withdrawUser}

})();