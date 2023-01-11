<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2023/01/07
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <h3>추천서비스</h3>
    <c:if test="${empty recommendCultureList }">
        <td colspan="5"> 추천서비스가 없습니다.</td>
    </c:if>
    <c:forEach items="${recommendCultureList }" var="recomendCultureList" >
        ${recomendCultureList.placeName}
    </c:forEach>
</div>

<div>
    <h3>최근 본 목록</h3>
</div>

<div>
    <h3>뉴스 크롤링</h3>

    <c:if test="${empty list }">
        <td colspan="6">게시글이 없습니다..</td>
    </c:if>
    <c:forEach var="b" items="${list }">
        <tr onclick="movePage(${b.boardNo});">
            <td class="bno" >${b.boardNo }</td>
            <td>${b.boardTitle }</td>
            <td>${b.boardWriter }</td>
            <td>${b.count }</td>
            <td>${b.createDate }</td>
            <td>
                <c:if test="${ not empty b.originName }">
                </c:if>
            </td>
        </tr>
    </c:forEach>

</div>


</body>
</html>
