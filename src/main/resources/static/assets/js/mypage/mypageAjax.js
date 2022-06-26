

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

    return {removeFollower: removeFollower, getMedal: getMedal}

})();