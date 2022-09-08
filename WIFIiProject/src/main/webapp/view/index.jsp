
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <style type="text/css">
        a { text-decoration:none }
    </style>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <a href="/view/index.jsp" class="btn btn-info" role=button" > &nbsp; 홈~ &nbsp;&nbsp;</a>


    <a href="/HomeServlet" class="btn btn-warnning" role=button"> 위치 히스토리 목록 &nbsp;&nbsp; </a>

    <a href="/ApiWifiController" class="btn btn-success" role=button"> Open API 와이파이 정보 로딩하기  </a>

    <br> <br>

    <form action="/LocationServlet" class="location-form">

            <label>LAT:</label>
            <label>
                <input id="latitude-input" name="latitude-input"  step="any" type="number" placeholder="X좌표"/>
            </label>

            <label>, LNT:</label>
            <label>

                <input id="longitude-input" name ="longitude-input" step="any"   type="number" placeholder="Y좌표"/>
            </label>
            <button id="myLocationButton" type="button" class="btn btn-danger"  onclick="restartLocation()">내 위치 가져오기</button>
            <button id="nearWifiButton" type="submit" class ="btn btn-info">근처 WIFI 정보 보기</button>


    </form>




    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">





    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>





<table class="table" style="undefinedtable-layout: fixed; width: 1833px">
    <colgroup>
        <col style="width: 86px">
        <col style="width: 77px">
        <col style="width: 74px">
        <col style="width: 147px">
        <col style="width: 197px">
        <col style="width: 127px">
        <col style="width: 83px">
        <col style="width: 134px">
        <col style="width: 99px">
        <col style="width: 144px">
        <col style="width: 104px">
        <col style="width: 59px">
        <col style="width: 73px">
        <col style="width: 116px">
        <col style="width: 97px">
        <col style="width: 103px">
        <col style="width: 113px">
    </colgroup>
    <thead>
    <tr class ="success">
        <td >거리(Km)</td>
        <td>관리번호</td>
        <td >자치구</td>
        <td >와이파이명</td>
        <td >도로명주소</td>
        <td >상세주소</td>
        <td >설치위치(층)</td>
        <td >설치유형</td>
        <td >설치기관</td>
        <td >서비스구분 </td>
        <td >망종류</td>
        <td >설치년도</td>
        <td>실내외구분</td>
        <td >WIFI접속환경</td>
        <td>X좌표</td>
        <td >Y좌표</td>
        <td>작업일자</td>



    </tr>
    </thead>



    <tbody>

    <c:forEach items="${searchList}" var="wifi">
    <tr class="warning">
            <td><c:out value="${wifi.distance}"/></td>
            <td><c:out value="${wifi.mgrNo}"/></td>
            <td><c:out value="${wifi.wrdofc}"/></td>
            <td><c:out value="${wifi.mainNm}"/></td>
            <td><c:out value="${wifi.adres1}"/></td>
            <td><c:out value="${wifi.adres2}"/></td>
            <td><c:out value="${wifi.floor}"/></td>
            <td><c:out value="${wifi.ty}"/></td>
            <td><c:out value="${wifi.mby}"/></td>
            <td><c:out value="${wifi.svcSe}"/></td>
            <td><c:out value="${wifi.cmcwr}"/></td>
            <td><c:out value="${wifi.year}"/></td>
            <td><c:out value="${wifi.door}"/></td>
            <td><c:out value="${wifi.remars3}"/></td>
            <td><c:out value="${wifi.lat}"/></td>
            <td><c:out value="${wifi.lnt}"/></td>
            <td><c:out value="${wifi.dttm}"/></td>

    </tr>
            </c:forEach>




    </tbody>






</table>



<script>
  function  restartLocation(){
      if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function (pos) {
              var latitude = pos.coords.latitude;
              var longitude = pos.coords.longitude;

              document.getElementById('latitude-input').value = latitude;
              document.getElementById('longitude-input').value = longitude;
          });
      } else {
          alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.")
      }
  }

</script>



</body>
</html>
