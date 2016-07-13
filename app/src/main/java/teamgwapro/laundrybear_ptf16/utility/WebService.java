package teamgwapro.laundrybear_ptf16.utility;


import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import teamgwapro.laundrybear_ptf16.models.AuthToken;
import teamgwapro.laundrybear_ptf16.models.LoginResult;
import teamgwapro.laundrybear_ptf16.models.LoginInfo;
import retrofit2.Call;
import retrofit2.http.Header;
import teamgwapro.laundrybear_ptf16.models.TransactionList;
import teamgwapro.laundrybear_ptf16.models.User;

/**
 * Created by coderschool on 7/7/16.
 */
public interface WebService {
    //String BASE_URL = "http://172.16.8.68:54323/api/";
    String BASE_URL = "http://10.48.32.48:8000/api/";
    String AUTH_TOKEN = "authorization";

    @POST("login")
    Call<User> login(@Body LoginInfo logininfo);

    @GET("transactions/")
    Call<TransactionList> getTransactions(@Body AuthToken authToken);
}
