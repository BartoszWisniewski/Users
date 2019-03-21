package userTest.servlet.standardUserPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/menu-standard-user")
public class MenuStandardUserServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MenuStandardUserServlet.class);

}
