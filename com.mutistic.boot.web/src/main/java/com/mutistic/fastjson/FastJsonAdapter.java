package com.mutistic.fastjson;

import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * @program 添加FastJSON 转换适配器
 * @description 
 * @author mutisitic
 * @date 2018年8月7日
 */
@SpringBootConfiguration
public class FastJsonAdapter extends WebMvcConfigurerAdapter {
	
	/**
	 * @description 方式一：使用创建HttpMessageConverters bean
	 * @author mutisitic
	 * @date 2018年8月7日
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverter () {
		// 1、定义一个 convert转换类
		FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
		// 2、添加 fastJson 配置信息，比如是否要格式化返回的json数据
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 3、在 convert种添加 config配置信息
		convert.setFastJsonConfig(config);
		/// 4、将 convert转换类添加到 HttpMessageConverters转换类集合中
		return new HttpMessageConverters(convert);
	}
	
	/**
	 * @description 方式一：使用WebMvcConfigurerAdapter方式实现数据转换
	 * @author mutisitic
	 * @date 2018年8月7日
	 * @param converters
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureMessageConverters(java.util.List)
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		convert.setFastJsonConfig(config);
		converters.add(convert);
	}
}
