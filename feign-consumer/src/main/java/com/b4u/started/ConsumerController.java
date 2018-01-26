package com.b4u.started;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/25
 */
@RestController
public class ConsumerController {
    @Autowired
    TinyFacebookService tinyFacebookService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return tinyFacebookService.hello();
    }
}
