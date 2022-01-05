package com.shield.entities;
import java.util.Objects;

public class User {

    private int userId;
    private String username;
    private String passcode;
    private String firstName;
    private String lastName;

    public User(){}

    public User(int userId, String firstName, String lastName, String username, String passcode){
        this.setUserId(userId);
        this.setUsername(username);
        this.setPasscode(passcode);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public String toString(){
        return "User{" +
                "userId=" + getUserId() +
                ", username='" + getUsername() + '\'' +
                ", passcode='" + getPasscode() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPasscode(), user.getPasscode()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getUserId(), getUsername(), getPasscode(), getFirstName(), getLastName());
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
