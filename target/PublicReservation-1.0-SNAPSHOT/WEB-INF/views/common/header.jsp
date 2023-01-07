<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>header</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">

</head>
<body>

<c:if test="${ not empty alertMsg }">
    <script>
        alertify.alert("서비스 요청 성공", '${alertMsg}' );
    </script>
    <c:remove var="alertMsg" scope="session" />
</c:if>

<div id="header">

    <div id="header_1">

        <div id="header_1_left">
            <video width="100" height="100" preload="none" style="background: transparent  url('https://cdn-icons-png.flaticon.com/512/9284/9284483.png') 50% 50% / fit no-repeat;" autoplay="autoplay" loop="true" muted="muted" playsinline="">
                <source src="https://cdn-icons-mp4.flaticon.com/512/9284/9284483.mp4" type="video/mp4">
            </video>
        </div>

        <div id="header_1_center">


        </div>

        <div id="header_1_right">

<%--            <c:when test="${ loginUser == null }">--%>
                <a href="login.me"/><b>로그인</b></a>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <label>${loginUser.userName }님 환영합니다.</label> &nbsp;&nbsp;--%>
<%--                <a href="${pageContext.request.contextPath}/logout">로그아웃</a>--%>
<%--            </c:otherwise>--%>

        </div>
    </div>

    <div id="header_2">
        <ul>
            <li><a href="<c:url value="/"/>">HOME</a></li>
            <li><a href="${pageContext.request.contextPath}/selectPhysicalList">체육시설</a> </li>
            <li><a href="${pageContext.request.contextPath}/selectCultureList">문화시설</a> </li>
            <li><a href="">예약확인</a></li>
        </ul>
    </div>
</div>


</body>
</html>
