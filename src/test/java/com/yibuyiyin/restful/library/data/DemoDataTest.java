package com.yibuyiyin.restful.library.data;

import com.yibuyiyin.restful.base.BaseTest;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DemoDataTest extends BaseTest {

    @Autowired
    private DemoData demoData;

    private Integer demoId = 0;

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
    void updateInfoById() {
        DemoVO vo = new DemoVO();
        vo.setName("testtest");
        assert demoData.updateInfoById(demoId, vo) : "demo update fail.";
        assert demoData.getInfoById(demoId).getName().equals("testtest") : "demo update fail.";
    }

    @Test
    void getInfoById() {
        assert demoData.getInfoById(demoId).getId().equals(demoId) : "demo query fail.";
    }
}