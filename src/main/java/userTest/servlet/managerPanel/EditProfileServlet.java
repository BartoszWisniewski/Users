package userTest.servlet.managerPanel;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;
import userTest.data.User;
import userTest.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/menu-manager/edit-profile")
public class EditProfileServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(EditProfileServlet.class);

    private static final String TEMPLATE_NAME = "managerMenu/editProfile";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String log = String.valueOf(session.getAttribute("login"));

        User editUser = userDAO.findByLog(log);

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
        HttpSession session = req.getSession();
        String log = String.valueOf(session.getAttribute("login"));
        final String password = req.getParameter("Password");
        final String name = req.getParameter("Name");
        final String surname = req.getParameter("Surname");
        final String telephone = req.getParameter("Telephone");
        final Integer userRole = Integer.parseInt(req.getParameter("UserRole"));

        User updateUser = new User(log, password, name, surname, telephone, userRole);
       // List findLogin = userDAO.findByLogin(log);

        LOG.info("Update user profile");

        userDAO.save(updateUser);

        resp.sendRedirect(req.getContextPath() + "/menu-manager");




       /* if(findLogin.size() == 0){
            LOG.info("Add new user");
            userDAO.save(updateUser);
            resp.sendRedirect(req.getContextPath() + "/menu-admin/user-list");
        }else {

            userDAO.update(updateUser);

            LOG.info("User updated.");
            resp.sendRedirect(req.getContextPath() + "/menu-admin/user-list");
        }*/
    }
}
