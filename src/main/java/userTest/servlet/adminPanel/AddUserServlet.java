package userTest.servlet.adminPanel;

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
import java.util.Map;

@WebServlet(urlPatterns = "/menu-admin/add-user")
public class AddUserServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(AddUserServlet.class);

    private static final String TEMPLATE_NAME = "adminMenu/addUser";
    private static final String TEMPLATE_NAME_EXIST = "adminMenu/addUserExist";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserDAO userDAO;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        Map<String, Object> model = new HashMap<>();

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

        User newUser = new User(login, password, name, surname, telephone, userRole);
        User findLogin = userDAO.findByLog(login);

        if(findLogin == null){
            LOG.info("Add new user");
            userDAO.save(newUser);
            doGet(req,resp);
        }else {

            Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME_EXIST);

            Map<String, Object> model = new HashMap<>();

            LOG.info("User exist, add new");

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                LOG.error("Error while processing the template: " + e);
            }

        }

    }
}
