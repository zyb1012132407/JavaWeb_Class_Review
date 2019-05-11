package cn.edu.bdu.test.Chapter04;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

//练习：读取资源文件（绝对路径）
//对应页码：
@WebServlet(name = "Servlet_Chapter_04_Test6", urlPatterns = {"/Servlet_Chapter_04_Test6"})
public class Servlet_Chapter_04_Test6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //声明一个servletContext对象用来读取资源文件
        ServletContext servletContext = request.getServletContext();

        //先用servletContext对象获取到配置文件的绝对路径（通过相对路径），然后作为fileInputStream初始化的参数
        FileInputStream fileInputStream = new FileInputStream
                (servletContext.getRealPath("/WEB-INF/classes/itcast.properties"));

        //声明Properties对象，并加载该配置文件
        Properties properties = new Properties();
        properties.load(fileInputStream);

        //通过参数名取得配置文件参数值，并进行输出
        printWriter.println("CompanyName:" + properties.getProperty("CompanyName") + "<br/>" +
                            "Address:" + properties.getProperty("Address") + "<br/>"
                );

//        输出结果为：
//          CompanyName:itcast
//          Address:Beijing
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
