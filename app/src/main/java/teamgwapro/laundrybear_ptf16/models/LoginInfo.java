package teamgwapro.laundrybear_ptf16.models;

import teamgwapro.laundrybear_ptf16.activities.LoginActivity;

/**
 * Created by coderschool on 7/7/16.
 */
public class LoginInfo {
    private String username;
    private String password;

    public LoginInfo(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String toString(){
        return this.username + this.password;
    }
}

