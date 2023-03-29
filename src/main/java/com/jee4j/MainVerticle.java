package com.jee4j;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jee4j.config.MyRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        JsonObject config = config();
        Injector injector = Guice.createInjector();

        Router router = Router.router(vertx);
        injector.getInstance(MyRouter.class).initRouter(router);

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(config.getJsonObject("server").getInteger("port"))
                .onSuccess(handle -> {
                    startPromise.complete();
                    System.out.println("####===== 项目启动成功 端口：" + handle.actualPort() + " =====####");
                })
                .onFailure(startPromise::fail);
    }
}
