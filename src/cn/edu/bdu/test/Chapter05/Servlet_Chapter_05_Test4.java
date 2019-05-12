package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//练习：自动刷新
//对应页码：P141-142

@WebServlet(name = "Servlet_Chapter_05_Test4", urlPatterns = {"/Servlet_Chapter_05_Test4"})
public class Servlet_Chapter_05_Test4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //添加Header说明，3秒钟自动刷新本页面
        response.setHeader("Refresh","3");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //通过输出现在时间来确定是否自动刷新
        printWriter.println("现在服务器时间是" + new Date());

        //输出结果为：
        //现在服务器时间是Sun May 12 11:34:40 GMT+08:00 2019
        //3秒后
        //现在服务器时间是Sun May 12 11:34:43 GMT+08:00 2019
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
