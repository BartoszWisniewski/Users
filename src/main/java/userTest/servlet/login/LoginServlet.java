package userTest.servlet.login;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;
import userTest.data.User;
import userTest.freemarker.TemplateProvider;
import userTest.service.LoginService;

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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    private static final String TEMPLATE_NAME = "log/login";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private LoginService loginService;

    @Inject
    private UserDAO userDAO;

    @Override
    public void init(){
        User admin = new User("Admin","haslo","Adam","Kowalski","123456789",2);
        User user1 = new User("Master","qwerty","Karol","Nowy","987987987",1);
        User user2 = new User("misiaczek","wsad","Marta","Nowińska","456456456",0);
        userDAO.save(admin);
        userDAO.save(user1);
        userDAO.save(user2);
    }

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
        HttpSession session = req.getSession();

        if (loginService.checkIfuserCanLogin(login, password)) {
            session.setAttribute("user", loginService.loggedUser(login));
            session.setAttribute("login",login);
            if(loginService.loggedUser(login).getRole().equals(2)){
                resp.sendRedirect(req.getContextPath() + "/menu-admin");
            }else if(loginService.loggedUser(login).getRole().equals(1)){
                resp.sendRedirect(req.getContextPath() + "/menu-menager");
            }else
                resp.sendRedirect(req.getContextPath() + "/menu-user");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }
}
