package servlet;

import dao.impl.CourseDaoImpl;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
        try {
            List<Course> courseList = courseDaoImpl.getCourseList();
            request.setAttribute("courseList", courseList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
        String[] deleteCourseId = request.getParameterValues("deleteId");
        if(deleteCourseId != null){
            for(String id: deleteCourseId) {
                try {
                    courseDaoImpl.deleteCourse(Integer.parseInt(id));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        response.sendRedirect("/Delete");
    }
}
