package com.b4u.tinyfacebook.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/23
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/discovery", method= RequestMethod.GET)
    public String testServiceDiscovery() {
        logger.info("testServiceDiscovery begin");
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return "hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId();
    }
}
