package com.atme.springcloud.controller;

import com.atme.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
// 不会自动刷新，需要localhost:3355/actuator/refresh 刷新
public class ConfigController {

    private final static String InstanceName = "client-config3366";

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public CommonResult<String> getConfigInfo() {
        return new CommonResult<String>(InstanceName, configInfo);
    }
}
