package model;

import apiTestScetion.WifiApiJsonService;
import apidto.WifiDto;

public class TestDB {
    public static void main(String[] args) {

        WifiDto wifiDto = new WifiDto();


        WifiApiJsonService wifiApiJsonService = new WifiApiJsonService();
        int pageCount = 0;
        int count =0;



        try {
            pageCount = wifiApiJsonService.getTotalPageCount();
            count  = wifiApiJsonService.getTotalCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("페이지카운트:"+pageCount);
        System.out.println("토탈카운트:"+count);


        DAO dao = new DAO();
        int start=0;
        int end=999;

        for(int i=0; i<pageCount; i++){

            try {
                dao.saveAllWifiDetailList // dao에게 Insert를 시킬건데
                (wifiApiJsonService.requestApiAndResponseToDto(start,end).// 제네릭타입의<RowInfo>타입의 리스트가필요한데
                        getWifiDetails()); // 그래서 getWifedeatails메소드를 사용했다. WifiDto가 그걸가지고있다.



                start+=1000;
                end+=1000;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }
}
