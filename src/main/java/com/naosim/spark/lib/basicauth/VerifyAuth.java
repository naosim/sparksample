package com.naosim.spark.lib.basicauth;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public interface VerifyAuth {
    boolean verify(String username, String password);
}
