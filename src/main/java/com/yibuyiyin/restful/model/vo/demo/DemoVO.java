package com.yibuyiyin.restful.model.vo.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * demo vo
 *
 * @author peng.yu
 */
@Data
@NoArgsConstructor
@ToString
@ApiModel(value = "Demo对象VO", description = "Demo详情")
public class DemoVO implements Serializable {

    private static final long serialVersionUID = -3815587402233403116L;

    @ApiModelProperty("DemoID")
    Integer id;

    @ApiModelProperty("Demo名称")
    String name;

    @ApiModelProperty("Demo创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date ctime;
}
