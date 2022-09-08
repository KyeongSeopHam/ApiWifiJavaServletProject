<%--
  Created by IntelliJ IDEA.
  User: 나비
  Date: 2022-09-07
  Time: 오전 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>



<body>

<a href="/" class="btn btn-info" role=button" > &nbsp; 홈 &nbsp;&nbsp;</a>


<a href="/LocationServlet" class="btn btn-warnning" role=button" > 위치 히스토리 목록 &nbsp;&nbsp; </a>

<a href="/ApiWifiController" class="btn btn-success" role=button"> Open API 와이파이 정보 로딩하기  </a>






<br> <br>
<table class="table">

    <thead>
    <tr class ="danger">
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${selectAll}" var="history">
        <tr class ="Info">
            <td><c:out value="${history.id}"/></td>
            <td><c:out value="${history.lat}"/></td>
            <td><c:out value="${history.lnt}"/></td>
            <td><c:out value="${history.date}"/></td>
            <td> <button type ="button" class="button">삭제</button></td>
        </tr>









    </c:forEach>

    </tbody>

</table>


<script>
    $(".button").click(function () {

            var checkBtn = $(this);
            var tr = checkBtn.parent().parent();
            var td = tr.children();

            var deleteIdnumber = td.eq(0).text();
            // console.log(no);

        $.ajax({
            type:"POST",
            url: "http://localhost:8080/removeOneData?deleteIdnumber=" + deleteIdnumber

        }).done(function (){
            location.reload();
        })
    }
    )
</script>




</body>
</html>
