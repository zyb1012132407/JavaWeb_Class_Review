package cn.edu.bdu.test.Chapter04.Test04;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//练习：Servlet练习
//对应页码：P125
@WebServlet(name = "Servlet_Chapter_04_Test4_Part1", urlPatterns = {"/Servlet_Chapter_04_Test4_Part1"})
public class Servlet_Chapter_04_Test4_Part1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //获取本Servlet的ServletContext
        ServletContext servletContext = this.getServletContext();

        //添加参数
        servletContext.setAttribute("data","this servlet save data");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
