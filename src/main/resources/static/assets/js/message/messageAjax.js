
let messageService = (function() {

    function send(message,callback,error){
        $.ajax({
            url: "/message/send",
            type: "post",
            data: JSON.stringify(message),
            contentType: "application/json",
            dataType: "json",

            // 하나씩 저장할 때
            // success: function (result) {
            //     if (callback) {
            //         callback(result)
            //     }
        });
    }

    function getFollowerList(userNumber,callback,error){
        $.ajax({
            url: "/message/getFollowerList/" + userNumber,
            type: "get",
            dataType: "json",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }

        })


    }

    return{send:send, getFollowerList:getFollowerList};
})();