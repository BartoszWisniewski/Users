package userTest.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import userTest.dao.UserDAO;
import userTest.data.User;
import userTest.dto.UserDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    private static final User USER = newUser("Admin", "HASLO", "Ala", "OLALA", "123456", 2);


    private static final String log = "Admin";

    private static final String pass = "HASLO";

    private static User newUser(String Login, String Password, String Name, String Surname, String Telephone, Integer UserRole) {
        User u = new User();
        u.setLogin(Login);
        u.setPassword(Password);
        u.setName(Name);
        u.setSurname(Surname);
        u.setTelephone(Telephone);
        u.setUserRole(UserRole);
        return u;
    }

    private static final UserDTO USER_DTO = newUserDTO("Admin", "Ala", "OLALA", "123456", 2);

    private static UserDTO newUserDTO(String login, String name, String surname, String telephone, Integer role) {
        UserDTO u1 = new UserDTO("Admin", "Ala", "OLALA", "123456", 2);
        u1.setLogin(login);
        u1.setName(name);
        u1.setSurname(surname);
        u1.setTelephone(telephone);
        u1.setRole(role);
        return u1;
    }


    /*@Mock
    private UserDAO userDAO;*/

    @InjectMocks
    private LoginService loginService = new LoginService();

    LoginService test = mock(LoginService.class);

    @DisplayName("User can log correctly")
    @Test
    public void userCanLogCorrectly() {

        //when
        when(test.checkIfUserCanLogin(log, pass)).thenReturn(true);
        //then
        assertThat(test.checkIfUserCanLogin(log, pass)).isEqualTo(true);

    }

    @DisplayName("User can't log correctly")
    @Test
    public void userCantLogCorrectly() {

        LoginService test = mock(LoginService.class);
        //when
        when(test.checkIfUserCanLogin(log, pass)).thenReturn(false);
        //then
        assertThat(test.checkIfUserCanLogin(log, pass)).isEqualTo(false);

    }
    

    @Test
    public void loggedUser() {
    /*    //given
        Mockito.when(loginService.loggedUser(log)).thenReturn(USER_DTO);
        Mockito.when(userDAO.findByLog(log)).thenReturn(USER);
        //when
        //then
    //    assertThat(out).isEqualTo(true);
*/
        LoginService test = mock(LoginService.class);
        when(test.loggedUser(log)).thenReturn(USER_DTO);
        assertThat(test.loggedUser(log)).isEqualTo(USER_DTO);
    }
}