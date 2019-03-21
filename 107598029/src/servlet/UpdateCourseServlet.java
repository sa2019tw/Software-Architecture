package servlet;

import dao.Coursedao;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateCourseServlet extends HttpServlet {
    private int id = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        id = Integer.parseInt(request.getParameter("id"));

        Course course = new Course();
        Coursedao coursedao = new Coursedao();
        try{
            course = coursedao.getcourseinfo(id);
        } catch (Exception e){
            e.printStackTrace();
        }

        request.setAttribute("course", course);
        request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String coursename = request.getParameter("coursename");
        String level = request.getParameter("level");
        String price_tmp = request.getParameter("courseprice");
        int price = 0;
        if(price_tmp.length() > 0){
            price = Integer.parseInt(price_tmp);
        }
        String description = request.getParameter("coursedescription");
        String precautions = request.getParameter("precautions");
        String remarks = request.getParameter("remarks");

        Course course = new Course(
                0,
                coursename,
                level,
                price,
                description,
                precautions,
                remarks
        );

        Coursedao coursedao = new Coursedao();

        try{
            coursedao.updatecourse(course);
        } catch (Exception e){
            e.printStackTrace();
        }


        response.sendRedirect("/list");

    }
}
