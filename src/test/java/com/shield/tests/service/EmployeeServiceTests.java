package com.shield.tests.service;

import com.shield.customexceptions.EmployeeIsNotAgent;
import com.shield.customexceptions.EmployeeIsNotHandler;
import com.shield.customexceptions.EmployeeNotFound;
import com.shield.customexceptions.UserNotFound;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.daos.employee.EmployeeDAOImp;
import org.testng.annotations.Test;
import com.shield.services.employee.EmployeeService;
import com.shield.services.employee.EmployeeServiceImp;


public class EmployeeServiceTests {
    EmployeeDAO employeeDAO = new EmployeeDAOImp();
    EmployeeService employeeService = new EmployeeServiceImp(employeeDAO);

    //Sad Tests

    //employee not found
    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetAllClaims(){
        employeeService.getAllClaimsService(-5);
    }

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetUserClaimsByAgentService(){
        employeeService.getUserClaimsByAgentService(-5);
    }

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetAllAgentDebriefingsService(){
        employeeService.getAllAgentDebriefingsService(-5);
    }

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetAgentDebriefingsService(){
        employeeService.getAgentDebriefingsService(-5);
    }

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdInsertEmployeeImageService(){
        employeeService.getAgentDebriefingsService(-5);
    }

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdGetEmployeeImageService(){
        employeeService.getAgentDebriefingsService(-5);
    }

    //employee is not handler
    @Test(expectedExceptions = EmployeeIsNotHandler.class, expectedExceptionsMessageRegExp = "That employee is not a handler.")
    void badHandlerForGetAllClaims(){
        employeeService.getAllClaimsService(2);
    }

    @Test(expectedExceptions = EmployeeIsNotHandler.class, expectedExceptionsMessageRegExp = "That employee is not a handler.")
    void badHandlerGetAllAgentDebriefingsService(){
        employeeService.getAllAgentDebriefingsService(2);
    }


    //employee is not agent
    @Test(expectedExceptions = EmployeeIsNotAgent.class, expectedExceptionsMessageRegExp = "That employee is not an agent.")
    void badAgentGetUserClaimsByAgentService(){
        employeeService.getUserClaimsByAgentService(3);
    }

    @Test(expectedExceptions = EmployeeIsNotAgent.class, expectedExceptionsMessageRegExp = "That employee is not an agent.")
    void badAgentGetAgentDebriefingsService(){
        employeeService.getAgentDebriefingsService(3);
    }

}
