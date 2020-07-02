package com.yibuyiyin.restful.controller;

import com.yibuyiyin.restful.model.common.ResultModel;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import lombok.var;
import org.springframework.web.bind.annotation.*;

/**
 * restful controller demo.
 *
 * @author peng.yu
 */
@RequestMapping("/demo")
@RestController
public class DemoController {
    /**
     * 查询详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResultModel get(@PathVariable Integer id) {
        var ret = new ResultModel();
        return ret;
    }

    /**
     * 新增内容
     *
     * @param vo
     * @return
     */
    @PostMapping("/")
    public Boolean add(@RequestBody DemoVO vo) {
        return true;
    }

    /**
     * 更新内容
     *
     * @param id
     * @param vo
     * @return
     */
    @PutMapping("/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody DemoVO vo) {
        return 1;
    }

    /**
     * 删除内容
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return true;
    }
}
