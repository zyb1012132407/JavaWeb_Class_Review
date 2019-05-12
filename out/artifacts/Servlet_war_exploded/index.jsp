<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>选择主页</title>
  </head>
  <body>
    <form action="/Servlet/IndexServlet" method="POST">
      选择类型:&nbsp;
      Servlet:<input type="radio" name="type" value="Servlet"/>
      Html:<input type="radio" name="type" value="Html"/><br/>
      章节：<input type="text" name="Chapter"><br/>
      练习：<input type="text" name="Test"><br/>
      Part：<input type="text" name="Part"><br/>
      <input type="submit" value="提交">
    </form>
  </body>
</html>
