package com.naosim.spark.lib.basicauth.decode;

import org.apache.commons.codec.binary.Base64;

import java.util.Optional;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public class Base64Decoder implements Decoder {
    @Override
    public DecodedString apply(EncodedString encodedString) {
        return Optional.of(encodedString)
                .map(v -> v.getValue())
                .map(v -> Base64.decodeBase64(v))
                .map(v -> new String(v))
                .map(v -> new DecodedString(v)).get();
    }
}
