$(document).ready(function (){

    //이름태그
    const $name = $('#member-name');
    //이메일 주소 태그
    const $email = $('#member-email');
    //비밀번호 태그
    const $password = $('#member-password');
    //비밀번호 확인 태그
    const $checkPassword = $('#check-member-password');
    //로그인 버튼
    const $loginBtn = $('.login-btn');
    //회원가입 버튼
    const $joinBtn = $('.join-btn');

    //통과
    const $pass = $('.valid-feedback');
    //불통과
    const $notPass = $('.invalid-feedback');

    $loginBtn.on("click", ()=>{location.href=`/members/login`})


    //회원가입 유효성검사
    // $joinBtn.on(click, function (){
    //
    // })


    //이메일 유효성검사
    $email.keyup(function() {
        if (!fn_emailChk($email.val())) {
        $notPass.text("올바른 이메일 형식을 입력해 주세요");
        } else {$pass.text("멋진 이메일이네요");
        }
    })



    //이름에 특수문자금지
    $name.bind("input", function() {
        console.log("들어옴")
        re = /[~!@\#$%^&*\()\-=+_']/gi;
        let temp = $name.val();
        if (re.test(temp)) { //특수문자가 포함되면 삭제하여 값으로 다시셋팅
            $name.val(temp.replace(re, ""));
        }
    });


    /*이메일 유효성검사 함수*/
    function fn_emailChk(email) {
        let regExp = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{1,4}$/;
        if (!regExp.test(email)) {
            return false;
        }
        return true;
    }


})