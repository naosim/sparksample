package com.naosim.spark.lib.basicauth;

/**
 * Created by nao_pillows on 2015/06/21.
 */
public class AuthenticationDetails implements VerifyAuth {
    private final String username;
    private final String password;
    public AuthenticationDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean verify(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
