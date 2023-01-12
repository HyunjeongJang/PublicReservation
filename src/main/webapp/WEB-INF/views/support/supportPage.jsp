<%--
  Created by IntelliJ IDEA.
  User: yeomseohak
  Date: 2023/01/12
  Time: 3:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>결제 페이지</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="http://service.iamport.kr/js/iamport.payment-1.1.8.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>


<button onclick="iamport();">결제!</button>
<script>
    function iamport(){
        //가맹점 식별코드
        IMP.init('imp38841066');
        IMP.request_pay({
            pg : 'kcp',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '상품1' , //결제창에서 보여질 이름
            amount : 100, //실제 결제되는 가격
            buyer_email : 'iamport@siot.do',
            buyer_name : '구매자이름',
            buyer_tel : '010-1234-5678',
            buyer_addr : '서울 강남구 도곡동',
            buyer_postcode : '123-456'
        }, function(rsp) {
            console.log(rsp);
            if ( rsp.success ) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }
            alert(msg);
        });
    }
</script>


</body>
</html>
