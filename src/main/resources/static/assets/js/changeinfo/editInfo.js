
let changeProfile = document.querySelector('#changeProfile');
let proFileImg = document.querySelector('#proFileImg');
const nickNameCk = $('#pepUsername');
const userName = $('#pepName');
const userContent = $('#pepBio');
const eamil = $('#email');

// 프로필 사진 바꾸기 모달 띄우기
function changeProfileModal(){
    changeProfile.style.display='block';
    changeProfile.style.overflow='none';
}

// 취소 버튼 클릭시
function changeProfileModalClose(){
    changeProfile.style.display='none';
}

// 현재 사진 삭제 버튼 클릭시
function changeProfileDelete(){
    document.getElementById('proFileImg').src = "/src/main/resources/static/images/changeinfo/basicProfile.png";
    changeProfile.style.display='none';
    alert("프로필 사진이 삭제되었습니다.");
}

// 사진 업로드 버튼 클릭시
function uploadProfile(){
    let fileInput = document.getElementById('ModalFileInput');
    let file = fileInput.click();

    changeProfile.style.display='none';
}

// 변경된 사진으로 프로필 사진 변경
$('#ModalFileInput').on("change", function(e){
    console.log($('#ModalFileInput'));
    let reader = new FileReader();

    let fileList = e.target.files;
    let file = fileList[0];
    console.log(fileList);
    console.log(file);
    reader.onload = function(e){
        console.log("bbb");

        console.log(e.target.result);
        proFileImg.src = e.target.result;
    }
    reader.readAsDataURL(file);

})


function checkNick(result) {
    console.log(nickNameCk.val() + "++++++++++++");

    if (!result) {

        $('._checkArea1').html('사용이 불가능한 사용자 이름입니다.');
        $('._checkArea1').css('color', 'red');

    } else {

        $('._checkArea1').html('사용 가능한 사용자 이름입니다.');
        $('._checkArea1').css('color', 'black');

    }
}


//버튼 활성화/비활성화
function buttonOn(){
    
    var chNick = checkNick();
    
    if(chNick && userName.val().length > 0 && nickNameCk.val().length > 0){
        $('#subBtn').attr("class", "submitBtnOn");
    } else{
        $('#subBtn').attr("class", "submitBtn");
    }
}

$('#subBtn').on("click", function(){
    alert("프로필이 저장되었습니다.")
});

userName.keyup(buttonOn);
nickNameCk.keyup(buttonOn);
userContent.keyup(buttonOn);
eamil.keyup(buttonOn);
