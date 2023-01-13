<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2023/01/06
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세페이지</title>
    <style>
        table * {margin:5px}
        table {width: 100%}
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="contents">
    <br>
    <div class="innerOuter">
        <div>
            <h2>${cultureDetail.serviceName}</h2>
            <br>
            <a class="btn btn-secondary" style="float: right;" href="${pageContext.request.contextPath}/selectCultureList">목록으로</a>
            <br><br>
            <table id="contentArea" class="table" border="1">
                <tr>
                    <th colspan="2" style="align-content: center">${cultureDetail.placeName}</th>
                </tr>

                <tr>
                    <td> ${cultureDetail.placeName} </td>
                    <td rowspan="4"><img src="<c:out value="${cultureDetail.imgUrl}" />" width="400"></td>
                </tr>
                <tr>
                    <td> ${cultureDetail.svcId} </td>
                </tr>
                <tr>
                    <td> ${cultureDetail.areaName} </td>
                </tr>
                <tr>
                    <td> ${cultureDetail.serviceState} </td>
                </tr>
                <tr>
                    <th colspan="4">예약하기</th>
                </tr>
                <tr>
                    <td colspan="4"><p style="height: 150px;">예약정보</p></td>
                </tr>
            </table>
        </div>

        <br>

        <div id="map" style="width:100%;height:350px;">

        </div>

        <div align="center">

            <table id="replyArea" class="table" align="center">
                <thead>
                <tr>
                    <th colspan="2">
                        <textarea class="form-control" name="" id="content" rows="2" cols="55" style="resize: none; width: 100%"></textarea>
                    </th>
                    <th style="vertical-align: middle;"><button class="btn btn-secondary" onclick="insertReply();">등록하기</button></th>
                </tr>
                <tr>
                    <td colspan="3">댓글(<span id="rCount"></span>)</td>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b29bee6395982488962042875b786bc3"></script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(${cultureDetail.y}, ${cultureDetail.x}), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    var iwContent = '<div style="padding:5px;">${cultureDetail.placeName}</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(${cultureDetail.y}, ${cultureDetail.x}), //인포윈도우 표시 위치입니다
        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

    // 인포윈도우를 생성하고 지도에 표시합니다
    var infowindow = new kakao.maps.InfoWindow({
        map: map, // 인포윈도우가 표시될 지도
        position : iwPosition,
        content : iwContent,
        removable : iwRemoveable
    });

</script>




<script>
    $(function (){
        selectReplyList();
    })

    function selectReplyList(){
        $.ajax({
            url : "selectReply",
            //url : '${pageContext.request.contextPath}/board/reply.bo',
            data : {svcId : ${cultureDetail.svcId} },
            dataType : "json",
            success : function(list) {
                console.log(list);
                let str = "";
                for(let i of list){
                    str += "<tr>"
                        + "<td>" + i.replyWriter + "</td>"
                        + "<td>" + i.replyContent + "</td>"
                        + "<td>" + i.createDate + "</td>"
                        + "</tr>";
                }
                $("#replyArea tbody").html(str);
                $("#rCount").html(list.length);
            },
            error : function(){
                console.log("댓글리스트조회 ajax통신 실패");
            }
        });
    }


    function insertReply(){
        $.ajax({
            url:"insertReply",
            data:{
                replyContent : $("#content").val(),
                refBno : ${cultureDetail.svcId}
            },
            success : (result) => {
                if(result > 0){
                    selectReplyList();
                    $("#content").val("");
                }
            },
            error : function (){
                console.log("댓글 작성 ajax통신 실패");
            }
        });
    }

</script>

</body>
</html>
