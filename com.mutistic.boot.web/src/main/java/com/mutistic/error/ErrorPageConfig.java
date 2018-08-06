package com.mutistic.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @program 自定义异常错误界面 
 * @description 
 * @author mutisitic
 * @date 2018年7月30日
 */
@Component
public class ErrorPageConfig implements ErrorPageRegistrar {

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage[] pageArray = new ErrorPage[3];
		pageArray[0] = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html"); // 配置404错误状态码，跳转的界面
		pageArray[1] = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html"); // 配置500错误状态码，跳转的界面
		pageArray[2] = new ErrorPage(IllegalArgumentException.class, "/error/args.html"); // 配置404错误状态码，跳转的界面
		
		registry.addErrorPages(pageArray); 
	}

}
