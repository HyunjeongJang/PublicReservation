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

    <%--    <%@ page isELIgnored="false" %>--%>

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
<br><br>
<div align="center">
    <a href="/insertCultureList">데이터 가져오기</a>
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
                        <img src="<c:out value="${selectCultureList.imgUrl}" />" width="250px" height="300px">
                        <hr>
                        <c:out value="${selectCultureList.minClassName}"/> <br>
                        <c:out value="${selectCultureList.serviceName}"/>
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
</div>



<!-- 페이지 이동기능 구현 -->
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


























<br>

<%--        <c:set var ="url" value="${boardCode }?cpage="/>--%>
<%--        <!-- 페이지 이동기능 구현 -->--%>
<%--        <div id="pagingArea">--%>
<%--            <ul class="pagination">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${ pi.currentPage eq 1 }">--%>
<%--                        <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        &lt;%&ndash;							<li class="page-item"><a class="page-link" href="list.bo?cpage=${pi.currentPage - 1}&s_type=${s_type}&s_content=${s_content}">Previous</a></li>&ndash;%&gt;--%>
<%--                        <li class="page-item"><a class="page-link" href="${url}${pi.currentPage -1 }${sUrl}">Previous</a></li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--                <c:forEach var="item" begin="${pi.startPage }" end="${pi.endPage }">--%>
<%--                    &lt;%&ndash;						<li class="page-item"><a class="page-link" href="list.bo?cpage=${item}&s_type=${s_type}&s_content=${s_content}">${item }</a></li>&ndash;%&gt;--%>
<%--                    <li class="page-item"><a class="page-link" href="${url}${item }${sUrl}">${item }</a></li>--%>
<%--                </c:forEach>--%>

<%--                <c:choose>--%>
<%--                    <c:when test="${ pi.currentPage eq pi.maxPage }">--%>
<%--                        <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        &lt;%&ndash;							<li class="page-item"><a class="page-link" href="list.bo?cpage=${pi.currentPage + 1}&s_type=${s_type}&s_content=${s_content}">Next</a></li>&ndash;%&gt;--%>
<%--                        <li class="page-item"><a class="page-link" href="${url}${pi.currentPage + 1 }${sUrl}">Next</a></li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--            </ul>--%>
<%--        </div>--%>


<!-- 검색 기능 구현 -->
<%--        <br clear="both"><br>--%>

<%--        <form id="searchForm" action="${boardCode }" method="get" align="center">--%>
<%--            <div class="select">--%>
<%--                <select class="custom-select" name="condition">--%>
<%--                    &lt;%&ndash;						검색 내코드 &ndash;%&gt;--%>
<%--                    &lt;%&ndash;						<option value="writer" ${s_type == 'WRITER' ? "selected" : "" }>작성자</option>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;						<option value="title" ${s_type == 'TITLE' ? "selected" : "" }>제목</option>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;						<option value="content" ${s_type == 'CONTENT' ? "selected" : "" }>내용</option>&ndash;%&gt;--%>
<%--                    <option value="writer">작성자</option>--%>
<%--                    <option value="title">제목</option>--%>
<%--                    <option value="content">내용</option>--%>
<%--                    <option value="titleAndContent">제목+내용</option>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class="text">--%>
<%--                <input type="text" class="form-control" name="keyword">--%>
<%--            </div>--%>
<%--            <button type="submit" class="searchBtn btn btn-secondary">검색</button>--%>
<%--        </form>--%>
<%--        <br><br>--%>
<%--    </div>--%>
<br><br>


</div>


</body>
</html>
