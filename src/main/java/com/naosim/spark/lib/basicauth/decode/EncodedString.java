package com.naosim.spark.lib.basicauth.decode;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public class EncodedString {
    private final String value;

    public EncodedString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
