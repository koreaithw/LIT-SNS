// let reviewNumber = [[${report.reviewNumber}]];
// let userNumber = [[${user.userNumber}]];

// Ajax area
let reportService = (function () {

    function addReport(report, callback, error) {
        $.ajax({
            url: "/litUp/report",
            type: "post",
            data: JSON.stringify(report),
            contentType: "application/json",
            success: function (result) {
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(xhr, status, er);
                }
            }
        })
    }

    function addReply(reply, callback, error) {
        $.ajax({
            url:"/litUp/reply",
            type:"post",
            data:JSON.stringify(reply),
            contentType: "application/json",
            success:function (result) {
                if(callback){
                    callback(result)
                }
            },
            error: function (xhr, status, er) {
                if (error){
                    error(xhr,status,er)
                }
            }

        })

    }

    return{addReport:addReport, addReply:addReply};
})();


