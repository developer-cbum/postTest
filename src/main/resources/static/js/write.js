$(document).ready(function (){
    //form 태그
    const $form = $('#post-form');
    //버튼 가져오기
    const $registerBtn = $('.register-btn');
    // 입력 태그들
    const $tags = $('.form-control')

    let sizes = [];
    let name =[];
    let text = "";
    // 파일 인풋
    $tags.eq(1).on("change", function (){
        text="";
        let files = $(this)[0].files;
        let formData = new FormData();

        let now = new Date();
        let year = now.getFullYear();
        let month = now.getMonth() + 1;
        let date = now.getDate();

        month = month < 10 ? "0" + month : month;
        date = date < 10 ? "0" + date : date;

        let filePath = year + "/" + month + "/" + date

        $(files).each((i,file) => {
            console.log("들어옴");
            formData.append("uploadFile", file);
            sizes.push(files[i].size);
            name.push(files[i].name);
            text += `
            <input type="hidden" name="files[${i}].filePath" value="${filePath}">
            <input type="hidden" name="files[${i}].fileName" value="${name[i]}">
            <input type="hidden" name="files[${i}].fileSize" value="${sizes[i]}">
             `
        })

            $.ajax({
                url:"/files/upload",
                type:"post",
                data: formData,
                contentType: false,
                processData: false,
                success: function (uuids){
                    for (let i = 0; i <uuids.length; i++) {
                        text+=`<input type="hidden" name="files[${i}].fileUuid" value="${uuids[i]}">`
                    }
                },
                error: function (){
                    alert("예상치 못한 오류 발생입니다.")
                }

            })

    })

    $registerBtn.on("click", function (){
        if($tags.eq(0).val() == ''){
            alert("제목을 입력해주세요.")
            $tags.eq(0).focus();
            return;
        }


        if($tags.eq(2).val() == ''){
            alert("내용을 입력해주세요.")
            $tags.eq(2).focus();
            return;
        }

        console.log(text);
        $form.append(text)
        $form.submit();
    })

})