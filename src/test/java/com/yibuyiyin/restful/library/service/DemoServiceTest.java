package com.yibuyiyin.restful.library.service;

import com.yibuyiyin.restful.base.BaseTest;
import com.yibuyiyin.restful.library.data.DemoData;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class DemoServiceTest extends BaseTest {

    private Integer demoId = 0;

    @Autowired
    DemoData demoData;

    @Autowired
    DemoService demoService;

    @BeforeEach
    void setUp() {
        DemoVO vo = new DemoVO();
        vo.setName("test");
        demoId = demoData.addInfo(vo);
        assert demoId > 0 : "demo create fail.";
    }

    @AfterEach
    void setDown() {
        assert demoData.deleteInfoById(demoId) : "demo del fail.";
    }

    @Test
    void testRedis() {
        assert demoService.redisQueueDemo("DemoData").equals("DemoData");
    }

    @Test
    void getPageList() {
        assert demoService.getPageList().getRecords().size() > 0 : "demo list query fail.";
    }
}