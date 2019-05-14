package cn.edu.bdu.test.Chapter06;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//练习：利用Cookies显示用户上次访问时间
//对应页码：
@WebServlet(name = "Servlet_Chapter_06_Test1", urlPatterns = {"/Servlet_Chapter_06_Test1"})
public class Servlet_Chapter_06_Test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //声明一个用来显示来访最后时间的字符串
        String lastAccessTime = null;

        //声明一个Cookies对象，用来判断和记录来访最后时间
        Cookie[] cookies = request.getCookies();

        //首先先判断cookies里是否有lastAccess这个cookie
        for(int i=0;cookies != null && i <cookies.length;i++){
            //如果cookies数组里面有"lastAccess"这个cookie，那么就赋值给上面的lastAccessTime变量，并跳出循环
            if("lastAccess".equals(cookies[i].getName())){
                //如果找到了"lastAccess"这个cookie，那么就赋值给lastAccessTime
                lastAccessTime = cookies[i].getValue();
                break;
            }
        }
        //如果没有找到"lastAccess"这个cookie,那么lastAccessTime变量仍为null
        if(lastAccessTime == null){
            printWriter.println("您是首次访问本站！");
            //如果找到的话，那么lastAccessTime肯定不为null,肯定有点东西，所以直接输出
        }else{
            printWriter.println("访问时间为:" + lastAccessTime);
        }

        //定义一个格式化的时间字符串，格式自定义
        String currenttime = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss").format(new Date());

        //将格式化后的字符串存入cookie中
        Cookie cookie = new Cookie("lastAccess",currenttime);

        //将cookie存入Cookie中，然后response返回
        response.addCookie(cookie);

        //如果想让浏览器不关闭删除可以设定时间。
//        cookie.setMaxAge(60*60);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
