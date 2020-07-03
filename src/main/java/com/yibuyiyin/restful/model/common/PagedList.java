package com.yibuyiyin.restful.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 返回结果Model
 */
@Data
@ApiModel(value = "分页后的当页记录")
public class PagedList<T> implements Serializable {

	private static final long serialVersionUID = -7604056494972561060L;

	@ApiModelProperty("总记录数")
	private Long totalSize;
	@ApiModelProperty("每页记录数")
	private Long pageSize;
	@ApiModelProperty(value = "当前页")
	private Long currentPage;
	@ApiModelProperty(value = "当前页记录")
	private List<T> records;
}
