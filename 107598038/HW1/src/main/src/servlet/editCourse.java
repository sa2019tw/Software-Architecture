package servlet;

import dao.CourseDao;
import dao.ExcelCourseDao;
import dao.MySQLCourseDao;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/editCourse")
public class editCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        try {
            Course course = null;
            CourseDao excelCourseDao= new ExcelCourseDao();
            course =  excelCourseDao.selectCourse(ID);
            request.setAttribute("editCourse",course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/editCourse.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Course course = new Course();
        course.setName(request.getParameter("CourseName"));
        course.setNumberOfPeople(Integer.parseInt(request.getParameter("number")));
        course.setPrice(Integer.parseInt(request.getParameter("price")));
        course.setNote(request.getParameter("note"));
        course.setRemark(request.getParameter("remark"));
        course.setSuitable(request.getParameter("suitable"));
        course.setDescription(request.getParameter("description"));
        course.setID(Integer.parseInt(request.getParameter("ID")));

        System.out.println(course.getName());
        CourseDao excelCourseDao = null;
        try {
            excelCourseDao = new ExcelCourseDao();
            excelCourseDao.updateCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("CourseHome");
    }
}
