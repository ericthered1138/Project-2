package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Debrief {

    private int debriefingId;
    private int employeeId;
    private String debriefingText;
    private String dateOfOccurrence;
    private String locationOfOccurrence;
    private String dateTimeOfCreation;

    public Debrief(){}

    public Debrief(int debriefingId, int employeeId, String debriefingText, String dateOfOccurrence, String locationOfOccurrence, String dateTimeOfCreation){
        this.setDebriefingId(debriefingId);
        this.setEmployeeId(employeeId);
        this.setDebriefingText(debriefingText);
        this.setDateOfOccurrence(dateOfOccurrence);
        this.setLocationOfOccurrence(locationOfOccurrence);
        this.setDateTimeOfCreation(dateTimeOfCreation);
    }

    @Override
    public String toString(){
        return "Debrief{" +
                "debriefingId=" + getDebriefingId() +
                ", employeeId=" + getEmployeeId() +
                ", debriefingText='" + getDebriefingText() + '\'' +
                ", dateOfOccurrence='" + getDateOfOccurrence() + '\'' +
                ", locationOfOccurrence='" + getLocationOfOccurrence() + '\'' +
                ", dateTimeOfCreation='" + getDateTimeOfCreation() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debrief debrief = (Debrief) o;
        return getDebriefingId() == debrief.getDebriefingId() && getEmployeeId() == debrief.getEmployeeId() && Objects.equals(getDebriefingText(), debrief.getDebriefingText()) && Objects.equals(getDateOfOccurrence(), debrief.getDateOfOccurrence()) && Objects.equals(getLocationOfOccurrence(), debrief.getLocationOfOccurrence()) && Objects.equals(getDateTimeOfCreation(), debrief.getDateTimeOfCreation());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getDebriefingId(), getEmployeeId(), getDebriefingText(), getDateOfOccurrence(), getLocationOfOccurrence(), getDateTimeOfCreation());
    }

    public int getDebriefingId() {
        return debriefingId;
    }

    public void setDebriefingId(int debriefingId) {
        this.debriefingId = debriefingId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDebriefingText() {
        return debriefingText;
    }

    public void setDebriefingText(String debriefingText) {
        this.debriefingText = debriefingText;
    }

    public String getDateOfOccurrence() {
        return dateOfOccurrence;
    }

    public void setDateOfOccurrence(String dateOfOccurrence) {
        this.dateOfOccurrence = dateOfOccurrence;
    }

    public String getLocationOfOccurrence() {
        return locationOfOccurrence;
    }

    public void setLocationOfOccurrence(String locationOfOccurrence) {
        this.locationOfOccurrence = locationOfOccurrence;
    }

    public String getDateTimeOfCreation() {
        return dateTimeOfCreation;
    }

    public void setDateTimeOfCreation(String dateTimeOfCreation) {
        this.dateTimeOfCreation = dateTimeOfCreation;
    }
}
