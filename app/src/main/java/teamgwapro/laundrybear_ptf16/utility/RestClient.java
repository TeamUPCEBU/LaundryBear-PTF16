package teamgwapro.laundrybear_ptf16.utility;

/**
 * Created by Paks on 7/7/16.
 */

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private WebService laundryBearAPIService;

    public RestClient(){

//        Gson gson = new GsonBuilder();


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
