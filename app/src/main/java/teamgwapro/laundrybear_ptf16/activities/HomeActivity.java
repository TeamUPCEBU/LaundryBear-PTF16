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

import teamgwapro.laundrybear_ptf16.R;
import teamgwapro.laundrybear_ptf16.adapters.TransactionsAdapter;
import teamgwapro.laundrybear_ptf16.managers.CacheManager;
import teamgwapro.laundrybear_ptf16.models.AuthToken;
import teamgwapro.laundrybear_ptf16.models.Transaction;
import teamgwapro.laundrybear_ptf16.models.User;
import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.BindString;



public class HomeActivity extends AppCompatActivity {
//    butterknife binds
    @Bind(R.id.order_button)
    Button make_order;
    @Bind(R.id.transac_list)
    RecyclerView transac_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        //gets userinfo from sharedpreferences
        User user = CacheManager.retrieveUserInfo(HomeActivity.this);
        AuthToken authToken = new AuthToken();
        authToken.setToken(user.getToken());
        generateTransacs();
        displayUserTransactions(authToken);
    }
    //display user info in homeactivity
    private void displayUserTransactions(AuthToken authToken){
        transac_list.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(HomeActivity.this);
        transac_list.setLayoutManager(llm);
        transac_list.setItemAnimator(new DefaultItemAnimator());
        TransactionsAdapter transactionsAdapter = new TransactionsAdapter(listOfTransactions);
        Log.d("", Integer.toString(transactionsAdapter.getItemCount()));
        transac_list.setAdapter(new TransactionsAdapter(listOfTransactions));
    }


    //temp list for trials only
    private List<Transaction> listOfTransactions;

    private void generateTransacs(){
        listOfTransactions = new ArrayList<>();
        listOfTransactions.add(new Transaction(1,1,"Laundry Shop","Aug 11, 2013", "Aug 12, 2013",1,"2"));
        listOfTransactions.add(new Transaction(2,2,"Laundry Shop","Aug 11, 2013", "Aug 12, 2013",3,"2"));
        listOfTransactions.add(new Transaction(3,3,"Laundry Shop","Aug 11, 2013", "Aug 12, 2013",1,"2"));
        listOfTransactions.add(new Transaction(4,4,"Laundry Shop","Aug 11, 2013", "Aug 12, 2013",2,"2"));
    }

}
