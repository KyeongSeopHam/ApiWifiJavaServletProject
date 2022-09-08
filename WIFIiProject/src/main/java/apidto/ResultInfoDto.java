package apidto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ResultInfoDto {

    @SerializedName("CODE")
    private String code;
    @SerializedName("MESSAGE")
    private String message;

}
