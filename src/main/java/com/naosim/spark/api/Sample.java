package com.naosim.spark.api;

import spark.Request;
import spark.Response;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public class Sample {
    public Object route(Request request, Response response) throws Exception {
        return "sample";
    }
}
