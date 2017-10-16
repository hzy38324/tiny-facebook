package com.b4u.tinyfacebook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hzy
 * @Description:
 * @Date: Created on 19:47 2017/10/16
 */
@RestController
public class PostController {
    @RequestMapping("/post")
    public String post() {
        return "this is a post";
    }
}
