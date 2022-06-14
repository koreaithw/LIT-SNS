
const pw = $('#_withdrawlPassword');
const pwBtn = $('#btnNoOff');

pw.keyup(function(){
    
    if(pw.val() == "1111"){
        pwBtn.attr('class', 'buttonOn');
    }

    if(!pw.val()){
        pwBtn.attr('class', 'buttonStyle');
    }

})


