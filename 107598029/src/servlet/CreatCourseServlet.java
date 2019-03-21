package servlet;


import dao.Coursedao;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/creat")
public class CreatCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
            coursedao.creatcourse(course);
        } catch (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/list");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/creat.jsp").forward(request, response);
    }
}
