$(document).ready(function () {
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
    //기존파일 목록
    const $basicFile = $('.rounded');
    //파일 전체를 감싸는 div 태그
    const $filePlusWrap = $('.file-plus-wrap');

    //새로 파일 추가 카운트
    let number = 0;
    //삭제 카운트
    let count = 0;
    let sizes = [];
    let name = [];
    // 새파일
    let text = "";
    // 화면에 추가하기 위한 변수선언
    let plusText = "";
    // 파일 인풋

    $fileInput.on("change", function () {
        name = [];
        text = "";
        let files = $(this)[0].files;
        console.log(files)
        let formData = new FormData();

        let now = new Date();
        let year = now.getFullYear();
        let month = now.getMonth() + 1;
        let date = now.getDate();

        month = month < 10 ? "0" + month : month;
        date = date < 10 ? "0" + date : date;

        let filePath = year + "/" + month + "/" + date

        $(files).each((i, file) => {
            console.log("들어옴");
            formData.append("uploadFile", file);
            sizes.push(files[i].size);
            name.push(files[i].name);
            text += `
            <input type="hidden" name="files[${i}].filePath" value="${filePath}">
            <input type="hidden" name="files[${i}].fileName" value="${name[i]}">
            <input type="hidden" name="files[${i}].fileSize" value="${sizes[i]}">
             `

            // 화면상에만 추가되어 보이기
            plusText += `
                                <div id="${number}" class="plus-file-wrap modify-file-wrap">
                                     <div class="file-wrap">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="cursor:default"
                                             class="bi bi-file-earmark-arrow-down" viewBox="0 0 16 16">
                                            <path d="M8.5 6.5a.5.5 0 0 0-1 0v3.793L6.354 9.146a.5.5 0 1 0-.708.708l2 2a.5.5 0 0 0 .708 0l2-2a.5.5 0 0 0-.708-.708L8.5 10.293V6.5z"/>
                                            <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5v2z"/>
                                        </svg>
                                        <a class="p-1 rounded" style="color:#0d6efd; font-size: 14px; cursor: default"
                                           href="">${name[i]}
                                        </a><span style="font-size: 12px;cursor:default">(<fmt:formatNumber value="${sizes[i] / 1024}"
                                                                                             pattern=".00"/>KB)</span><br>
                                    </div>
                                    <button type="button" class="btn btn-primary file-delete-btn active-file-delete-btn">삭제</button>
                                </div>
            `
            number++
        })

        $filePlusWrap.append(plusText);

        $.ajax({
            url        : "/files/upload",
            type       : "post",
            async: false,
            data       : formData,
            contentType: false,
            processData: false,
            success    : function (uuids) {
                for (let i = 0; i < uuids.length; i++) {
                    text += `<input type="hidden" name="files[${i}].fileUuid" value="${uuids[i]}">`
                }
            },
            error      : function () {
                alert("예상치 못한 오류 발생입니다.")
            }

        })

    })

    $registerBtn.on("click", function () {
        if ($tags.eq(0).val() == '') {
            alert("제목을 입력해주세요.")
            $tags.eq(0).focus();
            return;
        }


        if ($('.content-area').val() == '') {
            alert("내용을 입력해주세요.")
            $('.content-area').focus();
            return;
        }

        // $fileInput.trigger("change");
        console.log(text);
        $form.append(text)
        $form.submit();
    })

    // 기존 a태그 이벤트막기
    $basicFile.on("click", function (e) {
        e.preventDefault();
    });

//    파일 삭제 버튼
    $fileDeleteBtn.on("click", function () {
        const $thisFileWrap = $(this).closest('.modify-file-wrap')
        //화면 상숨기기
        $thisFileWrap.hide();
        text += `<input type="hidden" name="fileIdsForDelete[${count}]" value="${$thisFileWrap.prop("id")}">`
        console.log(count)
        $form.append(text)
        ++count;
    });


    // // 동적 화면 만 만든 파일 삭제 버튼
    $(document).on("click", '.active-file-delete-btn', function () {
        const files = $fileInput[0].files;
        let fileList = Array.from(files);
        plusText = "";
        const $thisFileWrap = $(this).closest('.modify-file-wrap')
        const index = $('.active-file-delete-btn').index($(this));

        //화면 상숨기기
        $thisFileWrap.remove();
        //삭제한 파일 값 삭제
        fileList.splice(index, 1);

        const newFileList = new DataTransfer();
        fileList.forEach(file => newFileList.items.add(file));
        $fileInput[0].files = newFileList.files;

    })

})