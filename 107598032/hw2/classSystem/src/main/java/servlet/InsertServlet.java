package servlet;

import dao.MySQLCourseDaoImplement;
import presenter.InsertPresenter;
import usecase.input.insert.InsertInputImplement;
import usecase.input.insert.InsertInputInterface;
import usecase.insert.InsertUseCaseImplement;
import usecase.insert.InsertUseCaseInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Insert")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        String member = request.getParameter("member");
        String priceTemp = request.getParameter("price");
        int price = 0;
        if(priceTemp.length() > 0)
            price = Integer.parseInt(request.getParameter("price"));
        String notice = request.getParameter("notice");
        String remark = request.getParameter("remark");
        InsertUseCaseInterface insertUseCase = new InsertUseCaseImplement();
        insertUseCase.setRepository(new MySQLCourseDaoImplement());
        InsertInputInterface input = new InsertInputImplement(
                -1,
                name,
                content,
                member,
                price,
                notice,
                remark
        );
        InsertPresenter presenter = new InsertPresenter();
        insertUseCase.execute(input, presenter);
        if(presenter.isSuccess())
            request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp").forward(request, response);
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(presenter.getMessage());
        }
    }
}
