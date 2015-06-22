package com.naosim.spark.lib.basicauth.basicauthprime;

import com.naosim.spark.lib.basicauth.VerifyAuth;
import com.naosim.spark.lib.basicauth.decode.Base64Decoder;
import com.naosim.spark.lib.basicauth.decode.EncodedString;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public class BasicAuth {
    private static final int NUMBER_OF_AUTHENTICATION_FIELDS = 2;
    private final VerifyAuth verifyAuth;
    private Base64Decoder base64Decoder = new Base64Decoder();

    public BasicAuth(VerifyAuth verifyAuth) {
        this.verifyAuth = verifyAuth;
    }

    public void verify(String authorizationHeader, Runnable successCallback, Consumer<BasicAuthError> errorCallback) {
        if (verify(authorizationHeader)) {
            successCallback.run();
        } else {
            errorCallback.accept(new BasicAuthError());
        }

    }

    public void verify(String authorizationHeader, Consumer<BasicAuthError> errorCallback) {
        verify(authorizationHeader, () -> {
        }, errorCallback);
    }

    public boolean verify(String authorizationHeader) {
        return Optional.ofNullable(substringAfter(authorizationHeader, "Basic"))
                .map(v -> new EncodedString(v))
                .map(base64Decoder::apply)
                .map(v -> v.getValue().split(":"))
                .filter(v -> v.length == NUMBER_OF_AUTHENTICATION_FIELDS)
                .map(v -> verifyAuth.verify(v[0], v[1]))
                .orElse(false);

    }

    private static String substringAfter(final String str, final String separator) {
        return Optional.ofNullable(str)
                .filter(v -> str.length() != 0)
                .map(v -> v.indexOf(separator))
                .filter(v -> v != -1)
                .map(v -> str.substring(v + separator.length()))
                .orElse(null);
    }
}
