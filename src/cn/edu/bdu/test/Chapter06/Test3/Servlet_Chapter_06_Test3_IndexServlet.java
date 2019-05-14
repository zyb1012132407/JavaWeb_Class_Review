package cn.edu.bdu.test.Chapter06.Test3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//练习：
//对应页码：
@WebServlet(name = "Servlet_Chapter_06_Test3_IndexServlet", urlPatterns = {"/Servlet_Chapter_06_Test3_IndexServlet"})
public class Servlet_Chapter_06_Test3_IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //获取HttpSession对象
        HttpSession session = request.getSession();
        //从session中寻找"user"的values，并返回给user
        User user = (User)session.getAttribute("user");

        if(user == null){
            //如果啥也没有，返回空，提示没登陆
            response.getWriter().println("您还没有登陆，请<a href='/Servlet/test/Chapter06/Test3/Login.html'>登录</a>");
        }else{
            //如果有东西，则提示登陆成功！
            response.getWriter().println("您已经登陆！欢迎您" + user.getUsername() + "！");
            response.getWriter().println("<a href='/Servlet/Servlet_Chapter_06_Test3_LogoutServlet'>退出</a>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
