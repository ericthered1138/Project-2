package com.shield.tests.dao;

import com.shield.entities.Claim;
import com.shield.daos.claim.ClaimDAOImp;
import com.shield.daos.claim.ClaimDAO;
import org.testng.Assert;
import com.shield.util.DatabaseTableCreator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClaimDAOTests {

    ClaimDAO claimDAO = new ClaimDAOImp();

    @BeforeClass
    void setup(){
        DatabaseTableCreator.table_depopulator();
        DatabaseTableCreator.table_populator();
    }

    @AfterClass
    void tearDown(){ DatabaseTableCreator.table_depopulator(); }



    @Test
    void selectClaimById(){
        Claim claim = claimDAO.getClaimById(1000001);
        System.out.println(claim);
        System.out.println(claimDAO.maxCreator());
        Assert.assertEquals(claim.getClaimId(), 1000001);
    }

    @Test(priority = 1)
    void createClaimById() {
        Claim testClaim = claimDAO.getClaimById(1000001);
        System.out.println(testClaim);
        Claim newClaim = claimDAO.createClaim(testClaim);
        System.out.println(newClaim);
        Assert.assertEquals(newClaim.getUserId(), 1000001);
    }

    @Test(priority = 2)
    void ApproveClaimById(){
        Claim testClaim = claimDAO.getClaimById(1000001);
        System.out.println(testClaim);
        testClaim.setHandlerComment("Yes");
        Claim approvedClaim = claimDAO.approveClaim(testClaim.getClaimId(), testClaim.getHandlerComment());
        System.out.println(approvedClaim);
        Assert.assertEquals(approvedClaim.getApproval(), "approved");
    }

    @Test(priority = 3)
    void DenyClaimById(){
        Claim testClaim = claimDAO.getClaimById(1000001);
        System.out.println(testClaim);
        testClaim.setHandlerComment("Nope");
        Claim deniedClaim = claimDAO.denyClaim(testClaim.getClaimId(), testClaim.getHandlerComment());
        System.out.println(deniedClaim);
        Assert.assertEquals(deniedClaim.getApproval(), "denied");
    }
}
