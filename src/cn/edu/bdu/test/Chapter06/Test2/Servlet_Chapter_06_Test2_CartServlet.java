package cn.edu.bdu.test.Chapter06.Test2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//练习：购物车清单
//对应页码：P181-P182
@WebServlet(name = "Servlet_Chapter_06_Test2_CartServlet", urlPatterns = {"/Servlet_Chapter_06_Test2_CartServlet"})
public class Servlet_Chapter_06_Test2_CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //声明一个用来接收Book的List
        List<Book> cart = null;
        //
        boolean pureFlag = true;

        //当前Session啥也没有就为null 和request.getSesssion()一样
        HttpSession session = request.getSession(false);
        //如果session没有的话，那么就为空
        if(session == null){
            //如果啥也没有，那么就得提示用户啥也没买。
            pureFlag = false;
        }else{
            //如果有的话，将session里面的List赋值给之前声明的cart
            cart = (List)session.getAttribute("cart");
            //如果cart为null的话，那么还是啥也没有，就得提示用户啥也没买。
            if(cart == null){
                pureFlag = false;
            }
        }
        if(!pureFlag){
            //如果啥也没有，就提示用户
            printWriter.println("对不起！您还没有购买任何商品！<br>");
        }else{
            //如果有的话，就直接输出
            printWriter.println("您购买的图书有:<br>");
            double price = 0;
            //利用高级for将每一本书的信息输出
            for(Book book:cart){
                printWriter.println(book.getName()+"<br>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
