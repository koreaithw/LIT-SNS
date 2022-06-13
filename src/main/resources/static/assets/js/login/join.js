const $loginBtn = document.querySelector('#login_btn')
const $idValue = document.querySelector('#idVal')
const $passwordValue = document.querySelector('#pwVal')
const $userName = document.querySelector('#userName')
const $nickName = document.querySelector('#nickName')

const loginBtn = function () {
    if($idValue.value.indexOf('@') > 0 && $passwordValue.value.length >= 6 && $userName.value.length >= 3 && $nickName){
        $loginBtn.className = 'buttonforjoin formEvent';
    } else {
        $loginBtn.className = 'buttonforjoin jonbuttoncolor';
    }
}
$idValue.addEventListener('keyup', loginBtn);
$passwordValue.addEventListener('keyup', loginBtn);


var form = document.joinForm;
 
function join(){

  if(!form.id.value){
     alert("아이디를 입력해주세요");
     form.id.focus();
     return;
  }
  if(form.id.value.length < 4 || form.id.value.length > 16){
     alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
     return;
  }
  
  if(!form.name.value){
     alert("이름을 입력해주세요.");
     form.name.focus();
     return;
  }
  if(!form.password.value){
     alert("비밀번호를 입력해주세요");
     form.password.focus();
     return;
  }
  
  //8자리 이상, 대문자, 소문자, 숫자, 특수문자 모두 포함되어 있는 지 검사
  let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*?-]).{8,}$/;
  let hangleCheck = /[ㄱ-ㅎ | ㅏ-ㅣ |가-힣]/
  if(!reg.test(form.password.value)){
     alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
     form.password.focus();
     return;
  }
  //같은 문자를 4번 사용할 수 없다.
  if(/(\w)\1\1\1/.test(form.password.value)){
     alert("같은 문자를 4번 이상 사용하실 수 없습니다.");
     form.password.focus();
     return;
  }
  
  //비밀번호 안에 아이디가 있을 때 해당 인덱스를 가져오고 없으면 -1을 반환한다.
  if(form.password.value.search(form.id.value) != -1){
     alert("비밀번호에 아이디를 포함할 수 없습니다.");
     form.password.focus();
     return;
  }
  
  //비밀번호에 한글이 있으면 안된다.
  if(hangleCheck.test(form.password.value)){
     alert("비밀번호에 한글을 사용할 수 없습니다.");
     form.password.focus();
     return;
  }
  
  //비밀번호에 공백을 포함할 수 없다.
  if(form.password.value.search(/\s/) != -1){
     alert("비밀번호에 공백 없이 입력해주세요.");
     form.password.focus()
     return;
  }
  
  if(form.password.value != form.password_re.value){
     alert("패스워드를 확인해주세요.");
     form.password.focus();
     return;
  }
  
  if(!form.id.readOnly){
     alert("아이디 중복 검사를 진행해주세요.");
     return;
  }
  form.submit();
}