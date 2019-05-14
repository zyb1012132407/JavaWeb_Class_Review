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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <form action="/Servlet/IndexServlet" method="POST">
      <span class="text-primary">选择类型:&nbsp;</span>
      Servlet:<input type="radio" name="type" value="Servlet"/>
      Html:<input type="radio" name="type" value="Html"/><br/>
      章节：<input type="text" name="Chapter"><br/>
      练习：<input type="text" name="Test"><br/>
      Part：<input type="text" name="Part"><br/>
      <input type="submit" value="提交">
    </form>
  </body>
</html>
