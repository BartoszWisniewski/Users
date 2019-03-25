package userTest.servlet.message;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.MessageDAO;
import userTest.dao.UserDAO;
import userTest.freemarker.TemplateProvider;
import userTest.service.MessageService;

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

@WebServlet(urlPatterns = "/message")
public class MessageListServet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MessageListServet.class);

    private static final String TEMPLATE_NAME = "message/message";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private MessageService messageService;

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        HttpSession session = req.getSession();

        String login = String.valueOf(session.getAttribute("login"));


        Map<String, Object> model = new HashMap<>();
        model.put("messageList", messageService.getMessageForGroup(userDAO.findUserGroup(login)));

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
