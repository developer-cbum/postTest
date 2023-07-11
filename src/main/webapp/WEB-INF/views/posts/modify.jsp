<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>게시판</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/css/common.css" />
    <link rel="stylesheet" href="/css/list.css" />
    <link rel="stylesheet" href="/css/write.css" />
</head>
<body>
<div class="write-container">
    <jsp:include page="../header/header.jsp" />
    <section>
        <form id="post-form" action="/posts/modify/${post.postId}" method="post">
          <div class="write-wrap">
              <input type="hidden" name="postId" value="${post.postId}">
              <div class="mb-3">
                  <label for="post-title">제목</label>
                  <input type="text" class="form-control" id="post-title" name="postTitle" placeholder="제목을 입력해주세요" value="${post.postTitle}">
              </div>
              <div class="mb-3">
                  <label for="post-writer">작성자</label>
                  <input type="text" class="form-control" id="post-writer" name="postWriter" placeholder="작성자를 입력해주세요" value="${post.postWriter}">
              </div>
              <div class="mb-3">
                  <label for="post-content">내용</label>
                  <textarea class="form-control content-area" id="post-content" name="postContent" placeholder="내용을 입력해주세요"><c:out value="${post.postContent}"/></textarea>
              </div>
              <div class="post-btn-container"><button type="button" class="btn btn-primary register-btn">게시글 수정</button></div>
          </div>
        </form>
    </section>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="/js/write.js"></script>
</html>