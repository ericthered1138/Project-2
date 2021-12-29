package entities;

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
        this.setEmployeeId(employeeId);
        this.setHandlerId(handlerId);
        this.setHandler(handler);
        this.setUsername(username);
        this.setPasscode(passcode);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public String toString(){
        return "Employee{" +
                "employeeId=" + getEmployeeId() +
                ", handlerId=" + getHandlerId() +
                ", handler=" + isHandler() +
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
        Employee employee = (Employee) o;
        return getEmployeeId() == employee.getEmployeeId() && getHandlerId() == employee.getHandlerId() && isHandler() == employee.isHandler() && Objects.equals(getUsername(), employee.getUsername()) && Objects.equals(getPasscode(), employee.getPasscode()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) ;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getEmployeeId(), getHandlerId(), isHandler(), getUsername(), getPasscode(), getFirstName(), getLastName());
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
