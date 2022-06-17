console.log("Admin Module......");

let adminService = (function(){
    console.log("adminSevice");
    function searchUser(userSearch, callback, error){
        $.ajax({
            url: "/admin/searchUser",
            type: "post",
            data: JSON.stringify(userSearch),
            contentType: "application/json",
            dataType: "json",
            success: function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er) {
                if(error){
                    error(er);
                }
            }
        });
    }

    function deleteUser(list, callback, error){
        $.ajax({
            url: "/admin/user/" + list,
            type : "delete",
            success: function () {
                if(callback){
                    console.log("삭제 완료")
                    callback();
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        })
    }

    function searchProject() {
        $.ajax({

        })

    }

    return {searchUser:searchUser, deleteUser:deleteUser, searchProject:searchProject};
})();