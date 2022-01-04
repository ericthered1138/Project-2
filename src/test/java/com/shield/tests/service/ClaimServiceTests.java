package com.shield.tests.service;

import com.shield.customexceptions.*;
import com.shield.daos.claim.ClaimDAO;
import com.shield.daos.claim.ClaimDAOImp;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.daos.employee.EmployeeDAOImp;
import com.shield.daos.user.UserDAO;
import com.shield.daos.user.UserDAOImp;
import com.shield.entities.Claim;
import com.shield.services.claim.ClaimService;
import com.shield.services.claim.ClaimServiceImp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClaimServiceTests {
    ClaimDAO claimDAO = new ClaimDAOImp();
    EmployeeDAO employeeDAO = new EmployeeDAOImp();
    UserDAO userDAO = new UserDAOImp();

    ClaimService claimService = new ClaimServiceImp(claimDAO, employeeDAO, userDAO);



    @Test(expectedExceptions = ClaimNotFound.class, expectedExceptionsMessageRegExp = "Claim not found")
    void badClaimIdForGetClaimService(){
        int badClaimId = -1;
        claimService.getClaimByIdService(badClaimId);

    }
    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
    void badUserIdForCreateClaimService(){
        Claim badUserIdClaim = new Claim(1, -1, 1, 1000, "test", "2022-1-4", "new york", "2022-1-4", "pending", null);
        badUserIdClaim.setClaimId(-1);
        claimService.createClaimService(badUserIdClaim);
    }

    @Test(expectedExceptions = EmployeeNotFound.class
    , expectedExceptionsMessageRegExp = "The employee was not found.")
    void badEmployeeIdForCreateClaimService(){
        Claim badEmployeeIdClaim = new Claim(1, 1, -1, 1000, "test", "2022-1-4", "new york", "2022-1-4", "pending", null);
        claimService.createClaimService(badEmployeeIdClaim);
    }

    @Test(expectedExceptions = NegativeClaimAmount.class, expectedExceptionsMessageRegExp = "Claim must be a positive number")
    void negativeAmountForCreateClaimService(){
        Claim negativeAmountClaim = new Claim(1, 1, 1, -1000, "test", "2022-1-4", "new york", "2022-1-4", "pending", null);
        claimService.createClaimService(negativeAmountClaim);
    }

    @Test(expectedExceptions = ClaimNotFound.class, expectedExceptionsMessageRegExp = "Claim not found")
    void badClaimIdForApproveClaimService(){
        int badClaimId = -1;
        String handlerComment = "Nice";
        claimService.approveClaimService(badClaimId, handlerComment);
    }

    @Test(expectedExceptions = CommentIsTooManyCharacters.class, expectedExceptionsMessageRegExp = "Comment is too long")
    void commentTooLongForApproveClaimService(){
        int claimId = 1;
        String badHandlerComment = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        claimService.approveClaimService(claimId, badHandlerComment);
    }

    @Test(expectedExceptions = CommentIsTooManyCharacters.class, expectedExceptionsMessageRegExp = "Comment is too long")
    void commentTooLongForDenyClaimService(){
        int claimId = 1;
        String badHandlerComment = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        claimService.approveClaimService(claimId, badHandlerComment);
    }

    @Test(expectedExceptions = ClaimNotFound.class, expectedExceptionsMessageRegExp = "Claim not found")
    void badClaimIdForDenyClaimService(){
        int badClaimId = -1;
        String handlerComment = "Nope";
        claimService.denyClaimService(badClaimId, handlerComment);
    }


}
