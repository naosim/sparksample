package com.naosim.spark.lib.basicauth;

import com.naosim.spark.lib.basicauth.basicauthprime.BasicAuth;
import spark.FilterImpl;
import spark.Request;
import spark.Response;
import spark.utils.SparkUtils;

import static spark.Spark.halt;

/**
 * Created by nao_pillows on 2015/06/21.
 */
public class BasicAuthenticationFilter extends FilterImpl {
    private static final String ACCEPT_ALL_TYPES = "*";
    private final BasicAuth basicAuth;

    public BasicAuthenticationFilter(final VerifyAuth verifyAuth) {
        this(SparkUtils.ALL_PATHS, verifyAuth);
    }

    public BasicAuthenticationFilter(final String path, final VerifyAuth verifyAuth) {
        super(path, ACCEPT_ALL_TYPES);
        this.basicAuth = new BasicAuth(verifyAuth);
    }

    @Override
    public void handle(final Request request, final Response response) {
        basicAuth.verify(request.headers("Authorization"), err -> {
            response.header(err.getHeaderKey(), err.getHeaderValue());
            halt(err.getHttpStatusCode());
        });
    }

}