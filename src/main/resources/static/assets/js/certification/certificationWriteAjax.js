let reviewWriteService = (function () {

    function reviewRegister(reviewVO, callback, error) {
        $.ajax({
            url: "/litUp/register" ,
            type: "post" ,
            data: JSON.stringify(reviewVO) ,
            contentType: "application/json" ,
            success: function (result) {
                if(callback){
                    callback(result);
                }
            } ,
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
            }
            })

    }


    return{reviewRegister:reviewRegister}
})();