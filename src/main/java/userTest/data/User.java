package userTest.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "LOGIN", length = 60, unique = true)
    @NotNull
    private String login;

    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "SURNAME")
    @NotNull
    private String surname;

    @Column(name = "TELEPHONE")
    @NotNull
    private String telephone;

    @Column(name = "USER_ROLE")
    private Integer userRole;

    public User() {
    }

    public User(String login, String password, String name, String surname, String telephone, Integer userRole) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.userRole = userRole;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone=" + telephone +
                ", userRole=" + userRole +
                '}';
    }
}
