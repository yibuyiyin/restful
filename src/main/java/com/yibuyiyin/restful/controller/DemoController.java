package com.yibuyiyin.restful.controller;

import com.yibuyiyin.restful.enums.common.error.ErrorInfo;
import com.yibuyiyin.restful.library.data.DemoData;
import com.yibuyiyin.restful.model.common.ResultModel;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * restful controller demo.
 *
 * @author peng.yu
 */
@RequestMapping(path = "/demo")
@RestController
public class DemoController {

    @Autowired
    private DemoData demoData;

    /**
     * 查询详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id) {
        var ret = new ResultModel();
        var data = demoData.getInfoById(id);
        ret.setData(data);
        return ret.response(ret);
    }

    /**
     * 新增内容
     *
     * @param vo
     * @return
     */
    @PostMapping("/")
    public ResponseEntity add(@RequestBody DemoVO vo) {
        var ret = new ResultModel();
        var demoId = demoData.addInfo(vo);
        ret.setData(demoId);
        return ret.response(ret);
    }

    /**
     * 更新内容
     *
     * @param id
     * @param vo
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody DemoVO vo) {
        var ret = new ResultModel();
        var isRet = demoData.updateInfoById(id, vo);
        if (!isRet) {
            ret.failure(ErrorInfo.DEMO_UPDATE_FAIL);
        }
        return ret.response(ret);
    }

    /**
     * 删除内容
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        var ret = new ResultModel();
        var isRet = demoData.deleteInfoById(id);
        if (!isRet) {
            ret.failure(ErrorInfo.DEMO_DELETE_FAIL);
        }
        return ret.response(ret);
    }
}
