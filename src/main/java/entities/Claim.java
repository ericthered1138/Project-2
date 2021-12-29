package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Claim {

    private int claimId;
    private int userId;
    private int employeeId;
    private float amount;
    private String description;
    private LocalDate dateOfOccurrence;
    private String locationOfOccurrence;
    private LocalDateTime dateTimeOfCreation;
    private String approval;
    private String handlerComment;

    public Claim(){}

    public Claim(int claimId, int userId, int employeeId, float amount, String description, LocalDate dateOfOccurrence, String locationOfOccurrence, LocalDateTime dateTimeOfCreation, String approval, String handlerComment){
        this.setClaimId(claimId);
        this.setUserId(userId);
        this.setEmployeeId(employeeId);
        this.setAmount(amount);
        this.setDescription(description);
        this.setDateOfOccurrence(dateOfOccurrence);
        this.setLocationOfOccurrence(locationOfOccurrence);
        this.setDateTimeOfCreation(dateTimeOfCreation);
        this.setApproval(approval);
        this.setHandlerComment(handlerComment);
    }

    @Override
    public String toString(){
        return "Claim{" +
                "claimId=" + getClaimId() +
                ", userId=" + getUserId() +
                ", employeeId=" + getEmployeeId() +
                ", amount=" + getAmount() +
                ", description='" + getDescription() + '\'' +
                ", dateOfOccurrence='" + getDateOfOccurrence() + '\'' +
                ", locationOfOccurrence='" + getLocationOfOccurrence() + '\'' +
                ", dateTimeOfCreation='" + getDateTimeOfCreation() + '\'' +
                ", approval='" + getApproval() + '\'' +
                ", handlerComment='" + getHandlerComment() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim  claim = (Claim) o;
        return getClaimId() == claim.getClaimId() && getUserId() == claim.getUserId() && getEmployeeId() == claim.getEmployeeId() && getAmount() == claim.getAmount() && Objects.equals(getDescription(), claim.getDescription()) && Objects.equals(getDateOfOccurrence(), claim.getDateOfOccurrence()) && Objects.equals(getLocationOfOccurrence(), claim.getLocationOfOccurrence()) && Objects.equals(getDateTimeOfCreation(), claim.getDateTimeOfCreation()) && Objects.equals(getApproval(), claim.getApproval()) && Objects.equals(getHandlerComment(), claim.getHandlerComment());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getClaimId(), getUserId(), getEmployeeId(), getAmount(), getDescription(), getDateOfOccurrence(), getLocationOfOccurrence(), getDateTimeOfCreation(), getApproval(), getHandlerComment());
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfOccurrence() {
        return dateOfOccurrence;
    }

    public void setDateOfOccurrence(LocalDate dateOfOccurrence) {
        this.dateOfOccurrence = dateOfOccurrence;
    }

    public String getLocationOfOccurrence() {
        return locationOfOccurrence;
    }

    public void setLocationOfOccurrence(String locationOfOccurrence) {
        this.locationOfOccurrence = locationOfOccurrence;
    }

    public LocalDateTime getDateTimeOfCreation() {
        return dateTimeOfCreation;
    }

    public void setDateTimeOfCreation(LocalDateTime dateTimeOfCreation) {
        this.dateTimeOfCreation = dateTimeOfCreation;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getHandlerComment() {
        return handlerComment;
    }

    public void setHandlerComment(String handlerComment) {
        this.handlerComment = handlerComment;
    }
}
