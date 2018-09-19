# <a id="a_top">[Spring Boot Web](https://spring.io/projects/spring-boot)</a>

[Apache Tomcat 9 Document](http://tomcat.apache.org/tomcat-9.0-doc/index.html) 
[Apache Tomcat 9 API](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/overview-summary.html)

|作者|Mutistic|
|---|---|
|邮箱|mutistic@qq.com|

---
### <a id="a_catalogue">目录</a>：
1. <a href="#a_web">Spring Boot Web概述</a>
2. <a href="#a_controllern">@Controller和@RestController的使用</a>
3. <a href="#a_jsp">JSP视图的使用</a>
4. <a href="#a_freemarker">Freemarker视图的使用</a>
5. <a href="#a_static">访问静态资源(resources)</a>
6. <a href="#a_servlet">Servlet的使用</a>
7. <a href="#a_filter">Filter过滤器的使用</a>
8. <a href="#a_interceptor">HandlerInterceptor拦截器的使用</a>
9. <a href="#a_error">自定义Error视图</a>
10. <a href="#a_jdbc">JDBC的使用</a>
11. <a href="#a_transaction">Transaction事务的使用</a>
12. <a href="#a_aop">AOP的使用</a>
13. <a href="#a_starter">创建starter项目并引用</a>
14. <a href="#a_logger">logger的使用</a>
15. <a href="#a_actuator">监控和度量的使用</a>
16. <a href="#a_tests">单元测试的使用</a>
17. <a href="#a_microservice">微服务的使用</a>
18. <a href="#a_zokkeeper">服务的注册和发现(简单使用zokkeeper)</a>
19. <a href="#a_devtools">热部署</a>
20. <a href="#a_maven">打包发布</a>
99. <a href="#a_down">down</a>

---
### <a id="a_web">一、Spring Boot Web概述：</a> <a href="#a_top">last</a> <a href="#a_controllern">next</a>


pom.xml：需要添加spring-boot-starter-web依赖：
```xml
<!-- 添加web项目依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

---
### <a id="a_controllern">二、@Controller和@RestController的使用：</a> <a href="#a_web">last</a> <a href="#a_jsp">next</a>
2.1、@RequestMapping：[
org.springframework.web.bind.annotation.RequestMapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)
```
1、使用灵活方法签名将Web请求映射到请求处理类中的方法的注释。
2、既Spring MVC和Spring WebFlux支持此注释通过 RequestMappingHandlerMapping并RequestMappingHandlerAdapter 在其各自的模块和封装结构。有关每个支持的处理程序方法参数和返回类型的确切列表，
3、注意：此注解可以在类和方法级别使用。在大多数情况下，在方法层面的应用程序将喜欢使用的HTTP方法具体的变种之一 
	@GetMapping，@PostMapping， @PutMapping，@DeleteMapping，或 @PatchMapping。
4、注意：使用控制器接口（例如，用于AOP代理）时，请确保始终将所有映射注释（例如 @RequestMapping和@SessionAttributes- ）
	放在控制器接口上，而不是放在实现类上。

public abstract java.lang.String name
	为此映射指定名称。在类型级别和方法级别支持! 在两个级别上使用时，组合名称通过串联"＃"作为分隔符派生。

public abstract java.lang.String[] value
	这是别名path()。例如 @RequestMapping("/foo")相当于 @RequestMapping(path="/foo")。在类型级别和方法级别支持! 在类型级别使用时，所有方法级别映射都会继承此主映射，从而使其针对特定处理程序方法进行缩小。

public abstract java.lang.String[] path
	路径映射URI（例如"/myPath.do"）。还支持Ant样式的路径模式（例如"/myPath/*.do"）。
	在方法级别，在类型级别表示的主映射内支持相对路径（例如"edit.do"）。
	路径映射URI可以包含占位符（例如"/$ {connect}"）。
	在类型级别和方法级别支持! 在类型级别使用时，所有方法级别映射都会继承此主映射，从而使其针对特定处理程序方法进行缩小

public abstract RequestMethod[] method
	要映射的HTTP请求方法，缩小主映射：GET，POST，HEAD，OPTIONS，PUT，PATCH，DELETE，TRACE。
	在类型级别和方法级别支持! 在类型级别使用时，所有方法级别映射都继承此HTTP方法限制（即，在处理程序方法被解析之前，将检查类型级别限制）。

public abstract java.lang.String[] params
	映射请求的参数，缩小主映射。
	任何环境的格式相同：一系列"myParam = myValue"样式表达式，如果发现每个此类参数都具有给定值，则仅映射请求。
	使用"!="运算符可以取消表达式，如"myParam!= myValue"。
	还支持"myParam"样式表达式，这些参数必须存在于请求中（允许具有任何值）。
	最后，"!myParam"样式表达式表明指定的参数不应该出现在请求中。
	在类型级别和方法级别支持! 在类型级别使用时，所有方法级别映射都会继承此参数限制（即，甚至在解析处理程序方法之前检查类型级别限制）。
	参数映射被视为在类型级别强制执行的限制。主路径映射（即指定的URI值）仍然必须唯一地标识目标处理程序，参数映射仅表示调用处理程序的前提条件。

public abstract java.lang.String[] headers
	映射请求的标头，缩小主映射。
	任何环境的格式相同：一系列"My-Header = myValue"样式表达式，只有在发现每个此类标题具有给定值时才会映射请求。
	使用"!="运算符可以取消表达式，如"My-Header!= myValue"。
	还支持"My-Header"样式表达式，这些标题必须存在于请求中（允许具有任何值）。
	最后，"!My-Header"样式表达式表明指定的标头不应该出现在请求中。
	还支持媒体类型通配符（*），用于诸如Accept和Content-Type之类的标题。例如，
	 @RequestMapping（value ="/something"，headers ="content-type = text/*"）
	将匹配请的内容类型为 text/html"，"text/plain"等。
	在类型级别和方法级别支持! 在类型级别使用时，所有方法级别映射都继承此标头限制（即在处理器方法甚至解析之前检查类型级别限制）。

public abstract java.lang.String[] consumes
	映射请求的可消耗媒体类型，缩小主映射。
	格式是单个媒体类型或媒体类型序列，如果Content-Type匹配这些媒体类型之一，则仅映射请求。例子：
	 consumes="text  plain"
	 consumes = {"text/ lain"， application/*"}
	使用"!"可以取消表达式。运算符，如"!text/ lain"， 匹配Content-Type除"text/ lain"以 的所有请求。
	在类型级别和方法级别支持! 在类型级别使用时，所有方法级别映射都会覆盖此消耗限制。

public abstract java.lang.String[] produces
	映射请求的可生成媒体类型，缩小主映射。
	格式是单个媒体类型或媒体类型序列，如果Accept匹配这些媒体类型之一，则仅映射请求。例子：
	 produce ="text/plain"
  	 produce = {"text/plain" "application/*"}
	 produce = MediaType.APPLICATION_JSON_UTF8_VALUE
	它会影响写入的实际内容类型，例如，应使用UTF-8编码生成JSON响应MediaType.APPLICATION_JSON_UTF8_VALUE。
	使用"!"可以取消表达式。运算符，如!text/plain"，它匹配Accept除"text/plain"以外的所有请求。
	在类型级别和方法级别支持! 在类型级别使用时，所有方法级别的映射都会覆盖此限制。
```

2.2、@ResponseBody：[org.springframework.web.bind.annotation.ResponseBody](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseBody.html)
```
指示方法返回值的注释应绑定到Web响应主体。支持带注释的处理程序方法。
从版本4.0开始，此注释也可以在类型级别上添加，在这种情况下它是继承的，不需要在方法级别添加
```

2.3、@Controller：[org.springframework.stereotype.Controller](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Controller.html)
```
@Controller：表示带注释的类是"控制器"（例如Web控制器）。
此注释用作特殊化@Component，允许通过类路径扫描自动检测实现类。它通常与基于RequestMapping注释的带注释的处理程序方法结合使用 。

public abstract java.lang.String value
	该值可以指示对逻辑组件名称的建议，在自动检测的组件的情况下将其转换为Spring bean。
```
```
@Controller的使用步骤：
	Class主类Controller类：使用@Controller
	方法：使用@RequestMapping(value = "URL")指定方法访问路径
	方法：使用@ResponseBody注解返回结果
	请求类型：@RequestMapping支持多种请求方式如get/post/put
```

TestController.java：
```Java
package com.mutistic.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// 演示 @Controller
@Controller
public class TestController {
	@RequestMapping(value = "/testControlle/testRequestMapping")//, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String testRequestMapping() {
		StringBuffer val = new StringBuffer("1、 @Controller的使用步骤：");
		val.append("Class主类Controller类：使用@Controller");
		val.append("方法：使用@RequestMapping(value = \"URL\")指定方法访问路径");
		val.append("方法：使用@ResponseBody注解返回结果");
		val.append("请求类型：@RequestMapping支持多种请求方式如get/post/put");
		val.append("参数信息：无参数");
		val.append("返回类型：String");
		return val.toString();
	}
}
```

2.4、@RestController：[org.springframework.web.bind.annotation.RestController](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)
```
一个便利注释本身用@Controller和注释 @ResponseBody。
带有此注解的类型被视为控制器，其中 @RequestMapping方法@ResponseBody默认采用 语义。
注意： @RestController如果一个合适的被处理 HandlerMapping- HandlerAdapter一对被配置成如 
RequestMappingHandlerMapping- RequestMappingHandlerAdapter 一对是在MVC的Java配置和MVC命名空间的默认。

public abstract java.lang.String value
	该值可以指示对逻辑组件名称的建议，在自动检测的组件的情况下将其转换为Spring bean。
```

TestRestController.java：
```Java
package com.mutistic.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mutistic.utils.HttpServletUtil;
// 演示 @RestController
@RestController
@RequestMapping("/testRestController/")
public class TestRestController {
	@GetMapping(value = "getMapping", produces = "text/html;charset=UTF-8")
	public String getMapping() {
		StringBuffer val = new StringBuffer("1、演示@RestController + @GetMapping：无需方法在添加 @ResponseBody注解");
		val.append("\n[Controller：使用@RestController。@RequestMapping(\"testRestController\") 指定默认访问路径]");
		val.append("\n[方法：使用@GetMapping(\\\"getMapping\\\"))指定访问路径和请求方式GET]");
		val.append("\n[请求方式：RequestMethod.GET]");
		val.append("\n[参数信息：无参数]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}
}

```

2.5、请求方式：<br/>
RequestMethod：[org.springframework.web.bind.annotation.RequestMethod](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMethod.html)
```
Java 5枚举HTTP请求方法。
旨在与注释的RequestMapping.method()属性一起使用 RequestMapping。
请注意，默认情况下，仅DispatcherServlet 支持GET，HEAD，POST，PUT，PATCH和DELETE。
DispatcherServlet将使用默认的HttpServlet行为处理TRACE和OPTIONS，除非明确告知也要调度这些请求类型：
 检查"dispatchOptionsRequest"和"dispatchTraceRequest"属性，必要时将它们切换为"true"。

枚举值：GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
```

@GetMapping：[org.springframework.web.bind.annotation.GetMapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html)<br/>
用于将HTTP GET请求映射到特定处理程序方法的注释。具体来说，@GetMapping是一个作为快捷方式的组合注释@RequestMapping(method = RequestMethod.GET)

@PostMapping：[org.springframework.web.bind.annotation.PostMapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html)<br/>
用于将HTTP POST请求映射到特定处理程序方法的注释。具体来说，@PostMapping是一个作为快捷方式的组合注释@RequestMapping(method = RequestMethod.POST)

@PatchMapping：[org.springframework.web.bind.annotation.PatchMapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/PatchMapping.html)<br/>
用于将HTTP PATCH请求映射到特定处理程序方法的注释。具体来说，@PatchMapping是一个作为快捷方式的组合注释@RequestMapping(method = RequestMethod.PATCH)

@PutMapping：[org.springframework.web.bind.annotation.PutMapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/PutMapping.html)<br/>
用于将HTTP PUT请求映射到特定处理程序方法的注释。具体来说，@PutMapping是一个作为快捷方式的组合注释@RequestMapping(method = RequestMethod.PUT)

@DeleteMapping：[org.springframework.web.bind.annotation.DeleteMapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/DeleteMapping.html)<br/>
用于将HTTP DELETE请求映射到特定处理程序方法的注释。具体来说，@DeleteMapping是一个作为快捷方式的组合注释@RequestMapping(method = RequestMethod.DELETE)


2.6、请求参数：<br/>
@RequestParam：[org.springframework.web.bind.annotation.RequestParam](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html)
```
注释，指示应将方法参数绑定到Web请求参数。
支持Servlet和Portlet环境中带注释的处理程序方法。
如果方法参数类型是Map并且指定了请求参数名称，则请求参数值将转换为Map 假定适当的转换策略可用。
如果方法参数为Map<String, String>或 MultiValueMap<String, String> 且未指定参数名称，则使用所有请求参数名称和值填充map参数。

public abstract java.lang.String value
	别名为name()。

public abstract java.lang.String name
	要绑定的请求参数的名称。

public abstract boolean required
	是否需要参数。默认为true，如果请求中缺少参数，则会导致抛出异常。提供默认值隐式值是required默认为false。

public abstract java.lang.String defaultValue
	未提供请求参数或具有空值时设置参数的默认值。
```

@PathVariable：[org.springframework.web.bind.annotation.PathVariable](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html)
```
注释，指示方法参数应绑定到URI模板变量。支持带RequestMapping注释的处理程序方法。
如果方法参数是，Map<String, String> 那么将使用所有路径变量名称和值填充映射。

public abstract java.lang.String name
	要绑定的路径变量的名称。

public abstract boolean required
	默认为true，如果在传入的请求中缺少路径变量，则会导致异常被抛出。
	如果设置为null或Java 8 java.util.Optional，则将其转换为false。
	在这种情况下可选。例如，在一个为不同请求服务的ModelAttribute方法上。
```

2.7、Request和Response：<br/>
HttpServletRequest：[javax.servlet.http.HttpServletRequest](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/javax/servlet/http/HttpServletRequest.html)
```
公共接口HttpServletRequest 扩展了ServletRequest 扩展ServletRequest接口以提供HTTP servlet的请求信息。
servlet容器创建一个HttpServletRequest对象，并将其作为一个参数传递给servlet的服务方法（doGet，doPost等）。

boolean	authenticate(HttpServletResponse response)
	如果请求是针对受安全性约束保护的资源，则触发相同的身份验证过程。

java.lang.String	changeSessionId()
	更改与此请求关联的会话的会话ID。

java.lang.String	getAuthType()
	返回用于保护servlet的身份验证方案的名称。

java.lang.String	getContextPath()
	返回请求URI的一部分，指示请求的上下文。

Cookie[]	getCookies()
	返回一个数组，其中包含Cookie客户端使用此请求发送的所有对象。

long	getDateHeader(java.lang.String name)
	返回指定请求标头的long 值，作为表示Date对象的值。

java.lang.String	getHeader(java.lang.String name)
	以a形式返回指定请求标头的值 String。

java.util.Enumeration<java.lang.String>	getHeaderNames()
	返回此请求包含的所有标头名称的枚举。

java.util.Enumeration<java.lang.String>	getHeaders(java.lang.String name)
	返回指定请求头作为的所有值 Enumeration的String对象。

default HttpServletMapping	getHttpServletMapping() 

int	getIntHeader(java.lang.String name)
	返回指定的请求标头的值作为int。

java.lang.String	getMethod()
	返回用于发出此请求的HTTP方法的名称，例如，GET，POST或PUT。

Part	getPart(java.lang.String name)
	获取命名的Part，如果Part不存在，则返回null。

java.util.Collection<Part>	getParts()
	返回所有上传部分的集合。

java.lang.String	getPathInfo()
	返回与客户端发出此请求时发送的URL关联的任何额外路径信息。

java.lang.String	getPathTranslated()
	返回servlet名称之后但查询字符串之前的任何额外路径信息，并将其转换为实际路径。

java.lang.String	getQueryString()
	返回路径后请求URL中包含的查询字符串。

java.lang.String	getRemoteUser()
	如果用户已经过身份验证，或者null用户未经过身份验证，则返回发出此请求的用户的登录名。

java.lang.String	getRequestedSessionId()
	返回客户端指定的会话ID。

java.lang.String	getRequestURI()
	将此请求的URL部分从协议名称返回到HTTP请求第一行中的查询字符串。

java.lang.StringBuffer	getRequestURL()
	重构客户端用于发出请求的URL。

java.lang.String	getServletPath()
	返回此请求调用servlet的URL的一部分。

HttpSession	getSession()
	返回与此请求关联的当前会话，或者如果请求没有会话，则创建一个会话。

HttpSession	getSession(boolean create)
	返回HttpSession与此请求关联的当前值，如果没有当前会话且create为true，则返回新会话。

default java.util.Map<java.lang.String,java.lang.String>	getTrailerFields()
	获取请求对象未支持的预告片字段的映射。

java.security.Principal	getUserPrincipal()
	返回java.security.Principal包含当前经过身份验证的用户的名称的对象。

boolean	isRequestedSessionIdFromCookie()
	检查所请求的会话ID是否作为cookie进入。

boolean	isRequestedSessionIdFromUrl()
	已过时。 从Java Servlet API的2.1版开始，请 isRequestedSessionIdFromURL()改用。

boolean	isRequestedSessionIdFromURL()
	检查请求的会话ID是否作为请求URL的一部分进入。

boolean	isRequestedSessionIdValid()
	检查请求的会话ID是否仍然有效。

default boolean	isTrailerFieldsReady()
	拖车区域是否准备好被阅读（可能仍然没有预告片可供阅读）。

boolean	isUserInRole(java.lang.String role)
	返回一个布尔值，指示经过身份验证的用户是否包含在指定的逻辑“角色”中。

login(java.lang.String username, java.lang.String password)
	验证提供的用户名和密码，然后将经过身份验证的用户与请求相关联。

logout()
	从请求中删除任何经过身份验证的用户。

default PushBuilder	newPushBuilder()
	获取用于生成推送请求的构建器。

<T extends HttpUpgradeHandler>	upgrade(java.lang.Class<T> httpUpgradeHandlerClass)
T	启动HTTP升级过程，并在当前请求/响应对完成处理后将连接传递给提供的协议处理程序。

```

HttpServletResponse：[javax.servlet.http.HttpServletResponse](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/javax/servlet/http/HttpServletResponse.html)
```
扩展ServletResponse接口以在发送响应时提供特定于HTTP的功能。例如，它具有访问HTTP标头和cookie的方法。
servlet容器创建一个HttpServletResponse对象，并将其作为一个参数传递给servlet的服务方法（doGet，doPost等）。

addCookie(Cookie cookie)
	将指定的cookie添加到响应中。

addDateHeader(java.lang.String name, long date)
	添加具有给定名称和日期值的响应标头。

addHeader(java.lang.String name, java.lang.String value)
	添加具有给定名称和值的响应标头。

addIntHeader(java.lang.String name, int value)
	添加具有给定名称和整数值的响应标头。

boolean	containsHeader(java.lang.String name)
	返回一个布尔值，指示是否已设置指定的响应头。

java.lang.String	encodeRedirectUrl(java.lang.String url)
	已过时。 从版本2.1开始，请使用encodeRedirectURL（String url）

java.lang.String	encodeRedirectURL(java.lang.String url)
	对指定的URL进行编码以在sendRedirect方法中使用，或者，如果不需要编码，则返回URL不变。

java.lang.String	encodeUrl(java.lang.String url)
	已过时。从2.1版开始，请使用encodeURL（String url）

java.lang.String	encodeURL(java.lang.String url)
	通过在其中包含会话ID来对指定的URL进行编码，或者，如果不需要编码，则返回URL不变。

java.lang.String	getHeader(java.lang.String name)
	返回指定标头的值，或者null是否尚未设置此标头。

java.util.Collection<java.lang.String>	getHeaderNames()
	获取为此HTTP响应设置的标头名称。

java.util.Collection<java.lang.String>	getHeaders(java.lang.String name)
	返回与指定标头名称关联的所有标头值的集合。

int	getStatus()
	获取此响应的HTTP状态代码。

default java.util.function.Supplier<java.util.Map<java.lang.String,java.lang.String>>	getTrailerFields()
	获取拖车标题的供应商。

sendError(int sc)
	使用指定的状态代码向客户端发送错误响应并清除缓冲区。

sendError(int sc, java.lang.String msg)
	使用指定的状态代码向客户端发送错误响应并清除输出缓冲区。

sendRedirect(java.lang.String location)
	使用指定的重定向位置URL向客户端发送临时重定向响应。

setDateHeader(java.lang.String name, long date)
	设置具有给定名称和日期值的响应标头。

setHeader(java.lang.String name, java.lang.String value)
	设置具有给定名称和值的响应标头。

setIntHeader(java.lang.String name, int value)
	设置具有给定名称和整数值的响应标头。

setStatus(int sc)
	设置此响应的状态代码。

setStatus(int sc, java.lang.String sm)
	已过时。 从版本2.1开始，由于消息参数的含义模糊。要设置状态代码 setStatus(int)，请使用描述使用发送错误sendError(int, String)。

setTrailerFields(java.util.function.Supplier<java.util.Map<java.lang.String,java.lang.String>> supplier)
	配置拖标头的供应商。
```


2.8、示例代码：<br/>
TestControllerByMapping.java：
```Java
package com.mutistic.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
// 演示 @Controller + @RequestMapping
@Controller
@RequestMapping("/testControllerByMapping/")
public class TestControllerByMapping {
	/**
	 * 请求参数的使用： 1、通过@RequestParam获取请求参数： 
	 * 1.1、value字：请求URL中参数的绑定值：name
	 * 1.2、method：指定请求方式：参考org.springframework.web.bind.annotation.RequestMethod
	 * 1.3、required：参数是否必填（默认true）：true必填，false非必填。
	 * 1.4、defaultValue：设置默认值。当请求URL无改参数时，生效
	 * 1.5、produces：设置请求格式及编码格式
	 * 2、通过@PathVariable获取请求URL中的参数 2.1、请求URL参数格式：{key}
	 * 3、通过Servlet API:HttpServletRequest获取请求参数：
	 */

	// 演示 @Controller + @RequestMapping + @ResponseBody访问接口
	@RequestMapping(value = "testRequestMapping", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String testRequestMapping() {
		StringBuffer val = new StringBuffer("1、演示 @Controller + @RequestMapping + @ResponseBody访问接口");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\"/testControllerByMapping/\")指定默认路径]");
		val.append("\n[方法：使用@RequestMapping(value = \"testRequestMapping\")指定方法访问路径]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：@RequestMapping支持多种请求方式如get/post/put]");
		val.append("\n[参数信息：无参数]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}
	// 演示 @RequestMapping 通过 @RequestParam 设置参数(默认参数必填)
	@RequestMapping(value = "getRequestMapping", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getRequestMapping(@RequestParam("name") String name) {
		StringBuffer val = new StringBuffer("2、演示 @RequestMapping 通过 @RequestParam 设置参数(默认参数必填)");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\"/testControllerByMapping/\")指定默认路径]");
		val.append(
				"\n[方法：@RequestMapping(value = \"getRequestMapping\", method = RequestMethod.GET)指定方法访问路径，和访问方式GET]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：RequestMethod.GET]");
		val.append("\n[参数信息： @RequestParam(\"name\") String name)指定访问参数，默认为必填");
		val.append("\n[参数值： name = " + name + "]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}

	// 演示 @RequestMapping 通过 required 设置参数非必填
	@RequestMapping(value = "postRequestMapping", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String postRequestMapping(@RequestParam(value = "name", required = false) String name) {
		StringBuffer val = new StringBuffer("3、演示 @RequestMapping 通过 required 设置参数非必填");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\"/testControllerByMapping/\")指定默认路径]");
		val.append(
				"\n[方法：@RequestMapping(value = \"postRequestMapping\", method = RequestMethod.POST)指定方法访问路径，和访问方式POST]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：RequestMethod.POST]");
		val.append("\n[参数信息： @RequestParam(value = \"name\", required = false) String name指定访问参数，required设置是否必填");
		val.append("\n[参数值： name = " + name + "]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}

	// 演示 @GetMapping 通过 defaultValue 指定参数默认值
	@GetMapping(value = "getMapping", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMapping(@RequestParam(value = "name", required = false, defaultValue = "admin") String name) {
		StringBuffer val = new StringBuffer("5、演示 @GetMapping 通过 defaultValue 指定参数默认值");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\\\"/testControllerByMapping/\\\")指定默认路径]");
		val.append("\n[方法：使用@GetMapping(\\\"getMapping\\\"))指定访问路径和请求方式GET]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：RequestMethod.GET]");
		val.append(
				"\n[参数信息：@RequestParam(value = \"name\", required = false, defaultValue=\"admin\") String name 指定访问参数，required设置是否必填，defaultValue设置默认值");
		val.append("\n[参数值： name = " + name + "]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}

	// 演示 @PostMapping 通过 @PathVariable 请求URL绑定参数
	@PostMapping(value = "postMapping/{name}", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String postMapping(@PathVariable("name") String name) {
		StringBuffer val = new StringBuffer("6、演示 @PostMapping 通过 @PathVariable 请求URL绑定参数");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\\\"/testControllerByMapping/\\\")指定默认路径]");
		val.append("\n[方法：使用@PostMapping(\"postMapping/{key}\")指定访问路径和请求方式POST]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：RequestMethod.POST]");
		val.append("\n[参数信息：@PathVariable(\"key\") String name 获取请求URL中绑定的参数key]");
		val.append("\n[参数值： name = " + name + "]");
		val.append("\n[返回类型：String]");
		val.append("\n[PS：spring 4.3的新特性@GetMapping @PostMapping @PutMapping @DeleteMapping 等注解可以直接指定具体的请求方式]");
		return val.toString();
	}
}
```

TestRestController.java：
```Java
package com.mutistic.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mutistic.utils.HttpServletUtil;
@RestController
@RequestMapping("/testRestController/")
public class TestRestController {
	// 演示入参时注入servler的API：HttpServletRequest参数
	@GetMapping(value = "showHttpServletRequest")
	public String showRequest(HttpServletRequest request, HttpServletResponse response) { 
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (Exception e) { }
		
		StringBuffer val = new StringBuffer("2、演示入参时注入servler的API：HttpServletRequest参数");
		val.append("\n[Controller：使用@RestController。@RequestMapping(\"testRestController\") 指定默认访问路径]");
		val.append("\n[方法：使用@GetMapping(\"showHttpServletRequest\"))指定访问路径和请求方式GET]");
		val.append("\n[请求方式：RequestMethod.GET]");
		val.append("\n[参数信息：javax.servlet.http.HttpServletRequest]");
		val.append("\n[获取客户端IP："+ HttpServletUtil.getIPAddress(request) +"]");
		val.append("\n[参数值："+ request.toString() +"]");
		val.append("\n[HttpServletRequest:remoteHost："+ request.getRemoteHost() +"]");
		val.append("\n[HttpServletRequest:localPort："+ request.getLocalPort() +"]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}
}
```

HttpServletUtil.java：
```Java
package com.mutistic.utils;
import javax.servlet.http.HttpServletRequest;
//  HttpServlet工具类
public class HttpServletUtil {
	// 获取客户端访问IP
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
```

---
### <a id="a_jsp">三、JSP视图的使用：</a> <a href="#a_controllern">last</a> <a href="#a_freemarker">next</a>
pom.xml：需要tomcat-embed-jasper依赖：
```xml
<!-- 配合：TestControllerByJSP 演示返回jsp文件所需要的jsp组件: 用于编译jsp -->
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
	<scope>provided</scope>
</dependency>
```

JSP视图的使用步骤：
```
【Controller：使用@Controller。使用@RequestMapping("/URL/")指定默认路径】
【方法：@PostMapping(value = "URL")指定方法访问路径，和访问方式POST】
【请求方式：RequestMethod.POST】
【参数信息： @RequestParam()指定访问参数
【参数值： userName = root, passWord = root123】
【返回类型：JSP文件相对地址及文件名】
【PS1：返回JSP文件时，类不能使用@RestController，方法不能使用 @ResponseBody注解】
【PS2：pom.xml需要引入jsp相关的组件:tomcat-embed-jasper】
【PS3：文件等资源默认路径在src/main/webapp下】
【PS4：属性配置 spring.mvc.view.prefix 可以执行返回view的前缀】
【PS5：属性配置 spring.mvc.view.suffix 可以指定返回view的后缀】
【PS6：pom.xml具体依赖:\n<!-- 配合：TestControllerByJSP 演示返回jsp文件所需要的jsp组件: 用于编译jsp -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>】
```

Model：[org.springframework.ui.Model](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/ui/Model.html)
```
特定于Java-5的接口，用于定义模型属性的持有者。主要用于向模型添加属性。允许以java.util.Map。身份访问整个模型。

Model	addAllAttributes(java.util.Collection<?> attributeValues)
	使用每个元素的属性名称生成，将提供的所有属性复制Collection到此中 Map。

Model	addAllAttributes(java.util.Map<java.lang.String,?> attributes)
	将提供的所有属性复制Map到此中Map。

Model	addAttribute(java.lang.Object attributeValue)
	Map使用将提供的属性添加到此处generated name。

Model	addAttribute(java.lang.String attributeName, java.lang.Object attributeValue)
	在提供的名称下添加提供的属性。

java.util.Map<java.lang.String,java.lang.Object>	asMap()
	将当前的模型属性集作为Map返回。

boolean	containsAttribute(java.lang.String attributeName)
	此模型是否包含给定名称的属性

Model	mergeAttributes(java.util.Map<java.lang.String,?> attributes)
	将所提供的Map中的所有属性复制到这张Map中，使用相同名称的现有对象优先（即不被替换）。
```

TestControllerByJSP.java：
```Java
package com.mutistic.jsp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mutistic.utils.ViewUtil;
// 演示返回.JSP文件
@Controller
public class TestControllerByJSP {
	/**
	 * JSP使用：
	 * 1、pom.xml：引入jasper插件：tomcat-embed-jasper
	 * 2、配置jsp视图路径：src/main/webapp
	 * 2.1、配置文件可以通过参数spring.freemarker.template-loader-path配置视图前缀
	 * 3、Controller可以使用@Controller注解，不能使用@RestController注解，不建议使用@RequestMapping注解配置路径前缀
	 * 4、接口方法不能使用 @ResponseBody注解 
	 * 5、接口返回格式：文件路径/文件名.jsp   (字符串)
	 * 5.1、返回格式前缀可以通过：参数：spring.mvc.view.prefix 指定
	 * 5.2、返回格式后缀可以通过：参数：spring.mvc.view.suffix 指定
	 */
	
	// 演示返回.JSP文件
	@PostMapping(value = "/testControllerByJSP/showJSP", produces = "text/html;charset=UTF-8")
	public String showJSP(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "passWord", required = false) String passWord) {
		StringBuffer val = new StringBuffer("\n1、演示返回.JSP文件");
		val.append("\n【Controller：使用@Controller。使用@RequestMapping(\"/testControllerByJSP/\")指定默认路径】");
		val.append("\n【方法：@PostMapping(value = \"showJSP\")指定方法访问路径，和访问方式POST】");
		val.append("\n【请求方式：RequestMethod.POST】");
		val.append("\n【参数信息： @RequestParam()指定访问参数");
		val.append("\n【参数值： userName = " + userName + ", passWord = " + passWord + "】");
		val.append("\n【返回类型：JSP文件相对地址及文件名】");
		val.append("\n【PS1：返回JSP文件时，类不能使用@RestController，方法不能使用 @ResponseBody注解】");
		val.append("\n【PS2：pom.xml需要引入jsp相关的组件:tomcat-embed-jasper】");
		val.append("\n【PS3：文件等资源默认路径在src/main/webapp下，需要新建webapp目录】");
		val.append("\n【PS4：属性配置 pring.mvc.view.prefix 可以执行返回view的前缀】");
		val.append("\n【PS5：属性配置 spring.mvc.view.suffix 可以指定返回view的后缀】");
		val.append("\n【PS6：pom.xml具体依赖:\\n"
				+ "<!-- 配合：TestControllerByJSP 演示返回jsp文件所需要的jsp组件: 用于编译jsp -->\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.apache.tomcat.embed</groupId>\r\n" + 
				"			<artifactId>tomcat-embed-jasper</artifactId>\r\n" + 
				"			<scope>provided</scope>\r\n" + 
				"		</dependency>】");
		System.out.println(val.toString());

		if ("root".equals(userName) && "root123".equals(passWord)) {
			return ViewUtil.getViewJsp("ok");
		}
		return ViewUtil.getViewJsp("fault");
	}

	// 演示JSP界面使用 ${key}引入Model中变量
	@GetMapping(value = "/testControllerByJSP/showMode", produces = "text/html;charset=UTF-8")
	public String showMode(Model mode) {
		StringBuffer val = new StringBuffer("\n2、演示JSP界面使用 ${key}引入Model中变量");
		val.append("\n【Controller：使用@Controller。使用@RequestMapping(\"/testControllerByJSP/\")指定默认路径】");
		val.append("\n【方法：@GetMapping(value = \"showMode\")】");
		val.append("\n【请求方式：RequestMethod.GET】");
		val.append("\n【参数信息： org.springframework.ui.Model:可以设置参数返回给页面调用");
		val.append("\n【返回类型：JSP文件相对地址及文件名】");
		System.out.println(val.toString());

		mode.addAttribute("print", val.toString());
		return  ViewUtil.getViewJsp("index");
	}
	
	// 演示JSP界面使用 ${key}引入HttpServletRequest中变量
	@GetMapping(value = "/testControllerByJSP/showHttpServletRequest", produces = "text/html;charset=UTF-8")
	public String showHttpServletRequest(HttpServletRequest request) {
		StringBuffer val = new StringBuffer("\n2、演示JSP界面使用 ${key}引入HttpServletRequest中变量");
		val.append("\n【Controller：使用@Controller。使用@RequestMapping(\"/testControllerByJSP/\")指定默认路径】");
		val.append("\n【方法：@GetMapping(value = \"showHttpServletRequest\")】");
		val.append("\n【请求方式：RequestMethod.GET】");
		val.append("\n【参数信息： javax.servlet.http.HttpServletRequest:可以设置参数返回给页面调用");
		val.append("\n【返回类型：JSP文件name】");
		System.out.println(val.toString());

		request.setAttribute("print", val.toString());
		return  ViewUtil.getViewJsp("index");
	}
}
```

ViewUtil.java：
```Java
package com.mutistic.utils;
public class ViewUtil {
	public final static String VIEW_PREFIX_JSP = "/jsp/";
	public final static String VIEW_SUFFIX_JSP = ".jsp";
	public static String getViewJsp(String val) {
		return VIEW_PREFIX_JSP + val + VIEW_SUFFIX_JSP;
	}
}
```

src/main/resources/webapp/jsp/index.jsp：
```Html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>INDEX.JSP</h1>
	<h2>${print}</h2>
</body>
</html>
```

---
### <a id="a_freemarker">四、Freemarker视图的使用：</a> <a href="#a_jsp">last</a> <a href="#a_static">next</a>
pom.xml：需要tomcat-embed-jasper依赖：
```xml
<!-- 配合：TestControllerByFreemarker 演示返回ftl文件所需要的Freemarker组件-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```

Freemarker使用步骤：
```
1、pom.xml：引入freemarker插件：spring-boot-starter-freemarker
2、根目录配置ftl视图：默认路径：src/main/resources/templates 等，参考FreeMarkerProperties.DEFAULT_TEMPLATE_LOADER_PATH
2.1、配置文件可以通过参数spring.freemarker.template-loader-path配置视图路径
3、Controller可以使用@Controller注解，不能使用@RestController注解，不建议使用@RequestMapping注解配置路径前缀
4、接口方法不能使用 @ResponseBody注解 
5、接口返回格式：文件路径/文件名.ftl   (字符串)
```

TestControllerByFreemarker.java：
```Java
package com.mutistic.freemarker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// 演示 Freemarker视图文件
@Controller
//@RequestMapping("/testControllerByFreemarker/")
public class TestControllerByFreemarker {
	@GetMapping(value = "/testControllerByFreemarker/showFreemarker", produces = "text/html;charset=UTF-8")
	public String showFreemarker(Model mode) {
		StringBuffer val = new StringBuffer("\n1、演示返回Freemarker视图");
		val.append("\n【Controller：使用@Controller。使用@RequestMapping(\"/showFreemarker/\")指定默认路径】");
		val.append("\n【方法：@GetMapping(value = \"showJSP\")指定方法访问路径，和访问方式GET】");
		val.append("\n【请求方式：RequestMethod.GET】");
		val.append("\n【参数信息： @RequestParam()指定访问参数");
		val.append("\n【参数值： 无参数】");
		val.append("\n【返回类型：JSP文件相对地址及文件名】");
		val.append("\n【PS1：返回JSP文件时，类不能使用@RestController，方法不能使用 @ResponseBody注解】");
		val.append("\n【PS2：pom.xml需要引入freemarker相关的组件:spring-boot-starter-freemarker】");
		val.append("\n【PS3：文件等资源默认路径在 classpath:/templates/(即:src/resources/templates下)】");
		val.append("\n【PS4：默认路径:参考类的:org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties.DEFAULT_TEMPLATE_LOADER_PATH】");
		val.append("\n【PS5：默认view前缀:参考FreeMarkerProperties.DEFAULT_PREFIX，默认view后缀:参考FreeMarkerProperties.DEFAULT_SUFFIX】");
		val.append("\n【PS6：pom.xml具体依赖:\n"
				+ "<!-- 配合：TestControllerByFreemarker 演示返回ftl文件所需要的Freemarker组件: 用于编译jsp -->\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-freemarker</artifactId>\r\n" + 
				"		</dependency>】");
		
		System.out.println(val.toString());

		mode.addAttribute("print", val.toString());
		return "freemarker";
	}
}
```

src/main/resources/templates/freemarker.ftl：
```Html
<!DOCTYPE html>
<html lang="ch">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>freemarker.ftl</h1>
		<h2>
		${print}
		</h2>
	</body>
</html>
```

---
### <a id="a_static">五、访问静态资源(resources)：</a> <a href="#a_freemarker">last</a> <a href="#a_servlet">next</a>
ResourceProperties：[org.springframework.boot.autoconfigure.web.ResourceProperties](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/web/ResourceProperties.html)
```
用于配置资源处理的属性。

嵌套类：
static class 	ResourceProperties.Cache
	缓存配置
	
static class 	ResourceProperties.Chain
	Spring资源处理链的配置。

static class 	ResourceProperties.Content
	基于内容散列的版本策略。

static class 	ResourceProperties.Fixed
	基于固定版本字符串的版本策略。

static class 	ResourceProperties.Strategy
	在URL路径中提取和嵌入资源版本的策略。

方法：
ResourceProperties.Cache	getCache() 

ResourceProperties.Chain	getChain() 

String[]	getStaticLocations() 

boolean	isAddMappings() 

setAddMappings(boolean addMappings) 

setStaticLocations(String[] staticLocations) 

private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };
```

application.properties 通过参数配置默认资源路径spring.resources.static-locations
```properties
#配置静态资源文件路径：参考类：org.springframework.boot.autoconfigure.web.ResourceProperties
spring.resources.static-locations=classpath:../webapp/,classpath:/html/,classpath:/META-INF/resources/,classpath:/resources/, classpath:/static/, classpath:/public/
```

---
### <a id="a_servlet">六、Servlet的使用</a> <a href="#a_static">last</a> <a href="#a_filter">next</a>
6.1、Servlet使用方式
```
一、Servlet使用方式1-Servlet3注解方法：
1、继承HttpServlet类，实现@WebServlet注解
1.1、urlPatterns：指定访问URL，一般自定义Servlet访问后缀为： .do或 .action
1.2、根据访问方式重写 doGet(), doPost()等方法
1.3、请求信息封装在：HttpServletRequest中
1.4、返回信息封装在：HttpServletResponse中
1.5、Spring boot run 入口需要开启 Servlet扫描注解： @ServletComponentScan

2、如果需要Filter过滤器， 实现Filter接口，实现@WebFilter接口
2.1、重写 init()、doFilter()、destroy()接口，重写时要删除super.doGet(req, resp);
2.1.1、init：过滤器初始化时执行
2.1.2、doFilter：过滤到配置的请求时执行，重写后要调用 chain.doFilter(request, response);
2.1.3、destroy：过滤器销毁时执行
2.2、urlPatterns：设置需要过滤的请求。

3、如果需要ServletContextListener监听器，实现ServletContextListener接口，实现@WebListener注解
3.1、重写contextInitialized()，contextDestroyed()方法
3.1.1、contextInitialized：context初始化时执行
3.1.2、contextDestroyed：context销毁时执行

二、Servlet使用方式2-通过Configuration配置类创建bean（建议用注解方式）：
1、继承HttpServlet类
1.1、Configuration类：通过 ServletRegistrationBean注册 HttpServlet子类
1.2、可以通过 ServletRegistrationBean.setServlet： 配置 HttpServlet子类实例
1.3、可以通过 ServletRegistrationBean.addUrlMappings：配置访问URL

2、如果需要Filter过滤器
2.1、重写 init()、doFilter()、destroy()接口
2.2、Configuration类：通过 FilterRegistrationBean注册 Filter实现类
2.3、可以通过 FilterRegistrationBean.setFilter： 配置 Filter实现类实例
2.4、可以通过 FilterRegistrationBean.setUrlPatterns：配置过滤URL

3、如果需要ServletContextListener监听器，实现ServletContextListener接口
3.1、重写contextInitialized()，contextDestroyed()方法
3.2、Configuration类：通过 ServletListenerRegistrationBean注册 ServletContextListener实现类实例
3.3、可以通过 ServletListenerRegistrationBean.setListener： 配置 ServletContextListener实现类实例
```

HttpServlet：[javax.servlet.http.HttpServlet](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/javax/servlet/http/HttpServlet.html)
```
公共抽象类HttpServlet 扩展了GenericServlet
提供一个抽象类，以创建适合于Web的HTTP servlet。HttpServlet的一个子类必须覆盖至少一种方法，通常是其中之一：
	doGet，如果servlet支持HTTP GET请求
	doPost，用于HTTP POST请求
	doPut，用于HTTP PUT请求
	doDelete, 用于HTTP删除请求
	init and destroy,，以管理为servlet生命所持有的资源
	getServletInfo, servlet用来提供关于自身的信息
几乎没有理由重写服务方法。服务处理标准HTTP请求，将它们分派给每个HTTP请求类型的处理程序方法（上面列出的doMethod方法）。
同样，几乎没有理由去覆盖doOptions和doTrace方法。
servlet通常在多线程服务器上运行，因此要注意servlet必须处理并发请求，并小心地同步对共享资源的访问。
共享资源包括内存中的数据，比如实例或类变量，以及诸如文件、数据库连接和网络连接等外部对象。

protected doDelete(HttpServletRequest req, HttpServletResponse resp)
	由服务器调用（通过service方法）以允许servlet处理DELETE请求。

protected doGet(HttpServletRequest req, HttpServletResponse resp)
	由服务器调用（通过service方法）以允许servlet处理GET请求。

protected doHead(HttpServletRequest req, HttpServletResponse resp)
	从受保护service方法接收HTTP HEAD请求 并处理请求。

protected doOptions(HttpServletRequest req, HttpServletResponse resp)
	由服务器调用（通过service方法）以允许servlet处理OPTIONS请求。

protected doPost(HttpServletRequest req, HttpServletResponse resp)
	由服务器调用（通过service方法）以允许servlet处理POST请求。

protected doPut(HttpServletRequest req, HttpServletResponse resp)
	由服务器调用（通过service方法）以允许servlet处理PUT请求。

protected doTrace(HttpServletRequest req, HttpServletResponse resp)
	由服务器调用（通过该service方法）以允许servlet处理TRACE请求。

protected long	getLastModified(HttpServletRequest req)
	返回HttpServletRequest 自上次修改对象的时间，以格林威治标准时间1970年1月1日午夜为单位，以毫秒为单位。

protected service(HttpServletRequest req, HttpServletResponse resp)
	从public service方法接收标准HTTP请求， 并将它们分派给此类中定义的doMethod方法。

service(ServletRequest req, ServletResponse res)
	将客户端请求分派给受保护的 service方法。
```

6.2.1、通过注解方式实现Serlvet<br/>
@WebServlet：[javax.servlet.annotation.WebServlet](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/javax/servlet/annotation/WebServlet.html)
```
此注解用于声明配置 Servlet。
如果未定义name属性，则使用该类的完全限定名称。
必须在注释的valueor urlPattern属性中声明至少一个URL模式，但不能同时在两者中声明。
该value属性被建议用于URL模式是唯一的属性被设置，否则urlPattern应使用属性。
声明此注解的类必须扩展 HttpServlet。


boolean	asyncSupported 
	此Servlet支持的异步操作

java.lang.String	description 
	此Servlet的描述（如果存在）

java.lang.String	displayName 
	显示此Servlet的名称（如果存在）

WebInitParam[]	initParams 
	此Servlet的初始化参数数组

java.lang.String	largeIcon 
	此Servlet的大图标（如果存在）

int	loadOnStartup 
	加载启动命令提示

java.lang.String	name 
	Servlet的名称

java.lang.String	smallIcon 
	此Servlet的小图标（如果存在）

java.lang.String[]	urlPatterns 
	此Filter应用的URL模式数组

java.lang.String[]	value
	一种方便的方法，允许对类进行极其简单的注释。
```

启动 main方法时，要开启 @ServletComponentScan Servlet扫描注解，在 @SpringBootApplication之上：<br/>
@ServletComponentScan：[org.springframework.boot.web.servlet.ServletComponentScan](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/web/servlet/ServletComponentScan.html)
```
使扫描的Servlet组分（filters，servlets，和listeners）。仅在使用嵌入式Web服务器时执行扫描。
典型地，中的一个value，basePackages或basePackageClasses 应指定控制包被扫描的部件。
在他们不在的情况下，将使用注释从类的包中执行扫描

Class<?>[]	basePackageClasses
	类型安全的替代方法，basePackages()用于指定要扫描带注释的servlet组件的包。

String[]	basePackages
	用于扫描带注释的servlet组件的基础包。

String[]	value
	basePackages()属性的别名。
```

TestControllerByServlet.java：
```Java
package com.mutistic.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Servlet3的 @WebServlet 注解 实现 HttpServlet
@WebServlet("/testHttpServlet.do")
//@WebServlet(urlPatterns="/testHttpServlet.do")
//@WebServlet(name = "myServlet", urlPatterns="/testHttpServlet.do")
public class TestControllerByServlet extends HttpServlet {
	/**
	 * 演示 HttpServlet - doGet方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp); //  使用 Servlet时 注意要删掉 super.doGet(req, resp);
		
		StringBuffer val = new StringBuffer("\n1、演示 HttpServlet - doGet方法");
		val.append("\n【Servlet：继承 HttpServlet，实现 @WebServlet(\"/testHttpServlet.do\") 注解】");
		val.append("\n【方法：重写HttpServlet的doGet()，指定访问方式 GET】");
		val.append("\n【请求方式：GET】");
		val.append("\n【参数信息：通过javax.servlet.http.HttpServletRequest 获取参数");
		val.append("\n【返回类型：通过javax.servlet.http.HttpServletResponse 返回数据】");
		val.append("\n【PS1：@WebServlet注解中 urlPatterns指定访问URL】");
		val.append("\n【PS2：启动 main方法时，要开启 @ServletComponentScan Servlet扫描注解，在 @SpringBootApplication之上】");
		val.append("\n【PS3：重写HttpServlet的doGet()方法时，要删除 super.doGet(req, resp); 】");
		val.append("\n【PS4：请求方式有 doGet() doPost() doPut() doDelete() 等; 】");
		
		resp.getWriter().print(val.toString());
	}

	/**
	 * 演示 HttpServlet - doPost方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer val = new StringBuffer("\n1、演示 HttpServlet - doGet方法");
		val.append("\n【Servlet：继承 HttpServlet，实现 @WebServlet(\"/testHttpServlet.do\") 注解】");
		val.append("\n【方法：重写HttpServlet的doPost()，指定访问方式 POST】");
		val.append("\n【请求方式：POST】");
		val.append("\n【参数信息：通过javax.servlet.http.HttpServletRequest 获取参数");
		val.append("\n【返回类型：通过javax.servlet.http.HttpServletResponse 返回数据】");
		val.append("\n【PS1：@WebServlet注解中 urlPatterns指定访问URL】");
		val.append("\n【PS2：启动 main方法时，要开启 @ServletComponentScan Servlet扫描注解，在 @SpringBootApplication之上】");
		val.append("\n【PS3：重写HttpServlet的doPost()方法时，要删除 super.doPost(req, resp); 】");

		resp.getWriter().print(val.toString());
	}
}
```

6.2.2、<a href="#a_filter">Filter过滤器的使用</a><br/>

6.2.3、通过注解方式实现ServletContextListener 监听器：<br/>
ServletContextListener：[javax.servlet.ServletContextListener](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/javax/servlet/ServletContextListener.html)
```
此接口的实现接收有关它们所属的Web应用程序的servlet上下文的更改的通知。要接收通知事件，必须在Web应用程序的部署描述符中配置实现类。


contextDestroyed(ServletContextEvent sce)
	Web应用程序初始化过程正在启动的通知。在初始化Web应用程序中的任何过滤器或servlet之前，将通知所有ServletContextListener上下文初始化。默认实现是NO-OP。
contextInitialized(ServletContextEvent sce)
	通知servlet上下文即将关闭。在通知任何ServletContextListener上下文销毁之前，所有servlet和过滤器都已被destroy()编辑。默认实现是NO-OP。
```

@WebListener：[javax.servlet.annotation.WebListener](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/javax/servlet/annotation/WebListener.html)
```
用于在给定Web应用程序上下文中为各种类型的事件声明侦听器的注释。
注释必须实现一个，（或更多），
下面的接口的类：HttpSessionAttributeListener， HttpSessionListener， ServletContextAttributeListener， ServletContextListener，  
ServletRequestAttributeListener， ServletRequestListener或 例如HttpSessionIdListener 

java.lang.String	value 
	听众的描述，如果存在的话
```

TestServletContextListener.java：
```Java
package com.mutistic.servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.mutistic.utils.CommonUtil;
// Servlet3的 @WebListener 注解 实现ServletContextListener 监听器
@WebListener
public class TestServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		StringBuffer val = new StringBuffer("\n1、演示 ServletContextListener - contextInitialized方法");
		val.append("\n【Listener：实现 ServletContextListener 接口，实现 @WebListener 注解】");
		val.append("\n【方法：重写ServletContextListener的contextInitialized()】");
		System.out.println(val.toString());
		CommonUtil.printOne("执行：TestServletContextListener implements ServletContextListener.contextInitialized()");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CommonUtil.printOne("执行：TestServletContextListener implements ServletContextListener.contextDestroyed()");
	}
}
```

6.3、通过Configuration配置类创建bean（建议用注解方式）:<br/>
TestServletConfiguration.java：
```Java
package com.mutistic.servlet;
import java.util.Arrays;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.mutistic.utils.CommonUtil;
@SpringBootConfiguration
public class TestServletConfiguration {
	// 通过 ServletRegistrationBean 创建  Servlet bean
	@Bean
	public ServletRegistrationBean<TestControllerByConfig> createrTestHttpServletByConfig() {
		CommonUtil.printOne("执行：创建 ServletRegistrationBean<TestControllerByConfig> bean");
//		ServletRegistrationBean<TestHttpServletByConfig> reg = new ServletRegistrationBean<TestHttpServletByConfig>();
//		reg.setServlet(new TestHttpServletByConfig()); // 配置 httpServlet类
//		reg.addUrlMappings("/testHttpServletByConfig.do"); // 配置访问URL
//		return reg;
		return new ServletRegistrationBean<TestControllerByConfig>(new TestControllerByConfig(), "/testHttpServletByConfig.do");
	}
	
	// 通过 ServletListenerRegistrationBean 创建ServletContextListener bean
	@Bean
	public ServletListenerRegistrationBean<TestServletContextListenerByConfig> createrTestServletContextListenerByConfig() {
		CommonUtil.printOne("执行：创建 ServletListenerRegistrationBean<TestServletContextListenerByConfig> bean");
		return new ServletListenerRegistrationBean<TestServletContextListenerByConfig>(new TestServletContextListenerByConfig());
	}
}
```

6.3.1、通过ServletRegistrationBean注册Servlet:<br/>
ServletRegistrationBean：[org.springframework.boot.web.servlet.ServletRegistrationBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/web/servlet/ServletRegistrationBean.html)
```
在Servlet 3.0+容器中ServletContextInitializer注册Servlets。类似于Spring Bean友好设计registration提供的功能ServletContext。
在servlet必须在调用之前指定 RegistrationBean.onStartup(javax.servlet.ServletContext)。
setUrlMappings(java.util.Collection<java.lang.String>)映射到'/ *'时可以使用或省略URL映射（除非 alwaysMapUrl设置为 false）。
如果未指定，将推导出servlet名称。

protected javax.servlet.ServletRegistration.Dynamic	addRegistration(String description, javax.servlet.ServletContext servletContext) 
	在servlet注册ServletContext中

addUrlMappings(String... urlMappings)
	为Servlet添加Servlet规范中定义的URL映射。

protected configure(javax.servlet.ServletRegistration.Dynamic registration)
	配置注册设置。

protected String	getDescription()
	返回注册说明。

javax.servlet.MultipartConfigElement	getMultipartConfig()
	返回multi-part configuration要应用的或null。

T	getServlet()
	返回正在注册的servlet。

String	getServletName()
	返回将要注册的servlet名称。

Collection<String>	getUrlMappings()
	返回servlet规范中定义的URL映射的可变集合，如Servlet规范中所定义。

setLoadOnStartup(int loadOnStartup)
	设置loadOnStartup优先级。

setMultipartConfig(javax.servlet.MultipartConfigElement multipartConfig)
	设置multi-part configuration。

setServlet(T servlet)
	设置要注册的servlet。	

setUrlMappings(Collection<String> urlMappings)
	设置servlet的URL映射。
```

6.3.2、<a href="#a_filter">7.2、通过 FilterRegistrationBean 注册Filter</a><br/>

6.3.3、通过ServletListenerRegistrationBean注册Listener:<br/>
ServletListenerRegistrationBean：[org.springframework.boot.web.servlet.ServletListenerRegistrationBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/web/servlet/ServletListenerRegistrationBean.html)
```
在Servlet 3.0+容器中ServletContextInitializer注册EventListeners。类似于Spring Bean友好设计registration提供的功能ServletContext。此bean可用于注册以下类型的侦听器：
	ServletContextAttributeListener
	ServletRequestListener
	ServletRequestAttributeListener
	HttpSessionAttributeListener
	HttpSessionListener
	ServletContextListener

protected String	getDescription()
	返回注册说明。

T	getListener()
	返回要注册的监听器。

static Set<Class<?>>	getSupportedTypes()
	返回此注册支持的类型。

static boolean	isSupportedType(EventListener listener)
	true如果指定的侦听器是受支持的类型之一，则返回。

protected register(String description, javax.servlet.ServletContext servletContext)
	使用servlet上下文注册此bean。
	
setListener(T listener)
	设置要注册的侦听器。
```

---
### <a id="a_filter">七、Filter过滤器的使用</a> <a href="#a_servlet">last</a> <a href="#a_interceptor">next</a>
7.1、通过注解方式实现Filter：<br/>
Filter：[javax.servlet.Filter](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/javax/servlet/Filter.html)
```
过滤器是对资源请求（servlet或静态内容）或来自资源的响应（或两者）执行过滤任务的对象。
过滤器在doFilter方法中执行过滤。每个Filter都可以访问FilterConfig对象，从该对象可以获取其初始化参数，即可以使用的ServletContext引用，例如，加载过滤任务所需的资源。
过滤器在Web应用程序的部署描述符中配置
已为此设计确定的示例包括：
	1）验证过滤器
	2）日志记录和审核过滤器
	3）图像转换过滤器
	4）数据压缩过滤器
	5）加密过滤器
	6）令牌过滤器
	7）触发资源访问事件的过滤器
	8）XSL / T过滤器
	9）Mime型链式过滤器

destroy()
	由Web容器调用以向过滤器指示它正在投入使用。在实例化过滤器之后，servlet容器只调用一次init方法。在要求过滤器执行任何过滤工作之前，init方法必须成功完成。
	如果使用init方法，则Web容器无法将过滤器置于服务中：抛出ServletException  不在Web容器定义的时间段内返回 
	默认实现是NO-OP

doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	doFilter每次由于客户端请求链末端的资源而请求/响应对通过链时，容器都会调用Filter 的方法。
	传递给此方法的FilterChain允许Filter将请求和响应传递给链中的下一个实体。
	此方法的典型实现将遵循以下模式： 
	1.检查请求
	2.可选地使用自定义实现包装请求对象以过滤用于输入过滤的内容或标头
	3.可选地使用自定义实现来包装响应对象以进行过滤内容或标题为输出滤波
	4.）要么调用链中的使用FilterChain对象（下一个实体chain.doFilter()），
	4.1）中或没有在请求/响应对传递到下一个实体在过滤器链，以阻止请求处理
	5.在调用过滤器链中的下一个实体后，直接在响应上设置标头。

init(FilterConfig filterConfig)
	由Web容器调用以向过滤器指示它正在停止服务。只有在过滤器的doFilter方法中的所有线程都已退出或超时时间过后，才会调用此方法。
	在Web容器调用此方法之后，它不会在此筛选器实例上再次调用doFilter方法。
	此方法使过滤器有机会清除所有正在保留的资源（例如，内存，文件句柄，线程），并确保任何持久状态与过滤器在内存中的当前状态同步。默认实现是NO-OP。
```

@WebFilter：[javax.servlet.annotation.WebFilter](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/javax/servlet/annotation/WebFilter.html)
```
用于声明Servlet的注释Filter。
该注释将在部署期间由容器处理，其中找到它的Filter类将根据配置创建并应用于URL模式Servlets和 DispatcherTypes。
如果未定义name属性，则使用该类的完全限定名称。
必须在注释的valueor urlPattern属性中声明至少一个URL模式，但不能同时在两者中声明。
该value属性被建议用于URL模式是唯一的属性被设置，否则urlPattern应使用属性。
带注释的类必须实现Filter
```

TestFilter.java：
```Java
package com.mutistic.servlet;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import com.mutistic.utils.CommonUtil;
// Servlet3的 @WebFilter 注解 实现 Filter
//@WebFilter("/*") // 过滤所有请求
@WebFilter("/testHttpServlet.do")
public class TestFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		CommonUtil.printOne("执行：TestFilter implements Filter.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CommonUtil.printOne("执行：TestFilter implements Filter.doFilter()");
		
		StringBuffer val = new StringBuffer("\n1、演示 javax.servlet.Filter - doFilter方法");
		val.append("\n【Filter：实现 javax.servlet.Filter 接口，实现 @WebFilter(\"/*.do\") 注解配置过滤请求】");
		val.append("\n【方法：重写Filter的doFilter()】");
		val.append("\n【PS1：@WebFilter可以指定具体请求的过滤】");
		val.append("\n【PS2：配置过滤器后，要嗲用chain.doFilter(request, response) 防止无法请求的访问】");
		System.out.println(val.toString());
		
		request.setCharacterEncoding(CommonUtil.UTF8);
		response.setCharacterEncoding(CommonUtil.UTF8);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		CommonUtil.printOne("执行：TestFilter implements Filter.destroy()");
	}
}
```

7.2、通过 FilterRegistrationBean 注册Filter：<br/>
FilterRegistrationBean：[org.springframework.boot.web.servlet.FilterRegistrationBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/web/servlet/FilterRegistrationBean.html)
```
在Servlet 3.0+容器中ServletContextInitializer注册Filters。类似于Spring Bean友好设计registration 提供的功能ServletContext。
在Filter必须在调用之前指定 RegistrationBean.onStartup(ServletContext)。注册可以与URL patterns和/或servlet 相关联 
（通过name或通过ServletRegistrationBeans。当没有指定URL模式或servlet时，过滤器将与'/ *'相关联。
如果未指定，将推断过滤器名称。

T	getFilter()
	返回Filter要注册。

setFilter(T filter)
	设置要注册的过滤器。
```

TestServletConfiguration.java：
```Java
package com.mutistic.servlet;
import java.util.Arrays;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.mutistic.utils.CommonUtil;
@SpringBootConfiguration
public class TestServletConfiguration {
	// 通过 FilterRegistrationBean 创建  Filter bean
	@Bean
	public FilterRegistrationBean<TestFilterByConfig> createrTestFilterByConfig() {
		CommonUtil.printOne("执行：创建 FilterRegistrationBean<TestFilterByConfig> bean");
		
		FilterRegistrationBean<TestFilterByConfig> filter = new FilterRegistrationBean<TestFilterByConfig>();
		filter.setFilter(new TestFilterByConfig()); // 配置 Filter类
//		filter.setServletRegistrationBeans(Arrays.asList(createrTestHttpServletByConfig()));
		filter.setUrlPatterns(Arrays.asList("/testHttpServletByConfig.do")); //配置过滤URL
		return filter;
	}
}
```

---
### <a id="a_interceptor">八、HandlerInterceptor拦截器的使用</a> <a href="#a_filter">last</a> <a href="#a_error">next</a>
HandlerInterceptor拦截器使用步骤：
```
1、实现 HandlerInterceptor 接口，重写 preHandle()、postHandle()、afterCompletion()方法
1.1、preHandle方法：在Controller请求之前触发（一般用于登陆验证）
1.2、postHandle方法：在Controller请求之后，页面未渲染时触发（一般用于业务逻辑等）
1.3、afterCompletion方法：Controller请求完毕，页面渲染完成触发（一般用于清理资源）

2、继承 WebMvcConfigurer 类，重写addInterceptors()方法，实现@SpringBootConfiguration注解
2.1、通过 InterceptorRegistry.addInterceptor() 添加 实例化的 HandlerInterceptor实现类
2.2、通过 InterceptorRegistration.addPathPatterns() 添加需要拦截的请求路径

PS1：使用WebMvcConfigurationSupport 需要自定义所有的配置，通常不建议使用这个。
```

8.1、实现 HandlerInterceptor 接口：<br/>
HandlerInterceptor：[org.springframework.web.servlet.HandlerInterceptor](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/HandlerInterceptor.html)
```
允许自定义处理程序执行链的工作流接口。
应用程序可以为某些处理程序组注册任意数量的现有或自定义拦截器，以添加常见的预处理行为，而无需修改每个处理程序实现。

在适当的HandlerAdapter触发处理程序本身的执行之前调用HandlerInterceptor。
此机制可用于大量预处理方面，例如用于授权检查，或常见的处理程序行为，如区域设置或主题更改。其主要目的是允许分解重复的处理程序代码。

在异步处理场景中，处理程序可以在单独的线程中执行，而主线程退出而不呈现或调用 postHandle和afterCompletion回调。
并发处理程序执行完成后，将调度该请求以继续呈现模型，并再次调用此合同的所有方法。

通常，每个HandlerMapping bean定义一个拦截器链，共享其粒度。
为了能够将某个拦截器链应用于一组处理程序，需要通过一个HandlerMapping bean映射所需的处理程序。
拦截器本身在应用程序上下文中定义为bean，由映射bean定义通过其“拦截器”属性引用（在XML中：<list> of <ref>）。

HandlerInterceptor基本上类似于Servlet过滤器，但与后者相反，它只允许自定义预处理，禁止执行处理程序本身，以及自定义后处理。
过滤器功能更强大，例如，它们允许交换传递链中的请求和响应对象。请注意，过滤器在web.xml中配置，web.xml是应用程序上下文中的HandlerInterceptor。

作为基本准则，与细粒度处理程序相关的预处理任务是HandlerInterceptor实现的候选者，尤其是分解出来的公共处理程序代码和授权检查。
另一方面，过滤器非常适合请求内容和视图内容处理，如多部分表单和GZIP压缩。这通常表示何时需要将过滤器映射到某些内容类型（例如图像）或所有请求

afterCompletion(HttpServletRequest request, HttpServletResponse response, java.lang.Object handler, java.lang.Exception ex)
	拦截处理程序的执行。在HandlerMapping确定适当的处理程序对象之后调用，但在HandlerAdapter调用处理程序之前。
	DispatcherServlet处理执行链中的处理程序，该处理程序由任意数量的拦截器组成，最后处理程序本身。
		使用此方法，每个拦截器可以决定中止执行链，通常发送HTTP错误或编写自定义响应。
	注意：特殊注意事项适用于异步请求处理

postHandle(HttpServletRequest request, HttpServletResponse response, java.lang.Object handler, ModelAndView modelAndView)
	拦截处理程序的执行。在HandlerAdapter实际调用处理程序之后调用，但在DispatcherServlet呈现视图之前调用。
		可以通过给定的ModelAndView将其他模型对象公开给视图。
	DispatcherServlet处理执行链中的处理程序，该处理程序由任意数量的拦截器组成，最后处理程序本身。
		使用此方法，每个拦截器可以对执行进行后处理，以执行链的相反顺序应用。
	注意：特殊注意事项适用于异步请求处理

default boolean	preHandle(HttpServletRequest request, HttpServletResponse response, java.lang.Object handler)
	完成请求处理后回调，即渲染视图后回调。将调用处理程序执行的任何结果，从而允许适当的资源清理。
	注意：只有在拦截器的preHandle 方法成功完成并返回时才会被调用true！
	与该postHandle方法一样，该方法将以相反的顺序在链中的每个拦截器上调用，因此第一个拦截器将是最后一个被调用的拦截器。
	注意：特殊注意事项适用于异步请求处理
```

AsyncHandlerInterceptor：[org.springframework.web.servlet.AsyncHandlerInterceptor](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/AsyncHandlerInterceptor.html)
```
HandlerInterceptor使用在异步请求处理开始后调用的回调方法进行扩展。

当处理程序启动异步请求时，DispatcherServlet 退出而不调用postHandle并且afterCompletion通常对同步请求执行，
因为请求处理的结果（例如ModelAndView）可能尚未就绪并且将从另一个线程同时生成。
在这种情况下，
afterConcurrentHandlingStarted(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object) 会调用，允许实现执行任务，例如在将线程释放到Servlet容器之前清理线程绑定的属性。

异步处理完成后，将请求分派给容器以进行进一步处理。在这个阶段，DispatcherServlet 所调用preHandle，postHandle和afterCompletion。
到初始请求和异步处理完成后后续的调度之间进行区分，拦截器可以检查是否 javax.servlet.DispatcherType的ServletRequest 是"REQUEST"或"ASYNC"。

请注意，HandlerInterceptor当异步请求超时或因网络错误而完成时，实现可能需要执行。
对于这种情况，Servlet容器不会调度，因此不会调用postHandle和afterCompletion方法。
相反，拦截器可以注册以通过registerCallbackInterceptor和registerDeferredResultInterceptor 
方法跟踪异步请求WebAsyncManager.preHandle无论是否将启动异步请求处理，都可以主动对每个请求执行此操作

afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, java.lang.Object handler)
	调用而不是postHandle和afterCompletion 处理程序同时执行时。
	实现可以使用提供的请求和响应，但应避免以与处理程序的并发执行冲突的方式修改它们。此方法的典型用法是清理线程局部变量
```

TestHandlerInterceptor.java：
```Java
package com.mutistic.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.mutistic.utils.CommonUtil;
// 实现 HandlerInterceptor 接口 定制拦截器
public class TestHandlerInterceptor implements HandlerInterceptor {
	/**
	 * 在Controller请求之前触发（一般用于登陆验证）
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		CommonUtil.printOne("执行：TestHandlerInterceptor implements HandlerInterceptor.preHandle()[在请求之前触发（一般用于登陆验证）]" + handler);
		return true;
	}

	/**
	 * 在Controller请求之后，页面未渲染时触发（一般用于业务逻辑等）
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		CommonUtil.printOne("执行：TestHandlerInterceptor implements HandlerInterceptor.postHandle()[在请求之后，页面未渲染时触发（一般用于业务逻辑等）]");
	}

	/**
	 * Controller请求完毕，页面渲染完成触发（一般用于清理资源）
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		CommonUtil.printOne("执行：TestHandlerInterceptor implements HandlerInterceptor.afterCompletion()[请求完毕，页面渲染完成触发（一般用于清理资源）]");
	}
}
```

8.2、继承 WebMvcConfigurer 类，添加HandlerInterceptor实例：<br/>
WebMvcConfigurer：[org.springframework.web.servlet.config.annotation.WebMvcConfigurer](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurer.html)
```
定义回调方法，以自定义启用Spring MVC的基于Java的配置@EnableWebMvc。
@EnableWebMvc注释配置类可以实现此接口以回调并有机会自定义默认配置。


addArgumentResolvers(java.util.List<HandlerMethodArgumentResolver> resolvers)
	添加解析器以支持自定义控制器方法参数类型。

addCorsMappings(CorsRegistry registry)
	配置跨源请求处理。

addFormatters(FormatterRegistry registry)
	在默认情况下添加Converters和Formatters。

addInterceptors(InterceptorRegistry registry)
	添加Spring MVC生命周期拦截器，用于控制器方法调用的预处理和后处理。

addResourceHandlers(ResourceHandlerRegistry registry)
	添加处理程序以提供静态资源，例如来自Web应用程序根目录下的特定位置的图像，js和css文件，类路径等。

addReturnValueHandlers(java.util.List<HandlerMethodReturnValueHandler> handlers)
	添加处理程序以支持自定义控制器方法返回值类型。

addViewControllers(ViewControllerRegistry registry)
	配置预先配置了响应状态代码的简单自动控制器和/或视图以呈现响应主体。

configureAsyncSupport(AsyncSupportConfigurer configurer)
	配置异步请求处理选项。

configureContentNegotiation(ContentNegotiationConfigurer configurer)
	配置内容协商选项。

configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	配置处理程序以通过转发到Servlet容器的“默认”servlet来委派未处理的请求。

configureHandlerExceptionResolvers(java.util.List<HandlerExceptionResolver> resolvers)
	配置异常解析器。

configureMessageConverters(java.util.List<HttpMessageConverter<?>> converters)
	配置HttpMessageConverters用于读取或写入请求或响应的正文。

configurePathMatch(PathMatchConfigurer configurer)
	帮助配置HandlerMappings路径匹配选项，例如尾部斜杠匹配，后缀注册，路径匹配器和路径助手。

configureViewResolvers(ViewResolverRegistry registry)
	配置视图解析器以将从控制器返回的基于字符串的视图名称转换为具体View 实现以执行渲染。

extendHandlerExceptionResolvers(java.util.List<HandlerExceptionResolver> resolvers)
	扩展或修改默认配置的异常解析器列表。

extendMessageConverters(java.util.List<HttpMessageConverter<?>> converters)
	用于在配置转换器列表后扩展或修改转换器列表的挂钩。

default MessageCodesResolver	getMessageCodesResolver()
	提供MessageCodesResolver用于根据数据绑定和验证错误代码构建消息代码的自定义。

default Validator	getValidator()
	提供自定义Validator而不是默认创建的自定义。
```

WebMvcConfigurerAdapter：[org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurerAdapter.html)
```
已过时。WebMvcConfigurer使用空方法的实现，允许子类仅覆盖它们感兴趣的方法。
```

WebMvcConfigurationSupport：[org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.html)
```
这是提供MVC Java后置的配置的主类。
通常通过添加@EnableWebMvc到应用程序@Configuration类来导入它。
另一个更高级的选项是直接从此类扩展并根据需要覆盖方法，记住添加@Configuration到子类和@Bean重写@Bean方法。

该类注册以下内容HandlerMappings：
	RequestMappingHandlerMapping 在0处排序，用于将请求映射到带注释的控制器方法。
	HandlerMapping 从1开始，将URL路径直接映射到视图名称。
	BeanNameUrlHandlerMapping 在2处排序以将URL路径映射到控制器bean名称。
	HandlerMapping 命令at Integer.MAX_VALUE-1来提供静态资源请求。
	HandlerMapping 命令Integer.MAX_VALUE将请求转发到默认servlet。

注册这些HandlerAdapters：
	RequestMappingHandlerAdapter 用于使用带注释的控制器方法处理请求。
	HttpRequestHandlerAdapter 用于处理请求HttpRequestHandlers。
	SimpleControllerHandlerAdapter 用于处理基于接口的请求Controllers。
	HandlerExceptionResolverComposite使用此链接的异常解析器注册a ：
	ExceptionHandlerExceptionResolver通过ExceptionHandler方法处理异常 。
	ResponseStatusExceptionResolver用于注释的例外 ResponseStatus。
	DefaultHandlerExceptionResolver 用于解析已知的Spring异常类型

注册AntPathMatcher和a UrlPathHelper 用于：
	的RequestMappingHandlerMapping，
	在HandlerMapping对ViewControllers
	和HandlerMapping服务资源

注意，这些bean可以配置一个PathMatchConfigurer。
	无论是RequestMappingHandlerAdapter和 ExceptionHandlerExceptionResolver与默认情况下，以下的默认实例配置：
	一个 ContentNegotiationManager
	一个 DefaultFormattingConversionService
	OptionalValidatorFactoryBean 如果类路径上有JSR-303实现可用
	一系列HttpMessageConverters取决于类路径上可用的第三方库。
```

@EnableWebMvc：[org.springframework.web.servlet.config.annotation.EnableWebMvc](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/EnableWebMvc.html)
```
将此批注添加到@Configuration类中可导入Spring MVC配置WebMvcConfigurationSupport
	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackageClasses = MyConfiguration.class)
	public class MyConfiguration {
	}

要自定义导入的配置，请实现接口 WebMvcConfigurer并覆盖单个方法，例如：
	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackageClasses = MyConfiguration.class)
	public class MyConfiguration implements WebMvcConfigurer {
	       @Override
	       public void addFormatters(FormatterRegistry formatterRegistry) {
	     		formatterRegistry.addConverter(new MyConverter());
	       }
	       @Override
	       public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    		 converters.add(new MyHttpMessageConverter());
	       }
	}


注意：只有一个@Configuration类可以具有@EnableWebMvc导入Spring Web MVC配置的 注释。但是，可以有多个@Configuration类来实现WebMvcConfigurer，以便自定义提供的配置。
如果WebMvcConfigurer没有公开需要配置​​的更高级设置，请考虑删除@EnableWebMvc 
注释并直接从WebMvcConfigurationSupport 或扩展DelegatingWebMvcConfiguration，例如：
	@Configuration
	@ComponentScan(basePackageClasses = { MyConfiguration.class })
	public class MyConfiguration extends WebMvcConfigurationSupport {
	   @Override
	   public void addFormatters(FormatterRegistry formatterRegistry) {
			 formatterRegistry.addConverter(new MyConverter());
	   }
	   @Bean
	   public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
			 // Create or delegate to "super" to create and
			 // customize properties of RequestMappingHandlerAdapter
	   }
	}
```

TestConfigurationByHI.java：
```Java
package com.mutistic.interceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.mutistic.utils.CommonUtil;
// 实现 WebMvcConfigurer通过 addInterceptors()方法添加 HandlerInterceptor 实例
@SpringBootConfiguration
//public class TestConfigurationByHI extends WebMvcConfigurationSupport { // 屏蔽Spring Boot的@EnableAutoConfiguration中的设置，需要自定义所有的配置
//public class TestConfigurationByHI extends WebMvcConfigurerAdapter { // SpringBoot2.0及Spring 5.0 WebMvcConfigurerAdapter已过期
public class TestConfigurationByHI implements WebMvcConfigurer { // 源接口类 使用 WebMvcConfigurer 代替过期的 WebMvcConfigurerAdapter
	/**
	 * 拦截器的使用方式：
	 * WebMvcConfigurationSupport：https://www.cnblogs.com/deng720/p/8989388.html
	 * WebMvcConfigurerAdapter：https://blog.csdn.net/u012129558/article/details/79006253
	 * WebMvcConfigurer：http://412887952-qq-com.iteye.com/blog/2398639
	 */
	/**
	 * 添加拦截器
	 * @param registry
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		CommonUtil.printOne("执行：TestConfigurationByHI implements WebMvcConfigurer.addInterceptors()");
		registry.addInterceptor(new TestHandlerInterceptor()).addPathPatterns("/testControllerByHI/*");
	}
}
```

TestControllerByHI.java：
```Java
package com.mutistic.interceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mutistic.utils.CommonUtil;
// Controller请求 演示 HandlerInterceptor拦截器
@RestController
@RequestMapping("/testControllerByHI/")
public class TestControllerByHI {
	@GetMapping(value = "showHandlerInterceptor", produces = "text/html;charset=UTF-8")
	public String showHandlerInterceptor() {
		return CommonUtil.printTwo("Controller请求 演示 HandlerInterceptor拦截器", "showHandlerInterceptor");
	}
}
```

8.3、使用WebMvcConfigurerAdapter演示FastJson的格式化拦截器：
pom.xml添加fastjson依赖：
```xml
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>fastjson</artifactId>
	<version>1.2.47</version>
</dependency>
```
		
FastJsonAdapter.java：
```Java
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
// 添加FastJSON 转换适配器
@SpringBootConfiguration
public class FastJsonAdapter extends WebMvcConfigurerAdapter {
	//  方式一：使用创建HttpMessageConverters bean
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
	 * 方式一：使用WebMvcConfigurerAdapter方式实现数据转换
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
```

---
### <a id="a_error">九、自定义Error视图</a> <a href="#a_interceptor">last</a> <a href="#a_jdbc">next</a>
9.1、通过ErrorPageRegistrar配置错误跳转界面：<br/>
ErrorPageRegistrar：[org.springframework.boot.web.server.ErrorPageRegistrar](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/web/server/ErrorPageRegistrar.html)
```
这是一个功能接口，因此可以用作lambda表达式或方法引用的赋值目标。

registerErrorPages(ErrorPageRegistry registry)
	根据给定注册表的要求注册页面。
```

ErrorPage：[org.springframework.boot.web.server.ErrorPage](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/web/server/ErrorPage.html)
```
简单的与服务器无关的错误页面抽象。大致相当于<error-page> 传统上在web.xml中找到的元素。

Class<? extends Throwable>	getException()
	返回异常类型（或者null按状态匹配的页面）。

String	getExceptionName()
	异常类型名称。

String	getPath()
	渲染路径（通常实现为向前），以“/”开头。

org.springframework.http.HttpStatus	getStatus()
	此错误页面匹配的HTTP状态值（或null对于按例外匹配的页面）。

int	getStatusCode()
	此错误页面匹配的HTTP状态值。

boolean	isGlobal()
	如果此错误页面是全局错误页面，则返回（匹配所有不匹配的状态和异常类型）。
```

ErrorPageRegistrar的使用步骤：
```
1、实现 ErrorPageRegistrar 接口
2、重写 registerErrorPages() 方法：
3、通过 ErrorPageRegistry.addErrorPages() 方法添加 ErrorPage 错误界面
3.1、错误界面配置默认路径：src/main/resourece下
3.2、ErrorPage可以通过 HttpStatus：错误状态码配置错误界面
3.3、ErrorPage可以通过 Throwable：异常类配置错误界面
```

ErrorPageConfig.java：
```Java
package com.mutistic.error;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
// 自定义异常错误界面 
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
```

src/main/resources/html/error/404.html：
```Html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>自定义400异常-错误页面</h1>
	自定义错误页面的使用：
	<br /> 1、实现 ErrorPageRegistrar 接口
	<br />2、重写 registerErrorPages() 方法：
	<br />3、通过 ErrorPageRegistry.addErrorPages() 方法添加 ErrorPage 错误界面
	<br />3.1、错误界面配置默认路径：src/main/resourece下
	<br />3.2、ErrorPage可以通过 HttpStatus：错误状态码配置错误界面
	<br />3.3、ErrorPage可以通过 Throwable：异常类配置错误界面
</body>
</html>
```

9.2、Controller使用@ExceptionHandler声明异常处理返回，对本Controller有效
ExceptionHandler：[org.springframework.web.bind.annotation.ExceptionHandler](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/ExceptionHandler.html)
```
用于处理特定处理程序类和/或处理程序方法中的异常的注释。

使用此注释注释的处理程序方法允许具有非常灵活的签名。它们可以按任意顺序具有以下类型的参数：
	异常参数：声明为一般异常或更具体的异常。如果注释本身不通过它缩小异常类型，这也可以作为映射提示value()。
	请求和/或响应对象（通常来自Servlet API）。您可以选择任何特定的请求/响应类型，例如 ServletRequest/ HttpServletRequest。
	会话对象：通常HttpSession。此类型的参数将强制存在相应的会话。因此，这样的论证永远不会null。 请注意，会话访问可能不是线程安全的，特别是在Servlet环境中："synchronizeOnSession"如果允许多个请求同时访问会话，请考虑将标志切换 为“true”。
	WebRequest或 NativeWebRequest。允许通用请求参数访问以及请求/会话属性访问，而不与本机Servlet API绑定。
	Locale对于当前请求区域设置（由最可用的区域设置解析程序确定，即LocaleResolver 在Servlet环境中配置）。
	InputStream/ Reader用于访问请求的内容。这将是Servlet API公开的原始InputStream / Reader。
	OutputStream/ Writer用于生成响应的内容。这将是Servlet API公开的原始OutputStream / Writer。
	Model作为从处理程序方法返回模型映射的替代方法。请注意，提供的模型不预先填充常规模型属性，因此始终为空，以便为特定于异常的视图准备模型。

处理程序方法支持以下返回类型：
	一个ModelAndView对象（来自Servlet MVC）。
	一个Model对象，视图名称通过一个隐式确定RequestToViewNameTranslator。
	甲Map用于曝光模式，与视图名称对象隐含地通过确定 RequestToViewNameTranslator。
	一个View对象。
	一个String值，它被解释为视图名称。
	@ResponseBody带注释的方法（仅限Servlet）来设置响应内容。返回值将使用消息转换器转换为响应流 。
	一个HttpEntity<?>或 一个ResponseEntity<?>对象（仅限Servlet）来设置响应头和内容。ResponseEntity主体将使用消息转换器进行转换并写入响应流 。
	void如果方法处理响应本身（通过直接编写响应内容 ，为此目的声明类型ServletResponse/ 的参数 HttpServletResponse）
		或者是否应该通过RequestToViewNameTranslator （不在处理程序方法签名中声明响应参数）隐式确定视图名称。

可以将ExceptionHandler注释与 @ResponseStatus特定HTTP错误状态组合使用。


java.lang.Class<? extends java.lang.Throwable>[]	value
	注释方法处理的异常。
```

TestControllerByEH.java：
```Java
package com.mutistic.error;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/testControllerByEH/")
public class TestControllerByEH {
	// 通过 @ExceptionHandler 处理当前Controller异常
	@ExceptionHandler(value = NullPointerException.class)
	@ResponseBody
	public String error(NullPointerException e) {
		return "\n通过 @ExceptionHandler 处理当前Controller异常:" + e.getMessage();
	}
	// 通过 @ExceptionHandler 处理当前Controller异常
	@GetMapping(value = "showExceptionHandler1")
	public void showErrorView() throws Exception {
		StringBuffer val = new StringBuffer("\n1、通过 @ExceptionHandler 处理当前Controller异常");
		val.append("\n[Controller：声明一个方法实现 @ExceptionHandler 注解]");
		val.append("\n[ExceptionHandler.value：拦截指定异常：value = Exception.class]");
		val.append("\n[PS1：@ExceptionHandler 只对当前Controller生效]");
		val.append("\n[PS2： @ExceptionHandler 会导致返回中文是乱码，需要对HttpServletRequest，HttpServletResponse 重新设置 CharacterEncoding 编码]");
		val.append("\n[PS3： @ExceptionHandler 优先级比 ErrorPageRegistrar配置的 低（可以声明多个）]");
		System.out.println(val.toString());
		throw new NullPointerException(val.toString());
	}
}
```

9.3、通过@ControllerAdvice声明全局@ExceptionHandler异常处理：<br/>
@ControllerAdvice：[org.springframework.web.bind.annotation.ControllerAdvice](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html)
```
@component的专用化，用于声明@异常处理程序、@initbinder或@modelattribute方法，以便跨多个@controller类共享。

@ControllerAdvice可以将类显式声明为Spring bean或通过类路径扫描自动检测。
所有这些bean 在运行时通过AnnotationAwareOrderComparator，即基于 @Order和 排序 Ordered，并按顺序应用。
对于处理异常，@ExceptionHandler将使用匹配的异常处理程序方法在第一个建议上选择一个异常。
对于模型的属性和InitBinder初始化，@ModelAttribute 和@InitBinder方法也将按照@ControllerAdvice顺序。

注意：对于@ExceptionHandler方法，在特定通知bean的处理程序方法中，根目录异常匹配将优先于匹配当前异常的原因。
但是，优先级较高的建议的原因匹配仍然优先于较低优先级的通知bean上的任何匹配（无论是根目录还是原因级别）。
因此，请在具有相应顺序的优先级通知bean上声明主根异常映射！

默认情况下，@ControllerAdvice全局应用于所有控制器的方法。使用选择器annotations()， 
basePackageClasses()和basePackages()（或其别名 value()）来定义更窄的目标控制器子集。
如果声明了多个选择器，则应用OR逻辑，这意味着所选控制器应匹配至少一个选择器。
请注意，选择器检查是在运行时执行的，因此添加许多选择器可能会对性能产生负面影响并增加复杂性。

java.lang.Class<? extends java.lang.annotation.Annotation>[]	annotations
	注释数组。

java.lang.Class<?>[]	assignableTypes
	类的数组。

java.lang.Class<?>[]	basePackageClasses
	类型安全的替代方法，value()用于指定包以选择由@ControllerAdvice 注释类辅助的控制器。

java.lang.String[]	basePackages
	基础包的数组。

java.lang.String[]	value
	basePackages()属性的别名。
```

GlobalExceptionHandler.java：
```Java
package com.mutistic.error;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mutistic.utils.CommonUtil;
@ControllerAdvice
public class GlobalExceptionHandler {
	// 通过 @ExceptionHandler 声明全局异常处理
	@ExceptionHandler(value = FileNotFoundException.class)
	@ResponseBody
	public String error(Exception e, HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding(CommonUtil.UTF8);
			response.setCharacterEncoding(CommonUtil.UTF8);
		} catch (UnsupportedEncodingException e1) { }
		

		StringBuffer val = new StringBuffer("\n通过@ControllerAdvice +  @ExceptionHandler 处理全局异常");
		val.append("\n[Class：声明一个类实现 @ControllerAdvice 注解]");
		val.append("\n[Method：声明一个方法实现 @ExceptionHandler 注解，同时实现 @ResponseBody注解]");
		val.append("\n[ExceptionHandler.value：拦截指定异常：value = FileNotFoundException.class]");
		val.append("\n[PS1： @ExceptionHandler 会导致返回中文是乱码，需要对HttpServletRequest，HttpServletResponse 重新设置 CharacterEncoding 编码]");
		val.append("\n[PS2： 全局的@ExceptionHandler 优先级比 具体Controller的ExceptionHandler 低 （可以声明多个）]");
		val.append("\n[PS3： @ExceptionHandler 优先级比 ErrorPageRegistrar配置的 低]");

		return "通过 @ExceptionHandler 声明全局异常处理:" + e.getMessage();
	}
}
```

---
### <a id="a_jdbc">十、JDBC的使用</a> <a href="#a_error">last</a> <a href="#a_transaction">next</a>
10.1、使用JDBC首先要添加spring-boot-starter-jdbc依赖：<br/>
pom.xml添加spring-boot-starter-jdbc依赖
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

10.2、使用Mysql数据库：<br/>
pom.xml添加mysql-connector-java依赖
```xml
<!-- 添加mysql数据库驱动 -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
</dependency>
```
application.properties配置datasource信息：
```properties
#配置jdbc-dataSource信息：参考类：org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
## 配置jdbc驱动：使用mysql驱动
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
## 配置 jdbc url
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/study
## 配置 jdbc 用户名
spring.datasource.username=root
## 配置 jdbc 密码
spring.datasource.password=root
## 配置 Datasourece类型：eg使用 com.zaxxer.hikari.HikariDataSource代替org.apache.tomcat.jdbc.pool.DataSource 这样pom.xml就无需排除tomcat-jdbc
### 可以参考默认支持的jdbc datesource类型：DataSourceAutoConfiguration.PooledDataSourceConfiguration()，默认是：org.apache.tomcat.jdbc.pool.DataSource
#spring.datasource.type=com.zaxxer.hikari.HikariDataSource
```

10.2、演示JdbcTemplate的使用
JdbcTemplate：[org.springframework.jdbc.core.JdbcTemplate](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html)
```
这是JDBC核心包中的中心类。 它简化了JDBC的使用，有助于避免常见错误。它执行核心JDBC工作流，留下应用程序代码以提供SQL并提取结果。
此类执行SQL查询或更新，启动对ResultSet的迭代并捕获JDBC异常并将它们转换为org.springframework.dao包中定义的通用的，更具信息性的异常层次结构 。

使用此类的代码只需要实现回调接口，为它们提供明确定义的合同。该PreparedStatementCreator回调接口创建给予连接一份声明中，SQL和任何必要的参数。
所述ResultSetExtractor接口从一个结果中提取值。又见PreparedStatementSetter和 RowMapper两个流行的替代回调接口。

可以通过使用DataSource引用直接实例化在服务实现中使用，也可以在应用程序上下文中准备并作为bean引用提供给服务。
注意：DataSource应始终在应用程序上下文中配置为bean，在第一种情况下直接提供给服务，在第二种情况下配置为准备好的模板。

因为这个类可以通过回调接口和SQLExceptionTranslator 接口进行参数化，所以不需要对它进行子类化。

此类执行的所有SQL操作都在调试级别记录，使用“org.springframework.jdbc.core.JdbcTemplate”作为日志类别。
注意：配置后，此类的实例是线程安全的。


protected void	applyStatementSettings(java.sql.Statement stmt)
	准备给定的JDBC语句（或PreparedStatement或CallableStatement），应用语句设置，如获取大小，最大行数和查询超时。
int[]	batchUpdate(java.lang.String... sql)
	使用批处理在单个JDBC语句上发出多个SQL更新。

java.util.Map<java.lang.String,java.lang.Object>	call(CallableStatementCreator csc, java.util.List<SqlParameter> declaredParameters)
	使用CallableStatementCreator执行SQL调用以提供SQL和任何所需的参数。

protected java.sql.Connection	createConnectionProxy(java.sql.Connection con)
	为给定的JDBC连接创建一个关闭抑制代理。

protected java.util.Map<java.lang.String,java.lang.Object>	createResultsMap()
	创建要用作结果映射的Map实例。

<T> T	execute(CallableStatementCreator csc, CallableStatementCallback<T> action)
	执行JDBC数据访问操作，实现为处理JDBC CallableStatement的回调操作。

protected java.util.Map<java.lang.String,java.lang.Object>	extractOutputParameters(java.sql.CallableStatement cs, java.util.List<SqlParameter> parameters)
	从完成的存储过程中提取输出参数。

protected java.util.Map<java.lang.String,java.lang.Object>	extractReturnedResults(java.sql.CallableStatement cs, java.util.List<SqlParameter> updateCountParameters, java.util.List<SqlParameter> resultSetParameters, int updateCount)
	从完成的存储过程中提取返回的ResultSet。

protected RowMapper<java.util.Map<java.lang.String,java.lang.Object>>	getColumnMapRowMapper()
	创建一个新的RowMapper，用于将列作为键值对读取。

int	getFetchSize()
	返回为此JdbcTemplate指定的获取大小。

int	getMaxRows()
	返回为此JdbcTemplate指定的最大行数。

int	getQueryTimeout()
	返回此JdbcTemplate执行的语句的查询超时。

protected <T> RowMapper<T>	getSingleColumnRowMapper(java.lang.Class<T> requiredType)
	创建一个新的RowMapper，用于从单个列读取结果对象。

protected void	handleWarnings(java.sql.SQLWarning warning)
	如果遇到实际警告，则抛出SQLWarningException。

protected void	handleWarnings(java.sql.Statement stmt)
	如果我们不忽略警告，则抛出SQLWarningException，否则记录警告（在调试级别）。

boolean	isIgnoreWarnings()
	返回我们是否忽略SQLWarnings。

boolean	isResultsMapCaseInsensitive()
	返回CallableStatement的执行是否会在使用参数的不区分大小写的名称的Map中返回结果。

boolean	isSkipResultsProcessing()
	返回是否应跳过结果处理。

boolean	isSkipUndeclaredResults()
	返回是否应跳过未声明的结果。

protected PreparedStatementSetter	newArgPreparedStatementSetter(java.lang.Object[] args)
	使用传入的args创建一个新的基于arg的PreparedStatementSetter。

protected PreparedStatementSetter	newArgTypePreparedStatementSetter(java.lang.Object[] args, int[] argTypes)
	使用传入的args和类型创建一个新的基于arg-type的PreparedStatementSetter。

protected java.util.Map<java.lang.String,java.lang.Object>	processResultSet(java.sql.ResultSet rs, ResultSetSupportingSqlParameter param)
	从存储过程处理给定的ResultSet。

<T> T	query(PreparedStatementCreator psc, PreparedStatementSetter pss, ResultSetExtractor<T> rse)
	使用预准备语句进行查询，允许PreparedStatementCreator和PreparedStatementSetter。等其他重载方法

java.util.List<java.util.Map<java.lang.String,java.lang.Object>>	queryForList(java.lang.String sql)
	给定静态SQL，执行结果列表的查询。等其他重载方法

java.util.Map<java.lang.String,java.lang.Object>	queryForMap(java.lang.String sql)
	给定静态SQL，对结果Map执行查询。等其他重载方法

<T> T	queryForObject(java.lang.String sql, java.lang.Class<T> requiredType)
	给定静态SQL，对结果对象执行查询。等其他重载方法

SqlRowSet	queryForRowSet(java.lang.String sql)
	给定静态SQL，执行SqlRowSet的查询。

void	setFetchSize(int fetchSize)
	设置此JdbcTemplate的获取大小。

void	setIgnoreWarnings(boolean ignoreWarnings)
	设置我们是否要忽略SQLWarnings。

void	setMaxRows(int maxRows)
	设置此JdbcTemplate的最大行数。

void	setQueryTimeout(int queryTimeout)
	为此JdbcTemplate执行的语句设置查询超时。

void	setResultsMapCaseInsensitive(boolean resultsMapCaseInsensitive)
	设置Call​​ableStatement的执行是否将在使用参数的不区分大小写的名称的Map中返回结果。

void	setSkipResultsProcessing(boolean skipResultsProcessing)
	设置是否应跳过结果处理。

void	setSkipUndeclaredResults(boolean skipUndeclaredResults)
	设置是否应跳过未声明的结果。

protected DataAccessException	translateException(java.lang.String task, java.lang.String sql, java.sql.SQLException ex)
	将给定SQLException转换为通用DataAccessException。

int	update(PreparedStatementCreator psc)
	使用PreparedStatementCreator发出单个SQL更新操作（例如insert，update或delete语句）以提供SQL和任何必需的参数。等其他重载方法
```

MyTestDao.java：
```Java
package com.mutistic.jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class MyTestDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public String insert(Long id, String name) {
		String sql = "INSERT INTO mytest VALUES ('" + id + "', '" + name + "');";
		jdbcTemplate.execute(sql);
		return sql;
	}
}
```

MyTestController.java：
```Java
package com.mutistic.jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/myTestController/")
public class MyTestController {
	@Autowired
	private MyTestDao myTestDao;
	// 演示使用 JdbcTemplate 实现数据插入
	@PostMapping(value = "insertByTemplate", produces = "text/html;charset=UTF-8")
	public String insertByJdbc(@RequestParam("id") Long id, @RequestParam("name") String name) {
		StringBuffer val = new StringBuffer("\n演示使用 JdbcTemplate 实现数据插入 ");
		val.append("\n[使用 JdbcTemplate通过execute() 方法执行sql语句完成数据插入]");
		val.append("\n[执行sql：" + myTestDao.insert(id, name) + "]");
		System.out.println(val.toString());
		return val.toString();
	}
}
```

---
### <a id="a_transaction">十一、Transaction事务的使用</a> <a href="#a_jdbc">last</a> <a href="#a_aop">next</a>
@EnableTransactionManagement：[org.springframework.transaction.annotation.EnableTransactionManagement](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/transaction/annotation/EnableTransactionManagement.html)
```
启用S​​pring的注释驱动的事务管理功能，类似于Spring的<tx:*>XML命名空间中的支持。要在@Configuration 上使用 如下
@Configuration
@EnableTransactionManagement
public class AppConfig {

 @Bean
 public FooRepository fooRepository() {
     // configure and return a class having @Transactional methods
     return new JdbcFooRepository(dataSource());
 }

 @Bean
 public DataSource dataSource() {
     // configure and return the necessary JDBC DataSource
 }

 @Bean
 public PlatformTransactionManager txManager() {
     return new DataSourceTransactionManager(dataSource());
 }
}

作为参考，可以将上面的示例与以下Spring XML配置进行比较
<beans>
 <tx:annotation-driven/>
 <bean id="fooRepository" class="com.foo.JdbcFooRepository">
     <constructor-arg ref="dataSource"/>
 </bean>
 <bean id="dataSource" class="com.vendor.VendorDataSource"/>
 <bean id="transactionManager" class="org.sfwk...DataSourceTransactionManager">
     <constructor-arg ref="dataSource"/>
 </bean>
</beans>

在上述两种情况下的，@EnableTransactionManagement并且<tx:annotation-driven/>是负责注册其编织拦截到当调用堆栈功率注解驱动事务管理必要的弹簧部件，例如的TransactionInterceptor和的Proxy-或基于AspectJ的建议JdbcFooRepository的@Transactional 方法是调用。
两个示例之间的细微差别在于PlatformTransactionManagerbean 的命名：在这种@Bean情况下，名称是 “txManager”（根据方法的名称）; 在XML情况下，名称是 “transactionManager”。该<tx:annotation-driven/>是硬连线到查找名为“transactionManager的”默认bean，但 @EnableTransactionManagement更加灵活; 它将回退到PlatformTransactionManager容器中任何bean 的类型查找。因此，名称可以是“txManager”，“transactionManager”或“tm”：它无关紧要。

对于那些希望在@EnableTransactionManagement要使用的确切事务管理器bean 之间建立更直接关系的人 ，TransactionManagementConfigurer可以实现回调接口 - 注意下面的implements子句和@Override注释方法
@Configuration
@EnableTransactionManagement
public class AppConfig implements TransactionManagementConfigurer {
 @Bean
 public FooRepository fooRepository() {
     // configure and return a class having @Transactional methods
     return new JdbcFooRepository(dataSource());
 }
 @Bean
 public DataSource dataSource() {
     // configure and return the necessary JDBC DataSource
 }
 @Bean
 public PlatformTransactionManager txManager() {
     return new DataSourceTransactionManager(dataSource());
 }
 @Override
 public PlatformTransactionManager annotationDrivenTransactionManager() {
     return txManager();
 }
}
这种方法可能是理想的，因为它更明确，或者为了区分PlatformTransactionManager同一容器中存在的两个bean 可能是必要的。顾名思义， annotationDrivenTransactionManager()将是用于处理@Transactional方法的那个 。有关TransactionManagementConfigurer更多详细信息，请参阅Javadoc。
该mode()属性控制如何应用建议：如果模式是 AdviceMode.PROXY（默认值），则其他属性控制代理的行为。请注意，代理模式仅允许通过代理拦截呼叫; 同一类中的本地调用不能以这种方式截获。

请注意，如果mode（）设置为AdviceMode.ASPECTJ，则将proxyTargetClass()忽略该属性的值。
另请注意，在这种情况下，spring-aspects模块JAR必须存在于类路径中，编译时编织或加载时编织将方面应用于受影响的类。
这种情况没有涉及代理人; 本地回话也会被截获。
```

@Transactional：[org.springframework.transaction.annotation.Transactional](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html)
```
描述方法或类的事务属性。
这个注释类型通常可以直接与Spring的RuleBasedTransactionAttribute 类相媲美 ，实际上它AnnotationTransactionAttributeSource会直接将数据转换为后一类，因此Spring的事务支持代码不必知道注释。
如果没有规则相关的例外，它会像对待 DefaultTransactionAttribute （回滚上RuntimeException和Error，但不会对检查的异常）。

Isolation	isolation
	事务隔离级别。

java.lang.Class<? extends java.lang.Throwable>[]	noRollbackFor
	定义零（0）或更多异常Classes，它必须是子类Throwable，指示哪些异常类型 不得导致事务回滚。

java.lang.String[]	noRollbackForClassName
	定义零（0）或更多异常名称（对于必须是其子类的Throwable异常），指示哪些异常类型不得 导致事务回滚。

Propagation	propagation
	事务传播类型。

boolean	readOnly
	true如果事务实际上是只读的，则可以设置为布尔标志，允许在运行时进行相应的优化。

java.lang.Class<? extends java.lang.Throwable>[]	rollbackFor
	定义零（0）或更多异常classes，它必须是子类Throwable，指示哪些异常类型必须导致事务回滚。

java.lang.String[]	rollbackForClassName
	定义零（0）或更多异常名称（对于必须是其子类的Throwable异常），指示哪些异常类型必须导致事务回滚。

int	timeout
	此事务的超时。

java.lang.String	transactionManager
	指定事务的限定符值。

java.lang.String	value
	别名为transactionManager()。
```

Isolation：[org.springframework.transaction.annotation.Isolation](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/transaction/annotation/Isolation.html)
```
枚举，表示与Transactional注释一起使用的事务隔离级别，对应于 TransactionDefinition接口。

DEFAULT
使用基础数据存储的默认隔离级别。

READ_COMMITTED
一个常量，表示防止脏读; 可以发生不可重复的读取和幻像读取。

READ_UNCOMMITTED
一个常量，表示可以发生脏读，不可重复读和幻像读。

REPEATABLE_READ
一个常量，表示防止脏读和不可重复读; 可以发生幻像读取。

SERIALIZABLE
一个常量，表示禁止脏读，不可重复读和幻像读。
```

Propagation[org.springframework.transaction.annotation.Propagation](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html)
```
枚举，表示与Transactional注释一起使用的事务传播行为，对应于 TransactionDefinition接口。

MANDATORY
支持当前事务，如果不存在则抛出异常。

NESTED
如果当前事务存在，则在嵌套事务中执行，其行为类似于PROPAGATION_REQUIRED else。

NEVER
如果事务存在，则以非事务方式执行，抛出异常。

NOT_SUPPORTED
以非事务方式执行，暂停当前事务（如果存在）。

REQUIRED
支持当前事务，如果不存在则创建新事务。

REQUIRES_NEW
创建一个新事务，并暂停当前事务（如果存在）。

SUPPORTS
支持当前事务，如果不存在则以非事务方式执行。
```

MyTestController.java：
```Java
package com.mutistic.jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/myTestController/")
@EnableTransactionManagement // 开启事务
public class MyTestController {
	@Autowired
	private MyTestDao myTestDao;
	// 演示使用 @EnableTransactionManagement 开启事务
	@PostMapping(value = "insertByException", produces = "text/html;charset=UTF-8")
	@Transactional(rollbackFor = Exception.class, noRollbackFor = NullPointerException.class)
	public String insertByException(@RequestParam("id") Long id, @RequestParam("name") String name) {
		StringBuffer val = new StringBuffer("\n演示使用 @EnableTransactionManagement 开启事务 ");
		val.append("\n[Controller类或者@SpringBootApplication类 实现  @EnableTransactionManagement 开启事务]");
		val.append("\n[方法上：实现@Transactional添加事务]");
		val.append("\n[执行sql：" + myTestDao.insert(id, name) + "]");
		val.append("\n[PS1：@EnableTransactionManagement默认对运行时异常即：RuntimeException进行回滚，其他异常不触发回滚]");
		val.append("\n[PS2：方法可以无需抛出 throws Exception]");
		val.append("\n[PS3：@Transactional rollbackFor可以指定那些异常回滚，默认是运行时异常，还有其他参数设置是否回滚的异常信息]");
		val.append("\n[PS4：@Transactional noRollbackFor可以指定那些异常不回滚]");
		val.append("\n[PS5：@Transactional 必须声明在初始调用的public方法上，参考事务的传播机制]");
		val.append("\n[PS6：@Transactional 要保证数据库是支持事务]");
		System.out.println(val.toString());
		
		if("Exception".equals(name)) {
			throw new RuntimeException(val.toString());
		}
		
		return val.toString();
	}
}
```

---
### <a id="a_aop">十二、AOP的使用</a> <a href="#a_transaction">last</a> <a href="#a_starter">next</a>
pom.xml添加AOP依赖：
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-aop</artifactId>
</dependency>

<!-- 实际上是使用aspectjweaver依赖-->
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.8.13</version>
  <scope>compile</scope>
</dependency>
```

AOP的使用步骤：
```
[pom.xml：添加AOP依赖，默认开启AOP功能：
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-aop</artifactId>
</dependency>
实际上是使用aspectjweaver依赖：
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.8.13</version>
  <scope>compile</scope>
</dependency>]
[Class：实现@Aspect注解，同时实现@Component注解将其注册到spring容器中]
[方法：实现 定义通知方式 的注解：AOP五种通知方式：@Before、@After、@AfterReturning、@AfterThrowing、@Around]
[定义切入点：通过 通知方式的注解value字段execution指定]
[execution表达式：execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)]
[参数信息：选填参数 org.aspectj.lang.JoinPoint：可以获取]
[@Before：前置通知：选填参数org.aspectj.lang.JoinPoint]
[@After：后置通知：选填参数org.aspectj.lang.JoinPoint]
[@AfterReturning：返回通知：选填参数org.aspectj.lang.JoinPoint，通知方式注解通过 returning 获取返回参数]
[@AfterThrowing：异常通知：选填参数org.aspectj.lang.JoinPoint，通知方式注解通过 throwing 获取指定异常]
[@Around：环绕通知：参数org.aspectj.lang.ProceedingJoinPoint]
[AOP：参考：class org.springframework.boot.autoconfigure.aop.AopAutoConfiguration，默认启用AOP功能]
[属性配置：spring.aop.auto配置是否启用AOP功能，默认true启用，  false为不启用]
[属性配置：spring.aop.proxy-target-class配置接口使用的代理模式，默认false=JDK动态代理模式：com.sun.proxy设置为true=CGLIB代理模式：EnhancerBySpringCGLIB，如果不是接口Spring默认使用CGLIB代理模式]
[代理接口：class com.mutistic.aop.TestProxyImpl]
```

@Aspect：[org.aspectj.lang.annotation.Aspect](http://www.eclipse.org/aspectj/doc/released/aspectj5rt-api/org/aspectj/lang/annotation/Aspect.html)<br/>
声明切面

JoinPoint：org.aspectj.lang.JoinPoint<br/>
@Before：org.aspectj.lang.annotation.Before
```
[@Before：前置通知]
[前置通知：在目标 方法开始之前进行执行的通知]
[前置通知：使用 @Before 注解, 并将切入点表达式的值作为注解值]
[value属性值：切入点表达式，匹配与之对应的目标。利用【*】可以进行那匹配不同的目标，参数只需要传入类型即可]
[方法体JoinPoint 参数：用来连接当前连接点的连接细节，一般包括方法名和参数值。【org.aspectj.lang.JoinPoint】包]
[JoinPoint：]
[通过JoinPoint.getSignature()获取签名信息：com.mutistic.aop.TestControllerByAop.showBuAOP]
[通过JoinPoint.getArgs()获取参数：[]]
```

@After：org.aspectj.lang.annotation.After
```
[@After：后置通知]
[后置通知： 在目标方法执行之后，无论是否发生异常，都进行执行的通知]
[后置通知：使用@After注解, 并将切入点表达式的值作为注解值]
[在后置通知中，不能访问目标方法的执行结果。原因可能在执行过程中发生异常而无法得到结果]
[方法体JoinPoint 参数：用来连接当前连接点的连接细节，一般包括方法名和参数值。【org.aspectj.lang.JoinPoint】包]
[com.mutistic.aop.TestControllerByAop.showBuAOP]
```
@AfterReturning：org.aspectj.lang.annotation.AfterReturning
```
[@AfterReturning：返回通知]
[返回通知： 在目标方法正常结束时，才执行的通知]
[返回通知：使用@AfterReturning注解，并将切入点表达式的值作为注解值]
[返回通知：可以访问到方法的返回值]
[returning属性值：声明该方法可以存在返回值，该属性的值即为用来传入返回值的参数名称]
[方法体Object参数 ：需要使用与returning同名参数名称，用来接收方法的返回值]com.mutistic.aop.TestControllerByAop.showBuAOP]
```
@AfterThrowing：org.aspectj.lang.annotation.AfterThrowing
```
[@AfterThrowing：异常通知]
[异常通知 ：在目标方法出现异常时才会进行执行的代码]
[异常通知 ：使用@AfterThrowing注解，并将切入点表达式的值作为注解值]
[throwing属性：访问连接点抛出的异常]
[returning属性值：声明该方法可以存在返回值，该属性的值即为用来传入返回值的参数名称]
[方法体Exception参数：用来接收连接点抛出的异常。Exception类匹配所有的异常，可以指定为特定的异常]
```
ProceedingJoinPoint：org.aspectj.lang.ProceedingJoinPoint<br/>
@Around：org.aspectj.lang.annotation.Around
```
[@Around：环绕通知]
[环绕通知：是所有通知类型中功能最为强大的， 能够全面地控制连接点。甚至可以控制是否执行连接点。类似于动态代理]
[环绕通知：连接点的参数类型必须是 ProceedingJoinPoint ，它是 JoinPoint 的子接口,，允许控制何时执行， 是否执行连接点]
[环绕通知：中需要明确调用 ProceedingJoinPoint 的 proceed()]
[方法来执行被代理的方法，如果忘记这样做就会导致通知被执行了，但目标方法没有被执行。]
[环绕通知：的方法需要有返回值，返回目标方法执行之后的结果， 即调用 joinPoint.proceed() 的返回值, 否则会出现空指针异常]
[环绕通知：虽然功能最为强大的，但是一般我们都不使用这个]
[@Around：前置通知com.mutistic.aop.TestControllerByAop.showBuAOP[[Ljava.lang.Object;@4fd02ab0]]]
[@Around：返回通知com.mutistic.aop.TestControllerByAop.showBuAOP return：
```

TestAspect.java：
```Java
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
@Aspect // 定义切面
@Component // 纳入到Spring容器中
public class TestAspect {
	// 定义通知方式-@Before：前置通知
	//  execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)
	@Before(value = "execution(* com.mutistic.aop.TestControllerByAop.*(..))") // execution 定义切入点：如xx包的xx方法
	public void before(JoinPoint joinPoint) {
		StringBuffer val = new StringBuffer("\n\n\n------------------");
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
	// 定义通知方式-@After：后置通知
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
	// 定义通知方式-@AfterReturning：返回通知
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
	// 定义通知方式-@AfterThrowing：异常通知
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
	// 定义通知方式-@Around：环绕通知
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
```

---
### <a id="a_starter">十三、创建starter项目并引用</a> <a href="#a_aop">last</a> <a href="a_logger">next</a>
13.1、创建starter项目并引用的步骤-以创建redis的starter项目为例：
```
[1、starter项目pom.xml：建议创建maven项目，此项目演示redis配置，故需要引入jedis依赖：
<dependency>
	<groupId>redis.clients</groupId>
        <artifactId>jedis</artifactId>
</dependency>]
[2、创建properties类（RedisProperties）：可实现@ConfigurationProperties注解，指定prefix，eg:prefix="redis"]，定义属性及get/set方法
[3、创建configuration类（RedisAutoConfiguration）：1、实现@Configuration或@SpringBootConfiguration注解，
2、实现@EnableConfigurationProperties注解
3、@EnableConfigurationProperties注解需要指定@ConfigurationProperties的properties类4、通过 @ConditionalOnClass 配置 Jedis.class 优化configuration配置
@SpringBootConfiguration
@EnableConfigurationProperties
@ConditionalOnClass(Jedis.class)
public class RedisConfiguration { } ]
[4、configuration类创建Jedis bean（jedis）：1、入参RedisProperties
2、创建Jedis实例传入 host和port信息
3、通过@ConditionalOnMissingBean 配置 Jedis 优化bean的创建
	@Bean
	@ConditionalOnMissingBean
	public Jedis jedis(RedisProperties properties) {
		return new Jedis(properties.getHost(), properties.getPort());
	}]
[5、starter项目启动configuration类：
5.1、通过@Import实现开启configuration类(@EnableRedis)：@Import导入RedisAutoConfiguration类，然后@SpringBootApplication类实现@EnableRedis注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisConfiguration.class)
public @interface EnableRedis { }5.2、可以通过resoureces/META-INF/spring.factories配置：
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.mutistic.starter.RedisConfiguration]
[6、引用方pom.xml：引用创建redis-starter的项目：eg：
<dependency>
	<groupId>com.mutistic</groupId>
	<artifactId>com.mutistic.boot.web.redis</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>]
[7、引用方properties：可以配置redis.host，redis.port的信息，是可以传递给redis-starter的RedisProperties]
[8、引用方就可以获取Jedis完成redis功能]
```

RedisProperties.java：
```
package com.mutistic.starter;
import org.springframework.boot.context.properties.ConfigurationProperties;
// Redis Properties 配置文件类
// 实现 @ConfigurationProperties 可以指定prefix
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

	private String host;
	private Integer port;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
}
```
RedisConfiguration.java：
```Java
package com.mutistic.starter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
// 创建 Jedis bend 配置类
@SpringBootConfiguration
@EnableConfigurationProperties
@ConditionalOnClass(Jedis.class)
public class RedisConfiguration {
	@Bean
	@ConditionalOnMissingBean
	public Jedis jedis(RedisProperties properties) {
		return new Jedis(properties.getHost(), properties.getPort());
	}
}
```
RedisConfiguration.java：
```Java
package com.mutistic.starter;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
// 开启 RedisConfiguration 配置类
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisConfiguration.class)
public @interface EnableRedis { }
```

---
### <a id="a_logger">十四、logger的使用</a> <a href="#a_starter">last</a> <a href="a_actuator">next</a>
Logger：[org.slf4j.Logger](https://www.slf4j.org/api/org/slf4j/Logger.html)</br>
此类是原始[org.apache.log4j.Logger](https://www.slf4j.org/api/org/slf4j/Logger.html)类的最小实现 （如log4j 1.2中所示），委托对Logger实例的所有调用。</br>

LogbackLoggingSystem：[org.springframework.boot.logging.logback.LogbackLoggingSystem](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/logback/LogbackLoggingSystem.html)</br>

14.1、slf4j Logger 的使用步骤：
```
[1、pom.xml：spring-boot-starter-web的依赖默认 添加 slf4j的依赖：
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-logging</artifactId>
  <version>2.0.3.RELEASE</version>
  <scope>compile</scope>
</dependency>]
[1.1、如果使用slf4j具体的依赖配置：需要排除 spring-boot-starter-logging 默认日志依赖
<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-log4j12</artifactId>
</dependency>]

[2、Logger：private static final Logger log = LoggerFactory.getLogger(TestControllerByLog.class);]

[3、日志级别level：参考org.slf4j.event.Level：OFF（关闭）< DEBUG（调试）< INFO（记录）< WARN（警告）< ERROR（错误） TRACE（跟踪）、FATAL（严重），一般使用：DEBUG、INFO、WARN、ERROR四种]
[3.1、默认日志级别：info]
[3.2、可以通过属性 logging.level.root 调整日志级别： 配置日志级别：（logging.level.root root表示所有的）（logging.level.* *表示具体包名或类名：logging.level.com.mutistic.utils.CommonUtil）
logging.level.root=DEBUG]
[3.3通过启动参数args调整的日志级别只对spring boot内部的类生效：--debug 或 --debug=true]

[4、可用通过配置文件配置：参考org.springframework.boot.logging.logback.LogbackLoggingSystem]
[4.1、logging.level：设置日志级别]
[4.2、logging.file：设置日志文件文件名及输入路径]
[4.3、logging.path：设置日志文件路径：默认日志文件名为：spring.log]
[4.4、日志输出格式参考：https://blog.csdn.net/qq496013218/article/details/69220907]
[4.4.1、logging.pattern.console：设置控制台日志输出格式：eg：logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss.sss} [%p][%t] [%c:%L] - %m%n]
[4.4.1、logging.pattern.file：设置文件日志输出格式]
[4.4.3、日志格式参数说明：
	%m 输出代码中指定的消息
	%p	输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL
	%r	输出自应用启动到输出该log信息耗费的毫秒数
	%c	输出所属的类目，通常就是所在类的全名
	%t	输出产生该日志事件的线程名
	%n	输出一个回车换行符，Windows平台为“\r\n”，Unix平台为“\n”
	%d	输出日志时间点的日期或时间，默认格式为ISO-8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss.SSS}，
	%l	输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。举例：Testlog4.main(TestLog4.java:10)]

[5、spring boot 默认是使用logback.xml或logback-spring.xml文件设置日志信息，默认位置 src/resources，spring 推荐使用：logback-spring.xml]
[5.1、logback.xml配置参考：https://logback.qos.ch/manual/configuration.html]
[5.2、logback.xml或logback-spring.xml简单配置实例：
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<!-- 日志输出到文件的配置：使用ch.qos.logback.core.ConsoleAppender 适配器-->
	<appender name="fileLog" class="ch.qos.logback.core.FileAppender">
		<!-- 配置输出文件位置及文件名:默认在项目目录下 -->
		<file>logs/catalina.log</file>
		<!-- 配置输出格式 -->
		<encoder>
			<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%p][%t] [%c:%L] - %m%n
			</pattern>
		</encoder>
	</appender>
	<!-- 日志输出到控制台的配置 -->
	<appender name="consoleLog"
		class="ch.qos.logback.core.ConsoleAppender">
		<encoder>
			<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%p][%t] [%c:%L] - %m%n</pattern>
		</encoder>
	</appender>

	<root level="INFO">
		<appender-ref ref="fileLog" />
		<appender-ref ref="consoleLog" />
	</root>
</configuration>]
[5.3、日志文件默认大小为10M，不可修改]

[6、选用其他日志组件的配pom.xml配置：需要先排除掉默认logger依赖：以log4j2日志为例:
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
		</exclusion>
	</exclusions>
</dependency>
<!-- 添加 log4j2 日志依赖：需要排除 spring-boot-starter-logging 默认日志依赖-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>]
[6.1、log4j2默认的日志配置文件名是log4j2.xml或log4j2-spring.xml：配置信息参考logback.xml]
```

pom.xml添加slf4j-log4j12依赖：
```xml
<!-- 添加web项目依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<!-- 引入其他log 需要排除spring-boot-starter-logging -->
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
		</exclusion>
	</exclusions>
</dependency>
<!-- 添加 log4j2 日志依赖：需要排除 spring-boot-starter-logging 默认日志依赖 -->
<!-- <dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-log4j2</artifactId>
</dependency> -->
<!-- 添加slf4j日志依赖：需要排除 spring-boot-starter-logging 默认日志依赖 -->
<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-log4j12</artifactId>
</dependency>
```

src/main/resources/logback.xml日志配置参考：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<!-- 日志输出到文件的配置：使用ch.qos.logback.core.ConsoleAppender 适配器
		参考配置位置：org.springframework.boot.logging.logback.file-appender.xml-->
	<appender name="fileLog" class="ch.qos.logback.core.FileAppender">
		<!-- 配置输出文件位置及文件名：默认在项目目录下 -->
		<file>logs/catalina.out</file>
		<!-- 配置回滚信息 -->
		<!-- <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
			<fileNamePattern>logs/catalina.%d{yyyy-MM-dd}.%i.out</fileNamePattern>
			<maxFileSize>10MB</maxFileSize>
			<maxHistory>30</maxHistory>
		</rollingPolicy> -->
		<!-- 配置输出格式 -->
		<encoder>
			<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%p][%t] [%c:%L] - %m%n
			</pattern>
		</encoder>
	</appender>

	<!-- 日志输出到控制台的配置：使用ch.qos.logback.core.ConsoleAppender 适配器
		参考配置位置：org.springframework.boot.logging.logback.console-appender.xml -->
	<appender name="consoleLog" class="ch.qos.logback.core.ConsoleAppender">
		<encoder>
			<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%p][%t] [%c:%L] - %m%n</pattern>
		</encoder>
	</appender>

	<root level="INFO">
		<appender-ref ref="fileLog" />
		<appender-ref ref="consoleLog" />
	</root>
</configuration>
```

---
### <a id="a_actuator">十五、监控和度量的使用</a> <a href="#a_logger">last</a> <a href="a_tests">next</a>
[监控和度量的使用](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html)：
```
[1、pom.xml添加actuator依赖：
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-actuator</artifactId>
</dependency>]

[2、浏览器访问日志打印的actuator开放的端口信息：http://127.0.0.1:8080/actuator 下]

[3、spring boot 2.x版本默认开放：health和info端口]
[3.1、通过management.endpoint.xxxx.enable属性配置端口的开放和关闭eg：
management.endpoint.shutdown.enabled=true]
[3.2、spring boot 2.x版本：属性配置调整到management.endpoint 下]
[3.3、spring boot 2.x版本：通过management.endpoints.web.exposure.include=* 设置开放端口，*表示所有，默认为health和info端口（实际上2.0.3以上版本并没有该属性，不生效）]
[3.4、spring boot 2.x版本：通过management.endpoints.web.exposure.exclude=shutdown 设置关闭端口（实际上2.0.3以上版本并没有该属性，不生效）]

[4、端口说明：参考https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html]
[4.1、auditevents：公开当前应用程序的审核事件信息。]
[4.2、beans：显示应用程序中所有Spring bean的完整列表。]
[4.3、conditions：显示在配置和自动配置类上评估的条件以及它们匹配或不匹配的原因。]
[4.4、configprops：显示所有的整理列表@ConfigurationProperties。]
[4.5、env：露出Spring的属性ConfigurableEnvironment。]
[4.6、flyway：显示已应用的任何Flyway数据库迁移。]
[4.7、health：显示应用健康信息。]
[4.8、httptrace：显示HTTP跟踪信息（默认情况下，最后100个HTTP请求 - 响应交换）。]
[4.9、info：显示任意应用信息。]
[4.10、loggers：显示和修改应用程序中记录器的配置。]
[4.11、liquibase：显示已应用的任何Liquibase数据库迁移。]
[4.12、metrics：显示当前应用程序的“指标”信息。]
[4.13、mappings：显示所有@RequestMapping路径的整理列表。]
[4.14、scheduledtasks：显示应用程序中的计划任务。]
[4.15、sessions：允许从Spring Session支持的会话存储中检索和删除用户会话。使用Spring Session对响应式Web应用程序的支持时不可用。]
[4.16、shutdown：允许应用程序正常关闭。]
[4.17、threaddump：执行线程转储。]
[PS1、经测试发现spring boot 2.x无法访问actuator信息，具体原因还未知]
```

pom.xml添加spring-boot-actuator依赖：
```xml
<!-- 添加监控和度量依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-actuator</artifactId>
</dependency>
```

---
### <a id="a_tests">十六、单元测试的使用</a> <a href="#a_actuator">last</a> <a href="a_microservice">next</a>
pom.xml添加spring-boot-starter-test依赖：
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```
@RunWith：org.junit.runner.RunWith

@Test：org.junit.Test

SpringRunner：[org.springframework.test.context.junit4.SpringRunner](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/context/junit4/SpringRunner.html)

@SpringBootTest：[org.springframework.boot.test.context.SpringBootTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html)

16.1、使用 @SpringBootTest 测试JdbcTemplate：<br/>
JdbcTemplateTests.java：
```Java
package com.mutistic.test.jdbc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.mutistic.jdbc.MyTestDao;
// 使用  @SpringBootTest 测试JdbcTemplate
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTests {
	@Autowired
	private MyTestDao myTestDao;
	@Test
	public void testInsert() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("使用  @SpringBootTest 测试JdbcTemplate：");
		val.append("\n[1、pom.xml添加test依赖：\n"
				+ "<dependency>\n" + 
				"			<groupId>org.springframework.boot</groupId>\n" + 
				"			<artifactId>spring-boot-starter-test</artifactId>\n" + 
				"			<scope>test</scope>\n" + 
				"		</dependency>]");
		
		val.append("\n[2、Test类：实现 @RunWith(SpringRunner.class) 注解，并且实现@SpringBootTest注解]");
		val.append("\n[3、方法：实现@Test注解]");
		val.append("\n[PS1：test包下的在正式环境是会被忽略掉的]");
		
		val.append("========以下是JdbcTemplate信息=========");
		val.append("\n[使用 JdbcTemplate通过execute() 方法执行sql语句完成数据插入]");
		val.append("\n[执行sql：" + myTestDao.insert(2l, "test") + "]");
		System.out.println(val.toString());
	}
}
```

16.2、使用 @TestConfiguration 配置测试环境生效的配置信息：<br/>
EnvironmentTestUtils：[org.springframework.boot.test.util.EnvironmentTestUtils](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/util/EnvironmentTestUtils.html)

```Java
package com.mutistic.test.env;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
// 使用 EnvironmentTestUtils 配置测试环境生效的属性信息
@RunWith(SpringRunner.class)
// @SpringBootTest
@SpringBootTest(properties = { "app.version=1.0.0" })
public class EnvironmentTests {
	@Autowired
	private ConfigurableEnvironment env;
	@Before
	public void initProperties() {
		EnvironmentTestUtils.addEnvironment(env, "app.name=spring boot web test");
	}

	@Test
	public void testShowValue() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");	
		val.append("使用 EnvironmentTestUtils 配置测试环境生效的属性信息：");
		val.append("\n[1、@SpringBootTest类：注入org.springframework.core.env.Environment]");
		val.append("\n[2、Test默认有限取test下的配置文件，取不到后会取主目录下的配置文件]");
		val.append("\n[3、可以通过@SpringBootTest的properties属性 配置参数]");
		val.append("\n[4、可以通过EnvironmentTestUtils添加配置参数：\n"
				+ "4.1、声明一个方法，实现org.junit.Before注解\n"
				+ "4.2、通过EnvironmentTestUtils.addEnvironment() 方法添加属性：\n"
				+ "EnvironmentTestUtils.addEnvironment(env, \"app.name=spring boot web test\")"
				+ "4.3、env类型为：org.springframework.core.env.ConfigurableEnvironment]");

		val.append("========以下是ConfigurableEnvironment获取properties信息=========");
		val.append("\n[获取配置参数server.port：" + env.getProperty("server.port") + "]");
		val.append("\n[获取@SpringBootTest配置的属性app.version：" + env.getProperty("app.version") + "]");
		val.append("\n[获取EnvironmentTestUtils.addEnvironment()添加的属性app.name：" + env.getProperty("app.name") + "]");
		System.out.println(val.toString());

	}
}
```

16.3、使用 @TestConfiguration 配置测试环境生效的配置信息：<br/>
@TestConfiguration：[org.springframework.boot.test.context.TestConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/TestConfiguration.html)

ConfigurationTests.java：
```Java
package com.mutistic.test.config;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
@TestConfiguration
public class ConfigurationTests {
	@Bean
	public Runnable createrRunnable() { return () -> {}; }
}
```

ApplicationContextTests.java：
```Java
package com.mutistic.test.config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.mutistic.jdbc.MyTestDao;
// 使用 @TestConfiguration 配置测试环境生效的配置信息
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigurationTests.class)
public class ApplicationContextTests {
	@Autowired
	private ApplicationContext context;
	@Test
	public void testShowTestBean() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("使用 @TestConfiguration 配置测试环境生效的配置信息：");
		val.append("\n[1、Configuration类：实现 @TestConfiguration注解，注意不能使用@Configuration或@SpringBootConfiguration注解配置类]");
		val.append("\n[2、@SpringBootTest类：通过classes属性配置Configuration类，否者@TestConfiguration不会生效：\n"
				+ "@SpringBootTest(classes = ConfigurationTests.class)]");

		val.append("========以下是ApplicationContext获取bean信息=========");
		val.append("\n[输出正常测试bean：" + context.getBeansOfType(MyTestDao.class) + "]");
		val.append("\n[输出测试环境bean：" + context.getBeansOfType(Runnable.class) + "]");
		System.out.println(val.toString());
	}
}
```

16.4、使用@MockBean创建测试bean：<br/>
@MockBean：[org.springframework.boot.test.mock.mockito.MockBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/mock/mockito/MockBean.html)

BDDMockito：org.mockito.BDDMockito

使用Mock需要引入mockito-core依赖，spring-boot-starter-test已经自动引入
```xml
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>2.15.0</version>
  <scope>compile</scope>
</dependency>
```

MockTests.java：
```Java
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
// 使用@MockBean创建测试bean
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTests {
	// 使用@MockBean创建测试bean
	@MockBean
	private MockUserMapper mockUserMapper;
	//  在执行测试之前需要的前置通知 
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
```
MockUserMapper.java：
```
package com.mutistic.test.mok;
public interface MockUserMapper {
	public Integer createrUser(String userName);
}
```

16.5、使用 TestRestTemplate 测试Controller：<br/>
TestRestTemplate：[org.springframework.boot.test.web.client.TestRestTemplate](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/web/client/TestRestTemplate.html)
ControllerTestsByTempleate.java：
```Java
package com.mutistic.test.controller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
// 使用 TestRestTemplate 测试Controller
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTestsByTempleate {
	@Autowired
	private TestRestTemplate testRestTemplate;
	@Test
	public void testShowTest() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("使用 TestRestTemplate 测试Controller：");
		val.append("\n[1、@SpringBootTest注解类：使用webEnvironment属性配置为WebEnvironment.RANDOM_PORT：随机接口]");
		val.append("\n[2、注入TestRestTemplate(org.springframework.boot.test.web.client.TestRestTemplate) bean]");
		val.append("\n[3、TestRestTemplate.getForObject()：方法模拟请求Controller接口]");
		val.append("\n[4、getForObject()为Controller接口返回值]");
		val.append("\n[PS1、TestRestTemplate 需要在web环境下，才能注入进来]");
		System.out.println(val.toString());

		String context = testRestTemplate.getForObject("/testsController/showTest", String.class);
		Assert.assertEquals("TestsController.showTest", context);
	}
	@Test
	public void testShowByParams() {
		System.out.println("Get请求可以在请求路径上直接传参： url?key=value");
		Long id = 100l;
		String context = testRestTemplate.getForObject("/testsController/showByParams?id=" + id, String.class);
		Assert.assertEquals("TestsController.showByParams" + id, context);
	}
}

```

16.6、使用 MockMvc 测试Controller：<br/>
MockMvc：[org.springframework.test.web.servlet.MockMvc](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/web/servlet/MockMvc.html)
ControllerTestsByMockMvc.java：
```Java
package com.mutistic.test.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.mutistic.tests.TestsController;
// 使用 MockMvc 测试Controller
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TestsController.class)
public class ControllerTestsByMockMvc {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testShowTest() throws Exception {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("使用 TestRestTemplate 测试Controller：");
		val.append("\n[1、类：实现@WebMvcTest注解，通过 controllers指定需要测试的Controller类]");
		val.append("\n[2、注入MockMvc(org.springframework.test.web.servlet.MockMvc) bean]");
		val.append("\n[3、MockMvc.perform()：调用接口：入参：MockMvcRequestBuilders]");
		val.append("\n[4、MockMvcRequestBuilders.get()：设置调用URL和请求方式，还有post()等请求方式]");
		val.append("\n[5、MockMvc.perform().andExpect()：设置预测返回结果]");
		val.append("\n[6、MockMvcResultMatchers.status().isOk()：预测接口访问成功：isOk() = HttpStatus.OK = 200]");
		val.append("\n[7、MockMvcResultMatchers.content().string(value)：设置预测返回结果类型为String且值为value]");
		val.append("\n[PS1：	@WebMvcTest不需要运行在Web环境下，但是需要自行执定Controller]");
		val.append("\n[PS2：	@WebMvcTest和@SpringBootTest不能同时使用]");
		val.append("\n[PS3：	@WebMvcTest不会加载整个spring bean，@SpringBootTest可以加载整个spring bean]");
		val.append("\n[PS4：	@SpringBootTest + @AutoConfigureMockMvc 可以注入 MockMvc bean]");
		System.out.println(val.toString());

		// 预测接口调用成功 isOk() = HttpStatus.OK = 200
		mockMvc.perform(MockMvcRequestBuilders.get("/testsController/showTest"))
				.andExpect(MockMvcResultMatchers.status().isOk()); // 预测结果是能够访问成功

		mockMvc.perform(MockMvcRequestBuilders.get("/testsController/showTest"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("TestsController.showTest")); // 预测接口返回
	}

	@Test
	public void testShowByParams() throws Exception {
		System.out.println("MockMvcRequestBuilders.get().param()：添加参数");
		Long id = 400l;
		// 预测接口调用成功 isOk() = HttpStatus.OK = 200
		mockMvc.perform(MockMvcRequestBuilders.get("/testsController/showByParams").param("id", id + ""))
				.andExpect(MockMvcResultMatchers.status().isOk()); // 预测结果是能够访问成功

		// 预测接口调用成功 isOk() = HttpStatus.OK = 200
		mockMvc.perform(MockMvcRequestBuilders.get("/testsController/showByParams").param("id", id + ""))
				.andExpect(MockMvcResultMatchers.content().string("TestsController.showByParams" + id)); // 预测结果是能够访问成功
	}
}
```

---
### <a id="a_microservice">十七、微服务的使用</a> <a href="#a_tests">last</a> <a href="a_zokkeeper">next</a>
演示创建com.mutistic.boot.server：<br/>
pom.xml：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.mutistic</groupId>
	<artifactId>com.mutistic.boot.server</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>com.mutistic.boot.server</name>
	<description>server</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.RELEASE</version>
		<relativePath />
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
		</dependency>
		<!-- fastjson依赖 -->
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.2.47</version>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.3.2</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>
```

application.properties：
```properties
## 设置端口号
#server.port=8888
## 设置请求编码格式
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true
spring.http.encoding.force=true
spring.http.encoding.force-request=true
spring.http.encoding.force-response=true
spring.messages.encoding=UTF-8

## 配置jdbc驱动：使用mysql驱动
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
## 配置 jdbc url
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/study?useSSL=false
## 配置 jdbc 用户名
spring.datasource.username=root
## 配置 jdbc 密码
spring.datasource.password=root

#设置jackson date 格式化字符串
spring.jackson.date-format=yyy-MM-dd HH:mm:ss
```

Application.java：
```java
package com.mutistic;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.mutistic.entity.BookEntity;
import com.mutistic.mapper.BookMapper;
import com.mutistic.utils.CommonUtil;
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		testBookMapper(ctx);
	}

	private static void testBookMapper(ConfigurableApplicationContext ctx) {
		CommonUtil.printOne("获取BookMapper bean："+ ctx.getBean(BookMapper.class));
		
		BookMapper mapper = ctx.getBean(BookMapper.class);
		
		CommonUtil.printOne("测试BookMapper.insert()方法:");
		BookEntity insert = new BookEntity();
		insert.setBookId((new Date()).getTime());
		insert.setTitle("test title");
		insert.setAuthor("test author");
		insert.setRemark("test remark");
		insert.setCreaterTime(new Date());
		CommonUtil.printThree("新增结果：", mapper.insert(insert));
		
		CommonUtil.printOne("测试BookMapper.queryAllList()方法:");
		CommonUtil.printThree("查询结果：", mapper.queryAllList());
		
		CommonUtil.printOne("测试BookMapper.queryById()方法:");
		BookEntity query = mapper.queryById(insert.getBookId());
		CommonUtil.printThree("查询结果：", query == null ? null : query.toString());
		
		CommonUtil.printOne("测试BookMapper.update()方法:");
		query.setCreaterTime(new Date());
		CommonUtil.printThree("更新结果：", mapper.update(query));
		
		CommonUtil.printOne("测试BookMapper.delete()方法:");
		CommonUtil.printThree("删除结果：", mapper.delete(insert.getBookId()));
	}
}
```

BookEntity.java：
```Java
package com.mutistic.entity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
// book 实体 
public class BookEntity {
	private Long bookId;
	private String title;
	private String author;
	private String remark;
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GTM+8") // 字符串(格式为yyyy-MM-dd HH:mm:ss)转换为日期java.util.Date
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createrTime;
	
	public Long getBookId() { return bookId; }
	public void setBookId(Long bookId) { this.bookId = bookId; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author;}
	public String getRemark() {	return remark;}
	public void setRemark(String remark) {this.remark = remark;	}
	public Date getCreaterTime() {return createrTime;}
	public void setCreaterTime(Date createrTime) {this.createrTime = createrTime;	}
	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", title=" + title + ", author=" + author + ", remark=" + remark
				+ ", createrTime=" + createrTime + "]";
	}
}
```

BookMapper.java：
```Java
package com.mutistic.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.mutistic.entity.BookEntity;
@Mapper
public interface BookMapper {
	@Insert("INSERT INTO book (bookId, title, author, remark, createrTime) VALUES (#{bookId}, #{title}, #{author}, #{remark}, #{createrTime}) ")
	Integer insert(BookEntity entity);
	
	@Select("SELECT bookId, title, author, remark, createrTime FROM book")
	List<BookEntity> queryAllList();
	
	@Select("SELECT bookId, title, author, remark, createrTime FROM book WHERE bookId = #{id}")
	BookEntity queryById(Long id);
	
	@Update("UPDATE book SET bookId = #{bookId}, title = #{title}, author = #{author}, remark = #{remark}, createrTime = #{createrTime}  WHERE bookId = #{bookId}")
	Integer update(BookEntity entity);
	
	@Delete("DELETE FROM book WHERE bookId = #{id}")
	Integer delete(Long id);
}
```

BookController.java：
```Java
package com.mutistic.controller;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mutistic.base.ResponseUtil;
import com.mutistic.entity.BookEntity;
import com.mutistic.mapper.BookMapper;

@RestController
@RequestMapping("/bookController/")
public class BookController {
	@Autowired
	private BookMapper bookMapper;
	// 查询所有book信息 
	@GetMapping("queryAllList")
	public Object queryAllList(HttpServletRequest request) { return ResponseUtil.setSuccess(bookMapper.queryAllList()); }
	// 根据ID查询book信息
	@GetMapping("queryById")
	public Object queryById(@RequestParam("id") Long id) { return ResponseUtil.setSuccess(bookMapper.queryById(id)); }
	// 新增book信息 
	@PostMapping("insert")
	public Object insert(@RequestBody BookEntity book) {
		book.setBookId((new Date()).getTime());
		if(null == book.getCreaterTime()) 
			book.setCreaterTime(new Date());
		return ResponseUtil.setSuccess(bookMapper.insert(book));
	}
	// 修改book信息 
	@PostMapping("update")
	public Object update(@RequestBody BookEntity book) {
		if(null == book.getCreaterTime()) book.setCreaterTime(new Date());
		return ResponseUtil.setSuccess(bookMapper.update(book));
	}
	//根据ID删除book信息 
	@DeleteMapping("delete")
	public Object delete(@RequestParam("id") Long id) { return ResponseUtil.setSuccess(bookMapper.delete(id)); }
}
```

ResponseUtil.java：
```Java
package com.mutistic.base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import com.alibaba.fastjson.JSON;
// Response 工具类
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
```

---
### <a id="a_zokkeeper">十八、服务的注册和发现(简单使用zokkeeper)</a> <a href="#a_tests">last</a> <a href="a_devtools">next</a>
18.1、Zookeeper的安装和使用：
```
ZK官网：【http://zookeeper.apache.org/】
ZK下载镜像：【http://mirrors.hust.edu.cn/apache/zookeeper/zookeeper-3.4.13/】
ZK的使用参考：【https://www.cnblogs.com/shanyou/p/3221990.html】
ZK客戶端命令使用：【https://www.cnblogs.com/senlinyang/p/7833669.html】
Zookeeper配置：【配置文件在 conf 目录下，这个目录下有 zoo_sample.cfg 和 log4j.properties，
你需要做的就是将 zoo_sample.cfg 改名为 zoo.cfg，因为 Zookeeper 在启动时会找这个文件作为默认配置文件Zookeeper 的配置文件在 conf 目录下，
这个目录下有 zoo_sample.cfg 和 log4j.properties，你需要做的就是将 zoo_sample.cfg 改名为 zoo.cfg，
因为 Zookeeper 在启动时会找这个文件作为默认配置文件】
tickTime：【这个时间是作为 Zookeeper 服务器之间或客户端与服务器之间维持心跳的时间间隔，也就是每个 tickTime 时间就会发送一个心跳。】
dataDir：【顾名思义就是 Zookeeper 保存数据的目录，默认情况下，Zookeeper 将写数据的日志文件也保存在这个目录里。】
dataLogDir：【顾名思义就是 Zookeeper 保存日志文件的目录】
clientPort：【这个端口就是客户端连接 Zookeeper 服务器的端口，Zookeeper 会监听这个端口，接受客户端的访问请求。】
启动zookeeper:【/bin/zkServer.cmd】
zookeeper客户端:【/bin/zkCli.cmd】
zk默认地址：【127.0.0.1:2181】
zk 与  curator 版本关系：【curator的版本：2.12.0，对应Zookeeper的版本为：3.4.x】
zk 与  curator 版本关系：【curator的版本：3.x或4.x，对应Zookeeper的版本为：3.5.x】
```

18.2、Zookeeper注册服务：<br/>
服务注册方pom.xml添加curator-x-discovery-server使用zk的依赖：
```xml
<!-- 服务的注册和发现(使用zokkeeper)：服务方使用组件:curator-x-discovery-server -->
<dependency>
	<groupId>org.apache.curator</groupId>
	<artifactId>curator-x-discovery-server</artifactId>
	<version>2.12.0</version>
</dependency>
```

ZKServiceRegister.java：
```Java
package com.mutistic.zokkeeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
// ZK注册服务
@Component
public class ZKServiceRegister implements ApplicationRunner {
	private static final Logger log = LoggerFactory.getLogger(ZKServiceRegister.class);

	@Value("${zookeeper.address}")
	private String zkAddress;
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// 注册zk客户端
		CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, new RetryOneTime(400000));
		client.start(); // 启动zk
		client.blockUntilConnected(); // 链接

		// 注册 127.0.0.1:8888 服务节点：服务节点名称为：address
		ServiceInstance<Object> instances = ServiceInstance.builder().name("address").address("127.0.0.1").port(8888)
				.build();
		// 注册 book 服务 路径为host
		ServiceDiscovery<Object> discovery = ServiceDiscoveryBuilder.builder(Object.class).client(client)
				.basePath("/host").build();
		discovery.registerService(instances);
		discovery.start();
		log.info("zookepper 服务注册成功：127.0.0.1:8888");

		// 注册 192.168.16.113:8888 服务节点：服务节点名称为：address
		ServiceInstance<Object> instances2 = ServiceInstance.builder().name("address").address("192.168.16.113")
				.port(8888).build();
		// 注册 book 服务 路径为host
		ServiceDiscovery<Object> discovery2 = ServiceDiscoveryBuilder.builder(Object.class).client(client)
				.basePath("/host").build();
		discovery2.registerService(instances2);
		discovery2.start();
		log.info("zookepper 服务注册成功：192.168.16.113:9999");
		
		showZk();
	}

	private void showZk() {
		StringBuffer val = new StringBuffer("\nZookeeper注册服务：");
		val.append("\n[可以在配置文件中配置zk的连接地址信息：zookeeper.address=127.0.0.1:2181]");
		val.append("\n[服务注册方pom.xml添加curator使用zk的依赖：\n"
				+ "<!-- 服务的注册和发现(使用zokkeeper)：服务方使用组件:curator-x-discovery-server -->\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.apache.curator</groupId>\r\n" + 
				"			<artifactId>curator-x-discovery-server</artifactId>\r\n" + 
				"			<version>2.12.0</version>\r\n" + 
				"		</dependency>]");
		val.append("\n[通过 CuratorFrameworkFactory.newClient() 创建Zk链接]");
		val.append("\n[通过 ServiceInstance 创建节点]");
		val.append("\n[通过 ServiceDiscoveryBuilder 创建服务]");
		System.out.println(val.toString());
	}
}
```

18.3、Zookeeper服务调用：<br/>
服务调用方pom.xml添加curator-x-discovery使用zk的依赖：
```xml
<!-- 服务的注册和发现(使用zokkeeper)：调用方使用组件:curator-x-discovery -->
<dependency>
	<groupId>org.apache.curator</groupId>
	<artifactId>curator-x-discovery</artifactId>
	<version>2.12.0</version>
</dependency>
```

BookZKMain.java：
```Java
package com.mutistic.zokkeeper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSON;
import com.mutistic.utils.CommonUtil;
// zk服务的调用
public class BookZKMain {
	public static void main(String[] args) throws Exception {
		// 链接zk客户端
		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new RetryOneTime(1000));
		client.start(); // 启动zk
		client.blockUntilConnected(); // 链接

		ServiceDiscovery<Object> discovery = ServiceDiscoveryBuilder.builder(Object.class).client(client)
				.basePath("/host").build();
		Collection<ServiceInstance<Object>> list = discovery.queryForInstances("address");

		List<String> serviceList = new ArrayList<String>();
		list.forEach((instances) -> {
			CommonUtil.printThree("获取zk服务注册信息：", JSON.toJSONString(instances));
			serviceList.add(instances.getAddress() + ":" + instances.getPort());
		});
		
		LoadBalance lb = new LoadBalance(serviceList);
		for (int i = 0; i < 10; i++) {
			// 调用接口
			RestTemplate rt = new RestTemplate();
			String url = "http://" + lb.choose() + "/bookController/queryById?id=1533384516863";
			CommonUtil.printTwo("获取RestTemplate请求的结果：" + url, rt.getForObject(url, String.class));
		}
	}
}
```
轮询算法：LoadBalance.java：
```Java
package com.mutistic.zokkeeper;
import java.util.List;
// 轮询算法 
public class LoadBalance {

	private int index = 0;
	private List<String> services;

	public LoadBalance(List<String> services) {
		super();
		this.services = services;
	}

	public String choose() {
		String service = services.get(index);
		index++;
		if(index >= services.size()) {
			index = 0;
		}
		return service;
	}
}
```

---
### <a id="a_devtools">十九、热部署</a> <a href="#a_zokkeeper">last</a> <a href="a_maven">next</a>
19.1、使用spring-boot-devtools实现热部署：
pom.xml 添加spring-boot-devtools依赖：
```xml
<!-- 热部署方式一：使用spring-boot-devtools插件 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<optional>true</optional>
	<scope>true</scope>
</dependency>

<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
			<configuration>
				<!-- 没有该配置，spring-boot-devtools 热部署不生效 -->
				<fork>true</fork>
				<addResources>true</addResources>
			</configuration>
		</plugin>
	</plugins>
</build>
```

19.2、使用springloaded实现热部署：
pom.xml build 添加springloaded依赖：
```xml
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
			<!-- 热部署方式二：使用springloaded插件 -->
			<dependencies>
				<dependency>
					<groupId>org.springframework</groupId>
					<artifactId>springloaded</artifactId>
					<version>1.2.6.RELEASE</version>
				</dependency>
			</dependencies>
			<executions>
				<execution>
					<goals>
						<goal>repackage</goal>
					</goals>
					<configuration>
						<classifier>exec</classifier>
					</configuration>
				</execution>
			</executions>
		</plugin>
	</plugins>
</build>
```

---
### <a id="a_maven">二十、打包发布</a> <a href="#a_devtools">last</a> <a href="a_down">next</a>
使用[appassembler-maven-plugin](http://www.mojohaus.org/appassembler/appassembler-maven-plugin/index.html)插件打包项目:
```
环境配置maven bin：path【C:\Work\Software\Maven\apache-maven-3.0.5\bin;】
执行命令：打包maven依赖【mvn clean appassembler:assemble】
执行命令：打包本项目【mvn clean package appassembler:assemble】
```

pom.xml build配置打包信息:
```xml
<build>
	<plugins>
		<plugin>
			<!-- appassembler-maven-plugin插件官网:http://www.mojohaus.org/appassembler/appassembler-maven-plugin/index.html
			mvn clean package appassembler:assemble
			mvn clean appassembler:assemble -->
			<groupId>org.codehaus.mojo</groupId>
			<artifactId>appassembler-maven-plugin</artifactId>
			<version>2.0.0</version>
			<configuration>
				<!-- 生成unix、windows平台执行脚本 -->
				<platforms>
					<platform>windows</platform>
					<platform>unix</platform>
				</platforms>
				<!-- 根目录 -->
				<assembleDirectory>${project.build.directory}/server</assembleDirectory>
				<!-- 打包的jar，以及maven依赖的jar放到这个目录 lib -->
				<repositoryName>lib</repositoryName>
				<!-- lib目录中jar存放的规则,默认是 ${groupId}/${artifactId}的目录格式,flat表示直接把jar放到 
					repositoryName声明的目录 -->
				<repositoryLayout>flat</repositoryLayout>
				<!-- 可执行脚本的目录 -->
				<binFolder>bin</binFolder>
				<!-- 配置文件的目标目录 -->
				<configurationDirectory>conf</configurationDirectory>
				<!-- 拷贝配置文件到configurationDirectory配置的目录种 -->
				<copyConfigurationDirectory>true</copyConfigurationDirectory>
				<!-- 执行从项目的目录拷贝配置文件(默认 src.main.config) -->
				<configurationSourceDirectory>src/main/resources</configurationSourceDirectory>
				<!-- 编码格式 -->
				<encoding>UTF-8</encoding>
				<!-- logs目录 -->
				<logsDirectory>logs</logsDirectory>
				<!-- 临时文件目录 -->
				<tempDirectory>tep</tempDirectory>
				<!-- 配置启动类 -->
				<programs>
					<program>
						<id>server </id>
						<mainClass>com.mutistic.Application</mainClass>
						<!-- jvm参数 -->
						<jvmSettings>
							<extraArguments>
								<!-- 指定以server的方式运行 -->
								<extraArgument>-server</extraArgument>
								<!-- 指定最大堆内存 -->
								<extraArgument>-Xmx1G</extraArgument>
								<!-- 指定最小堆内存 -->
								<extraArgument>-Xms1G</extraArgument>
							</extraArguments>
						</jvmSettings>
					</program>
				</programs>
			</configuration>
		</plugin>
	</plugins>
</build>
```

---
<a id="a_down"></a>  
<a href="#a_top">Top</a> 
<a href="#a_catalogue">Catalogue</a>
