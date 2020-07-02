package com.yibuyiyin.restful.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Date转换器配置类
 */
@Slf4j
@Configuration
public class ConverterConfig {
	@Bean
	public ConversionServiceFactoryBean conversionService() {
		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		Set<Converter<?, ?>> converters = new HashSet<>();
		converters.add(new DateConverter());
		conversionServiceFactoryBean.setConverters(converters);
		return conversionServiceFactoryBean;
	}

	class DateConverter implements Converter<String, Date> {

		public Date convert(String source) {
			if (StringUtils.isBlank(source)) {
				return null;
			}

			if (source.matches("^\\d{4}-\\d{1,2}$"))
				return parseDate(source, "yyyy-MM");
			if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$"))
				return parseDate(source, "yyyy-MM-dd");
			if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$"))
				return parseDate(source, "yyyy-MM-dd hh:mm");
			if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
				return parseDate(source, "yyyy-MM-dd hh:mm:ss");
			}
			throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
		}

		public Date parseDate(String dateStr, String format) {
			if (StringUtils.isBlank(dateStr)) {
				return null;
			}
			Date date = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat(format);
				date = dateFormat.parse(dateStr);
			} catch (Exception exception) {
			    log.error(exception.getMessage(), exception);
			}

			return date;
		}
	}
}
