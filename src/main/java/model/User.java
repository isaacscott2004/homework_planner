package model;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public User(){
        this.username = null;
        this.password = null;
        this.email = null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail(){ return email;}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) { this.password = password; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User userData)) {
            return false;
        }
        return Objects.equals(username, userData.username) && Objects.equals(password, userData.password) && Objects.equals(email, userData.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
