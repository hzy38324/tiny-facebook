package com.b4u.tinyfacebook.controller.test;

import com.b4u.tinyfacebook.util.TestMockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.io.File;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/23
 */
@RestController
@RequestMapping("/test")
@Validated
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

    @RequestMapping(value="/mock", method= RequestMethod.GET)
    public String testMockStatic() {
        logger.info("testMockStatic begin");
        return TestMockUtil.testMockStatic(new File(""));
    }

    @RequestMapping(value="/validation", method= RequestMethod.GET)
    public String testValidation(@Size(max = 4) @RequestParam String status) {
        logger.info("testValidation begin");
        return "Validate success";
    }
}
