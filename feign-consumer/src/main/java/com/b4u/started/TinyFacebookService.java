package com.b4u.started;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("tiny-facebook")
public interface TinyFacebookService {

    @RequestMapping("/test/discovery")
    String hello();
}
