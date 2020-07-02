package com.yibuyiyin.restful.library.data;

import com.yibuyiyin.restful.library.dao.db.mapper.DemoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String getName() {
        return "DemoData";
    }

//    /**
//     * 保存Demo信息
//     *
//     * @param vo
//     * @return
//     */
//    public Integer addInfo(DemoVO vo) {
//        var demo = new Demo();
//        final BeanCopier copier = BeanCopier.create(Demo.class, DemoVO.class, false);
//        copier.copy(vo, demo, null);
//        return demoMapper.insert(demo);
//    }
//
//    /**
//     * 删除Demo信息
//     *
//     * @param id
//     * @return
//     */
//    public Integer deleteInfoById(Integer id) {
//        return demoMapper.deleteById(id);
//    }
//
//    /**
//     * 更新Demo信息
//     *
//     * @param id
//     * @param vo
//     * @return
//     */
//    public Integer updateInfoById(Integer id, DemoVO vo) {
//        var demo = new Demo();
//        final BeanCopier copier = BeanCopier.create(Demo.class, DemoVO.class, false);
//        copier.copy(vo, demo, null);
//        demo.setId(id);
//        return demoMapper.updateById(demo);
//    }
//
//    /**
//     * 返回Demo详情信息
//     *
//     * @param id
//     * @return
//     */
//    public DemoVO getInfoById(Integer id) {
//        var demoVO = new DemoVO();
//        var demo = demoMapper.selectById(id);
//        final BeanCopier copier = BeanCopier.create(Demo.class, DemoVO.class, false);
//        copier.copy(demo, demoVO, null);
//        return demoVO;
//    }
//
//    /**
//     * 返回Demo分页列表
//     *
//     * @return
//     */
//    public void getPageList() {
//    }
}
