$(document).ready(function () {
    // 게시글 등록버튼
    const registerBtn = $('.btn-primary');
    //게시글 목록을 감싸는 ul 태그
    const $ul = $('.content-ul');
    let text = ``;


    //게시글 등록버튼 클릭 이벤트
    registerBtn.on("click", () => {
        if (id.length == 0) {
            alert("로그인 후 이용해주세요");
            return;
        }
        location.href = `/posts/write`
    })


    //게시글 목록
    posts.forEach(post => {
        text += `
                <li>
                    <a href="/posts/detail/${post.postId}">
                        <div class="content-box">
                            <div class="title">${post.postTitle}</div>
                            <div class="writer-wrap">
                                <div class="writer">${post.memberName}</div><span></span> 
                                <div class="register-time">${elapsedTime(post.postRegisterDate)}</div>
                            </div>
                        </div>
                    </a>
                </li>
        `
    })
    $ul.html(text);
})