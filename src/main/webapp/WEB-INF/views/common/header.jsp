
<%--경로확인 테스트용--%>

<%--불러오는 방식/경로는 문제없고 경로 세팅이 덜 된것같음--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <!--  공통적으로사용할 라이브러리 추가 -->
    <!-- Jquey 라이브러리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- 부트스트랩에서 제공하있는 스타일 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- 부투스트랩에서 제공하고있는 스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- alertify -->
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
    <!-- alertify css -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
    <!-- Default theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
    <!-- Semantic UI theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>



    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/header.css">
<%--    <link rel="stylesheet" href="<c:url value="/resources/header.css"/>">--%>

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
            하이하이
        </div>
        <div id="header_1_center">

        </div>
        <div id="header_1_right">
            <c:choose>
                <c:when test="${ empty loginUser}">
                    <!-- 로그인전 -->
                    <a href="${contextPath}/enrollForm.me">회원가입</a>
                    <!-- 모달의 원리 : 이 버튼 클릭시  data-target에 정의해놓은 해다 아이디의 dom요소 를 띄워줌 -->
                    <a data-toggle="modal" data-target="#loginModal">로그인</a>
                </c:when>
                <c:otherwise>
                    <!-- 로그인 후 -->
                    <label>${loginUser.userName }님 환영합니다.</label> &nbsp;&nbsp;
                    <a href="${contextPath}/myPage.me">마이페이지</a>
                    <a href="${contextPath}/logout.me">로그아웃</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div id="header_2">
        <ul>
            <li><a href="${contextPath}/">HOME</a></li>
            <li><a href="${contextPath}/chat/chatRoomList">채팅</a></li>
            <c:forEach items="${boardTypeList}" var="boardType">
                <li><a href="${contextPath}/board/list/${boardType.boardCd}">${boardType.boardName}</a></li>
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

            <form action="${contextPath}/login.me" method="post">
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
