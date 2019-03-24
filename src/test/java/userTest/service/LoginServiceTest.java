package userTest.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import userTest.dto.UserDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    private static final String log = "Admin";

    private static final String pass = "HASLO";

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
    public void dataLoggedUser() {

        LoginService test = mock(LoginService.class);
        //when
        when(test.loggedUser(log)).thenReturn(USER_DTO);
        //then
        assertThat(test.loggedUser(log)).isEqualTo(USER_DTO);
    }
}