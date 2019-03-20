package userTest.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;
import userTest.freemarker.TemplateProvider;
import userTest.data.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "edit-user")
public class EditUserServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(EditUserServlet.class);

    private static final String TEMPLATE_NAME = "user/editUser";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userLog = req.getParameter("log");

        User editUser = userDAO.findByLog(userLog);

        Map<String, Object> model = new HashMap<>();
        model.put("user", editUser);


        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String login = req.getParameter("Login");
        final String password = req.getParameter("Password");
        final String name = req.getParameter("Name");
        final String surname = req.getParameter("Surname");
        final String telephone = req.getParameter("Telephone");
        final Integer userRole = Integer.parseInt(req.getParameter("UserRole"));

        User updateUser = new User(login, password, name, surname, telephone, userRole);
        List findLogin = userDAO.findByLogin(login);

        if(findLogin.size() == 0){
            LOG.info("Add new user");
            userDAO.save(updateUser);
            resp.sendRedirect(req.getContextPath() + "/user-list");
        }else {

            userDAO.update(updateUser);

            LOG.info("User updated.");
            resp.sendRedirect(req.getContextPath() + "/user-list");
        }

    }
}
