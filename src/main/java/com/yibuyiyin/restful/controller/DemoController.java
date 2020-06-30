package com.yibuyiyin.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * restful controller demo.
 *
 * @author peng.yu
 */
@RestController
public class DemoController {

    @GetMapping("/test")
    public String test() {
        return "hello world.";
    }
}
