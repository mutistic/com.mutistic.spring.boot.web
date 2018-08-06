<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ERROR.JSP</h1>
<h2>
1、演示返回.JSP文件
[Controller：使用@Controller。使用@RequestMapping("/testControllerByJSP/")指定默认路径]
[方法：@PostMapping(value = "showJSP")指定方法访问路径，和访问方式POST]
[方法：使用@ResponseBody可以直接返回出去]
[请求方式：RequestMethod.POST]
[参数信息： @RequestParam()指定访问参数
[参数值： userName = root, passWord = root123]
[返回类型：JSP文件name]
[PS1：返回JSP文件时，类不能使用@RestController，方法不能使用 @ResponseBody注解]
[PS2：pom.xml需要引入jsp相关的组建:org.apache.tomcat.embed-tomcat-embed-jasper]
</h2>
</body>
</html>