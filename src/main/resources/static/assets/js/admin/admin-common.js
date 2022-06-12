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

//date-picker 설정 ====================================
window.addEventListener("load", function () {
  if ($.datepicker === undefined) {
    return;
  }
  $.datepicker.setDefaults({
    dateFormat: "yy-mm-dd",
    prevText: "이전 달",
    nextText: "다음 달",
    monthNames: [
      "1월",
      "2월",
      "3월",
      "4월",
      "5월",
      "6월",
      "7월",
      "8월",
      "9월",
      "10월",
      "11월",
      "12월",
    ],
    monthNamesShort: [
      "1월",
      "2월",
      "3월",
      "4월",
      "5월",
      "6월",
      "7월",
      "8월",
      "9월",
      "10월",
      "11월",
      "12월",
    ],
    dayNames: ["일", "월", "화", "수", "목", "금", "토"],
    dayNamesShort: ["일", "월", "화", "수", "목", "금", "토"],
    dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
    showMonthAfterYear: true,
    yearSuffix: "년",
  });
});

//chart 설정======================================
//요소ID와 객체하나 받으면 차트 꽂히도록 함수 정의
function makechart(domId, myData) {
  let chartArea = document.getElementById(domId).getContext("2d");
  // 차트생성
  let mychart = new Chart(chartArea, {
    type: "line", //string

    // data : Object
    data: {
      // x축 ar[]
      labels: myData.labels,

      //datasets : ar[{dataset1, ds2, ds3...}]
      datasets: [
        {
          label: myData.label, //string
          data: myData.data,
          lineTension: 0.3,
          backgroundColor: "rgba(255, 69, 67, 0.3)", //string
          bordercolor: "rgba(53,53,53,1)", //string
          borderWidth: 1,
          fill: true,
        },
      ],
    },
    options: {
      responsive: false,
      scales: {
        y: {
          beginAtZero: true,
        },
      },
    },
  });
}
