package userTest.dto;

public class UserDTO {
    private String login;
    private String name;
    private String surname;
    private String telephone;
    private Integer role;

    public UserDTO(String login, String name, String surname, String telephone, Integer role) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
