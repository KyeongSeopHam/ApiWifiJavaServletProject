package apiTestScetion;

import apidto.BaseDto;
import apidto.WifiDto;
import com.google.gson.Gson;

public class WifiApiParser {

    /* 파싱을위한 구조 설계
          1. Gson 라이브러리 사용
          2. Gson 로직 처리
           2-0.  2-1에 큰 엘레멘트리들 -> 작은 요소로 쪼개는작업(클래스 처리)
           2-1. 리턴타입은 파싱할 큰 엘레멘터리부분들 (일단 전체를가져와야함)
     */

    private Gson gson = new Gson();  // DB에는 제이슨형식으로 넣을수없기떄문에 Object형식으로 바꿔주기위해서 gson의 도움이필요하다.


    public WifiDto parse(String json){


        try{
            BaseDto wifiDto = gson.fromJson(json, BaseDto.class);  // 넘어온 json type을 ->  BaseDto.class type으로

            return wifiDto.getTbPublicWifiInfo();  // json -> 폼에맞게 전체 파싱 -> 이때 리턴타입은 BaseDto

        }catch (Exception e){
            throw new RuntimeException();
        }


    }




}
