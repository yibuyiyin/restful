package com.yibuyiyin.restful.controller;

import com.yibuyiyin.restful.enums.common.ErrorInfo;
import com.yibuyiyin.restful.library.data.DemoData;
import com.yibuyiyin.restful.model.common.ResultModel;
import com.yibuyiyin.restful.model.vo.demo.DemoVO;
import lombok.var;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResultModel<DemoVO> get(@PathVariable Integer id) {
        var ret = new ResultModel<DemoVO>();
        try {
            var data = demoData.getInfoById(id);
            ret.setData(data);
        } catch (Exception e) {
            ret.failure(e);
        }
        return ret;
    }

    /**
     * 新增内容
     *
     * @param vo
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<T> add(@RequestBody DemoVO vo) {
        var ret = new ResultModel<Boolean>();
        try {
            var demoId = demoData.addInfo(vo);
            ret.setData(demoId);
        } catch (Exception e) {
            ret.failure(e);
        }
//        ret.failure(ErrorInfo.EXPIRE);
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
    public ResultModel<Boolean> update(@PathVariable Integer id, @RequestBody DemoVO vo) {
        var ret = new ResultModel<Boolean>();
        try {
            var isRet = demoData.updateInfoById(id, vo);
            if (!isRet) {
//               ret.failure("DEMO更新失败");
            }
        } catch (Exception e) {
            ret.failure(e);
        }
        return ret;
    }

    /**
     * 删除内容
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultModel<Boolean> delete(@PathVariable Integer id) {
        var ret = new ResultModel<Boolean>();
        try {
            var isRet = demoData.deleteInfoById(id);
            if (!isRet) {
//                ret.failure("DEMO删除失败");
            }
        } catch (Exception e) {
            ret.failure(e);
        }
        return ret;
    }
}
