package com.yibuyiyin.restful.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DemoControllerTest {

    @Autowired
    DemoController demoController;

    @Test
    void get() {
        demoController.get(1);
    }
}