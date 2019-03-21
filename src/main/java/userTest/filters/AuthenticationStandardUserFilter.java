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

@WebFilter(urlPatterns = {})
public class AuthenticationStandardUserFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationStandardUserFilter.class);
    private static final Integer STANDARD_USER = 0;

    @Inject
    private UserDAO userDAO;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null || userDAO.findByLog(session.getAttribute("login").toString()).getUserRole().intValue() != STANDARD_USER) {
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
