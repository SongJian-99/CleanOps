package com.ops.langchain.config;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.dialect.JdbcTypeMapping;
import com.zaxxer.hikari.HikariDataSource;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Author: Cleaner
 * Date: 2025/9/16 16:50
 **/
public class Codegen {
    public static void main(String[] args) {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/clean_ops?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        JdbcTypeMapping.registerMapping(LocalDateTime.class, Date.class);
        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle1();
        //GlobalConfig globalConfig = createGlobalConfigUseStyle2();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMapperGenerateEnable(true);
        globalConfig.setControllerGenerateEnable(true);
        globalConfig.setEntityGenerateEnable(true);
        globalConfig.setServiceGenerateEnable(true);
        globalConfig.setServiceImplGenerateEnable(true);
        globalConfig.setMapperGenerateEnable(true);
        globalConfig.setMapperXmlGenerateEnable(true);

        globalConfig.getPackageConfig()
                .setBasePackage("com.ops.langchain");
        globalConfig.getStrategyConfig()
                .setLogicDeleteColumn("del_flag")
                .setGenerateTable("model_provider");
        globalConfig.getJavadocConfig()
                .setAuthor("Cleaner");
        globalConfig.getEntityConfig()
                .setClassSuffix("DO")
                .setOverwriteEnable(true)
                .setWithLombok(true)
                .setLombokNoArgsConstructorEnable(false)
                .setLombokAllArgsConstructorEnable(false)
                .setJdkVersion(17);
        globalConfig.getMapperConfig()
                .setClassSuffix("Mapper")
                .setOverwriteEnable(true)
                .setMapperAnnotation(true);
        return globalConfig;
    }
}
