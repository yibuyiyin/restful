package com.yibuyiyin.restful.library.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yibuyiyin.restful.library.dao.db.entity.Demo;
import com.yibuyiyin.restful.library.dao.db.mapper.DemoMapper;
import com.yibuyiyin.restful.library.dao.redis.DemoQueue;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

/**
 * Demo数据逻辑层
 *
 * @author peng.yu
 */

@Slf4j
@Component
public class DemoData {
    @Autowired
    DemoMapper demoMapper;

    @Autowired
    DemoQueue demoQueue;

    /**
     * 先进先出队列demo
     *
     * @param id
     * @return
     */
    public String redisQueueDemo(Integer id, String str) {
        demoQueue.push(id, str);
        return demoQueue.pop(id);
    }

    /**
     * 保存Demo信息
     *
     * @param vo
     * @return
     */
    public Integer addInfo(DemoVO vo) {
        var demo = new Demo();
        final BeanCopier copier = BeanCopier.create(DemoVO.class, Demo.class, false);
        copier.copy(vo, demo, null);
        var ret = demoMapper.insert(demo);
        return ret > 0 ? demo.getId() : 0;
    }

    /**
     * 删除Demo信息
     *
     * @param id
     * @return
     */
    public Boolean deleteInfoById(Integer id) {
        return demoMapper.deleteById(id) > 0;
    }

    /**
     * 更新Demo信息
     *
     * @param id
     * @param vo
     * @return
     */
    public Boolean updateInfoById(Integer id, DemoVO vo) {
        var demo = new Demo();
        final BeanCopier copier = BeanCopier.create(DemoVO.class, Demo.class, false);
        copier.copy(vo, demo, null);
        demo.setId(id);
        System.out.println(demo);
        return demoMapper.updateById(demo) > 0;
    }

    /**
     * 返回Demo详情信息
     *
     * @param id
     * @return
     */
    public DemoVO getInfoById(Integer id) {
        var demoVO = new DemoVO();
        var demo = demoMapper.selectById(id);
        final BeanCopier copier = BeanCopier.create(Demo.class, DemoVO.class, false);
        copier.copy(demo, demoVO, null);
        return demoVO;
    }

    /**
     * 返回Demo分页列表
     *
     * @param page
     * @param size
     */
    public Page getPageList(Integer page, Integer size) {
        var pagination = new Page(page, size);
        var pageList = demoMapper.selectPage(pagination,
                new QueryWrapper<Demo>().gt("ctime", "2020-01-01"));
        return pageList;
    }
}
