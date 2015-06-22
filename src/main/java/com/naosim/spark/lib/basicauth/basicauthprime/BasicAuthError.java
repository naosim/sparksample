package com.naosim.spark.lib.basicauth.basicauthprime;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public class BasicAuthError {
    private final String headerKey = "WWW-Authenticate";
    private final String headerValue = "Basic";
    private final int httpStatusCode = 401;

    public String getHeaderKey() {
        return headerKey;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}
