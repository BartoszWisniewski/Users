package userTest.servlet.login;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;
import userTest.freemarker.TemplateProvider;
import userTest.model.User;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    private static final String TEMPLATE_NAME = "log/login";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        User user = null;

            try {
                 user = userDAO.findByLog(login);
            }catch (NoResultException e){
                LOG.error("No user: " + e);
            }

        if(user==null){
            resp.sendRedirect(req.getContextPath() + "/login");
        }else if(password.equals(user.getPassword())){
            resp.sendRedirect(req.getContextPath() + "/menu-admin");
        }else{
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }
}
