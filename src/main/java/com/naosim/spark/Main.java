package com.naosim.spark;

import java.util.Optional;

/**
 * Created by nao_pillows on 2015/06/22.
 */
public class Main {
    public static void main(String[] args) {
        int port = Optional.ofNullable(args)
                .filter(v -> v.length == 1)
                .map(v -> v[0])
                .map(v -> Integer.valueOf(v))
                .orElse(8080);

        new Router(port).init();
    }
}
