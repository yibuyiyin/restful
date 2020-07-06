package com.yibuyiyin.restful.controller;

import com.yibuyiyin.restful.base.ControllerBaseTest;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoControllerTest extends ControllerBaseTest {
    @Test
    public void add() throws Exception {
        String uri = "/demo/";
        DemoVO demo = new DemoVO();
        demo.setName("demo-testunit.");

        String inputJson = super.mapToJson(demo);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
}