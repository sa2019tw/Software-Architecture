package servlet;

import dao.MySQLCourseDaoImplement;
import presenter.EditPresenter;
import presenter.ListPresenter;
import usecase.edit.EditUseCaseImplement;
import usecase.edit.EditUseCaseInterface;
import usecase.input.edit.EditInputImplement;
import usecase.input.edit.EditInputInterface;
import usecase.input.list.ListInputImplement;
import usecase.list.ListUseCaseImplement;
import usecase.list.ListUseCaseInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListUseCaseInterface listUseCase = new ListUseCaseImplement();
        listUseCase.setRepository(new MySQLCourseDaoImplement());
        ListPresenter presenter = new ListPresenter();
        listUseCase.execute(new ListInputImplement(), presenter);
        if(presenter.isSuccess()) {
            request.setAttribute("courseList", presenter.buildViewModel().getCourses());
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(presenter.getMessage());
        }
        if(request.getParameter("selectCourse") != null){
            int selectId = Integer.parseInt(request.getParameter("selectCourse"));
            request.setAttribute("selectCourse", presenter.getCourseById(selectId));
            request.setAttribute("id", selectId);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        String member = request.getParameter("member");
        String priceTemp = request.getParameter("price");
        int price = 0;
        if(priceTemp.length() > 0)
            price = Integer.parseInt(request.getParameter("price"));
        String notice = request.getParameter("notice");
        String remark = request.getParameter("remark");
        EditUseCaseInterface editUseCase = new EditUseCaseImplement();
        editUseCase.setRepository(new MySQLCourseDaoImplement());
        EditInputInterface input = new EditInputImplement(
                id,
                name,
                content,
                member,
                price,
                notice,
                remark
        );
        EditPresenter presenter = new EditPresenter();
        editUseCase.execute(input, presenter);
        if(presenter.isSuccess())
            response.sendRedirect("/Edit");
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
