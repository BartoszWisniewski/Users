package userTest.servlet.adminPanel;

import userTest.dao.UserDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/menu-admin/delete-user")
public class DeleteUserServlet extends HttpServlet {

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteUser = req.getParameter("log");
        userDAO.delete(deleteUser);

        resp.sendRedirect(req.getContextPath() + "/menu-admin/user-list");
    }
}
