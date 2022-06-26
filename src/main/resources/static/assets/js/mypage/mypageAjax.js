

let myPageAjaxService = (function () {

    function getMedal(userNumber, callback){
        console.log("getMedal................");
        $.getJSON("/user/getMedal/" + userNumber, function(medals){
            if(callback){
                callback(medals);
            }
        });
    }

    //모달 - 팔로우 삭제
    function removeFollower(followerNumber, followingNumber, callback) {
        console.log("removeFollower..........");
        $.ajax({
            url:"/user/removeFollower/" + followerNumber + "/" + followingNumber,
            type: "delete",
            success: function (result) {
                console.log("삭제 성공");
                if(callback){
                    callback(result);
                }
            }
        });
    }

    function get4Medal(userNumber) {
        console.log("get4Medal..........");
        $.ajax({
            url:"/user/get4Medal/" + userNumber,
            type: "get"
        });
    }

    function get5Medal(userNumber, callback) {
        console.log("get5Medal..........");
        $.ajax({
            url:"/user/get5Medal/" + userNumber,
            type: "get",
            success: function (result) {
                if(callback){
                    callback(result);
                }
            }
        });
    }

    function get8Medal(param, callback) {
        console.log("get8Medal..........");
        $.ajax({
            url:"/user/get8Medal/" + param.userNumber + "/" + param.category,
            type: "get",
            success: function (result) {
                console.log("ajax 콜백함수 들어옴")
                if(callback){
                    callback(result);
                }
            }
        });
    }

    return {removeFollower: removeFollower, getMedal: getMedal, get4Medal: get4Medal,
        get5Medal: get5Medal, get8Medal: get8Medal}

})();