package cn.edu.bdu.test.Chapter05.Test11;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：Dispatcher+Include练习
//对应页码：P166-P167
@WebServlet(name = "Servlet_Chapter_05_Test11_Part2", urlPatterns = {"/Servlet_Chapter_05_Test11_Part2"})
public class Servlet_Chapter_05_Test11_Part2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        printWriter.println("中国" + "<br/>");
        printWriter.println("URL" +request.getRequestURI() +"<br/>");
        printWriter.println("QueryString" + request.getQueryString() +  "<br/>");
        printWriter.println("parameter" + request.getParameter("Company") + "<br/>");
        //输出结果为：
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
