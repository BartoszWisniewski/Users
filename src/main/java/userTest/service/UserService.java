package userTest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.UserDAO;
import userTest.dto.UserDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Stateless
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Inject
    private UserDAO userDAO;

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
