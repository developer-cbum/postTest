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
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"
    ></script>
</head>
<body>
<div class="container">
    <header class="header">
        <div class="header-wrap">
            <div class="main-logo"><img src="/images/logo2.png" alt="" /></div>
            <a href="#"><div class="login">로그인</div></a>
        </div>
    </header>
    <section class="banner">
        <img src="/images/logo.png" alt="" />
    </section>
    <section>
        <div class="content-wrap">
            <div class="content-top">
                <div>
                    <div class="post-list">게시글 목록</div>
                    <div class="post-total">4개</div>
                </div>
                <div class="post-btn-wrap"><button class="btn btn-primary">게시글 등록</button></div>
            </div>
            <ul class="content-ul"></ul>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                <c:if test="${pagination.prev}">
                    <li class="page-item"><a class="page-link" href="/posts/list?page=${pagination.startPage-1}"><</a></li>
                </c:if>
                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                    <c:choose>
                        <c:when test="${i eq pagination.page}">
                            <li class="page-item active"><a class="page-link"><c:out value="${i}"/></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="/posts/list?page=${i}"><c:out value="${i}"/></a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${pagination.next}">
                    <li class="page-item"><a class="page-link" href="/posts/list?page=${pagination.endPage+1}"></a></li>
                </c:if>
                </ul>
            </nav>
        </div>
    </section>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>
    let posts = ${posts};
</script>
<script src="/js/elapsedTime.js"></script>
<script src="/js/list.js"></script>
</html>
