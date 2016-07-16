package teamgwapro.laundrybear_ptf16.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import teamgwapro.laundrybear_ptf16.models.AuthToken;
import teamgwapro.laundrybear_ptf16.models.Transaction;
import teamgwapro.laundrybear_ptf16.models.TransactionList;
import teamgwapro.laundrybear_ptf16.models.User;

/**
 * Created by coderschool on 7/7/16.
 */
public class CacheManager {

    private static final String KEY_USER_INFO = "userInfo";
    private static final String KEY_USER_TRANSACTIONS = "usertransactions";

    public static void storeUserInfo(Context context, User user){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);

        editor.putString(KEY_USER_INFO, json);
        editor.apply();
    }

    public static User retrieveUserInfo(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_USER_INFO, null);
        User user = null;

       // Log.d("", "Hey im heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeere!!!!:    "+ json);
        if (json != null){
            user = gson.fromJson(json, User.class);
        }
        return user;
    }

    public static void storeUserTransactions(Context context, TransactionList transactionList){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(transactionList);

        Log.d("", "Hey im heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeere!!!!:    "+ transactionList);
        editor.putString(KEY_USER_TRANSACTIONS, json);
        editor.apply();
    }

    public static TransactionList retrieveTransactionList(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_USER_TRANSACTIONS, null);
        //Log.d("", "retrieveTransactionList: " + json);
        TransactionList transactionList = null;
        if (json != null)
            transactionList = gson.fromJson(json ,TransactionList.class);
        return transactionList;
    }
}
