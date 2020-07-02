package com.yibuyiyin.restful.util;

import com.yibuyiyin.restful.enums.common.BaseEnum;

/**
 * 枚举工具类
 */
public class EnumUtils {
	public static <T extends Enum<?> & BaseEnum> T valueOf(Class<T> enumClass, int typeValue) {
		T[] enumConstants = enumClass.getEnumConstants();
		for (T t : enumConstants) {
			if (t.getTypeValue() == typeValue) {
				return t;
			}
		}
		return null;
	}
}
