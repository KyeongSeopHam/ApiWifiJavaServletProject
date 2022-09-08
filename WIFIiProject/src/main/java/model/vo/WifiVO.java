package model.vo;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
vo = 테이블이랑 매칭된 네임들

 */
public class WifiVO {
    private String distance;
    private String mgrNo;
    private String wrdofc;
    private String mainNm;
    private String adres1;
    private String adres2;
    private String floor;
    private String ty;
    private String mby;
    private String svcSe;
    private String cmcwr;
    private String year;
    private String door;
    private String remars3;
    private String lat;
    private String lnt;
    private String dttm;
}