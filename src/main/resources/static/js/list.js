$(document).ready(function () {
    const $ul = $('.content-ul');
    let text=``;

    posts.forEach(post => {
        text += `
                <li>
                    <a href="#">
                        <div class="content-box">
                            <div class="title">${post.postTitle}</div>
                            <div class="writer-wrap">
                                <div class="writer">${post.postWriter}</div>
                                <div class="register-time">${elapsedTime(post.postRegisterDate)}</div>
                            </div>
                        </div>
                    </a>
                </li>
        `
    })
    $ul.html(text);
})