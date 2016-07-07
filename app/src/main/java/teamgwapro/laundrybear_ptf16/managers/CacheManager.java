package teamgwapro.laundrybear_ptf16.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import teamgwapro.laundrybear_ptf16.models.AuthToken;

/**
 * Created by coderschool on 7/7/16.
 */
public class CacheManager {

    private static final String KEY_AUTH_TOKEN = "authToken";

    public static void storeAuthToken(Context context, AuthToken authToken){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(authToken);

        editor.putString(KEY_AUTH_TOKEN, json);
        editor.apply();
    }

    public static AuthToken retrieveAuthToken(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_AUTH_TOKEN, null);
        AuthToken authToken = null;
        if (json != null){
            authToken = gson.fromJson(json, AuthToken.class);
        }
        return authToken;
    }

}
