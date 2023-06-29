package com.gxh.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.gxh.system.mapper")
public class SystemConfig {
}
