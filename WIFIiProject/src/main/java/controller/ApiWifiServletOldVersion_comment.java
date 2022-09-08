//package controller;
//
//
//import apiTestScetion.WifiApiJsonService;
//import apidto.RowInfoDto;
//import apidto.WifiDto;
//import model.DAO;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.http.HTTPException;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
///**
// Open Api 와이파이 정보 로딩하기
//     1.  공공데이터 wifi json 수집 ( wifiApliJsonService) // 와이파이수집서비스   Ok
//     2.  Json 형태를 -> Object로 파싱작업  Ok
//
//     3.  Object로 파싱한 결과를 ->  DB에 Insert (저장)
//     4.  화면에 총 파싱한 결과의 갯수를 출력. ok
// */
//
//@WebServlet("/ApiWifiController")
//public class ApiWifiServlet extends HttpServlet {
//
//    WifiApiJsonService wifiApiService = new WifiApiJsonService();   // 와이파이 API Json으로 가져오는 메소드사용하기위해서 객체할당
//
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse respons) throws
//            IOException, HTTPException {
//
//
//
//
//        try {
//            int count = wifiApiService.getTotalPageCount();
//
//
//
////            int count = wifiApiService.getTotalCount();
//            int start = 0;
//            int end = 999;
//
//
//
//
//            DAO wifiDao = new DAO();
//            // wifiDao의 객체를 만든다 -> for문
//            // wifiDao의 역할이 Insert 하는거니까 만들어야함.
//
//            for (int i = 0; i < count; i++) { // 카운트의 횟수까지 돌면서 (ex) 18003 => 19번
//
//
//                WifiDto wifiDto = wifiApiService.requestApiAndResponseToDto(start, end);// 처음에 0~999 순수하게 파싱까지다해서
//                // WifiDto 타입으로 wifiDto 인스턴스에 넣어놓고
//
//
//                //   그 파싱한 wifiDto 인스턴스에게 WifiDto(전체적인구조)부분에서 -> Details한 부분의 정보만 가져오라는거 그리고
//                List<RowInfoDto> rowInfoDtos = wifiDto.getWifiDetails();
//                // 그 가져온걸 rowInfoDtos 인스턴스가 그 참조값을 가리키고있고 그걸 리스트 <RowInfoDto> 타입이다.
//                // 처음에는 0~999개까지의 리스트를 가지고있다가 for문을 돌면서 그다음은 1000~1999 이런식을 반복
//
//                wifiDao.saveAllWifiDetailList(rowInfoDtos);
//                // wifiDao에게 Insert메소드 수행한다.
//
//                start += 1000;
//                end += 1000;
//
//            }
//
//
//
//            print(respons, wifiApiService.getTotalCount()); // 컨트롤 + 알트 + m  => 메소드 추출기법
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//
//
//
//    private void print(HttpServletResponse respons, int count) throws IOException {
//
//        respons.setContentType("text/html;charset=utf-8");
//        respons.setCharacterEncoding("utf-8");
//        PrintWriter out = respons.getWriter();
//
//
//        out.println("<html><body>");
//        out.println("<div style=\"text-align:center\"> ");
//        out.println("<h1>" + "Total 토탈: " + count + "</h1>");
//
//        out.println("</div>");
//
//        out.println("<div  style=\"text-align:center\">");
//        out.println("<a href=http://localhost:8080/view/index.jsp>" + "Home ComeBack" + "</a>");
//        out.println("</div>");
//
//        out.println("</body></html>");
//    }
//}
//
//
