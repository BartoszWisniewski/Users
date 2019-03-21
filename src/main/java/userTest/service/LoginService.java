package userTest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;
import userTest.data.User;
import userTest.dto.UserDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Stateless
public class LoginService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);

    @Inject
    private UserDAO userDAO;

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

    public List<UserDTO> listOfAllusers() {
        List<UserDTO> result = userDAO.findAll().stream().map(o -> {
            String login = o.getLogin();
            String name = o.getName();
            String surname = o.getSurname();
            String telephone = o.getTelephone();
            Integer role = o.getUserRole();
            return new UserDTO(login, name, surname, telephone, role);
        })
                .collect(toList());
        return result;
    }


}
