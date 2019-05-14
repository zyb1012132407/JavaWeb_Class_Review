package cn.edu.bdu.index;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet", urlPatterns = {"/IndexServlet"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
//        response.setContentType("text/html;charset=utf-8");

        String Type = request.getParameter("type");
        String Chapter = request.getParameter("Chapter");
        String Test = request.getParameter("Test");
        String Part = request.getParameter("Part");

//        PrintWriter printWriter = response.getWriter();
//        response.sendRedirect("/Servlet/Servlet_Chapter_0"+Chapter+"_Test"+Test);
        if(Type.equals("Servlet")){
            if(Chapter.equals("4") || Chapter.equals("04")){
                if(Test.equals("4") || Test.equals("04")){
                    response.sendRedirect("/Servlet/Servlet_Chapter_0"+Chapter+"_Test"+Test + "_Part" + Part);
                }else{
                    response.sendRedirect("/Servlet/Servlet_Chapter_0"+Chapter+"_Test"+Test);
                }
            }
            else if (Chapter.equals("5")|| Chapter.equals("05")){
                if(Test.equals("11")){
                    response.sendRedirect("/Servlet/Servlet_Chapter_0"+Chapter+"_Test"+Test + "_Part" + Part);
                }else{
                    response.sendRedirect("/Servlet/Servlet_Chapter_0"+Chapter+"_Test"+Test);
                }
            }
        }else if(Type.equals("Html")){
            if(Chapter.equals("4") || Chapter.equals("04")){
                response.sendRedirect("/Servlet/test/Chapter04/Test1/Servlet_Chapter_04_Test1_Form.html");
            }else if (Chapter.equals( "5") || Chapter.equals( "05")){
                if(Test.equals( "6") || Test.equals( "06")){
                    response.sendRedirect("/Servlet/test/Chapter05/Test6/login.html");
                }else if (Test.equals( "7") || Test.equals( "07")){
                    response.sendRedirect("/Servlet/test/Chapter05/Test7/login.html");
                }else if(Test.equals( "8") || Test.equals( "08")){
                    response.sendRedirect("/Servlet/test/Chapter05/Test8/download.html");
                }else if (Test.equals( "9") || Test.equals( "09")){
                    response.sendRedirect("/Servlet/test/Chapter05/Test9/login.html");
                }
            }
        }
//        printWriter.println("Type:" + Type + "\n" + "Chapter:" + Chapter + "\n" + "Test:" + Test);
//        System.out.println("Type:" + Type + "\n" + "Chapter:" + Chapter + "\n" + "Test:" + Test);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
