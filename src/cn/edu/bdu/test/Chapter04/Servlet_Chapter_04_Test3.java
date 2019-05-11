package cn.edu.bdu.test.Chapter04;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//ServletContext练习 关于web.xml初始化信息
//P122-P123

@WebServlet(name = "Servlet_Chapter_04_Test3",
        urlPatterns = "/Servlet_Chapter_04_Test3")

public class Servlet_Chapter_04_Test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test Context <br/>");

        //声明一个ServletContext对象，用来获取web.xml初始化的相关信息
        ServletContext servletContext = this.getServletContext();

        //将所有参数名传递给一个枚举类型变量，以供遍历
        Enumeration<String> enumeration = servletContext.getInitParameterNames();

        //输出所有的参数名与参数变量
        printWriter.println("输出初始化参数信息为:<br/>");
        while (enumeration.hasMoreElements()) {
            //将参数名赋值给中间变量，保持步长为1
            String name = enumeration.nextElement();
            //获取参数值，将参数名与参数值同时输出
            printWriter.println("参数名为:" + name + "参数值为:" + servletContext.getInitParameter(name) + "<br/>");
        }
        //返回结果(web.xml没有配置初始化参数)为：输出初始化参数信息为:
        //返回结果(web.xml配置初始化参数)为：
        //        输出初始化参数信息为:
        //        参数名为:address参数值为:bejing
        //        参数名为:companyName参数值为:itcase


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
