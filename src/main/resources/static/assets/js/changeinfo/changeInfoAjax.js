
let changeInfoAjax = (function () {

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

    return {checkOldPw: checkOldPw, checkWithdrawPw: checkWithdrawPw}

})();