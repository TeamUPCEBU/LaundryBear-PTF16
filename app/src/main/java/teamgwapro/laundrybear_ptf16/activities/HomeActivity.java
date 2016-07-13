package teamgwapro.laundrybear_ptf16.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

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
//    butterknife binds
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
        AuthToken authToken = new AuthToken();
        authToken.setToken(user.getToken());
        displayUserTransactions(user);
    }
    //backend happens here
    public void retrieveTransactions(AuthToken authToken){
        Call<TransactionList> call = laundryBearAPIService.getTransactions(authToken);
        call.enqueue(new Callback<TransactionList>() {
            @Override
            public void onResponse(Call<TransactionList> call, Response<TransactionList> response) {
                if(response.code() == 200){
                    TransactionList transactionList = response.body();
                    CacheManager.storeUserTransactions(HomeActivity.this,transactionList);
                } else{

                }
            }

            @Override
            public void onFailure(Call<TransactionList> call, Throwable t) {
                Log.d("","No Transactions");
            }
        });
    }


    //temp list for trials only
    private List<Transaction> listOfTransactions;


    //display user info in homeactivity
    private void displayUserTransactions(User user){
        transac_list.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(HomeActivity.this);
        transac_list.setLayoutManager(llm);
        transac_list.setItemAnimator(new DefaultItemAnimator());
        TransactionsAdapter transactionsAdapter = new TransactionsAdapter(listOfTransactions);
        Log.d("", Integer.toString(transactionsAdapter.getItemCount()));
        transac_list.setAdapter(new TransactionsAdapter(listOfTransactions));
    }
}
