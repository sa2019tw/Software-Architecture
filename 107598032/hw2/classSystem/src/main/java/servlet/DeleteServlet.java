package servlet;

import dao.MySQLCourseDaoImplement;
import usecase.delete.DeleteUseCaseImplement;
import usecase.delete.DeleteUseCaseInterface;
import usecase.input.delete.DeleteInputImplement;
import usecase.input.delete.DeleteInputInterface;
import usecase.input.list.ListInputImplement;
import usecase.input.list.ListInputInterface;
import usecase.list.ListUseCaseImplement;
import usecase.list.ListUseCaseInterface;
import usecase.output.delete.DeleteOutputImplement;
import usecase.output.delete.DeleteOutputInterface;
import usecase.output.list.ListOutputImplement;
import usecase.output.list.ListOutputInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ListUseCaseInterface listUseCase = new ListUseCaseImplement();
        listUseCase.setRepository(new MySQLCourseDaoImplement());
        ListInputInterface input = new ListInputImplement();
        ListOutputInterface output = new ListOutputImplement();
        listUseCase.execute(input, output);
        if(output.isSuccess()) {
            request.setAttribute("courseList", output.getCourses());
            request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String[] deleteCourseId = request.getParameterValues("deleteId");
        if(deleteCourseId != null){
            List<Integer> ids = new ArrayList<>();
            for(String id: deleteCourseId){
                ids.add(Integer.parseInt(id));
            }
            DeleteUseCaseInterface deleteUseCase = new DeleteUseCaseImplement();
            deleteUseCase.setRepository(new MySQLCourseDaoImplement());
            DeleteInputInterface input = new DeleteInputImplement(ids);
            DeleteOutputInterface output = new DeleteOutputImplement();
            deleteUseCase.execute(input, output);
            if(output.isSuccess())
                response.sendRedirect("/Delete");
            else
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
