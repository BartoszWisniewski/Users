package userTest.servlet.menagerPanel;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;
import userTest.freemarker.TemplateProvider;
import userTest.service.LoginService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/menu-menager/user-list")
public class UserListMenagerServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UserListMenagerServlet.class);

    private static final String TEMPLATE_NAME = "menagerMenu/userListMenager";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private LoginService loginService;

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        Map<String, Object> model = new HashMap<>();
        model.put("usersList", loginService.listOfAllusers());

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e.getMessage());
            e.printStackTrace();
        }


    }

}
