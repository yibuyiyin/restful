package com.yibuyiyin.restful.library.service;

import com.yibuyiyin.restful.library.data.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Demo业务逻辑层
 *
 * @author peng.yu
 */
@Slf4j
@Service
public class DemoService {

    @Autowired
    DemoData demoData;

    public String getName() {
        return demoData.getName();
    }
}
