package apiTestScetion;

import apidto.WifiDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.net.URL;

/**
 1. okHttp  o
 2. 공공사이트 url+key값 가져오기
 3. request ( url) 작업
 4. reponse ( was로부터 작업결과 들고오기)

 */
public class WifiApiJsonService {
    WifiApiParser parser = new WifiApiParser();


    public WifiDto requestApiAndResponseToDto(int start, int end) throws Exception {

        OkHttpClient client = new OkHttpClient();

        String url = "http://openapi.seoul.go.kr:8088/6566634150727564363264436a4d79/json/TbPublicWifiInfo/"
                + start + "/" + end;

        URL urlRequest = new URL(url); // 내용물
        Request request = new Request.Builder() // 박스
                .url(urlRequest)
                .get()
                .build(); // 포장완료

        Response response = client.newCall(request).execute(); // 포장된박스를-> Api 사이트로 보냄

//        return response.body().string(); // Json 문자열로 가져온것

        String json = response.body().string(); // 문자열로 리턴하지말고 그냥 제이슨->파싱까지 (한번에묶어서작업)

        return parser.parse(json); // 이부분에서 그 작업을 return parser.parse(json)


    }

    /**
     *
     getTotalPageCount() => 18페이지   (1000개씩)
     @getTotalCount() => 17830개
     */

    public int getTotalPageCount() throws Exception {     //  17094-> 18set
        WifiDto dto = requestApiAndResponseToDto(0, 1);
        int totalCount = dto.getTotalcount();  // 총갯수


        int count = (totalCount / 1000); // 몫

        if ((totalCount % 1000) > 0) {  // 나머지1개라도존재한다면
            count++;
        }

        return count;
    }


    public int getTotalCount() throws Exception {    //  total Api count 17xxx개
        WifiDto dto = requestApiAndResponseToDto(0, 1); // json tpye 파싱후-> 일부
        int totalCount = dto.getTotalcount();  // 총갯수

        return totalCount;
    }


}
