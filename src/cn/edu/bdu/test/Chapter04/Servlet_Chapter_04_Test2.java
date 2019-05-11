package cn.edu.bdu.test.Chapter04;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//ServletConfig练习 关于Servlet相关的配置信息
//P121-P122

@WebServlet(name = "Servlet_Chapter_04_Test2",
        urlPatterns = "/Servlet_Chapter_04_Test2"
)
public class Servlet_Chapter_04_Test2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test Config <br/>");

        //声明ServletConfig对象，用来获取Servlet配置信息
        ServletConfig servletConfig = this.getServletConfig();

        //通过ServletConfig对象获取该Servlet的编码
        printWriter.println("该Servlet的编码为" + servletConfig.getInitParameter("encoding") + "\n");
        //返回结果(web.xml没有配置编码)为：该Servlet的编码为null
        //返回结果(web.xml配置编码)为：该Servlet的编码为UTF-8


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
