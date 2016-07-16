package teamgwapro.laundrybear_ptf16.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teamgwapro.laundrybear_ptf16.R;
import teamgwapro.laundrybear_ptf16.adapters.TransactionsAdapter;
import teamgwapro.laundrybear_ptf16.managers.CacheManager;
import teamgwapro.laundrybear_ptf16.models.AuthToken;
import teamgwapro.laundrybear_ptf16.models.Transaction;
import teamgwapro.laundrybear_ptf16.models.TransactionList;
import teamgwapro.laundrybear_ptf16.models.User;
import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.BindString;
import teamgwapro.laundrybear_ptf16.utility.RestClient;
import teamgwapro.laundrybear_ptf16.utility.WebService;


public class HomeActivity extends AppCompatActivity {
    private String LOG_TAG = HomeActivity.class.getSimpleName();
    //butterknife binds
    @Bind(R.id.order_button)
    Button make_order;
    @Bind(R.id.transac_list)
    RecyclerView transac_list;

    //needed for the use of webservice
    private WebService laundryBearAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        laundryBearAPIService = new RestClient().getLaundryBearAPIService();
        ButterKnife.bind(this);


        //gets userinfo from sharedpreferences
        User user = CacheManager.retrieveUserInfo(HomeActivity.this);
        String authToken = user.getToken();
        retrieveTransactions(authToken);
//        Log.d("",authToken);

        TransactionList transactionList = CacheManager.retrieveTransactionList(HomeActivity.this);
//        Log.d("", transactionList.getTransactionList());
        //displayUserTransactions(transactionList.getTransactionList());
    }
    //backend happens here
    private void retrieveTransactions(String authToken){
        Call<Transaction[]> call = laundryBearAPIService.getTransactions(authToken);
        AsyncTask task = new Task();
        Call<Transaction[]>[] calls = new Call[1];
        calls[0] = call;
        task.execute(calls);

//        call.enqueue(new Callback<TransactionList>() {
//            @Override
//            public void onResponse(Call<TransactionList> call, Response<TransactionList> response) {
//                Log.d(LOG_TAG, "In onResponse");
//                Log.d(LOG_TAG, Integer.toString(response.code()));
//                if(response.code() == 200){
//                    TransactionList transactionList = response.body();
//                    CacheManager.storeUserTransactions(HomeActivity.this,transactionList);
//                } else{
//                    Log.e("","Error: "+ response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TransactionList> call, Throwable t) {
//                Log.d("","No Transactions");
//            }
//        });
//        Log.d(LOG_TAG, "After enqueue");
    }


    //temp list for trials only


    //display user info in homeactivity
    private void displayUserTransactions(List<Transaction> transactionList){
        transac_list.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(HomeActivity.this);
        transac_list.setLayoutManager(llm);
        transac_list.setItemAnimator(new DefaultItemAnimator());
        TransactionsAdapter transactionsAdapter = new TransactionsAdapter(transactionList);
        Log.d("", Integer.toString(transactionsAdapter.getItemCount()));
        transac_list.setAdapter(new TransactionsAdapter(transactionList));
    }

    class Task extends AsyncTask<Call<Transaction[]>, Void, Response<Transaction[]>> {
        private String LOG_TAG = Task.class.getSimpleName();

        @Override
        protected Response<Transaction[]> doInBackground(Call<Transaction[]>... calls) {
            Response<Transaction[]> res = null;
            try {

                res = calls[0].execute();
                Log.d(LOG_TAG, String.valueOf(res.code()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }
    }
}
