package userTest.servlet.standardUserPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/menu-standard-user/edit-profile")
public class EditProfileSUServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(EditProfileSUServlet.class);

    private static final String TEMPLATE_NAME = "standardUserMenu/menuStandardUser";

    @Inject
    private TemplateProvider templateProvider;
}
