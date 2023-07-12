<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>게시판</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/css/common.css"/>
    <link rel="stylesheet" href="/css/list.css"/>
    <link rel="stylesheet" href="/css/detail.css"/>
</head>
<body>
<div class="detail-container">
    <jsp:include page="../header/header.jsp"/>
    <section>
        <div class="detail-wrap">
            <div class="post-btn-wrap"><button type="button" class="btn btn-primary back-list">리스트로 돌아가기</button></div>
            <div class="mb-3">
                <label for="title">제목</label>
                <div class="form-control" id="title">
                    <c:out value="${post.postTitle}"/>
                </div>
            </div>
            <div class="mb-3">
                <label for="writer">작성자</label>
                <div class="form-control" id="writer">
                  <c:out value="${post.memberName}"/>
                </div>
            </div>
            <div class="mb-3">
                <label for="content">내용</label>
                <div class="form-control last-content" id="content">
                    <pre><c:out value="${post.postContent}"/></pre>
                </div>
            </div>
            <div class="btn-wrap">
                    <c:if test="${sessionScope.id == post.memberId}">
                        <div class="post-btn-wrap modify-btn-wrap">
                            <button type="button" class="btn btn-primary modify-btn" onclick="location.href='/posts/modify/${post.postId}'">수정</button>
                        </div>
                        <div class="post-btn-wrap delete-btn-wrap">
                            <button type="button" class="btn btn-primary delete-btn" onclick="location.href='/posts/remove/${post.postId}'">삭제</button>
                        </div>
                    </c:if>
            </div>
        </div>
    </section>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>
    $(document).ready(function (){
        const $backToListBtn = $('.back-list');
        $backToListBtn.on("click" ,$(document), ()=>{location.href="/posts/list"})
    });
</script>

</html>
