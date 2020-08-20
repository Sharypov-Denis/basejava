import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResumeServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //String name = request.getParameter("name");
       //response.getWriter().write(name == null ? "Hello Resumes!" : "Hello " + name + '!');


        request.setAttribute("name", "Devcolibri");
        request.setAttribute("name1", "Devcolibri1");
        request.setAttribute("name2", "Devcolibri2");
       //request.getRequestDispatcher("test.html").forward(request, response);
        request.getRequestDispatcher("mypage.jsp").forward(request, response);

    }
}