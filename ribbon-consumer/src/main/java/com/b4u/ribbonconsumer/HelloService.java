package com.b4u.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/25
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://tiny-facebook/test/discovery", String.class).getBody();
    }

    public String helloFallback() {
        return "error";
    }

}