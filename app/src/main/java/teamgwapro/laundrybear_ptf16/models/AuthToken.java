package teamgwapro.laundrybear_ptf16.models;

/**
 * Created by coderschool on 7/7/16.
 */
public class AuthToken {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String genPostToken(){
        return "token " + token;
    }
}

