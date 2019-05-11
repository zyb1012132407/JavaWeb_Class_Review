package cn.edu.bdu.test.Chapter04;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

//练习：读取资源文件（相对路径）
//对应页码：P128
@WebServlet(name = "Servlet_Chapter_04_Test5", urlPatterns = {"/Servlet_Chapter_04_Test5"})
public class Servlet_Chapter_04_Test5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

//        声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

//        声明一个servletContext对象用来读取资源文件
        ServletContext servletContext = request.getServletContext();

//        声明inputStream对象，并且以itcast.properties为源接受数据流
        InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/itcast.properties");

//        声明Properties对象，并加载该配置文件
        Properties properties = new Properties();
        properties.load(inputStream);

//      通过参数名取得配置文件参数值，并进行输出
        printWriter.println("CompanyName=" + properties.getProperty("CompanyName") + "<br>" +
                "Address=" + properties.getProperty("Address") + "<br>"
        );

//      输出结果为：
//         CompanyName=itcast
//         Address=Beijing
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
