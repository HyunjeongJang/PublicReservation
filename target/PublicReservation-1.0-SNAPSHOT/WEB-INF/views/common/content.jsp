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

<div align="center">
    <h2>추천서비스</h2>
    <table>


<%--    <c:if test="${empty recommendCultureList }">--%>
<%--        <td colspan="5"> 추천서비스가 없습니다.</td>--%>
<%--    </c:if>--%>
    <c:forEach items="${recommendCultureList }" var="recomendCultureList" >
        <tr style="width: 250px">
            <td>${recommendCultureList.placeName}</td>
            <td><img src="${recommendCultureList.imgUrl}"></td>
        </tr>
    </c:forEach>

    </table>

</div>

</body>
</html>
