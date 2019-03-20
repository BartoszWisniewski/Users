package userTest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;
import userTest.data.User;
import userTest.dto.UserDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@Stateless
public class LoginService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);

    @Inject
    private UserDAO userDAO;

   /* @Inject
    private UserDTO userDTO;*/

    public boolean checkIfuserCanLogin(String login, String password) {
        User user = null;

        try {
            user = userDAO.findByLog(login);
        } catch (NoResultException e) {
            LOG.error("No user: " + e);
        }

        if (user == null) {
            return false;
        } else if (password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public UserDTO loggedUser(String login) {

        User user = userDAO.findByLog(login);

        return new UserDTO(user.getLogin(), user.getName(), user.getSurname(), user.getTelephone(), user.getUserRole());

    }


}
