package com.mutistic.utils;

public class ViewUtil {

	public final static String VIEW_PREFIX_JSP = "/jsp/";
	public final static String VIEW_SUFFIX_JSP = ".jsp";

	public static String getViewJsp(String val) {
		return VIEW_PREFIX_JSP + val + VIEW_SUFFIX_JSP;
	}
}
