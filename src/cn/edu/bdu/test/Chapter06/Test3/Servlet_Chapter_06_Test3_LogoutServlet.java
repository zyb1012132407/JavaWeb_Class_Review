package cn.edu.bdu.test.Chapter06.Test3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：
//对应页码：
@WebServlet(name = "Servlet_Chapter_06_Test3_LogoutServlet", urlPatterns = {"/Servlet_Chapter_06_Test3_LogoutServlet"})
public class Servlet_Chapter_06_Test3_LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        request.getSession().removeAttribute("user");
        response.sendRedirect("/Servlet/Servlet_Chapter_06_Test3_IndexServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
