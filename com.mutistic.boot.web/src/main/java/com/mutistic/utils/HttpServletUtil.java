package com.mutistic.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @program HttpServlet工具类
 * @description
 * @author mutisitic
 * @date 2018年8月6日
 */
public class HttpServletUtil {

	/**
	 * @description 获取客户端访问IP
	 * @author mutisitic
	 * @date 2018年8月6日
	 * @param request
	 * @return
	 */
	public static String getIPAddress(HttpServletRequest request) {
		String ip = null;
		// X-Forwarded-For：Squid 服务代理
		String ipAddresses = request.getHeader("X-Forwarded-For");
		// Proxy-Client-IP：apache 服务代理
		if (isEmpty(ipAddresses)) ipAddresses = request.getHeader("Proxy-Client-IP");
		// WL-Proxy-Client-IP：weblogic 服务代理
		if (isEmpty(ipAddresses)) ipAddresses = request.getHeader("WL-Proxy-Client-IP");
		// HTTP_CLIENT_IP：有些代理服务器
		if (isEmpty(ipAddresses)) ipAddresses = request.getHeader("HTTP_CLIENT_IP");
		// X-Real-IP：nginx服务代理
		if (isEmpty(ipAddresses)) ipAddresses = request.getHeader("X-Real-IP");
		// 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
		if (!isEmpty(ipAddresses)) ip = ipAddresses.split(",")[0];
		// 还是不能获取到，最后再通过request.getRemoteAddr();获取
		if (isEmpty(ipAddresses)) ip = request.getRemoteAddr();
		return ip;
	}
	private static boolean isEmpty(String ipAddresses) {
		return ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses);
	}
}
