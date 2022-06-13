const $loginBtn = document.querySelector('#login_btn')
const $idValue = document.querySelector('#idVal')
const $passwordValue = document.querySelector('#pwVal')
const loginBtn = function () {
    if($idValue.value.indexOf('@') > 0 && $passwordValue.value.length >= 6){
        $loginBtn.className = 'buttonforjoin formEvent';
    } else {
        $loginBtn.className = 'buttonforjoin jonbuttoncolor';
    }
}
$idValue.addEventListener('keyup', loginBtn)
$passwordValue.addEventListener('keyup', loginBtn)