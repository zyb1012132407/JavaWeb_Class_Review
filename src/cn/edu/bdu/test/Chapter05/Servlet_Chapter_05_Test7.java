package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//练习：Request对象 获取请求行，请求头相关信息
//对应页码：P147-P150
@WebServlet(name = "Servlet_Chapter_05_Test7", urlPatterns = {"/Servlet_Chapter_05_Test7"})
public class Servlet_Chapter_05_Test7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/><hr/>");

        //获取请求行相关信息
        printWriter.println("获取请求行相关信息<br/>");
        printWriter.println(
                        "getMethod:" + request.getMethod() + "<br/>（获取请求消息的请求方式）<br/><br/>" +
                        "getRequestURI:" + request.getRequestURI()+ "<br/>（获取请求行中资源名称部分）<br/><br/>" +
                        "getQueryString:" + request.getQueryString()+ "<br/>（获取GET方式请求行中的参数部分）<br/><br/>"+
                        "getProtocol:" + request.getProtocol()+ "<br/>（获取请求行中的协议名称和版本）<br/><br/>"+
                        "getContextPath:" + request.getContextPath()+ "<br/>（获取请求URL中Web程序的路径）<br/><br/>"+
                        "getPathInfo:" + request.getPathInfo()+ "<br/>（获取请求URL中的额外路径信息）<br/><br/>"+
                        "getPathTranslated:" + request.getPathTranslated()+ "<br/>（获取请求URL中的额外路径信息对应资源的真实路径）<br/><br/>"+
                        "getServletPath:" + request.getServletPath()+ "<br/>（获取Servlet的名称或映射路径）<br/><br/>"+
                        "<hr/>"
                        );


        //获取请求头相关信息
        printWriter.println("获取请求头相关信息<br/>");
        Enumeration headNames = request.getHeaderNames();
        while (headNames.hasMoreElements()){
            String headName = (String)headNames.nextElement();
            printWriter.println(headName + ":" + request.getHeader(headName) + "<br/>");
        }
        printWriter.println("<hr/>");



        //输出结果略
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
