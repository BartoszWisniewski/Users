package userTest.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/menu-manager", "/menu-manager/edit-profile", "/menu-manager/user-list"}
)
public class AuthenticationManagerFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationManagerFilter.class);
    private static final Integer MANAGER = 1;

    @Inject
    private UserDAO userDAO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null || userDAO.findByLog(session.getAttribute("login").toString()).getUserRole().intValue() != MANAGER) {
            LOG.warn("Not authorized try get acces to Manager function");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/login");
            requestDispatcher.forward(servletRequest, servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
