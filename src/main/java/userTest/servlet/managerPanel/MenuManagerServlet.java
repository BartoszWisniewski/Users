package userTest.servlet.managerPanel;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@WebServlet(urlPatterns = "/menu-manager")
public class MenuManagerServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MenuManagerServlet.class);

    private static final String TEMPLATE_NAME = "managerMenu/menuManager";

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Map<String, Object> model = new HashMap<>();

        model.put("session", session.getAttribute("user"));

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }
}
