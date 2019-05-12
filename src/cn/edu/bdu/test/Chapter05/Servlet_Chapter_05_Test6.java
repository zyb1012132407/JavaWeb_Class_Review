package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：体验用户登录（请求重定向）
//对应页码：P144-P145
@WebServlet(name = "Servlet_Chapter_05_Test6", urlPatterns = {"/Servlet_Chapter_05_Test6"})
public class Servlet_Chapter_05_Test6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //接受login.html传进来的参数username和password
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //进行简单的账号密码验证（用户名：root 密码：123456）
        if("root".equals(username) && "123456".equals(password)){
            //验证成功跳转到欢迎界面
            response.sendRedirect("/Servlet/test/Chapter05/Test6/welcome.html");
        }else{
            //验证失败返回主界面
            response.sendRedirect("/Servlet/test/Chapter05/Test6/login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
