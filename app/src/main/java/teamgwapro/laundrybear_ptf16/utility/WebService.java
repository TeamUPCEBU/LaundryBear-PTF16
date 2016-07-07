package teamgwapro.laundrybear_ptf16.utility;


import retrofit2.http.Body;
import retrofit2.http.POST;
import teamgwapro.laundrybear_ptf16.models.AuthToken;
import teamgwapro.laundrybear_ptf16.models.LoginResult;
import teamgwapro.laundrybear_ptf16.models.LoginInfo;
import retrofit2.Call;
import retrofit2.http.Header;

/**
 * Created by coderschool on 7/7/16.
 */
public interface WebService {
    String BASE_URL = "http://10.48.32.5:8000/";
    String AUTH_TOKEN = "Authorization";

    @POST("/api-token-auth")
    Call<AuthToken> login(@Body LoginInfo logininfo);
}
