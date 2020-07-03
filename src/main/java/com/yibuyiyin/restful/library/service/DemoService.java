package com.yibuyiyin.restful.library.service;

import com.yibuyiyin.restful.library.dao.db.entity.Demo;
import com.yibuyiyin.restful.library.data.DemoData;
import com.yibuyiyin.restful.model.common.PagedList;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    /**
     * redis invoke demo
     *
     * @return
     */
    public String redisQueueDemo(String str) {
        return demoData.redisQueueDemo(1, str);
    }

    /**
     * get demo page list
     *
     * @return
     */
    public PagedList<DemoVO> getPageList() {
        var list = demoData.getPageList(1, 10);
        var demo = new PagedList<DemoVO>();
        demo.setCurrentPage(list.getCurrent());
        demo.setPageSize(list.getSize());
        var demoList = new ArrayList<DemoVO>();
        final BeanCopier copier = BeanCopier.create(Demo.class, DemoVO.class, false);
        for (var data : list.getRecords()) {
            var vo = new DemoVO();
            copier.copy(data, vo, null);
            demoList.add(vo);
        }
        demo.setRecords(demoList);
        demo.setTotalSize(list.getTotal());
        return demo;
    }
}
