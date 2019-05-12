package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：获取网络连接信息
//对应页码：P160-P161
@WebServlet(name = "Servlet_Chapter_05_Test10", urlPatterns = {"/Servlet_Chapter_05_Test10"})
public class Servlet_Chapter_05_Test10 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        printWriter.println(
                "<hr/>"+
                        //客户端请求相关
                "getRemoteAddr:" + request.getRemoteAddr() + "<br>"+
                "getRemoteHost:" + request.getRemoteHost() + "<br>"+
                "getRemotePort:" + request.getRemotePort() + "<br>"+
                        //Web服务器请求相关
                "getLocalAddr:" + request.getLocalAddr() + "<br>"+
                "getLocalName:" + request.getLocalName() + "<br>"+
                "getLocalPort:" + request.getLocalPort() + "<br>"+
                        //请求指向相关
                "getServerName:" + request.getServerName() + "<br>"+
                "getServerPort:" + request.getServerPort() + "<br>"+
                        //请求协议名
                "getScheme:" + request.getScheme() + "<br>"+
                        //获取客户端发出请求时完整URL
                "getRequestURI:" + request.getRequestURI() + "<br>  "
        );
        //输出结果略
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
