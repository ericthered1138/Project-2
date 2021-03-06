package com.shield.tests.service;

import com.shield.customexceptions.ClaimNotFound;
import com.shield.customexceptions.NegativeClaimAmount;
import com.shield.customexceptions.NonNumericClaimAmount;
import com.shield.customexceptions.EmployeeNotFound;
import com.shield.customexceptions.UserNotFound;
import com.shield.daos.user.UserDAO;
import com.shield.daos.claim.ClaimDAO;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.entities.User;
import com.shield.entities.Employee;
import com.shield.entities.Claim;
import com.shield.services.user.UserServices;
import com.shield.services.user.UserServicesImp;
import com.shield.services.employee.EmployeeService;
import com.shield.services.employee.EmployeeServiceImp;
import com.shield.services.claim.ClaimService;
import com.shield.services.claim.ClaimServiceImp;
import io.cucumber.core.backend.Pending;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ClaimServiceMockitoTest {

    public EmployeeDAO employeeDAO;
    public EmployeeService employeeService;
    public UserDAO userDAO;
    public UserServices userServices;
    public ClaimDAO claimDAO;
    public ClaimService claimService;

    @BeforeClass
    public void setup(){
        employeeDAO = Mockito.mock(EmployeeDAO.class);
        claimDAO = Mockito.mock(ClaimDAO.class);
        userDAO = Mockito.mock(UserDAO.class);
        claimService = new ClaimServiceImp(claimDAO, employeeDAO, userDAO);
    }
    @Test
    void getClaimServiceByIdMock(){
        Claim returned_claim = new Claim(1,1,1,50,"my game was destroyed","12052021","TX","","True","Apologies for that, we will send reimbursement, right away.");
        Mockito.when(claimDAO.getClaimById(1)).thenReturn(returned_claim);
        Claim mock_claim = claimService.getClaimByIdService(1);
        Assert.assertEquals(mock_claim.getClaimId(), 1);
    }

    @Test
    //This test is having an error trying to find the Employee ID but returning a null...
    void createClaimServiceMock(){
        User returned_user = new User(1, "david", "zazulak", "david", "david");
        Mockito.when(userDAO.getUserById(1)).thenReturn(returned_user);
        Employee returned_employee = new Employee(1, 1, false, "username", "password", "Joe", "Jenkins");
        Mockito.when(employeeDAO.getEmployeeById(1)).thenReturn(returned_employee);
        Claim created_claim = new Claim(1, 1, 1, 100, "My gamecube was destroyed", "12152021", "WA", "", "Approve", "Apologies for that, we will send reimbursement, right away.");
        Mockito.when(claimDAO.createClaim(created_claim)).thenReturn(created_claim);
        Claim mocked_created_claim = claimService.createClaimService(created_claim);
        Assert.assertEquals(mocked_created_claim.getClaimId(), 1);
    }

    @Test
    void approveClaimServiceMock(){
        Claim approve_claim = new Claim(3,3,3,3,"???","2022-1-14","Miami","2021-12-10 00:00:00.000","approved","???");
        Mockito.when(claimDAO.approveClaim(3, "???")).thenReturn(approve_claim);
        Claim mock_claim = claimService.approveClaimService(3,"???");
        Assert.assertEquals(mock_claim.getApproval(), "approved");
    }

    @Test
    void denyClaimServiceMock(){
        Claim approve_claim = new Claim(3,3,3,3,"???","2022-1-14","Miami","2021-12-10 00:00:00.000","denied","???");
        Mockito.when(claimDAO.approveClaim(3, "???")).thenReturn(approve_claim);
        Claim mock_claim = claimService.approveClaimService(3,"???");
        Assert.assertEquals(mock_claim.getApproval(), "denied");
    }
}
