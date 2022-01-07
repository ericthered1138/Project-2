package com.shield.tests.dao;

import com.shield.daos.employee.EmployeeDAO;
import com.shield.daos.employee.EmployeeDAOImp;
import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.shield.Util.DatabaseTableCreator.table_depopulator;
import static com.shield.Util.DatabaseTableCreator.table_populator;

public class EmployeeDAOTests {

    EmployeeDAO employeeDAO = new EmployeeDAOImp();

    @BeforeClass
    void setup(){
        table_depopulator();
        table_populator();
    };

    @AfterClass
    void teardown(){
        table_depopulator();
    };

    @Test
    void getEmployeeById() {
        Employee employee = employeeDAO.getEmployeeById(1_000_001);
        System.out.println(employee);
        Assert.assertEquals(employee.getEmployeeId(),1_000_001);
    }

    @Test
    void loginEmployee() {
        //String username, String password
        Employee employee = employeeDAO.getEmployeeById(1_000_001);
        String username = employee.getUsername();
        String password = employee.getPasscode();
        Employee returnedEmployee = employeeDAO.loginEmployee(username, password);
        Assert.assertEquals(returnedEmployee.getEmployeeId(), 1_000_001);
    }

    @Test
    void getAllClaims() {
        Employee employee = employeeDAO.getEmployeeById(1_000_001);
        Integer employeeId = employee.getEmployeeId();
        List<Claim> claimsList = employeeDAO.getAllHandlerClaims(employeeId);
        System.out.println(claimsList);
        Assert.assertTrue(claimsList.size() == 1);
    }


    @Test
    void getUserClaimsByAgent() {
        Employee employee = employeeDAO.getEmployeeById(1_000_002);
        Integer employeeId = employee.getEmployeeId();
        List<Claim> claimsList = employeeDAO.getUserClaimsByAgent(employeeId);
        Assert.assertTrue(claimsList.size() == 1);
    }

    @Test
    void getAllAgentDebriefings() {
        Employee employee = employeeDAO.getEmployeeById(1_000_001);
        Integer employeeId = employee.getEmployeeId();
        List<Debrief> claimsList = employeeDAO.getAllAgentDebriefings(employeeId);
        Assert.assertTrue(claimsList.size() == 1);
    }

    @Test
    void getAgentDebriefings() {
        Employee employee = employeeDAO.getEmployeeById(1_000_002);
        Integer employeeId = employee.getEmployeeId();
        List<Debrief> claimsList = employeeDAO.getAgentDebriefings(employeeId);
        System.out.println(claimsList);
        Assert.assertTrue(claimsList.size() == 1);
    }
}
