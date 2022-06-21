let reviewWriteService = (function () {

    //리뷰 작성
    function reviewRegister(reviewVO, callback, error) {
        $.ajax({
            url: "/litUp/register/"+reviewVO.userNumber+"/"+reviewVO.projectNumber ,
            type: "get" ,
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

    //프로젝트 유저번호로 유저 네임 가져오는 DTO 유무 확인 필요, 관련해서 PROJECT MAPPER ,LISTUPSERVICE, IMPLE, CONTROLLER 수정 필요
    function getProject(projectNumber, callback, error) {
        $.ajax({
            url: "/litUp/getProject/"+projectNumber ,
            type: "get" ,
            success: function (projectVO) {
                if(callback){
                    // 닉네임이 빠짐!!@!@!!@!@!!!!!!!!!!
                    callback(projectVO.title, projectVO.content, projectVO.startDate);
                }
            } ,
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
            }
        })
    }

    function getRegisterDate(registerDate){
        let rDate = new Date(registerDate);

            let y = rDate.getFullYear();
            let m = rDate.getMonth() + 1;
            let d = rDate.getDate();

            return [y, (m < 10 ? '0' : '') + m, (d < 10 ? '0' : '') + d].join("-")

    }

    return{reviewRegister:reviewRegister, getProject:getProject, getRegisterDate:getRegisterDate}
})();