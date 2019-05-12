package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：禁止浏览器缓存（暂不能正常运行）
//对应页码：P142-P143
@WebServlet(name = "Servlet_Chapter_05_Test5", urlPatterns = {"/Servlet_Chapter_05_Test5"})
public class Servlet_Chapter_05_Test5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //禁止缓存设置
        //设置缓存马上过期 （Expires为0->马上过期  Expires为-1->永不过期）
        response.setDateHeader("Expires",0);
        //强制页面不缓存（Cache-Control适用于http1.1，而Pragma适用于http1.0和http1.1）
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        ServletContext servletContext = this.getServletContext();

        String test = (String)servletContext.getAttribute("data");
        printWriter.println(test);
        servletContext.setAttribute("data","test");

        printWriter.println();
        printWriter.println("本次的响应数为" + Math.random());
        printWriter.println("<br/>" +
                "<form action='NoServlet'  method='POST'> " +
                "<input type='text' name='input1'><br>" +
                "<textarea name='input2'></textarea><br>" +
                "<input type='submit' value='提交'/>" +
                "</form>");

        //输出结果为：这个结果翻车了。。。，并没有课本所讲的刷新随机数
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
