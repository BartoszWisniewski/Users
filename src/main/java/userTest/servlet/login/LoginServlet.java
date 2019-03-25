package userTest.servlet.login;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.MessageDAO;
import userTest.dao.UserDAO;
import userTest.data.Message;
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
import java.time.LocalDate;
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

    @Inject
    private MessageDAO messageDAO;

    @Override
    public void init() {
        User admin = new User("Admin", "haslo", "Adam", "Kowalski", "123456789", 2);
        User user1 = new User("Master", "qwerty", "Karol", "Nowy", "987987987", 1);
        User user2 = new User("misiaczek", "wsad", "Marta", "Nowińska", "456456456", 0);
        userDAO.save(admin);
        userDAO.save(user1);
        userDAO.save(user2);

        Message msg1 = new Message("Hello", LocalDate.of(2018, 3, 22), "Witaj Manager", "Manager");
        Message msg2 = new Message("Hello", LocalDate.of(2018, 3, 21), "Witaj Standard user", "Standard");
        Message msg3 = new Message("Hello", LocalDate.of(2018, 3, 20), "Witaj Admin", "Admin");
        messageDAO.save(msg1);
        messageDAO.save(msg2);
        messageDAO.save(msg3);

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

        if (loginService.checkIfUserCanLogin(login, password)) {
            session.setAttribute("user", loginService.loggedUser(login));
            session.setAttribute("login", login);
            if (loginService.loggedUser(login).getRole().equals(2)) {
                resp.sendRedirect(req.getContextPath() + "/menu-admin");
            } else if (loginService.loggedUser(login).getRole().equals(1)) {
                resp.sendRedirect(req.getContextPath() + "/menu-manager");
            } else
                resp.sendRedirect(req.getContextPath() + "/menu-standard-user");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }
}
