function checkAlert(msg) {
  //테스트용
  //실제 사용시 매개변수로 콜백받기 -> function checkAlert(msg, callback)
  if (confirm(msg)) {
    // 확인을 눌렀을 때 실행할 코드
    //매개변수로 받은 콜백함수를 실행시키면 됨 callback()
    console.log("완료");
  } else {
    console.log("실패");
  }
}
