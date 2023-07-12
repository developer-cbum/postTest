$(document).ready(function (){
    //form 태그
    const $form = $('#post-form');
    //버튼 가져오기
    const $registerBtn = $('.register-btn');
    // 입력 태그들
    const $tags = $('.form-control')
    // 파일 삭제버튼
    const $fileDeleteBtn = $('.file-delete-btn');
    //파일 인풋
    const $fileInput = $('#file');

    let count = 0;
    let sizes = [];
    let name =[];
    // 새파일
    let text = "";
    // 파일 인풋
    $fileInput.on("change", function (){
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


        if($('.content-area').val() == ''){
            alert("내용을 입력해주세요.")
            $('.content-area').focus();
            return;
        }

        console.log(text);
        $form.append(text)
        $form.submit();
    })



//    파일 삭제 버튼
    $fileDeleteBtn.on("click", function (){
        const $thisFileWrap = $(this).closest('.modify-file-wrap')
        //화면 상숨기기
        $thisFileWrap.hide();
       text+= `<input type="hidden" name="fileIdsForDelete[${count}]" value="${$thisFileWrap.prop("id")}">`
        console.log(count)
        $form.append(text)
        ++count;
    });

})