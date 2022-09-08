package controller;


import apiTestScetion.WifiApiJsonService;
import apidto.RowInfoDto;
import apidto.WifiDto;
import model.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.List;

/**
 * Open Api 와이파이 정보 로딩하기
 * 1.  공공데이터 wifi json 수집 ( wifiApliJsonService) // 와이파이수집서비스   Ok
 * 2.  Json 형태를 -> Object로 파싱작업  Ok
 * <p>
 * 3.  Object로 파싱한 결과를 ->  DB에 Insert (저장)
 * 4.  화면에 총 파싱한 결과의 갯수를 출력. ok
 */

@WebServlet("/ApiWifiController")
public class ApiWifiServlet_NewVersion extends HttpServlet {

    WifiApiJsonService wifiApiServzice = new WifiApiJsonService();   // 와이파이 API Json으로 가져오는 메소드사용하기위해서 객체할당
    DAO wifiDao = new DAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse respons) throws
            IOException, HTTPException {


        try {
            int count = wifiApiServzice.getTotalPageCount();


//            int count = wifiApiService.getTotalCount();
            int start = 0;
            int end = 999;


            // wifiDao의 객체를 만든다 -> for문
            // wifiDao의 역할이 Insert 하는거니까 만들어야함.

            wifiDao.removeAllData();

            for (int i = 0; i < count; i++) { // 카운트의 횟수까지 돌면서 (ex) 18003 => 19번

                System.out.println(start+" , "+ end);
                WifiDto wifiDto = wifiApiServzice.requestApiAndResponseToDto(start, end);// 처음에 0~999 순수하게 파싱까지다해서
                // WifiDto 타입으로 wifiDto 인스턴스에 넣어놓고


                //   그 파싱한 wifiDto 인스턴스에게 WifiDto(전체적인구조)부분에서 -> Details한 부분의 정보만 가져오라는거 그리고
                List<RowInfoDto> rowInfoDtos = wifiDto.getWifiDetails();
                // 그 가져온걸 rowInfoDtos 인스턴스가 그 참조값을 가리키고있고 그걸 리스트 <RowInfoDto> 타입이다.
                // 처음에는 0~999개까지의 리스트를 가지고있다가 for문을 돌면서 그다음은 1000~1999 이런식을 반복

                wifiDao.saveAllWifiDetailList(rowInfoDtos);
                // wifiDao에게 Insert메소드 수행한다.

                start += 1000;
                end += 1000;

            }
            // jsp에서 사용
            request.setAttribute("apiWifiTotalCount",wifiApiServzice.getTotalCount());// 데이터담기

            /**
             * 포워드
             */
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/apiWifiSend.jsp");// 보내야함
            requestDispatcher.forward(request,respons);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}


