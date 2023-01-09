<%--
  Created by IntelliJ IDEA.
  User: yeomseohak
  Date: 2023/01/05
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<div class="content">
    <c:set var="i" value="0"/>
    <c:set var="j" value="4"/>
    <table border=1>
        <c:choose>
            <c:when test="${response.list != null && fn:length(response.list) > 0 }">
                <c:forEach items="${response.list}" var="list">
                    <c:if test="{i%j == 0}">
                        <tr>
                    </c:if>
                    <td align="center">
                        <img src="<c:out value="${list.imgUrl}" />" width="250px" height="300px">
                        <hr>
                        <c:out value="${list.minClassNm}"/> <br>
                        <c:out value="${list.svcNm}"/>
                    </td>
                    <%--                    <td><c:out value="${selectCultureList.minClassName}"/></td>--%>
                    <c:if test="${i%j == j-1}">
                        </tr>
                    </c:if>
                    <c:set var="i" value="${i+1}"/>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td>존재하지 않습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
    <!-- 페이징 처리 -->
        <div id="pagingArea">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${ params.page eq 1 }">
                        <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="selectPhysicalList?page=${params.page - 1}">Previous</a></li>
                    </c:otherwise>
                </c:choose>

                <c:forEach var="item" begin="${response.pagination2.startPagep }" end="${response.pagination2.endPage }">
                    <li class="page-item"><a class="page-link" href="selectPhysicalList?page=${item }">${item }</a></li>
                </c:forEach>

                <c:choose>
                    <c:when test="${ params.page eq response.pagination2.totalPageCount }">
                        <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="selectPhysicalList?page=${params.page + 1}">Next</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>







    <%--function movePage(bno) {--%>
    <%--    location.href = '${contextPath}/board/detail/${boardCode}/' + bno;--%>
    <%--}--%>

    <%--// 			 	$(function(){--%>
    <%--// 			 		$("#boardList>table>tbody tr").on('click', function(){--%>
    <%--// 			 			let bno = $(this).children().eq(0).text();--%>
    <%--// 			 			location.href = '${contextPath}/board/detail.bo?bno='+bno;--%>
    <%--// 			 		});--%>
    <%--// 			 	})--%>
</script>
</body>
</html>
