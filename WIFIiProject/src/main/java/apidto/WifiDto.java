package apidto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class WifiDto {

    @SerializedName("list_total_count")
    private int totalcount;

    @SerializedName("RESULT")
    private ResultInfoDto result;

    @SerializedName("row")
    private List<RowInfoDto> wifiDetails;


}