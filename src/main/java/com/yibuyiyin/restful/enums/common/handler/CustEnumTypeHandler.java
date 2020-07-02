package com.yibuyiyin.restful.enums.common.handler;

import com.yibuyiyin.restful.enums.common.BaseEnum;
import com.yibuyiyin.restful.util.EnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 枚举处理器
 * 供MyBatis数据库枚举类型处理
 * @author admin
 *
 * @param <T>
 */
public class CustEnumTypeHandler<T extends Enum<T> & BaseEnum> extends BaseTypeHandler<T> {

	private final Class<T> type;

	public CustEnumTypeHandler(Class<T> type) {
		if (type == null) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}
		this.type = type;
	}

	/**
	 * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的 Java类型
	 */
	@Override
	public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int value = rs.getInt(columnName);
		return rs.wasNull() ? null : EnumUtils.valueOf(this.type, value);
	}

	/**
	 * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的 Java类型
	 */
	@Override
	public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int value = rs.getInt(columnIndex);
		return rs.wasNull() ? null : EnumUtils.valueOf(this.type, value);
	}

	/**
	 * 用定义调用存储过程后，如何把数据库类型转换为对应的 Java类型
	 */
	@Override
	public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int value = cs.getInt(columnIndex);
		return cs.wasNull() ? null : EnumUtils.valueOf(this.type, value);
	}

	/**
	 * 用于定义设置参数时，该如何把 Java类型的参数转换为对应的数据库类型
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getTypeValue());
	}
}
