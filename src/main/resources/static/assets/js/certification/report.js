let reportModalBackground = document.querySelector('.reportBackground');
let reportModal = document.querySelector('.reportModal');

//신고 창 보여주기
function reportModalShow(){
    reportModalBackground.style.display = 'block';
}

//신고 창 닫기
function reportModalClose(){
    reportModalBackground.style.display = 'none';
}



$("#reportButtons button").on("clcik",function (report, callback, error) {
    $.ajax({
        url: "/litUp/report",
        type: "get",
        data: JSON.stringify(report),
        contentType: "application/json",
        success: function(result){
            if(callback){
                callback(result);
            }
        },
        error: function(xhr, status, er){
            if(error){
                error(xhr, status, er);
            }
        }
    });
})
