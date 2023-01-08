<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2023/01/03
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<c:set var="selectCultureList" value="${map.selectCultureList}"/>--%>
<%--<c:set var="pi" value="${map.pi}"/>--%>
<!--
검색을 진행한경우 key, query를 쿼리스트링 형태로 저장한 변수생성.
-->
<%--<c:if test="${!empty param.condition }">--%>
<%--    <c:set var="sUrl" value="&condition=${param.condition}&keyword=${param.keyword }"/>--%>
<%--</c:if>--%>
<%--<c:forEach items="${boardTypeList }" var="bt">--%>
<%--    <c:if test="${boardCode == bt.boardCd }">--%>
<%--        <c:set var="boardNM" value="${bt.boardName }"/>--%>
<%--    </c:if>--%>
<%--</c:forEach>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>시설리스트</title>
    <style>
        #boardList {
            text-align: center;
        }

        #boardList > tbody > tr:hover {
            cursor: pointer;
        }

        #pagingArea {
            width: fit-content;
            margin: auto;
        }

        #searchForm {
            width: 80%;
            margin: auto;
        }

        #searchForm > * {
            float: left;
            margin: 5px;
        }

        .select {
            width: 20%;
        }

        .text {
            width: 53%;
        }

        .searchBtn {
            width: 20%;
        }

    </style>

</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div align="center">

    <div>
        <input type="text" placeholder="검색어를 입력해주세요">
        <input type="button" value="검색">
    </div>

    <br>
    <div>

        <h3>상세검색</h3><br>
<%--        <form id="form" method="post">--%>

            <b>접수기간</b>&nbsp;&nbsp;<input type="date"> ~ <input type="date"> <br><br>
            <b>접수상태</b>
            &nbsp;&nbsp;<input type="checkbox" name="chk_code" value="안내중">안내중
            &nbsp;&nbsp;<input type="checkbox" name="chk_code" value="접수중">접수중
            &nbsp;&nbsp;<input type="checkbox" name="chk_code" value="예약마감">예약마감
            &nbsp;&nbsp;<input type="checkbox" name="chk_code" value="접수종료">접수종료<br><br>
            <b>지역</b>&nbsp;&nbsp;<input type="checkbox" name="test2" value="test">테스트2<br><br>

<%--        </form>--%>

<%--        <form id="form" method="post">--%>
<%--            <input type="hidden" id="arrayParam" name="arrayParam"/>--%>
<%--            <c:forEach var="item" items="${selectCultureList}">--%>
<%--                <input type="checkbox" name="chk_code" value="${selectCultureList.serviceState}">--%>
<%--                ${selectCultureList.serviceState}--%>
<%--            </c:forEach>--%>
<%--        </form>--%>



<%--        <script>--%>
<%--            var array = new Array(); // 배열 선언--%>
<%--            $('input:checkbox[name=chk_code]:checked').each(function() { // 체크된 체크박스의 value 값을 가지고 온다.--%>
<%--                array.push(this.value);--%>
<%--            });--%>

<%--            $("#arrayParam").val(array);--%>

<%--            $("#form").attr("action", "/selectCultureList");--%>
<%--            $("#form").submit();--%>
<%--        </script>--%>



        <button>상세검색</button>
    </div>


    <br><br>
    <a href="${pageContext.request.contextPath}/searchCultureList">데이터 가져오기 확인용</a>
</div>


<div class="content">
    <c:set var="i" value="0"/>
    <c:set var="j" value="4"/>
    <table border=1>
        <c:choose>
            <c:when test="${selectCultureList != null && fn:length(selectCultureList) > 0 }">
                <c:forEach items="${selectCultureList}" var="selectCultureList">
                    <c:if test="{i%j == 0}">
                        <tr>
                    </c:if>

                    <td align="center">
                        <a href="cultureDetail?svcId=${selectCultureList.svcId}">링크</a><br>
                        <img src="<c:out value="${selectCultureList.imgUrl}" />" width="250px" height="300px">
                        <hr>
                        <c:out value="${selectCultureList.minClassName}"/> <br>
                        <c:out value="${selectCultureList.serviceName}"/><br>
                        <c:out value="${selectCultureList.svcId}"/>
                    </td>


                    <c:if test="${i%j == j-1}">
                        </tr>
                    </c:if>
                    <c:set var="i" value="${i+1}"/>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td>내역이 존재하지 않습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>


<div id="pagingArea">
    <ul class="pagination">
        <c:choose>
            <c:when test="${ pi.currentPage eq 1 }">
                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="selectCultureList?cpage=${pi.currentPage -1 }">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <c:forEach var="item" begin="${pi.startPage }" end="${pi.endPage }">
            <li class="page-item"><a class="page-link" href="selectCultureList?cpage=${item }">${item }</a></li>
        </c:forEach>

        <c:choose>
            <c:when test="${ pi.currentPage eq pi.maxPage }">
                <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="selectCultureList?cpage=${pi.currentPage + 1}">Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>



</body>




</div>


</body>
</html>
