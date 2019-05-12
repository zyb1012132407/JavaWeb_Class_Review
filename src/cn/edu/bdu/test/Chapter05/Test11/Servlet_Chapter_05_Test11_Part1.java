package cn.edu.bdu.test.Chapter05.Test11;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：Dispatcher+Include练习
//对应页码：P166-P167
@WebServlet(name = "Servlet_Chapter_05_Test11_Part1", urlPatterns = {"/Servlet_Chapter_05_Test11_Part1"})
public class Servlet_Chapter_05_Test11_Part1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Servlet_Chapter_05_Test11_Part2");
        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");
        request.setAttribute("Company","传智播客");
        printWriter.println("before including <br/>");
        requestDispatcher.include(request,response);
        printWriter.println("after including <br/>");

        //输出结果为：
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
