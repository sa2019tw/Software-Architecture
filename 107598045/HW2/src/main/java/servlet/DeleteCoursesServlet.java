package servlet;

import dao.impl.CourseDaoImpl;
import usecase.delete.DeleteCoursesUseCase;
import usecase.delete.DeleteCoursesUseCaseImplement;
import usecase.delete.input.DeleteInput;
import usecase.delete.input.DeleteInputImplement;
import usecase.delete.output.DeleteOutput;
import usecase.delete.output.DeleteOutputImplement;
import usecase.read.ListAllCoursesUseCase;
import usecase.read.ListAllCoursesUseCaseImplement;
import usecase.read.input.ListAllInput;
import usecase.read.input.ListAllInputImplement;
import usecase.read.output.ListAllOutput;
import usecase.read.output.ListAllOutputImplement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WHM on 2019 / 03 / 01.
 */
@WebServlet("/deleteCourses")
public class DeleteCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        ListAllInput input = new ListAllInputImplement();
        ListAllOutput output = new ListAllOutputImplement();

        ListAllCoursesUseCase listAllCoursesUseCase = new ListAllCoursesUseCaseImplement();  //使用 列出所有課程列表的use case
        listAllCoursesUseCase.setRepository(new CourseDaoImpl());
        listAllCoursesUseCase.execute(input, output);

        if(output.hasErrorOccur()){
            System.out.println(output.getErrorMessage());
        } else {
            request.setAttribute("courseList", output.getCourseList());
            request.getRequestDispatcher("/WEB-INF/jsp/deleteCourses.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String[] deleteCourseId = request.getParameterValues("deleteId");

        DeleteCoursesUseCase deleteUseCase = new DeleteCoursesUseCaseImplement();
        deleteUseCase.setRepository(new CourseDaoImpl());

        DeleteInput input = new DeleteInputImplement(deleteCourseId);
        DeleteOutput output = new DeleteOutputImplement();

        deleteUseCase.execute(input, output);

        if(output.hasErrorOccur()){
            System.out.println(output.getErrorMessage());
        } else {
            response.sendRedirect("listAllCourses"); //使用這個方會跑doGet
        }
    }
}
