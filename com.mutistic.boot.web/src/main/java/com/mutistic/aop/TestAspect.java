package com.mutistic.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * @program 定义切面
 * @description 参考：https://blog.csdn.net/sinat_28978689/article/details/62215513
 *              https://blog.csdn.net/qq_35091777/article/details/78365472
 *              https://blog.csdn.net/abcd898989/article/details/50809321
 *              https://blog.csdn.net/u010771890/article/details/54233750
 * @author mutisitic
 * @date 2018年7月31日
 */
@Aspect // 定义切面
@Component // 纳入到Spring容器中
public class TestAspect {

	/**
	 * @description 定义通知方式-@Before：前置通知
	 *              execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)
	 * @author mutisitic
	 * @date 2018年7月31日
	 */
	@Before(value = "execution(* com.mutistic.aop.TestControllerByAop.*(..))") // execution 定义切入点：如xx包的xx方法
	public void before(JoinPoint joinPoint) {
		StringBuffer val = new StringBuffer("\n\n\n-----------------------------------");
		val.append("\n[@Before：前置通知]");
		val.append("\n[前置通知：在目标 方法开始之前进行执行的通知]");
		val.append("\n[前置通知：使用 @Before 注解, 并将切入点表达式的值作为注解值]");
		val.append("\n[value属性值：切入点表达式，匹配与之对应的目标。利用【*】可以进行那匹配不同的目标，参数只需要传入类型即可]");
		val.append("\n[方法体JoinPoint 参数：用来连接当前连接点的连接细节，一般包括方法名和参数值。【org.aspectj.lang.JoinPoint】包]");
		val.append("\n[JoinPoint：]");

//		joinPoint.getSignature().getDeclaringTypeName(); // 获取签名类名称
//		joinPoint.getTarget().getClass(); // 获取签名类
//		joinPoint.getSignature().getName(); // 获取签名方法
//		joinPoint.getArgs(); // 获取签名入参
//		AopContext.currentProxy().getClass(); //获取代理对象
		
		val.append("\n[通过JoinPoint.getSignature()获取签名信息：" + joinPoint.getSignature().getDeclaringTypeName()
				+ "." + joinPoint.getSignature().getName() + "]");
		val.append("\n[通过JoinPoint.getArgs()获取参数：" + Arrays.asList(joinPoint.getArgs()) + "]");
		
		System.out.println(val.toString());
	}

	/**
	 * @description 定义通知方式-@After：后置通知
	 * @author mutisitic
	 * @date 2018年7月31日
	 */
	@After(value = "execution(* com.mutistic.aop.TestControllerByAop.*(..))")
	public void after(JoinPoint joinPoint) {
		StringBuffer val = new StringBuffer("\n\n\n-----------------------------------");
		val.append("\n[@After：后置通知]");
		val.append("\n[后置通知： 在目标方法执行之后，无论是否发生异常，都进行执行的通知]");
		val.append("\n[后置通知：使用@After注解, 并将切入点表达式的值作为注解值]");
		val.append("\n[在后置通知中，不能访问目标方法的执行结果。原因可能在执行过程中发生异常而无法得到结果]");
		val.append("\n[方法体JoinPoint 参数：用来连接当前连接点的连接细节，一般包括方法名和参数值。【org.aspectj.lang.JoinPoint】包]");
		val.append(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "]");
		
		System.out.println(val.toString());
	}

	/**
	 * @description 定义通知方式-@AfterReturning：返回通知
	 * @author mutisitic
	 * @date 2018年7月31日
	 */
	@AfterReturning(value = "execution(* com.mutistic.aop.TestControllerByAop.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		StringBuffer val = new StringBuffer("\n\n\n-----------------------------------");
		val.append("\n[@AfterReturning：返回通知]");
		val.append("\n[返回通知： 在目标方法正常结束时，才执行的通知]");
		val.append("\n[返回通知：使用@AfterReturning注解，并将切入点表达式的值作为注解值]");
		val.append("\n[返回通知：可以访问到方法的返回值]");
		val.append("\n[returning属性值：声明该方法可以存在返回值，该属性的值即为用来传入返回值的参数名称]");
		val.append("\n[方法体Object参数 ：需要使用与returning同名参数名称，用来接收方法的返回值]");
		val.append(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "]");
		
		System.out.println(val.toString());
	}

	/**
	 * @description 定义通知方式-@AfterThrowing：异常通知
	 * @author mutisitic
	 * @date 2018年7月31日
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value = "execution(* com.mutistic.aop.TestControllerByAop.*(..))", throwing = "ex")
	public void afterthrowing(JoinPoint joinPoint, Exception ex) {
		StringBuffer val = new StringBuffer("\n\n\n-----------------------------------");
		val.append("\n[@AfterThrowing：异常通知]");
		val.append("\n[异常通知 ：在目标方法出现异常时才会进行执行的代码]");
		val.append("\n[异常通知 ：使用@AfterThrowing注解，并将切入点表达式的值作为注解值]");
		val.append("\n[throwing属性：访问连接点抛出的异常]");
		val.append("\n[returning属性值：声明该方法可以存在返回值，该属性的值即为用来传入返回值的参数名称]");
		val.append("\n[方法体Exception参数：用来接收连接点抛出的异常。Exception类匹配所有的异常，可以指定为特定的异常]");
		val.append(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "]");
		
		System.out.println(val.toString());
	}

	/**
	 * @description 定义通知方式-@Around：环绕通知
	 * @author mutisitic
	 * @date 2018年7月31日
	 * @param pjd
	 * @return
	 */
	@Around(value = "execution(* com.mutistic.aop.TestControllerByAop.*(..))")
	public Object around(ProceedingJoinPoint pjd) {
		StringBuffer val = new StringBuffer("\n\n\n-----------------------------------");
		val.append("\n[@Around：环绕通知]");
		val.append("\n[环绕通知：是所有通知类型中功能最为强大的， 能够全面地控制连接点。甚至可以控制是否执行连接点。类似于动态代理]");
		val.append("\n[环绕通知：连接点的参数类型必须是 ProceedingJoinPoint ，它是 JoinPoint 的子接口,，允许控制何时执行， 是否执行连接点]");
		val.append("\n[环绕通知：中需要明确调用 ProceedingJoinPoint 的 proceed()]");
		val.append("\n[方法来执行被代理的方法，如果忘记这样做就会导致通知被执行了，但目标方法没有被执行。]");
		val.append("\n[环绕通知：的方法需要有返回值，返回目标方法执行之后的结果， 即调用 joinPoint.proceed() 的返回值, 否则会出现空指针异常]");
		val.append("\n[环绕通知：虽然功能最为强大的，但是一般我们都不使用这个]");
		
		String allName = pjd.getSignature().getDeclaringTypeName() + "." + pjd.getSignature().getName();
		Object result = null;
		try {
			List<Object> args = Arrays.asList(pjd.getArgs() + "]");
			result = pjd.proceed();
			val.append("\n[@Around：前置通知" + allName + args + "]");
			val.append("\n[@Around：返回通知" + allName + " return：" + result + "]");
		} catch (Throwable e) {
			val.append("\n[@Around：异常通知" + allName + " excetion：" + e + "]");

			e.printStackTrace();
		}
		// 后置通知
		val.append("\n[@Around：后置通知" + allName + "]");
		
		System.out.println(val.toString());
		return result;
	}
}
