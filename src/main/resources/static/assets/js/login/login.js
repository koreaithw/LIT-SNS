const loginBtn = $('#login_btn');
const email = $('#email');
const passwordValue = $('#pwVal');
var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

const loginBtnF = function () {
    if(passwordValue.val().length >= 6 && filter.test(email.val())){
        loginBtn.attr("class", "buttonforjoin formEvent");
    } else {
        loginBtn.attr("class", "buttonforjoin jonbuttoncolor");
    }
}
email.keyup(loginBtnF)
passwordValue.keyup(loginBtnF)