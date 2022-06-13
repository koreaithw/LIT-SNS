let follower = document.querySelector('.follower');
let followering = document.querySelector('.followering');
let medal = document.querySelector('.medal');
let followingBtnn = document.querySelector('.followingBtnn');
let followBtnn = document.querySelector('.followBtnn');

// 팔로워 모달 보이기
function followerModal(){
    follower.style.display='block';
    follower.style.overflow='none';
}
// 팔로워 모달 숨기기
function followerModalClose(){
    follower.style.display='none';
}

// 팔로우 모달 보이기
function followeringModal(){
    followering.style.display='block';
    followering.style.overflow='none';
}

// 팔로우 모달 숨기기
function followeringModalClose(){
    followering.style.display='none';
}

// 메달 모달 보이기
function medalModal(){
    medal.style.display='block';
    medal.style.overflow='none';
}

// 메달 모달 숨기기
function medalModalClose(){
    medal.style.display='none';
}

// 메달 선택시 해당 클릭 사항으로 변경
function representMedal(e){
    let changeImg = e.getAttribute('src');
    document.getElementById('medalImg').src = changeImg;
    medal.style.display='none';
}

// 팔로우 모달에서 팔로잉-팔로우 변경
function changeFollow(){
    console.log(followingBtnn.style.display);
    if(followingBtnn.style.display=='block'){
        console.log("111");
        followingBtnn.style.display='none';
        followBtnn.style.display='block';
    } else{
        console.log("222");
        followingBtnn.style.display='block';
        followBtnn.style.display='none';
    }
}