# <a id="a_top">[Spring Boot Web](https://spring.io/projects/spring-boot)</a>

附：
[Apache Tomcat 9 Document](http://tomcat.apache.org/tomcat-9.0-doc/index.html)
[Apache Tomcat 9 API](http://tomcat.apache.org/tomcat-9.0-doc/servletapi/overview-summary.html)

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
18. <a href="#a_zokkeeper">服务的注册和发现(使用zokkeeper)</a>
19. <a href="#a_devtools">、热部署</a>
20. <a href="#a_maven">打包发布</a>
96. <a href="#a_pit">spring boot web 入坑总结</a>
97. <a href="#a_sql">sql</a>
98. <a href="#a_sql">ea</a>
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
	。
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

---
### <a id="a_transaction">十一、Transaction事务的使用</a> <a href="#a_jdbc">last</a> <a href="#a_aop">next</a>

---
### <a id="a_aop">十二、AOP的使用</a> <a href="#a_transaction">last</a> <a href="#a_starter">next</a>

---
### <a id="a_starter">十三、创建starter项目并引用</a> <a href="#a_aop">last</a> <a href="a_logger">next</a>

---
### <a id="a_logger">十四、logger的使用</a> <a href="#a_starter">last</a> <a href="a_actuator">next</a>

---
### <a id="a_actuator">十五、监控和度量的使用</a> <a href="#a_logger">last</a> <a href="a_tests">next</a>

---
### <a id="a_tests">十六、单元测试的使用</a> <a href="#a_actuator">last</a> <a href="a_microservice">next</a>

---
### <a id="a_microservice">十七、微服务的使用</a> <a href="#a_tests">last</a> <a href="a_zokkeeper">next</a>

---
### <a id="a_zokkeeper">十八、服务的注册和发现(使用zokkeeper)</a> <a href="#a_tests">last</a> <a href="a_devtools">next</a>

---
### <a id="a_devtools">十九、热部署</a> <a href="#a_zokkeeper">last</a> <a href="a_maven">next</a>

---
### <a id="a_maven">二十、打包发布</a> <a href="#a_devtools">last</a> <a href="a_down">next</a>


---
<a id="a_down"></a>  
<a href="#a_top">Top</a> 
<a href="#a_catalogue">Catalogue</a>