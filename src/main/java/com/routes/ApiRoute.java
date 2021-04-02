package com.routes;

import com.jfinal.config.Routes;
import com.mall.api.*;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-23 15:02
 */
public class ApiRoute extends Routes {
    @Override
    public void config() {
        add("/", index.class);
        add("/api", Api.class);

    }
}
