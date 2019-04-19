package servlet;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import model.Course;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by David on 2019 / 02 / 27.
 */
@WebServlet("/newCourses")
public class newCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/newCourses.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String course_name = request.getParameter("course_name");
        String course_detail = request.getParameter("course_detail");
        String course_suit_people = request.getParameter("course_suit_people");
        int course_price = Integer.parseInt(request.getParameter("course_price"));
        String course_notes = request.getParameter("course_notes");
        String course_remark = request.getParameter("course_remark");

        CourseDao courseDao = new CourseDaoImpl();
        try {
            int courseId = courseDao.getMaxCourseId();
            courseId+=1;
            Course course = new Course(
                    courseId,
                    course_name,
                    course_detail,
                    course_suit_people,
                    course_price,
                    course_notes,
                    course_remark);
            courseDao.insertCourseToDB(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("listAllCourses");
    }
}
