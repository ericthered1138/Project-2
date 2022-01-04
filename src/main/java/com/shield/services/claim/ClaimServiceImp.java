package com.shield.services.claim;

import com.shield.customexceptions.EmployeeNotFound;
import com.shield.customexceptions.NegativeClaimAmount;
import com.shield.customexceptions.UserNotFound;
import com.shield.daos.claim.ClaimDAO;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.daos.user.UserDAO;
import com.shield.entities.Claim;
import com.shield.entities.Employee;
import com.shield.entities.User;

public class ClaimServiceImp implements ClaimService {

    ClaimDAO claimDAO;
    EmployeeDAO employeeDAO;
    UserDAO userDAO;

    public ClaimServiceImp(ClaimDAO claimDAO, EmployeeDAO employeeDAO, UserDAO userDAO) {
        this.claimDAO = claimDAO;
        this.employeeDAO = employeeDAO;
        this.userDAO = userDAO;
    }

    @Override
    public Claim getClaimByIdService(int claimId) {
        return this.claimDAO.getClaimById(claimId);
    }

    @Override
    public Claim createClaimService(Claim claim) {

        Employee employee = employeeDAO.getEmployeeById(claim.getEmployeeId());
        User user = userDAO.getUserById(claim.getUserId());
        try {
            if (user.getUserId() == claim.getUserId()) {
                if (employee.getEmployeeId() == claim.getEmployeeId()) {
                    if (claim.getAmount() > 0) {
                        return this.claimDAO.createClaim(claim);
                    } else{
                        throw new NegativeClaimAmount("Claim must be a positive number");
                    }
                } else {
                    throw new EmployeeNotFound("The employee was not found.");
                }
            } else {
                throw new UserNotFound("User not found");
            }
        }
        catch (UserNotFound e){
            throw new UserNotFound("User not found");
        }
        catch (EmployeeNotFound e){
            throw new EmployeeNotFound("The employee was not found.");
        }
    }

    @Override
    public Claim approveClaimService(int claimId) {
        return this.claimDAO.approveClaim(claimId);
    }

    @Override
    public Claim denyClaimService(int claimId) {
        return this.claimDAO.denyClaim(claimId);
    }
}
