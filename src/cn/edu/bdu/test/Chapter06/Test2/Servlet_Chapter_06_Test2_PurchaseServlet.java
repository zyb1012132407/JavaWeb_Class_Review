package cn.edu.bdu.test.Chapter06.Test2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//练习：被ListBookServlet指向过来的链接
//对应页码：P181-P182
@WebServlet(name = "Servlet_Chapter_06_Test2_PurchaseServlet", urlPatterns = {"/Servlet_Chapter_06_Test2_PurchaseServlet"})
public class Servlet_Chapter_06_Test2_PurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //获取ListBookServlet请求的id （"?id=x" 中的x）
        String id = request.getParameter("id");

        //如果id为空 那么直接回到图书清单
        if(id == null){
            String url = "/Servlet/Servlet_Chapter_06_Test2_ListBookServlet";
            response.sendRedirect(url);
            return;
        }

        //通过传入id获取对应的book对象
        Book book = BookDB.getBook(id);
        //获取一个session对象
        HttpSession session =request.getSession();

        //首先获取session里面的"cart"是否存在List<Book>类型的数据，如果没有的话，就新声明一个
        List<Book> cart = (List)session.getAttribute("cart");

        //如果没有的话，就新声明一个
        if(cart == null){
            cart = new ArrayList<Book>();
            //新声明后的cart变量添加到session里面
            session.setAttribute("cart",cart);
        }
        //将数组添加到cart里面,这时session内的cart也会被修改
        cart.add(book);

//        测试cart之后session是否实时添加
//        System.out.println("测试信息有");
//        List<Book> cart1 = (List)session.getAttribute("cart");
//        for(Book booktmp:cart1){
//            System.out.println(booktmp.getName()+"<br>");
//        }

//        将session号存储到Cookie中，但是书上这么写，并没有用，徒劳
//        Cookie cookie = new Cookie("JESSIONID",session.getId());
//        cookie.setMaxAge(60*60);
//        cookie.setPath("/Servlet");
//        response.addCookie(cookie);

        String url = "/Servlet/Servlet_Chapter_06_Test2_CartServlet";
        response.sendRedirect(url);

        //输出结果为：
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
