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
            공공서비스 예약
        </div>
        <div id="header_1_center">

        </div>
        <div id="header_1_right">
            <a href="${contextPath}/signup">회원가입</a>
            <a data-toggle="modal" data-target="#loginModal">로그인</a>
<%--            <c:choose>--%>
<%--                <c:when test="${ empty loginUser}">--%>
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
            <li><a href="${contextPath}/chat/chatRoomList">채팅</a></li>
            <c:forEach items="${facilityTypeList}" var="facilityType">
                <li><a href="${contextPath}/facility/list/${facilityType.facilityCd}">${facilityType.fName}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>

<!-- 로그인 클릭시 뜨는 모달( 기존에 안보이다가 버튼클릭시 보임) -->
<div class="modal fade" id="loginModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <!-- 모달 해더 -->
            <div class="modal-header">
                <h4 class="modal-title">Login</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <form action="${contextPath}/login" method="post">
                <!--  모달 바디 -->
                <div class="modal-body">
                    <label for="userId" class="mr-sm-2">ID : </label>
                    <input type="text" class="form-controll mb-2 mr-sm-2" placeholder="Enter ID" id="userId" name="userId"> <br>
                    <label for="userPwd" class="mr-sm-2">Password : </label>
                    <input type="password" class="form-controll mb-2 mr-sm-2" placeholder="Enter Password" id="userPwd" name="userPwd">
                </div>

                <!-- 모달 푸터 -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">로그인</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
