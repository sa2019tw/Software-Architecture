package servlet;

import dao.MySQLCourseDaoImplement;
import presenter.DeletePresenter;
import presenter.ListPresenter;
import usecase.delete.DeleteUseCaseImplement;
import usecase.delete.DeleteUseCaseInterface;
import usecase.input.delete.DeleteInputImplement;
import usecase.input.delete.DeleteInputInterface;
import usecase.input.list.ListInputImplement;
import usecase.list.ListUseCaseImplement;
import usecase.list.ListUseCaseInterface;

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
        ListPresenter presenter = new ListPresenter();
        listUseCase.execute(new ListInputImplement(), presenter);
        if(presenter.isSuccess()) {
            request.setAttribute("courseList", presenter.buildViewModel().getCourses());
            request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(presenter.getMessage());
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
            DeletePresenter presenter = new DeletePresenter();
            deleteUseCase.execute(input, presenter);
            if(presenter.isSuccess())
                response.sendRedirect("/Delete");
            else
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
