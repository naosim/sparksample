package com.naosim.spark.lib.spark;

import spark.Spark;
import spark.servlet.SparkApplication;

import java.util.Arrays;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public abstract class SparkBaseApplication implements SparkApplication {
    @Override
    public void init() {
        initBeforeRouting();

        RouteDefine[] routes = getRouteDegineList();
        Arrays.stream(routes)
                .forEach(api -> {
                    System.out.println(api.getMethod().name() + " " + api.getRoutePath() + ": " + api.getDescription());
                });
        // ルーティング
        Arrays.stream(routes).forEach(api -> {
            switch (api.getMethod()) {
                case get:
                    Spark.get(api.getRoutePath(), api.getRoute());
                    break;
                case post:
                    Spark.post(api.getRoutePath(), api.getRoute());
                    break;
            }
        });
    }

    public void initBeforeRouting() {}

    abstract public RouteDefine[] getRouteDegineList();

}
