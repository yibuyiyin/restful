package com.yibuyiyin.restful.library.dao.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 定义demo实体类
 *
 * @author peng.yu
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("demo")
@ApiModel(value = "Demo实体对象", description = "Demo信息表")
public class Demo implements Serializable {

    private static final long serialVersionUID = -3426398028822619987L;

    @ApiModelProperty("DemoID")
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;

    @ApiModelProperty("Demo名称")
    String name;

    @ApiModelProperty("Demo创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date ctime;
}
