package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：定点刷新至其他页面（为好理解就不说跳转了）
//对应页码：P140-141
@WebServlet(name = "Servlet_Chapter_05_Test3", urlPatterns = {"/Servlet_Chapter_05_Test3"})
public class Servlet_Chapter_05_Test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //添加Header说明，2秒钟自动刷新至百度首页
        response.setHeader("Refresh","2;URL=https://www.baidu.com");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();

        printWriter.println("2秒后跳转");
        //输出结果为：2秒后跳转   2s后跳转到百度首页

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
