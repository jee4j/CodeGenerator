package com.jee4j;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Launcher;

public class Application extends Launcher {
    public static void main(String[] args) {
        new Application().dispatch(args);
    }

    @Override
    public void beforeDeployingVerticle(DeploymentOptions options) {
        super.beforeDeployingVerticle(options);
    }
}
