<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Public Reservation Service</title>
</head>
<body>

<jsp:include page="common/header.jsp" />


<%--<c:forEach items="${cultureList}" var="culture">--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            <c:out value="${culture.svcid}"/>--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            <c:out value="${culture.minClassNm}"/>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--</c:forEach>--%>

<br><br>
<h2>${content}</h2>


</body>
</html>