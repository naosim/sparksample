package com.naosim.spark.lib.spark;

import spark.Route;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public class RouteDefine {
    private final HttpMethod method;
    private final String routePath;
    private final Route route;
    private final String description;

    public RouteDefine(HttpMethod method, String routePath, Route route, String description) {
        this.method = method;
        this.routePath = routePath;
        this.route = route;
        this.description = description;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getRoutePath() {
        return routePath;
    }

    public Route getRoute() {
        return route;
    }

    public String getDescription() {
        return description;
    }

    public static RouteDefine def(HttpMethod method, String routePath, Route route, String description) {
        return new RouteDefine(method, routePath, route, description);
    }
}
