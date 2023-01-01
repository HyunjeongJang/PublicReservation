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
            <b>공공서비스 예약</b>
        </div>

        <div id="header_1_center">

        </div>

        <div id="header_1_right">
            <a href="<c:url value="/user/login"/>">회원가입</a>
            <a href="login.me"/>로그인</a>

<%--            <a data-toggle="modal" data-target="#loginModal">로그인</a>--%>
<%--            <c:choose>--%>
<%--                <c:when test="${ loginUser == null }">--%>
<%--                    <a href="${contextPath}/enrollForm">회원가입</a>--%>
<%--                    <a data-toggle="modal" data-target="#loginModal">로그인</a>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <label>${loginUser.userName }님 환영합니다.</label> &nbsp;&nbsp;--%>
<%--                    <a href="${contextPath}/myPage">마이페이지</a>--%>
<%--                    <a href="${contextPath}/logout">로그아웃</a>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>

        </div>
    </div>

    <div id="header_2">
        <ul>
            <li><a href="${contextPath}/">HOME</a></li>
            <c:forEach items="${facilityTypeList}" var="facilityType">
                <li><a href="${contextPath}/facility/list/${facilityType.facilityCd}">${facilityType.fName}</a></li>
            </c:forEach>
            <li><a href="${contextPath}/reservation">예약확인</a></li>
        </ul>
    </div>
</div>

<%--<!-- 로그인 클릭시 뜨는 모달( 기존에 안보이다가 버튼클릭시 보임) -->--%>
<%--<div class="modal fade" id="loginModal">--%>
<%--    <div class="modal-dialog modal-sm">--%>
<%--        <div class="modal-content">--%>
<%--            <!-- 모달 해더 -->--%>
<%--            <div class="modal-header">--%>
<%--                <h4 class="modal-title">Login</h4>--%>
<%--                <button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--            </div>--%>

<%--            <form action="${contextPath}/login" method="post">--%>
<%--                <!--  모달 바디 -->--%>
<%--                <div class="modal-body">--%>
<%--&lt;%&ndash;                    <label for="userId" class="mr-sm-2">ID : </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="text" class="form-controll mb-2 mr-sm-2" placeholder="Enter ID" id="userId" name="userId"> <br>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <label for="userPwd" class="mr-sm-2">Password : </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="password" class="form-controll mb-2 mr-sm-2" placeholder="Enter Password" id="userPwd" name="userPwd">&ndash;%&gt;--%>


<%--                    <a href="http://kauth.kakao.com/oauth/authorize?client_id=d1bcff54c37052ab7ac6c06c5902e5ca&redirect_uri=http://localhost:8090/login&response_type=code HTTP/1.1">--%>
<%--                        <img src="<c:url value="/resources/images/kakao/kakao_login_medium_narrow.png"/>">--%>
<%--                    </a>--%>
<%--                </div>--%>

<%--                <!-- 모달 푸터 -->--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="submit" class="btn btn-primary">로그인</button>--%>
<%--                    <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>
