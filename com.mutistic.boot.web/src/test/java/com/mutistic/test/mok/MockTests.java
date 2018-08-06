package com.mutistic.test.mok;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutistic.utils.CommonUtil;

/**
 * @program 使用@MockBean创建测试bean
 * @description 
 * @author mutisitic
 * @date 2018年8月4日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTests {

	/**
	 * 使用@MockBean创建测试bean
	 */
	@MockBean
	private MockUserMapper mockUserMapper;
	
	/**
	 * @description 在执行测试之前需要的前置通知 
	 * @author mutisitic
	 * @date 2018年8月4日
	 */
	@Before
	public void craterMockit() {
		BDDMockito.given(mockUserMapper.createrUser("mutistic")).willReturn(999);
		CommonUtil.printTwo("使用@Before 添加预测传入mutistic，返回结果为999：", "BDDMockito.given(mockUserMapper.createrUser(\"mutistic\")).willReturn(999);");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreater() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");	
		val.append("使用 @MockBean 创建bean用来做预测接口方法的测试：");
		val.append("\n[1、使用 @MockBean(org.springframework.boot.test.mock.mockito.MockBean)注解 创建bean]");
		val.append("\n[1.1、MockBean："+ mockUserMapper.getClass() +"]");
		val.append("\n[2、使用 org.mockito.BDDMockito.given()：调用接口方法]");
		val.append("\n[3、使用BDDMockito.given().willReturn()：预测接口的返回值]");
		val.append("\n[4、使用BDDMockito.given().willThrow()：预测接口抛出异常]");
		val.append("\n[4.1、预测接口抛出异常时需要，@Test注解通过 expected 字段 设置异常类型]");
		val.append("\n[5、预测信息也可以通过@Before(org.junit.Before)注解的方法配置]");
		System.out.println(val.toString());
		
		
		CommonUtil.printOne("以下时预测和断言信息：");
		// 调用接口，预测返回结果
		BDDMockito.given(mockUserMapper.createrUser("")).willReturn(0); // 预测传入空字符串，返回0
		CommonUtil.printTwo("预测传入空字符串，返回结果为0：", "BDDMockito.given(mockUserMapper.createrUser(\"\")).willReturn(0);");
		
		BDDMockito.given(mockUserMapper.createrUser("admin")).willReturn(1); // 预测传入admin，返回1
		CommonUtil.printThree("预测传入admin，返回结果为1：", "BDDMockito.given(mockUserMapper.createrUser(\"admin\")).willReturn(1);");
		
		BDDMockito.given(mockUserMapper.createrUser(null)).willThrow(NullPointerException.class); // 预测传入null，抛出  NullPointerException异常
		CommonUtil.printThree("预测传入null，抛出  NullPointerException异常：", "BDDMockito.given(mockUserMapper.createrUser(null)).willThrow(NullPointerException.class);");
		
		
		// 断言接口
		Assert.assertEquals(Integer.valueOf(0), mockUserMapper.createrUser("")); // 断言调用接口传入"" 结果为0
		CommonUtil.printTwo("断言调用接口传入\"\" 结果为0：断言成功：", "Assert.assertEquals(Integer.valueOf(0), mockUserMapper.createrUser(\"\"));");

		Assert.assertEquals(Integer.valueOf(1), mockUserMapper.createrUser("admin")); // 断言调用接口传入admin 结果为1
		CommonUtil.printThree("断言调用接口传入admin 结果为1：断言成功：", "Assert.assertEquals(Integer.valueOf(1), mockUserMapper.createrUser(\"admin\"));");
		
		Assert.assertEquals(Integer.valueOf(999), mockUserMapper.createrUser("mutistic")); // 断言调用接口传入预测不存在的信息
		CommonUtil.printThree("断言调用接口传入mutistic 结果为999：断言成功：", "Assert.assertEquals(Integer.valueOf(999), mockUserMapper.createrUser(\"mutistic\"));");
	
		Assert.assertEquals(Integer.valueOf(11), mockUserMapper.createrUser(null)); // 断言调用接口传入null, 结果抛出NullPointerException异常
		CommonUtil.printThree("断言调用接口传入null, 结果抛出NullPointerException异常：断言成功：", "Assert.assertEquals(Integer.valueOf(1), mockUserMapper.createrUser(null));");

//		Assert.assertEquals(Integer.valueOf(11), mockUserMapper.createrUser("not exists")); // 断言调用接口传入预测不存在的信息
		CommonUtil.printThree("断言调用接口传入不存在的信息 结果为11，：断言成功：", "Assert.assertEquals(Integer.valueOf(111), mockUserMapper.createrUser(\"not exists\"));");
	}

}
