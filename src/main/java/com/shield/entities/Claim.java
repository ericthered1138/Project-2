package com.shield.entities;

import java.util.Objects;

public class Claim {

    private int claimId;
    private int userId;
    private int employeeId;
    private float amount;
    private String description;
    private String dateOfOccurrence;
    private String locationOfOccurrence;
    private String dateTimeOfCreation;
    private String approval;
    private String handlerComment;

    public Claim(){}

    public Claim(int claimId, int userId, int employeeId, float amount, String description, String dateOfOccurrence, String locationOfOccurrence, String dateTimeOfCreation, String approval, String handlerComment){
        this.claimId = claimId;
        this.userId = userId;
        this.employeeId = employeeId;
        this.amount = amount;
        this.description = description;
        this.dateOfOccurrence = dateOfOccurrence;
        this.locationOfOccurrence = locationOfOccurrence;
        this.dateTimeOfCreation = dateTimeOfCreation;
        this.approval = approval;
        this.handlerComment = handlerComment;
    }

    @Override
    public String toString(){
        return "Claim{" +
                "claimId=" + claimId +
                ", userId=" + userId +
                ", employeeId=" + employeeId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", dateOfOccurrence='" + dateOfOccurrence + '\'' +
                ", locationOfOccurrence='" + locationOfOccurrence + '\'' +
                ", dateTimeOfCreation='" + dateTimeOfCreation + '\'' +
                ", approval='" + approval + '\'' +
                ", handlerComment='" + handlerComment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim  claim = (Claim) o;
        return claimId == claim.claimId && userId == claim.userId && employeeId == claim.employeeId && amount == claim.amount && Objects.equals(description, claim.description) && Objects.equals(dateOfOccurrence, claim.dateOfOccurrence) && Objects.equals(locationOfOccurrence, claim.locationOfOccurrence) && Objects.equals(dateTimeOfCreation, claim.dateTimeOfCreation) && Objects.equals(approval, claim.approval) && Objects.equals(handlerComment, claim.handlerComment);
    }

    @Override
    public int hashCode(){
        return Objects.hash(claimId, userId, employeeId, amount, description, dateOfOccurrence, locationOfOccurrence, dateTimeOfCreation, approval, handlerComment);
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
