package cn.edu.bdu.test.Chapter06.Test2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

//练习：图书清单
//对应页码： P180-P181
@WebServlet(name = "Servlet_Chapter_06_Test2_ListBookServlet", urlPatterns = {"/Servlet_Chapter_06_Test2_ListBookServlet"})
public class Servlet_Chapter_06_Test2_ListBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //接收图书书籍，并且返回给Collection类型的 books
        Collection<Book> books = BookDB.getAll();
        //简单输出
        printWriter.println("本站提供的图书有：<br>");

        //循环输出
        for (Book book:books){
            //设定一个链接指向
            String url = "/Servlet/Servlet_Chapter_06_Test2_PurchaseServlet?id="+book.getId();
            //每一次输出 图书名 + 图书购买指向链接
            printWriter.println(book.getName() + "<a href='" + url + "'>点击购买</a><br>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
