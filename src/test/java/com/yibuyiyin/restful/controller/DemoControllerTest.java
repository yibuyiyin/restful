package com.yibuyiyin.restful.controller;

import com.yibuyiyin.restful.base.ControllerBaseTest;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DemoControllerTest extends ControllerBaseTest {
    @Test
    public void add() throws Exception {
        String uri = "/demo/";
        DemoVO demo = new DemoVO();
        demo.setName("demo-testunit01.");

        String inputJson = super.mapToJson(demo);
        ResultActions mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .content(inputJson)
                .contentType("application/json; charset=utf-8")
                .accept("application/json; charset=utf-8"));
        System.out.println(mvcResult.andReturn().getResponse().getContentAsString());
        mvcResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("success")));
    }

    @Test
    public void get() throws Exception {
        String uri = "/demo/22";
        ResultActions mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType("application/json; charset=utf-8")
                .accept("application/json; charset=utf-8"));
        System.out.println(mvcResult.andReturn().getResponse().getContentAsString());
        mvcResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("success")))
                .andExpect(jsonPath("$.data.id", is(22)));
    }

    @Test
    public void update() throws Exception {
        String uri = "/demo/21";
        DemoVO demo = new DemoVO();
        demo.setName("demo-testunit01.");

        String inputJson = super.mapToJson(demo);
        ResultActions mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .content(inputJson)
                .contentType("application/json; charset=utf-8")
                .accept("application/json; charset=utf-8"));
        System.out.println(mvcResult.andReturn().getResponse().getContentAsString());
        mvcResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("success")));
    }

    @Test
    public void delete() throws Exception {
        String uri = "/demo/21";
        ResultActions mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
                .contentType("application/json; charset=utf-8")
                .accept("application/json; charset=utf-8"));
        System.out.println(mvcResult.andReturn().getResponse().getContentAsString());
        mvcResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("success")));
    }
}