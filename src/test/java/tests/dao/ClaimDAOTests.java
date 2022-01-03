package tests.dao;

import customexceptions.ClaimNotFound;
import entities.Claim;
import daos.claim.ClaimDAOImp;
import daos.claim.ClaimDAO;
import org.testng.Assert;
import Util.DatabaseTableCreator;
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
        Claim approvedClaim = claimDAO.approveClaim(testClaim.getClaimId());
        System.out.println(approvedClaim);
        Assert.assertEquals(approvedClaim.getApproval(), "approved");
    }

    @Test(priority = 3)
    void DenyClaimById(){
        Claim testClaim = claimDAO.getClaimById(1000001);
        System.out.println(testClaim);
        Claim deniedClaim = claimDAO.denyClaim(testClaim.getClaimId());
        System.out.println(deniedClaim);
        Assert.assertEquals(deniedClaim.getApproval(), "denied");
    }
}
