package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//练习：获取请求参数
//对应页码：
@WebServlet(name = "Servlet_Chapter_05_Test9", urlPatterns = {"/Servlet_Chapter_05_Test9"})
public class Servlet_Chapter_05_Test9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //设置接收参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbys = request.getParameterValues("hobby");

        //声明一个PrintWriter对象用于输出
        PrintWriter printWriter = response.getWriter();

        printWriter.println("用户名：" + username + "\n" + "密码：" + password + "\n");
        printWriter.println("爱好：");
        for (int i = 0;i <hobbys.length;i++){
            printWriter.println(hobbys[i] + " ");
        }

        //输出结果为：用户名：123123 密码：sfaadAS 爱好： sing dance rap basketball
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
