package cn.edu.bdu.test.Chapter04.Test04;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_Chapter_04_Test4_Part2", urlPatterns = {"/Servlet_Chapter_04_Test4_Part2"})
public class Servlet_Chapter_04_Test4_Part2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //获取本Servlet的ServletContext
        ServletContext servletContext = this.getServletContext();

        //获取参数data对应的值，根据类型进行强转
        String data = (String)servletContext.getAttribute("data");

        //输出结果
        printWriter.println(data);
        //输出结果为：this servlet save data
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
