package servlet;


import dao.Coursedao;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/find")
public class FindCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String coursename = request.getParameter("cname");

        Coursedao coursedao = new Coursedao();
        List<Course> list = new ArrayList<>();
        try {
            list = coursedao.findcourse(coursename);
        } catch (Exception e){
            e.printStackTrace();
        }

        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
    }
}
