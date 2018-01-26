package com.b4u.started;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/23
 */
@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${from: undefined}")
    private String from;

    @RequestMapping(value="/configClient", method= RequestMethod.GET)
    public String testConfigClient() {
        return from;
    }
}
