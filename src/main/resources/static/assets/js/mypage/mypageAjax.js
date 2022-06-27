

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

    //litUp(리뷰) 리스트
    function litUpList(callback, error){

        $.ajax({
            url : "/litUp/getMyList",
            type : "get",
            dataType : "json",
            success : function(result){
                if(callback){ callback(result); }
            },
            error : function(xhr, status, er){
                if(error) { error(er); }
            }
        })
    }

    //lit(프로젝트) 리스트
    function litList(callback, error){
        $.ajax({
            url : "/lit/getMyList",
            type : "get",
            dataType: "json",
            success : function(result){
                if(callback){ callback(result); }
            },
            error : function(xhr, status, er){
                if(error) { error(er); }
            }
        })
    }

    function getMyProfileImg(userNumber,callback){
        $.getJSON("/litUp/profilePic" , {userNumber: userNumber}, function(pic){
            if(callback){callback(pic);
            }
        });

    }


    return {removeFollower: removeFollower, getMedal: getMedal, litUpList:litUpList, litList:litList, getMyProfileImg:getMyProfileImg}

})();