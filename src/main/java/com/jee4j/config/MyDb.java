package com.jee4j.config;

import cn.hutool.db.Db;
import cn.hutool.db.ds.simple.SimpleDataSource;
import io.vertx.core.json.JsonObject;

import javax.inject.Singleton;


@Singleton
public class MyDb {

    public Db db;

    /**
     * 初始化数据库配置
     * @param config
     */
    public void initDb(JsonObject config){
        db  = Db.use(new SimpleDataSource(
                config.getString("url"),
                config.getString("username"),
                config.getString("password"),
                config.getString("driverClassName")
        ));
    }

}
