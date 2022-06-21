

let myPageAjaxService = (function () {

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

    return {removeFollower: removeFollower}

})();