package userTest.servlet.standardUserPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/menu-standard-user/user-list")
public class UserListStandardUserServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UserListStandardUserServlet.class);

    private static final String TEMPLATE_NAME = "standardUserMenu/menuStandardUser";

    @Inject
    private TemplateProvider templateProvider;
}
