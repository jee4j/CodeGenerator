package com.jee4j.config;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class MyRouter {

    /**
     * 路由初始化
     * @param router
     */
    public void initRouter(Router router){
        router.route().handler(BodyHandler.create());

    }
}
