package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：利用Referer防盗链
//对应页码：P150-P151
@WebServlet(name = "/Servlet_Chapter_05_Test8", urlPatterns = {"/Servlet_Chapter_05_Test8"})
public class Servlet_Chapter_05_Test8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //获取请求头的referer
        String referer = request.getHeader("referer");
        //获取本地服务器的名称
        String sitePart = request.getServerName();

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //判断referer是否为空 referer是否来自本服务器
        if(referer != null && referer.startsWith("http://" +sitePart)){
            //如果都符合的话，开始下载
            printWriter.println("正在下载");
        }else{
            //如果不符合的话，则可能有盗链风险，返回到download.html页面
            //dispatcher为考虑学习过程暂时不用（后面会讲，前面直接一提啥也不说，太突兀）
            response.sendRedirect("/Servlet/test/Chapter05/Test8/download.html");
        }

        //输出结果略
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
