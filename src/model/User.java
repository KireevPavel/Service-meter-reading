package model;

import java.util.Objects;

public class User {
    int id;
    String login;
    String password;
    boolean loggedIn;
    String status;

    public User(int id, String login, String password, boolean loggedIn, String status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.loggedIn = loggedIn;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && loggedIn == user.loggedIn && login.equals(user.login) && password.equals(user.password) && status.equals(user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, loggedIn, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                ", status='" + status + '\'' +
                '}';
    }
}
