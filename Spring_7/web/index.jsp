<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.hhu.beans.Person" %><%--
  Created by IntelliJ IDEA.
  User: WeiguoLiu
  Date: 2018/3/5
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>测试Spring</title>
  </head>
  <body>
      <%
        //1.从application域对象中获取IOC容器,这里是通过Spring提供工具类获取，实际获取很麻烦，默认的名字很长
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
        Person person = (Person) ctx.getBean("person");
        System.out.println("has come to jsp");
        person.hello();
      %>
  </body>
</html>
