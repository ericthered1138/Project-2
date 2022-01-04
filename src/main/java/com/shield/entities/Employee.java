package com.shield.entities;

import java.util.Objects;

public class Employee {

    private int employeeId;
    private int handlerId;
    private boolean handler;
    private String username;
    private String passcode;
    private String firstName;
    private String lastName;


    public Employee(){}

    public Employee(int employeeId, int handlerId, boolean handler, String username, String passcode, String firstName, String lastName){
        this.employeeId = employeeId;
        this.handlerId = handlerId;
        this.handler = handler;
        this.username = username;
        this.passcode = passcode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Employee{" +
                "employeeId=" + employeeId +
                ", handlerId=" + handlerId +
                ", handler=" + handler +
                ", username='" + username + '\'' +
                ", passcode='" + passcode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && handlerId == employee.handlerId && handler == employee.handler && Objects.equals(username, employee.username) && Objects.equals(passcode, employee.passcode) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) ;
    }

    @Override
    public int hashCode(){
        return Objects.hash(employeeId, handlerId, handler, username, passcode, firstName, lastName);
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(int handlerId) {
        this.handlerId = handlerId;
    }

    public boolean isHandler() {
        return handler;
    }

    public void setHandler(boolean handler) {
        this.handler = handler;
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
