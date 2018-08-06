package com.mutistic.main;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mutistic.entity.BookEntity;
import com.mutistic.utils.CommonUtil;

public class BookControllerTest {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		testQueryById(rt);
		testQueryAllList(rt);
	}

	private static void testQueryAllList(RestTemplate rt) {
		String responseJSON = rt.getForObject("http://127.0.0.1:8888/bookController/queryAllList",
				String.class);

		CommonUtil.printOne("获取RestTemplate请求的结果：queryById：" + responseJSON);
		JSONObject resp = (JSONObject) JSON.parse(responseJSON);
		if (resp.get("data") != null) {
			List<JSONObject> dataList = JSON.toJavaObject((JSON) resp.parse(resp.get("data").toString()), List.class);
			for(JSONObject json : dataList) {
				CommonUtil.printThree("获取JSONObject转成的实体对象：", JSON.toJavaObject((JSONObject)JSON.parse(json.toString()), BookEntity.class));
			}
		}
	}

	private static void testQueryById(RestTemplate rt) {
		String responseJSON = rt.getForObject("http://127.0.0.1:8888/bookController/queryById?id=1533384516863",
				String.class);

		CommonUtil.printOne("获取RestTemplate请求的结果：queryById：" + responseJSON);
		JSONObject resp = (JSONObject) JSON.parse(responseJSON);
		if (resp.get("data") != null) {
			BookEntity book = JSON.toJavaObject((JSON) resp.parse(resp.get("data").toString()), BookEntity.class);
			CommonUtil.printThree("获取JSONObject转成的实体对象：", book.toString());
		}
	}

}
