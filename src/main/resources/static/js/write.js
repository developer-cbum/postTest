$(document).ready(function (){
    //form 태그
    const $form = $('#post-form');
    //버튼 가져오기
    const $registerBtn = $('.register-btn');
    // 입력 태그들
    const $tags = $('.form-control')

    $registerBtn.on("click", function (){
        if($tags.eq(0).val() == ''){
            alert("제목을 입력해주세요.")
            $tags.eq(0).focus();
            return;
        }

        if($tags.eq(1).val() == ''){
            alert("작성자를 입력해주세요.")
            $tags.eq(1).focus();
            return;
        }

        if($tags.eq(2).val() == ''){
            alert("내용을 입력해주세요.")
            $tags.eq(2).focus();
            return;
        }

        $form.submit();
    })

})