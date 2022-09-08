package apidto;

import com.google.gson.annotations.SerializedName;
import lombok.Data; //롬북

@Data
public class RowInfoDto {

    @SerializedName("X_SWIFI_MGR_NO")
    private String mgrNo;
    @SerializedName("X_SWIFI_WRDOFC")
    private String wrdofc;
    @SerializedName("X_SWIFI_MAIN_NM")
    private String mainNm;


    @SerializedName("X_SWIFI_ADRES1")
    private String adres1;
    @SerializedName("X_SWIFI_ADRES2")
    private String adres2;
    @SerializedName("X_SWIFI_INSTL_FLOOR")
    private String floor;


    @SerializedName("X_SWIFI_INSTL_TY")
    private String ty;
    @SerializedName("X_SWIFI_INSTL_MBY")
    private String mby;
    @SerializedName("X_SWIFI_SVC_SE")
    private String svcSe;


    @SerializedName("X_SWIFI_CMCWR")
    private String cmcwr;
    @SerializedName("X_SWIFI_CNSTC_YEAR")
    private String year;
    @SerializedName("X_SWIFI_INOUT_DOOR")
    private String door;
    @SerializedName("X_SWIFI_REMARS3")
    private String remars3;


    @SerializedName("LAT")
    private String lat;
    @SerializedName("LNT")
    private String lnt;
    @SerializedName("WORK_DTTM")
    private String dttm;


}