package com.b4u.tinyfacebook.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/discovery", method= RequestMethod.GET)
    public String testServiceDiscovery() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return "hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId();
    }
}
