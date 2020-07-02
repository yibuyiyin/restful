package com.yibuyiyin.restful.library.service;

import com.yibuyiyin.restful.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class DemoServiceTest extends BaseTest {

    @Autowired
    DemoService demoService;

    @Test
    void getName() {
        System.out.println(demoService.getName());
    }
}