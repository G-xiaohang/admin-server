package com.gxh.demo;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class CodeGenerator {

    @Test
    public void run() {

        // 1、数据库配置
        String url = "jdbc:mysql://localhost:3306/admin-server?characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(url, username, password).build();

        // 2、全局配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .disableOpenDir()
                .author("gxh")
                .outputDir(projectPath + "/src/main/java")
                .dateType(DateType.ONLY_DATE)
                .enableSwagger()
                .build();

        // 3、包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.gxh")
                .moduleName("system")
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper.xml")
                .controller("controller")
                .build();

        // 4、策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                // 4.1 通用策略
                .addInclude("edu_teacher")
                .addTablePrefix("edu_")

                // 4.2 实体类策略
                .entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .enableLombok()

                // 4.3 控制器策略
                .controllerBuilder()
                .enableRestStyle()
                .enableHyphenStyle()

                // 4.4 服务类策略
                .serviceBuilder()
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImpl")

                .build();

        // 5、创建代码生成器并传递相关配置
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);
        autoGenerator.global(globalConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig);

        // 6、执行代码生成
        autoGenerator.execute();
    }
}

