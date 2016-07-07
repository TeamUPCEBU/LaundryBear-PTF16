package teamgwapro.laundrybear_ptf16.activities;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import teamgwapro.laundrybear_ptf16.R;
import teamgwapro.laundrybear_ptf16.managers.CacheManager;
import teamgwapro.laundrybear_ptf16.models.AuthToken;
import teamgwapro.laundrybear_ptf16.models.LoginInfo;

import butterknife.BindString;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teamgwapro.laundrybear_ptf16.utility.RestClient;
import teamgwapro.laundrybear_ptf16.utility.WebService;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // Binding with Butterknife
    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.sign_in)
    Button sign_in;

    // Login Messages
    @BindString(R.string.login_status)
    String MESSAGE_LOGGING_IN;
    @BindString(R.string.login_fail)
    String MESSAGE_FAILED;
    @BindString(R.string.login_success)
    String MESSAGE_WELCOME;
    private final String MESSAGE_EMPTY = "";

    private WebService laundryBearAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        laundryBearAPIService = new RestClient().getLaundryBearAPIService();
        sign_in.setOnClickListener(new SignInOnClickListener());
    }
    private class SignInOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String usernameInput = username.getText().toString();
            String passwordInput = password.getText().toString();

            loginWithCredentials(usernameInput, passwordInput);
        }
    }

    private void loginWithCredentials(String usernameInput, String passwordInput){
        LoginInfo loginInfo = new LoginInfo(usernameInput, passwordInput);

        Call<AuthToken> call = laundryBearAPIService.login(loginInfo);
        call.enqueue(new Callback<AuthToken>() {
            @Override
            public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {
                if(response.code() == 200){
                    AuthToken authToken = response.body();
                    Log.d(LoginActivity.class.toString() , response.body().toString());
                    CacheManager.storeAuthToken(LoginActivity.this, authToken);
                    Toast.makeText(LoginActivity.this, MESSAGE_WELCOME, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent();
                    finish();
                } else if (response.code() == 400){

                }
                Log.e(LoginActivity.class.getSimpleName(), String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<AuthToken> call, Throwable t) {
                Log.e(LoginActivity.class.getSimpleName(), "Login Failure" + t);
            }
        });
    }


}

