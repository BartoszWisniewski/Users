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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/menu-admin")
public class MenuAdminServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MenuAdminServlet.class);

    private static final String TEMPLATE_NAME = "adminMenu/menuAdmin";

    @Inject
    private TemplateProvider templateProvider;

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

        HttpSession session = req.getSession();

        Map<String, Object> model = new HashMap<>();
        model.put("member1", "Bartosz Wiśniewski");

        model.put("session", session.getAttribute("user"));

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

    }
}
