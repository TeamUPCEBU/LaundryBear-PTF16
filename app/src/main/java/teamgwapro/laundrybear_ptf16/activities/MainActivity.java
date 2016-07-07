package teamgwapro.laundrybear_ptf16.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import teamgwapro.laundrybear_ptf16.R;
import teamgwapro.laundrybear_ptf16.managers.CacheManager;
import teamgwapro.laundrybear_ptf16.models.AuthToken;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AuthToken authToken = CacheManager.retrieveAuthToken(MainActivity.this);
        Intent intent = new Intent();
        if (authToken == null){
            intent.setClassName("teamgwapro.laundrybear_ptf16",
                    "teamgwapro.laundrybear_ptf16.activities.LoginActivity");
            Log.d(MainActivity.class.getSimpleName().toString(), "No Log In info.");
        }
        else {
            intent.setClassName("teamgwapro.laundrybear_ptf16",
                    "teamgwapro.laundrybear_ptf16.activities.HomeActivity");

            Log.d(MainActivity.class.getSimpleName().toString(), "Has Log In info.");
        }
        startActivity(intent);
    }
}
