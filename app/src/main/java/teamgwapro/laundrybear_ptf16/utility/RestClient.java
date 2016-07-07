package teamgwapro.laundrybear_ptf16.utility;

/**
 * Created by Paks on 7/7/16.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private WebService laundryBearAPIService;

    public RestClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(laundryBearAPIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        laundryBearAPIService = retrofit.create(WebService.class);
    }

    public WebService getLaundryBearAPIService() {
        return laundryBearAPIService;
    }
}
