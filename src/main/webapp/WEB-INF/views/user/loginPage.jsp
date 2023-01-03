<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2023/01/01
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>

<div>

    <jsp:include page="../common/header.jsp" />
    <br><br>

    <div align="center">
        <h1>로그인</h1>
        <br><br><br>
        <span c:if = ${userId == null }>
            <a href="https://kauth.kakao.com/oauth/authorize?client_id=d1bcff54c37052ab7ac6c06c5902e5ca&redirect_uri=http://localhost:8090/PublicReservation/login&response_type=code">
                <img src="<c:url value="/resources/images/oauth/kakao_login_medium_wide.png"/>">
            </a>
        </span>
    </div>


<%--    <span c:if = ${userId != null }>--%>
<%--        <form name="logout" action="http://localhost:8090/logout">--%>
<%--            <input type="submit" value="로그아웃">--%>
<%--        </form>--%>
<%--    </span>--%>

    <%--                <c:when test="${ loginUser == null }">--%>
    <%--                    <a href="${contextPath}/enrollForm">회원가입</a>--%>
    <%--                    <a data-toggle="modal" data-target="#loginModal">로그인</a>--%>
    <%--                </c:when>--%>
    <%--                <c:otherwise>--%>
    <%--                    <label>${loginUser.userName }님 환영합니다.</label> &nbsp;&nbsp;--%>
    <%--                    <a href="${contextPath}/myPage">마이페이지</a>--%>
    <%--                    <a href="${contextPath}/logout">로그아웃</a>--%>
    <%--                </c:otherwise>--%>

</div>


</body>
</html>
