package cn.edu.bdu.test.Chapter06.Test4;

import cn.edu.bdu.test.Chapter06.Test3.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：
//对应页码：
@WebServlet(name = "Servlet_Chapter_06_Test4_LoginServlet", urlPatterns = {"/Servlet_Chapter_06_Test4_LoginServlet"})
public class Servlet_Chapter_06_Test4_LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //声明接受username和password的字符串
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("check_code");
        String savedCode = (String)request.getSession().getAttribute("check-mode");

        System.out.println("checkCode:" + checkCode +"\n" + "savedCode:" + savedCode);

        //对username和password进行简单的判断
        //如果都符合的话，进行成功登陆操作
        if("root".equals(username) && "123456".equals(password) && checkCode.equals(savedCode)){
            //声明一个User对象
            User user = new User(username,password);
            //将user对象添加到session中
            request.getSession().setAttribute("user",user);
            //添加之后跳转到主界面，提示登陆成功
            response.sendRedirect("/Servlet/Servlet_Chapter_06_Test4_IndexServlet");
        }else{
            //如果不都符合的话，那么提示用户重新输入
            printWriter.println("信息错误，请重新修改");
        }

        //输出结果为：
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
