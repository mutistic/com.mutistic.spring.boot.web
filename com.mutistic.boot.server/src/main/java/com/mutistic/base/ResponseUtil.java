package com.mutistic.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;

/**
 * @program Response 工具类
 * @description 
 * @author mutisitic
 * @date 2018年8月4日
 */
public class ResponseUtil {
	private static final Logger log = LoggerFactory.getLogger(ResponseUtil.class);

	
	public static ResponseEntity<ModelMap> setSuccess(Object data) {
		ModelMap mode = new ModelMap();
		if (data != null) {
			mode.put("data", data);
		}

		mode.put("code", HttpStatus.OK.value());
		mode.put("msg", HttpStatus.OK.getReasonPhrase());
		mode.put("timestamp", System.currentTimeMillis());
		log.info("response===> "+ JSON.toJSONString(mode));
		return ResponseEntity.ok(mode);
	}

}
