package com.naosim.spark;

import com.naosim.spark.api.Sample;
import com.naosim.spark.lib.basicauth.AuthenticationDetails;
import com.naosim.spark.lib.basicauth.BasicAuthenticationFilter;
import com.naosim.spark.lib.spark.HttpMethod;
import com.naosim.spark.lib.spark.RouteDefine;
import com.naosim.spark.lib.spark.SparkBaseApplication;
import hello.Hoo;
import spark.Spark;

import static com.naosim.spark.lib.spark.HttpMethod.get;
import static com.naosim.spark.lib.spark.RouteDefine.def;

/**
 * Created by nao_pillows on 2015/06/21.
 */
public class Router extends SparkBaseApplication {
    private final int port;

    public Router(int port) {
        this.port = port;
    }

    @Override
    public void initBeforeRouting() {
        Spark.port(port);
        Spark.before(new BasicAuthenticationFilter(new AuthenticationDetails("1", "2")));
    }

    @Override
    public RouteDefine[] getRouteDegineList() {
        return new RouteDefine[] {
                def(get, "sample", new Sample()::route, "sample"),
                def(get, "ok", new Hoo()::route, "ok")
        };
    }

}
