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
    <div class="paging">
    </div>

</div>


</body>

<script>

    window.onload = () =>{
        findAllPost();
    }

    function findAllPost() {


        const pagination = [[ ${response.pagination2} ]];
        const params = [[ ${params} ]];

        drawPage(pagination, params);
    }

    function drawPage(pagination, params) {

        if ( !pagination || !params ) {
            document.querySelector('.paging').innerHTML = '';
            throw new Error('Missing required parameters...');
        }

        let html = '';

        // 첫 페이지, 이전 페이지
        if (pagination.existPrevPage) {
            html += `
            <a href="javascript:void(0);" onclick="movePage(1)" class="page_bt first">첫 페이지</a>
            <a href="javascript:void(0);" onclick="movePage(${pagination.startPage - 1})" class="page_bt prev">이전 페이지</a>
        `;
        }

        // 페이지 번호
        html += '<p>';
        for (let i = pagination.startPage; i <= pagination.endPage; i++) {
            html += (i !== params.page)
                ? `<a href="javascript:void(0);" onclick="movePage(${i});">${i}</a>`
                : `<span class="on">${i}</span>`
        }
        html += '</p>';

        // 다음 페이지, 마지막 페이지
        if (pagination.existNextPage) {
            html += `
            <a href="javascript:void(0);" onclick="movePage(${pagination.endPage + 1});" class="page_bt next">다음 페이지</a>
            <a href="javascript:void(0);" onclick="movePage(${pagination.totalPageCount});" class="page_bt last">마지막 페이지</a>
        `;
        }

        document.querySelector('.paging').innerHTML = html;


    }

    function movePage(page) {
        const queryParams = {
            page: (page) ? page : 1,
            recordSize: 12,
            pageSize: 10
        }
        location.href = location.pathname + '?' + new URLSearchParams(queryParams).toString();
    }





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
