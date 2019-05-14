package cn.edu.bdu.test.Chapter06.Test4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//练习：
//对应页码：
@WebServlet(name = "Servlet_Chapter_06_Test4_LogoutServlet", urlPatterns = {"/Servlet_Chapter_06_Test4_LogoutServlet"})
public class Servlet_Chapter_06_Test4_LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        request.getSession().removeAttribute("user");
        response.sendRedirect("/Servlet/Servlet_Chapter_06_Test4_IndexServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
